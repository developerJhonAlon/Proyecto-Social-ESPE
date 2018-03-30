/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVCABCOMCA")
@XmlRootElement
public class ComisionCalificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCABCOMCA", sequenceName = "SEQ_SZDTAVCABCOMCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCABCOMCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCABCOMCA_CODE")
    private Integer id;

    @Column(name = "SZTVCABCOMCA_FECH_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Size(max = 100)
    @Column(name = "SZTVCABCOMCA_DECSRIP")
    private String descripcion;

    @OneToMany(mappedBy = "comisionCalificacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MiembroComisionCalificacion> miembroList;

    @Transient
    private boolean expanded;

    public ComisionCalificacion() {
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

    public List<MiembroComisionCalificacion> getMiembroList() {
        return miembroList;
    }

    public void setMiembroList(List<MiembroComisionCalificacion> miembroList) {
        this.miembroList = miembroList;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
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
        if (!(object instanceof ComisionCalificacion)) {
            return false;
        }
        ComisionCalificacion other = (ComisionCalificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComisionCalificacion[ id=" + id + " ]";
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void addMiembro(MiembroComisionCalificacion miembroComisionCalificacion) {
        if (miembroList == null) {
            miembroList = new ArrayList<>();
        }
        miembroComisionCalificacion.setComisionCalificacion(this);
        miembroList.add(miembroComisionCalificacion);
    }

    public void removeMiembro(MiembroComisionCalificacion miembroComisionCalificacion) {
        miembroList.remove(miembroComisionCalificacion);
    }

    public List<MiembroComisionCalificacion> getMiembroActivoList() {
        List<MiembroComisionCalificacion> result = new ArrayList<>();
        for (MiembroComisionCalificacion m : miembroList) {
            if (m.getEstado().equals(MiembroComisionCalificacion.ESTADO_ACTIVO)) {
                result.add(m);
            }
        }
        return result;
    }
    
    @Transient
    private Integer nroProyectos;

    public Integer getNroProyectos() {
        return nroProyectos;
    }

    public void setNroProyectos(Integer nroProyectos) {
        this.nroProyectos = nroProyectos;
    }
    public void addNroProyectos(){
        if (this.nroProyectos==null){
            this.nroProyectos=0;
        }
        this.nroProyectos++;
    }
    

}
