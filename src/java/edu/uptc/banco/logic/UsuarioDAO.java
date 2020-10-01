/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.banco.logic;

import edu.uptc.banco.model.Usuario;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author samav
 */
public class UsuarioDAO extends Conexion {

    //METODO QUE AGREGA UN USUARIO A TRAVES DEL PROCEDIMIENTO ALMACENADO proc_add_usuario creado anteriormente
    public boolean crearUsuario(Usuario usuario) {
        PreparedStatement statement = null;
        boolean flag = false;

        try {
            String sql = "call proc_add_usuario(?,?)";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getContrasena());

            if (statement.executeUpdate() == 1) {
                flag = true;
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
            } catch (Exception e) {
            }
        }

        return flag;
    }

    //Trae todos los usuarios con la funcion func_select_usuario creada anteriormente
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            //String sql = "select * from"
            String sql = "select * from func_select_usuario()";
            statement = getConnection().prepareCall(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                usuarios.add(new Usuario(rs.getString("nombre_usuario"), rs.getString("contrasena")));
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

        return usuarios;

    }

    //Trae el usuario con el nombre de usuario correspondiente a traves de la funcion func_select_id_usuario creada anteriormente
    public Usuario getUsuarioId(String nombreUsuario) {
        Usuario usuario = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            //String sql = "select * from"
            String sql = "select * from func_select_id_usuario(?)";
            statement = getConnection().prepareCall(sql);
            statement.setString(1, nombreUsuario);
            rs = statement.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(rs.getString("nombre_usuario"), rs.getString("contrasena"));
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

        return usuario;

    }

}
