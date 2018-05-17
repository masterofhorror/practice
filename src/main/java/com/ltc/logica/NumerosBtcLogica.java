/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.logica;

import com.ltc.comun.Mensajes;
import com.ltc.dao.NumerosBtcDAO;
import com.ltc.dto.MensajeDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author davidscorp
 */
@Stateless
public class NumerosBtcLogica {
    
    @EJB
    private NumerosBtcDAO numerosBtcDAO;
    
    /**
     * 
     * @return 
     */
    public MensajeDTO consultaNumerosBtc (){
        MensajeDTO salida = new MensajeDTO();
        Integer numerosActivos = numerosBtcDAO.countCantidadNumerosActivosBtc();
        if(numerosActivos != 0){
            salida.setCodmensaje(Mensajes.OK);
            salida.setObject(numerosActivos);
            return salida;
        }else{
            salida.setCodmensaje(Mensajes.ERROR);
            salida.setObject(numerosActivos);
            return salida;
        }
    }
    
}
