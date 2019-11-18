/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "SZDTAVCONFOBJ", schema="SIEVAL")
@XmlRootElement
public class ConfiguraObjetivo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCONFOBJ_CODE")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "SZTVCONFOBJ_DESCRIPCION")
    private String descripcion;
    
    @Column(name = "SZTVCONFOBJ_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConfiguracion;
    
    @OneToMany(mappedBy = "configuraObjetivo",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoBVivir> objetivoBVivirList;
    
    @OneToMany(mappedBy = "configuraObjetivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoEstrategico> objetivoEstrategicoList;
    
    @JoinColumn(name = "SZTVCONFOBJTIPO_CODE", referencedColumnName = "SZTVCONFOBJTIPO_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConfiguraObjetivoTipo configuraObjetivoTipo;
    
    @Size(max = 1)
    @Column(name = "SZTVCONFOBJ_ESTADO")
    private String estado;
    
    public final static Integer TIPO_PLAN_NACIONAL = 1;
    public final static Integer TIPO_PLAN_ESPE = 2;
    public final static Integer TIPO_PLAN_UNESCO = 3;
    public final static Integer TIPO_PLAN_MILENIO = 4;
    public final static Integer TIPO_PLAN_DOMINIO = 5;
    public final static String ESTADO_ACTIVA = "A";
    public final static String ESTADO_INACTIVA = "I";

    public ConfiguraObjetivo() {
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

    public ConfiguraObjetivoTipo getConfiguraObjetivoTipo() {
        return configuraObjetivoTipo;
    }

    public void setConfiguraObjetivoTipo(ConfiguraObjetivoTipo configuraObjetivoTipo) {
        this.configuraObjetivoTipo = configuraObjetivoTipo;
    }

    @XmlTransient
    public List<ObjetivoBVivir> getObjetivoBVivirList() {
        return objetivoBVivirList;
    }

    public void setObjetivoBVivirList(List<ObjetivoBVivir> objetivoBVivirList) {
        this.objetivoBVivirList = objetivoBVivirList;
    }

    @XmlTransient
    public List<ObjetivoEstrategico> getObjetivoEstrategicoList() {
        return objetivoEstrategicoList;
    }

    public void setObjetivoEstrategicoList(List<ObjetivoEstrategico> objetivoEstrategicoList) {
        this.objetivoEstrategicoList = objetivoEstrategicoList;
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
        if (!(object instanceof ConfiguraObjetivo)) {
            return false;
        }
        ConfiguraObjetivo other = (ConfiguraObjetivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.ConfigurarObjetivo[ sztvconfobjCode=" + id + " ]";
    }

   
}
