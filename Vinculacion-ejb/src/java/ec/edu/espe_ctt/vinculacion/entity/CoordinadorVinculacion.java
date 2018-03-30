/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVCOORDINADOR_VINCU")
@XmlRootElement
public class CoordinadorVinculacion implements Serializable, Comparable<CoordinadorVinculacion> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCOORDINADOR_VINCU", sequenceName = "SEQ_SZDTAVCOORDINADOR_VINCU", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCOORDINADOR_VINCU")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAVCOORDINADOR_VINCU_ID")
    private Integer id;

    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;

    @JoinColumn(name = "STVCAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp campus;

    @JoinColumn(name = "STVSUBJ_CODE", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj departamento;

    @JoinColumn(name = "STVMAJR_CODE", referencedColumnName = "STVMAJR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvmajr carrera;

    public CoordinadorVinculacion() {
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
        if (!(object instanceof CoordinadorVinculacion)) {
            return false;
        }
        CoordinadorVinculacion other = (CoordinadorVinculacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.CoordinadorVinculacion[ id=" + id + " ]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(CoordinadorVinculacion o) {
        int result = this.campus.compareTo(o.campus);
        if (result == 0 && this.departamento != null) {
            result = this.departamento.compareTo(o.departamento);
            if (result == 0 && carrera != null) {
                result = this.carrera.compareTo(o.carrera);
            }
        }
        return result;
    }

    @Transient
    private String cedula;

    public String getCedula() {
        if (usuario != null) {
            return usuario.getUsuCc();
        }
        return null;

    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }

    public Stvmajr getCarrera() {
        return carrera;
    }

    public void setCarrera(Stvmajr carrera) {
        this.carrera = carrera;
    }

}
