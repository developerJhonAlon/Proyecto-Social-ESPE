/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
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
@Table(name = "SZDTAVDETCOMCA")
@XmlRootElement
public class MiembroComisionCalificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVDETCOMCA", sequenceName = "SEQ_SZDTAVDETCOMCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVDETCOMCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVDETCOMCA_CODE")
    private Integer id;

    @JoinColumn(name = "USU_ID_CREA", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuarioCrea;
    
    @JoinColumn(name = "USU_ID_ASIGNADO", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;

    @JoinColumn(name = "SZTVCABCOMCA_CODE", referencedColumnName = "SZTVCABCOMCA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ComisionCalificacion comisionCalificacion;

    @Column(name = "SZTVDETCOMCA_FECH_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;
    
    
    @Size(max = 1)
    @Column(name = "SZTVDETCOMCA_ESTADO")
    private String estado;
    
    
    public final static String ESTADO_ACTIVO = "A";
    public final static String ESTADO_INACTIVO = "I";

    public MiembroComisionCalificacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public ComisionCalificacion getComisionCalificacion() {
        return comisionCalificacion;
    }

    public void setComisionCalificacion(ComisionCalificacion comisionCalificacion) {
        this.comisionCalificacion = comisionCalificacion;
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
        if (!(object instanceof MiembroComisionCalificacion)) {
            return false;
        }
        MiembroComisionCalificacion other = (MiembroComisionCalificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MiembroComisionCalificacion[ id=" + id + " ]";
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public SegUsuario getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(SegUsuario usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

}
