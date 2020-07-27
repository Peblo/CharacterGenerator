/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rol.charactergenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tipozico
 */
public class Conexion {
    
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String USER = "APP";
    private static final String PASSWORD = "asd";
    private static final String URL = "jdbc:derby://localhost:1527/CharaDDBB;create=true";
    //?autoReconnect=true&useSSL=false
    
    private Connection CN;
    private static Conexion instance = null;
    
    public Conexion() throws InstantiationException, IllegalAccessException{
        try{
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL,USER,PASSWORD);
            
        }catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al obtener la conexión :"+ ex.getMessage());
            System.exit(0);
        }
    }
    
    public Connection getConnection(){
        return CN;
    }
    
    public static Conexion getInstance() throws InstantiationException, IllegalAccessException{
        if(instance != null){
            return instance;
        }
        else {
            return (instance = new Conexion());
        }
    }
    
    public void close() {
        try{
            CN.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión :"+ ex.getMessage());
        }
    }
}
    
