/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dto;

/**
 *
 * @author davidscorp
 */
public class UsuarioDTO {
    
    private Integer usuariosId;
    private Integer usuariosEstado;
    private Integer usuariosTipo;
    private String usuariosPass;

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }

    public Integer getUsuariosEstado() {
        return usuariosEstado;
    }

    public void setUsuariosEstado(Integer usuariosEstado) {
        this.usuariosEstado = usuariosEstado;
    }

    public Integer getUsuariosTipo() {
        return usuariosTipo;
    }

    public void setUsuariosTipo(Integer usuariosTipo) {
        this.usuariosTipo = usuariosTipo;
    }

    public String getUsuariosPass() {
        return usuariosPass;
    }

    public void setUsuariosPass(String usuariosPass) {
        this.usuariosPass = usuariosPass;
    }
    
}
