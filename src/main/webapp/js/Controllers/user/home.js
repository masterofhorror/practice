(function () {
    
    'use strict';

    angular.module('Ltc.controllers').controller('homeUserCtrl', homeUser);

    homeUser.$inject = ['$scope', '$http', '$routeParams'];

    function homeUser($scope, $http, $routeParams) {
        $scope.data = {
            usuario : $routeParams.param1
        };
        
        $scope.logout = logout;
        
        function logout (){
            window.open("index.html", "_self");
        }
        
    }
    
})();
