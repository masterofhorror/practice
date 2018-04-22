    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dto;

/**
 *
 * @author dsalamanca
 */
public class MensajeDTO {

    private String codmensaje;
    private Object object;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodmensaje() {
        return codmensaje;
    }

    public void setCodmensaje(String codmensaje) {
        this.codmensaje = codmensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;

    }

}
