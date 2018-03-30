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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVPROGRAMA_V")
@XmlRootElement
public class Programa implements Serializable {

    @SequenceGenerator(name = "SEQ_SZDTAVPROGRAMA_V", sequenceName = "SEQ_SZDTAVPROGRAMA_V", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPROGRAMA_V")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPRV_ID")
    private Integer id;
    private static final long serialVersionUID = 1L;
    @Size(max = 500)
    @Column(name = "SPRV_NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "SPRV_RESUMEN2")
    private String resumen;
    @Column(name = "SPRV_FECHA_PRESENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPresentacion;
    @Column(name = "SPRV_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "SPRV_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 3000)
    @Column(name = "SPRV_METAS")
    private String metas;
    @Size(max = 3000)
    @Column(name = "SPRV_POLITICAS")
    private String politicas;
    @Size(max = 3000)
    @Column(name = "SPRV_VIAVILIDAD_TECNICA")
    private String viabilidadTecnica;
    @Size(max = 3000)
    @Column(name = "SPRV_PERDERIA_NO_EJECUTA")
    private String perderiaNoEjecuta;
    @Size(max = 3000)
    @Column(name = "SPRV_RESULTADOS_IMPACTO")
    private String resultadosImpacto;
    @Lob
    @Column(name = "SPRV_FACTOR_C_EXITO2")
    private String factorCExito;
    @Lob
    @Column(name = "SPRV_UBICACION2")
    private String ubicacion;
    @Lob
    @Column(name = "SPRV_DIAGNOSTICO2")
    private String diagnostico;
    @Lob
    @Column(name = "SPRV_LINEA_BASE2")
    private String lineaBase;
    @Lob
    @Column(name = "SPRV_BENEFICIOS2")
    private String beneficios;
    @Size(max = 4)
    @Column(name = "SPRV_ESTADO")
    private String estado;
    @Size(max = 1)
    @Column(name = "SPRV_ESTADO_ACTIVO")
    private String estadoActivo;

    @Column(name = "SPRV_COBERTURA")
    private Integer cobertura;

    @Size(max = 1000)
    @Column(name = "SPRV_EVALUACION_CUAL")
    private String evaluacionCualitativa;

    @Column(name = "SPRV_FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "SPRV_FECHA_EVALUACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvaluacionFinal;
    @JoinColumn(name = "STVCAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp campus;
    @JoinColumn(name = "STVSUBJ_CODE", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj departamento;


    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DepartamentoPrograma> departamentoProgramaList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResponsableProyecto> responsableList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoPrograma> objetivoProgramaList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntidadEjecutoraPrograma> entidadEjecutoraList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LocalizacionPrograma> objetivosProvCanParr = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoBVivirPrograma> objetivoBVivirProyectoList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoPlanVinculaPrograma> objetivoPlanVinculacionList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstrategiaPlanVinculaPrograma> estrategiasPlanVinculacionList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarreraPrograma> carreraProgramaList;
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActividadPrograma> actividadPlanificadaList;
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndicadorEstrategiaProyecto> objetivoEstrategicoList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeccionAprendidaPrograma> leccionAprendidaList = new ArrayList<>();
    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnexoProyecto> anexoList;

    public static final String ESTADO_CREADO = "CRE";//Estado Creado
    public static final String ESTADO_CERRADO_PERFIL = "CEP";//Estado finalizado el ingreso de la información del perfil
    public static final String ESTADO_CERRADO_SEGUIMIENTO = "CES"; //Estado finalizado el proceso de seguimiento
    public static final String ESTADO_CERRADO = "CER";      //El proyecto ha sido cerrado
    public static final String ESTADO_EVALUADO = "EVA";     //Se ha registrado la evaluación final

    public static final Integer COBERTURA_NACIONAL = 1;
    public static final Integer COBERTURA_PROVINCIAL = 2;
    public static final Integer COBERTURA_CANTONAL = 3;
    public static final Integer COBERTURA_PARROQUIAL = 4;

    public final static String ESTADO_PROGRAMA_ACTIVO = "A";
    public final static String ESTADO_PROGRAMA_INACTIVO = "I";

    public Programa() {
        estado = "CRE";
        estadoActivo = "A";
        cobertura = COBERTURA_PARROQUIAL;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /*public Stvsubj getStvsubjCode() {
     return stvsubjCode;
     }

     public void setStvsubjCode(Stvsubj stvsubjCode) {
     this.stvsubjCode = stvsubjCode;
     }*/
    public String getMetas() {
        return metas;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    public String getPoliticas() {
        return politicas;
    }

    public void setPoliticas(String politicas) {
        this.politicas = politicas;
    }

    public String getViabilidadTecnica() {
        return viabilidadTecnica;
    }

    public void setViabilidadTecnica(String viabilidadTecnica) {
        this.viabilidadTecnica = viabilidadTecnica;
    }

    public String getPerderiaNoEjecuta() {
        return perderiaNoEjecuta;
    }

    public void setPerderiaNoEjecuta(String perderiaNoEjecuta) {
        this.perderiaNoEjecuta = perderiaNoEjecuta;
    }

    public String getResultadosImpacto() {
        return resultadosImpacto;
    }

    public void setResultadosImpacto(String resultadosImpacto) {
        this.resultadosImpacto = resultadosImpacto;
    }

    public String getFactorCExito() {
        return factorCExito;
    }

    public void setFactorCExito(String factorCExito) {
        this.factorCExito = factorCExito;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getLineaBase() {
        return lineaBase;
    }

    public void setLineaBase(String lineaBase) {
        this.lineaBase = lineaBase;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
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
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Programa[ id=" + id + " ]";
    }

    /*public String getStvsubjCode() {
     return stvsubjCode;
     }

     public void setStvsubjCode(String stvsubjCode) {
     this.stvsubjCode = stvsubjCode;
     }*/
 /*public Stvcamp getCampus() {
     return campus;
     }

     public void setCampus(Stvcamp campus) {
     this.campus = campus;
     }*/
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<DepartamentoPrograma> getDepartamentoProgramaList() {
        return departamentoProgramaList;
    }

    public void setDepartamentoProgramaList(List<DepartamentoPrograma> departamentoProgramaList) {
        this.departamentoProgramaList = departamentoProgramaList;
    }

    public List<ResponsableProyecto> getResponsableList() {
        return responsableList;
    }

    public void setResponsableList(List<ResponsableProyecto> responsableList) {
        this.responsableList = responsableList;
    }

    public ResponsableProyecto getDirector() {
        List<ResponsableProyecto> temp = getResponsableListByTipo(TipoResponsable.TIPO_DIRECTOR);
        if (!temp.isEmpty()) {
            return temp.get(0);
        }
        return null;
    }

    public ResponsableProyecto getCreador() {
        List<ResponsableProyecto> temp = getResponsableListByTipo(TipoResponsable.TIPO_CREADOR);
        if (!temp.isEmpty()) {
            return temp.get(0);
        }
        return null;
    }

    public ResponsableProyecto getEvaluadorFinal() {
        List<ResponsableProyecto> temp = getResponsableListByTipo(TipoResponsable.TIPO_EVALUADOR_FINAL);
        if (!temp.isEmpty()) {
            return temp.get(0);
        }
        return null;
    }

    public void asignarCreador(SegUsuario usuario) {
        if (responsableList == null) {
            responsableList = new ArrayList<>();
        }
        ResponsableProyecto resp = new ResponsableProyecto(new TipoResponsable(TipoResponsable.TIPO_CREADOR));
        resp.setPrograma(this);
        resp.setUsuario(usuario);
        responsableList.add(resp);
    }

    public void asignarDirector(SegUsuario docente, Stvsubj departamento, Stvcamp campus) {
        if (responsableList == null) {
            responsableList = new ArrayList<>();
        }
        if (getDirector() == null) {
            ResponsableProyecto svinResponsableProg = new ResponsableProyecto();
            svinResponsableProg.setPrograma(this);
            svinResponsableProg.setUsuario(docente);
            svinResponsableProg.setTipoResponsable(new TipoResponsable(TipoResponsable.TIPO_DIRECTOR));
            svinResponsableProg.setCampus(campus);
            svinResponsableProg.setDepartamento(departamento);
            responsableList.add(svinResponsableProg);
        } else {
            getDirector().setUsuario(docente);
            getDirector().setCampus(campus);
            getDirector().setDepartamento(departamento);

        }
    }

    public void asignarEvaluadorFinal(SegUsuario usuario) {
        if (responsableList == null) {
            responsableList = new ArrayList<>();
        }
        if (getEvaluadorFinal() == null) {
            ResponsableProyecto resp = new ResponsableProyecto(new TipoResponsable(TipoResponsable.TIPO_EVALUADOR_FINAL));
            resp.setPrograma(this);
            resp.setUsuario(usuario);
            responsableList.add(resp);
        } else {
            getEvaluadorFinal().setUsuario(usuario);
        }
    }

    private List<ResponsableProyecto> getResponsableListByTipo(Integer tipoResponsable) {
        List<ResponsableProyecto> temp = new ArrayList<>();
        for (ResponsableProyecto svinResponsableProg : responsableList) {
            if (svinResponsableProg.getTipoResponsable().getId().equals(tipoResponsable)) {
                temp.add(svinResponsableProg);
            }
        }
        return temp;
    }

    public List<DepartamentoPrograma> getCampusList() {
        List<DepartamentoPrograma> campusList = new ArrayList<>();
        for (DepartamentoPrograma svinDepcenproy : departamentoProgramaList) {
            if (svinDepcenproy.getDepartamento() == null && svinDepcenproy.getCampus() != null) {
                campusList.add(svinDepcenproy);
            }
        }
        return campusList;
    }

    public List<DepartamentoPrograma> getDepartamentoList() {
        List<DepartamentoPrograma> departamentoList = new ArrayList<>();
        for (DepartamentoPrograma svinDepcenproy : departamentoProgramaList) {
            if (svinDepcenproy.getDepartamento() != null && svinDepcenproy.getCampus() != null) {
                departamentoList.add(svinDepcenproy);
            }
        }
        return departamentoList;
    }

    public void eliminarSvinDepcenProy(DepartamentoPrograma svinDepcenproy) {
        departamentoProgramaList.remove(svinDepcenproy);
    }

    public void agregarSvinDepcenProy(DepartamentoPrograma svinDepcenproy) {
        departamentoProgramaList.add(svinDepcenproy);
    }

    public List<ObjetivoPrograma> getObjetivoProgramaList() {
        return objetivoProgramaList;
    }

    public void setObjetivoProgramaList(List<ObjetivoPrograma> objetivoProgramaList) {
        this.objetivoProgramaList = objetivoProgramaList;
    }

    public List<ObjetivoPrograma> getObjetivoProgramaPadreList() {
        List<ObjetivoPrograma> temp = new ArrayList<>();
        for (ObjetivoPrograma obj : objetivoProgramaList) {
            if (obj.getSvinObjetivoPadre() == null) {
                temp.add(obj);
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public void setearEstadoExpandido() {
        for (ObjetivoPrograma obj : objetivoProgramaList) {
            obj.setExpanded(!obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN));
        }
    }

    public void addObjetivoPrograma(ObjetivoPrograma obj) {
        objetivoProgramaList.add(obj);
    }

    public List<EntidadEjecutoraPrograma> getEntidadEjecutoraList() {
        return entidadEjecutoraList;
    }

    public void setEntidadEjecutoraList(List<EntidadEjecutoraPrograma> entidadEjecutoraList) {
        this.entidadEjecutoraList = entidadEjecutoraList;
    }

    public void addEntidadEjecutora(EntidadEjecutoraPrograma entidadEjecutora) {
        if (entidadEjecutoraList == null) {
            entidadEjecutoraList = new ArrayList<>();
        }
        entidadEjecutora.setPrograma(this);
        entidadEjecutoraList.add(entidadEjecutora);
    }

    public void removeEndidadEjecutora(EntidadEjecutoraPrograma entidadEjecutora) {
        entidadEjecutoraList.remove(entidadEjecutora);
    }

    public List<LocalizacionPrograma> getObjetivosProvCanParr() {
        return objetivosProvCanParr;
    }

    public List<LocalizacionPrograma> getObjetivosProvCanParrOrdenado() {
        Collections.sort(objetivosProvCanParr);
        return objetivosProvCanParr;
    }

    public void setObjetivosProvCanParr(List<LocalizacionPrograma> objetivosProvCanParr) {
        this.objetivosProvCanParr = objetivosProvCanParr;
    }

    public List<ObjetivoBVivirPrograma> getObjetivoBVivirProyectoList() {
        return objetivoBVivirProyectoList;
    }

    public void setObjetivoBVivirProyectoList(List<ObjetivoBVivirPrograma> objetivoBVivirProyectoList) {
        this.objetivoBVivirProyectoList = objetivoBVivirProyectoList;
    }

    public List<ObjetivoPlanVinculaPrograma> getObjetivoPlanVinculacionList() {
        return objetivoPlanVinculacionList;
    }

    public void setObjetivoPlanVinculacionList(List<ObjetivoPlanVinculaPrograma> objetivoPlanVinculacionList) {
        this.objetivoPlanVinculacionList = objetivoPlanVinculacionList;
    }

    public List<EstrategiaPlanVinculaPrograma> getEstrategiasPlanVinculacionList() {
        return estrategiasPlanVinculacionList;
    }

    public void setEstrategiasPlanVinculacionList(List<EstrategiaPlanVinculaPrograma> estrategiasPlanVinculacionList) {
        this.estrategiasPlanVinculacionList = estrategiasPlanVinculacionList;
    }

    public List<CarreraPrograma> getCarreraProgramaList() {
        return carreraProgramaList;
    }

    public void setCarreraProgramaList(List<CarreraPrograma> carreraProgramaList) {
        this.carreraProgramaList = carreraProgramaList;
    }

    public List<ActividadPrograma> getActividadPlanificadaList() {
        return actividadPlanificadaList;
    }

    public void setActividadPlanificadaList(List<ActividadPrograma> actividadPlanificadaList) {
        this.actividadPlanificadaList = actividadPlanificadaList;
    }

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public List<Proyecto> getProyectoActivoList() {
        List<Proyecto> temp = new ArrayList<>();
        for (Proyecto proy : proyectoList) {
            if (proy.getEstadoActivo().equals(Proyecto.ESTADO_PROYECTO_ACTIVO)) {
                temp.add(proy);
            }
        }
        return temp;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public List<IndicadorEstrategiaProyecto> getObjetivoEstrategicoList() {
        return objetivoEstrategicoList;
    }

    public void setObjetivoEstrategicoList(List<IndicadorEstrategiaProyecto> objetivoEstrategicoList) {
        this.objetivoEstrategicoList = objetivoEstrategicoList;
    }

    public IndicadorEstrategiaProyecto getIndicadorEstrategia(Integer idObjetivoEstrategico) {
        for (IndicadorEstrategiaProyecto ind : objetivoEstrategicoList) {
            if (ind.getObjetivoEstrategico().getId().equals(idObjetivoEstrategico)) {
                return ind;
            }
        }
        return null;
    }

    public List<ObjetivoEstrategico> getPerspectivaList() {
        List<ObjetivoEstrategico> temp = new ArrayList<>();

        //perspectivas
        for (IndicadorEstrategiaProyecto obj : objetivoEstrategicoList) {
            boolean encontro = false;
            ObjetivoEstrategico perspectiva = obj.getObjetivoEstrategico().getObjetivoEstrategicoPadre().getObjetivoEstrategicoPadre();
            for (ObjetivoEstrategico perspectivaTemp : temp) {
                if (perspectivaTemp.equals(perspectiva)) {
                    encontro = true;
                }
            }
            if (!encontro) {
                ObjetivoEstrategico perspectivaNuevo = new ObjetivoEstrategico(perspectiva.getId(), perspectiva.getDescripcion());
                perspectivaNuevo.setTipo(perspectiva.getTipo());
                temp.add(perspectivaNuevo);
            }
        }

        //objetivos
        for (IndicadorEstrategiaProyecto obj : objetivoEstrategicoList) {
            ObjetivoEstrategico perspectiva = null;
            ObjetivoEstrategico objetivo = obj.getObjetivoEstrategico().getObjetivoEstrategicoPadre();
            for (ObjetivoEstrategico estrategiaTemp : temp) {
                if (estrategiaTemp.equals(objetivo.getObjetivoEstrategicoPadre())) {
                    perspectiva = estrategiaTemp;
                    break;
                }
            }
            ObjetivoEstrategico objetivoNuevo = new ObjetivoEstrategico(objetivo.getId(), objetivo.getDescripcion());
            objetivoNuevo.setTipo(objetivo.getTipo());
            boolean encontro = false;
            if (perspectiva.getObjetivoEstrategicoHijoList() != null) {
                for (ObjetivoEstrategico objetivoTemp : perspectiva.getObjetivoEstrategicoHijoList()) {
                    if (objetivoTemp.equals(objetivoNuevo)) {
                        encontro = true;
                        break;
                    }
                }
            }
            if (!encontro) {
                objetivoNuevo.setObjetivoEstrategicoPadre(perspectiva);
                perspectiva.addObjetivoEstrategicoHijo(objetivoNuevo);
            }
        }

        //indicadores
        for (IndicadorEstrategiaProyecto obj : objetivoEstrategicoList) {
            ObjetivoEstrategico indicadorEstrategia = obj.getObjetivoEstrategico();
            ObjetivoEstrategico objetivo = null;
            for (ObjetivoEstrategico perspectivaTemp : temp) {
                for (ObjetivoEstrategico objetivoTemp : perspectivaTemp.getObjetivoEstrategicoHijoList()) {
                    if (objetivoTemp.equals(indicadorEstrategia.getObjetivoEstrategicoPadre())) {
                        objetivo = objetivoTemp;
                        break;
                    }
                }
                if (objetivo != null) {
                    break;
                }
            }
            ObjetivoEstrategico indicadorEstrategiaNuevo = new ObjetivoEstrategico(indicadorEstrategia.getId(), indicadorEstrategia.getDescripcion());
            indicadorEstrategiaNuevo.setTipo(indicadorEstrategia.getTipo());
            indicadorEstrategiaNuevo.setObjetivoEstrategicoPadre(objetivo);
            objetivo.addObjetivoEstrategicoHijo(indicadorEstrategiaNuevo);
        }
        return temp;
    }

    public Integer getCobertura() {
        return cobertura;
    }

    public void setCobertura(Integer cobertura) {
        this.cobertura = cobertura;
    }

    public void addObjetivosProvCanParr(LocalizacionPrograma svinZonaDetalle) {
        if (svinZonaDetalle.getProvincia() == null) {
            boolean encontro = false;
            for (LocalizacionPrograma obj : objetivosProvCanParr) {
                if (obj.getProvincia() == null) {
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                svinZonaDetalle.setPrograma(this);
                objetivosProvCanParr.add(svinZonaDetalle);
            }
        } else {
            boolean encontro = false;
            for (LocalizacionPrograma obj : objetivosProvCanParr) {
                if (obj.getProvincia().equals(svinZonaDetalle.getProvincia())) {
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                LocalizacionPrograma svinZonaDetalleNuevo = new LocalizacionPrograma(svinZonaDetalle.getProvincia());
                svinZonaDetalleNuevo.setPrograma(this);
                objetivosProvCanParr.add(svinZonaDetalleNuevo);
            }
            if (svinZonaDetalle.getCanton() != null) {
                encontro = false;
                for (LocalizacionPrograma obj : objetivosProvCanParr) {
                    if (obj.getCanton() != null && svinZonaDetalle.getCanton().equals(obj.getCanton())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    LocalizacionPrograma svinZonaDetalleNuevo = new LocalizacionPrograma(svinZonaDetalle.getCanton());
                    svinZonaDetalleNuevo.setPrograma(this);
                    objetivosProvCanParr.add(svinZonaDetalleNuevo);
                }
            }
            if (svinZonaDetalle.getParroquia() != null) {
                encontro = false;
                for (LocalizacionPrograma obj : objetivosProvCanParr) {
                    if (obj.getParroquia() != null && svinZonaDetalle.getParroquia().equals(obj.getParroquia())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    LocalizacionPrograma svinZonaDetalleNuevo = new LocalizacionPrograma(svinZonaDetalle.getParroquia());
                    svinZonaDetalleNuevo.setPrograma(this);
                    objetivosProvCanParr.add(svinZonaDetalleNuevo);
                }
            }
        }

    }

    public List<LocalizacionPrograma> getParroquiasCobertura() {
        List<LocalizacionPrograma> temp = new ArrayList<>();
        for (LocalizacionPrograma svinZonaDetalle : objetivosProvCanParr) {
            if ((cobertura.equals(COBERTURA_PARROQUIAL) && svinZonaDetalle.getParroquia() != null)
                    || (cobertura.equals(COBERTURA_CANTONAL) && svinZonaDetalle.getCanton() != null)
                    || (cobertura.equals(COBERTURA_PROVINCIAL) && svinZonaDetalle.getProvincia() != null)) {
                temp.add(svinZonaDetalle);
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public String getEstadoStr() {
        if (estado.equals(ESTADO_CREADO)) {
            return "INGRESO DE PERFIL";
        } else if (estado.equals(ESTADO_CERRADO_PERFIL)) {
            return "SEGUIMIENTO";
        } else if (estado.equals(ESTADO_CERRADO_SEGUIMIENTO)) {
            return "PROCESO DE CIERRE";
        } else if (estado.equals(ESTADO_CERRADO)) {
            return "EVALUACION FINAL";
        } else if (estado.equals(ESTADO_EVALUADO)) {
            return "FINALIZADO";
        }
        return "";
    }

    public String getEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(String estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public ObjetivoPrograma getObjetivoGeneral() {
        for (ObjetivoPrograma obj : objetivoProgramaList) {
            if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                return obj;
            }
        }
        return null;
    }

    public String getMensajePermitirSeguimiento() {
        if (estado.equals(ESTADO_CREADO)) {
            return "No se puede registrar esta información, porque el programa se encuentra en proceso de ingreso de perfil";
        }
        return "";
    }

    public String getMensajePermitirCierre() {
        String result = getMensajePermitirSeguimiento();
        if (result.equals("")) {
            if (estado.equals(ESTADO_CERRADO_PERFIL)) {
                return "No se puede registrar esta información, porque el programa se encuentra en proceso de seguimiento";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirFinalizarCierre() {
        String result = getMensajePermitirCierre();
        if (result.equals("")) {
            boolean encontro = false;
            if (getProyectoActivoList().isEmpty()){
                return "No se puede registrar esta información, porque no se ha registrado ningún proyecto dentro de este programa.";
            }
            for (Proyecto proy : getProyectoActivoList()) {
                if (!proy.isEstadoEvaluacionFinal() && !proy.isEstadoFinalizado()
                        && !proy.isEstadoNoAprobadoComision()
                        && !proy.isEstadoNoAprobadoVicerrectorado()
                        && !proy.isEstadoNoAprobadoConsejoAcademico()) {
                    encontro = true;
                }
            }
            if (encontro) {
                return "No se puede registrar esta información, porque existen proyectos de este programa que aún no han sido cerrados.";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirEvaluacionFinal() {
        String result = getMensajePermitirCierre();
        if (result.equals("")) {
            if (estado.equals(ESTADO_CERRADO_SEGUIMIENTO)) {
                return "No se puede registrar esta información, porque el programa se encuentra en proceso de cierre";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirFinalizarEvaluacionFinal() {
        String result = getMensajePermitirEvaluacionFinal();
        if (result.equals("")) {
            boolean encontro = false;
            for (Proyecto proy : getProyectoActivoList()) {
                if (!proy.isEstadoFinalizado()
                        && !proy.isEstadoNoAprobadoComision()
                        && !proy.isEstadoNoAprobadoVicerrectorado()
                        && !proy.isEstadoNoAprobadoConsejoAcademico()) {

                    encontro = true;
                }
            }
            if (encontro) {
                return "No se puede registrar esta información, porque existen proyectos de este programa que aún no han sido evaluados:";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getTotalPresupuestoUniversidadGastoPermanenteStr() {
        return decimalToString(getTotalPresupuestoUniversidadGastoPermanente());
    }

    public BigDecimal getTotalPresupuestoUniversidadGastoPermanente() {
        return getTotalPresupuestoXTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, PresupuestoProyecto.TIPO_GASTO_CORRIENTE);
    }

    public String getTotalPresupuestoUniversidadGastoNoPermanenteStr() {
        return decimalToString(getTotalPresupuestoUniversidadGastoNoPermanente());
    }

    public BigDecimal getTotalPresupuestoUniversidadGastoNoPermanente() {
        return getTotalPresupuestoXTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, PresupuestoProyecto.TIPO_GASTO_INVERSION);
    }

    public String getTotalPresupuestoEntidadAuspicianteStr() {
        return decimalToString(getTotalPresupuestoEntidadAuspiciante());
    }

    public BigDecimal getTotalPresupuestoEntidadAuspiciante() {
        return getTotalPresupuestoXTipo(PresupuestoProyecto.TIPO_APORTE_ENTIDAD_AUSPICIANTE, null);
    }

    public String getTotalPresupuestoComunidadBeneficiariaStr() {
        return decimalToString(getTotalPresupuestoComunidadBeneficiaria());
    }

    public BigDecimal getTotalPresupuestoComunidadBeneficiaria() {
        return getTotalPresupuestoXTipo(PresupuestoProyecto.TIPO_APORTE_COMUNIDAD_BENEFICIARIA, null);
    }

    public String getTotalPresupuestoEjecutadoUniversidadStr() {
        return decimalToString(getTotalPresupuestoEjecutadoUniversidad());
    }

    private BigDecimal getTotalPresupuestoEjecutadoUniversidad() {
        return getTotalPresupuestoEjecutadoXTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, null);
    }

    public String getTotalPresupuestoEjecutadoUniversidadGastoPermanenteStr() {
        return decimalToString(getTotalPresupuestoEjecutadoUniversidadGastoPermanente());
    }

    public BigDecimal getTotalPresupuestoEjecutadoUniversidadGastoPermanente() {
        return getTotalPresupuestoEjecutadoXTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, PresupuestoProyecto.TIPO_GASTO_CORRIENTE);
    }

    public String getTotalPresupuestoEjecutadoUniversidadGastoNoPermanenteStr() {
        return decimalToString(getTotalPresupuestoEjecutadoUniversidadGastoNoPermanente());
    }

    public BigDecimal getTotalPresupuestoEjecutadoUniversidadGastoNoPermanente() {
        return getTotalPresupuestoEjecutadoXTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, PresupuestoProyecto.TIPO_GASTO_INVERSION);
    }

    public String getTotalPresupuestoEjecutadoEntidadAuspicianteStr() {
        return decimalToString(getTotalPresupuestoEjecutadoEntidadAuspiciante());
    }

    public BigDecimal getTotalPresupuestoEjecutadoEntidadAuspiciante() {
        return getTotalPresupuestoEjecutadoXTipo(PresupuestoProyecto.TIPO_APORTE_ENTIDAD_AUSPICIANTE, null);
    }

    public String getTotalPresupuestoEjecutadoComunidadBeneficiariaStr() {
        return decimalToString(getTotalPresupuestoEjecutadoComunidadBeneficiaria());
    }

    public BigDecimal getTotalPresupuestoEjecutadoComunidadBeneficiaria() {
        return getTotalPresupuestoEjecutadoXTipo(PresupuestoProyecto.TIPO_APORTE_COMUNIDAD_BENEFICIARIA, null);
    }

    private BigDecimal getTotalPresupuestoXTipo(Integer tipoPresupuesto, String tipoGasto) {
        BigDecimal total = BigDecimal.ZERO;
        if (proyectoList != null) {
            for (Proyecto proy : getProyectoActivoList()) {
                if (proy.getPresupuestoProyectoList() != null) {
                    for (PresupuestoProyecto pre : proy.getPresupuestoProyectoList()) {
                        if (tipoGasto != null) {
                            if (pre.getTipo().equals(tipoPresupuesto) && pre.getTipoGasto().equals(tipoGasto)) {
                                try {
                                    total = total.add(pre.getTotal());
                                } catch (Exception e) {
                                }
                            }
                        } else if (pre.getTipo().equals(tipoPresupuesto)) {
                            try {
                                total = total.add(pre.getTotal());
                            } catch (Exception e) {
                            }
                        }
                    }
                }

            }
        }

        return total;
    }

    private BigDecimal getTotalPresupuestoEjecutadoXTipo(Integer tipoPresupuesto, String tipoGasto) {
        BigDecimal total = BigDecimal.ZERO;
        if (proyectoList != null) {
            for (Proyecto proy : getProyectoActivoList()) {
                if (proy.getPresupuestoProyectoList() != null) {
                    for (PresupuestoProyecto pre : proy.getPresupuestoProyectoList()) {
                        if (tipoGasto != null) {
                            if (pre.getTipo().equals(tipoPresupuesto) && pre.getTipoGasto().equals(tipoGasto)) {
                                try {
                                    total = total.add(pre.getTotalEjecutado());
                                } catch (Exception e) {
                                }
                            }
                        } else if (pre.getTipo().equals(tipoPresupuesto)) {
                            try {
                                total = total.add(pre.getTotalEjecutado());
                            } catch (Exception e) {
                            }
                        }
                    }
                }

            }
        }

        return total;
    }

    public String getTotalPresupuestoStr() {
        return decimalToString(getTotalPresupuesto());
    }

    private BigDecimal getTotalPresupuesto() {
        BigDecimal total = BigDecimal.ZERO;
        if (proyectoList != null) {
            for (Proyecto proy : getProyectoActivoList()) {
                total = total.add(proy.getTotalPresupuesto());
            }
        }
        return (total);
    }

    public String getTotalPresupuestoEjecutadoStr() {
        return decimalToString(getTotalPresupuestoEjecutado());
    }

    private BigDecimal getTotalPresupuestoEjecutado() {
        BigDecimal total = BigDecimal.ZERO;
        if (proyectoList != null) {
            for (Proyecto proy : getProyectoActivoList()) {
                total = total.add(proy.getTotalPresupuestoEjecutado());
            }
        }
        return (total);
    }

    private String decimalToString(BigDecimal valor) {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0.00";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }

    private String integerToString(Integer valor) {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }

    public String getTotalBeneficiariosDirectosEjecutadosHombresStr() {
        return integerToString(getTotalBeneficiariosDirectosEjecutadosHombres());
    }

    public String getTotalBeneficiariosDirectosEjecutadosMujeresStr() {
        return integerToString(getTotalBeneficiariosDirectosEjecutadosMujeres());
    }

    public String getTotalBeneficiariosDirectosEjecutadosNiniosStr() {
        return integerToString(getTotalBeneficiariosDirectosEjecutadosNinios());
    }

    public String getTotalBeneficiariosDirectosEjecutadosDiscapacidadStr() {
        return integerToString(getTotalBeneficiariosDirectosEjecutadosDiscapacidad());
    }

    public String getTotalBeneficiariosDirectosEjecutadosStr() {
        return integerToString(getTotalBeneficiariosDirectosEjecutados());
    }

    public String getTotalBeneficiariosIndirectosEjecutadosStr() {
        return integerToString(getTotalBeneficiariosIndirectosEjecutados());
    }

    public String getTotalBeneficiariosEjecutadosStr() {
        return integerToString(getTotalBeneficiariosEjecutados());
    }

    public Integer getTotalBeneficiariosDirectosEjecutadosHombres() {
        return getTotalBeneficiariosEjecutadosXTipo(0);
    }

    public Integer getTotalBeneficiariosDirectosEjecutadosMujeres() {
        return getTotalBeneficiariosEjecutadosXTipo(1);
    }

    public Integer getTotalBeneficiariosDirectosEjecutadosNinios() {
        return getTotalBeneficiariosEjecutadosXTipo(2);
    }

    public Integer getTotalBeneficiariosDirectosEjecutadosDiscapacidad() {
        return getTotalBeneficiariosEjecutadosXTipo(3);
    }

    public Integer getTotalBeneficiariosDirectosEjecutados() {
        return getTotalBeneficiariosEjecutadosXTipo(4);
    }

    public Integer getTotalBeneficiariosIndirectosEjecutados() {
        return getTotalBeneficiariosEjecutadosXTipo(5);
    }

    public Integer getTotalBeneficiariosEjecutados() {
        return getTotalBeneficiariosDirectosEjecutados() + getTotalBeneficiariosIndirectosEjecutados();
    }

    /**
     * *
     *
     * @param tipo: 0=Directos Hombres, 1=Directos Mujeres, 2=Directos Niños,
     * 3=Directos Discapacidad, 4=Total Directos, 5=Total Indirectos
     * @return
     */
    private Integer getTotalBeneficiariosEjecutadosXTipo(Integer tipo) {
        Integer result = 0;
        for (Proyecto proy : getProyectoActivoList()) {
            if (null != tipo) {
                switch (tipo) {
                    case 0:
                        if (proy.getTotalBeneficiariosDirectosEjecutadosHombres() != null) {
                            result += proy.getTotalBeneficiariosDirectosEjecutadosHombres();
                        }
                        break;
                    case 1:
                        if (proy.getTotalBeneficiariosDirectosEjecutadosMujeres() != null) {
                            result += proy.getTotalBeneficiariosDirectosEjecutadosMujeres();
                        }
                        break;
                    case 2:
                        if (proy.getTotalBeneficiariosDirectosEjecutadosNinios() != null) {
                            result += proy.getTotalBeneficiariosDirectosEjecutadosNinios();
                        }
                        break;
                    case 3:
                        if (proy.getTotalBeneficiariosDirectosEjecutadosDiscapacidad() != null) {
                            result += proy.getTotalBeneficiariosDirectosEjecutadosDiscapacidad();
                        }
                        break;
                    case 4:
                        if (proy.getTotalBeneficiariosDirectosEjecutados() != null) {
                            result += proy.getTotalBeneficiariosDirectosEjecutados();
                        }
                        break;
                    case 5:
                        if (proy.getTotalBeneficiariosIndirectosEjecutados() != null) {
                            result += proy.getTotalBeneficiariosIndirectosEjecutados();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return result;
    }

    public Integer getTotalBeneficiariosDirectosHombres() {
        return getTotalBeneficiariosXTipo(0);
    }

    public Integer getTotalBeneficiariosDirectosMujeres() {
        return getTotalBeneficiariosXTipo(1);
    }

    public Integer getTotalBeneficiariosDirectosNinios() {
        return getTotalBeneficiariosXTipo(2);
    }

    public Integer getTotalBeneficiariosDirectosDiscapacidad() {
        return getTotalBeneficiariosXTipo(3);
    }

    public Integer getTotalBeneficiariosDirectos() {
        return getTotalBeneficiariosXTipo(4);
    }

    public Integer getTotalBeneficiariosIndirectos() {
        return getTotalBeneficiariosXTipo(5);
    }

    public Integer getTotalBeneficiarios() {
        return getTotalBeneficiariosDirectos() + getTotalBeneficiariosIndirectos();
    }

    /**
     * *
     *
     * @param tipo: 0=Directos Hombres, 1=Directos Mujeres, 2=Directos Niños,
     * 3=Directos Discapacidad, 4=Total Directos, 5=Total Indirectos
     * @return
     */
    private Integer getTotalBeneficiariosXTipo(Integer tipo) {
        Integer result = 0;
        for (Proyecto proy : getProyectoActivoList()) {
            if (null != tipo) {
                switch (tipo) {
                    case 0:
                        if (proy.getNroBeneficiariosDirectosHombres() != null) {
                            result += proy.getNroBeneficiariosDirectosHombres();
                        }
                        break;
                    case 1:
                        if (proy.getNroBeneficiariosDirectosMujeres() != null) {
                            result += proy.getNroBeneficiariosDirectosMujeres();
                        }
                        break;
                    case 2:
                        if (proy.getNroBeneficiariosDirectosNinios() != null) {
                            result += proy.getNroBeneficiariosDirectosNinios();
                        }
                        break;
                    case 3:
                        if (proy.getNroBeneficiariosDirectosDiscapac() != null) {
                            result += proy.getNroBeneficiariosDirectosDiscapac();
                        }
                        break;
                    case 4:
                        if (proy.getTotalDirectos() != null) {
                            result += proy.getTotalDirectos();
                        }
                        break;
                    case 5:
                        if (proy.getNroBeneficiariosIndirectos() != null) {
                            result += proy.getNroBeneficiariosIndirectos();
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        return result;
    }

    public List<LeccionAprendidaPrograma> getLeccionAprendidaList() {
        return leccionAprendidaList;
    }

    public void setLeccionAprendidaList(List<LeccionAprendidaPrograma> leccionAprendidaList) {
        this.leccionAprendidaList = leccionAprendidaList;
    }

    public String getEvaluacionCualitativa() {
        return evaluacionCualitativa;
    }

    public void setEvaluacionCualitativa(String evaluacionCualitativa) {
        this.evaluacionCualitativa = evaluacionCualitativa;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getFechaEvaluacionFinal() {
        return fechaEvaluacionFinal;
    }

    public void setFechaEvaluacionFinal(Date fechaEvaluacionFinal) {
        this.fechaEvaluacionFinal = fechaEvaluacionFinal;
    }

    public List<Proyecto> getProyectoSinCerrarList() {
        List<Proyecto> temp = new ArrayList<>();
        for (Proyecto proy : proyectoList) {
            if (proy.getEstadoActivo().equals(Proyecto.ESTADO_PROYECTO_ACTIVO)
                    && !proy.isEstadoEvaluacionFinal()
                    && !proy.isEstadoFinalizado()) {
                temp.add(proy);
            }
        }
        return temp;
    }

    public List<Proyecto> getProyectoSinEvaluarList() {
        List<Proyecto> temp = new ArrayList<>();
        for (Proyecto proy : proyectoList) {
            if (proy.getEstadoActivo().equals(Proyecto.ESTADO_PROYECTO_ACTIVO)
                    && !proy.isEstadoFinalizado()) {
                temp.add(proy);
            }
        }
        return temp;
    }

    public List<AnexoProyecto> getAnexoList() {
        return anexoList;
    }

    public void setAnexoList(List<AnexoProyecto> anexoList) {
        this.anexoList = anexoList;
    }

    public boolean existeAnexo(AnexoProyecto anexo) {
        if (anexo.getTipo().equals(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA)) {
            return existeAnexo(anexo.getArchivoNombre(), AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA);
        } else {
            return existeAnexo(anexo.getArchivoNombre(), null);
        }

    }

    private boolean existeAnexo(String nombreArchivo, Integer tipo) {
        if (anexoList != null) {
            for (AnexoProyecto anexo : anexoList) {
                if (anexo.getArchivoNombre().trim().toUpperCase().equals(nombreArchivo.trim().toUpperCase())) {
                    if ((tipo != null && anexo.getTipo().equals(tipo))
                            || (tipo == null && !anexo.getTipo().equals(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Integer getTotalDocentesPlanificado() {
        Integer total = 0;
        for (Proyecto proy : getProyectoActivoList()) {
            try {
                total += proy.getTotalDocentesParticipantes();
            } catch (Exception e) {
            }
        }
        return total;
    }

    public Integer getTotalDocentesEjecutado() {
        Integer total = 0;
        for (Proyecto proy : getProyectoActivoList()) {
            try {
                total += proy.getTotalDocentesEjecutado();
            } catch (Exception e) {
            }
        }
        return total;
    }

    public Integer getTotalEstudiantesPlanificado() {
        Integer total = 0;
        for (Proyecto proy : getProyectoActivoList()) {
            try {
                total += proy.getTotalEstudiantesParticipantes();
            } catch (Exception e) {
            }
        }
        return total;
    }

    public Integer getTotalEstudiantesEjecutado() {
        Integer total = 0;
        for (Proyecto proy : getProyectoActivoList()) {
            try {
                total += proy.getTotalEstudiantesEjecutado();
            } catch (Exception e) {
            }
        }
        return total;
    }

    @Transient
    private Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getCoberturaStr() {
        if (null != cobertura) {
            switch (cobertura) {
                case 1:
                    return "Nacional";
                case 2:
                    return "Provincial";
                case 3:
                    return "Cantonal";
                case 4:
                    return "Parroquial";
            }
        }
        return "";
    }

    public List<LocalizacionPrograma> getLocalizacionDistinctProvinciaList() {
        List<LocalizacionPrograma> result = new ArrayList<>();
        if (objetivosProvCanParr != null && !objetivosProvCanParr.isEmpty()) {
            for (LocalizacionPrograma dep : objetivosProvCanParr) {
                boolean encontro = false;
                for (LocalizacionPrograma dep2 : result) {
                    if (dep.getProvincia() != null && dep.getProvincia().equals(dep2.getProvincia())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro && dep.getProvincia() != null) {
                    result.add(dep);
                }
            }

        }
        return result;
    }
    public List<LocalizacionPrograma> getLocalizacionDistinctCantonList() {
        List<LocalizacionPrograma> result = new ArrayList<>();
        if (objetivosProvCanParr != null && !objetivosProvCanParr.isEmpty()) {
            for (LocalizacionPrograma dep : objetivosProvCanParr) {
                boolean encontro = false;
                for (LocalizacionPrograma dep2 : result) {
                    if (dep.getCanton() != null && dep.getCanton().equals(dep2.getCanton())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro && dep.getCanton() != null) {
                    result.add(dep);
                }
            }

        }
        return result;
    }

    public List<LocalizacionPrograma> getLocalizacionDistinctParroquiaList() {
        List<LocalizacionPrograma> result = new ArrayList<>();
        if (objetivosProvCanParr != null && !objetivosProvCanParr.isEmpty()) {
            for (LocalizacionPrograma dep : objetivosProvCanParr) {
                boolean encontro = false;
                for (LocalizacionPrograma dep2 : result) {
                    if (dep.getParroquia() != null && dep.getParroquia().equals(dep2.getParroquia())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro && dep.getParroquia() != null) {
                    result.add(dep);
                }
            }

        }
        return result;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }

    public Stvsubj getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Stvsubj departamento) {
        this.departamento = departamento;
    }

    public String getDuracion() {
        String result = "";
        if (fechaFin != null && fechaInicio != null) {
            SimpleDateFormat sdfIni = new SimpleDateFormat("dd/mm/yyyy");
            SimpleDateFormat sdfFIn = new SimpleDateFormat("dd/mm/yyyy");
            sdfIni.format(fechaInicio.getTime());
            sdfFIn.format(fechaFin.getTime());
            Calendar calendarInicio = Calendar.getInstance();
            calendarInicio.setTime(this.fechaInicio);
            Calendar calendarFin = Calendar.getInstance();
            calendarFin.setTime(this.fechaFin);
            if (calendarInicio.compareTo(calendarFin) == 1) {
                fechaFin = null;
            } else {
                int mes1 = calendarInicio.get(Calendar.MONTH);
                int mes2 = calendarFin.get(Calendar.MONTH);
                int meses = 0;
                if (mes1 > mes2) {
                    meses = (12 - mes1) + mes2;
                } else {
                    meses = mes2 - mes1;
                }
                int anos = calendarFin.get(Calendar.YEAR) - calendarInicio.get(Calendar.YEAR);
                result = anos + " años y " + meses + " mes(es).";
            }
        }
        return result;
    }
    
}
