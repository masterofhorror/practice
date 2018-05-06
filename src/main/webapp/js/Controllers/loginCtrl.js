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
                error = true;
            }
            if (!$scope.datosFormulario.password) {
                alert("El password es obligatorio");
                error = true;
            }
            if (!error) {
                $scope.datos.infoUsuariosUsername = $scope.datosFormulario.username;
                $scope.datos.infoUsuariosPass = $scope.datosFormulario.password;
                $http.post($scope.urlConsulta + "user/validaUser", $scope.datos, {})
                        .success(function (data, status, headers, config) {
                            if (data.codmensaje === "USER") {
                                window.open("partials/user/index.html", "_self");
                            } else {
                                if (data.codmensaje === "ERROR") {
                                    alert(data.mensaje);
                                }
                            }
                        }).error(function (data, status, headers, config) {
                    alert("Error al iniciar sesión, por favor intentar luego.");
                });
            }
        }

        function registerUser() {
            var error = false;
            if (!$scope.datosFormulario.username) {
                alert("El nombre de usuario es obligatorio");
                error = true;
            }
            if (!$scope.datosFormulario.password) {
                alert("La contraseña es obligatorio");
            } else {
                if (!$scope.datosFormulario.password2) {
                    alert("Por favor repetir la contraseña");
                    error = true;
                } else {
                    if ($scope.datosFormulario.password !== $scope.datosFormulario.password2) {
                        alert("Los campos de coinciden");
                        error = true;
                    }
                }
            }
            if (!$scope.datosFormulario.nombres) {
                alert("El nombre es obligatorio");
                error = true;
            }
            if (!$scope.datosFormulario.email) {
                alert("La dirección de correo electronico es obligatorio");
                error = true;
            }
            if (!$scope.datosFormulario.wallet) {
                alert("El número de wallet es obligatorio");
                error = true;
            }
            if (!error) {
                $scope.datos.infoUsuariosUsername = $scope.datosFormulario.username;
                $scope.datos.infoUsuariosPass = $scope.datosFormulario.password;
                $scope.datos.infoUsuariosNombres = $scope.datosFormulario.nombres;
                $scope.datos.infoUsuariosWallet = $scope.datosFormulario.wallet;
                $scope.datos.infoUsuariosEmail = $scope.datosFormulario.email;
                $scope.datos.userNameReferido = $scope.datosFormulario.userNameReferido;
                $http.post($scope.urlConsulta + "user/registerUser", $scope.datos, {})
                        .success(function (data, status, headers, config) {
                            if (data.codmensaje === "OK") {
                                alert("EL usuario existe");
                            } else {
                                if (data.codmensaje === "ERROR") {
                                    alert(data.mensaje);
                                }
                            }
                        }).error(function (data, status, headers, config) {
                    alert("Error al iniciar sesión, por favor intentar luego.");
                });
            }
        }


        // ** --Funciones utilitarias
        $scope.verLogin = verLogin;
        $scope.verRegistro = verRegistro;
        $scope.limpiarCampos = limpiarCampos;

        function verLogin() {
            $scope.login = true;
            $scope.registrar = false;
            $scope.limpiarCampos();
        }

        function verRegistro() {
            $scope.login = false;
            $scope.registrar = true;
            $scope.limpiarCampos();
        }

        function limpiarCampos() {
            $scope.datosFormulario.username = '';
            $scope.datosFormulario.password = '';
            $scope.datosFormulario.nombres = '';
            $scope.datosFormulario.wallet = '';
            $scope.datosFormulario.email = '';
            $scope.datosFormulario.userNameReferido = '';
        }
    }

})();
