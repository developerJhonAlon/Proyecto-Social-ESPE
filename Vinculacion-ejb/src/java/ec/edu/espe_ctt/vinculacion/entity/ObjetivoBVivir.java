/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVOBJETIVO_B_VIVIR")
@XmlRootElement
public class ObjetivoBVivir implements Serializable ,Comparable<ObjetivoBVivir> {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVOBJETIVO_B_VIVIR", sequenceName = "SEQ_SZDTAVOBJETIVO_B_VIVIR", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVOBJETIVO_B_VIVIR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SVOBVI_ID")
    private BigDecimal svobviId;
    @Size(max = 500)
    @Column(name = "SVOBVI_DESCRIPCION")
    private String svobviDescripcion;
    @OneToMany(mappedBy = "svobviIdPadre", fetch = FetchType.LAZY)
    private Collection<ObjetivoBVivir> svinObjetivoBVivirCollection;
    @JoinColumn(name = "SVOBVI_ID_PADRE", referencedColumnName = "SVOBVI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoBVivir svobviIdPadre;
    @Column(name = "SVOBVI_ORDEN")
    private Integer orden;
 
    @JoinColumn(name = "SZTVPLAN_CODE", referencedColumnName = "SZTVPLAN_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PlanNacional configuracionPlanNacional;
    
    @Transient
    private boolean expanded;
    
    
    public ObjetivoBVivir() {
    }

    public ObjetivoBVivir(BigDecimal svobviId) {
        this.svobviId = svobviId;
    }

    
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void cambiarOrden(Integer cambio) {
        Integer temp = orden;
        if (cambio.equals(-1)) {
            configuracionPlanNacional.getObjetivoBVivirList().get(temp - 2).setOrden(temp);
      
            
            setOrden(temp - 1);
        } else {
            configuracionPlanNacional.getObjetivoBVivirList().get(temp).setOrden(temp);
            setOrden(temp + 1);
        }
    }
    
    public void removePolitica(ObjetivoBVivir politicaPlanNacional) {
        for (ObjetivoBVivir politica : getSvinObjetivoBVivirCollection()) {
            if (politica.getOrden() > politicaPlanNacional.getOrden()) {
                politica.setOrden(politica.getOrden() - 1);
            }
        }
        svinObjetivoBVivirCollection.remove(politicaPlanNacional);
    }
   
    public void setSvobviId(BigDecimal svobviId) {
        this.svobviId = svobviId;
    }

    public BigDecimal getSvobviId() {
        return svobviId;
    }
   
    
    
    public String getSvobviDescripcion() {
        return svobviDescripcion;
    }

    public void setSvobviDescripcion(String svobviDescripcion) {
        this.svobviDescripcion = svobviDescripcion;
    }

    @XmlTransient
    public Collection<ObjetivoBVivir> getSvinObjetivoBVivirCollection() {
        return svinObjetivoBVivirCollection;
    }

    public void setSvinObjetivoBVivirCollection(Collection<ObjetivoBVivir> svinObjetivoBVivirCollection) {
        this.svinObjetivoBVivirCollection = svinObjetivoBVivirCollection;
    }

    public ObjetivoBVivir getSvobviIdPadre() {
        return svobviIdPadre;
    }

    public void setSvobviIdPadre(ObjetivoBVivir svobviIdPadre) {
        this.svobviIdPadre = svobviIdPadre;
    }

    public PlanNacional getConfiguracionPlanNacional() {
        return configuracionPlanNacional;
    }

    public void setConfiguracionPlanNacional(PlanNacional configuracionPlanNacional) {
        this.configuracionPlanNacional = configuracionPlanNacional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svobviId != null ? svobviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoBVivir)) {
            return false;
        }
        ObjetivoBVivir other = (ObjetivoBVivir) object;
        if ((this.svobviId == null && other.svobviId != null) || (this.svobviId != null && !this.svobviId.equals(other.svobviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.SvinObjetivoBVivir[ svobviId=" + svobviId + " ]";
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getOrdenDescripcion(){
        if (svobviIdPadre!=null){
            return svobviIdPadre.getOrden() + "." + orden.toString() + ". " + svobviDescripcion;
        }
        else{
            return orden.toString() + ". " + svobviDescripcion;
        }
    }

    @Override
    public int compareTo(ObjetivoBVivir o) {
        return this.orden.compareTo(o.getOrden());
    }

    
}
