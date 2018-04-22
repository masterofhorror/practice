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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davidscorp
 */
@Stateless
public class UsuarioDAO {

    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getSimpleName());

     @PersistenceContext(unitName = "LtcPU")
    private EntityManager entityManager;
     
    /**
     * Metodo que valida si existe un usuario
     * @param pass
     * @return 
     */
    public Usuarios consultaUsuario(final String pass) {
        try {
            return (Usuarios) entityManager.createNamedQuery("Usuarios.findByUsuariosPass")
                    .setParameter(ConstantesComunes.PASS, pass)
                    .getSingleResult();
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
        }
        return null;
    }
}
