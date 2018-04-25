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
        $scope.startSesion = startSesion;
        $scope.registerUser = registerUser;
        
        function startSesion() {
            var error = false;
            if (!$scope.datosFormulario.username) {
                alert("El nombre de usuario es obligatorio");
            }
            if(!$scope.datosFormulario.password){
                alert("El password es obligatorio");
            }
            if (!error) {
                $scope.datos.infoUsuariosUsername = $scope.datosFormulario.username;
                $scope.datos.infoUsuariosPass = $scope.datosFormulario.password;
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
        }
        
        function registerUser(){
            var error = false;
            if (!$scope.datosFormulario.username) {
                alert("El nombre de usuario es obligatorio");
            }
            if(!$scope.datosFormulario.password){
                alert("La contraseña es obligatorio");
            }else{
                if(!$scope.datosFormulario.password2){
                    alert("Por favor repetir la contraseña");
                }else{
                    if($scope.datosFormulario.password !== $scope.datosFormulario.password2){
                        alert("Los campos de coinciden");
                    }
                }
            }
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
