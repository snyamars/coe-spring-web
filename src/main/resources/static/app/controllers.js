(function(angular) {
  var AppController = function($scope, Promotion) {
    Promotion.query(function(response) {
      $scope.promotions = response ? response : [];
      console.log("abc")
      console.log($scope.promotions)
      console.log(response)
    });
    
    $scope.addPromotion = function(description,promotionStartDate, promotionEndDate ) {
      new Promotion({
        description: description,
        promotionStartDate: promotionStartDate,
        promotionEndDate : promotionEndDate ,
        checked: false
      }).save(function(promotion) {
    	  console.log("promotion");
    	  console.log(promotion);
        $scope.promotions.push(promotion);
      });
      $scope.newPromotion = "";
    };
    
    $scope.updatePromotion = function(promotion) {
      promotion.save();
    };
    
    $scope.deletePromotion = function(promotion) {
      promotion.remove(function() {
        $scope.promotions.splice($scope.promotions.indexOf(promotion), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Promotion'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));
