/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * @author Jhonny
 */
@Entity
@Table(name = "SZDTAVIMPACTOTIPO", schema="SIEVAL")
@XmlRootElement
public class ImpactoEsperadoTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVAIMPACTOTIPO_CODE")
    private Integer id;
    @Size(max = 100)
    @Column(name = "SZTVAIMPACTOTIPO_DESCR")
    private String descripcion;
    @OneToMany(mappedBy = "impactoEsperadoTipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImpactoEsperado> impactoEsperadoList;

    public ImpactoEsperadoTipo() {
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
    

    @XmlTransient
    public List<ImpactoEsperado> getImpactoEsperadoList() {
        return impactoEsperadoList;
    }

    public void setImpactoEsperadoList(List<ImpactoEsperado> impactoEsperadoList) {
        this.impactoEsperadoList = impactoEsperadoList;
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
        if (!(object instanceof ImpactoEsperadoTipo)) {
            return false;
        }
        ImpactoEsperadoTipo other = (ImpactoEsperadoTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.ImpactoEsperadoTipo[ sztvaimpactotipoCode=" + id + " ]";
    }
    
}
