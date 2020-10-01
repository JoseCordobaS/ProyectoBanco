/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.banco.logic;

import edu.uptc.banco.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author samav
 */
public class ClienteDAO extends Conexion{
    
    //METODO QUE AGREGA UN Cliente A TRAVES DEL PROCEDIMIENTO ALMACENADO proc_add_cliente creado anteriormente
    public boolean crearCliente(Cliente cliente){
        PreparedStatement statement = null;
        boolean flag = false;
        
        try {
            String sql = "call proc_add_cliente(?, ?, ?, ?, ?)";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, cliente.getDocumentoCliente());
            statement.setString(2, cliente.getNombresCliente());
            statement.setString(3, cliente.getApellidosCliente());
            statement.setString(4, cliente.getCorreoCliente());
            statement.setString(5, cliente.getFkUsuario());
            
            if(statement.executeUpdate() == 1){
                flag = true;
            }
            
        } catch (Exception e) {
        } finally {
            try {
                if(getConnection() != null){
                    getConnection().close();
                }
                
                if(statement != null){
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
        
        return flag;
    }
    
    //Trae todos los clientes con la funcion func_select_cliente creada anteriormente
    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            //String sql = "select * from"
            String sql = "select * from func_select_cliente()";
            statement = getConnection().prepareCall(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                clientes.add(new Cliente(rs.getString("documento_cliente"), rs.getString("nombre_cliente"), rs.getString("apellido_cliente"),
                        rs.getString("correo_cliente"), rs.getString("fk_usuario")));
            }
        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }

                if (statement != null) {
                    statement.close();
                }
                
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        
        return clientes;

    }
    
    //Obtiene el cliente que tenga como documento el mismo del parametro del metodo a traves de la funcion func_select_id_cliente creada anteriormente
    public Cliente getClienteId(String documentoCliente) {
        Cliente cliente = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            //String sql = "select * from"
            String sql = "select * from func_select_id_cliente(?)";
            statement = getConnection().prepareCall(sql);
            statement.setString(1, documentoCliente);
            rs = statement.executeQuery();

            while (rs.next()) {
                cliente = new Cliente(rs.getString("documento_cliente"), rs.getString("nombre_cliente"), rs.getString("apellido_cliente"),
                        rs.getString("correo_cliente"), rs.getString("fk_usuario"));
            }
        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }

        return cliente;

    }
    
}
