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
@Table(name = "SZDTAVPARAEVA")
@XmlRootElement
public class ParametroEvaluacion implements Serializable, Comparable<ParametroEvaluacion> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVPARAEVA", sequenceName = "SEQ_SZDTAVPARAEVA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPARAEVA")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVPARAEVA_CODE")
    private Integer id;

    @Size(max = 1000)
    @Column(name = "SZTVPARAEVA_DESCRIP")
    private String descripcion;

    @Column(name = "SZTVPARAEVA_ORDEN")
    private Integer orden;

    @JoinColumn(name = "SZTVCONPARAEVA_CODE", referencedColumnName = "SZTVCONPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion;

    @JoinColumn(name = "SZTVCABPARAEVAF_CODE", referencedColumnName = "SZTVCABPARAEVAF_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabecera;

    @OneToMany(mappedBy = "parametroEvaluacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValoracionParametroEvaluacion> valoracionList;

    @Column(name = "SZTVPARAEVA_OPCMENU")
    private String opcionMenu;

    @Column(name = "SZTVPARAEVA_ASPEVA")
    private String idAspectoEvaluacion;
                /*case "1.1":
                    return "DETALLE BENEFICIARIO (DIRECTO)";
                case "2.1":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO APORTE UNIVERSIDAD)";
                case "2.2":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO APORTE UNIVERSIDAD VALORADO)";
                case "2.3":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO ENTIDAD AUSPICIANTE)";
                case "2.4":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO CONTRAPARTE-COMUNIDAD BENEFICIARIA)";*/
                
    @Size(max = 1)
    @Column(name = "SZTVPARAEVA_INFOADIC")
    private String solicitarInfoAdicional;

    @Size(max = 250)
    @Column(name = "SZTVPARAEVA_PREGINFOADIC")
    private String preguntaInfoAdicional;

    @Transient
    private boolean expanded;

    @Transient
    private ValoracionParametroEvaluacion valoracionParametroEvaluacion;
    @Transient
    private String respuestaInfoAdicional;

    public ParametroEvaluacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ValoracionParametroEvaluacion getValoracionParametroEvaluacion() {
        return valoracionParametroEvaluacion;
    }

    public void setValoracionParametroEvaluacion(ValoracionParametroEvaluacion valoracionParametroEvaluacion) {
        this.valoracionParametroEvaluacion = valoracionParametroEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<ValoracionParametroEvaluacion> getValoracionList() {
        if (valoracionList != null) {
            Collections.sort(valoracionList);
        }
        return valoracionList;
    }

    public void setValoracionList(List<ValoracionParametroEvaluacion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametroEvaluacion)) {
            return false;
        }
        ParametroEvaluacion other = (ParametroEvaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ParametroEvaluacion o) {
        return this.orden.compareTo(o.getOrden());
    }

    public void addValoracion(ValoracionParametroEvaluacion valoracionParametroEvaluacion) {
        if (valoracionList == null) {
            valoracionList = new ArrayList<>();
            valoracionParametroEvaluacion.setOrden(0);
        } else {
            valoracionParametroEvaluacion.setOrden(valoracionList.size() + 1);
        }
        valoracionParametroEvaluacion.setParametroEvaluacion(this);
        valoracionList.add(valoracionParametroEvaluacion);
    }

    public void removeValoracion(ValoracionParametroEvaluacion valoracionParametroEvaluacion) {
        for (ValoracionParametroEvaluacion valoracion : getValoracionList()) {
            if (valoracion.getOrden() > valoracionParametroEvaluacion.getOrden()) {
                valoracion.setOrden(valoracion.getOrden() - 1);
            }
        }
        valoracionList.remove(valoracionParametroEvaluacion);
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

    public ParametroEvaluacionFinalCabecera getParametroEvaluacionFinalCabecera() {
        return parametroEvaluacionFinalCabecera;
    }

    public void setParametroEvaluacionFinalCabecera(ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabecera) {
        this.parametroEvaluacionFinalCabecera = parametroEvaluacionFinalCabecera;
    }

    public void cambiarOrden(Integer cambio) {
        Integer temp = orden;
        if (cambio.equals(-1)) {
            configuracionParametrosEvaluacion.getParametroEvaluacionList().get(temp - 2).setOrden(temp);
            setOrden(temp - 1);
        } else {
            configuracionParametrosEvaluacion.getParametroEvaluacionList().get(temp).setOrden(temp);
            setOrden(temp + 1);
        }
    }

    public void cambiarOrdenEvaluacionFinal(Integer cambio) {
        Integer temp = orden;
        if (cambio.equals(-1)) {
            parametroEvaluacionFinalCabecera.getParametroEvaluacionList().get(temp - 2).setOrden(temp);
            setOrden(temp - 1);
        } else {
            parametroEvaluacionFinalCabecera.getParametroEvaluacionList().get(temp).setOrden(temp);
            setOrden(temp + 1);
        }
    }

    public String getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public String getOpcionMenuNombre() {
        if (opcionMenu == null) {
            return "";
        }
        switch (opcionMenu) {
            case "1.1":
                return "1.1. Datos Generales";
            case "1.2":
                return "1.2. Cobertura y Localización";
//            case "1.3":
//                return "1.3. Origen de los fondos";
            case "1.4":
                return "1.3. Detalle de entregables del proyecto";
            case "1.5":
                return "1.4. Impactos Esperados";
            case "2.1":
                return "2.1. Diagnóstico y Problema";
            case "2.2":
                return "2.3. Identificación de Población";
            case "2.3":
                return "2.4. Docentes Participantes";
            case "2.4":
                return "2.5. Estudiantes Participantes";
            case "3.1":
                return "3.1. Objetivos PLNBV";
            case "3.2":
                return "3.2. Objetivos Provinciales, Cantonales o Parroquiales";
            case "3.3":
                return "3.3. Objetivos Estratégicos Institucionales";
            case "3.4":
                return "4. Matriz del Marco Lógico";
            case "3.0.1":
                return "3.1. Objetivos de Desarrollo Sostenible del Milenio";
            case "3.0.2":
                return "3.2. Objetivos Plan Nacional de Desarrollo";
            case "3.0.3":
                return "3.3. Objetivos Provinciales, Cantonales o Parroquiales";
            case "3.0.4":
                return "3.4. Objetivos Estratégicos Institucionales";
            case "3.0.6":
                return "3.6. Campo de Conocimiento UNESCO";
          
            
            case "4":
                return "5. Viabilidad y Plan de Sostenibilidad";
            case "5":
                return "6. Presupuesto Detallado y Fuentes de Financiamiento";
            case "6":
                return "7. Estrategia de Ejecución-Cronograma";
            case "7":
                return "8. Acta de Consejo de Departamento";
            
            default:
                return "";
        }

    }

    public String getIdAspectoEvaluacion() {
        return idAspectoEvaluacion;
    }

    public void setIdAspectoEvaluacion(String idAspectoEvaluacion) {
        this.idAspectoEvaluacion = idAspectoEvaluacion;
    }

    public String getDescripcion2() {
        if (descripcion != null) {
            return descripcion;
        } else {
            switch (idAspectoEvaluacion) {
                case "1.1":
                    return "DETALLE BENEFICIARIO (DIRECTO)";
                case "2.1":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO APORTE UNIVERSIDAD)";
                case "2.2":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO APORTE UNIVERSIDAD VALORADO)";
                case "2.3":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO ENTIDAD AUSPICIANTE)";
                case "2.4":
                    return "DETALLE EJECUCION PRESUPUESTARIA DEL PROYECTO(PRESUPUESTO CONTRAPARTE-COMUNIDAD BENEFICIARIA)";

            }
        }
        return "";
    }

    public String getDescripcion3() {
        String temp = " Indicador: " + objetivoPrograma.getSvopIndicador() + " Tipo Indicador: ";
        if (objetivoPrograma.getIndicadorTipo() != null) {
            if (objetivoPrograma.getIndicadorTipo().equals(ObjetivoPrograma.TIPO_INDICADOR_VALOR)) {
                temp += " Valor";
            } else {
                temp += " Porcentaje";
            }

        }
        return temp;
    }

    public String getSolicitarInfoAdicional() {
        return solicitarInfoAdicional;
    }

    public void setSolicitarInfoAdicional(String solicitarInfoAdicional) {
        this.solicitarInfoAdicional = solicitarInfoAdicional;
    }

    public String getPreguntaInfoAdicional() {
        return preguntaInfoAdicional;
    }

    public void setPreguntaInfoAdicional(String preguntaInfoAdicional) {
        this.preguntaInfoAdicional = preguntaInfoAdicional;
    }

    public String getDescValor1() {
        if (idAspectoEvaluacion != null) {
            if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO)) {
                return "No. Esperado (NE)";
            } else if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO)) {
                return "Planificado (P)";
            } else {
                return "Presupuesto en Dólares (PR)";
            }

        }
        return "";
    }

    public String getValor1() {
        if (idAspectoEvaluacion != null && proyecto != null) {
            if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO)) {
                return proyecto.getTotalDirectosStr();
            } else {
                switch (idAspectoEvaluacion) {
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD:
                        return "$ " + proyecto.getTotalPresupuestoUniversidadGastoPermanenteStr();
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD_VALORADO:
                        return "$ " + proyecto.getTotalPresupuestoUniversidadGastoNoPermanenteStr();
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_ENTIDAD_AUSPICIANTE:
                        return "$ " + proyecto.getTotalPresupuestoEntidadAuspicianteStr();
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_CONTRAPARTE:
                        return "$ " + proyecto.getTotalPresupuestoComunidadBeneficiariaStr();
                    case AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO:
                        return integerToString(objetivoPrograma.getIndicadorValor());
                }
                return "$ 0,00";
            }

        }
        return "";
    }

    public String getDescValor2() {
        if (idAspectoEvaluacion != null) {
            if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO)) {
                return "No. Efectivamente (NA)";
            } else if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO)) {
                return "Ejecutado (E)";
            } else {
                return "Ejecutado en Dólares (EJ)";
            }
        }
        return "";
    }

    private String integerToString(Integer valor) {
        if (valor == null) {
            valor = 0;
        }
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }

    private String decimalToString(BigDecimal valor) {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0.00";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }

    public String getValor2() {
        if (idAspectoEvaluacion != null) {
            if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO)) {
                return proyecto.getTotalDirectosEjecutadosStr();
            } else {
                switch (idAspectoEvaluacion) {
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD:
                        return "$ " + proyecto.getTotalPresupuestoEjecutadoUniversidadGastoPermanenteStr();
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD_VALORADO:
                        return "$ " + proyecto.getTotalPresupuestoEjecutadoUniversidadGastoNoPermanenteStr();
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_ENTIDAD_AUSPICIANTE:
                        return "$ " + proyecto.getTotalPresupuestoEjecutadoEntidadAuspicianteStr();
                    case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_CONTRAPARTE:
                        return "$ " + proyecto.getTotalPresupuestoEjecutadoComunidadBeneficiariaStr();
                    case AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO:
                        return integerToString(objetivoPrograma.getIndicadorValorEjecutado());

                }
                return "$ 0,00";
            }

        }
        return "";
    }

    public String getDescValor3() {
        if (idAspectoEvaluacion != null) {
            if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO)) {
                return "Nivel de cumplimiento (NA/NE * 100)";
            } else if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO)) {
                return "Nivel de ejecución (E/P * 100)";
            } else {
                return "Nivel de ejecución (EJ/PR * 100)";
            }
        }
        return "";
    }

    public String getValor3() {
        if (idAspectoEvaluacion != null) {
            switch (idAspectoEvaluacion) {
                case AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO:
                    return (proyecto.getPorcentajeDirectosEjecutadosStr() + " %");
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD:
                    return proyecto.getPorcentajePresupuestoEjecutadoUniversidadGastoPermanenteStr() + " %";
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD_VALORADO:
                    return proyecto.getPorcentajePresupuestoEjecutadoUniversidadGastoNoPermanenteStr() + " %";
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_ENTIDAD_AUSPICIANTE:
                    return proyecto.getPorcentajePresupuestoEjecutadoEntidadAuspicianteStr() + " %";
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_CONTRAPARTE:
                    return proyecto.getPorcentajePresupuestoEjecutadoComunidadBeneficiariaStr() + " %";
                case AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO:
                    if (objetivoPrograma != null) {
                        if (objetivoPrograma.getIndicadorValor() != null && objetivoPrograma.getIndicadorValor() != 0 && objetivoPrograma.getIndicadorValorEjecutado() != null) {
                            return decimalToString((new BigDecimal(objetivoPrograma.getIndicadorValorEjecutado()).divide(new BigDecimal(objetivoPrograma.getIndicadorValor()), 10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100))) + " %";
                        } else if (objetivoPrograma.getIndicadorValor() == 0) {
                            return decimalToString(new BigDecimal(100)) + " %";
                        }
                    }
            }
        }
        return "";
    }

    @Transient
    private Proyecto proyecto;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getRespuestaInfoAdicional() {
        return respuestaInfoAdicional;
    }

    public void setRespuestaInfoAdicional(String respuestaInfoAdicional) {
        this.respuestaInfoAdicional = respuestaInfoAdicional;
    }

    public void initValoracion() {
        BigDecimal promedio = BigDecimal.ZERO;
        Integer puntajeMaximo = 0;
        if (valoracionList != null) {
            for (ValoracionParametroEvaluacion val : valoracionList) {
                if (val.getPuntaje() > puntajeMaximo) {
                    puntajeMaximo = val.getPuntaje();
                }
            }
        }

        if (idAspectoEvaluacion.equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO)) {
            if (proyecto.getTotalDirectos() != null && proyecto.getTotalDirectos() != 0) {
                promedio = ((new BigDecimal(proyecto.getTotalDirectosEjecutados())).multiply(new BigDecimal(puntajeMaximo))).divide(new BigDecimal(proyecto.getTotalDirectos()), 10, RoundingMode.HALF_UP);
            }

        } else {
            switch (idAspectoEvaluacion) {
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD:
                    //if (proyecto.getTotalPresupuestoUniversidadGastoPermanente() != null && !proyecto.getTotalPresupuestoUniversidadGastoPermanente().equals(BigDecimal.ZERO)) {
                    promedio = new BigDecimal(100);
                    if (!proyecto.getTotalPresupuestoUniversidadGastoPermanente().equals(BigDecimal.ZERO)) {
                        promedio = ((proyecto.getTotalPresupuestoEjecutadoUniversidadGastoPermanente()).multiply(new BigDecimal(puntajeMaximo))).divide(proyecto.getTotalPresupuestoUniversidadGastoPermanente(), 10, RoundingMode.HALF_UP);
                    }
                    break;
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD_VALORADO:
                    //if (proyecto.getTotalPresupuestoUniversidadGastoNoPermanente() != null && !proyecto.getTotalPresupuestoUniversidadGastoNoPermanente().equals(BigDecimal.ZERO)) {
                    promedio = new BigDecimal(100);
                    if (!proyecto.getTotalPresupuestoUniversidadGastoNoPermanente().equals(BigDecimal.ZERO)) {
                        promedio = ((proyecto.getTotalPresupuestoEjecutadoUniversidadGastoNoPermanente()).multiply(new BigDecimal(puntajeMaximo))).divide(proyecto.getTotalPresupuestoUniversidadGastoNoPermanente(), 10, RoundingMode.HALF_UP);
                    }
                    break;
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_ENTIDAD_AUSPICIANTE:
                    //if (proyecto.getTotalPresupuestoEntidadAuspiciante() != null && !proyecto.getTotalPresupuestoEntidadAuspiciante().equals(BigDecimal.ZERO)) {
                    promedio = new BigDecimal(100);
                    if (!proyecto.getTotalPresupuestoEntidadAuspiciante().equals(BigDecimal.ZERO)) {
                        promedio = ((proyecto.getTotalPresupuestoEjecutadoEntidadAuspiciante()).multiply(new BigDecimal(puntajeMaximo))).divide(proyecto.getTotalPresupuestoEntidadAuspiciante(), 10, RoundingMode.HALF_UP);
                    }
                    break;
                case AspectoEvaluacionFinal.TIPO_PRESUPUESTO_CONTRAPARTE:
                    //if (proyecto.getTotalPresupuestoComunidadBeneficiaria() != null && !proyecto.getTotalPresupuestoComunidadBeneficiaria().equals(BigDecimal.ZERO)) {
                    promedio = new BigDecimal(100);
                    if (!proyecto.getTotalPresupuestoComunidadBeneficiaria().equals(BigDecimal.ZERO)) {
                        promedio = ((proyecto.getTotalPresupuestoEjecutadoComunidadBeneficiaria()).multiply(new BigDecimal(puntajeMaximo))).divide(proyecto.getTotalPresupuestoComunidadBeneficiaria(), 10, RoundingMode.HALF_UP);
                    }
                    break;
                case AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO:
                    if (objetivoPrograma != null) {
                        if (objetivoPrograma.getIndicadorValor() != null && objetivoPrograma.getIndicadorValor() != 0 && objetivoPrograma.getIndicadorValorEjecutado() != null) {
                            promedio = ((new BigDecimal(objetivoPrograma.getIndicadorValorEjecutado())).multiply(new BigDecimal(puntajeMaximo))).divide(new BigDecimal(objetivoPrograma.getIndicadorValor()), 10, RoundingMode.HALF_UP);
                        } else if (objetivoPrograma.getIndicadorValor() == null || objetivoPrograma.getIndicadorValor() == 0) {
                            promedio = new BigDecimal(100);
                        }
                    }
                    break;
            }
        }
        valoracionParametroEvaluacion = getValoracionPromedio(promedio);
    }

    private ValoracionParametroEvaluacion getValoracionPromedio(BigDecimal promedio) {
        ValoracionParametroEvaluacion valoracion1 = null;
        ValoracionParametroEvaluacion valoracion2 = null;

        List<ValoracionParametroEvaluacion> list1 = getValoracionList();
        if (list1 != null) {
            Collections.sort(list1, new ValoracionParametroEvaluacionComparator());
            for (ValoracionParametroEvaluacion val : list1) {
                if (new BigDecimal(val.getPuntaje()).compareTo(promedio) <= 0) {
                    valoracion1 = val;
                }
                if (new BigDecimal(val.getPuntaje()).compareTo(promedio) == 0) {
                    if (valoracion1 == null) {
                        return val;
                    } else {
                        valoracion2 = val;
                        break;
                    }

                } else if ((new BigDecimal(val.getPuntaje()).compareTo(promedio)) > 0) {
                    if (valoracion1 == null) {
                        valoracion1 = val;
                    } else {
                        valoracion2 = val;
                    }
                    break;
                }
            }
        }

        if (valoracion2 == null || (valoracion1.getPuntaje().equals(valoracion2.getPuntaje()))) {
            return valoracion1;
        }
        if (((new BigDecimal(valoracion1.getPuntaje()).add(new BigDecimal(valoracion2.getPuntaje())).divide(new BigDecimal(2)))).compareTo(promedio) > 0) {
            return valoracion1;
        } else {
            return valoracion2;
        }
    }

    @Transient
    private ObjetivoPrograma objetivoPrograma;

    public ObjetivoPrograma getObjetivoPrograma() {
        return objetivoPrograma;
    }

    public void setObjetivoPrograma(ObjetivoPrograma objetivoPrograma) {
        this.objetivoPrograma = objetivoPrograma;
    }

    public Integer getPuntajeMaximo() {
        Integer result = 0;
        for (ValoracionParametroEvaluacion val : valoracionList) {
            if (val.getPuntaje() > result) {
                result = val.getPuntaje();
            }
        }
        return result;
    }
}
