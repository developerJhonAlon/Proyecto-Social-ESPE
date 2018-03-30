/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.saturno.entity.Stvterm;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "V_ESTUDIANTE_CARRERA")
@XmlRootElement
public class VEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ID")
    private Integer id;
    
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;

    @JoinColumn(name = "STVSUBJ_CODE", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj departamento;

    @JoinColumn(name = "STVMAJR_CODE", referencedColumnName = "STVMAJR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvmajr carrera;

    @JoinColumn(name = "SGBSTDN_TERM_CODE_EFF", referencedColumnName = "STVTERM_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvterm periodo;

    public VEstudiante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stvterm getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Stvterm periodo) {
        this.periodo = periodo;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public Stvsubj getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Stvsubj departamento) {
        this.departamento = departamento;
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
        if (!(object instanceof VEstudiante)) {
            return false;
        }
        VEstudiante other = (VEstudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.VEstudiante[ id=" + id + " ]";
    }

    public Stvmajr getCarrera() {
        return carrera;
    }

    public void setCarrera(Stvmajr carrera) {
        this.carrera = carrera;
    }

}
