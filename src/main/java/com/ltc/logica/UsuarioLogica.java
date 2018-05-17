/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.logica;

import com.ltc.casteador.UsuariosCast;
import com.ltc.comun.Mensajes;
import com.ltc.dao.InfoUsuarioDAO;
import com.ltc.dao.UsuarioDAO;
import com.ltc.utils.TransformacionDozer;
import com.ltc.dto.InfoUsuarioDTO;
import com.ltc.dto.MensajeDTO;
import com.ltc.entitis.InfoUsuarios;
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

    @EJB
    private UsuariosCast usuariosCast;

    @EJB
    private InfoUsuarioDAO infoUsuarioDAO;

    /**
     * Metodo que se encarga de insertar un usuario
     *
     * @param infoUsuarioDTO
     * @return
     */
    public MensajeDTO registerUser(InfoUsuarioDTO infoUsuarioDTO) {
        MensajeDTO salida = new MensajeDTO();
        Integer idReferido;
        String validaUsername = validaUserName(infoUsuarioDTO.getInfoUsuariosUsername());
        if (validaUsername != null) {
            salida.setCodmensaje(Mensajes.ERROR);
            salida.setMensaje(validaUsername);
            return salida;
        }
        Usuarios castUsuario = usuariosCast.usuarioCast();
        boolean registroUsuario = usuarioDAO.create(castUsuario);
        if (registroUsuario) {
            if (infoUsuarioDTO.getUserNameReferido() != null) {
                idReferido = idReferido(infoUsuarioDTO.getUserNameReferido());
            } else {
                idReferido = 0;
            }
            InfoUsuarios castInfoUsuario = usuariosCast.infoUsuarioCast(castUsuario, infoUsuarioDTO, idReferido);
            boolean registroInfoUsuario = infoUsuarioDAO.create(castInfoUsuario);
            if (registroInfoUsuario) {
                salida.setCodmensaje(Mensajes.OK);
                salida.setMensaje("Se creo de forma exitosa el usuario");
                return salida;
            } else {
                salida.setCodmensaje(Mensajes.ERROR);
                salida.setMensaje("Error al registrar el usuario");
                return salida;
            }
        } else {
            salida.setCodmensaje(Mensajes.ERROR);
            salida.setMensaje("Error al registrar el usuario");
            return salida;
        }
    }

    /**
     * Metodo que consulta el id del usuario referido
     *
     * @param userNameReferedido
     * @return
     */
    public Integer idReferido(final String userNameReferedido) {
        Integer idUsuario = 0;
        InfoUsuarios consultaReferido = infoUsuarioDAO.consultaUsuario(userNameReferedido);
        if (consultaReferido != null) {
            idUsuario = consultaReferido.getUsuarios().getUsuariosId();
            return idUsuario;
        } else {
            return idUsuario;
        }
    }

    /**
     *
     * @param userName
     * @return
     */
    public String validaUserName(final String userName) {
        String mensaje = null;
        Integer validaUsername = infoUsuarioDAO.validaUsername(userName);
        if (validaUsername != 0) {
            mensaje = "El nombre de usuario ya existe";
        }
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
        Integer validaUsername = infoUsuarioDAO.validaUsername(infoUsuarioDTO.getInfoUsuariosUsername());
        if (validaUsername == 0) {
            salida.setCodmensaje(Mensajes.ERROR);
            salida.setMensaje("El nombre de usuario no se encuentra registrado");
            return salida;
        }
        InfoUsuarios consultaUsuario = infoUsuarioDAO.login(infoUsuarioDTO.getInfoUsuariosUsername(), infoUsuarioDTO.getInfoUsuariosPass());
        if (consultaUsuario == null) {
            salida.setCodmensaje(Mensajes.ERROR);
            salida.setMensaje("Error en el nombre de usuario o contraseña, por favor valide y vuelva a intentar");
            return salida;
        } else {
            if (consultaUsuario.getUsuarios().getUsuariosEstado() != 1) {
                salida.setCodmensaje(Mensajes.ERROR);
                salida.setMensaje("El estado del usuario es INACTIVO");
                return salida;
            } else {
                if (consultaUsuario.getUsuarios().getUsuariosTipo() == 1) {
                    InfoUsuarioDTO usuario = TransformacionDozer.transformar(consultaUsuario, InfoUsuarioDTO.class);
                    salida.setCodmensaje(Mensajes.USER);
                    salida.setObject(usuario);
                    return salida;
                } else if (consultaUsuario.getUsuarios().getUsuariosTipo() == 2) {
                    InfoUsuarioDTO usuario = TransformacionDozer.transformar(consultaUsuario, InfoUsuarioDTO.class);
                    salida.setCodmensaje(Mensajes.ADMIN);
                    salida.setObject(usuario);
                    return salida;
                }
            }
        }
        return salida;
    }

}
