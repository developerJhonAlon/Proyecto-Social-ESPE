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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "SZDTAVANUALVALOR", schema = "SIEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CantidadAnualProyecto.findAll", query = "SELECT c FROM CantidadAnualProyecto c ORDER BY c.id DESC")})
public class CantidadAnualProyecto implements Serializable, Comparable<CantidadAnualProyecto> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVANUALVALOR", sequenceName = "SEQ_SZDTAVANUALVALOR", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVANUALVALOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAVANUALVALOR_CODE")
    private Integer id;
    @Size(max = 100)
    @Column(name = "SZDTAVANUALVALOR_DESC")
    private String descripcion;
    @Column(name = "SZDTAVANUALVALOR_VALOR")
    private BigDecimal cantidadAnual;
    @JoinColumn(name = "SZTVPRESUP_CODE", referencedColumnName = "SZTVPRESUP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PresupuestoProyecto presupuestoProyecto;

    public CantidadAnualProyecto() {
    }

    public CantidadAnualProyecto(String descripcion, BigDecimal cantidadAnual,PresupuestoProyecto presupuestoProyecto) {
        this.descripcion = descripcion;
        this.cantidadAnual = cantidadAnual;
        this.presupuestoProyecto = presupuestoProyecto;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidadAnual() {
        return cantidadAnual;
    }

    public void setCantidadAnual(BigDecimal cantidadAnual) {
        this.cantidadAnual = cantidadAnual;
    }

    public PresupuestoProyecto getPresupuestoProyecto() {
        return presupuestoProyecto;
    }

    public void setPresupuestoProyecto(PresupuestoProyecto presupuestoProyecto) {
        this.presupuestoProyecto = presupuestoProyecto;
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
        if (!(object instanceof CantidadAnualProyecto)) {
            return false;
        }
        CantidadAnualProyecto other = (CantidadAnualProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.CantidadAnualProyecto[ szdtavanualvalorCode=" + id + " ]";
    }

    @Override
    public int compareTo(CantidadAnualProyecto o) {
        
        if (o != null) {
            return Integer.compare(this.id, o.id);
        } else {
              return 0;
        }
      
      
        
    }
    
}
