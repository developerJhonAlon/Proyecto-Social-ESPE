/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SZDTAVOBJETIVO_PROGRAMA")
@XmlRootElement
public class ObjetivoPrograma implements Serializable, Comparable<ObjetivoPrograma> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVOBJETIVO_PROGRAMA", sequenceName = "SEQ_SZDTAVOBJETIVO_PROGRAMA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVOBJETIVO_PROGRAMA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SVOP_ID")
    private BigDecimal svopId;
    @Size(max = 1000)
    @Column(name = "SVOP_OBJETIVO_PROY")
    private String svopObjetivoProy;
    @Column(name = "SVOP_TIPO")
    private Integer svopTipo;
    public final static Integer TIPO_FIN = 1;
    public final static Integer TIPO_PROPOSITO = 2;
    public final static Integer TIPO_COMPONENTE = 3;
    public final static Integer TIPO_ACTIVIDAD = 4;

    
    @Size(max = 1000)
    @Column(name = "SVOP_MVERIFICA")
    private String svopMverifica;
    @Size(max = 1000)
    @Column(name = "SVOP_SUPUESTOS")
    private String svopSupuestos;
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    @JoinColumn(name = "SVOP_ID_PADRE", referencedColumnName = "SVOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoPrograma svinObjetivoPadre;
    @OneToMany(mappedBy = "svinObjetivoPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoPrograma> svinObjetivoHijoList;
    @Column(name = "SVOP_ORDEN")
    private Integer svopOrden = 1;
    @Column(name = "SVOP_FEC_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "SVOP_FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @Column(name = "SVOP_INDICADOR_TIPO")
    private Integer indicadorTipo;
    public final static Integer TIPO_INDICADOR_VALOR = 1;
    public final static Integer TIPO_INDICADOR_PORCENTAJE = 2;
    @Size(max = 1000)
    @Column(name = "SVOP_INDICADOR")
    private String svopIndicador;
    @Column(name = "SVOP_INDICADOR_VALOR")
    private Integer indicadorValor;
    @Column(name = "SVOP_INDICADOR_VALOR_EJE")
    private Integer indicadorValorEjecutado;
    
    @OneToMany(mappedBy = "componenteEspecifico", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HitoProyecto> hitoProyectoList = new ArrayList<>();     
    
    @OneToMany(mappedBy = "componenteEspecifico", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvanceComponente> avanceComponenteList;
  
  
    
    
    public ObjetivoPrograma() {
    }

    public ObjetivoPrograma(Proyecto proyecto) {
        //Date fecha1 = new Date();
        Date fecha1 = proyecto.getFechaInicio();
        Calendar cal1 = Calendar.getInstance();    
        Calendar cal2 = Calendar.getInstance();    
        cal1.setTime(fecha1);
        cal2.setTime(fecha1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        fechaInicio= cal1.getTime();
        cal2.set(Calendar.HOUR_OF_DAY,23 );
        cal2.set(Calendar.MINUTE, 59);
        cal2.set(Calendar.SECOND, 59);
        fechaFin= cal2.getTime();
        this.proyecto = proyecto;
    }

    public ObjetivoPrograma(Proyecto proyecto, Integer tipo, Integer orden) {
        this.proyecto = proyecto;
        this.svopTipo = tipo;
        this.svopOrden = orden;
    }

    public ObjetivoPrograma(Programa programa, Integer tipo, Integer orden) {
        this.programa = programa;
        this.svopTipo = tipo;
        this.svopOrden = orden;
    }

    public ObjetivoPrograma(Programa sprvId) {
        this.programa = sprvId;
    }

    public ObjetivoPrograma(Integer tipo) {
        this.svopTipo = tipo;
    }

    public ObjetivoPrograma(BigDecimal svopId) {
        this.svopId = svopId;
    }

    public BigDecimal getSvopId() {
        return svopId;
    }

    public void setSvopId(BigDecimal svopId) {
        this.svopId = svopId;
    }

    public String getSvopIndicador() {
        return svopIndicador;
    }

    public void setSvopIndicador(String svopIndicador) {
        this.svopIndicador = svopIndicador;
    }

    public String getSvopMverifica() {
        return svopMverifica;
    }

    public void setSvopMverifica(String svopMverifica) {
        this.svopMverifica = svopMverifica;
    }

    public String getSvopSupuestos() {
        return svopSupuestos;
    }

    public void setSvopSupuestos(String svopSupuestos) {
        this.svopSupuestos = svopSupuestos;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public String getSvopObjetivoProy() {
        return svopObjetivoProy;
    }

    public void setSvopObjetivoProy(String svopObjetivoProy) {
        this.svopObjetivoProy = svopObjetivoProy;
    }

    public Integer getSvopTipo() {
        return svopTipo;
    }

    public void setSvopTipo(Integer svopTipo) {
        this.svopTipo = svopTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svopId != null ? svopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoPrograma)) {
            return false;
        }
        ObjetivoPrograma other = (ObjetivoPrograma) object;
        if ((this.svopId == null && other.svopId != null) || (this.svopId != null && !this.svopId.equals(other.svopId))) {
            return false;
        }
        return true;
    }

    public String getTipoStr() {
        if (svopTipo != null) {
            if (svopTipo.equals(TIPO_FIN)) {
                return "FIN";
            } else if (svopTipo.equals(TIPO_PROPOSITO)) {
                return "PROPOSITO (OBJETIVO GENERAL)";
            } else if (svopTipo.equals(TIPO_COMPONENTE)) {
                return "COMPONENTE (OBJETIVO ESPECIFICO)";
            } else {
                return "ACTIVIDAD";
            }
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return "entity.ObjetivoPrograma[ svopId=" + svopId + " ]";
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public ObjetivoPrograma getSvinObjetivoPadre() {
        return svinObjetivoPadre;
    }

    public void setSvinObjetivoPadre(ObjetivoPrograma svinObjetivoPadre) {
        this.svinObjetivoPadre = svinObjetivoPadre;
    }

    public List<ObjetivoPrograma> getSvinObjetivoHijoList() {
        Collections.sort(svinObjetivoHijoList);
        return svinObjetivoHijoList;
    }

    public void setSvinObjetivoHijoList(List<ObjetivoPrograma> svinObjetivoHijoList) {
        this.svinObjetivoHijoList = svinObjetivoHijoList;
    }
    @Transient
    private boolean expanded = true;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void setearEstadoExpanded() {
        expanded = !svopTipo.equals(ObjetivoPrograma.TIPO_FIN);
    }

    public Integer getSvopOrden() {
        return svopOrden;
    }

    public void setSvopOrden(Integer svopOrden) {
        this.svopOrden = svopOrden;
    }

    @Override
    public int compareTo(ObjetivoPrograma o) {
        return this.svopOrden.compareTo(o.getSvopOrden());
    }

    public void cambiarOrdenObjetivo(Integer cambio) {
        Integer temp = svopOrden;
        svopOrden = -1;
        if (cambio.equals(-1)) {
            svinObjetivoPadre.getSvinObjetivoHijoList().get(temp - 1).setSvopOrden(temp);
            svopOrden = temp - 1;
        } else {
            svinObjetivoPadre.getSvinObjetivoHijoList().get(temp).setSvopOrden(temp);
            svopOrden = temp + 1;
        }

    }

    public Integer getNroHijos() {
        Integer temp = 0;
        if (svinObjetivoHijoList != null) {
            temp = svinObjetivoHijoList.size();
        }
        return temp;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
 public List<AvanceComponente> getAvanceComponenteList() {
        return avanceComponenteList;
    }

    public void setAvanceComponenteList(List<AvanceComponente> avanceComponenteList) {
        this.avanceComponenteList = avanceComponenteList;
    }

    public void addSeguimientoProyecto(AvanceComponente seguimientoProyecto) {
        if (avanceComponenteList==null){
            avanceComponenteList= new ArrayList<>();
        }
        avanceComponenteList.add(seguimientoProyecto);
    }

    public void removeSeguimientoProyecto(AvanceComponente seguimientoProyecto) {
        avanceComponenteList.remove(seguimientoProyecto);
    }

    public AvanceComponente getSeguimientoProyectoActual() {
        AvanceComponente seguimientoProyecto = new AvanceComponente();
        if (avanceComponenteList != null && !avanceComponenteList.isEmpty()) {
            seguimientoProyecto= avanceComponenteList.get(0);
            Date fecha = avanceComponenteList.get(0).getFecha();
            for (AvanceComponente seg : avanceComponenteList) {
                if (seg.getFecha().after(fecha)) {
                    seguimientoProyecto= seg;
                }
            }
        }
        return seguimientoProyecto;
    }    

    public Integer getIndicadorTipo() {
        return indicadorTipo;
    }

    public void setIndicadorTipo(Integer indicadorTipo) {
        this.indicadorTipo = indicadorTipo;
    }

    public Integer getIndicadorValor() {
        return indicadorValor;
    }

    public void setIndicadorValor(Integer indicadorValor) {
        this.indicadorValor = indicadorValor;
    }

    public void removeObjetivo(ObjetivoPrograma actividad){
        for (ObjetivoPrograma act : svinObjetivoHijoList) {
            if (act.getSvopOrden().compareTo(actividad.getSvopOrden())>0){
                act.setSvopOrden(act.getSvopOrden()-1);
            }
        }
        svinObjetivoHijoList.remove(actividad);
    }

    public Integer getIndicadorValorEjecutado() {
        return indicadorValorEjecutado;
    }

    public void setIndicadorValorEjecutado(Integer indicadorValorEjecutado) {
        this.indicadorValorEjecutado = indicadorValorEjecutado;
    }
    
    public AvanceComponente getUltimoAvanceComponente(){
       AvanceComponente avanceComponente = new AvanceComponente();
       if (avanceComponenteList!=null){
           Integer idMaximo = 0;
           for (AvanceComponente avance : avanceComponenteList) {
               if (idMaximo<avance.getId()){
                   avanceComponente = avance;
                   idMaximo = avance.getId();
               }
           }
       }
       return avanceComponente;
    }    

}
