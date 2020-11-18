/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service.impl;

import edu.unicundi.dto.ConexionBD;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Valentina
 */
public class DatosImpl implements Serializable{
     Connection conexion;

    public DatosImpl() {
        try {
            ConexionBD conectar = new ConexionBD();
            conectar.conectarBaseDatos();
            this.conexion = conectar.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(DatosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @PostConstruct
    public void init() {

    }
    

    public void modifacionBaseDatos(String cadenaSqlBean,FacesMessage messageBean){
        PreparedStatement prepararSentencia = null;
        try {
            String cadenaSql = cadenaSqlBean;
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
            FacesContext.getCurrentInstance().addMessage(null,messageBean);
        } catch (Exception e) {

        }
    }
    
    public void modifacionBaseDatos(String cadenaSqlBean){
        PreparedStatement prepararSentencia = null;
        try {
            String cadenaSql = cadenaSqlBean;
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
        } catch (Exception e) {

        }
    }

}
