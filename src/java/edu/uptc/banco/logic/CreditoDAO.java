/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.banco.logic;

import edu.uptc.banco.model.Credito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author samav
 */
public class CreditoDAO extends Conexion {

    //METODO QUE AGREGA UN CREDITO A TRAVES DEL PROCEDIMIENTO ALMACENADO proc_add_credito creado anteriormente
    public boolean crearUsuario(Credito credito) {
        PreparedStatement statement = null;
        boolean flag = false;

        try {
            String sql = "call proc_add_credito(?,?,?,?,?)";
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, credito.getNumCredito());
            statement.setInt(2, credito.getPlazoCredito());
            statement.setFloat(3, credito.getInteresCredito());
            statement.setInt(4, credito.getValorCredito());
            statement.setString(5, credito.getFkCredito());

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

    //Trae todos los creditos con la funcion func_select_credito creada anteriormente
    public ArrayList<Credito> getCreditos() {
        ArrayList<Credito> creditos = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            //String sql = "select * from"
            String sql = "select * from func_select_credito()";
            statement = getConnection().prepareCall(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                creditos.add(new Credito(rs.getString("num_credito"), rs.getInt("plazo_credito"), rs.getFloat("interes_credito"),
                        rs.getInt("valor_credito"), rs.getString("fk_cliente")));
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

        return creditos;

    }

    //Obtiene el credito que tenga como numero de credito el mismo del parametro del metodo a traves de la funcion func_select_id_credito creada anteriormente
    public Credito getCreditoId(String numCredito) {
        Credito credito = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            //String sql = "select * from"
            String sql = "select * from func_select_id_credito(?)";
            statement = getConnection().prepareCall(sql);
            statement.setString(1, numCredito);
            rs = statement.executeQuery();

            while (rs.next()) {
                credito = new Credito(rs.getString("num_credito"), rs.getInt("plazo_credito"), rs.getFloat("interes_credito"),
                        rs.getInt("valor_credito"), rs.getString("fk_cliente"));
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

        return credito;

    }

}
