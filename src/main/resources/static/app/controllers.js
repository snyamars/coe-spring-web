
var app = angular.module('MyApp');


app.controller('PromotionListCtrl', ['$scope', '$routeParams','$http' ,'PromotionFactory','sendPromotion', 'PromotionsFactory', '$location',
  function ($scope,$routeParams,$http, PromotionsFactory,sendPromotion, PromotionFactory, $location) {

      //for getting all the values
      PromotionsFactory.query().$promise.then(function(data) 
        {
        $scope.promotions=data;
        });
      
    /* callback for editPromotion */
    $scope.editPromotion = function (promotion) {
        sendPromotion.setProperty(
        {   "id":promotion.id,
            "description":promotion.description,
            "promotionStartDate":promotion.promotionStartDate,
            "promotionEndDate":promotion.promotionEndDate,
            "promotionOwnerName":promotion.promotionOwnerName
        });
      $location.path('/promotionDetail/' + promotion.id);
    };
      

    /* callback for deletePromotion */
    $scope.deletePromotion = function (id) {
       
         $http.delete('/promotion/'+ id ). 
        success(function(data){
        // this callback will be called asynchronously
        // when the response is available
         $scope.promotions=data;
             console.log("success",data);
      }).
      error(function(data) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
             console.log("Error");
      });
      
       PromotionsFactory.query().$promise.then(function(data) 
        {
        $scope.promotions=data;
        });
    }
       
    

    /* callback for createUser */
    $scope.createNewPromotion = function () {
      $location.path('/promotionCreation');
    };

    
      
  }]);




app.controller('PromotionDetailCtrl', ['$scope', '$routeParams','$http' ,'PromotionFactory', '$location',
  function ($scope,$routeParams,$http, PromotionFactory, $location) {

    $scope.editPromotion;
    $http.get("/promotion/" + $routeParams.id).success(function(data)
                {
                   $scope.editPromotion=data;
                 
                }); 
      
    
      
    /* callback for updateUser */
    $scope.updatePromotion = function () { 
        $http.put('/promotion/'+$routeParams.id , JSON.stringify($scope.editPromotion)). 
        success(function(data){
        // this callback will be called asynchronously
        // when the response is available
          $scope.promotions=data;
             console.log("success",data);
      }).
      error(function(data) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
             console.log("error",error);
      });
        
         $location.path('/promotionDetail');
       
    };

    /* callback for  cancel */
    $scope.cancel = function () {
      $location.path('/promotionDetail');
    };
      console.log($routeParams.id);
      
      
  }]);

app.controller('PromotionCreationCtrl', ['$scope', '$routeParams','$http' ,'sendPromotion', 'PromotionsFactory', '$location',
  function ($scope,$routeParams,$http, PromotionsFactory,sendPromotion, $location) {

    /* callback for createNewUser */
    $scope.createNewPromotion = function () {
        console.log($scope.addPromotion);
         $http.post('/promotion/', JSON.stringify($scope.addPromotion)). 
        success(function(data){
        // this callback will be called asynchronously
        // when the response is available
          $scope.promotions=data;
             console.log("success",data);
      }).
      error(function(data) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
             console.log("error");
      });
        alert("Promotion created successfuly")
      $location.path('/promotionDetail');
    }
  }]);



