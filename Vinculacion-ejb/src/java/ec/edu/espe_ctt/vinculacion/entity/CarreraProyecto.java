/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvmajr;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVESTUPARTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarreraProyecto.findAll", query = "SELECT c FROM CarreraProyecto c"),
    @NamedQuery(name = "CarreraProyecto.findById", query = "SELECT c FROM CarreraProyecto c WHERE c.id = :id")
})
public class CarreraProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVESTUPARTI", sequenceName = "SEQ_SZDTAVESTUPARTI", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVESTUPARTI")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVESTUPARTI_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    
    @JoinColumn(name = "STVMAJR_CODE", referencedColumnName = "STVMAJR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvmajr carrera;
            
    
    @Column(name = "SZTVESTUPARTI_NUMERO")
    private Integer nroEstudiantes;

    public CarreraProyecto() {
    }

    public CarreraProyecto(Integer id) {
        this.id = id;
    }

    public CarreraProyecto(Proyecto proyecto) {
        this.proyecto= proyecto;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }


    public Integer getNroEstudiantes() {
        return nroEstudiantes;
    }

    public void setNroEstudiantes(Integer nroEstudiantes) {
        this.nroEstudiantes = nroEstudiantes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stvmajr getCarrera() {
        return carrera;
    }

    public void setCarrera(Stvmajr carrera) {
        this.carrera = carrera;
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
        if (!(object instanceof CarreraProyecto)) {
            return false;
        }
        CarreraProyecto other = (CarreraProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.CarreraProyecto[ id=" + id + " ]";
    }
    
}
