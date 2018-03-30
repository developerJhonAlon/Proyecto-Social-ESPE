/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVPROG_OBJ")
@XmlRootElement
public class ObjetivoBVivirPrograma implements Serializable, Comparable<ObjetivoBVivirPrograma> {
    private static final long serialVersionUID = 1L;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVPROG_OBJ", sequenceName = "SEQ_SZDTAVPROG_OBJ", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPROG_OBJ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPROB_ID")
    private Integer id;
    @JoinColumn(name = "SVOBVI_ID", referencedColumnName = "SVOBVI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoBVivir objetivoBVivir;
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    @Transient
    private List<ObjetivoBVivirPrograma> svinProgObjHijos=new ArrayList<>();
    @Transient
    private boolean expanded=true;

    public ObjetivoBVivirPrograma()
    {
    }
    public ObjetivoBVivirPrograma(Proyecto proyecto)
    {
        this.proyecto= proyecto;
    }
    
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public List<ObjetivoBVivirPrograma> getSvinProgObjHijos() {
        Collections.sort(svinProgObjHijos);
        return svinProgObjHijos;
    }

    public void setSvinProgObjHijos(List<ObjetivoBVivirPrograma> svinProgObjHijos) {
        this.svinProgObjHijos = svinProgObjHijos;
    }

    public ObjetivoBVivir getObjetivoBVivir() {
        return objetivoBVivir;
    }

    public void setObjetivoBVivir(ObjetivoBVivir objetivoBVivir) {
        this.objetivoBVivir = objetivoBVivir;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
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
    
 @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoBVivirPrograma)) {
            return false;
        }
        ObjetivoBVivirPrograma other = (ObjetivoBVivirPrograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.ObjetivoBVivirPrograma[ sprobId=" + id + " ]";
    }

    @Override
    public int compareTo(ObjetivoBVivirPrograma o) {
        return this.objetivoBVivir.getOrden().compareTo(o.getObjetivoBVivir().getOrden());
    }


}
