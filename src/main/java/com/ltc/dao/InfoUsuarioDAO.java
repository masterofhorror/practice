/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dao;

import com.ltc.dao.utils.GenericDAO;
import com.ltc.entitis.InfoUsuarios;
import javax.ejb.Stateless;

/**
 *
 * @author davidscorp
 */
@Stateless
public class InfoUsuarioDAO extends GenericDAO<InfoUsuarios>{
 
    /**
     *
     */
    public InfoUsuarioDAO() {
        super(InfoUsuarios.class);
    }
    
}
