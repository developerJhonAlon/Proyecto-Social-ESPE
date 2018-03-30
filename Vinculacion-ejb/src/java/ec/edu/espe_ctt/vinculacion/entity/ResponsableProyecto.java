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
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SZDTAVRESPONSABLE_PROG")
@XmlRootElement
public class ResponsableProyecto implements Serializable, Comparable<ResponsableProyecto> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVRESPONSABLE_PROG", sequenceName = "SEQ_SZDTAVRESPONSABLE_PROG", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVRESPONSABLE_PROG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SRESPROG_ID")
    private Integer id;

    @JoinColumn(name = "SZTVTIPRES_CODE", referencedColumnName = "SZTVTIPRES_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoResponsable tipoResponsable;

    @JoinColumn(name = "USU_ID_DOCENTE", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;

    @JoinColumn(name = "STVCAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp campus;

    @JoinColumn(name = "STVSUBJ_CODE_DPTO", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj departamento;

    @JoinColumn(name = "STVMAJR_CODE", referencedColumnName = "STVMAJR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvmajr carrera;

    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;

    @Column(name = "SRESPROG_HORAS_PLANIF")
    private Integer horasPlanificadas;

    @Column(name = "SRESPROG_NRO_CERTIFICADOS")
    private Integer nroCertificadosEmtregados;

    @Column(name = "SRESPROG_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Size(max = 1)
    @Column(name = "SRESPROG_ESTADO")
    private String estado;
    public final static String ESTADO_ACTIVO = "A";
    public final static String ESTADO_INACTIVO = "I";

    @JoinColumn(name = "SZDTAVACTARESPONSA_CODE", referencedColumnName = "SZDTAVACTARESPONSA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActaDesignacionResponsable actaDesignacionResponsable;

    @OneToMany(mappedBy = "responsableProyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorasResponsableProyecto> horasDedicadasList;

    public ResponsableProyecto() {
        this.nroCertificadosEmtregados = 0;
        this.fechaCreacion = new Date();
        this.estado = ESTADO_ACTIVO;
    }

    public ResponsableProyecto(Integer id, SegUsuario usuario) {
        this();
        this.id = id;
        this.usuario = usuario;
    }

    public ResponsableProyecto(TipoResponsable tipoResponsable) {
        this();
        this.tipoResponsable = tipoResponsable;
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

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
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
        if (!(object instanceof ResponsableProyecto)) {
            return false;
        }
        ResponsableProyecto other = (ResponsableProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.SvinResponsableProg[ id=" + id + " ]";
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

    public TipoResponsable getTipoResponsable() {
        return tipoResponsable;
    }

    public void setTipoResponsable(TipoResponsable tipoResponsable) {
        this.tipoResponsable = tipoResponsable;
    }

    @Transient
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Integer getHorasPlanificadas() {
        return horasPlanificadas;
    }

    public void setHorasPlanificadas(Integer horasPlanificadas) {
        this.horasPlanificadas = horasPlanificadas;
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

    @Override
    public int compareTo(ResponsableProyecto o) {
        if (campus != null && o.campus != null) {
            if (campus.getStvcampDesc().equals(o.campus.getStvcampDesc())) {
                if (departamento != null && o.departamento != null) {
                    if (departamento.getStvsubjDesc().equals(o.departamento.getStvsubjDesc())){
                        if (carrera != null && o.getCarrera() != null) {
                            return (carrera.getStvmajrDesc().compareTo(o.carrera.getStvmajrDesc()));
                        }
                    }
                    return (departamento.getStvsubjDesc().compareTo(o.departamento.getStvsubjDesc()));
                }

            }
            return campus.getStvcampDesc().compareTo(o.campus.getStvcampDesc());
        }
        if (carrera != null && o.carrera != null) {
            return (carrera.getStvmajrDesc().compareTo(o.carrera.getStvmajrDesc()));
        }
        return this.id.compareTo(o.id);
    }

    public List<HorasResponsableProyecto> getHorasDedicadasList() {
        return horasDedicadasList;
    }

    public void setHorasDedicadasList(List<HorasResponsableProyecto> horasDedicadasList) {
        this.horasDedicadasList = horasDedicadasList;
    }

    public Integer getTotalHorasDedicadas() {
        Integer temp = 0;
        if (horasDedicadasList != null) {
            for (HorasResponsableProyecto hor : horasDedicadasList) {
                temp += hor.getCantidadHoras();
            }
        }
        return temp;
    }

    public Stvmajr getCarrera() {
        return carrera;
    }

    public void setCarrera(Stvmajr carrera) {
        this.carrera = carrera;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }

    public Integer getNroCertificadosEmtregados() {
        return nroCertificadosEmtregados;
    }

    public void setNroCertificadosEmtregados(Integer nroCertificadosEmtregados) {
        this.nroCertificadosEmtregados = nroCertificadosEmtregados;
    }

    public void agregarNroCertificadoEntregado() {
        if (nroCertificadosEmtregados == null) {
            nroCertificadosEmtregados = 1;
        } else {
            nroCertificadosEmtregados++;
        }
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ActaDesignacionResponsable getActaDesignacionResponsable() {
        return actaDesignacionResponsable;
    }

    public void setActaDesignacionResponsable(ActaDesignacionResponsable actaDesignacionResponsable) {
        this.actaDesignacionResponsable = actaDesignacionResponsable;
    }
    public boolean isPermitirEliminar() {
        if (tipoResponsable.getId().equals(TipoResponsable.TIPO_DIRECTOR)){
            //True Si está en un estado antes de laejecucion
            return (proyecto.getEstado().getPrdId().compareTo(SeaParametrosDet.ESTADO_APROBADO_CONSEJO_ACADEMICO)<0);
        }
        else{
            return (proyecto.isEstadoEjecucion() && actaDesignacionResponsable==null);
        }
    }

}
