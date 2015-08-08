(function(){

var app = angular.module('weatherBureau',[]);

app.controller('WeatherController',function($scope, $http){
	$scope.selectedCity = null;
    $scope.cities = [];
    $scope.weather = {};    
    var ready = false;
    
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
                // failed
        });//http post end    	
    };//getWeather end
    
    $scope.isReady = function(){
    	return ready;
    };//isReady end
});//app controller end


})();//root function end