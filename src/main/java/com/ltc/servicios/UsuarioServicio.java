/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.servicios;

import com.ltc.dto.InfoUsuarioDTO;
import com.ltc.dto.MensajeDTO;
import com.ltc.logica.UsuarioLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author davidscorp
 */
@Path("user")
@Stateless
public class UsuarioServicio {

    @EJB
    private UsuarioLogica usuarioLogica;
    
    /**
     * 
     * @param infoUsuarioDTO
     * @return 
     */
    @POST
    @Path("/validaUser/")
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeDTO validaUsuario(InfoUsuarioDTO infoUsuarioDTO){
        return usuarioLogica.consultaUsuario(infoUsuarioDTO);
    }
}
