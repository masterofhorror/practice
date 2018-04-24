(function () {
    'use strict';

    angular.module('Ltc.controllers').controller('loginCtrl', login);

    login.$inject = ['$scope', '$http'];

    function login($scope, $http) {
        // ** -- Variables
        $scope.datosFormulario = {};



        $scope.validaUsuario = validaUsuario;
        $scope.login = login;

        function login() {
            if (!$scope.datosFormulario.usuario) {
                alert("El usuario es obligatorio");
            }
            $http.get('./webresources/').
                    success(function (data, status, headers, config) {
                        if (data.codmensaje === "OK") {
                            $scope.resultados = data.object;
                        } else {
                            if (data.codmensaje === "ERROR") {
                                alert(data.mensaje);
                            }

                        }

                    }).error(function (data, status, headers, config) {
                //alert(status);
                if (data === null) {
                    alert('Debe ingresar un número de placa.');
                }
                alert('Error al consultar la información, por favor intente más tarde.');
            });
        }

        function validaUsuario() {

        }

    }

})();
