(function () {
    
    'use strict';

    angular.module('Ltc.controllers').controller('homeUserCtrl', homeUser);

    homeUser.$inject = ['$scope', '$http', '$routeParams'];

    function homeUser($scope, $http, $routeParams) {
        
        if ($routeParams.param1) {

            var numSol = $routeParams.param1;

            $scope.consultarDatosSol(numSol);

        } else {

            return;

        }
        $scope.logout = logout;
        
        function logout (){
            window.open("index.html", "_self");
        }
        
    }
    
})();
