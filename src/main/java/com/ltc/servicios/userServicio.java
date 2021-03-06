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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author dsalamanca
 */
@Path("user")
@Stateless
public class userServicio {

    @Context
    private UriInfo context;
    
    @EJB
    private UsuarioLogica usuarioLogica;

    /**
     * 
     * @param infoUsuarioDTO
     * @return 
     */
    @POST
    @Path("/validaUser")
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeDTO login(InfoUsuarioDTO infoUsuarioDTO){
        return usuarioLogica.login(infoUsuarioDTO);
    }
    
    /**
     * 
     * @param infoUsuarioDTO
     * @return 
     */
    @POST
    @Path("/registerUser")
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeDTO registrerUser(InfoUsuarioDTO infoUsuarioDTO){
        return usuarioLogica.registerUser(infoUsuarioDTO);
    }
}
