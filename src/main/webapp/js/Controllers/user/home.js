(function () {

    'use strict';

    angular.module('Ltc.controllers').controller('homeUserCtrl', homeUser);

    homeUser.$inject = ['$scope', '$http', '$routeParams'];

    function homeUser($scope, $http, $routeParams) {
        $scope.urlConsulta = './webresources/';

        $scope.countNumerosActivos = countNumerosActivos;
        $scope.countNumerosActivos();

        function countNumerosActivos() {
            $http.get($scope.urlConsulta + "numerosBtc/countActivos").
                    success(function (data, status, headers, config) {
                        if (data.codmensaje === "OK") {
                            $scope.resultados = data.object;
                        } else {
                            if (data.codmensaje === "ERROR") {
                                $scope.resultados = data.object;
                            }
                        }

                    }).error(function (data, status, headers, config) {
                $scope.mostrarMensajeError('Error al consultar la información, por favor intente más tarde.');
            });
        }



        $scope.data = {
            usuario: $routeParams.param1
        };

        $scope.logout = logout;

        function logout() {
            window.open("index.html", "_self");
        }

    }

})();
