/**
 * value - expresionRegular.
 * 
 * @author Hmoreno
 * @version 1.0.0
 */
(function() {
	'use strict';

	angular.module('GestionRNA.values').value('expresionRegular', {
		formatoAlfanumerico : function() {
			return /^[0-9a-zA-Z]+$/;
		},
		formatoAlfanumericoSimbolo : function() {
			return /^[0-9a-zA-ZñÑáéíóúÁÉÍÓÚ\s\'\*\.\,\!\¡\¿\?\#\°_-]+$/;
		},
		formatoAlfanumericoEspacios : function() {
			return /^[0-9a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/;
		},
		formatoNumerico : function() {
			return /^[0-9]+$/;
		}
	});

})();