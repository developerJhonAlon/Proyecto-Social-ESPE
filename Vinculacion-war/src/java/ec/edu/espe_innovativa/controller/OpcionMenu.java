/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_innovativa.controller;

/**
 *
 * @author PC1
 */
public class OpcionMenu {
    private String codigo;
    private String nombre;
    private boolean expanded;
    
    public OpcionMenu(String codigo, String nombre){
        this.codigo=codigo;
        this.nombre=nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    
    
}
