/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVDETACTPROY")
@XmlRootElement
public class AvanceActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVDETACTPROY", sequenceName = "SEQ_SZDTAVDETACTPROY", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVDETACTPROY")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVDETACTPROY_CODE")
    private Integer id;

    
    @JoinColumn(name = "SZTVACTPROY_CODE", referencedColumnName = "SZTVACTPROY_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private AvanceComponente avanceComponente;

    @JoinColumn(name = "SVOP_ID", referencedColumnName = "SVOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoPrograma actividad;

    @Size(max = 250)
    @Column(name = "SZTVDETACTPROY_OBSERVA")
    private String observacion;
    
    @Size(max = 250)
    @Column(name = "SZTVDETACTPROY_RESULTADO")
    private String resultado;
    
    
    @Column(name = "SZTVDETACTPROY_PORCENT")
    private Integer porcentajeAvance;
    
 
    public AvanceActividad() {
    }

    public AvanceActividad(Integer id) {
        this.id= id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AvanceComponente getAvanceComponente() {
        return avanceComponente;
    }

    public void setAvanceComponente(AvanceComponente avanceComponente) {
        this.avanceComponente = avanceComponente;
    }


    public ObjetivoPrograma getActividad() {
        return actividad;
    }

    public void setActividad(ObjetivoPrograma actividad) {
        this.actividad = actividad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(Integer porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }


    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvanceActividad)) {
            return false;
        }
        AvanceActividad other = (AvanceActividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.SeguimientoActividad[ id=" + id + " ]";
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
}
