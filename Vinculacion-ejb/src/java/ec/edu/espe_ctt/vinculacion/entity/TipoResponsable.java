/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVTIPRES")
@XmlRootElement
public class TipoResponsable implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "SZTVTIPRES_CODE")
    private Integer id;
    public final static Integer TIPO_DIRECTOR=1;
    public final static Integer TIPO_PARTICIPANTE_DOCENTE=2;
    public final static Integer TIPO_COMISION_EVALUACION=3;
    public final static Integer TIPO_EVALUADOR_FINAL=4;
    public final static Integer TIPO_PARTICIPANTE_ESTUDIANTE=5;
    public final static Integer TIPO_CREADOR=6;
    
    @Column(name = "SZTVTIPRES_DESCRIP")
    private String descripcion;
    

    public TipoResponsable() {
    }
    public TipoResponsable(Integer id, String descripcion) {
        this.id=id;
        this.descripcion=descripcion;
    }
    
    public TipoResponsable(Integer id) {
        this.id=id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoResponsable)) {
            return false;
        }
        TipoResponsable other = (TipoResponsable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoResponsable[ id=" + id + " ]";
    }
    
}
