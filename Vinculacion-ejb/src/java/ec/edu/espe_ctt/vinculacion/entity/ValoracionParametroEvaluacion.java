/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVALORPAR")
@XmlRootElement
public class ValoracionParametroEvaluacion implements Serializable, Comparable<ValoracionParametroEvaluacion> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVALORPAR", sequenceName = "SEQ_SZDTAVALORPAR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVALORPAR")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVALORPAR_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPARAEVA_CODE", referencedColumnName = "SZTVPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParametroEvaluacion parametroEvaluacion;

    @Size(max = 500)
    @Column(name = "SZTVALORPAR_DESCRIP")
    private String descripcion;

    @Column(name = "SZTVALORPAR_ORDEN")
    private Integer orden;

    @Column(name = "SZTVALORPAR_PUNTAJE")
    private Integer puntaje;

    public ValoracionParametroEvaluacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParametroEvaluacion getParametroEvaluacion() {
        return parametroEvaluacion;
    }

    public void setParametroEvaluacion(ParametroEvaluacion parametroEvaluacion) {
        this.parametroEvaluacion = parametroEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionParametroEvaluacion)) {
            return false;
        }
        ValoracionParametroEvaluacion other = (ValoracionParametroEvaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ValoracionParametroEvaluacion o) {
        return this.orden.compareTo(o.getOrden());
    }

    public void cambiarOrden(Integer cambio) {
        Integer temp = this.orden;
        if (cambio.equals(-1)) {
            parametroEvaluacion.getValoracionList().get(temp - 2).setOrden(temp);
            setOrden(temp - 1);
        } else {
            parametroEvaluacion.getValoracionList().get(temp).setOrden(temp);
            setOrden(temp + 1);
        }
    }
    
}
