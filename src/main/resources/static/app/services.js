
var services = angular.module('MyApp');


services.factory('PromotionsFactory', function ($resource) {
    return $resource('/promotion', {}, {
        query: { method: 'GET',  
                transformResponse: function(data) 
                {
                return angular.fromJson(data).events;
                },
                isArray: true
               },
        create: { method: 'POST' }
    })
});

services.factory('PromotionFactory', function ($resource) {
    return $resource('/promotion/:id', {}, {
        show: { method: 'GET', params: {id: '@id'}, isArray: true , transformResponse: function(data) 
                {
                return angular.fromJson(data).events;
                    console.log(data);
                },},
        update: { method: 'PUT', params: {id: '@id', description:'@description'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});

services.factory('sendPromotion', function ()
{
            var property = null;

	        return {
	            getProperty: function () {
	                return property;
	            },
	            setProperty: function(value) {
	                property = value;
	            }
	        }; 
    
    
});
