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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVCABPARAEVAF")
@XmlRootElement
public class ParametroEvaluacionFinalCabecera implements Serializable, Comparable<ParametroEvaluacionFinalCabecera> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCABPARAEVAF", sequenceName = "SEQ_SZDTAVCABPARAEVAF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCABPARAEVAF")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCABPARAEVAF_CODE")
    private Integer id;

    @Size(max = 250)
    @Column(name = "SZTVCABPARAEVAF_NOMBRE")
    private String nombre;

    @Size(max = 500)
    @Column(name = "SZTVCABPARAEVAF_DESC1")
    private String descripcion1;

    @Size(max = 500)
    @Column(name = "SZTVCABPARAEVAF_DESC2")
    private String descripcion2;

    @Column(name = "SZTVCABPARAEVAF_ORDEN")
    private Integer orden;
    
    @Column(name = "SZTVCABPARAEVAF_TIPO")
    private Integer tipo;
    public final static Integer TIPO_ANALISIS_PERTINENCIA= 1;
    public final static Integer TIPO_ANALISIS_EFICACIA= 2;
    public final static Integer TIPO_ANALISIS_EFICIENCIA= 3;
    public final static Integer TIPO_ANALISIS_SOSTENIBILIDAD= 4;
    

    @JoinColumn(name = "SZTVCONPARAEVA_CODE", referencedColumnName = "SZTVCONPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion;

    @OneToMany(mappedBy = "parametroEvaluacionFinalCabecera", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParametroEvaluacion> parametroEvaluacionList;

    @Transient
    private boolean expanded;
    
    

    public ParametroEvaluacionFinalCabecera() {
    }

    public ParametroEvaluacionFinalCabecera(Integer tipo) {
        this.tipo=tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public List<ParametroEvaluacion> getParametroEvaluacionList() {
        if (parametroEvaluacionList != null) {
            Collections.sort(parametroEvaluacionList);
        }
        return parametroEvaluacionList;
    }

    public void setParametroEvaluacionList(List<ParametroEvaluacion> parametroEvaluacionList) {
        this.parametroEvaluacionList = parametroEvaluacionList;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametroEvaluacionFinalCabecera)) {
            return false;
        }
        ParametroEvaluacionFinalCabecera other = (ParametroEvaluacionFinalCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ParametroEvaluacionFinalCabecera o) {
        return this.orden.compareTo(o.getOrden());
    }

    public void addParametro(ParametroEvaluacion parametroEvaluacion) {
        if (parametroEvaluacionList == null) {
            parametroEvaluacionList = new ArrayList<>();
            parametroEvaluacion.setOrden(0);
        } else {
            parametroEvaluacion.setOrden(parametroEvaluacionList.size() + 1);
        }
        parametroEvaluacion.setParametroEvaluacionFinalCabecera(this);
        parametroEvaluacionList.add(parametroEvaluacion);
    }

    public void removeParametro(ParametroEvaluacion parametroEvaluacion) {
        for (ParametroEvaluacion param : getParametroEvaluacionList()) {
            if (param.getOrden() > parametroEvaluacion.getOrden()) {
                param.setOrden(param.getOrden() - 1);
            }
        }
        parametroEvaluacionList.remove(parametroEvaluacion);
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public ConfiguracionParametrosEvaluacion getConfiguracionParametrosEvaluacion() {
        return configuracionParametrosEvaluacion;
    }

    public void setConfiguracionParametrosEvaluacion(ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion) {
        this.configuracionParametrosEvaluacion = configuracionParametrosEvaluacion;
    }

    public void cambiarOrden(Integer cambio) {
        Integer temp = orden;
        if (cambio.equals(-1)) {
            configuracionParametrosEvaluacion.getParametroEvaluacionFinalCabeceraList().get(temp - 2).setOrden(temp);
            setOrden(temp - 1);
        } else {
            configuracionParametrosEvaluacion.getParametroEvaluacionFinalCabeceraList().get(temp).setOrden(temp);
            setOrden(temp + 1);
        }
    }

    public void removeParametroEvaluacion(ParametroEvaluacion parametroEvaluacion) {
        for (ParametroEvaluacion param : getParametroEvaluacionList()) {
            if (param.getOrden() > parametroEvaluacion.getOrden()) {
                param.setOrden(param.getOrden() - 1);
            }
        }
        parametroEvaluacionList.remove(parametroEvaluacion);
    }
    
    public Integer getPuntajeTotal(){
        Integer result = 0;
        if (parametroEvaluacionList!=null && !parametroEvaluacionList.isEmpty()){
            for (ParametroEvaluacion par : parametroEvaluacionList) {
                try {
                    result+=par.getValoracionParametroEvaluacion().getPuntaje();
                } catch (Exception e) {
                }
            }
        }
        return result;
    }
    public Integer getPuntajeMaximo(){
        Integer result = 0;
        if (parametroEvaluacionList!=null && !parametroEvaluacionList.isEmpty()){
            for (ParametroEvaluacion par : parametroEvaluacionList) {
                try {
                    result+=par.getPuntajeMaximo();
                } catch (Exception e) {
                }
            }
        }
        return result;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    
}
