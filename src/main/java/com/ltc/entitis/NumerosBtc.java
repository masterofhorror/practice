/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.entitis;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "numeros_btc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumerosBtc.findAll", query = "SELECT n FROM NumerosBtc n")
    , @NamedQuery(name = "NumerosBtc.findByNumerosbtcId", query = "SELECT n FROM NumerosBtc n WHERE n.numerosbtcId = :numerosbtcId")
    , @NamedQuery(name = "NumerosBtc.findByNumerosbtcNumeros", query = "SELECT n FROM NumerosBtc n WHERE n.numerosbtcNumeros = :numerosbtcNumeros")
    , @NamedQuery(name = "NumerosBtc.findByNumerosbtcEstado", query = "SELECT n FROM NumerosBtc n WHERE n.numerosbtcEstado = :numerosbtcEstado")
    , @NamedQuery(name = "NumerosBtc.countNumeros", query = "SELECT COUNT(n) FROM NumerosBtc n WHERE n.numerosbtcEstado = 'PAGADO'")    
})
public class NumerosBtc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerosbtc_id")
    private BigDecimal numerosbtcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "numerosbtc_numeros")
    private String numerosbtcNumeros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "numerosbtc_estado")
    private String numerosbtcEstado;

    public NumerosBtc() {
    }

    public NumerosBtc(BigDecimal numerosbtcId) {
        this.numerosbtcId = numerosbtcId;
    }

    public NumerosBtc(BigDecimal numerosbtcId, String numerosbtcNumeros, String numerosbtcEstado) {
        this.numerosbtcId = numerosbtcId;
        this.numerosbtcNumeros = numerosbtcNumeros;
        this.numerosbtcEstado = numerosbtcEstado;
    }

    public BigDecimal getNumerosbtcId() {
        return numerosbtcId;
    }

    public void setNumerosbtcId(BigDecimal numerosbtcId) {
        this.numerosbtcId = numerosbtcId;
    }

    public String getNumerosbtcNumeros() {
        return numerosbtcNumeros;
    }

    public void setNumerosbtcNumeros(String numerosbtcNumeros) {
        this.numerosbtcNumeros = numerosbtcNumeros;
    }

    public String getNumerosbtcEstado() {
        return numerosbtcEstado;
    }

    public void setNumerosbtcEstado(String numerosbtcEstado) {
        this.numerosbtcEstado = numerosbtcEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerosbtcId != null ? numerosbtcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumerosBtc)) {
            return false;
        }
        NumerosBtc other = (NumerosBtc) object;
        if ((this.numerosbtcId == null && other.numerosbtcId != null) || (this.numerosbtcId != null && !this.numerosbtcId.equals(other.numerosbtcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ltc.entitis.NumerosBtc[ numerosbtcId=" + numerosbtcId + " ]";
    }
    
}
