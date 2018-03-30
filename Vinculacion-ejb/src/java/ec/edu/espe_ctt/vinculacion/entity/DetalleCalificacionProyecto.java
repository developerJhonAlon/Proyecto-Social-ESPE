/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVEVALPROY")
@XmlRootElement
public class DetalleCalificacionProyecto implements Serializable, Comparable<DetalleCalificacionProyecto> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVEVALPROY", sequenceName = "SEQ_SZDTAVEVALPROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVEVALPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVEVALPROY_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVCABEVALP_CODE", referencedColumnName = "SZTVCABEVALP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private CalificacionProyecto calificacionProyecto;

    @JoinColumn(name = "SZTVPARAEVA_CODE", referencedColumnName = "SZTVPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParametroEvaluacion parametroEvaluacion;

    @JoinColumn(name = "SZTVALORPAR_CODE", referencedColumnName = "SZTVALORPAR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ValoracionParametroEvaluacion valoracionParametroEvaluacion;

    @Column(name = "SZTVEVALPROY_PUNTAJE")
    private Integer puntaje;

    @Size(max = 250)
    @Column(name = "SZTVEVALPROY_OBSERV")
    private String observaciones;

    @Transient
    private List<DetalleCalificacionProyecto> detalleCalificacionList;

    public DetalleCalificacionProyecto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CalificacionProyecto getCalificacionProyecto() {
        return calificacionProyecto;
    }

    public void setCalificacionProyecto(CalificacionProyecto calificacionProyecto) {
        this.calificacionProyecto = calificacionProyecto;
    }

    public ValoracionParametroEvaluacion getValoracionParametroEvaluacion() {
        return valoracionParametroEvaluacion;
    }

    public void setValoracionParametroEvaluacion(ValoracionParametroEvaluacion valoracionParametroEvaluacion) {
        this.valoracionParametroEvaluacion = valoracionParametroEvaluacion;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public ParametroEvaluacion getParametroEvaluacion() {
        return parametroEvaluacion;
    }

    public void setParametroEvaluacion(ParametroEvaluacion parametroEvaluacion) {
        this.parametroEvaluacion = parametroEvaluacion;
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
        if (!(object instanceof DetalleCalificacionProyecto)) {
            return false;
        }
        DetalleCalificacionProyecto other = (DetalleCalificacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetalleCalificacionProyecto[ id=" + id + " ]";
    }

    @Override
    public int compareTo(DetalleCalificacionProyecto o) {
        return this.parametroEvaluacion.getOrden().compareTo(o.parametroEvaluacion.getOrden());
    }

    public List<DetalleCalificacionProyecto> getDetalleCalificacionList() {
        return detalleCalificacionList;
    }

    public void setDetalleCalificacionList(List<DetalleCalificacionProyecto> detalleCalificacionList) {
        this.detalleCalificacionList = detalleCalificacionList;
    }

    public void addDetalleCalificacion(DetalleCalificacionProyecto detalleCalificacionProyecto) {
        if (detalleCalificacionList == null) {
            detalleCalificacionList = new ArrayList<>();
        }
        detalleCalificacionList.add(detalleCalificacionProyecto);
    }

    public ValoracionParametroEvaluacion getValoracionParametroPromedio() {
        /*if (getParametroEvaluacion() != null && getParametroEvaluacion().getId() == 128) {
            System.out.println("aa");
        }*/

        if (detalleCalificacionList == null) {
            return new ValoracionParametroEvaluacion();
        }
        int cont = 0;
        int puntajeTotal = 0;
        for (DetalleCalificacionProyecto detalleCalificacionProyecto : detalleCalificacionList) {
            cont++;
            if (detalleCalificacionProyecto.getValoracionParametroEvaluacion() != null) {
                puntajeTotal += detalleCalificacionProyecto.getValoracionParametroEvaluacion().getPuntaje();
            }
        }
        if (cont == 0) {
            return new ValoracionParametroEvaluacion();
        }
        BigDecimal promedio = new BigDecimal(puntajeTotal).divide(new BigDecimal(cont), 10, RoundingMode.HALF_UP);

        ValoracionParametroEvaluacion valoracion1 = null;
        ValoracionParametroEvaluacion valoracion2 = null;

        List<ValoracionParametroEvaluacion> list1 = parametroEvaluacion.getValoracionList();
        Collections.sort(list1, new ValoracionParametroEvaluacionComparator());
        for (ValoracionParametroEvaluacion val : list1) {
            /*
            if (new BigDecimal(val.getPuntaje()).compareTo(promedio)<0){
                valoracion1= val;
            }
            if (new BigDecimal(val.getPuntaje()).compareTo(promedio)==0){
                if (valoracion1==null){
                    return val;
                }
                else{
                    valoracion2= val;
                    break;
                }
                
            }else if ((new BigDecimal(val.getPuntaje()).compareTo(promedio))>0){
                if (valoracion1==null){
                    valoracion1= val;
                }else{
                    valoracion2= val;
                }
                break;
            }
             */
            if (new BigDecimal(val.getPuntaje()).compareTo(promedio) == 0) {
                return val;
            }
            if (new BigDecimal(val.getPuntaje()).compareTo(promedio) < 0) {
                valoracion1 = val;
            } else if (valoracion1 == null) {
                return val;
            } else {
                valoracion2 = val;
                break;
            }
        }
        if (valoracion2 == null) {
            return valoracion1;
        }
        if (((new BigDecimal(valoracion1.getPuntaje()).add(new BigDecimal(valoracion2.getPuntaje())).divide(new BigDecimal(2)))).compareTo(promedio) > 0) {
            return valoracion1;
        } else {
            return valoracion2;
        }

    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
