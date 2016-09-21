angular.module('MyApp', ['ngRoute','ngResource']).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider
			.when('/', {
				templateUrl : 'Partials/readonlypromotions.html',
				controller : 'PromotionListCtrl'
			}).otherwise({
				redirectTo	: '/',
                
			})
			;
		  } 
		]);
    
    console.log("main");

