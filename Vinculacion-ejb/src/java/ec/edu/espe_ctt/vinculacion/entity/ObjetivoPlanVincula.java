/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
    @Table(name = "SZDTAVOBJ_PLAN_VINVULA")
@XmlRootElement
public class ObjetivoPlanVincula implements Serializable, Comparable<ObjetivoPlanVincula> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SVOPVI_ID")
    private BigDecimal svopviId;
    @Size(max = 50)
    @Column(name = "SVOPVI_DESCRIPCION")
    private String svopviDescripcion;
    @Column(name = "SVOPVI_ORDEN")
    private Integer orden;

    public ObjetivoPlanVincula() {
    }

    public ObjetivoPlanVincula(BigDecimal svopviId) {
        this.svopviId = svopviId;
    }

    public BigDecimal getSvopviId() {
        return svopviId;
    }

    public void setSvopviId(BigDecimal svopviId) {
        this.svopviId = svopviId;
    }

    public String getSvopviDescripcion() {
        return svopviDescripcion;
    }

    public void setSvopviDescripcion(String svopviDescripcion) {
        this.svopviDescripcion = svopviDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svopviId != null ? svopviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoPlanVincula)) {
            return false;
        }
        ObjetivoPlanVincula other = (ObjetivoPlanVincula) object;
        if ((this.svopviId == null && other.svopviId != null) || (this.svopviId != null && !this.svopviId.equals(other.svopviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.ObjetivoPlanVincula[ svopviId=" + svopviId + " ]";
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    public String getOrdenDescripcion(){
        return orden.toString() + ". " + svopviDescripcion;
    }

    @Override
    public int compareTo(ObjetivoPlanVincula o) {
        return this.orden.compareTo(o.getOrden());
    }
    
    
}
