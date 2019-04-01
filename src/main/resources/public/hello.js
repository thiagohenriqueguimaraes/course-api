angular.module('demo', [])
    .controller('Hello', function($scope, $http) {
        //$http.get('http://rest-service.guides.spring.io/greeting').
        $http.get('http://blog-web-api.azurewebsites.net/topics/js').
        then(function(response) {
            $scope.topic = response.data;
        });
    });