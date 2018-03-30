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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVESTRATEGIAS_V_PLAN")
@XmlRootElement
public class EstrategiaPlanVincula implements Serializable, Comparable<EstrategiaPlanVincula> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SVEVPL_ID")
    private BigDecimal svevplId;
    @Size(max = 50)
    @Column(name = "SVEVPL_DESCRIPCION")
    private String svevplDescripcion;
    @Column(name = "SVEVPL_ORDEN")
    private Integer orden;

    public EstrategiaPlanVincula() {
    }

    public EstrategiaPlanVincula(BigDecimal svevplId) {
        this.svevplId = svevplId;
    }

    public BigDecimal getSvevplId() {
        return svevplId;
    }

    public void setSvevplId(BigDecimal svevplId) {
        this.svevplId = svevplId;
    }

    public String getSvevplDescripcion() {
        return svevplDescripcion;
    }

    public void setSvevplDescripcion(String svevplDescripcion) {
        this.svevplDescripcion = svevplDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svevplId != null ? svevplId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstrategiaPlanVincula)) {
            return false;
        }
        EstrategiaPlanVincula other = (EstrategiaPlanVincula) object;
        if ((this.svevplId == null && other.svevplId != null) || (this.svevplId != null && !this.svevplId.equals(other.svevplId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.EstrategiaPlanVincula[ svevplId=" + svevplId + " ]";
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public int compareTo(EstrategiaPlanVincula o) {
        return this.orden.compareTo(o.getOrden());
    }
    
    public String getOrdenDescripcion(){
        return orden.toString() + ". " + svevplDescripcion;
    }
}
