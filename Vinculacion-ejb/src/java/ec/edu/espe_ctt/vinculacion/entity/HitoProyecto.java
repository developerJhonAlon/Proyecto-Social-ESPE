/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVSEGUIM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HitoProyecto.findAll", query = "SELECT h FROM HitoProyecto h"),
    @NamedQuery(name = "HitoProyecto.findById", query = "SELECT h FROM HitoProyecto h WHERE h.id = :id")
})
public class HitoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVSEGUIM", sequenceName = "SEQ_SZDTAVSEGUIM", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVSEGUIM")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVSEGUIM_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    
    @JoinColumn(name = "SVOP_ID", referencedColumnName = "SVOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoPrograma componenteEspecifico;    
    
    @Column(name = "SZTVSEGUIM_FECHA_LOGRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Size(max = 100)
    @Column(name = "SZTVSEGUIM_DESCRIP")
    private String descripcion;
  
     @Size(max = 1000)
    @Column(name = "SZTVSEGUIM_LOGRO")
    private String logro;
     
  
    public HitoProyecto() {
    }

    public HitoProyecto(Integer id) {
        this.id = id;
    }

    public HitoProyecto(Proyecto proyecto) {
        this.proyecto= proyecto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ObjetivoPrograma getComponenteEspecifico() {
        return componenteEspecifico;
    }

    public void setComponenteEspecifico(ObjetivoPrograma componenteEspecifico) {
        this.componenteEspecifico = componenteEspecifico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLogro() {
        return logro;
    }

    public void setLogro(String logro) {
        this.logro = logro;
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
        if (!(object instanceof HitoProyecto)) {
            return false;
        }
        HitoProyecto other = (HitoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.HitoProyecto[ id=" + id + " ]";
    }
    
}
