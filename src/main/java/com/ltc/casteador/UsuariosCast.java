/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.casteador;

import com.ltc.dto.InfoUsuarioDTO;
import com.ltc.entitis.InfoUsuarios;
import com.ltc.entitis.Usuarios;
import javax.ejb.Stateless;

/**
 *
 * @author davidscorp
 */
@Stateless
public class UsuariosCast {
    
    /**
     * Metodo que castea la información del usuario
     * @return 
     */
    public Usuarios usuarioCast (){
        Usuarios usuario = new Usuarios();
        usuario.setUsuariosTipo(1);
        usuario.setUsuariosEstado(1);
        return usuario;
    }
    
    /**
     * Metodo que castea la tabla InfoUsuarios
     * @param usuarios
     * @param infoUsuarioDTO
     * @param idReferido
     * @return 
     */
    public InfoUsuarios infoUsuarioCast (Usuarios usuarios, InfoUsuarioDTO infoUsuarioDTO, Integer idReferido){
        InfoUsuarios infoUsuarios = new InfoUsuarios();
        infoUsuarios.setUsuarios(usuarios);
        infoUsuarios.setInfoUsuariosUsername(infoUsuarioDTO.getInfoUsuariosUsername());
        infoUsuarios.setInfoUsuariosNombres(infoUsuarioDTO.getInfoUsuariosNombres());
        infoUsuarios.setInfoUsuariosPass(infoUsuarioDTO.getInfoUsuariosPass());
        infoUsuarios.setInfoUsuariosWallet(infoUsuarioDTO.getInfoUsuariosWallet());
        infoUsuarios.setInfoUsuariosEmail(infoUsuarioDTO.getInfoUsuariosEmail());
        infoUsuarios.setUsuariosIdReferido(idReferido);
        return infoUsuarios;
    }
    
}
