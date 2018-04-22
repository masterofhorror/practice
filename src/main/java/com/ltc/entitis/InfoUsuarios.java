/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.entitis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davidscorp
 */
@Entity
@Table(name = "info_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoUsuarios.findAll", query = "SELECT i FROM InfoUsuarios i")
    , @NamedQuery(name = "InfoUsuarios.findByInfoUsuariosId", query = "SELECT i FROM InfoUsuarios i WHERE i.infoUsuariosId = :infoUsuariosId")
    , @NamedQuery(name = "InfoUsuarios.findByInfoUsuariosUsername", query = "SELECT i FROM InfoUsuarios i WHERE i.infoUsuariosUsername = :infoUsuariosUsername")
    , @NamedQuery(name = "InfoUsuarios.findByInfoUsuariosNombres", query = "SELECT i FROM InfoUsuarios i WHERE i.infoUsuariosNombres = :infoUsuariosNombres")
    , @NamedQuery(name = "InfoUsuarios.findByInfoUsuariosWallet", query = "SELECT i FROM InfoUsuarios i WHERE i.infoUsuariosWallet = :infoUsuariosWallet")
    , @NamedQuery(name = "InfoUsuarios.findByInfoUsuariosEmail", query = "SELECT i FROM InfoUsuarios i WHERE i.infoUsuariosEmail = :infoUsuariosEmail")
    , @NamedQuery(name = "InfoUsuarios.findByUsuariosIdReferido", query = "SELECT i FROM InfoUsuarios i WHERE i.usuariosIdReferido = :usuariosIdReferido")})
public class InfoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "info_usuarios_id")
    private Integer infoUsuariosId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "info_usuarios_username")
    private Integer infoUsuariosUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "info_usuarios_nombres")
    private String infoUsuariosNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "info_usuarios_wallet")
    private String infoUsuariosWallet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "info_usuarios_email")
    private String infoUsuariosEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarios_id_referido")
    private Integer usuariosIdReferido;
    @JoinColumn(name = "info_usuarios_id_usuario", referencedColumnName = "usuarios_id")
    @ManyToOne(optional = false)
    private Usuarios infoUsuariosIdUsuario;

    public InfoUsuarios() {
    }

    public InfoUsuarios(Integer infoUsuariosId) {
        this.infoUsuariosId = infoUsuariosId;
    }

    public InfoUsuarios(Integer infoUsuariosId, Integer infoUsuariosUsername, String infoUsuariosNombres, String infoUsuariosWallet, String infoUsuariosEmail, Integer usuariosIdReferido) {
        this.infoUsuariosId = infoUsuariosId;
        this.infoUsuariosUsername = infoUsuariosUsername;
        this.infoUsuariosNombres = infoUsuariosNombres;
        this.infoUsuariosWallet = infoUsuariosWallet;
        this.infoUsuariosEmail = infoUsuariosEmail;
        this.usuariosIdReferido = usuariosIdReferido;
    }

    public Integer getInfoUsuariosId() {
        return infoUsuariosId;
    }

    public void setInfoUsuariosId(Integer infoUsuariosId) {
        this.infoUsuariosId = infoUsuariosId;
    }

    public Integer getInfoUsuariosUsername() {
        return infoUsuariosUsername;
    }

    public void setInfoUsuariosUsername(Integer infoUsuariosUsername) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infoUsuariosId != null ? infoUsuariosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoUsuarios)) {
            return false;
        }
        InfoUsuarios other = (InfoUsuarios) object;
        if ((this.infoUsuariosId == null && other.infoUsuariosId != null) || (this.infoUsuariosId != null && !this.infoUsuariosId.equals(other.infoUsuariosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ltc.entitis.InfoUsuarios[ infoUsuariosId=" + infoUsuariosId + " ]";
    }
    
}
