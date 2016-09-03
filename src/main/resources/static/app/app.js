angular.module('MyApp', ['ngRoute','ngResource']).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider
			.when('/', {
				templateUrl : 'Partials/promotions.html',
				controller : 'PromotionListCtrl'
			})
			.when('/promotionList', {
				templateUrl : 'Partials/promotions.html',
                controller : 'PromotionListCtrl'
				
			}).when('/promotionDetail/:id', {
				templateUrl : 'Partials/promotionDetail.html',
                controller : 'PromotionDetailCtrl'
				
			}).when('/promotionCreation', {
				templateUrl : 'Partials/addPromotion.html',
                controller : 'PromotionCreationCtrl'
			}).otherwise({
				redirectTo	: '/',
                
			})
			;
		  } 
		]);
    
    console.log("main");

