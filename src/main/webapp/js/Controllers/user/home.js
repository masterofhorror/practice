(function () {
    
    'use strict';

    angular.module('Ltc.controllers').controller('homeUserCtrl', homeUser);

    homeUser.$inject = ['$scope', '$http'];

    function homeUser($scope, $http) {
        
        
        $scope.logout = logout;
        
        function logout (){
            window.open("index.html", "_self");
        }
        
    }
    
})();
