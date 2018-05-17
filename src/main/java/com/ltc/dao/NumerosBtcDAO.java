/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dao;

import com.ltc.dao.utils.GenericDAO;
import com.ltc.entitis.NumerosBtc;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author davidscorp
 */
@Stateless
public class NumerosBtcDAO extends GenericDAO<NumerosBtc>{
    
    private static final Logger LOGGER = Logger.getLogger(NumerosBtcDAO.class.getSimpleName());
    
    public NumerosBtcDAO(){
        super(NumerosBtc.class);
    }
    
    public Integer countCantidadNumerosActivosBtc (){
        try {
            return Integer.parseInt(entityManager.createNamedQuery("NumerosBtc.countNumeros")
                    .getSingleResult().toString());
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
        }
        return 0;
    }
    
}
