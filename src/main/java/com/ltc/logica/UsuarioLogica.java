/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.logica;

import com.ltc.comun.Mensajes;
import com.ltc.dao.UsuarioDAO;
import com.ltc.dao.utils.TransformacionDozer;
import com.ltc.dto.InfoUsuarioDTO;
import com.ltc.dto.MensajeDTO;
import com.ltc.entitis.InfoUsuarios;
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
     * Metodo que se encarga de insertar un usuario
     * @param infoUsuarioDTO
     * @return 
     */
    public MensajeDTO registerUser(InfoUsuarioDTO infoUsuarioDTO){
        MensajeDTO salida = new MensajeDTO();
        
        return salida;
    }
    
    /**
     * Metodo que valida si el usuario existe
     * @return 
     */
    public String validaUsuario (){
        String mensaje = null;
        
        return mensaje;
    }

    /**
     *
     * @param infoUsuarioDTO
     * @return
     */
    public MensajeDTO login(InfoUsuarioDTO infoUsuarioDTO) {
        MensajeDTO salida = new MensajeDTO();
        //Se valida que el nombre de usuario exista en la base de datos
        Integer validaUsername = usuarioDAO.validaUsername(infoUsuarioDTO.getInfoUsuariosUsername());
        if (validaUsername == 0) {
            salida.setCodmensaje(Mensajes.ESTADOS_MESAJE.ERROR.name());
            salida.setMensaje("El nombre de usuario no se encuentra registrado");
            return salida;
        }
        InfoUsuarios consultaUsuario = usuarioDAO.consultaUsuario(infoUsuarioDTO.getInfoUsuariosUsername(), infoUsuarioDTO.getInfoUsuariosPass());
        if (consultaUsuario == null) {
            salida.setCodmensaje(Mensajes.ESTADOS_MESAJE.ERROR.name());
            salida.setMensaje("Error en el nombre de usuario o contraseña, por favor valide y vuelva a intentar");
            return salida;
        } else {
            if (consultaUsuario.getUsuarios().getUsuariosEstado() != 1) {
                salida.setCodmensaje(Mensajes.ESTADOS_MESAJE.ERROR.name());
                salida.setMensaje("El estado del usuario es INACTIVO");
                return salida;
            } else {
                if (consultaUsuario.getUsuarios().getUsuariosTipo() == 1) {
                    InfoUsuarioDTO usuario = TransformacionDozer.transformar(consultaUsuario, InfoUsuarioDTO.class);
                    salida.setCodmensaje(Mensajes.ESTADOS_MESAJE.USER.name());
                    salida.setObject(usuario);
                    return salida;
                } else if (consultaUsuario.getUsuarios().getUsuariosTipo() == 2) {
                    InfoUsuarioDTO usuario = TransformacionDozer.transformar(consultaUsuario, InfoUsuarioDTO.class);
                    salida.setCodmensaje(Mensajes.ESTADOS_MESAJE.ADMIN.name());
                    salida.setObject(usuario);
                    return salida;
                }
            }
        }
        return salida;
    }

}
