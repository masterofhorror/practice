'use strict';

var module = angular.module('Ltc', [
    'ngRoute',
    'Ltc.controllers'
//    'Ltc.filters',
//    'Ltc.directives',
//    'Ltc.values',
//    'angularUtils.directives.dirPagination'
]);

module.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'loginCtrl'});
        $routeProvider.when('/user/home/:param1', {templateUrl: 'partials/user/user.html', controller: 'homeUserCtrl'});
    
        $routeProvider.otherwise({redirectTo: '/login'});
    }]).directive('capitalize',
        function () {

            return {
                require: 'ngModel',
                link: function (scope, element, attrs, modelCtrl) {
                    var capitalize = function (inputValue) {
                        if (inputValue == undefined)
                            inputValue = '';
                        var capitalized = inputValue.toUpperCase();
                        if (capitalized !== inputValue) {
                            modelCtrl.$setViewValue(capitalized);
                            modelCtrl.$render();
                        }
                        return capitalized;
                    }
                    modelCtrl.$parsers.push(capitalize);
                    capitalize(scope[attrs.ngModel]);
                }
            };
        });
