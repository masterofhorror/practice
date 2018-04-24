(function () {
    'use strict';

    angular.module('Ltc.controllers').controller('loginCtrl', login);

    login.$inject = ['$scope', '$http'];

    function login($scope, $http) {
        // ** --Variables utilitarias
        $scope.datosFormulario = {};
        $scope.errores = {};
        $scope.urlConsulta = './webresources/';
        $scope.datos = {};

        // ** --Variables
        $scope.login = true;
        $scope.registrar = false;

        // ** --Llamado de funciones
        $scope.validaUsername = validaUsername;

        function validaUsername() {
            if (!$scope.datosFormulario.username) {
                alert("El nombre de usuario es obligatorio");
            }
            $scope.datos.infoUsuariosUsername = $scope.datosFormulario.username;
            $http.post($scope.urlConsulta + "user/validaUser", $scope.datos, {})
                    .success(function (data, status, headers, config) {
                        if (data.codmensaje === "OK") {
                            alert("EL usuario existe");
                        } else {
                            if (data.codmensaje === "ERROR") {
                                alert(data.mensaje);
                            }
                        }
                    }).error(function (data, status, headers, config) {
                alert("Error al consultar el vehículo, por favor intentar luego.");
            });
        }


        // ** --Funciones utilitarias
        $scope.verLogin = verLogin;
        $scope.verRegistro = verRegistro;

        function verLogin() {
            $scope.login = true;
            $scope.registrar = false;
        }

        function verRegistro() {
            $scope.login = false;
            $scope.registrar = true;
        }
    }

})();
