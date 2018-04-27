/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dao;

import com.ltc.comun.ConstantesComunes;
import com.ltc.dao.utils.GenericDAO;
import com.ltc.entitis.InfoUsuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author davidscorp
 */
@Stateless
public class InfoUsuarioDAO extends GenericDAO<InfoUsuarios>{
    
    private static final Logger LOGGER = Logger.getLogger(InfoUsuarioDAO.class.getSimpleName());
 
    /**
     *
     */
    public InfoUsuarioDAO() {
        super(InfoUsuarios.class);
    }
    
    /**
     * Metodo que valida si existe el nombre de usuario
     * @param username
     * @return 
     */
    public Integer validaUsername(final String username) {
        try {
            return Integer.parseInt(entityManager.createNamedQuery("InfoUsuarios.countUsername")
                    .setParameter(ConstantesComunes.USERNAME, username)
                    .getSingleResult().toString());
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
        }
        return 0;
    }
    
    /**
     * Metodo que consulta el usuario
     * @param username
     * @param pass
     * @return 
     */
    public InfoUsuarios login (final String username, final String pass){
        try {
            return (InfoUsuarios) entityManager.createNamedQuery("InfoUsuarios.findUserByPassAndUser")
                    .setParameter(ConstantesComunes.USERNAME, username)
                    .setParameter(ConstantesComunes.PASS, pass)
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * Metodo que consulta la información del usuario con el nombre de usuario
     * @param username
     * @return 
     */
    public InfoUsuarios consultaUsuario (final String username){
        try {
            return (InfoUsuarios) entityManager.createNamedQuery("InfoUsuarios.findByInfoUsuariosUsername")
                    .setParameter(ConstantesComunes.USERNAME, username)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }
}
