/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.banco.logic;

import java.sql.*;

public class Conexion {
    
    //En todos estos atributos se definen los parametros de conexion 
    private String username = "postgres";
    private String password = "PProgramador1410";
    private String hostname = "localhost";
    private String port = "5432";
    private String database = "ProyProg";
    private String classname = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;
    private Connection conn; 
    
    //Se crea la conexion en la variable conn con la url, nombreusuario y pass
    public Conexion() {
        try {
            Class.forName(classname);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    //retorna la conexion para uso en otra clase
    public Connection getConnection(){
        return conn;
    }    
    
}