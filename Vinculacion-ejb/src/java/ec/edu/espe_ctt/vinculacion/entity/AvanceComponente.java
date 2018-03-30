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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVACTPROY")
@XmlRootElement
public class AvanceComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVACTPROY", sequenceName = "SEQ_SZDTAVACTPROY", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVACTPROY")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVACTPROY_CODE")
    private Integer id;

    @JoinColumn(name = "SVOP_ID", referencedColumnName = "SVOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoPrograma componenteEspecifico; 

    @Column(name = "SZTVACTPROY_FECH_REGIS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Size(max = 250)
    @Column(name = "SZTVACTPROY_OBSERVA")
    private String observacion;
  
  
    @OneToMany(mappedBy = "avanceComponente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvanceActividad> avanceActividadList;
  
    
    public AvanceComponente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ObjetivoPrograma getComponenteEspecifico() {
        return componenteEspecifico;
    }

    public void setComponenteEspecifico(ObjetivoPrograma componenteEspecifico) {
        this.componenteEspecifico = componenteEspecifico;
    }

    public List<AvanceActividad> getAvanceActividadList() {
        return avanceActividadList;
    }

    public void setAvanceActividadList(List<AvanceActividad> avanceActividadList) {
        this.avanceActividadList = avanceActividadList;
    }


    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvanceComponente)) {
            return false;
        }
        AvanceComponente other = (AvanceComponente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.SeguimientoProyecto[ id=" + id + " ]";
    }

    public void addSeguimientoActividad(AvanceActividad seguimientoActividad){
        if (avanceActividadList==null){
            avanceActividadList= new ArrayList<>();
        }
        avanceActividadList.add(seguimientoActividad);
    }
    public void removeSeguimientoActividad(AvanceActividad seguimientoActividad){
        avanceActividadList.remove(seguimientoActividad);
    }
    public AvanceActividad getUltimoAvance(){
       AvanceActividad avanceActividad = new AvanceActividad();
       if (avanceActividadList!=null){
           Integer idMaximo = 0;
           for (AvanceActividad avance : avanceActividadList) {
               if (idMaximo<avance.getId()){
                   avanceActividad = avance;
                   idMaximo = avance.getId();
               }
           }
       }
       return avanceActividad;
    }
}
