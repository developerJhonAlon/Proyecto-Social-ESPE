/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVCONPARAEVA")
@XmlRootElement
public class ConfiguracionParametrosEvaluacion implements Serializable, Comparable<ConfiguracionParametrosEvaluacion> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCONPARAEVA", sequenceName = "SEQ_SZDTAVCONPARAEVA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCONPARAEVA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCONPARAEVA_CODE")
    private Integer id;

    @Column(name = "SZTVCONPARAEVA_FECHA_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConfiguracion;

    @Size(max = 100)
    @Column(name = "SZTVCONPARAEVA_DESCRIP")
    private String descripcion;

    @Column(name = "SZTVCONPARAEVA_PUMINIRE")
    private Integer puntajeMinimoRequerido;

    @OneToMany(mappedBy = "configuracionParametrosEvaluacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParametroEvaluacion> parametroEvaluacionList;
    @OneToMany(mappedBy = "configuracionParametrosEvaluacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParametroEvaluacionFinalCabecera> parametroEvaluacionFinalCabeceraList;

    @Column(name = "SZTVCONPARAEVA_TIPO")
    private Integer tipo;

    @Size(max = 1)
    @Column(name = "SZTVCONPARAEVA_ESTADO")
    private String estado;
    
    public final static Integer TIPO_EVALUACION_INICIAL = 1;
    public final static Integer TIPO_EVALUACION_FINAL = 2;
    public final static String ESTADO_ACTIVA = "A";
    public final static String ESTADO_INACTIVA = "I";

    @Transient
    private boolean expanded;

    public ConfiguracionParametrosEvaluacion() {
        fechaConfiguracion = new Date();
    }

    public ConfiguracionParametrosEvaluacion(Integer tipo) {
        this();
        this.tipo = tipo;
        if (tipo.equals(TIPO_EVALUACION_FINAL)) {
            parametroEvaluacionFinalCabeceraList = new ArrayList<>();
            ParametroEvaluacionFinalCabecera par = new ParametroEvaluacionFinalCabecera(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_PERTINENCIA);
            par.setOrden(1);
            par.setConfiguracionParametrosEvaluacion(this);
            par.setNombre("ANÁLISIS DE PERTINENCIA, COHERENCIA Y RELEVANCIA");
            par.setDescripcion1("EVALUACIÓN DEL MARCO LÓGICO");
            par.setDescripcion2("Comprende la identificación de los elementos estratégicos (objetivos, insumos, productos, efectos e impactos), sus relaciones causales y los indicadores de riesgo que pueden influir en el éxito o en fracaso del Proyecto");
            parametroEvaluacionFinalCabeceraList.add(par);

            par = new ParametroEvaluacionFinalCabecera(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA);
            par.setOrden(2);
            par.setNombre("ANÁLISIS DE EFICACIA");
            par.setConfiguracionParametrosEvaluacion(this);
            par.setDescripcion1("EVALUACIÓN DE RESULTADOS");
            par.setDescripcion2("Los resultados se pueden confundir con los productos, pero no son exactamente lo mismo.  Los productos son bienes y servicios que el proyecto promete entregar, y el resultado es una evaluación cualitativa y cuantitativa de su suministro y calidad .");
            parametroEvaluacionFinalCabeceraList.add(par);

            par = new ParametroEvaluacionFinalCabecera(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA);
            par.setNombre("ANÁLISIS DE EFICIENCIA");
            par.setOrden(3);
            par.setConfiguracionParametrosEvaluacion(this);
            par.setDescripcion1("EVALUACIÓN DE INSUMOS, PRODUCTOS, COSTOS Y PROCESOS");
            par.setDescripcion2("Los insumos, son el conjunto de recursos que moviliza la organización para alcanzar un resultado.  Los costos en la fase previa (ex ante), son las salidas de dinero necesarias para financiar el proyecto y la fase posterior (ex post) son los gastos en que se han incurrido durante la ejecución del proyecto; los productos son los bienes o servicios proporcionados por el proyecto; y, los procesos es la forma en la cual los insumos se convierten en productos.");
            parametroEvaluacionFinalCabeceraList.add(par);

            par = new ParametroEvaluacionFinalCabecera(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_SOSTENIBILIDAD);
            par.setNombre("ANÁLISIS DE SOSTENIBILIDAD");
            par.setOrden(4);
            par.setConfiguracionParametrosEvaluacion(this);
            par.setDescripcion1("Aprendizaje, Institucionalidad , Empoderamiento");
            par.setDescripcion2("Proceso de incorporación, internalización o validación de los resultados por parte de los involucrados.  Presupone la identificación de las principales lecciones aprendidas, su discusión y validación, y su incorporación y transformación en recomendaciones para el futuro.");
            parametroEvaluacionFinalCabeceraList.add(par);

        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaConfiguracion() {
        return fechaConfiguracion;
    }

    public void setFechaConfiguracion(Date fechaConfiguracion) {
        this.fechaConfiguracion = fechaConfiguracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public Integer getPuntajeMinimoRequerido() {
        return puntajeMinimoRequerido;
    }

    public Integer getPuntajeTotalEvaluacionFinal() {
        Integer result = 0;
        for (ParametroEvaluacionFinalCabecera cab : parametroEvaluacionFinalCabeceraList) {
            try {
                result += cab.getPuntajeTotal();
            } catch (Exception e) {
            }
        }
        return result;
    }

    public Integer getPuntajeMaximoEvaluacionFinal() {
        Integer result = 0;
        for (ParametroEvaluacionFinalCabecera cab : parametroEvaluacionFinalCabeceraList) {
            try {
                result += cab.getPuntajeMaximo();
            } catch (Exception e) {
            }
        }
        return result;
    }
    public Integer getPuntajeMaximoEvaluacion() {
        Integer result = 0;
        for (ParametroEvaluacion par : parametroEvaluacionList) {
            try {
                result += par.getPuntajeMaximo();
            } catch (Exception e) {
            }
        }
        return result;
    }

    public String getPorcentajeCumplimientoEvaluacionFinalStr() {
        BigDecimal temp = BigDecimal.ZERO;
        if (getPuntajeTotalEvaluacionFinal() != 0) {
            temp = ((new BigDecimal(getPuntajeTotalEvaluacionFinal())).divide(new BigDecimal(getPuntajeMaximoEvaluacionFinal()), 10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100));
        }
        return decimalToString(temp);
    }

    private String decimalToString(BigDecimal valor) {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0.00";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }

    public void setPuntajeMinimoRequerido(Integer puntajeMinimoRequerido) {
        this.puntajeMinimoRequerido = puntajeMinimoRequerido;
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

    public void addParametroEvaluacion(ParametroEvaluacion parametroEvaluacion) {
        if (parametroEvaluacionList == null) {
            parametroEvaluacionList = new ArrayList<>();
        }
        parametroEvaluacion.setConfiguracionParametrosEvaluacion(this);
        parametroEvaluacionList.add(parametroEvaluacion);
    }

    public void removeParametroEvaluacion(ParametroEvaluacion parametroEvaluacion) {
        for (ParametroEvaluacion param : getParametroEvaluacionList()) {
            if (param.getOrden() > parametroEvaluacion.getOrden()) {
                param.setOrden(param.getOrden() - 1);
            }
        }
        parametroEvaluacionList.remove(parametroEvaluacion);
    }

    public List<ParametroEvaluacionFinalCabecera> getParametroEvaluacionFinalCabeceraList() {
        if (parametroEvaluacionFinalCabeceraList != null) {
            Collections.sort(parametroEvaluacionFinalCabeceraList);
        }
        return parametroEvaluacionFinalCabeceraList;

    }
    public List<ParametroEvaluacionFinalCabecera> getParametroEvaluacionFinalCabeceraPertinenciaList() {
        return getParametroEvaluacionFinalCabeceraListXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_PERTINENCIA);
    }
    public List<ParametroEvaluacionFinalCabecera> getParametroEvaluacionFinalCabeceraEficaciaList() {
        return getParametroEvaluacionFinalCabeceraListXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA);
    }
    public List<ParametroEvaluacionFinalCabecera> getParametroEvaluacionFinalCabeceraEficienciaList() {
        return getParametroEvaluacionFinalCabeceraListXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA);
    }
    public List<ParametroEvaluacionFinalCabecera> getParametroEvaluacionFinalCabeceraSostenibilidadList() {
        return getParametroEvaluacionFinalCabeceraListXTipo(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_SOSTENIBILIDAD);
    }
    
    private List<ParametroEvaluacionFinalCabecera> getParametroEvaluacionFinalCabeceraListXTipo(Integer tipo) {
        List<ParametroEvaluacionFinalCabecera> temp = new ArrayList<>();
        for (ParametroEvaluacionFinalCabecera cab : parametroEvaluacionFinalCabeceraList) {
            if (cab.getTipo().equals(tipo)){
                temp.add(cab);
                break;
            }
        }
        return temp;
    }
    public void setParametroEvaluacionFinalCabeceraList(List<ParametroEvaluacionFinalCabecera> parametroEvaluacionFinalCabeceraList) {
        this.parametroEvaluacionFinalCabeceraList = parametroEvaluacionFinalCabeceraList;
    }

    public void addParametroEvaluacionFinalCabecera(ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabecera) {
        if (parametroEvaluacionFinalCabeceraList == null) {
            parametroEvaluacionFinalCabeceraList = new ArrayList<>();
        }
        parametroEvaluacionFinalCabecera.setConfiguracionParametrosEvaluacion(this);
        parametroEvaluacionFinalCabeceraList.add(parametroEvaluacionFinalCabecera);
    }

    public void removeParametroEvaluacionFinalCabecera(ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabecera) {
        for (ParametroEvaluacionFinalCabecera param : getParametroEvaluacionFinalCabeceraList()) {
            if (param.getOrden() > parametroEvaluacionFinalCabecera.getOrden()) {
                param.setOrden(param.getOrden() - 1);
            }
        }
        parametroEvaluacionFinalCabeceraList.remove(parametroEvaluacionFinalCabecera);
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
        if (!(object instanceof ConfiguracionParametrosEvaluacion)) {
            return false;
        }
        ConfiguracionParametrosEvaluacion other = (ConfiguracionParametrosEvaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ConfiguracionParametrosEvaluacion[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ConfiguracionParametrosEvaluacion o) {
        return this.id.compareTo(o.getId()) * -1;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getEstadoActiva() {
        if (estado != null && estado.equals(ESTADO_ACTIVA)) {
            return true;
        }
        return false;
    }

    public void initValoracion() {
        for (ParametroEvaluacionFinalCabecera cab : parametroEvaluacionFinalCabeceraList) {
            for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                if (par.getIdAspectoEvaluacion() != null) {
                    par.initValoracion();
                }
            }

        }
    }


}
