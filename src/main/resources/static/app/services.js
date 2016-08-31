(function(angular) {
  var HATEOAS_URL = '/promotion';
  var PromotionFactory = function($http, SpringDataRestAdapter) {
    function Promotion(promotion) {
      
      if (promotion._resources) {
         promotion.resources = promotion._resources("self", {}, {
          update: {
            method: 'PUT'
          }
        });
        promotion.save = function(callback) {
          promotion.resources.update(promotion, function() {
            callback && callback(promotion);
          });
        };
        
        promotion.remove = function(callback) {
        	console.log("removed")
          promotion.resources.remove(function() {
            callback && callback(promotion);
          });
        };
      } 
      else {
        promotion.save = function(callback) {
        	console.log(Promotion.resources);
        	//console.log(promotion);
            Promotion.resources.save(promotion, function(promotion, headers) {
            //var deferred = $http.get(headers().location);
            
            //return SpringDataRestAdapter.process(deferred).then(function(newPromotion) {
        	// return function(newPromotion) {
              //callback && callback(new Promotion(newPromotion));
            //});
          });
        };
      }

      return promotion;
    }
    
    Promotion.query = function(callback) {
      var deferred = $http.get(HATEOAS_URL);
      return SpringDataRestAdapter.process(deferred).then(function(data) {
        Promotion.resources = data._resources("self");
        callback && callback(_.map(data._embeddedItems, function(promotion) {
          return new Promotion(promotion);
        }));
      });
    };
    
    Promotion.resources = null;
    
    return Promotion;
  };
  
  PromotionFactory.$inject = ['$http', 'SpringDataRestAdapter'];
  angular.module("myApp.services").factory("Promotion", PromotionFactory);
}(angular));