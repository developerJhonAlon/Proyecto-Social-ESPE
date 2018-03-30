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
@Table(name = "SZDTAVCONSOLCA")
@XmlRootElement
public class ConsolidacionCalificacionProyecto implements Serializable, Comparable<ConsolidacionCalificacionProyecto> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCONSOLCA", sequenceName = "SEQ_SZDTAVCONSOLCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCONSOLCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCONSOLCA_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;

    @Column(name = "SZTVCONSOLCA_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConsolidacion;

    @Column(name = "SZTVCONSOLCA_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacionConsolidacion;
    
    @Size(max = 4000)
    @Column(name = "SZTVCONSOLCA_OBSERVA")
    private String observaciones;

    @Size(max = 4000)
    @Column(name = "SZTVCONSOLCA_MENSAJE_CORREO")
    private String mensajeCorreo;

    @Size(max = 100)
    @Column(name = "SZTVCONSOLCA_ASUNTO_CORREO")
    private String asuntoCorreo;

    @Size(max = 150)
    @Column(name = "SZTVCONSOLCA_DIRECCION_CORREO")
    private String direccionCorreo;

    @Size(max = 1)
    @Column(name = "SZTVCONSOLCA_ESTADOFIN")
    private String estadoFinalizado;
    public final static String ESTADO_FINALIZADO_SI = "S";
    public final static String ESTADO_FINALIZADO_NO = "N";

    @OneToMany(mappedBy = "consolidacionCalificacionProyecto", fetch = FetchType.LAZY)
    private List<CalificacionProyecto> calificacionProyectoList;

    @Transient
    private boolean expanded;

    public ConsolidacionCalificacionProyecto() {
        fechaConsolidacion = new Date();
        estadoFinalizado = ESTADO_FINALIZADO_NO;
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

    public Date getFechaConsolidacion() {
        return fechaConsolidacion;
    }

    public void setFechaConsolidacion(Date fechaConsolidacion) {
        this.fechaConsolidacion = fechaConsolidacion;
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

    public List<CalificacionProyecto> getCalificacionProyectoList() {
        return calificacionProyectoList;
    }

    public void setCalificacionProyectoList(List<CalificacionProyecto> calificacionProyectoList) {
        this.calificacionProyectoList = calificacionProyectoList;
    }

    public void addCalificacionProyecto(CalificacionProyecto calificacionProyecto) {
        if (calificacionProyectoList == null) {
            calificacionProyectoList = new ArrayList<>();
        }
        calificacionProyecto.setConsolidacionCalificacionProyecto(this);
        calificacionProyectoList.add(calificacionProyecto);
    }

    public void removeCalificacionProyecto(CalificacionProyecto calificacionProyecto) {
        calificacionProyectoList.remove(calificacionProyecto);
    }

    public String getObservacionesConsolidado() {
        String observacionesConsolidado = "";
        //Integer cont = 1;
        if (calificacionProyectoList != null) {
            for (CalificacionProyecto cal : calificacionProyectoList) {
                if (!observacionesConsolidado.isEmpty()) {
                    observacionesConsolidado += "\r\n";
                    observacionesConsolidado += "************************************";
                    observacionesConsolidado += "\r\n";
                }
                observacionesConsolidado += cal.getMiembroComisionCalificacion().getUsuario().getNombresCompletos().toUpperCase();
                observacionesConsolidado += "\r\n";
                observacionesConsolidado += "OBSERVACIONES GENERALES";
                observacionesConsolidado += ":\r\n";
                if (cal.getCumpleRequisitos() != null && cal.getCumpleRequisitos().equals(CalificacionProyecto.CUMPLE_REQUISITOS_NO)) {
                    observacionesConsolidado += "NO CUMPLE CON REQUISITOS";
                    observacionesConsolidado += "\r\n";
                }
                if (cal.getObservaciones() != null && !cal.getObservaciones().isEmpty()) {
                    observacionesConsolidado += cal.getObservaciones();
                    observacionesConsolidado += "\r\n";
                }
                if (cal.getCumpleRequisitos() != null && cal.getCumpleRequisitos().equals(CalificacionProyecto.CUMPLE_REQUISITOS_SI)) {
                    observacionesConsolidado += "\r\n";
                    observacionesConsolidado += "OBSERVACIONES ESPECIFICAS";
                    observacionesConsolidado += ":\r\n";
                    int cont = 0;
                    for (DetalleCalificacionProyecto det : cal.getDetalleCalificacionList()) {
                        if (det.getObservaciones() != null && !det.getObservaciones().isEmpty()) {
                            if (cont != 0) {
                                observacionesConsolidado += "\r\n";
                                observacionesConsolidado += "\r\n";
                            }
                            cont++;
                            observacionesConsolidado += "\"";
                            observacionesConsolidado += det.getParametroEvaluacion().getDescripcion();
                            observacionesConsolidado += "\": ";
                            observacionesConsolidado += det.getObservaciones();
                        }
                    }
                }
                //cont++;
            }
        }
        return observacionesConsolidado;
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
        if (!(object instanceof ConsolidacionCalificacionProyecto)) {
            return false;
        }
        ConsolidacionCalificacionProyecto other = (ConsolidacionCalificacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ConsolidacionCalificacion[ id=" + id + " ]";
    }

    public List<DetalleCalificacionProyecto> getDetalleCalificacionProyectoConsolidado() {
        List<DetalleCalificacionProyecto> temp = new ArrayList<>();
        if (proyecto != null && proyecto.getCalificacionList() != null && !proyecto.getCalificacionList().isEmpty() && proyecto.getCalificacionList().get(0) != null) {
            for (DetalleCalificacionProyecto det : proyecto.getCalificacionList().get(0).getDetalleCalificacionList()) {
                DetalleCalificacionProyecto detalleCalificacionProyecto = new DetalleCalificacionProyecto();
                detalleCalificacionProyecto.setParametroEvaluacion(det.getParametroEvaluacion());
                /*if (det.getParametroEvaluacion().getId() == 128) {
                    System.out.println("aa");
                }*/
                if (calificacionProyectoList != null) {
                    for (CalificacionProyecto calif : calificacionProyectoList) {
                        for (DetalleCalificacionProyecto det2 : calif.getDetalleCalificacionList()) {
                            if (det2.getParametroEvaluacion().getId().equals(det.getParametroEvaluacion().getId())) {
                                /*if (det2.getParametroEvaluacion().getId() == 128) {
                                    System.out.println("aa");
                                }*/

                                detalleCalificacionProyecto.addDetalleCalificacion(det2);
                                CalificacionProyecto calificacionProyecto = new CalificacionProyecto();
                                calificacionProyecto.setMiembroComisionCalificacion(calif.getMiembroComisionCalificacion());
                                detalleCalificacionProyecto.setCalificacionProyecto(calificacionProyecto);
                                break;
                            }
                        }
                    }
                }

                temp.add(detalleCalificacionProyecto);
            }

        }
        return temp;
    }

    public Integer getTotalPuntaje() {
        Integer total = 0;
        if (getDetalleCalificacionProyectoConsolidado() != null && !getDetalleCalificacionProyectoConsolidado().isEmpty()) {
            for (DetalleCalificacionProyecto det : getDetalleCalificacionProyectoConsolidado()) {
                try {
                    total += det.getValoracionParametroPromedio().getPuntaje();
                } catch (Exception e) {
                }
            }
        }
        return total;
    }

    public String getResultado() {
        if (getTotalPuntaje() >= proyecto.getConfiguracionParametrosEvaluacion().getPuntajeMinimoRequerido()) {
            return "APROBADO";
        } else {
            return "NO APROBADO";
        }
    }

    @Override
    public int compareTo(ConsolidacionCalificacionProyecto o) {
        return this.id.compareTo(o.id) * -1;
    }

    public String getMensajeCorreo() {
        return mensajeCorreo;
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }

    public String getAsuntoCorreo() {
        return asuntoCorreo;
    }

    public void setAsuntoCorreo(String asuntoCorreo) {
        this.asuntoCorreo = asuntoCorreo;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public String getEstadoFinalizado() {
        return estadoFinalizado;
    }

    public void setEstadoFinalizado(String estadoFinalizado) {
        this.estadoFinalizado = estadoFinalizado;
    }

    public Date getFechaFinalizacionConsolidacion() {
        return fechaFinalizacionConsolidacion;
    }

    public void setFechaFinalizacionConsolidacion(Date fechaFinalizacionConsolidacion) {
        this.fechaFinalizacionConsolidacion = fechaFinalizacionConsolidacion;
    }

    
}
