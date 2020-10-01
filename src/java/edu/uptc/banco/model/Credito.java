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
public class Credito {
    
    private String numCredito;
    private int plazoCredito;
    private float interesCredito;
    private int valorCredito;
    private String fkCredito;

    public Credito(String numCredito, int plazoCredito, float interesCredito, int valorCredito, String fkCredito) {
        this.numCredito = numCredito;
        this.plazoCredito = plazoCredito;
        this.interesCredito = interesCredito;
        this.valorCredito = valorCredito;
        this.fkCredito = fkCredito;
    }

    /**
     * @return the numCredito
     */
    public String getNumCredito() {
        return numCredito;
    }

    /**
     * @param numCredito the numCredito to set
     */
    public void setNumCredito(String numCredito) {
        this.numCredito = numCredito;
    }

    /**
     * @return the plazoCredito
     */
    public int getPlazoCredito() {
        return plazoCredito;
    }

    /**
     * @param plazoCredito the plazoCredito to set
     */
    public void setPlazoCredito(int plazoCredito) {
        this.plazoCredito = plazoCredito;
    }

    /**
     * @return the interesCredito
     */
    public float getInteresCredito() {
        return interesCredito;
    }

    /**
     * @param interesCredito the interesCredito to set
     */
    public void setInteresCredito(float interesCredito) {
        this.interesCredito = interesCredito;
    }

    /**
     * @return the valorCredito
     */
    public int getValorCredito() {
        return valorCredito;
    }

    /**
     * @param valorCredito the valorCredito to set
     */
    public void setValorCredito(int valorCredito) {
        this.valorCredito = valorCredito;
    }

    /**
     * @return the fkCredito
     */
    public String getFkCredito() {
        return fkCredito;
    }

    /**
     * @param fkCredito the fkCredito to set
     */
    public void setFkCredito(String fkCredito) {
        this.fkCredito = fkCredito;
    }

}
