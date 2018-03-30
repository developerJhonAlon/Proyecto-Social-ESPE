/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVPROLIN")
@XmlRootElement
public class LineaInvestigacionProyecto implements Serializable, Comparable<LineaInvestigacionProyecto> {

    private static final long serialVersionUID = 1L;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVPROLIN", sequenceName = "SEQ_SZDTAVPROLIN", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPROLIN")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZVTAPROLIN_CODE")
    private Integer id;
    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    @JoinColumn(name = "LINEA_ID", referencedColumnName = "LINEA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaLineainves lineaInvestigacion;
    @Transient
    private boolean expanded = true;

    public LineaInvestigacionProyecto() {
    }

    public LineaInvestigacionProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public SeaLineainves getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(SeaLineainves lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
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
        if (!(object instanceof LineaInvestigacionProyecto)) {
            return false;
        }
        LineaInvestigacionProyecto other = (LineaInvestigacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.LineaInvestigacionProyecto[ id=" + id + " ]";
    }

    @Override
    public int compareTo(LineaInvestigacionProyecto o) {
        return this.id.compareTo(o.id);
    }

}
