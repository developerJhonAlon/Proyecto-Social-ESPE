/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "SZDTAVPOBLAPROY")
@XmlRootElement
public class TipoPoblacionProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVPOBLAPROY", sequenceName = "SEQ_SZDTAVPOBLAPROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPOBLAPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVPOBLAPROY_CODE")
    private BigInteger id;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    
    @JoinColumn(name = "PRD_ID_POBLACION", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet tipoPoblacion = new SeaParametrosDet();
    
    
    public TipoPoblacionProyecto() {
    }

    public TipoPoblacionProyecto(Proyecto proyecto) {
        this.proyecto= proyecto;
    }
    public TipoPoblacionProyecto(Proyecto proyecto, SeaParametrosDet tipoPoblacion) {
        this.proyecto= proyecto;
        this.tipoPoblacion= tipoPoblacion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public SeaParametrosDet getTipoPoblacion() {
        return tipoPoblacion;
    }

    public void setTipoPoblacion(SeaParametrosDet tipoPoblacion) {
        this.tipoPoblacion = tipoPoblacion;
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
        if (!(object instanceof TipoPoblacionProyecto)) {
            return false;
        }
        TipoPoblacionProyecto other = (TipoPoblacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoPoblacionProyecto[ id=" + id + " ]";
    }
    
}