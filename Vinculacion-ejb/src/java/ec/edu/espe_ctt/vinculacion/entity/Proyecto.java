/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVPROYEC", schema = "SIEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT s FROM Proyecto s"),
    @NamedQuery(name = "Proyecto.findById", query = "SELECT s FROM Proyecto s WHERE s.id = :id")
})
public class Proyecto implements Serializable {
  
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SZDTAVPROYEC", sequenceName = "SEQ_SZDTAVPROYEC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPROYEC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVPROYEC_CODE")
    private Integer id;
    @Column(name = "SZTVPROYEC_CODIGO")
    private String codigo;
    @Column(name = "SZTVPROYEC_SECUENCIAL")
    private Integer secuencial;

    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_NOMBRE")
    private String nombre;
    @Column(name = "SZTVPROYEC_FECHA_FIN_EJEC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacioEjecucion;
    @Column(name = "SZTVPROYEC_FECMAX_CORREC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMaximaCorreccion;
    
    @Column(name = "SZTVPROYEC_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "SZTVPROYEC_FECHA_FINALIZA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    @Column(name = "SZTVPROYEC_FECHA_C")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacionConsejoAcademico;
    @Column(name = "SZTVPROYEC_FECHA_V")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacionVicerrectorado;
    @Column(name = "SZTVPROYEC_FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "SZTVPROYEC_FECHA_EVALUACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvaluacionFinal;
    @Column(name = "SZTVPROYEC_FECHA_MAIL_AVANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecordatorioAvance;
    
    @Size(max = 25)
    @Column(name = "SZTVPROYEC_CONS_ACAD_NROACTA")
    private String nroActaAprobacionConsejoAcademico;
    @Size(max = 100)
    @Column(name = "SZTVPROYEC_NOMBRE_PDF_ACTA")
    private String pdfActaAprobacionConsejoAcademicoNombre;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_URL_PDF_ACTA")
    private String pdfActaAprobacionConsejoAcademicoUrl;
    @Size(max = 100)
    @Column(name = "SZTVPROYEC_NOMBRE_PDF_MEMO")
    private String pdfMemorandoAprobacionConsejoAcademicoNombre;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_URL_PDF_MEMO")
    private String pdfMemorandoAprobacionConsejoAcademicoUrl;
    @Size(max = 100)
    @Column(name = "SZTVPROYEC_COM_PART1_NOM")
    private String actaCompromisoDirectorProyectoNombre;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_COM_PART1_URL")
    private String actaCompromisoDirectorProyectoUrl;
    @Size(max = 100)
    @Column(name = "SZTVPROYEC_COM_PART2_NOM")
    private String actaCompromisoCarrerasNombre;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_COM_PART2_URL")
    private String actaCompromisoCarrerasUrl;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_CARTA_COM_URL")
    private String cartaCompromisoComunidadUrl;
    @Size(max = 100)
    @Column(name = "SZTVPROYEC_CARTA_COM_NOM")
    private String cartaCompromisoComunidadNombre;
    
    
    @Column(name = "SZTVPROYEC_FECHA_FINP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacionPerfil;

    @Size(max = 1)
    @Column(name = "SZTVCONPARAEVA_ADJUNTO_ACTA")
    private String adjuntarActaAprobacionConsejoAcademico;
    public static final String ADJUNTAR_ACTA_APROBACION_CONSEJO_ACADEMICO_SI = "S";
    public static final String ADJUNTAR_ACTA_APROBACION_CONSEJO_ACADEMICO_NO = "N";

    @Size(max = 1)
    @Column(name = "SZTVCONPARAEVA_ADJUNTO_MEMO")
    private String adjuntarMemorandoNotificacionConsejoAcademico;
    public static final String ADJUNTAR_MEMO_NOTIFICACION_CONSEJO_ACADEMICO_SI = "S";
    public static final String ADJUNTAR_MEMO_NOTIFICACION_CONSEJO_ACADEMICO_NO = "N";

    @Size(max = 250)
    @Column(name = "SZTVPROYEC_OBSERVACIO_C")
    private String observacionAprobacionConsejoAcademico;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_OBSERVACIO_V")
    private String observacionAprobacionVicerrectorado;

    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_VIABILIDAD")
    private String viabilidadTecnica;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_PERDERIA")
    private String perderiaPais;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_RESULTADOS")
    private String resultadosEsperados;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_IMPACTOA")
    private String impactoAmbiental;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_SOSTENIBILIDAD")
    private String sostenibilidadSocial;
    @Lob
    @Column(name = "SZTVPROYEC_SITUACTUAL2")
    private String areaIntervencion2;
    @Lob
    @Column(name = "SZTVPROYEC_DIAGNOSTICO2")
    private String diagnosticoProblema2;
    @Lob
    @Column(name = "SZTVPROYEC_LINEABASE2")
    private String lineaBase;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_POBLACION_DESC")
    private String descripcionPoblacion;
    @Column(name = "SZTVPROYEC_DIRECTOS_HOMBRES")
    private Integer nroBeneficiariosDirectosHombres;
    @Column(name = "SZTVPROYEC_DIRECTOS_MUJERES")
    private Integer nroBeneficiariosDirectosMujeres;
    @Column(name = "SZTVPROYEC_DIRECTOS_NINIOS")
    private Integer nroBeneficiariosDirectosNinios;
    @Column(name = "SZTVPROYEC_DIRECTOS_DISCAPAC")
    private Integer nroBeneficiariosDirectosDiscapac;
    @Column(name = "SZTVPROYEC_INDIRECTOS")
    private Integer nroBeneficiariosIndirectos;

    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_FACTORESC")
    private String factoresCriticos;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_RESTRICION")
    private String restricciones;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_BIENES")
    private String bienes;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_SERVICIOS")
    private String servicios;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_BIEN_SERVICIO")
    private String bienesServicios;
    @Size(max = 3000)
    @Column(name = "SZTVPROYEC_EFECTO_ESPERADO")
    private String efectoEsperado;
    @Column(name = "SZTVPROYEC_TIPO_PROY")
    private String tipo;
    public static final String TIPO_GASTO_NO_PERMANENTE = "I";
    public static final String TIPO_GASTO_PERMANENTE = "C";

    @Size(max = 100)
    @Column(name = "SZTVPROYEC_APROB_CON_DEP_NOM")
    private String nombreDocAprobacionConcejoDep;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_APROB_CON_DEP_URL")
    private String urlDocAprobacionConcejoDep;
    @Size(max = 25)
    @Column(name = "SZTVPROYEC_APROB_CON_DEP_NRO")
    private String nroActaAprobacionConsejoDep;
    @Column(name = "SZTVPROYEC_APROB_CON_DEP_FEC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActaAprobacionConsejoDep;

    @Size(max = 100)
    @Column(name = "SZTVPROYEC_APROB_VIITT_NOM")
    private String nombreDocAprobacionVicerrectorado;
    @Size(max = 250)
    @Column(name = "SZTVPROYEC_APROB_VIITT_URL")
    private String urlDocAprobacionVicerrectorado;
    @Size(max = 25)
    @Column(name = "SZTVPROYEC_APROB_VIITT_NRO")
    private String nroActaAprobacionVicerrectorado;
    @Column(name = "SZTVPROYEC_APROB_VIITT_FEC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActaAprobacionVicerrectorado;
    
    @JoinColumn(name = "STVCAMP_CODE", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp campus;
    @JoinColumn(name = "STVSUBJ_CODE", referencedColumnName = "STVSUBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvsubj departamento;
    @JoinColumn(name = "SCONV_ID", referencedColumnName = "SCONV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Convocatoria convocatoria;
    @JoinColumn(name = "SZTVCABCOMCA_CODE", referencedColumnName = "SZTVCABCOMCA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ComisionCalificacion comisionCalificacion;
    @JoinColumn(name = "SZTVCONPARAEVA_CODE", referencedColumnName = "SZTVCONPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion;
    @JoinColumn(name = "SZTVCONPARAEVAF_CODE", referencedColumnName = "SZTVCONPARAEVA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionFinal;

    
    
    /*@Size(max = 5)
    @Column(name = "SZTVPROYEC_ESTADO")
    private String estado;
    */
    
    /*public static final String ESTADO_CREADO = "CRE";//Estado Creado
    public static final String ESTADO_REVISION = "REV";//Estado enviado a revision, luego de la calificacion por la comision de vinculacion.
    public static final String ESTADO_CERRADO_PERFIL = "CEP";//Estado finalizado el ingreso de la información del perfil
    public static final String ESTADO_CERRADO_CALIFICACION = "CEC";//Estado finalizado el proceso de calificación
    public static final String ESTADO_RECHAZADO_COMISION_VINCULACION = "REC0";//No Aprobado luego de consolidacion de la calificacion de la omision de vinculacion
    public static final String ESTADO_APROBADO_COMISION_VINCULACION = "APR0";//Aprobado luego de consolidacion de la calificacion de la comision de vinculacion
    public static final String ESTADO_RECHAZADO_VICERRECTORADO = "REC1";  //Los proyectos que fueron rechazadados por Vicerrectorado
    public static final String ESTADO_APROBADO_VICERRECTORADO = "APR1";   //Los proyectos que fueron aprobados por Vicerrectorado
    public static final String ESTADO_RECHAZADO_CONSEJO_ACADEMICO = "REC2";  //Los proyectos que fueron rechazadados por el Consejo Académico
    public static final String ESTADO_APROBADO_CONSEJO_ACADEMICO = "APR2";   //Los proyectos que fueron aprobados por el Consejo Académico
    public static final String ESTADO_CERRADO_EJECUCION = "CEE"; //Estado finalizado el proceso de ejecucion
    public static final String ESTADO_CERRADO = "CER";      //El proyecto ha sido cerrado
    public static final String ESTADO_EVALUADO = "EVA";     //Se ha registrado la evaluación final

    */
    
    
            
    
    @Size(max = 1)
    @Column(name = "SZTVPROYEC_ESTADO_ACTIVO")
    private String estadoActivo;
    public final static String ESTADO_PROYECTO_ACTIVO = "A";
    public final static String ESTADO_PROYECTO_INACTIVO = "I";

    @Size(max = 1000)
    @Column(name = "SZTVPROYEC_MENSAJE_CORREO")
    private String mensajeCorreo;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_ASUNTO_CORREO")
    private String asuntoCorreo;
    @Size(max = 100)
    @Column(name = "SZTVPROYEC_DIRECCION_CORREO")
    private String direccionCorreo;

    /*@Column(name = "SZTVPROYEC_COBERTURA")
    private Integer cobertura;
    public static final Integer COBERTURA_NACIONAL = 1;
    public static final Integer COBERTURA_PROVINCIAL = 2;
    public static final Integer COBERTURA_CANTONAL = 3;
    public static final Integer COBERTURA_PARROQUIAL = 4;*/

    @Size(max = 500)
    @Column(name = "SZTVPROYEC_CIERRE_PROD")
    private String cierreProductos;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_CIERRE_BIEN")
    private String cierreBienes;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_CIERRE_RESUL")
    private String cierreResultados;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_CIERRE_APLIC")
    private String cierreOtrasAplicaciones;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_CIERRE_IMP")
    private String cierreImpactoFuturo;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_CIERRE_REST")
    private String cierreRestricciones;
    @Size(max = 500)
    @Column(name = "SZTVPROYEC_CIERRE_COMEN")
    private String cierreComentarios;
    @JoinColumn(name = "STVMAJR_CODE", referencedColumnName = "STVMAJR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvmajr carrera;
    @JoinColumn(name = "PRD_ID", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet estado;
    @JoinColumn(name = "PRD_ID_COBERTURA", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet cobertura2;
    @JoinColumn(name = "SZDTAVACTAPRUEBA_CODE", referencedColumnName = "SZDTAVACTAPRUEBA_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActaAprobacionVicerrectorado actaAprobacionVicerrectorado;
    
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResponsableProyecto> responsableList = new ArrayList<>();
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoBVivirPrograma> objetivoBVivirProyectoList = new ArrayList<>();
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndicadorEstrategiaProyecto> objetivoEstrategicoList = new ArrayList<>();
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LocalizacionPrograma> objetivosProvCanParr = new ArrayList<>();
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoPrograma> objetivoProyectoList = new ArrayList<>();
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HitoProyecto> hitoProyectoList = new ArrayList<>();
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PresupuestoProyecto> presupuestoProyectoList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TipoPoblacionProyecto> tipoPoblacionList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalificacionProyecto> calificacionList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsolidacionCalificacionProyecto> consolidacionCalificacioList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DepartamentoProyecto> departamentoProyectoList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarreraProyecto> carreraProyectoList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionFinalProyecto> evaluacionFinalList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaInvestigacionProyecto> lineaInvestigacionProyectoList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnexoProyecto> anexoProyectoList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompromisoParticipacionProyecto> compromisoParticipacionList;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImpactoEsperado> impactoEsperadoList;
    
    @Transient
    private List<SeaLineainves> lineaInvestigacionList;
    @Transient
    private List<AnexoProyecto> anexoDiagnosticoProblemaList;
    @Transient
    private List<AnexoProyecto> anexoDocumentoProyectoList;

    public Proyecto() {
        estado= new SeaParametrosDet(SeaParametrosDet.ESTADO_CREADO);
        estadoActivo = ESTADO_PROYECTO_ACTIVO;
        cobertura2 = new SeaParametrosDet(SeaParametrosDet.COBERTURA_PARROQUIAL);
    }

    public Proyecto(Integer id) {
        this.id = id;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    /*public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getDuracion() {
        String result = "";
        if (fechaFinalizacion != null && fechaInicio != null) {
            SimpleDateFormat sdfIni = new SimpleDateFormat("dd/mm/yyyy");
            SimpleDateFormat sdfFIn = new SimpleDateFormat("dd/mm/yyyy");
            sdfIni.format(fechaInicio.getTime());
            sdfFIn.format(fechaFinalizacion.getTime());
            Calendar calendarInicio = Calendar.getInstance();
            calendarInicio.setTime(this.fechaInicio);
            Calendar calendarFin = Calendar.getInstance();
            calendarFin.setTime(this.fechaFinalizacion);
            if (calendarInicio.compareTo(calendarFin) == 1) {
                fechaFinalizacion = null;
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
    
     public int[] getDuracionNum() {
        
        if (fechaFinalizacion != null && fechaInicio != null) {
            SimpleDateFormat sdfIni = new SimpleDateFormat("dd/mm/yyyy");
            SimpleDateFormat sdfFIn = new SimpleDateFormat("dd/mm/yyyy");
            sdfIni.format(fechaInicio.getTime());
            sdfFIn.format(fechaFinalizacion.getTime());
            Calendar calendarInicio = Calendar.getInstance();
            calendarInicio.setTime(this.fechaInicio);
            Calendar calendarFin = Calendar.getInstance();
            calendarFin.setTime(this.fechaFinalizacion);
            if (calendarInicio.compareTo(calendarFin) == 1) {
                fechaFinalizacion = null;
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
                int[] dur = {anos,meses};
                return dur;
            }
        }
        return null;
    }
    

    public String getViabilidadTecnica() {
        return viabilidadTecnica;
    }

    public void setViabilidadTecnica(String viabilidadTecnica) {
        this.viabilidadTecnica = viabilidadTecnica;
    }

    public String getPerderiaPais() {
        return perderiaPais;
    }

    public void setPerderiaPais(String perderiaPais) {
        this.perderiaPais = perderiaPais;
    }

    public String getResultadosEsperados() {
        return resultadosEsperados;
    }

    public void setResultadosEsperados(String resultadosEsperados) {
        this.resultadosEsperados = resultadosEsperados;
    }

    public String getImpactoAmbiental() {
        return impactoAmbiental;
    }

    public void setImpactoAmbiental(String impactoAmbiental) {
        this.impactoAmbiental = impactoAmbiental;
    }

    public String getSostenibilidadSocial() {
        return sostenibilidadSocial;
    }

    public void setSostenibilidadSocial(String sostenibilidadSocial) {
        this.sostenibilidadSocial = sostenibilidadSocial;
    }

    public String getLineaBase() {
        return lineaBase;
    }

    public void setLineaBase(String lineaBase) {
        this.lineaBase = lineaBase;
    }

    public String getFactoresCriticos() {
        return factoresCriticos;
    }

    public void setFactoresCriticos(String factoresCriticos) {
        this.factoresCriticos = factoresCriticos;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getBienes() {
        return bienes;
    }

    public void setBienes(String bienes) {
        this.bienes = bienes;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getBienesServicios() {
        return bienesServicios;
    }

    public void setBienesServicios(String bienesServicios) {
        this.bienesServicios = bienesServicios;
    }

    public List<ResponsableProyecto> getResponsableList() {
        return responsableList;
    }

    public void setResponsableList(List<ResponsableProyecto> responsableList) {
        this.responsableList = responsableList;
    }

    public String getDescripcionPoblacion() {
        return descripcionPoblacion;
    }

    public void setDescripcionPoblacion(String descripcionPoblacion) {
        this.descripcionPoblacion = descripcionPoblacion;
    }
       
    public Integer getNroBeneficiariosDirectosHombres() {
        return nroBeneficiariosDirectosHombres;
    }

    public void setNroBeneficiariosDirectosHombres(Integer nroBeneficiariosDirectosHombres) {
        this.nroBeneficiariosDirectosHombres = nroBeneficiariosDirectosHombres;
    }

    public Integer getNroBeneficiariosDirectosMujeres() {
        return nroBeneficiariosDirectosMujeres;
    }

    public void setNroBeneficiariosDirectosMujeres(Integer nroBeneficiariosDirectosMujeres) {
        this.nroBeneficiariosDirectosMujeres = nroBeneficiariosDirectosMujeres;
    }

    public Integer getNroBeneficiariosDirectosDiscapac() {
        return nroBeneficiariosDirectosDiscapac;
    }

    public void setNroBeneficiariosDirectosDiscapac(Integer nroBeneficiariosDirectosDiscapac) {
        this.nroBeneficiariosDirectosDiscapac = nroBeneficiariosDirectosDiscapac;
    }

    /*public Integer getNroBeneficiariosIndirectosHombres() {
        return nroBeneficiariosIndirectosHombres;
    }

    public void setNroBeneficiariosIndirectosHombres(Integer nroBeneficiariosIndirectosHombres) {
        this.nroBeneficiariosIndirectosHombres = nroBeneficiariosIndirectosHombres;
    }

    public Integer getNroBeneficiariosIndirectosMujeres() {
        return nroBeneficiariosIndirectosMujeres;
    }

    public void setNroBeneficiariosIndirectosMujeres(Integer nroBeneficiariosIndirectosMujeres) {
        this.nroBeneficiariosIndirectosMujeres = nroBeneficiariosIndirectosMujeres;
    }

    public Integer getNroBeneficiariosIndirectosDiscapac() {
        return nroBeneficiariosIndirectosDiscapac;
    }

    public void setNroBeneficiariosIndirectosDiscapac(Integer nroBeneficiariosIndirectosDiscapac) {
        this.nroBeneficiariosIndirectosDiscapac = nroBeneficiariosIndirectosDiscapac;
    }
     */
    public List<IndicadorEstrategiaProyecto> getObjetivoEstrategicoList() {
        return objetivoEstrategicoList;
    }
    
    public List<ObjetivoEstrategico> getPlanMilenioList(){
        return getPerspectivaListNivelDos(ConfiguraObjetivo.TIPO_PLAN_MILENIO);
    }
    
    public List<ObjetivoEstrategico> getPlanDominiosList(){
        return getPerspectivaListNivelDos(ConfiguraObjetivo.TIPO_PLAN_DOMINIO);
    }
        
     public List<ObjetivoEstrategico> getPlanUnescoList(){
        return getPerspectivaList(ConfiguraObjetivo.TIPO_PLAN_UNESCO);
    }
    public List<ObjetivoEstrategico> getPlanEspeList(){
        return getPerspectivaList(ConfiguraObjetivo.TIPO_PLAN_ESPE);
    }
    
    
    
    public List<ObjetivoEstrategico> getPerspectivaListNivelDos(Integer tipoObjetivo) {
         List<ObjetivoEstrategico> temp = new ArrayList<>();
        List<IndicadorEstrategiaProyecto> tempTipos = new ArrayList<>();
        
        for (IndicadorEstrategiaProyecto tempTipo : objetivoEstrategicoList) {
            if(tempTipo.getObjetivoEstrategico().getConfiguraObjetivo().getConfiguraObjetivoTipo().getId().equals(tipoObjetivo)){tempTipos.add(tempTipo);}
        }
       
        //perspectivas
        for (IndicadorEstrategiaProyecto obj : tempTipos) {
            boolean encontro = false;
            
            ObjetivoEstrategico perspectiva = obj.getObjetivoEstrategico().getObjetivoEstrategicoPadre();
            
            for (ObjetivoEstrategico perspectivaTemp : temp) {
                if (perspectivaTemp.equals(perspectiva) ) {
                    encontro = true;
                }
            }
            if (!encontro) {
                ObjetivoEstrategico perspectivaNuevo = new ObjetivoEstrategico(perspectiva.getId(), perspectiva.getDescripcion());
                temp.add(perspectivaNuevo);
            }
        }
//
 //objetivos
        for (IndicadorEstrategiaProyecto obj : tempTipos) {
            ObjetivoEstrategico perspectiva = null;
            ObjetivoEstrategico objetivo = obj.getObjetivoEstrategico();
            
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
        return temp;
    }

            
            
    public List<ObjetivoEstrategico> getPerspectivaList(Integer tipoObjetivo) {
        List<ObjetivoEstrategico> temp = new ArrayList<>();
        List<IndicadorEstrategiaProyecto> tempTipos = new ArrayList<>();
        
        for (IndicadorEstrategiaProyecto tempTipo : objetivoEstrategicoList) {
            if(tempTipo.getObjetivoEstrategico().getConfiguraObjetivo().getConfiguraObjetivoTipo().getId().equals(tipoObjetivo)){tempTipos.add(tempTipo);}
        }

        //perspectivas
        for (IndicadorEstrategiaProyecto obj : tempTipos) {
            boolean encontro = false;
            
            ObjetivoEstrategico perspectiva = obj.getObjetivoEstrategico().getObjetivoEstrategicoPadre().getObjetivoEstrategicoPadre();
            //Solo es equals(perspectivaTemp.equals(perspectiva)) porque es el primer registro.
            for (ObjetivoEstrategico perspectivaTemp : temp) {
                if (perspectivaTemp.equals(perspectiva) ) {
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
        for (IndicadorEstrategiaProyecto obj : tempTipos) {
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
        for (IndicadorEstrategiaProyecto obj : tempTipos) {
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

    public void setObjetivoEstrategicoList(List<IndicadorEstrategiaProyecto> objetivoEstrategicoList) {
        this.objetivoEstrategicoList = objetivoEstrategicoList;
    }

    public Integer getTotalDirectos() {
        Integer result = 0;
        if (nroBeneficiariosDirectosHombres != null) {
            result += nroBeneficiariosDirectosHombres;
        }
        if (nroBeneficiariosDirectosMujeres != null) {
            result += nroBeneficiariosDirectosMujeres;
        }
        if (nroBeneficiariosDirectosNinios != null) {
            result += nroBeneficiariosDirectosNinios;
        }
        if (nroBeneficiariosDirectosDiscapac != null) {
            result += nroBeneficiariosDirectosDiscapac;
        }
        return result;
    }

    public Integer getTotalBeneficiariosPlanificado() {
        if (getNroBeneficiariosIndirectos() != null) {
            return getTotalDirectos() + getNroBeneficiariosIndirectos();
        } else {
            return getTotalDirectos();
        }
    }

    public Integer getTotalDirectosEjecutados() {
        Integer result = 0;
        for (CompromisoParticipacionProyecto com : getNumericoBeneficiarioList()) {
            result += com.getTotalBeneficiariosDirectos();
        }
        return result;
    }

    public String getTotalDirectosStr() {
        return integerToString(getTotalDirectos());
    }

    public String getPorcentajeDirectosEjecutadosStr() {
        BigDecimal temp = BigDecimal.ZERO;
        if (getTotalDirectos() != 0) {
            temp = ((new BigDecimal(getTotalDirectosEjecutados())).divide(new BigDecimal(getTotalDirectos()), 10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100));
        }
        return decimalToString(temp);
    }

    public String getPorcentajePresupuestoEjecutadoUniversidadGastoPermanenteStr() {
        BigDecimal temp = new BigDecimal(100);
        if (!getTotalPresupuestoUniversidadGastoPermanente().equals(BigDecimal.ZERO)) {
            temp = (getTotalPresupuestoEjecutadoUniversidadGastoPermanente().divide(getTotalPresupuestoUniversidadGastoPermanente(), 10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100));
        }
        return decimalToString(temp);
    }

    public String getPorcentajePresupuestoEjecutadoUniversidadGastoNoPermanenteStr() {
        BigDecimal temp = new BigDecimal(100);
        if (!getTotalPresupuestoUniversidadGastoNoPermanente().equals(BigDecimal.ZERO)) {
            temp = (getTotalPresupuestoEjecutadoUniversidadGastoNoPermanente().divide(getTotalPresupuestoUniversidadGastoNoPermanente(), 10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100));
        }
        return decimalToString(temp);
    }

    public String getPorcentajePresupuestoEjecutadoEntidadAuspicianteStr() {
        BigDecimal temp = new BigDecimal(100);
        if (!getTotalPresupuestoEntidadAuspiciante().equals(BigDecimal.ZERO)) {
            temp = (getTotalPresupuestoEjecutadoEntidadAuspiciante().divide(getTotalPresupuestoEntidadAuspiciante(), 10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100));
        }
        return decimalToString(temp);
    }

    public String getPorcentajePresupuestoEjecutadoComunidadBeneficiariaStr() {
        BigDecimal temp = new BigDecimal(100);
        if (!getTotalPresupuestoComunidadBeneficiaria().equals(BigDecimal.ZERO)) {
            temp = (getTotalPresupuestoEjecutadoComunidadBeneficiaria().divide(getTotalPresupuestoComunidadBeneficiaria(), 10, RoundingMode.HALF_UP)).multiply(new BigDecimal(100));
        }
        return decimalToString(temp);
    }

    public String getTotalDirectosEjecutadosStr() {
        return integerToString(getTotalDirectosEjecutados());
    }

    /*public Integer getTotalIndirectos() {
        Integer result = 0;
        if (nroBeneficiariosIndirectosHombres != null) {
            result += nroBeneficiariosIndirectosHombres;
        }
        if (nroBeneficiariosIndirectosMujeres != null) {
            result += nroBeneficiariosIndirectosMujeres;
        }
        if (nroBeneficiariosIndirectosNinios != null) {
            result += nroBeneficiariosIndirectosNinios;
        }
        if (nroBeneficiariosIndirectosDiscapac != null) {
            result += nroBeneficiariosIndirectosDiscapac;
        }
        return result;
    }*/
    public List<ObjetivoBVivirPrograma> getObjetivoBVivirProyectoList() {
        return objetivoBVivirProyectoList;
    }

    public void setObjetivoBVivirProyectoList(List<ObjetivoBVivirPrograma> objetivoBVivirProyectoList) {
        this.objetivoBVivirProyectoList = objetivoBVivirProyectoList;
    }

    public void addObjetivoBVivir(ObjetivoBVivirPrograma objetivoBVivirProyecto) {
        estadoExpandidoObjetivoBVivir.put(objetivoBVivirProyecto.getObjetivoBVivir().getSvobviIdPadre().getSvobviId(), Boolean.TRUE);
        objetivoBVivirProyectoList.add(objetivoBVivirProyecto);
    }

    public void removeObjetivoBVivir(ObjetivoBVivirPrograma objetivoBVivirProyecto) {
        setearObjetivoBVivirProyectoPadreList();
        objetivoBVivirProyectoList.remove(objetivoBVivirProyecto);
    }

    public void setearObjetivoBVivirProyectoPadreList() {
        objetivoBVivirProyectoPadreList = new ArrayList<>();

        for (ObjetivoBVivirPrograma svinProgObjHijo : objetivoBVivirProyectoList) {
            boolean encontro = false;
            for (ObjetivoBVivirPrograma svinProgObjPadre : objetivoBVivirProyectoPadreList) {

                if (svinProgObjHijo.getObjetivoBVivir().getSvobviIdPadre().getSvobviId().equals(svinProgObjPadre.getObjetivoBVivir().getSvobviId())) {
                    svinProgObjPadre.getSvinProgObjHijos().add(svinProgObjHijo);
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                ObjetivoBVivirPrograma svinProgObjPadreNuevo = new ObjetivoBVivirPrograma();
                svinProgObjPadreNuevo.setPrograma(svinProgObjHijo.getPrograma());
                svinProgObjPadreNuevo.setObjetivoBVivir(svinProgObjHijo.getObjetivoBVivir().getSvobviIdPadre());
                svinProgObjPadreNuevo.getSvinProgObjHijos().add(svinProgObjHijo);
                objetivoBVivirProyectoPadreList.add(svinProgObjPadreNuevo);
            }
        }
    }

    public void addObjetivoEstrategico(IndicadorEstrategiaProyecto objetivoEstrategico) {
        objetivoEstrategicoList.add(objetivoEstrategico);
    }

    public void removeObjetivoEstrategico(IndicadorEstrategiaProyecto objetivoEstrategico) {
        objetivoEstrategicoList.remove(objetivoEstrategico);
    }

    public List<LocalizacionPrograma> getObjetivosProvCanParr() {
        return objetivosProvCanParr;
    }

    public void setObjetivosProvCanParr(List<LocalizacionPrograma> objetivosProvCanParr) {
        this.objetivosProvCanParr = objetivosProvCanParr;
    }

    public List<LocalizacionPrograma> getObjetivosProvCanParrOrdenado() {
        Collections.sort(objetivosProvCanParr);
        return objetivosProvCanParr;
    }

    public List<ObjetivoPrograma> getObjetivoProyectoList() {
        return objetivoProyectoList;
    }

    public void setObjetivoProyectoList(List<ObjetivoPrograma> objetivoProyectoList) {
        this.objetivoProyectoList = objetivoProyectoList;
    }

    public List<ObjetivoPrograma> getObjetivoProyectoPadreList() {
        List<ObjetivoPrograma> temp = new ArrayList<>();
        for (ObjetivoPrograma obj : objetivoProyectoList) {
            if (obj.getSvinObjetivoPadre() == null) {
                temp.add(obj);
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public List<ObjetivoPrograma> getComponentes() {
        return getObjetivosByTipo(ObjetivoPrograma.TIPO_COMPONENTE);
    }
    public List<ObjetivoPrograma> getActividades() {
        return getObjetivosByTipo(ObjetivoPrograma.TIPO_ACTIVIDAD);
    }
    private List<ObjetivoPrograma> getObjetivosByTipo(Integer tipo) {
        List<ObjetivoPrograma> temp = new ArrayList<>();
        for (ObjetivoPrograma obj : objetivoProyectoList) {
            if (obj.getSvopTipo().equals(tipo)) {
                temp.add(obj);
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public void addObjetivoProyecto(ObjetivoPrograma obj) {
        objetivoProyectoList.add(obj);
    }

    @Transient
    private List<ObjetivoBVivirPrograma> objetivoBVivirProyectoPadreList = new ArrayList<>();

    public List<ObjetivoBVivirPrograma> getObjetivoBVivirProyectoPadreList() {
        Collections.sort(objetivoBVivirProyectoPadreList);
        return objetivoBVivirProyectoPadreList;
    }

    public void setObjetivoBVivirProyectoPadreList(List<ObjetivoBVivirPrograma> objetivoBVivirProyectoPadreList) {
        this.objetivoBVivirProyectoPadreList = objetivoBVivirProyectoPadreList;
    }

    @Transient
    private Map<BigDecimal, Boolean> estadoExpandidoObjetivo = new HashMap<BigDecimal, Boolean>();
    @Transient
    private Map<BigDecimal, Boolean> estadoExpandidoObjetivoBVivir = new HashMap<BigDecimal, Boolean>();

    public void setEstadoExpandidoObjetivoBVivir(Map<BigDecimal, Boolean> estadoExpandidoObjetivoBVivir) {
        this.estadoExpandidoObjetivoBVivir = estadoExpandidoObjetivoBVivir;
        for (ObjetivoBVivirPrograma obj : objetivoBVivirProyectoPadreList) {
            Boolean expanded = (estadoExpandidoObjetivoBVivir.get(obj.getObjetivoBVivir().getSvobviId()) != null) ? estadoExpandidoObjetivoBVivir.get(obj.getObjetivoBVivir().getSvobviId()) : false;
            obj.setExpanded(expanded);
        }
    }

    public Map<BigDecimal, Boolean> getEstadoExpandidoObjetivoBVivir() {
        return estadoExpandidoObjetivoBVivir;
    }

    public void resetEstadoExpandidoObjetivo() {
        this.estadoExpandidoObjetivo = new HashMap<>();
        for (ObjetivoPrograma obj : objetivoProyectoList) {
            obj.setExpanded(!obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN));
            estadoExpandidoObjetivo.put(obj.getSvopId(), obj.isExpanded());
        }
    }

    public Map<BigDecimal, Boolean> getEstadoExpandidoObjetivo() {
        return estadoExpandidoObjetivo;
    }

    public void setEstadoExpandidoObjetivo(Map<BigDecimal, Boolean> estadoExpandidoObjetivo) {
        this.estadoExpandidoObjetivo = estadoExpandidoObjetivo;
        for (ObjetivoPrograma obj : objetivoProyectoList) {
            Boolean expanded = (estadoExpandidoObjetivo.get(obj.getSvopId()) != null) ? estadoExpandidoObjetivo.get(obj.getSvopId()) : false;
            obj.setExpanded(expanded);
        }

    }

    public List<HitoProyecto> getHitoProyectoList() {
        return hitoProyectoList;
    }

    public void setHitoProyectoList(List<HitoProyecto> hitoProyectoList) {
        this.hitoProyectoList = hitoProyectoList;
    }

    public void addHitoProyecto(HitoProyecto hito) {
        this.hitoProyectoList.add(hito);
    }

    public void removeHitoProyecto(HitoProyecto hitoProyecto) {
        hitoProyectoList.remove(hitoProyecto);
    }

    @XmlTransient
    public List<PresupuestoProyecto> getPresupuestoProyectoList() {
        return presupuestoProyectoList;
    }

    public void setPresupuestoProyectoList(List<PresupuestoProyecto> presupuestoProyectoList) {
        this.presupuestoProyectoList = presupuestoProyectoList;
    }

    public void addPresupuesto(PresupuestoProyecto presupuestoProyecto) {
        this.presupuestoProyectoList.add(presupuestoProyecto);
    }

    public void removePresupuesto(PresupuestoProyecto presupuestoProyecto) {
        presupuestoProyectoList.remove(presupuestoProyecto);
    }

    public String getTotalPresupuestoStr() {
        return decimalToString(getTotalPresupuesto());
    }

    public BigDecimal getTotalPresupuesto() {
        BigDecimal total = BigDecimal.ZERO;
        if (presupuestoProyectoList != null) {
            for (PresupuestoProyecto presupuestoProyecto : presupuestoProyectoList) {
                try {
                    total = total.add(presupuestoProyecto.getTotal());
                } catch (Exception e) {
                }
            }
        }
        return total;
    }

    public String getTotalPresupuestoEjecutadoStr() {
        return decimalToString(getTotalPresupuestoEjecutado());
    }

    public BigDecimal getTotalPresupuestoEjecutado() {
        BigDecimal total = BigDecimal.ZERO;
        if (presupuestoProyectoList != null) {
            for (PresupuestoProyecto presupuestoProyecto : presupuestoProyectoList) {
                try {
                    total = total.add(presupuestoProyecto.getTotalEjecutado());
                } catch (Exception e) {
                }
            }
        }
        return (total);
    }

    public List<TipoPoblacionProyecto> getTipoPoblacionList() {
        return tipoPoblacionList;
    }

    public void setTipoPoblacionList(List<TipoPoblacionProyecto> tipoPoblacionList) {
        this.tipoPoblacionList = tipoPoblacionList;
    }

    public void addTipoPoblacion(TipoPoblacionProyecto tipoPoblacionProyecto) {
        if (tipoPoblacionList == null) {
            tipoPoblacionList = new ArrayList<>();
        }
        this.tipoPoblacionList.add(tipoPoblacionProyecto);

    }

    public List<LocalizacionPrograma> getParroquiasCobertura() {
        List<LocalizacionPrograma> temp = new ArrayList<>();
        for (LocalizacionPrograma svinZonaDetalle : objetivosProvCanParr) {
            if ((isCoberturaParroquial() && svinZonaDetalle.getParroquia() != null)
                    || (isCoberturaCantonal() && svinZonaDetalle.getCanton() != null)
                    || (isCoberturaProvincial() && svinZonaDetalle.getProvincia() != null)) {
                temp.add(svinZonaDetalle);
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Stvsubj getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Stvsubj departamento) {
        this.departamento = departamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void generarCodigo(Integer secuencial) {
        codigo = "";
        String[] a = departamento.getStvsubjDesc().split(" ");
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > 2 || (a[i].length() == 2 && a[i].substring(1, 2).equals("."))) {
                codigo += a[i].substring(0, 1);
            }
        }
        codigo = codigo + "-G" + (tipo.equals("C") ? "P" : "NP") + "-";
        if (secuencial.toString().length() == 1) {
            codigo += "000";
        } else if (secuencial.toString().length() == 2) {
            codigo += "00";
        } else if (secuencial.toString().length() == 3) {
            codigo += "0";
        }

        codigo = codigo + secuencial.toString() + "-" + (new Date().getYear() + 1900);
        this.secuencial=secuencial;

    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getNombreDocAprobacionConcejoDep() {
        return nombreDocAprobacionConcejoDep;
    }

    public void setNombreDocAprobacionConcejoDep(String nombreDocAprobacionConcejoDep) {
        this.nombreDocAprobacionConcejoDep = nombreDocAprobacionConcejoDep;
    }

    public String getUrlDocAprobacionConcejoDep() {
        return urlDocAprobacionConcejoDep;
    }

    public void setUrlDocAprobacionConcejoDep(String urlDocAprobacionConcejoDep) {
        this.urlDocAprobacionConcejoDep = urlDocAprobacionConcejoDep;
    }

    public String getUrlFinalDocAprobacionConcejoDep() {
        try {
            return this.urlDocAprobacionConcejoDep + this.nombreDocAprobacionConcejoDep;
        } catch (Exception e) {
            return null;
        }
    }

    public ResponsableProyecto getDirector() {
        List<ResponsableProyecto> temp = getResponsableListByTipo(TipoResponsable.TIPO_DIRECTOR);
        if (!temp.isEmpty()) {
            for (ResponsableProyecto resp : temp) {
                if (resp.getEstado().equals(ResponsableProyecto.ESTADO_ACTIVO)){
                    return resp;
                }
            }
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

    public List<ResponsableProyecto> getParticipanteDocenteList() {
        List<ResponsableProyecto> temp = getResponsableListByTipo(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE);
        Collections.sort(temp);
        return temp;
    }

    public List<ResponsableProyecto> getParticipanteDocenteTodosList() {
        List<ResponsableProyecto> temp = getResponsableListByTipo(TipoResponsable.TIPO_DIRECTOR);
        List<ResponsableProyecto> temp2 = getResponsableListByTipo(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE);
        Collections.sort(temp2);
        temp.addAll(temp2);
        return temp;
    }

    public List<ResponsableProyecto> getComisionList() {
        return getResponsableListByTipo(TipoResponsable.TIPO_COMISION_EVALUACION);
    }

    public List<ResponsableProyecto> getParticipanteEstudianteList() {
        return getResponsableListByTipo(TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE);
    }

    private List<ResponsableProyecto> getResponsableListByTipo(Integer tipoResponsable) {
        List<ResponsableProyecto> temp = new ArrayList<>();
        for (ResponsableProyecto resp : responsableList) {
            if (resp.getTipoResponsable().getId().equals(tipoResponsable)) {
                temp.add(resp);
            }
        }
        return temp;
    }

    public void addResponsable(ResponsableProyecto responsable) {
        if (responsableList == null || id==null) {
            responsableList = new ArrayList<>();
        }
        ResponsableProyecto respEliminar = null;
        if (responsable.getTipoResponsable().getId().equals(TipoResponsable.TIPO_DIRECTOR)) {
            for (ResponsableProyecto resp : responsableList) {
                if (resp.getTipoResponsable().getId().equals(TipoResponsable.TIPO_DIRECTOR)) {
                    //if (!resp.getUsuario().getUsuId().equals(responsable.getUsuario().getUsuId())) {
                    if (resp.getId() == null) {
                        respEliminar = resp;
                        break;
                    }
                }

            }
        }
        if (respEliminar != null) {
            responsableList.remove(respEliminar);
        }
        responsable.setProyecto(this);
        if (getDirector()==null || !getDirector().getUsuario().equals(responsable.getUsuario())){
            responsableList.add(responsable);
        }
    }

    public List<CalificacionProyecto> getCalificacionList() {
        Collections.sort(calificacionList);
        return calificacionList;
    }

    public List<CalificacionProyecto> getCalificacionUltimaList() {
        List<CalificacionProyecto> temp = new ArrayList<>();
        CalificacionProyecto cal = getCalificacionActualXUsuario();
        if (cal != null) {
            temp.add(cal);
        }
        return temp;
    }

    public void setCalificacionList(List<CalificacionProyecto> calificacionList) {
        this.calificacionList = calificacionList;
    }

    public void addCalificacion(CalificacionProyecto calificacionProyecto) {
        if (calificacionList == null) {
            calificacionList = new ArrayList<>();
        }
        calificacionProyecto.setProyecto(this);
        calificacionList.add(calificacionProyecto);
    }

    public void removeCalificacion(CalificacionProyecto calificacionProyecto) {
        calificacionList.remove(calificacionProyecto);
    }

    public CalificacionProyecto getCalificacionActualXUsuario() {
        if (getCalificacionPorUsuarioList() == null || getCalificacionPorUsuarioList().isEmpty()) {
            return null;
        }
        return getCalificacionPorUsuarioList().get(0);
    }

    @Transient
    private SegUsuario usuarioActual;

    public SegUsuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(SegUsuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public List<CalificacionProyecto> getCalificacionPorUsuarioList() {
        List<CalificacionProyecto> temp = new ArrayList<>();
        if (calificacionList != null && !calificacionList.isEmpty() && usuarioActual != null) {
            for (CalificacionProyecto calificacionProyecto : calificacionList) {
                if (calificacionProyecto.getMiembroComisionCalificacion().getUsuario().getUsuId().equals(usuarioActual.getUsuId())) {
                    temp.add(calificacionProyecto);
                }
            }

        }
        Collections.sort(temp);
        return temp;
    }

    public ComisionCalificacion getComisionCalificacion() {
        return comisionCalificacion;
    }

    public void setComisionCalificacion(ComisionCalificacion comisionCalificacion) {
        this.comisionCalificacion = comisionCalificacion;
    }

    public List<ConsolidacionCalificacionProyecto> getConsolidacionCalificacioList() {
        if (consolidacionCalificacioList != null && !consolidacionCalificacioList.isEmpty()) {
            Collections.sort(consolidacionCalificacioList);
        }
        return consolidacionCalificacioList;
    }

    public void setConsolidacionCalificacioList(List<ConsolidacionCalificacionProyecto> consolidacionCalificacioList) {
        this.consolidacionCalificacioList = consolidacionCalificacioList;
    }

    public List<ConsolidacionCalificacionProyecto> getConsolidacionCalificacionUltimaList() {
        List<ConsolidacionCalificacionProyecto> temp = new ArrayList<>();
        if (consolidacionCalificacioList != null && !consolidacionCalificacioList.isEmpty()) {
            temp.add(getConsolidacionCalificacioList().get(0));
        }
        return temp;
    }

    public ConfiguracionParametrosEvaluacion getConfiguracionParametrosEvaluacion() {
        return configuracionParametrosEvaluacion;
    }

    public void setConfiguracionParametrosEvaluacion(ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion) {
        this.configuracionParametrosEvaluacion = configuracionParametrosEvaluacion;
    }

    public List<DepartamentoProyecto> getDepartamentoProyectoList() {
        return departamentoProyectoList;
    }

    //Devuelve departamentos del proyecto pero sin repetir los que ya existe.
    public List<DepartamentoProyecto> getDepartamentoProyectoDistinctDepList() {
        List<DepartamentoProyecto> result = new ArrayList<>();
        if (departamentoProyectoList != null && !departamentoProyectoList.isEmpty()) {
            for (DepartamentoProyecto dep : departamentoProyectoList) {
                boolean encontro = false;
                for (DepartamentoProyecto dep2 : result) {
                    if (dep.getDepartamento().equals(dep2.getDepartamento())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    result.add(dep);
                }
            }

        }
        return result;
    }

    public List<DepartamentoProyecto> getDepartamentoProyectoDistinctCampusList() {
        List<DepartamentoProyecto> result = new ArrayList<>();
        if (departamentoProyectoList != null && !departamentoProyectoList.isEmpty()) {
            for (DepartamentoProyecto dep : departamentoProyectoList) {
                boolean encontro = false;
                for (DepartamentoProyecto dep2 : result) {
                    if (dep.getCampus().equals(dep2.getCampus())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    result.add(dep);
                }
            }

        }
        return result;
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

    public void setDepartamentoProyectoList(List<DepartamentoProyecto> departamentoProyectoList) {
        this.departamentoProyectoList = departamentoProyectoList;
    }

    public String getTotalDocentesParticipantesStr() {
        return integerToString(getTotalDocentesParticipantes());
    }

    public Integer getTotalDocentesParticipantes() {
        Integer total = 0;
        if (departamentoProyectoList != null) {

            for (DepartamentoProyecto departamentoProyecto : departamentoProyectoList) {
                try {
                    total += departamentoProyecto.getNroDocentes();
                } catch (Exception e) {
                }
            }
        }
        return total;
    }

    public Date getFechaAprobacionConsejoAcademico() {
        return fechaAprobacionConsejoAcademico;
    }

    public void setFechaAprobacionConsejoAcademico(Date fechaAprobacionConsejoAcademico) {
        this.fechaAprobacionConsejoAcademico = fechaAprobacionConsejoAcademico;
    }

    public String getPdfActaAprobacionConsejoAcademicoNombre() {
        return pdfActaAprobacionConsejoAcademicoNombre;
    }

    public void setPdfActaAprobacionConsejoAcademicoNombre(String pdfActaAprobacionConsejoAcademicoNombre) {
        this.pdfActaAprobacionConsejoAcademicoNombre = pdfActaAprobacionConsejoAcademicoNombre;
    }

    public String getPdfActaAprobacionConsejoAcademicoUrl() {
        return pdfActaAprobacionConsejoAcademicoUrl;
    }

    public void setPdfActaAprobacionConsejoAcademicoUrl(String pdfActaAprobacionConsejoAcademicoUrl) {
        this.pdfActaAprobacionConsejoAcademicoUrl = pdfActaAprobacionConsejoAcademicoUrl;
    }

    public String getObservacionAprobacionConsejoAcademico() {
        return observacionAprobacionConsejoAcademico;
    }

    public void setObservacionAprobacionConsejoAcademico(String observacionAprobacionConsejoAcademico) {
        this.observacionAprobacionConsejoAcademico = observacionAprobacionConsejoAcademico;
    }

    public String getUrlFinalPdfAprobacionConsejoAcademico() {
        try {
            return this.pdfActaAprobacionConsejoAcademicoUrl + this.pdfActaAprobacionConsejoAcademicoNombre;
        } catch (Exception e) {
            return null;
        }
    }

    public String getUrlFinalPdfMemorandoNotificacionConsejoAcademico() {
        try {
            return this.pdfMemorandoAprobacionConsejoAcademicoUrl + this.pdfMemorandoAprobacionConsejoAcademicoNombre;
        } catch (Exception e) {
            return null;
        }
    }

    @Transient
    private Map<Integer, ValoracionParametroEvaluacion> columns;

    public void setColumns(Map<Integer, ValoracionParametroEvaluacion> columns) {
        this.columns = columns;
    }

    public Map<Integer, ValoracionParametroEvaluacion> getColumns() {
        /*Map<String, DetalleCalificacionProyecto> columns = new HashMap<>();
        for (DetalleCalificacionProyecto det : getConsolidacionCalificacionUltimaList().get(0).getDetalleCalificacionProyectoConsolidado()) {
            columns.put(det.getParametroEvaluacion().getDescripcion(), det);
        }*/
        //Map<String, DetalleCalificacionProyecto> columns = new HashMap<>();
        if (columns == null) {
            columns = new HashMap<>();
            for (DetalleCalificacionProyecto det : getConsolidacionCalificacionUltimaList().get(0).getDetalleCalificacionProyectoConsolidado()) {
                Integer id = det.getValoracionParametroPromedio().getId();
                for (ValoracionParametroEvaluacion val : det.getParametroEvaluacion().getValoracionList()) {

                    if (this.id.equals(80)) {
                        int b = 10;
                        b = 11;
                    }
                    if (val.getId().equals(320)) {
                        int a = 1;
                        a = 12;
                    }
                    ValoracionParametroEvaluacion valoracionParametroEvaluacion = new ValoracionParametroEvaluacion();
                    valoracionParametroEvaluacion.setId(val.getId());
                    if (!val.getId().equals(id)) {
                        //val.setPuntaje(-1);
                        valoracionParametroEvaluacion.setPuntaje(-1);
                    } else {
                        valoracionParametroEvaluacion.setPuntaje(val.getPuntaje());
                    }
                    columns.put(valoracionParametroEvaluacion.getId(), valoracionParametroEvaluacion);
                }
            }
        }
        return columns;
    }

    public ObjetivoPrograma getObjetivoGeneral() {
        for (ObjetivoPrograma obj : objetivoProyectoList) {
            if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                return obj;
            }
        }
        return null;
    }

    @Transient
    private List<PresupuestoProyecto> detallePresupuestoUniversidad;

    public void setDetallePresupuestoUniversidad(List<PresupuestoProyecto> detallePresupuestoUniversidad) {
        this.detallePresupuestoUniversidad = detallePresupuestoUniversidad;
    }

    public List<PresupuestoProyecto> getDetallePresupuestoUniversidad() {
        return this.detallePresupuestoUniversidad;
    }
    @Transient
    private List<PresupuestoProyecto> detallePresupuestoUniversidadGastoPermanente;

    public List<PresupuestoProyecto> getDetallePresupuestoUniversidadGastoPermanente() {
        return detallePresupuestoUniversidadGastoPermanente;
    }

    public void setDetallePresupuestoUniversidadGastoPermanente(List<PresupuestoProyecto> detallePresupuestoUniversidadGastoPermanente) {
        this.detallePresupuestoUniversidadGastoPermanente = detallePresupuestoUniversidadGastoPermanente;
    }
    @Transient
    private List<PresupuestoProyecto> detallePresupuestoUniversidadGastoNoPermanente;

    public List<PresupuestoProyecto> getDetallePresupuestoUniversidadGastoNoPermanente() {
        return detallePresupuestoUniversidadGastoNoPermanente;
    }

    public void setDetallePresupuestoUniversidadGastoNoPermanente(List<PresupuestoProyecto> detallePresupuestoUniversidadGastoNoPermanente) {
        this.detallePresupuestoUniversidadGastoNoPermanente = detallePresupuestoUniversidadGastoNoPermanente;
    }

    @Transient
    private List<PresupuestoProyecto> detallePresupuestoEntidadAuspiciante;

    public void setDetallePresupuestoEntidadAuspiciante(List<PresupuestoProyecto> detallePresupuestoEntidadAuspiciante) {
        this.detallePresupuestoEntidadAuspiciante = detallePresupuestoEntidadAuspiciante;
    }

    public List<PresupuestoProyecto> getDetallePresupuestoEntidadAuspiciante() {
        return this.detallePresupuestoEntidadAuspiciante;
    }
    @Transient
    private List<PresupuestoProyecto> detallePresupuestoComunidadBeneficiaria;

    public void setDetallePresupuestoComunidadBeneficiaria(List<PresupuestoProyecto> detallePresupuestoComunidadBeneficiaria) {
        this.detallePresupuestoComunidadBeneficiaria = detallePresupuestoComunidadBeneficiaria;
    }

    public List<PresupuestoProyecto> getDetallePresupuestoComunidadBeneficiaria() {
        return detallePresupuestoComunidadBeneficiaria;
    }

    private List<PresupuestoProyecto> getDetallePresupuestoByTipo(Integer tipo, String tipoGasto) {
        List<PresupuestoProyecto> temp = new ArrayList<>();
        if (presupuestoProyectoList != null) {
            for (PresupuestoProyecto pre : presupuestoProyectoList) {
                if (tipoGasto == null) {
                    if (pre.getTipo().equals(tipo)) {
                        temp.add(pre);
                    }

                } else if (pre.getTipo().equals(tipo) && pre.getTipoGasto().equals(tipoGasto)) {
                    temp.add(pre);
                }
            }
        }
        return temp;
    }

    private String getTotalPresupuestoXTipoStr(Integer tipoPresupuesto, String tipoGasto) {
        return decimalToString(getTotalPresupuestoXTipo(tipoPresupuesto, tipoGasto));
    }

    private BigDecimal getTotalPresupuestoXTipo(Integer tipoPresupuesto, String tipoGasto) {
        BigDecimal total = BigDecimal.ZERO;
        if (presupuestoProyectoList != null) {
            for (PresupuestoProyecto pre : presupuestoProyectoList) {
                if (tipoGasto != null) {
                    if (pre.getTipo().equals(tipoPresupuesto) && pre.getTipoGasto().equals(tipoGasto)) {
                        if(pre.getCantidadAnualProyectoList().isEmpty()){
                            total = total.add(pre.getTotal());
                        }else{
                            for(CantidadAnualProyecto cant : pre.getCantidadAnualProyectoList()){
                                
                                total = total.add(cant.getCantidadAnual());
                            }
                        }
                       
                        
                    }
                } else if (pre.getTipo().equals(tipoPresupuesto)) {
                   if(pre.getCantidadAnualProyectoList().isEmpty()){
                       total = total.add(pre.getTotal());
                   }else{
                       for(CantidadAnualProyecto cant : pre.getCantidadAnualProyectoList()){
                           
                           total = total.add(cant.getCantidadAnual());
                       }
                   }
                }
            }
        }
        return total;
    }
    
    private BigDecimal getTotalPresupuestoXTipoAnual(Integer tipoPresupuesto, String tipoGasto) {
        BigDecimal total = BigDecimal.ZERO;
        if (presupuestoProyectoList != null) {
            for (PresupuestoProyecto pre : presupuestoProyectoList) {
                if (tipoGasto != null) {
                    if (pre.getTipo().equals(tipoPresupuesto) && pre.getTipoGasto().equals(tipoGasto)) {
                        for(CantidadAnualProyecto cant : pre.getCantidadAnualProyectoList()){
                            
                            total = total.add(cant.getCantidadAnual());
                        }
                        
                    }
                } else if (pre.getTipo().equals(tipoPresupuesto)) {
                    
                    for(CantidadAnualProyecto cant : pre.getCantidadAnualProyectoList()){
                            
                            total = total.add(cant.getCantidadAnual());
                        }
                }
            }
        }
        return total;
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

    /*private String getTotalPresupuestoEjecutadoXTipoStr(Integer tipoPresupuesto, String tipoGasto) {
        return decimalToString(getTotalPresupuestoEjecutadoXTipo(tipoPresupuesto,tipoGasto));
    }*/
    private BigDecimal getTotalPresupuestoEjecutadoXTipo(Integer tipoPresupuesto, String tipoGasto) {
        BigDecimal total = BigDecimal.ZERO;
        if (presupuestoProyectoList != null) {
            for (PresupuestoProyecto pre : presupuestoProyectoList) {
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
        return total;
    }

    public String getTotalPresupuestoUniversidadStr() {
        return decimalToString(getTotalPresupuestoUniversidad());
    }

    public BigDecimal getTotalPresupuestoUniversidad() {
        return getTotalPresupuestoXTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, null);
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

    public void inicializarListadoPresupuestos() {
        this.detallePresupuestoUniversidad = getDetallePresupuestoByTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, null);
        this.detallePresupuestoUniversidadGastoPermanente = getDetallePresupuestoByTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, PresupuestoProyecto.TIPO_GASTO_CORRIENTE);
        this.detallePresupuestoUniversidadGastoNoPermanente = getDetallePresupuestoByTipo(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD, PresupuestoProyecto.TIPO_GASTO_INVERSION);
        this.detallePresupuestoEntidadAuspiciante = getDetallePresupuestoByTipo(PresupuestoProyecto.TIPO_APORTE_ENTIDAD_AUSPICIANTE, null);
        this.detallePresupuestoComunidadBeneficiaria = getDetallePresupuestoByTipo(PresupuestoProyecto.TIPO_APORTE_COMUNIDAD_BENEFICIARIA, null);
    }

    public String getMensajeCorreo() {
        return mensajeCorreo;
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }

    public String getAsuntoCorreo() {
        return asuntoCorreo;
    }

    public void setAsuntoCorreo(String asuntoCorreo) {
        this.asuntoCorreo = asuntoCorreo;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public List<CarreraProyecto> getCarreraProyectoList() {
        return carreraProyectoList;
    }

    public void setCarreraProyectoList(List<CarreraProyecto> carreraProyectoList) {
        this.carreraProyectoList = carreraProyectoList;
    }

    public IndicadorEstrategiaProyecto getIndicadorEstrategia(Integer idObjetivoEstrategico) {
        for (IndicadorEstrategiaProyecto ind : objetivoEstrategicoList) {
            if (ind.getObjetivoEstrategico().getId().equals(idObjetivoEstrategico)) {
                return ind;
            }
        }
        return null;
    }

    /*public Integer getNroBeneficiariosDirectosEjecutados() {
        return nroBeneficiariosDirectosEjecutados;
    }

    public void setNroBeneficiariosDirectosEjecutados(Integer nroBeneficiariosDirectosEjecutados) {
        this.nroBeneficiariosDirectosEjecutados = nroBeneficiariosDirectosEjecutados;
    }*/
    public List<EvaluacionFinalProyecto> getEvaluacionFinalList() {
        if (evaluacionFinalList != null) {
            Collections.sort(evaluacionFinalList);
        }
        return evaluacionFinalList;
    }

    public void setEvaluacionFinalList(List<EvaluacionFinalProyecto> evaluacionFinalList) {
        this.evaluacionFinalList = evaluacionFinalList;
    }

    public EvaluacionFinalProyecto getEvaluacionFinal() {
        if (evaluacionFinalList != null && !evaluacionFinalList.isEmpty()) {
            return getEvaluacionFinalList().get(0);
        }
        return null;
    }

    public String getAreaIntervencion2() {
        return areaIntervencion2;
    }

    public void setAreaIntervencion2(String areaIntervencion2) {
        this.areaIntervencion2 = areaIntervencion2;
    }

    public String getDiagnosticoProblema2() {
        return diagnosticoProblema2;
    }

    public void setDiagnosticoProblema2(String diagnosticoProblema2) {
        this.diagnosticoProblema2 = diagnosticoProblema2;
    }

    public String getPdfMemorandoAprobacionConsejoAcademicoNombre() {
        return pdfMemorandoAprobacionConsejoAcademicoNombre;
    }

    public void setPdfMemorandoAprobacionConsejoAcademicoNombre(String pdfMemorandoAprobacionConsejoAcademicoNombre) {
        this.pdfMemorandoAprobacionConsejoAcademicoNombre = pdfMemorandoAprobacionConsejoAcademicoNombre;
    }

    public String getPdfMemorandoAprobacionConsejoAcademicoUrl() {
        return pdfMemorandoAprobacionConsejoAcademicoUrl;
    }

    public void setPdfMemorandoAprobacionConsejoAcademicoUrl(String pdfMemorandoAprobacionConsejoAcademicoUrl) {
        this.pdfMemorandoAprobacionConsejoAcademicoUrl = pdfMemorandoAprobacionConsejoAcademicoUrl;
    }

    public String getAdjuntarActaAprobacionConsejoAcademico() {
        return adjuntarActaAprobacionConsejoAcademico;
    }

    public void setAdjuntarActaAprobacionConsejoAcademico(String adjuntarActaAprobacionConsejoAcademico) {
        this.adjuntarActaAprobacionConsejoAcademico = adjuntarActaAprobacionConsejoAcademico;
    }

    public String getAdjuntarMemorandoNotificacionConsejoAcademico() {
        return adjuntarMemorandoNotificacionConsejoAcademico;
    }

    public void setAdjuntarMemorandoNotificacionConsejoAcademico(String adjuntarMemorandoNotificacionConsejoAcademico) {
        this.adjuntarMemorandoNotificacionConsejoAcademico = adjuntarMemorandoNotificacionConsejoAcademico;
    }

    /*public Integer getCobertura() {
        return cobertura;
    }

    public void setCobertura(Integer cobertura) {
        this.cobertura = cobertura;
    }*/

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
                svinZonaDetalle.setProyecto(this);
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
                svinZonaDetalleNuevo.setProyecto(this);
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
                    svinZonaDetalleNuevo.setProyecto(this);
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
                    svinZonaDetalleNuevo.setProyecto(this);
                    objetivosProvCanParr.add(svinZonaDetalleNuevo);
                }
            }
        }

    }

    public List<LineaInvestigacionProyecto> getLineaInvestigacionProyectoList() {
        return lineaInvestigacionProyectoList;
    }

    public void setLineaInvestigacionProyectoList(List<LineaInvestigacionProyecto> lineaInvestigacionProyectoList) {
        this.lineaInvestigacionProyectoList = lineaInvestigacionProyectoList;
    }

    public void setearLineaInvestigacionList() {
        lineaInvestigacionList = new ArrayList<>();
        if (lineaInvestigacionProyectoList != null) {
            for (LineaInvestigacionProyecto lineaInvesProy : lineaInvestigacionProyectoList) {
                boolean encontro = false;
                for (SeaLineainves lineaInves : lineaInvestigacionList) {
                    if (lineaInvesProy.getLineaInvestigacion().getLineaIdPadre().getLineaId().equals(lineaInves.getLineaId())) {
                        lineaInves.addSeaLineaInvest(lineaInvesProy.getLineaInvestigacion());
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    SeaLineainves lineaInves = new SeaLineainves();
                    lineaInves.setLineaDescip(lineaInvesProy.getLineaInvestigacion().getLineaIdPadre().getLineaDescip());
                    lineaInves.setLineaId(lineaInvesProy.getLineaInvestigacion().getLineaIdPadre().getLineaId());
                    lineaInves.addSeaLineaInvest(lineaInvesProy.getLineaInvestigacion());
                    lineaInvestigacionList.add(lineaInves);
                }
            }
        }
    }

    public List<SeaLineainves> getLineaInvestigacionList() {
        return lineaInvestigacionList;
    }

    public void setLineaInvestigacionList(List<SeaLineainves> lineaInvestigacionList) {
        this.lineaInvestigacionList = lineaInvestigacionList;
    }

    public void asignarEvaluadorFinal(SegUsuario usuario) {
        if (responsableList == null) {
            responsableList = new ArrayList<>();
        }
        if (getEvaluadorFinal() == null) {
            ResponsableProyecto resp = new ResponsableProyecto(new TipoResponsable(TipoResponsable.TIPO_EVALUADOR_FINAL));
            resp.setProyecto(this);
            resp.setUsuario(usuario);
            responsableList.add(resp);
        } else {
            getEvaluadorFinal().setUsuario(usuario);
        }
    }

    public Integer getNroBeneficiariosDirectosNinios() {
        return nroBeneficiariosDirectosNinios;
    }

    public void setNroBeneficiariosDirectosNinios(Integer nroBeneficiariosDirectosNinios) {
        this.nroBeneficiariosDirectosNinios = nroBeneficiariosDirectosNinios;
    }

    /*public Integer getNroBeneficiariosIndirectosNinios() {
        return nroBeneficiariosIndirectosNinios;
    }

    public void setNroBeneficiariosIndirectosNinios(Integer nroBeneficiariosIndirectosNinios) {
        this.nroBeneficiariosIndirectosNinios = nroBeneficiariosIndirectosNinios;
    }*/
    public List<AnexoProyecto> getAnexoProyectoList() {
        return anexoProyectoList;
    }

    public void setAnexoProyectoList(List<AnexoProyecto> anexoProyectoList) {
        this.anexoProyectoList = anexoProyectoList;
    }

    public List<CompromisoParticipacionProyecto> getCompromisoParticipacionList() {
        return compromisoParticipacionList;
    }

    public void setCompromisoParticipacionList(List<CompromisoParticipacionProyecto> compromisoParticipacionList) {
        this.compromisoParticipacionList = compromisoParticipacionList;
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
        return (getTotalBeneficiariosEjecutadosXTipo(4));
    }

    public Integer getTotalBeneficiariosIndirectosEjecutados() {
        return (getTotalBeneficiariosEjecutadosXTipo(5));
    }

    public Integer getTotalBeneficiariosEjecutados() {
        return (getTotalBeneficiariosDirectosEjecutados() + getTotalBeneficiariosIndirectosEjecutados());
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
        if (compromisoParticipacionList != null) {
            for (CompromisoParticipacionProyecto com : compromisoParticipacionList) {
                try {
                    if (null != tipo) {
                        switch (tipo) {
                            case 0:
                                if (com.getNroBeneficiariosDirectosHombres() != null) {
                                    result += com.getNroBeneficiariosDirectosHombres();
                                }
                                break;
                            case 1:
                                if (com.getNroBeneficiariosDirectosMujeres() != null) {
                                    result += com.getNroBeneficiariosDirectosMujeres();
                                }
                                break;
                            case 2:
                                if (com.getNroBeneficiariosDirectosNinios() != null) {
                                    result += com.getNroBeneficiariosDirectosNinios();
                                }
                                break;
                            case 3:
                                if (com.getNroBeneficiariosDirectosDiscapacidad() != null) {
                                    result += com.getNroBeneficiariosDirectosDiscapacidad();
                                }
                                break;
                            case 4:
                                if (com.getTotalBeneficiariosDirectos() != null) {
                                    result += com.getTotalBeneficiariosDirectos();
                                }
                                break;
                            case 5:
                                if (com.getNroBeneficiariosIndirectos() != null) {
                                    result += com.getNroBeneficiariosIndirectos();
                                }
                                break;
                            default:
                                break;
                        }
                    }

                } catch (Exception e) {
                }
            }
        }
        return result;
    }

    public List<CompromisoParticipacionProyecto> getNumericoBeneficiarioList() {
        List<CompromisoParticipacionProyecto> temp = new ArrayList<>();
        Long tipoCompromisoParticipacion = SeaParametrosDet.PARAM_TIPO_COMPROMISO_PARTICIPACION_ENTIDAD;
        if (getExisteParticipacionComunidad()) {
            tipoCompromisoParticipacion = SeaParametrosDet.PARAM_TIPO_COMPROMISO_PARTICIPACION_COMUNIDAD;
        }
        if (compromisoParticipacionList != null) {
            for (CompromisoParticipacionProyecto com : compromisoParticipacionList) {
                if (com.getTipoParticipacion().getPrdId().equals(tipoCompromisoParticipacion)) {
                    temp.add(com);
                }
            }

        }
        return temp;
    }

    public boolean getExisteParticipacionComunidad() {
        boolean existe = false;
        if (compromisoParticipacionList != null) {
            for (CompromisoParticipacionProyecto com : compromisoParticipacionList) {
                if (com.getTipoParticipacion().getPrdId().equals(SeaParametrosDet.PARAM_TIPO_COMPROMISO_PARTICIPACION_COMUNIDAD)) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }

    public String getTotalEstudiantesParticipantesStr() {
        return integerToString(getTotalEstudiantesParticipantes());
    }

    public Integer getTotalEstudiantesParticipantes() {
        Integer total = 0;
        if (carreraProyectoList != null) {
            for (CarreraProyecto carreraProyecto : carreraProyectoList) {
                try {
                    total += carreraProyecto.getNroEstudiantes();
                } catch (Exception e) {
                }
            }
        }
        return (total);
    }

    public String getCierreProductos() {
        return cierreProductos;
    }

    public void setCierreProductos(String cierreProductos) {
        this.cierreProductos = cierreProductos;
    }

    public String getCierreBienes() {
        return cierreBienes;
    }

    public void setCierreBienes(String cierreBienes) {
        this.cierreBienes = cierreBienes;
    }

    public String getCierreResultados() {
        return cierreResultados;
    }

    public void setCierreResultados(String cierreResultados) {
        this.cierreResultados = cierreResultados;
    }

    public String getCierreOtrasAplicaciones() {
        return cierreOtrasAplicaciones;
    }

    public void setCierreOtrasAplicaciones(String cierreOtrasAplicaciones) {
        this.cierreOtrasAplicaciones = cierreOtrasAplicaciones;
    }

    public String getCierreImpactoFuturo() {
        return cierreImpactoFuturo;
    }

    public void setCierreImpactoFuturo(String cierreImpactoFuturo) {
        this.cierreImpactoFuturo = cierreImpactoFuturo;
    }

    public String getCierreRestricciones() {
        return cierreRestricciones;
    }

    public void setCierreRestricciones(String cierreRestricciones) {
        this.cierreRestricciones = cierreRestricciones;
    }

    public String getCierreComentarios() {
        return cierreComentarios;
    }

    public void setCierreComentarios(String cierreComentarios) {
        this.cierreComentarios = cierreComentarios;
    }

    public String getMensajePermitirCalificacionComisionVinculacion() {
        if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_CREADO) || estado.getPrdId().equals(SeaParametrosDet.ESTADO_REVISION)) {
            return "No se puede registrar esta información, porque el proyecto se encuentra en proceso de ingreso de perfil";
        }
        return "";
    }

    public String getMensajePermitirConsolidacionCalificacion() {
        String result = getMensajePermitirCalificacionComisionVinculacion();
        if (result.equals("")) {
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_CERRADO_PERFIL)) {
                return "No se puede registrar esta información, porque el proyecto se encuentra en proceso de calificación por la comisión de vinculación";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirAprobacionVicerrectorado() {
        String result = getMensajePermitirConsolidacionCalificacion();
        if (result.equals("")) {
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_CERRADO_CALIFICACION)) {
                return "No se puede registrar esta información, porque el proyecto se encuentra en proceso de consolidación de calificaciones de la comisión de vinculación";
            }
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_RECHAZADO_COMISION_VINCULACION)) {
                return "No se puede registrar esta información, porque el proyecto no ha cumplido el puntaje mínimo requerido en la calificación de la comisión de vinculación";
            }
        } else {
            return result;
        }
        return "";
    }

  
    public String getMensajePermitirAprobacionConsejoAcademico() {
        String result = getMensajePermitirAprobacionVicerrectorado();
        if (result.equals("")) {
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION)) {
                return "No se puede registrar esta información, porque el proyecto se encuentra en proceso de aprobación por Vicerrectorado";
            }
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_RECHAZADO_VICERRECTORADO)) {
                return "No se puede registrar esta información, porque el proyecto ha sido rechazado por Vicerrectorado";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirEjecucion() {
        String result = getMensajePermitirAprobacionConsejoAcademico();
        if (result.equals("")) {
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_APROBADO_VICERRECTORADO)) {
                return "No se puede registrar esta información, porque el proyecto se encuentra en proceso de aprobación por el consejo académico";
            }
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_RECHAZADO_CONSEJO_ACADEMICO)) {
                return "No se puede registrar esta información, porque el proyecto ha sido rechazado por el consejo académico";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirCierre() {
        String result = getMensajePermitirEjecucion();
        if (result.equals("")) {
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_APROBADO_CONSEJO_ACADEMICO)) {
                return "No se puede registrar esta información, porque el proyecto se encuentra en proceso de ejecución";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirEvaluacionFinal() {
        String result = getMensajePermitirCierre();
        if (result.equals("")) {
            if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_CERRADO_EJECUCION)) {
                return "No se puede registrar esta información, porque el proyecto se encuentra en proceso de cierre";
            }
            if (configuracionParametrosEvaluacionFinal == null) {
                return "No se puede registrar esta información, porque no existe una configuración activa de parámetros de evaluación final";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getMensajePermitirFinalizarEvaluacionFinal() {
        String result = getMensajePermitirEvaluacionFinal();
        if (result.equals("")) {
            if (evaluacionFinalList == null || evaluacionFinalList.isEmpty()) {
                return "No se puede registrar esta información, porque no se ha registrado la evaluación final";
            }
        } else {
            return result;
        }
        return "";
    }

    public String getEstadoStr() {
        if (estado!=null){
            return estado.getPrdDescripcion();
        }
        return "";
    }

    public ConfiguracionParametrosEvaluacion getConfiguracionParametrosEvaluacionFinal() {
        return configuracionParametrosEvaluacionFinal;
    }

    public void setConfiguracionParametrosEvaluacionFinal(ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionFinal) {
        this.configuracionParametrosEvaluacionFinal = configuracionParametrosEvaluacionFinal;
    }

    public Date getFechaAprobacionVicerrectorado() {
        return fechaAprobacionVicerrectorado;
    }

    public void setFechaAprobacionVicerrectorado(Date fechaAprobacionVicerrectorado) {
        this.fechaAprobacionVicerrectorado = fechaAprobacionVicerrectorado;
    }

    public String getObservacionAprobacionVicerrectorado() {
        return observacionAprobacionVicerrectorado;
    }

    public void setObservacionAprobacionVicerrectorado(String observacionAprobacionVicerrectorado) {
        this.observacionAprobacionVicerrectorado = observacionAprobacionVicerrectorado;
    }

    public List<AnexoProyecto> getAnexoDiagnosticoProblemaList() {
        return anexoDiagnosticoProblemaList;
    }

    public void setAnexoDiagnosticoProblemaList(List<AnexoProyecto> anexoDiagnosticoProblemaList) {
        this.anexoDiagnosticoProblemaList = anexoDiagnosticoProblemaList;
    }

    public List<AnexoProyecto> getAnexoDocumentoProyectoList() {
        return anexoDocumentoProyectoList;
    }

    public void setAnexoDocumentoProyectoList(List<AnexoProyecto> anexoDocumentoProyectoList) {
        this.anexoDocumentoProyectoList = anexoDocumentoProyectoList;
    }

    public void initAnexos() {
        if (anexoDiagnosticoProblemaList == null) {
            anexoDiagnosticoProblemaList = new ArrayList<>();
        }
        if (anexoDocumentoProyectoList == null) {
            anexoDocumentoProyectoList = new ArrayList<>();
        }
        for (AnexoProyecto anexo : anexoProyectoList) {
            if (anexo.getTipo().equals(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA)) {
                anexoDiagnosticoProblemaList.add(anexo);
            } else {
                anexoDocumentoProyectoList.add(anexo);
            }

        }
    }

    public boolean existeAnexo(AnexoProyecto anexo) {
        if (anexo.getTipo().equals(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA)) {
            return existeAnexo(anexo.getArchivoNombre(), AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA);
        } else {
            return existeAnexo(anexo.getArchivoNombre(), null);
        }

    }

    private boolean existeAnexo(String nombreArchivo, Integer tipo) {
        if (anexoProyectoList != null) {
            for (AnexoProyecto anexo : anexoProyectoList) {
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

    public String getEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(String estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public void addEvaluacionFinal(EvaluacionFinalProyecto evaluacionFinalProyecto) {
        if (evaluacionFinalList == null) {
            evaluacionFinalList = new ArrayList<>();
        }
        evaluacionFinalList.add(evaluacionFinalProyecto);
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

    public Date getFechaRecordatorioAvance() {
        return fechaRecordatorioAvance;
    }

    public void setFechaRecordatorioAvance(Date fechaRecordatorioAvance) {
        this.fechaRecordatorioAvance = fechaRecordatorioAvance;
    }

    public String getMailDirector() {
        if (getDirector() != null) {
            return getDirector().getUsuario().getUsuEmail();
        }
        return null;
    }

    public String getNombreDirector() {
        if (getDirector() != null) {
            return getDirector().getUsuario().getUsuNombres() + " " + getDirector().getUsuario().getUsuApellidos();
        }
        return null;
    }

    public Integer getNroBeneficiariosIndirectos() {
        return nroBeneficiariosIndirectos;
    }

    public void setNroBeneficiariosIndirectos(Integer nroBeneficiariosIndirectos) {
        this.nroBeneficiariosIndirectos = nroBeneficiariosIndirectos;
    }

    public Integer getTotalDocentesEjecutado() {
        Integer total = 0;
        for (ResponsableProyecto resp : getParticipanteDocenteList()) {
            if (resp.getHorasDedicadasList().size() > 0) {
                total++;
            }
        }
        return total;
    }

    public Integer getTotalEstudiantesEjecutado() {
        Integer total = 0;
        for (ResponsableProyecto resp : getParticipanteEstudianteList()) {
            if (resp.getHorasDedicadasList().size() > 0) {
                total++;
            }
        }
        return total;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }

    public Integer getNroTotalCertificadosEstudiante() {
        return getNroTotalCertificadosXTipoResponsable(TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE);
    }

    public Integer getNroTotalCertificadosDocente() {
        return getNroTotalCertificadosXTipoResponsable(TipoResponsable.TIPO_DIRECTOR)
                + getNroTotalCertificadosXTipoResponsable(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE);
    }

    private Integer getNroTotalCertificadosXTipoResponsable(Integer tipoResponsable) {
        Integer result = 0;
        for (ResponsableProyecto resp : responsableList) {
            if (resp.getTipoResponsable().getId().equals(tipoResponsable)) {
                try {
                    result += resp.getNroCertificadosEmtregados();
                } catch (Exception e) {
                }

            }
        }
        return result;
    }
    @Transient
    private Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getCoberturaStr() {
        if (null != cobertura2) {
            return cobertura2.getPrdDescripcion();
        }
        return "";
    }

    public Integer getPuntajeEvaluacionPertinencia() {
        return getEvaluacionFinal().getPuntajeEvaluacionFinalPertinencia();
    }

    public Integer getPuntajeEvaluacionEficacia() {
        return getEvaluacionFinal().getPuntajeEvaluacionFinalEficacia();
    }

    public Integer getPuntajeEvaluacionEficiencia() {
        return getEvaluacionFinal().getPuntajeEvaluacionFinalEficiencia();
    }

    public Integer getPuntajeEvaluacionSostenibilidad() {
        return getEvaluacionFinal().getPuntajeEvaluacionFinalSostenibilidad();
    }
    public Integer getPuntajeEvaluacionPertinenciaMaximo() {
        return getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalPertinencia();
    }

    public Integer getPuntajeEvaluacionEficaciaMaximo() {
        return getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalEficacia();
    }

    public Integer getPuntajeEvaluacionEficienciaMaximo() {
        return getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalEficiencia();
    }

    public Integer getPuntajeEvaluacionSostenibilidadMaximo() {
        return getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalSostenibilidad();
    }
   
    public Integer getPuntajeEvaluacionMaximo() {
        return getEvaluacionFinal().getPuntajeEvaluacionFinalMaximo();
    }    
    
    public Integer getPuntajeTotalEvaluacionFinal() {
        return getEvaluacionFinal().getPuntajeEvaluacionFinalTotal();
    }

    public boolean isTipoPoblacionBeneficiariaUrbanoMarginal() {
        return verificarTipoPoblacionBeneficiariaRural(SeaParametrosDet.PARAM_TIPO_POBLACION_BENEFICIARIA_URBANO_MARGINAL);
    }

    public boolean isTipoPoblacionBeneficiariaRural() {
        return verificarTipoPoblacionBeneficiariaRural(SeaParametrosDet.PARAM_TIPO_POBLACION_BENEFICIARIA_RURAL);
    }

    public boolean isTipoPoblacionGrupoAtencionPrioritaria() {
        return verificarTipoPoblacionBeneficiariaRural(SeaParametrosDet.PARAM_TIPO_POBLACION_GRUPO_ATENCION_PRIORITARIA);
    }

    public boolean verificarTipoPoblacionBeneficiariaRural(Long tipo) {
        if (tipoPoblacionList != null) {
            for (TipoPoblacionProyecto t : tipoPoblacionList) {
                if (t.getTipoPoblacion().getPrdId().equals(tipo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarCronogramaIngresado() {
        Date fecha1 = getFechaInicio();
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(fecha1);
        cal2.setTime(fecha1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        Date fechaI = cal1.getTime();
        cal2.set(Calendar.HOUR_OF_DAY, 23);
        cal2.set(Calendar.MINUTE, 59);
        cal2.set(Calendar.SECOND, 59);
        Date fechaF = cal2.getTime();
        if (objetivoProyectoList != null && !objetivoProyectoList.isEmpty()) {
            for (ObjetivoPrograma obj : getActividades()) {
                if (obj.getFechaInicio() == null || obj.getFechaFin() == null) {
                    //return false;
                    continue;
                }
                if (obj.getFechaInicio().equals(fechaI) && obj.getFechaFin().equals(fechaF)){
                    //return false;
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    public Stvmajr getCarrera() {
        return carrera;
    }

    public void setCarrera(Stvmajr carrera) {
        this.carrera = carrera;
    }

    @Transient
    private boolean calificacionFinalizada;

    public boolean isCalificacionFinalizada() {
        if (getCalificacionActualXUsuario() != null) {
            if (getCalificacionActualXUsuario().getEstadoFinalizado() != null && getCalificacionActualXUsuario().getEstadoFinalizado().equals(CalificacionProyecto.ESTADO_FINALIZADO_SI)) {
                return true;
            }
        }
        return false;
    }

    public void setCalificacionFinalizada(boolean calificacionFinalizada) {
        this.calificacionFinalizada = calificacionFinalizada;
    }

    @Transient
    private boolean asignadoComision;

    public boolean isAsignadoComision() {
        if (comisionCalificacion != null) {
            return true;
        }
        return false;
    }

    public void setAsignadoComision(boolean asignadoComision) {
        this.asignadoComision = asignadoComision;
    }

    public void setearEstadoDirector() {
        ResponsableProyecto directorNuevo=null;
        for (ResponsableProyecto resp : responsableList) {
            if (resp.getId()==null && resp.getTipoResponsable().getId().equals(TipoResponsable.TIPO_DIRECTOR)) {
                directorNuevo=resp;
                break;
            }
        }
        if (directorNuevo!=null){
            for (ResponsableProyecto resp : responsableList) {
                if (resp.getId()!=null && resp.getTipoResponsable().getId().equals(TipoResponsable.TIPO_DIRECTOR)){
                    resp.setEstado(ResponsableProyecto.ESTADO_INACTIVO);
                }
            }
            directorNuevo.setFechaCreacion(new Date());
        }

    }

    public String getActaCompromisoDirectorProyectoNombre() {
        return actaCompromisoDirectorProyectoNombre;
    }

    public void setActaCompromisoDirectorProyectoNombre(String actaCompromisoDirectorProyectoNombre) {
        this.actaCompromisoDirectorProyectoNombre = actaCompromisoDirectorProyectoNombre;
    }

    public String getActaCompromisoDirectorProyectoUrl() {
        return actaCompromisoDirectorProyectoUrl;
    }

    public void setActaCompromisoDirectorProyectoUrl(String actaCompromisoDirectorProyectoUrl) {
        this.actaCompromisoDirectorProyectoUrl = actaCompromisoDirectorProyectoUrl;
    }

    public String getActaCompromisoCarrerasNombre() {
        return actaCompromisoCarrerasNombre;
    }

    public void setActaCompromisoCarrerasNombre(String actaCompromisoCarrerasNombre) {
        this.actaCompromisoCarrerasNombre = actaCompromisoCarrerasNombre;
    }

    public String getActaCompromisoCarrerasUrl() {
        return actaCompromisoCarrerasUrl;
    }

    public void setActaCompromisoCarrerasUrl(String actaCompromisoCarrerasUrl) {
        this.actaCompromisoCarrerasUrl = actaCompromisoCarrerasUrl;
    }

    public String getActaCompromisoDirectorProyectoUrlFinal() {
        try {
            return this.actaCompromisoDirectorProyectoUrl + this.actaCompromisoDirectorProyectoNombre;
        } catch (Exception e) {
            return null;
        }
    }
    public String getActaCompromisoCarrerasUrlFinal() {
        try {
            return this.actaCompromisoCarrerasUrl + this.actaCompromisoCarrerasNombre;
        } catch (Exception e) {
            return null;
        }
    }

    public Date getFechaFinalizacionPerfil() {
        return fechaFinalizacionPerfil;
    }

    public void setFechaFinalizacionPerfil(Date fechaFinalizacionPerfil) {
        this.fechaFinalizacionPerfil = fechaFinalizacionPerfil;
    }

    public String getNroActaAprobacionConsejoDep() {
        return nroActaAprobacionConsejoDep;
    }

    public void setNroActaAprobacionConsejoDep(String nroActaAprobacionConsejoDep) {
        this.nroActaAprobacionConsejoDep = nroActaAprobacionConsejoDep;
    }

    public Date getFechaActaAprobacionConsejoDep() {
        return fechaActaAprobacionConsejoDep;
    }

    public void setFechaActaAprobacionConsejoDep(Date fechaActaAprobacionConsejoDep) {
        this.fechaActaAprobacionConsejoDep = fechaActaAprobacionConsejoDep;
    }

    public String getNombreDocAprobacionVicerrectorado() {
        return nombreDocAprobacionVicerrectorado;
    }

    public void setNombreDocAprobacionVicerrectorado(String nombreDocAprobacionVicerrectorado) {
        this.nombreDocAprobacionVicerrectorado = nombreDocAprobacionVicerrectorado;
    }

    public String getUrlDocAprobacionVicerrectorado() {
        return urlDocAprobacionVicerrectorado;
    }

    public void setUrlDocAprobacionVicerrectorado(String urlDocAprobacionVicerrectorado) {
        this.urlDocAprobacionVicerrectorado = urlDocAprobacionVicerrectorado;
    }

    public String getNroActaAprobacionVicerrectorado() {
        return nroActaAprobacionVicerrectorado;
    }

    public void setNroActaAprobacionVicerrectorado(String nroActaAprobacionVicerrectorado) {
        this.nroActaAprobacionVicerrectorado = nroActaAprobacionVicerrectorado;
    }

    public Date getFechaActaAprobacionVicerrectorado() {
        return fechaActaAprobacionVicerrectorado;
    }

    public void setFechaActaAprobacionVicerrectorado(Date fechaActaAprobacionVicerrectorado) {
        this.fechaActaAprobacionVicerrectorado = fechaActaAprobacionVicerrectorado;
    }


    public String getUrlFinalDocAprobacionVicerrectorado() {
        try {
            return this.urlDocAprobacionVicerrectorado + this.nombreDocAprobacionVicerrectorado;
        } catch (Exception e) {
            return null;
        }
    }

    public String getNroActaAprobacionConsejoAcademico() {
        return nroActaAprobacionConsejoAcademico;
    }

    public void setNroActaAprobacionConsejoAcademico(String nroActaAprobacionConsejoAcademico) {
        this.nroActaAprobacionConsejoAcademico = nroActaAprobacionConsejoAcademico;
    }

    public String getCartaCompromisoComunidadUrl() {
        return cartaCompromisoComunidadUrl;
    }

    public void setCartaCompromisoComunidadUrl(String cartaCompromisoComunidadUrl) {
        this.cartaCompromisoComunidadUrl = cartaCompromisoComunidadUrl;
    }

    public String getCartaCompromisoComunidadNombre() {
        return cartaCompromisoComunidadNombre;
    }

    public void setCartaCompromisoComunidadNombre(String cartaCompromisoComunidadNombre) {
        this.cartaCompromisoComunidadNombre = cartaCompromisoComunidadNombre;
    }
    
    public String getCartaCompromisoComunidadUrlFinal() {
        try {
            return this.cartaCompromisoComunidadUrl + this.cartaCompromisoComunidadNombre;
        } catch (Exception e) {
            return null;
        }
    }

    public Date getFechaFinalizacioEjecucion() {
        return fechaFinalizacioEjecucion;
    }

    public void setFechaFinalizacioEjecucion(Date fechaFinalizacioEjecucion) {
        this.fechaFinalizacioEjecucion = fechaFinalizacioEjecucion;
    }

    public Date getFechaMaximaCorreccion() {
        return fechaMaximaCorreccion;
    }

    public void setFechaMaximaCorreccion(Date fechaMaximaCorreccion) {
        this.fechaMaximaCorreccion = fechaMaximaCorreccion;
    }

    public Integer getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
    }
    
    public boolean verificarEvaluacionFinal(){
         if (evaluacionFinalList == null || evaluacionFinalList.isEmpty()) {
             return false;
         }
         return getEvaluacionFinal().verificarEvaluacion();
    }

    public SeaParametrosDet getEstado() {
        return estado;
    }

    public void setEstado(SeaParametrosDet estado) {
        this.estado = estado;
    }
    
    private boolean verificarEstado(Long estado){
        return this.estado.getPrdId().equals(estado);
    }
    
    public boolean isEstadoIngresoPerfil(){
        return verificarEstado(SeaParametrosDet.ESTADO_CREADO);
    }
    public boolean isEstadoEnviadoRevision(){
        return verificarEstado(SeaParametrosDet.ESTADO_REVISION);
    }
    public boolean isEstadoEnCalificacionComision(){
        return verificarEstado(SeaParametrosDet.ESTADO_CERRADO_PERFIL);
    }
    public boolean isEstadoEnConsolidacionCalificacionComision(){
        return verificarEstado(SeaParametrosDet.ESTADO_CERRADO_CALIFICACION);
    }
    public boolean isEstadoNoAprobadoComision(){
        return verificarEstado(SeaParametrosDet.ESTADO_RECHAZADO_COMISION_VINCULACION);
    }
    public boolean isEstadoAprobacionVicerrectorado(){
        return verificarEstado(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION);
    }
    public boolean isEstadoNoAprobadoVicerrectorado(){
        return verificarEstado(SeaParametrosDet.ESTADO_RECHAZADO_VICERRECTORADO);
    }
    public boolean isEstadoAprobacionConsejoAcademico(){
        return verificarEstado(SeaParametrosDet.ESTADO_APROBADO_VICERRECTORADO);
    }
    public boolean isEstadoNoAprobadoConsejoAcademico(){
        return verificarEstado(SeaParametrosDet.ESTADO_RECHAZADO_CONSEJO_ACADEMICO);
    }
    public boolean isEstadoEjecucion(){
        return verificarEstado(SeaParametrosDet.ESTADO_APROBADO_CONSEJO_ACADEMICO);
    }
    public boolean isEstadoCierre(){
        return verificarEstado(SeaParametrosDet.ESTADO_CERRADO_EJECUCION);
    }
    public boolean isEstadoEvaluacionFinal(){
        return verificarEstado(SeaParametrosDet.ESTADO_CERRADO);
    }
    public boolean isEstadoFinalizado(){
        return verificarEstado(SeaParametrosDet.ESTADO_EVALUADO);
    }

    public SeaParametrosDet getCobertura2() {
        return cobertura2;
    }

    public void setCobertura2(SeaParametrosDet cobertura2) {
        this.cobertura2 = cobertura2;
    }


    private boolean verificarCobertura(Long cobertura){
        return this.cobertura2.getPrdId().equals(cobertura);
    }
    public boolean isCoberturaNacional(){
        return verificarCobertura(SeaParametrosDet.COBERTURA_NACIONAL);
    }    
    public boolean isCoberturaProvincial(){
        return verificarCobertura(SeaParametrosDet.COBERTURA_PROVINCIAL);
    }    
    public boolean isCoberturaCantonal(){
        return verificarCobertura(SeaParametrosDet.COBERTURA_CANTONAL);
    }    
    public boolean isCoberturaParroquial(){
        return verificarCobertura(SeaParametrosDet.COBERTURA_PARROQUIAL);
    }    

    public ActaAprobacionVicerrectorado getActaAprobacionVicerrectorado() {
        return actaAprobacionVicerrectorado;
    }

    public void setActaAprobacionVicerrectorado(ActaAprobacionVicerrectorado actaAprobacionVicerrectorado) {
        this.actaAprobacionVicerrectorado = actaAprobacionVicerrectorado;
    }


    @Transient    
    private Long aprobadoVicerrectorado;

    public Long getAprobadoVicerrectorado() {
        return aprobadoVicerrectorado;
    }

    public void setAprobadoVicerrectorado(Long aprobadoVicerrectorado) {
        this.aprobadoVicerrectorado = aprobadoVicerrectorado;
    }


    @Transient
    private String estadoAprobVicerrectorado;

    public String getEstadoAprobVicerrectorado() {
        if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION)){
            return "P";
        }
        else if (estado.getPrdId().equals(SeaParametrosDet.ESTADO_RECHAZADO_VICERRECTORADO)){
            return "N";
        }
        else{
            return "A";
        }
    }

    public void setEstadoAprobVicerrectorado(String estadoAprobVicerrectorado) {
        this.estadoAprobVicerrectorado = estadoAprobVicerrectorado;
    }

    public String getEfectoEsperado() {
        return efectoEsperado;
    }

    public void setEfectoEsperado(String efectoEsperado) {
        this.efectoEsperado = efectoEsperado;
    }

    public List<ImpactoEsperado> getImpactoEsperadoList() {
        return impactoEsperadoList;
    }

    public void setImpactoEsperadoList(List<ImpactoEsperado> impactoEsperadoList) {
        this.impactoEsperadoList = impactoEsperadoList;
    }
    
}
