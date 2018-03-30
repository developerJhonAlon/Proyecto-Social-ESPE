/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVPROG_OBJ_ESTARTEGICOS")
@XmlRootElement
public class IndicadorEstrategiaProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVPROG_OBJ_ESTARTEGI", sequenceName = "SEQ_SZDTAVPROG_OBJ_ESTARTEGI", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPROG_OBJ_ESTARTEGI")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SVPOE_ID")
    private BigDecimal id;
    
    @JoinColumn(name = "SOESI_ID", referencedColumnName = "SOESI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoEstrategico objetivoEstrategico;
    
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    
    public IndicadorEstrategiaProyecto() {
    }
    public IndicadorEstrategiaProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    public IndicadorEstrategiaProyecto(Programa programa) {
        this.programa = programa;
    }
    
    public IndicadorEstrategiaProyecto(BigDecimal svpoeId) {
        this.id = svpoeId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public ObjetivoEstrategico getObjetivoEstrategico() {
        return objetivoEstrategico;
    }

    public void setObjetivoEstrategico(ObjetivoEstrategico objetivoEstrategico) {
        this.objetivoEstrategico = objetivoEstrategico;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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
        if (!(object instanceof IndicadorEstrategiaProyecto)) {
            return false;
        }
        IndicadorEstrategiaProyecto other = (IndicadorEstrategiaProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.IndicadorEstrategiaProyecto[ svpoeId=" + id + " ]";
    }
    
}