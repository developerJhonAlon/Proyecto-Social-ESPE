/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "V_DIRECTORES_DEPTO_E")
@XmlRootElement
public class VDirectorDepartamento implements Serializable, Comparable<VDirectorDepartamento> {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;

    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;

    @JoinColumn(name = "STVSUBJ_CODE", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj departamento;

    @JoinColumn(name = "STVCAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp campus;
    
            
    public VDirectorDepartamento() {
    }

  

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public Stvsubj getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Stvsubj departamento) {
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VDirectorDepartamento)) {
            return false;
        }
        VDirectorDepartamento other = (VDirectorDepartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.VDirectorDepartamento[ id=" + id + " ]";
    }

    @Override
    public int compareTo(VDirectorDepartamento o) {
        return this.departamento.getStvsubjDesc().compareTo(o.getDepartamento().getStvsubjDesc());
    }

}
