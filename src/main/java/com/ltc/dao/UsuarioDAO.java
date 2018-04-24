/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dao;

import com.ltc.comun.ConstantesComunes;
import com.ltc.dao.utils.GenericDAO;
import com.ltc.entitis.Usuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author davidscorp
 */
@Stateless
public class UsuarioDAO extends GenericDAO<Usuarios>{

    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getSimpleName());

    /**
     *
     */
    public UsuarioDAO() {
        super(Usuarios.class);
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
}
