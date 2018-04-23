function firmar(texto) {
    try {

        var contenido = texto;
        //verifica que exista CAPICOM
        var testObject = new ActiveXObject("CAPICOM.Signer");
        if (typeof (testObject) != "object") {
            throw new Error("La librería de criptografía de Windows ::CAPICOM:: no se encuentra instalada.");
            ;
        }

        var SignedData = new ActiveXObject("CAPICOM.SignedData");
        var Signer = new ActiveXObject("CAPICOM.Signer");
        var TimeAttribute = new ActiveXObject("CAPICOM.Attribute");

        // datos a firmar
        SignedData.Content = contenido;

        // timestamp
        var Today = new Date();
        TimeAttribute.Name = 0;
        TimeAttribute.Value = Today.getVarDate();
        Signer.AuthenticatedAttributes.Add(TimeAttribute);

        // Crear la firma digital
        return SignedData.Sign(Signer, false, 0);

    } catch (e) {
        var error_number = e.number;

        switch (error_number)
        {
            case -2138570191:
                alert("No existe ningún certificado digital de firma registrado en el almacén de certificados de la máquina. Verifique que el dispositivo de almacenamiento del certificado digital (Token) se encuentra conectado a la máquina y que el certificado digital se encuentra registrado en el almacén de certificados del sistema operativo.");
                break;
            case -2147024809:
                alert("El usuario ha cancelado la digitación del PIN de acceso a la llave privada del certificado y no es posible crear la firma digital.");
                break;
            case -2146893792:
                alert("No es posible acceder a la llave privada del certificado digital seleccionado para el proceso de firma y no es posible crear la firma digital." + " Verifique que el dispositivo de almacenamiento del certificado digital (Token) se encuentra conectado a la máquina.");
                break;
            case -2147023673:
                alert("El usuario ha cancelado la digitación del PIN de acceso a la llave privada del certificado y no es posible crear la firma digital.");
                break;
            case -2147024883:
                alert("El usuario ha digitado de manera incorrecta la clave de acceso a la llave privada del certificado digital hasta bloquear el dispositivo. " + " Es necesario verificar que el dispositivo de almacenamiento del certificado digital ha sido bloqueado. En caso de ser así deberá proceder a revocar el certificado digital. ");
                break;
            case -2138568446:
                alert("El usuario ha cancelado el proceso de selección del certificado digital con el cual desea crear la firma digital. ");
                break;
            case -2146435060:
                alert("El usuario ha seleccionado para la firma un certificado digital que se encuentra registrado en el almacén de certificados de la máquina, cuyo dispositivo de almacenamiento correspondiente no se encuentra conectado a la máquina. " + "Verifique que el dispositivo de almacenamiento del certificado digital (Token) se encuentra conectado a la máquina.");
                break;
            case -2146893802:
                alert("No es posible acceder a la llave privada del certificado digital seleccionado para el proceso de firma y no es posible crear la firma digital." + "Verifique que el dispositivo de almacenamiento del certificado digital (Token) se encuentra conectado a la máquina. ");
                break;
            case -2146827859:
                alert("No se encuentra instalada en la máquina del usuario la DLL Capicom, empleada como proveedor criptográfico por la aplicación. " + "Verifique que se encuentra instalada en su máquina la aplicación Certifirma Digital o que su máquina tiene acceso a Internet al sitio de Microsoft.");
                break;
            case -2146881269:
                alert("Se ha modificado el valor de la firma digital calculada. Se ha alterado la integridad de la firma digital y, por lo tanto, ha perdido validez.");
                break;
            case -2146889724:
                alert("Se ha modificado el valor de la firma digital calculada. Se ha alterado la integridad de la firma digital y, por lo tanto, ha perdido validez.");
                break;
            case -2146881277:
                alert("Se ha modificado el valor de la firma digital calculada. Se ha alterado la integridad de la firma digital y, por lo tanto, ha perdido validez.");
                break;
            case -2146889721:
                alert("Se ha modificado el valor de la firma digital calculada. Se ha alterado la integridad de la firma digital y, por lo tanto, ha perdido validez.");
                break;
            case -2146881278:
                alert("Se ha modificado el valor de la firma digital calculada. Se ha alterado la integridad de la firma digital y, por lo tanto, ha perdido validez.");
                break;
            default:
                alert("Se ha producido una excepción no controlada = " + e.message + ". " + e.number);
        }
        return false;
    }
}