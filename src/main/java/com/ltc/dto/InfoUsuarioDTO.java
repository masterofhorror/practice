/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dto;

import com.ltc.entitis.Usuarios;

/**
 *
 * @author davidscorp
 */
public class InfoUsuarioDTO {
    
    private Integer infoUsuariosId;
    private String infoUsuariosUsername;
    private String infoUsuariosNombres;
    private String infoUsuariosWallet;
    private String infoUsuariosEmail;
    private Integer usuariosIdReferido;
    private Usuarios infoUsuariosIdUsuario;

    public Integer getInfoUsuariosId() {
        return infoUsuariosId;
    }

    public void setInfoUsuariosId(Integer infoUsuariosId) {
        this.infoUsuariosId = infoUsuariosId;
    }

    public String getInfoUsuariosUsername() {
        return infoUsuariosUsername;
    }

    public void setInfoUsuariosUsername(String infoUsuariosUsername) {
        this.infoUsuariosUsername = infoUsuariosUsername;
    }

    public String getInfoUsuariosNombres() {
        return infoUsuariosNombres;
    }

    public void setInfoUsuariosNombres(String infoUsuariosNombres) {
        this.infoUsuariosNombres = infoUsuariosNombres;
    }

    public String getInfoUsuariosWallet() {
        return infoUsuariosWallet;
    }

    public void setInfoUsuariosWallet(String infoUsuariosWallet) {
        this.infoUsuariosWallet = infoUsuariosWallet;
    }

    public String getInfoUsuariosEmail() {
        return infoUsuariosEmail;
    }

    public void setInfoUsuariosEmail(String infoUsuariosEmail) {
        this.infoUsuariosEmail = infoUsuariosEmail;
    }

    public Integer getUsuariosIdReferido() {
        return usuariosIdReferido;
    }

    public void setUsuariosIdReferido(Integer usuariosIdReferido) {
        this.usuariosIdReferido = usuariosIdReferido;
    }

    public Usuarios getInfoUsuariosIdUsuario() {
        return infoUsuariosIdUsuario;
    }

    public void setInfoUsuariosIdUsuario(Usuarios infoUsuariosIdUsuario) {
        this.infoUsuariosIdUsuario = infoUsuariosIdUsuario;
    }
    
    
}
