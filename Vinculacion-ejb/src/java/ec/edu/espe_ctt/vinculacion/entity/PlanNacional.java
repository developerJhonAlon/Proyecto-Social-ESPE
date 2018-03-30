/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "SZDTAVPLAN_NACIONAL")
@XmlRootElement
public class PlanNacional implements Serializable, Comparable<PlanNacional> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVPLAN_NACIONAL", sequenceName = "SEQ_SZDTAVPLAN_NACIONAL", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPLAN_NACIONAL")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVPLAN_CODE")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "SZTVPLAN_DESCRIPCION")
    private String descripcion;
    @Column(name = "SZTVPLAN_FECHA")
    @Temporal(TemporalType.DATE)
    private Date fechaConfiguracion;
    @Size(max = 1)
    @Column(name = "SZTVPLAN_ESTADO")
    private String estado;
    @OneToMany(mappedBy = "sztvplanCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoBVivir> objetivoBVivirList;

    public final static String ESTADO_ACTIVA = "A";
    public final static String ESTADO_INACTIVA = "I";
    
    
    @Transient
    private boolean expanded;
            
    public PlanNacional() {
    }

    public PlanNacional(Integer id) {
        this.id = id;
    }

    public boolean isExpanded() {
        return expanded;
        
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaConfiguracion() {
        return fechaConfiguracion;
    }

    public void setFechaConfiguracion(Date fechaConfiguracion) {
        this.fechaConfiguracion = fechaConfiguracion;
    }

   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ObjetivoBVivir> getObjetivoBVivirList() {
        if(objetivoBVivirList != null){
           Collections.sort(objetivoBVivirList);
        }
        return objetivoBVivirList;
    }

    public void setObjetivoBVivirList(List<ObjetivoBVivir> objetivoBVivirList) {
        this.objetivoBVivirList = objetivoBVivirList;
    }

    public void removeObjetivoPlanNacional(ObjetivoBVivir objetivoBVivir) {
        for (ObjetivoBVivir objetivo : getObjetivoBVivirList()) {
            if (objetivo.getOrden() > objetivoBVivir.getOrden()) {
                objetivo.setOrden(objetivo.getOrden() - 1);
            }
        }
        objetivoBVivirList.remove(objetivoBVivir);
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
        if (!(object instanceof PlanNacional)) {
            return false;
        }
        PlanNacional other = (PlanNacional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.PlanNacional[ sztvplanCode=" + id + " ]";
    }

    @Override
    public int compareTo(PlanNacional o) {
        return this.id.compareTo(o.getId()) * -1;
    }
    
}
