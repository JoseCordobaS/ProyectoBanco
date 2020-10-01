/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.banco.model;

/**
 *
 * @author samav
 */
public class Cliente {
    
    private String documentoCliente;
    private String nombresCliente;
    private String apellidosCliente;
    private String correoCliente;
    private String fkUsuario;

    public Cliente(String documentoCliente, String nombresCliente, String apellidosCliente, String correoCliente, String fkUsuario) {
        this.documentoCliente = documentoCliente;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.correoCliente = correoCliente;
        this.fkUsuario = fkUsuario;
    }

    /**
     * @return the documentoCliente
     */
    public String getDocumentoCliente() {
        return documentoCliente;
    }

    /**
     * @param documentoCliente the documentoCliente to set
     */
    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    /**
     * @return the nombresCliente
     */
    public String getNombresCliente() {
        return nombresCliente;
    }

    /**
     * @param nombresCliente the nombresCliente to set
     */
    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    /**
     * @return the apellidosCliente
     */
    public String getApellidosCliente() {
        return apellidosCliente;
    }

    /**
     * @param apellidosCliente the apellidosCliente to set
     */
    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    /**
     * @return the correoCliente
     */
    public String getCorreoCliente() {
        return correoCliente;
    }

    /**
     * @param correoCliente the correoCliente to set
     */
    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    /**
     * @return the fkUsuario
     */
    public String getFkUsuario() {
        return fkUsuario;
    }

    /**
     * @param fkUsuario the fkUsuario to set
     */
    public void setFkUsuario(String fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
    
}
