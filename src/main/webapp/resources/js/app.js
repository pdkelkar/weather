(function(){

var app = angular.module('weatherBureau',[]);

app.controller('WeatherController',function($scope, $http){
	$scope.selectedCity = null;
    $scope.cities = [];
    $scope.weather = {};    
    var ready = false;
    var err = false;
    
    $http({
            method: 'GET',
            url: '/weather/cities'
        }).success(function (result) {
        $scope.cities = result;
    });
    
    $scope.getWeather = function(){
    	$scope.dt = new Date();
    	$http({
            method: "POST",
            url: '/weather/today',
            data: $scope.selectedCity
        })
        .then(function(response) {        	
  		  $scope.weather = response.data;
  		  ready=true;
        }, 
        function(response) { // optional
           err=true;
        });//http post end    	
    };//getWeather end
    
    $scope.isReady = function(){
    	return ready;
    };//isReady end
    
    $scope.isError = function(){
    	return err;
    }
});//app controller end


})();//root function end