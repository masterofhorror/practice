/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.logica;

import com.ltc.comun.Mensajes;
import com.ltc.dao.UsuarioDAO;
import com.ltc.dto.MensajeDTO;
import com.ltc.dto.UsuarioDTO;
import com.ltc.entitis.Usuarios;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author davidscorp
 */
@Stateless
public class UsuarioLogica {
    
    @EJB
    private UsuarioDAO usuarioDAO;
    
    /**
     * 
     * @param usuarioDTO
     * @return 
     */
    public MensajeDTO consultaUsuario (UsuarioDTO usuarioDTO){
        MensajeDTO salida = new MensajeDTO();
        Usuarios consultaUsuario = usuarioDAO.consultaUsuario(usuarioDTO.getUsuariosPass());
        if(consultaUsuario == null){
            salida.setCodmensaje(Mensajes.ESTADOS_MESAJE.ERROR.name());
            salida.setMensaje("El usuario ingresado no se encuentra registrado");
            return salida;
        }
        return salida;
    }
    
}
