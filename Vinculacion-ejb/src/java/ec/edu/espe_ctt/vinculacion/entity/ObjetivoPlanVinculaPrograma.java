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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVPLAN_V_PROGRAMA")
@XmlRootElement
public class ObjetivoPlanVinculaPrograma implements Serializable, Comparable<ObjetivoPlanVinculaPrograma> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
     @SequenceGenerator(name = " SEQ_SZDTAVPLAN_V_PROGRAMA", sequenceName = " SEQ_SZDTAVPLAN_V_PROGRAMA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " SEQ_SZDTAVPLAN_V_PROGRAMA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SVPVP_ID")
    private BigDecimal id;
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @JoinColumn(name = "SVOPVI_ID", referencedColumnName = "SVOPVI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoPlanVincula objetivoPlanVinculacion;

    public ObjetivoPlanVinculaPrograma() {
    }

    public ObjetivoPlanVinculaPrograma(BigDecimal svpvpId) {
        this.id = svpvpId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public ObjetivoPlanVincula getObjetivoPlanVinculacion() {
        return objetivoPlanVinculacion;
    }

    public void setObjetivoPlanVinculacion(ObjetivoPlanVincula objetivoPlanVinculacion) {
        this.objetivoPlanVinculacion = objetivoPlanVinculacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoPlanVinculaPrograma)) {
            return false;
        }
        ObjetivoPlanVinculaPrograma other = (ObjetivoPlanVinculaPrograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObjetivoPlanVinculaPrograma[ svpvpId=" + id + " ]";
    }

    @Override
    public int compareTo(ObjetivoPlanVinculaPrograma o) {
        return this.objetivoPlanVinculacion.getOrden().compareTo(o.getObjetivoPlanVinculacion().getOrden());
    }
    
}