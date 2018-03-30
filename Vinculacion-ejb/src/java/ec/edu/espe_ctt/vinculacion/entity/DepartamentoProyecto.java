/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVDOCPARTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartamentoProyecto.findAll", query = "SELECT d FROM DepartamentoProyecto d"),
    @NamedQuery(name = "DepartamentoProyecto.findById", query = "SELECT d FROM DepartamentoProyecto d WHERE d.id = :id")
})
public class DepartamentoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVDOCPARTI", sequenceName = "SEQ_SZDTAVDOCPARTI", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVDOCPARTI")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVDOCPARTI_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    
    @JoinColumn(name = "STVCAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp campus;
    
    @JoinColumn(name = "STVSUBJ_CODE", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj departamento =new Stvsubj();
            
    
    @Column(name = "SZTVDOCPARTI_NUMERO")
    private Integer nroDocentes;

    public DepartamentoProyecto() {
    }

    public DepartamentoProyecto(Integer id) {
        this.id = id;
    }

    public DepartamentoProyecto(Proyecto proyecto) {
        this.proyecto= proyecto;
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

    public Stvsubj getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Stvsubj departamento) {
        this.departamento = departamento;
    }

    public Integer getNroDocentes() {
        return nroDocentes;
    }

    public void setNroDocentes(Integer nroDocentes) {
        this.nroDocentes = nroDocentes;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
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
        if (!(object instanceof DepartamentoProyecto)) {
            return false;
        }
        DepartamentoProyecto other = (DepartamentoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.DepartamentoProyecto[ id=" + id + " ]";
    }
    
}
