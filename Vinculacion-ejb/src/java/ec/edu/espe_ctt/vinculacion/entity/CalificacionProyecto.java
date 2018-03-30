/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
@Table(name = "SZDTAVCABEVALP")
@XmlRootElement
public class CalificacionProyecto implements Serializable, Comparable<CalificacionProyecto> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCABEVALP", sequenceName = "SEQ_SZDTAVCABEVALP", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCABEVALP")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCABEVALP_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;

    @Column(name = "SZTVCABEVALP_FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Size(max = 1000)
    @Column(name = "SZTVCABEVALP_OBSERVA")
    private String observaciones;

    @OneToMany(mappedBy = "calificacionProyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCalificacionProyecto> detalleCalificacionList;

    /*@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;*/
    
    @JoinColumn(name = "SZTVDETCOMCA_CODE", referencedColumnName = "SZTVDETCOMCA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private MiembroComisionCalificacion miembroComisionCalificacion;


    @JoinColumn(name = "SZTVCONSOLCA_CODE", referencedColumnName = "SZTVCONSOLCA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsolidacionCalificacionProyecto consolidacionCalificacionProyecto;
    
    @Size(max = 1)
    @Column(name = "SZTVCABEVALP_ESTADOFIN")
    private String estadoFinalizado;
    public final static String ESTADO_FINALIZADO_SI= "S";
    public final static String ESTADO_FINALIZADO_NO= "N";

      
    @Transient
    private boolean expanded;
    
    
    
    @Size(max = 1)
    @Column(name = "SZTVPROYEC_CUMPLE_REQ")
    private String cumpleRequisitos;
    public final static String CUMPLE_REQUISITOS_SI = "S";
    public final static String CUMPLE_REQUISITOS_NO = "N";
    
    public CalificacionProyecto() {
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

    public List<DetalleCalificacionProyecto> getDetalleCalificacionList() {
        if (detalleCalificacionList!=null){
            Collections.sort(detalleCalificacionList);
        }
        return detalleCalificacionList;
    }

    public void setDetalleCalificacionList(List<DetalleCalificacionProyecto> detalleCalificacionList) {
        this.detalleCalificacionList = detalleCalificacionList;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void addDetalleCalificacion(DetalleCalificacionProyecto detalleCalificacionProyecto){
        if (detalleCalificacionList==null){
            detalleCalificacionList= new ArrayList<>();
        }
        detalleCalificacionProyecto.setCalificacionProyecto(this);
        detalleCalificacionList.add(detalleCalificacionProyecto);
    }

    public ConsolidacionCalificacionProyecto getConsolidacionCalificacionProyecto() {
        return consolidacionCalificacionProyecto;
    }

    public void setConsolidacionCalificacionProyecto(ConsolidacionCalificacionProyecto consolidacionCalificacionProyecto) {
        this.consolidacionCalificacionProyecto = consolidacionCalificacionProyecto;
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
        if (!(object instanceof CalificacionProyecto)) {
            return false;
        }
        CalificacionProyecto other = (CalificacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CalificacionProyecto[ id=" + id + " ]";
    }

    @Override
    public int compareTo(CalificacionProyecto o) {
        return this.id.compareTo(o.getId())*-1;
    }

    public Integer getTotalPuntaje(){
        Integer total = 0;
        if (detalleCalificacionList!=null && !detalleCalificacionList.isEmpty()){
            for (DetalleCalificacionProyecto det : detalleCalificacionList) {
                try {
                    total+=det.getValoracionParametroEvaluacion().getPuntaje();
                } catch (Exception e) {
                }
            }
        }
        return total;
    }
    
    public String getResultado(){
        if (getTotalPuntaje()>=proyecto.getConfiguracionParametrosEvaluacion().getPuntajeMinimoRequerido()){
            return "APROBADO";
        }
        else{
            return "NO APROBADO";
        }
    }

/*    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }
  */  

    public MiembroComisionCalificacion getMiembroComisionCalificacion() {
        return miembroComisionCalificacion;
    }

    public void setMiembroComisionCalificacion(MiembroComisionCalificacion miembroComisionCalificacion) {
        this.miembroComisionCalificacion = miembroComisionCalificacion;
    }

    public String getEstadoFinalizado() {
        return estadoFinalizado;
    }

    public void setEstadoFinalizado(String estadoFinalizado) {
        this.estadoFinalizado = estadoFinalizado;
    }
    
    
    public String getCumpleRequisitos() {
        return cumpleRequisitos;
    }

    public void setCumpleRequisitos(String cumpleRequisitos) {
        this.cumpleRequisitos = cumpleRequisitos;
    }

    
}
