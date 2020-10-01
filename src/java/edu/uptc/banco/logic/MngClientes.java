/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.banco.logic;

import edu.uptc.banco.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author samav
 */
public class MngClientes {

    private ArrayList<Cliente> clientes;

    public boolean crearCliente(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.crearCliente(cliente);
    }

}
