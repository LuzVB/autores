/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentina
 */
public class ConexionBD {
     
    Connection conexion;

    public ConexionBD() {
    }

    public ConexionBD(Connection conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Metodo que se encarga de ralizar la conexion a la base de datos
     * @throws SQLException 
     */
    public void conectarBaseDatos() throws SQLException {
        String usuario = "postgres";
        String contrasena ="1234";
        String nombreDB = "Docentes4";
        String cadenaConexion = "jdbc:postgresql://localhost:5433/"+nombreDB;

        try {
            Class.forName("org.postgresql.Driver");
            this.conexion = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            System.out.println("La Conexion se realizo correctamente");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion(){
        return this.conexion;
    }
}
