/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.math.BigDecimal;

/**
 *
 * @author Jhonny
 */
public class CantidadAnual {
   private String descripcion;
   private BigDecimal cantidad;

   
   
   
   public CantidadAnual(){
   }

    public CantidadAnual(String descripcion, BigDecimal cantidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
   
   
   
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
   
   
    
}
