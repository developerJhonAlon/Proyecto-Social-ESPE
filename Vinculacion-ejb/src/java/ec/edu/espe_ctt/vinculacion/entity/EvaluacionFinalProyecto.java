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
@Table(name = "SZDTAVCABEVALPF")
@XmlRootElement
public class EvaluacionFinalProyecto implements Serializable, Comparable<EvaluacionFinalProyecto> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCABEVALPF", sequenceName = "SEQ_SZDTAVCABEVALPF", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCABEVALPF")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCABEVALPF_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;

    @Column(name = "SZTVCABEVALPF_FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Size(max = 1000)
    @Column(name = "SZTVCABEVALPF_OBSERVA")
    private String observaciones;

    @OneToMany(mappedBy = "evaluacionFinalProyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleEvaluacionFinalProyecto> detalleEvaluacionFinalProyectoList;

    @Transient
    private boolean expanded;

    public EvaluacionFinalProyecto() {
        fecha = new Date();
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        if (!(object instanceof EvaluacionFinalProyecto)) {
            return false;
        }
        EvaluacionFinalProyecto other = (EvaluacionFinalProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EvaluacionFinalProyecto[ id=" + id + " ]";
    }

    @Override
    public int compareTo(EvaluacionFinalProyecto o) {
        return this.id.compareTo(o.getId()) * -1;
    }

    public List<DetalleEvaluacionFinalProyecto> getDetalleEvaluacionFinalProyectoList() {
        return detalleEvaluacionFinalProyectoList;
    }

    public void setDetalleEvaluacionFinalProyectoList(List<DetalleEvaluacionFinalProyecto> detalleEvaluacionFinalProyectoList) {
        this.detalleEvaluacionFinalProyectoList = detalleEvaluacionFinalProyectoList;
    }

    public void addDetalleEvaluacionFinalProyecto(DetalleEvaluacionFinalProyecto detalleEvaluacionFinalProyecto) {
        if (detalleEvaluacionFinalProyectoList == null) {
            detalleEvaluacionFinalProyectoList = new ArrayList<>();
        }
        detalleEvaluacionFinalProyectoList.add(detalleEvaluacionFinalProyecto);
    }

    public Integer getPuntajeEvaluacionFinalPertinencia() {
        return getPuntajeEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_PERTINENCIA);
    }

    public Integer getPuntajeEvaluacionFinalEficacia() {
        return getPuntajeEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA);
    }

    public Integer getPuntajeEvaluacionFinalEficiencia() {
        return getPuntajeEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA);
    }

    public Integer getPuntajeEvaluacionFinalSostenibilidad() {
        return getPuntajeEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_SOSTENIBILIDAD);
    }

    public Integer getPuntajeEvaluacionFinalTotal() {
        return getPuntajeEvaluacionFinalEficacia() + getPuntajeEvaluacionFinalEficiencia() + getPuntajeEvaluacionFinalPertinencia() + getPuntajeEvaluacionFinalSostenibilidad();
    }

    public Integer getPuntajeEvaluacionFinalMaximo() {
        return getPuntajeMaximoEvaluacionFinalEficacia() + getPuntajeMaximoEvaluacionFinalEficiencia() + getPuntajeMaximoEvaluacionFinalPertinencia() + getPuntajeMaximoEvaluacionFinalSostenibilidad();
    }

    private Integer getPuntajeEvaluacionFinalXTipo(Integer tipo) {
        Integer puntaje = 0;
        if (detalleEvaluacionFinalProyectoList != null) {
            for (DetalleEvaluacionFinalProyecto d : detalleEvaluacionFinalProyectoList) {
                if (tipo.equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)
                        && d.getObjetivoMatrizMarcoLogico() != null) {
                    puntaje += d.getPuntaje();
                } else if (d.getValoracionParametroEvaluacion() != null
                        && d.getValoracionParametroEvaluacion().getParametroEvaluacion().getParametroEvaluacionFinalCabecera().getTipo().equals(tipo)) {
                    puntaje += d.getValoracionParametroEvaluacion().getPuntaje();
                }
            }
        }
        return puntaje;
    }

    public Integer getPuntajeMaximoEvaluacionFinalPertinencia() {
        return getPuntajeMaximoEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_PERTINENCIA);
    }

    public Integer getPuntajeMaximoEvaluacionFinalEficacia() {
        return getPuntajeMaximoEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA);
    }

    public Integer getPuntajeMaximoEvaluacionFinalEficiencia() {
        return getPuntajeMaximoEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA);
    }

    public Integer getPuntajeMaximoEvaluacionFinalSostenibilidad() {
        return getPuntajeMaximoEvaluacionFinalXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_SOSTENIBILIDAD);
    }

    private Integer getPuntajeMaximoEvaluacionFinalXTipo(Integer tipo) {
        Integer result = 0;
        if (tipo.equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
            return proyecto.getObjetivoProyectoList().size() * 5;
        } else if (tipo.equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_PERTINENCIA)) {
            for (ParametroEvaluacion p : proyecto.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraPertinenciaList().get(0).getParametroEvaluacionList()) {
                result += p.getPuntajeMaximo();
            }
        } else if (tipo.equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA)) {
            for (ParametroEvaluacion p : proyecto.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraEficienciaList().get(0).getParametroEvaluacionList()) {
                if (!(proyecto.getTipo().equals(Proyecto.TIPO_GASTO_PERMANENTE)
                        && p.getIdAspectoEvaluacion() != null
                        && p.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD))) {
                    result += p.getPuntajeMaximo();
                }
            }
        } else if (tipo.equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_SOSTENIBILIDAD)) {
            for (ParametroEvaluacion p : proyecto.getConfiguracionParametrosEvaluacionFinal().getParametroEvaluacionFinalCabeceraSostenibilidadList().get(0).getParametroEvaluacionList()) {
                result += p.getPuntajeMaximo();
            }
        }
        return result;
    }

    public boolean verificarEvaluacion() {
        for (DetalleEvaluacionFinalProyecto d : detalleEvaluacionFinalProyectoList) {
            if (d.getObjetivoMatrizMarcoLogico() == null) {
                if (d.getValoracionParametroEvaluacion() == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
