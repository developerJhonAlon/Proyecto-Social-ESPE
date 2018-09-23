/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class ObjetivoBVivir implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
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


    public ObjetivoBVivir() {
    }

    public ObjetivoBVivir(BigDecimal svobviId) {
        this.svobviId = svobviId;
    }

    public BigDecimal getSvobviId() {
        return svobviId;
    }

    public void setSvobviId(BigDecimal svobviId) {
        this.svobviId = svobviId;
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
    

}
