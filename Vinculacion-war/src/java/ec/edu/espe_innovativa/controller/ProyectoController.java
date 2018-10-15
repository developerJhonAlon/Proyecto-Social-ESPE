/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

//<editor-fold defaultstate="collapsed" desc="Import">
import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvterm;
import ec.edu.espe_ctt.saturno.session.StvmajrFacade;
import ec.edu.espe_ctt.saturno.session.StvtermFacade;
import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt.vinculacion.entity.ActaDesignacionResponsable;
import ec.edu.espe_ctt.vinculacion.entity.AnexoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.AspectoEvaluacionFinal;
import ec.edu.espe_ctt.vinculacion.entity.CarreraProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Convocatoria;
import ec.edu.espe_ctt.vinculacion.entity.DepartamentoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.HitoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.PresupuestoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.AvanceActividad;
import ec.edu.espe_ctt.vinculacion.entity.AvanceComponente;
import ec.edu.espe_ctt.vinculacion.entity.CalificacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.ComisionCalificacion;
import ec.edu.espe_ctt.vinculacion.entity.CompromisoParticipacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Configuracion;
import ec.edu.espe_ctt.vinculacion.entity.ConfiguracionParametrosEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ConsolidacionCalificacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.DetalleCalificacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.DetalleEvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.DocumentoCompromisoParticipacion;
import ec.edu.espe_ctt.vinculacion.entity.EvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.HorasResponsableProyecto;
import ec.edu.espe_ctt.vinculacion.entity.ImpactoEsperado;
import ec.edu.espe_ctt.vinculacion.entity.ImpactoEsperadoTipo;
import ec.edu.espe_ctt.vinculacion.entity.MiembroComisionCalificacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.PartidaPresupuestaria;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivir;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoEstrategico;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivirPrograma;
import ec.edu.espe_ctt.vinculacion.entity.IndicadorEstrategiaProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Institucion;
import ec.edu.espe_ctt.vinculacion.entity.LineaInvestigacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import ec.edu.espe_ctt.vinculacion.entity.LocalizacionPrograma;
import ec.edu.espe_ctt.vinculacion.entity.TipoPoblacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.TipoResponsable;
import ec.edu.espe_ctt.vinculacion.entity.VDirectorCarrera;
import ec.edu.espe_ctt.vinculacion.entity.VDirectorDepartamento;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.entity.VEstudiante;
import ec.edu.espe_ctt.vinculacion.entity.VEstudianteCarreraPregrado;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.session.ActaDesignacionResponsableFacade;
import ec.edu.espe_ctt.vinculacion.session.AnexoProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.CalificacionProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.CarreraProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ComisionCalificacionFacade;
import ec.edu.espe_ctt.vinculacion.session.CompromisoParticipacionProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionFacade;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionParametrosEvaluacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ConsolidacionCalificacionProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ConvocatoriaFacade;
import ec.edu.espe_ctt.vinculacion.session.DepartamentoProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.EvaluacionFinalProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.HorasResponsableProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ImpactoEsperadoFacade;
import ec.edu.espe_ctt.vinculacion.session.ImpactoEsperadoTipoFacade;
import ec.edu.espe_ctt.vinculacion.session.IndicadorEstrategiaProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.LineaInvestigacionProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.PartidaPresupuestariaFacade;
import ec.edu.espe_ctt.vinculacion.session.PresupuestoProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ResponsableProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoBVivirFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoEstrategicoFacade;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.VDirectorCarreraFacade;
import ec.edu.espe_ctt.vinculacion.session.VDirectorDepartamentoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import ec.edu.espe_ctt.vinculacion.session.VistaEstudianteCarreraPregradoFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.session.SeaLineainvesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProvinciaFacade;
import ec.edu.espe_innovativa.util.FacesUtils;
import ec.edu.espe_innovativa.util.JasperReportUtil;
import ec.edu.espe_innovativa.util.NumeroALetras;
import ec.edu.espe_matriz.wsClient.WSEnvioMail;
import ec.edu.espe_matriz.wsClient.WSEnvioMail_Service;
import java.io.ByteArrayInputStream;
import static java.io.File.separatorChar;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.extensions.component.timeline.TimelineUpdater;
import org.primefaces.extensions.event.timeline.TimelineAddEvent;
import org.primefaces.extensions.event.timeline.TimelineModificationEvent;
import org.primefaces.extensions.event.timeline.TimelineRangeEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineGroup;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.Visibility;

//</editor-fold>
/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ProyectoController implements Serializable {

//<editor-fold defaultstate="collapsed" desc="Atributos">
    @EJB
    private SegUsuarioFacade usuarioFacade;
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;
    @EJB
    private ProgramaFacade programaFacade;
    @EJB
    private ProyectoFacade proyectoFacade;
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    @EJB
    private DepartamentoProyectoFacade departamentoProyectoFacade;
    @EJB
    private CarreraProyectoFacade carreraProyectoFacade;
    @EJB
    private StvmajrFacade carreraFacade;
    @EJB
    private ObjetivoProgramaFacade objetivoProgramaFacade;
    @EJB
    private SeaProvinciaFacade provinciaFacade;
    @EJB
    private ObjetivoBVivirFacade svinObjBVivirFacade;
    @EJB
    private ObjetivoEstrategicoFacade objetivoEstrategicoFacade;
    @EJB
    private CalificacionProyectoFacade calificacionProyectoFacade;
    @EJB
    private ComisionCalificacionFacade comisionCalificacionFacade;
    @EJB
    private ConsolidacionCalificacionProyectoFacade consolidacionCalificacionProyectoFacade;
    @EJB
    private StvtermFacade periodoFacade;
    @EJB
    private VistaEstudianteCarreraPregradoFacade vEstudianteCarreraPregradoFacade;
    @EJB
    private ImpactoEsperadoTipoFacade impactoEsperadoTipoFacade;
    @EJB
    private ImpactoEsperadoFacade impactoEsperadoFacade;

    private List<SeaParametrosDet> tipoPoblacionList;
    private List<SeaParametrosDet> tipoPoblacionSelectedList;
    private List<SeaParametrosDet> paramTipoAdquisicionProyectoList;
    private List<DepartamentoProyecto> departamentoProyectoList;
    private List<CarreraProyecto> carreraProyectoList;
    private List<Stvmajr> carreraList;
    private List<SeaProvincia> provinciaList;
    private List<HitoProyecto> hitoProyectoList;
    private List<SeaParametrosDet> paramSemestreList;
    private List<ObjetivoBVivir> objBVivirPadreList;
    private List<ObjetivoBVivir> objBVivirHijoList;
    private List<ObjetivoEstrategico> perspectivasList;
    private List<ObjetivoEstrategico> milenioList;
     private List<ObjetivoEstrategico> unescoList;
    private List<ImpactoEsperadoTipo> impactoEsperadoTipoList;
    private List<ImpactoEsperado> impactoEsperadoList;
    private List<ComisionCalificacion> comisionCalificacionList;

    private Proyecto proyectoSelected;
    //private Programa programaSelected;
    private CarreraProyecto carreraProyectoSelected;
    private ObjetivoPrograma objetivoProyectoSelected;
    private ObjetivoPrograma objetivoProyectoPadreSelected;
    private ObjetivoBVivirPrograma objetivoBVivirSelected;
    private DepartamentoProyecto departamentoProyectoSelected;
    private HitoProyecto hitoProyectoSelected;
    private VDocenteVinculacion2 docenteSelected;
    private ObjetivoBVivir objBVivirPadre = new ObjetivoBVivir();
    private ObjetivoBVivir objBVivirHijo = new ObjetivoBVivir();
    private ObjetivoEstrategico perspectivaSelected;
    private ObjetivoEstrategico milenioSelected;
    private ImpactoEsperado impactoEsperadoSelected;
    private ObjetivoEstrategico objetivoEstrategicoSelected;
    private IndicadorEstrategiaProyecto indicadorEstrategiaProyectoSelected;
    private CalificacionProyecto calificacionProyectoSelected;

    private Integer codProgramaSelected;
    private boolean controlGrabar;
    private boolean datosCompletos;
    private int indiceTabActivo;
    private int indiceTabActivoEjecucion;
    private TreeNode root3;
    private TreeNode[] selectedNodes2;
    private String nomDocenteBusqueda = "";
    private Stvmajr carreraSelected;
    private SegUsuario usuarioActual;
    private List<SegPerfil> perfilUsuarioActual;
    private List<Programa> programaList;
    private List<SeaParametrosDet> coberturaList;
    private List<VDirectorDepartamento> directorDepartamentoList;
    private List<VDirectorCarrera> directorCarreraList;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Constructor">
    public ProyectoController() {
        objetivoProyectoSelected = new ObjetivoPrograma();
        departamentoProyectoSelected = new DepartamentoProyecto();
        carreraProyectoSelected = new CarreraProyecto();
        impactoEsperadoSelected = new ImpactoEsperado();
        hitoProyectoSelected = new HitoProyecto();
        objetivoBVivirSelected = new ObjetivoBVivirPrograma();

        datosCompletos = false;
        controlGrabar = false;
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Init">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        perfilUsuarioActual = (List<SegPerfil>) context.getExternalContext().getSessionMap().get("usu_perfil");

        tipoPoblacionList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_TIPO_POBLACION);
        coberturaList = parametrosDetFacade.findByCodigoParametroActivos(SeaParametros.PARAM_COBERTURA);

        campusList = new ArrayList<>();
        directorDepartamentoList = directorDepartamentoFacade.findAll();
        for (VDirectorDepartamento dir : directorDepartamentoList) {
            if (dir.getCampus() != null && dir.getDepartamento() != null) {
                boolean encontro = false;
                for (Stvcamp camp : campusList) {
                    if (camp.equals(dir.getCampus())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    Stvcamp cam = dir.getCampus();
                    for (VDirectorDepartamento dir2 : directorDepartamentoList) {
                        if (dir2.getCampus() != null && dir2.getDepartamento() != null) {
                            if (dir2.getCampus().equals(cam)) {
                                cam.addDepartamento(dir2.getDepartamento());
                            }

                        }
                    }
                    campusList.add(cam);
                }
            }

        }
        Collections.sort(campusList);
        programaList = programaFacade.findXEstado(null);
        paramTipoAdquisicionProyectoList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_TIPO_ADQUISICION_PROYECTO);
        paramSemestreList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_SEMESTRE);
        provinciaList = provinciaFacade.findAllOrdenados();
        carreraList = carreraFacade.findCarrera();
        objBVivirPadreList = svinObjBVivirFacade.findObjetivosPadre();
        indicadorEstrategiaProyectoSelected = new IndicadorEstrategiaProyecto();
        modoEdicion = false;

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("calificacion");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("calificacionFinal");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("configuracionParametrosEvaluacionActual");

        Object idProyecto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProyecto");
        if (idProyecto != null) {
            proyectoSelected = proyectoFacade.findById(Integer.valueOf(idProyecto.toString()));
            seleccionarProyecto();

        } else { //Nuevo Proyecto
            modoEdicion = true;
            permitirEditarTipoProyecto = true;
            //Object idPrograma = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPrograma");
            //programaSelected = programaFacade.find(Integer.valueOf(idPrograma.toString()));
            proyectoSelected = new Proyecto();

            proyectoSelected.setConvocatoria(convocatoriaFacade.findByActiva());

            docenteSelected = new VDocenteVinculacion2();
            nomDocenteBusqueda = "";
            llenarDatosDocenteXUsuId(usuarioActual.getUsuId());
            if (docenteSelected != null) {
                for (Stvcamp cam : campusList) {
                    if (cam.equals(docenteSelected.getCampus())) {
                        proyectoSelected.setCampus(cam);
                        break;
                    }
                }
                proyectoSelected.setDepartamento(docenteSelected.getDepartamento());
                ResponsableProyecto svinResponsableProg = new ResponsableProyecto();
                svinResponsableProg.setTipoResponsable(new TipoResponsable(TipoResponsable.TIPO_DIRECTOR));
                svinResponsableProg.setUsuario(docenteSelected.getUsuario());
                svinResponsableProg.setDepartamento(docenteSelected.getDepartamento());
                svinResponsableProg.setCampus(docenteSelected.getCampus());
                proyectoSelected.addResponsable(svinResponsableProg);
            }
            tipoPoblacionSelectedList = new ArrayList<>();
            controlGrabar = true;

        }
        crearArbolMenu(SeaParametrosDet.ESTADO_CREADO);
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public IndicadorEstrategiaProyecto getIndicadorEstrategiaProyectoSelected() {
        return indicadorEstrategiaProyectoSelected;
    }

    public void setIndicadorEstrategiaProyectoSelected(IndicadorEstrategiaProyecto indicadorEstrategiaProyectoSelected) {
        this.indicadorEstrategiaProyectoSelected = indicadorEstrategiaProyectoSelected;
    }

    public ObjetivoEstrategico getPerspectivaSelected() {
        return perspectivaSelected;
    }

    public void setPerspectivaSelected(ObjetivoEstrategico perspectivaSelected) {
        this.perspectivaSelected = perspectivaSelected;
    }

    public List<ImpactoEsperadoTipo> getImpactoEsperadoTipoList() {
        return impactoEsperadoTipoList;
    }

    public void setImpactoEsperadoTipoList(List<ImpactoEsperadoTipo> impactoEsperadoTipoList) {
        this.impactoEsperadoTipoList = impactoEsperadoTipoList;
    }

    public List<ImpactoEsperado> getImpactoEsperadoList() {
        return impactoEsperadoList;
    }

    public void setImpactoEsperadoList(List<ImpactoEsperado> impactoEsperadoList) {
        this.impactoEsperadoList = impactoEsperadoList;
    }

    public ImpactoEsperado getImpactoEsperadoSelected() {
        return impactoEsperadoSelected;
    }

    public void setImpactoEsperadoSelected(ImpactoEsperado impactoEsperadoSelected) {
        this.impactoEsperadoSelected = impactoEsperadoSelected;
    }
        
    public List<ObjetivoEstrategico> getMilenioList() {
        return milenioList;
    }

    public void setMilenioList(List<ObjetivoEstrategico> milenioList) {
        this.milenioList = milenioList;
    }

    public List<ObjetivoEstrategico> getUnescoList() {
        return unescoList;
    }

    public void setUnescoList(List<ObjetivoEstrategico> unescoList) {
        this.unescoList = unescoList;
    }

    public ObjetivoEstrategico getObjetivoEstrategicoSelected() {
        return objetivoEstrategicoSelected;
    }

    public void setObjetivoEstrategicoSelected(ObjetivoEstrategico objetivoEstrategicoSelected) {
        this.objetivoEstrategicoSelected = objetivoEstrategicoSelected;
    }

    public List<ObjetivoEstrategico> getPerspectivasList() {
        return perspectivasList;
    }

    public void setPerspectivasList(List<ObjetivoEstrategico> perspectivasList) {
        this.perspectivasList = perspectivasList;
    }

    public ObjetivoBVivirPrograma getObjetivoBVivirSelected() {
        return objetivoBVivirSelected;
    }

    public void setObjetivoBVivirSelected(ObjetivoBVivirPrograma objetivoBVivirSelected) {
        this.objetivoBVivirSelected = objetivoBVivirSelected;
    }

    public List<ObjetivoBVivir> getObjBVivirPadreList() {
        return objBVivirPadreList;
    }

    public void setObjBVivirPadreList(List<ObjetivoBVivir> objBVivirPadreList) {
        this.objBVivirPadreList = objBVivirPadreList;
    }

    public List<ObjetivoBVivir> getObjBVivirHijoList() {
        return objBVivirHijoList;
    }

    public void setObjBVivirHijoList(List<ObjetivoBVivir> objBVivirHijoList) {
        this.objBVivirHijoList = objBVivirHijoList;
    }

    public ObjetivoBVivir getObjBVivirPadre() {
        return objBVivirPadre;
    }

    public void setObjBVivirPadre(ObjetivoBVivir objBVivirPadre) {
        this.objBVivirPadre = objBVivirPadre;
    }

    public ObjetivoBVivir getObjBVivirHijo() {
        return objBVivirHijo;
    }

    public void setObjBVivirHijo(ObjetivoBVivir objBVivirHijo) {
        this.objBVivirHijo = objBVivirHijo;
    }

    public Stvmajr getCarreraSelected() {
        return carreraSelected;
    }

    public void setCarreraSelected(Stvmajr carreraSelected) {
        this.carreraSelected = carreraSelected;
    }

    public String getNomDocenteBusqueda() {
        return nomDocenteBusqueda;
    }

    public void setNomDocenteBusqueda(String nomDocenteBusqueda) {
        this.nomDocenteBusqueda = nomDocenteBusqueda;
    }

    public List<HitoProyecto> getHitoProyectoList() {
        return hitoProyectoList;
    }

    public void setHitoProyectoList(List<HitoProyecto> hitoProyectoList) {
        this.hitoProyectoList = hitoProyectoList;
    }

    public List<SeaParametrosDet> getParamSemestreList() {
        return paramSemestreList;
    }

    public void setParamSemestreList(List<SeaParametrosDet> paramSemestreList) {
        this.paramSemestreList = paramSemestreList;
    }

    public HitoProyecto getHitoProyectoSelected() {
        return hitoProyectoSelected;
    }

    public void setHitoProyectoSelected(HitoProyecto hitoProyectoSelected) {
        this.hitoProyectoSelected = hitoProyectoSelected;
    }

    public List<SeaParametrosDet> getParamTipoAdquisicionProyectoList() {
        return paramTipoAdquisicionProyectoList;
    }

    public void setParamTipoAdquisicionProyectoList(List<SeaParametrosDet> paramTipoAdquisicionProyectoList) {
        this.paramTipoAdquisicionProyectoList = paramTipoAdquisicionProyectoList;
    }

    public List<DepartamentoProyecto> getDepartamentoProyectoList() {
        return departamentoProyectoList;
    }

    public void setDepartamentoProyectoList(List<DepartamentoProyecto> departamentoProyectoList) {
        this.departamentoProyectoList = departamentoProyectoList;
    }

    public DepartamentoProyecto getDepartamentoProyectoSelected() {
        return departamentoProyectoSelected;
    }

    public void setDepartamentoProyectoSelected(DepartamentoProyecto departamentoProyectoSelected) {
        this.departamentoProyectoSelected = departamentoProyectoSelected;
    }

    public CarreraProyecto getCarreraProyectoSelected() {
        return carreraProyectoSelected;
    }

    public void setCarreraProyectoSelected(CarreraProyecto carreraProyectoSelected) {
        this.carreraProyectoSelected = carreraProyectoSelected;
    }

    public VDocenteVinculacion2 getDocenteSelected() {
        return docenteSelected;
    }

    public void setDocenteSelected(VDocenteVinculacion2 docenteSelected) {
        this.docenteSelected = docenteSelected;
    }

    public List<Stvmajr> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Stvmajr> carreraList) {
        this.carreraList = carreraList;
    }

    public List<CarreraProyecto> getCarreraProyectoList() {
        return carreraProyectoList;
    }

    public void setCarreraProyectoList(List<CarreraProyecto> carreraProyectoList) {
        this.carreraProyectoList = carreraProyectoList;
    }

    public ObjetivoPrograma getObjetivoProyectoSelected() {
        return objetivoProyectoSelected;
    }

    public void setObjetivoProyectoSelected(ObjetivoPrograma objetivoProyectoSelected) {
        this.objetivoProyectoSelected = objetivoProyectoSelected;
    }

    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }

    public Integer getCodProgramaSelected() {
        return codProgramaSelected;
    }

    public void setCodProgramaSelected(Integer codProgramaSelected) {
        this.codProgramaSelected = codProgramaSelected;
    }

    public int getIndiceTabActivo() {
        return indiceTabActivo;
    }

    public void setIndiceTabActivo(int indiceTabActivo) {
        this.indiceTabActivo = indiceTabActivo;
    }

    public String getNombreProySeleccionado() {
        if (proyectoSelected != null && proyectoSelected.getNombre() != null) {
            return ("PROYECTO: " + proyectoSelected.getNombre());
        } else {
            return "NUEVO PROYECTO";
        }
    }

    public Proyecto getProyectoSelected() {
        return proyectoSelected;
    }

    public void setProyectoSelected(Proyecto proyectoSelected) {
        this.proyectoSelected = proyectoSelected;
    }

    public boolean isDatosCompletos() {
        return datosCompletos;
    }

    public void setDatosCompletos(boolean datosCompletos) {
        this.datosCompletos = datosCompletos;
    }

    public List<SeaParametrosDet> getTipoPoblacionList() {
        return tipoPoblacionList;
    }

    public void setTipoPoblacionList(List<SeaParametrosDet> tipoPoblacionList) {
        this.tipoPoblacionList = tipoPoblacionList;
    }

    public List<SeaParametrosDet> getTipoPoblacionSelectedList() {
        return tipoPoblacionSelectedList;
    }

    public void setTipoPoblacionSelectedList(List<SeaParametrosDet> tipoPoblacionSelectedList) {
        this.tipoPoblacionSelectedList = tipoPoblacionSelectedList;
    }

    public TreeNode getRoot3() {
        return root3;
    }

    public void setRoot3(TreeNode root3) {
        this.root3 = root3;
    }

    public TreeNode[] getSelectedNodes2() {
        return selectedNodes2;
    }

    public void setSelectedNodes2(TreeNode[] selectedNodes2) {
        this.selectedNodes2 = selectedNodes2;
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tab1-Datos Generales">
    private List<Stvcamp> campusList;

    public List<Stvcamp> getCampusList() {
        return campusList;
    }

    public void setCampusList(List<Stvcamp> campusList) {
        this.campusList = campusList;
    }

    @EJB
    private VDirectorDepartamentoFacade directorDepartamentoFacade;
    @EJB
    private VDirectorCarreraFacade directorCarreraFacade;

    public void cancelarPerfil() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        for (Stvcamp cam : campusList) {
            if (cam.equals(proyectoSelected.getCampus())) {
                proyectoSelected.setCampus(cam);
                break;
            }
        }
        if (proyectoSelected.getDirector() != null) {
            llenarDatosDocenteXUsuId(proyectoSelected.getDirector().getUsuario().getUsuId());
        }
        tipoPoblacionSelectedList = new ArrayList<>();
        for (TipoPoblacionProyecto tipoPoblacionProyecto : proyectoSelected.getTipoPoblacionList()) {
            tipoPoblacionSelectedList.add(tipoPoblacionProyecto.getTipoPoblacion());
        }

        datosCompletos = false;
        controlGrabar = false;
        modoEdicion = false;
    }

    @EJB
    private ConvocatoriaFacade convocatoriaFacade;

    private Convocatoria convocatoriaAbierta;

    public Convocatoria getConvocatoriaAbierta() {
        return convocatoriaAbierta;
    }

    public void setConvocatoriaAbierta(Convocatoria convocatoriaAbierta) {
        this.convocatoriaAbierta = convocatoriaAbierta;
    }

    public String registraP1() {
        try {
            if (proyectoSelected.getTipoPoblacionList() != null) {
                for (Iterator<TipoPoblacionProyecto> iterator = proyectoSelected.getTipoPoblacionList().iterator(); iterator.hasNext();) {
                    TipoPoblacionProyecto tipoPoblacionProyecto = iterator.next();
                    boolean encontro = false;
                    for (SeaParametrosDet tipoPoblacion : tipoPoblacionSelectedList) {
                        if (tipoPoblacionProyecto.getTipoPoblacion().getPrdId().equals(tipoPoblacion.getPrdId())) {
                            encontro = true;
                            break;
                        }
                    }
                    if (!encontro) {
                        iterator.remove();
                    }
                }

            }

            for (SeaParametrosDet tipoPoblacion : tipoPoblacionSelectedList) {
                boolean encontro = false;
                if (proyectoSelected.getTipoPoblacionList() != null) {
                    for (TipoPoblacionProyecto tipoPoblacionProyecto : proyectoSelected.getTipoPoblacionList()) {
                        if (tipoPoblacion.getPrdId().equals(tipoPoblacionProyecto.getTipoPoblacion().getPrdId())) {
                            encontro = true;
                            break;
                        }
                    }
                }
                if (!encontro) {
                    proyectoSelected.addTipoPoblacion(new TipoPoblacionProyecto(proyectoSelected, tipoPoblacion));
                }
            }

            if (validarVaciosP1()) {
                SegUsuario usu = usuarioFacade.find(docenteSelected.getUsuario().getUsuId());
                usu.setUsuEmail(docenteSelected.getUsuario().getUsuEmail());
                usu.setUsuTelefonoFijo(docenteSelected.getUsuario().getUsuTelefonoFijo());
                usuarioFacade.edit(usu);
                proyectoSelected.setearEstadoDirector();
                if (proyectoSelected.getId() == null) {
                    proyectoSelected.addObjetivoProyecto(new ObjetivoPrograma(proyectoSelected, ObjetivoPrograma.TIPO_FIN, 1));
                    proyectoSelected.addObjetivoProyecto(new ObjetivoPrograma(proyectoSelected, ObjetivoPrograma.TIPO_PROPOSITO, 2));
                    proyectoSelected.generarCodigo(proyectoFacade.findSecuencialByDepartamento(proyectoSelected.getDepartamento().getStvsubjCode()) + 1);
                    proyectoFacade.create(proyectoSelected);
                    /*crearArbolMenu(Proyecto.ESTADO_CREADO);
                    RequestContext.getCurrentInstance().update("formPrincipal");*/
                } else {
                    if (!proyectoSelected.getDepartamento().getStvsubjCode().equals(codDepartamento)) {
                        proyectoSelected.generarCodigo(proyectoFacade.findSecuencialByDepartamento(proyectoSelected.getDepartamento().getStvsubjCode()) + 1);
                    } else if (!proyectoSelected.getTipo().equals(tipoProyecto)) {
                        String[] temp = proyectoSelected.getCodigo().split("-");
                        Integer secuencial = Integer.valueOf(temp[temp.length - 2]);
                        proyectoSelected.generarCodigo(secuencial);
                    }

                    proyectoFacade.edit(proyectoSelected);
                }
                if (getSelectedNodeCode().equals("1.1.1")) {
                    crearArbolMenu(SeaParametrosDet.ESTADO_CREADO);
                }

                //RequestContext.getCurrentInstance().update("formPrincipal");
                cancelarPerfil();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public boolean validarVaciosP1() {
        datosCompletos = true;
        if (proyectoSelected.getConvocatoria() == null && proyectoSelected.getTipo().equals(Proyecto.TIPO_GASTO_NO_PERMANENTE)) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConvocatoria", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Para un proyecto de tipo Gasto No Permanente debe existir una Convocatoria abierta"));
            datosCompletos = false;
        }

        if (proyectoSelected.getTipoPoblacionList() == null || proyectoSelected.getTipoPoblacionList().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:selTipoPoblacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar al menos un tipo de población"));
            datosCompletos = false;
        }
        if (!proyectoSelected.getFechaFinalizacion().after(proyectoSelected.getFechaInicio())) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:fechaFinProyecto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de finalización debe ser mayor que la fecha de inicio"));
            datosCompletos = false;
        }

        if (docenteSelected.getUsuario().getUsuId() == null) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblNombreDirectorProyecto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Campo obligatorio"));
            datosCompletos = false;
        }

        /*datosCompletos = true;
         if (proyectoSelected.getNombre() == null || proyectoSelected.getNombre().trim().isEmpty()
         || proyectoSelected.getFechaPresentacion() == null
         || proyectoSelected.getFechaInicio() == null
         || proyectoSelected.getFechaFinalizacion() == null
         || proyectoSelected.getTipoPoblacion() == null || proyectoSelected.getTipoPoblacion().getPrdId() == null
         || programaSelected.getSvinDepcenproyList() == null || programaSelected.getSvinDepcenproyList().isEmpty()) {
         datosCompletos = false;
         }*/
        return datosCompletos;
    }

    public void validarFechaInicio() {
        if (proyectoSelected.getFechaFinalizacion() != null && proyectoSelected.getFechaFinalizacion().compareTo(proyectoSelected.getFechaInicio()) <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de inicio debe ser menor que la fecha de finalización"));
            proyectoSelected.setFechaInicio(null);
        }
        validarVaciosP1();
    }

    public void validarFechaFin() {
        if (proyectoSelected.getFechaInicio() != null && proyectoSelected.getFechaFinalizacion().compareTo(proyectoSelected.getFechaInicio()) <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de finalización debe ser mayor que la fecha de inicio"));
            proyectoSelected.setFechaFinalizacion(null);
        }
        validarVaciosP1();

    }

    public void eliminarProyecto() {
        try {
            proyectoSelected.setEstadoActivo(Proyecto.ESTADO_PROYECTO_INACTIVO);
            proyectoFacade.edit(proyectoSelected);
            //proyectoFacade.remove(proyectoSelected);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El proyecto ha sido eliminado exitosamente"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("listadoProyectos.xhtml");
        } catch (Exception e) {
        }
    }

    public void seleccionarTipoPoblacion(ValueChangeEvent event) {
        /*Long codSeleccionado = (Long) event.getNewValue();
         for (SeaParametrosDet par : tipoPoblacionList) {
         if (par.getPrdId().equals(codSeleccionado)) {
         proyectoSelected.setTipoPoblacion(par);
         }
         }*/
    }

    public List<String> completeText(String query) {
        System.out.println(" el valor es tar " + query);
        List<VDocenteVinculacion2> doceVincuLista = vistaDocenteFacade.findByName(query);
        System.out.println(" la lista es " + doceVincuLista.size());
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < doceVincuLista.size(); i++) {
            results.add(doceVincuLista.get(i).getUsuario().getUsuApellidos() + " " + doceVincuLista.get(i).getUsuario().getUsuNombres());
        }
        return results;
    }

    public void onItemSelect(SelectEvent event) {
        llenarDatosDocenteXNombres(event.getObject().toString());
        if (docenteSelected != null) {
            for (Stvcamp cam : campusList) {
                if (cam.equals(docenteSelected.getCampus())) {
                    proyectoSelected.setCampus(cam);
                    break;
                }
            }
            proyectoSelected.setDepartamento(docenteSelected.getDepartamento());
        }

        //validarVaciosP1();
    }

    private void llenarDatosDocenteXNombres(String nombresApellidos) {
        List<VDocenteVinculacion2> doceVincuLista = vistaDocenteFacade.findByName(nombresApellidos);
        docenteSelected = doceVincuLista.get(0);
        ResponsableProyecto svinResponsableProg = new ResponsableProyecto();
        svinResponsableProg.setTipoResponsable(new TipoResponsable(TipoResponsable.TIPO_DIRECTOR));
        svinResponsableProg.setUsuario(docenteSelected.getUsuario());
        svinResponsableProg.setDepartamento(docenteSelected.getDepartamento());
        svinResponsableProg.setCampus(docenteSelected.getCampus());
        proyectoSelected.addResponsable(svinResponsableProg);

    }

    private void llenarDatosDocenteXUsuId(BigDecimal usuId) {
        docenteSelected = vistaDocenteFacade.findByUsuId(usuId);
        if (docenteSelected != null) {
            nomDocenteBusqueda = docenteSelected.getUsuario().getUsuApellidos() + " " + docenteSelected.getUsuario().getUsuNombres();
        }
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tab3-Cobertura y Localización">
    public String editarP3() {
        controlGrabar = true;
        return "";
    }

    public void cancelarP3() {
        cancelarPerfil();
        cobertura = proyectoSelected.getCobertura2().getPrdId().intValue();
        root3 = crearArbolCobertura();
        datosCompletos = false;
        controlGrabar = false;
    }

    private Integer cobertura;

    public Integer getCobertura() {
        return cobertura;
    }

    public void setCobertura(Integer cobertura) {
        this.cobertura = cobertura;
    }

    public String registraP3() {
        try {
            //Eliminar los items ingresados incialmente, que han sido deseleccionados
            Iterator<LocalizacionPrograma> it = proyectoSelected.getObjetivosProvCanParr().iterator();
            while (it.hasNext()) {
                LocalizacionPrograma svinZonaDetalleIngresado = it.next();
                boolean encontro = false;
                if (svinZonaDetalleIngresado.getProvincia() != null && !cobertura.equals(SeaParametrosDet.COBERTURA_NACIONAL.intValue())) {
                    for (TreeNode node : selectedNodes2) {
                        LocalizacionPrograma svinZonaDetalleSelected = (LocalizacionPrograma) node.getData();
                        if (svinZonaDetalleIngresado.getCanton() == null && svinZonaDetalleIngresado.getParroquia() == null) {
                            if (svinZonaDetalleIngresado.getProvincia().equals(svinZonaDetalleSelected.getProvincia())) {
                                encontro = true;
                                break;
                            }
                        } else if (svinZonaDetalleIngresado.getParroquia() == null) {
                            if (svinZonaDetalleIngresado.getCanton().equals(svinZonaDetalleSelected.getCanton())) {
                                encontro = true;
                                break;
                            }
                        } else if (svinZonaDetalleIngresado.getParroquia().equals(svinZonaDetalleSelected.getParroquia())) {
                            encontro = true;
                            break;
                        }
                    }
                } else if (svinZonaDetalleIngresado.getProvincia() == null && cobertura.equals(SeaParametrosDet.COBERTURA_NACIONAL.intValue())) {
                    encontro = true;
                }
                if (!encontro) {
                    it.remove();
                }
            }

            //Agregar los items nuevos seleccionados
            if (cobertura.equals(SeaParametrosDet.COBERTURA_NACIONAL.intValue())) {
                LocalizacionPrograma svinZonaDetalleSelected = new LocalizacionPrograma();
                proyectoSelected.addObjetivosProvCanParr(svinZonaDetalleSelected);
            } else {
                for (TreeNode node : selectedNodes2) {
                    LocalizacionPrograma svinZonaDetalleSelected = (LocalizacionPrograma) node.getData();
                    proyectoSelected.addObjetivosProvCanParr(svinZonaDetalleSelected);
                }
            }
            proyectoSelected.setCobertura2(new SeaParametrosDet(new Long(cobertura)));
            proyectoFacade.edit(proyectoSelected);
            cancelarP3();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public String validarVaciosP3() {
        datosCompletos = true;

        if (selectedNodes2.length == 0) {
            datosCompletos = false;
        }
        return "";
    }

    private TreeNode crearArbolCobertura() {
        TreeNode root = new CheckboxTreeNode(new LocalizacionPrograma(), null);
        if (!cobertura.equals(SeaParametrosDet.COBERTURA_NACIONAL.intValue())) {
            for (SeaProvincia provincia : provinciaList) {
                TreeNode nodoProvincia = new CheckboxTreeNode(new LocalizacionPrograma(provincia), root);
                if (cobertura.equals(SeaParametrosDet.COBERTURA_CANTONAL.intValue()) || cobertura.equals(SeaParametrosDet.COBERTURA_PARROQUIAL.intValue())) {
                    for (SeaCanton canton : provincia.getSeaCantonList()) {
                        TreeNode nodoCanton = new CheckboxTreeNode(new LocalizacionPrograma(canton), nodoProvincia);
                        if (cobertura.equals(SeaParametrosDet.COBERTURA_PARROQUIAL.intValue())) {
                            for (SeaParroquia parroquia : canton.getSeaParroquiaList()) {
                                LocalizacionPrograma svinZonaDetalle = new LocalizacionPrograma(parroquia);
                                TreeNode nodoParroquia = new CheckboxTreeNode(svinZonaDetalle, nodoCanton);
                                if (buscarSvinZonaDetalleGuardado(svinZonaDetalle)) {
                                    nodoParroquia.setSelected(true);
                                }
                            }
                        } else {
                            LocalizacionPrograma svinZonaDetalle = new LocalizacionPrograma(canton);
                            if (buscarSvinZonaDetalleGuardado(svinZonaDetalle)) {
                                nodoCanton.setSelected(true);
                            }
                        }
                    }
                } else {
                    LocalizacionPrograma svinZonaDetalle = new LocalizacionPrograma(provincia);
                    if (buscarSvinZonaDetalleGuardado(svinZonaDetalle)) {
                        nodoProvincia.setSelected(true);
                    }

                }
            }
        }

        return root;
    }

    private boolean buscarSvinZonaDetalleGuardado(LocalizacionPrograma svinZonaDetalleBuscar) {
        for (LocalizacionPrograma svinZonaDetalle : proyectoSelected.getObjetivosProvCanParr()) {
            boolean encontro = svinZonaDetalle.comparar(svinZonaDetalleBuscar);
            if (encontro) {
                return true;
            }
        }
        return false;
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tab4-Detalle de entregables del proyecto">
    public String validarVaciosP4() {
        datosCompletos = true;
        if (proyectoSelected.getBienes() == null || proyectoSelected.getBienes().trim().isEmpty()
                || proyectoSelected.getServicios() == null || proyectoSelected.getServicios().trim().isEmpty()
                || proyectoSelected.getBienesServicios() == null || proyectoSelected.getBienesServicios().trim().isEmpty()) {
            datosCompletos = false;
        }
        return "";
    }

    public String registraP4() {
        if ((proyectoSelected.getBienes() == null || proyectoSelected.getBienes().trim().isEmpty())
                && (proyectoSelected.getServicios() == null || proyectoSelected.getServicios().trim().isEmpty())
                && (proyectoSelected.getBienesServicios() == null || proyectoSelected.getBienesServicios().trim().isEmpty())) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:txtBienes", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar por lo menos un bien o servicio"));
        } else {
            registraP1();
        }
        return "";
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tab5-Docentes participantes">
    public void seleccionarDepartamentoParticipante() {
        modoEdicion = true;
        controlGrabar = true;
        datosCompletos = false;

        for (Stvcamp cam : campusList) {
            if (cam.equals(departamentoProyectoSelected.getCampus())) {
                departamentoProyectoSelected.setCampus(cam);
                break;
            }
        }
    }

    public void cancelarP5() {
        controlGrabar = false;
        datosCompletos = false;
        departamentoProyectoList = departamentoProyectoFacade.findByProyecto(proyectoSelected.getId());
    }

    public boolean validarVaciosP5() {
        datosCompletos = true;
        if (departamentoProyectoSelected.getDepartamento() == null || departamentoProyectoSelected.getDepartamento().getStvsubjCode() == null
                || departamentoProyectoSelected.getNroDocentes() == null) {
            datosCompletos = false;
        }
        return datosCompletos;
    }

    public void agregarP5(ActionEvent event) {
        departamentoProyectoSelected = new DepartamentoProyecto(proyectoSelected);
        controlGrabar = true;

    }

    public void eliminarP5() {
        try {
            departamentoProyectoFacade.remove(departamentoProyectoSelected);
            cancelarP5();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public String registraP5() {
        try {
            if (departamentoProyectoSelected.getId() == null) {
                departamentoProyectoFacade.create(departamentoProyectoSelected);
            } else {
                departamentoProyectoFacade.edit(departamentoProyectoSelected);
            }
            cancelarP5();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            RequestContext.getCurrentInstance().update("formPrincipal:panel5");
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para el departamento seleccionado";
                }
                controlMsgError = "formPrincipal:selDepartamentoParti";
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            } finally {
                departamentoProyectoList = departamentoProyectoFacade.findByProyecto(proyectoSelected.getId());
            }
        }
        return "";
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tab6-Estudiantes participantes">
    public void eliminarP6() {
        try {
            carreraProyectoFacade.remove(carreraProyectoSelected);
            cancelarP6();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void cancelarP6() {
        controlGrabar = false;
        datosCompletos = false;
        carreraProyectoList = carreraProyectoFacade.findByProyecto(proyectoSelected.getId());
    }
    
    public boolean validarVaciosP6() {
        datosCompletos = true;
        if (carreraProyectoSelected.getCarrera() == null || carreraProyectoSelected.getCarrera().getStvmajrCode() == null
                || carreraProyectoSelected.getNroEstudiantes() == null) {
            datosCompletos = false;
        }
        return datosCompletos;
    }

    /*public void seleccionarCarrera(ValueChangeEvent event) {
     String codSeleccionado = (String) event.getNewValue();
     if (codSeleccionado.equals("0")) {
     carreraProyectoSelected.setCarrera(new Stvmajr());
     } else {
     for (Stvmajr car : carreraList) {
     if (car.getStvmajrCode().equals(codSeleccionado)) {
     carreraProyectoSelected.setCarrera(car);
     break;
     }
     }
     }
     */
 /*public void seleccionarCarrera(SelectEvent event) {
     String[] temp = event.getObject().toString().split("-");
     String cod = temp[temp.length - 1];
     event.getObject().toString();
     carreraProyectoSelected.setCarrera(new Stvmajr(cod));
     //validarVaciosP1();
     }*/

 /*  public List<Stvmajr> buscarCarrera(String query) {
     carreraList = carreraFacade.findByNombre(query);
     return carreraList;
     }
     */
    public List<String> buscarCarrera(String query) {
        carreraList = carreraFacade.findByNombre(query);
        List<String> temp = new ArrayList<>();
        for (Stvmajr car : carreraList) {
            temp.add(car.getStvmajrDesc() + "-" + car.getStvmajrCode());
        }
        return temp;
    }
    private String nomCarreraSeleccionada;

    public String getNomCarreraSeleccionada() {
        return nomCarreraSeleccionada;
    }

    public void setNomCarreraSeleccionada(String nomCarreraSeleccionada) {
        this.nomCarreraSeleccionada = nomCarreraSeleccionada;
    }

    public String getTotalDocentesParticipantesStr() {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,##0";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        Integer total = 0;
        if (departamentoProyectoList != null) {

            for (DepartamentoProyecto departamentoProyecto : departamentoProyectoList) {
                try {
                    total += departamentoProyecto.getNroDocentes();
                } catch (Exception e) {
                }
            }
        }
        return decimalFormat.format(total);
    }

    public String getTotalEstudiantesParticipantesStr() {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,##0";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        Integer total = 0;
        if (carreraProyectoList != null) {
            for (CarreraProyecto carreraProyecto : carreraProyectoList) {
                try {
                    total += carreraProyecto.getNroEstudiantes();
                } catch (Exception e) {
                }
            }
        }
        return decimalFormat.format(total);
    }

    public String registraP6() {
        try {
            /*String[] temp = nomCarreraSeleccionada.split("-");
            String cod = temp[temp.length - 1];
            carreraProyectoSelected.setCarrera(carreraFacade.find(cod));*/

            if (carreraProyectoSelected.getId() == null) {
                carreraProyectoFacade.create(carreraProyectoSelected);
            } else {
                carreraProyectoFacade.edit(carreraProyectoSelected);
            }
            cancelarP6();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            RequestContext.getCurrentInstance().update("formPrincipal:panel6");
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para la Carrera seleccionada";
                    carreraProyectoList = carreraProyectoFacade.findByProyecto(proyectoSelected.getId());
                    RequestContext.getCurrentInstance().update("formPrincipal:dataTEstudiantesParticipantes");
                    controlMsgError = "formPrincipal:selCarrera";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void agregarP6(ActionEvent event) {
        carreraProyectoSelected = new CarreraProyecto(proyectoSelected);
        nomCarreraSeleccionada = "";
        controlGrabar = true;
        datosCompletos = false;

    }

    public String editarP6() {
        nomCarreraSeleccionada = carreraProyectoSelected.getCarrera().getStvmajrDesc() + "-" + carreraProyectoSelected.getCarrera().getStvmajrCode();
        controlGrabar = true;
        datosCompletos = false;
        return "";
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tab7-Presupuesto Detallado y Fuentes de Financiamiento">
    private PresupuestoProyecto presupuestoProyectoSelected;

    public PresupuestoProyecto getPresupuestoProyectoSelected() {
        return presupuestoProyectoSelected;
    }

    public void setPresupuestoProyectoSelected(PresupuestoProyecto presupuestoProyectoSelected) {
        this.presupuestoProyectoSelected = presupuestoProyectoSelected;
    }
    @EJB
    private PartidaPresupuestariaFacade partidaPresupuestariaFacade;

    public void agregarP7(ActionEvent event) {
        presupuestoProyectoSelected = new PresupuestoProyecto(proyectoSelected, PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD);
        controlGrabar = true;
    }

    public String seleccionarEdicionP7() {
        /*grupoPartidaSelected = presupuestoProyectoSelected.getPartidaPresupuestaria().getScpPadre().getScpPadre();
        subGrupo1PartidaSelected = presupuestoProyectoSelected.getPartidaPresupuestaria().getScpPadre();
         */
        controlGrabar = true;
        datosCompletos = false;
        return "";
    }

    private void initP7() {
        partidaPresupuestariaGastoCorrienteList = partidaPresupuestariaFacade.findByGastoCorriente();
        partidaPresupuestariaGastoInversionList = partidaPresupuestariaFacade.findByGastoInversion();
        //cancelarP7(true);
        cancelarPresupuestoProyecto();
    }

    public void cancelarP7(boolean setearBotones) {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (setearBotones) {
            datosCompletos = false;
            controlGrabar = false;
            presupuestoProyectoSelected = new PresupuestoProyecto(proyectoSelected);
        }
    }

    public String registraP7() {
        try {
            proyectoSelected.addPresupuesto(presupuestoProyectoSelected);
            proyectoFacade.edit(proyectoSelected);
            cancelarP7(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                cancelarP7(false);
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para la Partida Presupuestaria seleccionada";
                    controlMsgError = "formPrincipal:selPartida";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void eliminarP7() {
        try {
            proyectoSelected.removePresupuesto(presupuestoProyectoSelected);
            proyectoFacade.edit(proyectoSelected);
            cancelarP7(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public String seleccionarPartida() {
        /*if (presupuestoProyectoSelected.getPartidaPresupuestaria().getScpId().equals(new BigDecimal("710108"))) {
            presupuestoProyectoSelected.setTipoGasto("C");
        }*/
        return "";
    }

    //</editor-fold>    
//<editor-fold defaultstate="collapsed" desc="tab8: Estrategia de Ejecución-Cronograma">    
    private Date start;
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void onChangeActividad(TimelineModificationEvent e) {
        TimelineEvent event = e.getTimelineEvent();
        ((ObjetivoPrograma) event.getData()).setFechaInicio(event.getStartDate());
        ((ObjetivoPrograma) event.getData()).setFechaFin(event.getEndDate());
        modelActividades.update(event);

    }

    public void registraActividadProyecto() {
        TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":formPrincipal:timelineActividades");
        ((ObjetivoPrograma) event.getData()).setFechaInicio(event.getStartDate());
        ((ObjetivoPrograma) event.getData()).setFechaFin(event.getEndDate());
        modelActividades.update(event, timelineUpdater);
    }

    BigDecimal codComponenteSelected;

    public BigDecimal getCodComponenteSelected() {
        return codComponenteSelected;
    }

    public void setCodComponenteSelected(BigDecimal codComponenteSelected) {
        this.codComponenteSelected = codComponenteSelected;
    }

    public void cancelarP8(boolean resetearZoom) {
        controlGrabar = false;
        datosCompletos = false;
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());

        modelActividades = new TimelineModel();
        if (objetivoProyectoSelected != null) {
            for (ObjetivoPrograma obj1 : proyectoSelected.getObjetivoProyectoList()) {
                if (obj1.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                    for (ObjetivoPrograma obj2 : obj1.getSvinObjetivoHijoList()) {
                        // create groups  
                        if (obj2.getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                            for (ObjetivoPrograma act : obj2.getSvinObjetivoHijoList()) {
                                //TimelineEvent event = new TimelineEvent(act.getSvopObjetivoProy(), act.getFechaInicio(), act.getFechaFin(), true, act.getSvopObjetivoProy(), act.getSvopObjetivoProy().toLowerCase());
                                TimelineGroup group = new TimelineGroup(act.getSvopId().toString(), act);
                                modelActividades.addGroup(group);

                                TimelineEvent event = new TimelineEvent(act, act.getFechaInicio(), act.getFechaFin(), true, act.getSvopId().toString());
                                modelActividades.add(event);
                            }
                        }
                    }
                }
            }
        }

        modelHitos = new TimelineModel();
        TimelineGroup group = new TimelineGroup("Hitos", "Hitos");
        modelHitos.addGroup(group);
        if (objetivoProyectoSelected != null) {
            for (HitoProyecto hito : proyectoSelected.getHitoProyectoList()) {
                if (hito.getComponenteEspecifico().getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                    TimelineEvent event = new TimelineEvent(hito, hito.getFecha(), null, true, "Hitos");
                    modelHitos.add(event);
                }
            }

        }

        if (resetearZoom) {
            start = new Date();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(start);
            cal1.add(Calendar.DATE, -5);
            cal1.set(Calendar.HOUR_OF_DAY, 0);
            cal1.set(Calendar.MINUTE, 0);
            cal1.set(Calendar.SECOND, 0);
            start = cal1.getTime();

            end = new Date();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(end);
            cal2.add(Calendar.DATE, 5);
            cal2.set(Calendar.HOUR_OF_DAY, 0);
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.SECOND, 0);
            end = cal2.getTime();
        }
    }

    public String registraP8() {
        try {
            proyectoFacade.edit(proyectoSelected);
            cancelarP8(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    private TimelineModel modelActividades;
    private TimelineModel modelHitos;
    private TimelineEvent event; // current event to be changed, edited, deleted or added  

    public TimelineEvent getEvent() {
        return event;
    }

    public void setEvent(TimelineEvent event) {
        this.event = event;
    }

    public void onRangeChanged(TimelineRangeEvent e) {
        start = e.getStartDate();
        end = e.getEndDate();
    }

    public void delete() {
        TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":formPrincipal:timelineHitos");
        modelHitos.delete(event, timelineUpdater);
    }

    public TimelineModel getModelActividades() {
        return modelActividades;
    }

    public void setModelActividades(TimelineModel modelActividades) {
        this.modelActividades = modelActividades;
    }

    public TimelineModel getModelHitos() {
        return modelHitos;
    }

    public void setModelHitos(TimelineModel modelHitos) {
        this.modelHitos = modelHitos;
    }

    public String registraCronogramaActividades() {
        try {
            proyectoFacade.edit(proyectoSelected);
            cancelarCronogramaActividades();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void initCronogramaActividades() {
        objetivoProyectoSelected = null;
        cancelarCronogramaActividades();
    }

    public void cancelarCronogramaActividades() {
        controlGrabar = false;
        datosCompletos = false;
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());

        modelActividades = new TimelineModel();
        if (objetivoProyectoSelected != null) {
            for (ObjetivoPrograma obj1 : proyectoSelected.getObjetivoProyectoList()) {
                if (obj1.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                    for (ObjetivoPrograma obj2 : obj1.getSvinObjetivoHijoList()) {
                        // create groups  
                        if (obj2.getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                            for (ObjetivoPrograma act : obj2.getSvinObjetivoHijoList()) {
                                //TimelineEvent event = new TimelineEvent(act.getSvopObjetivoProy(), act.getFechaInicio(), act.getFechaFin(), true, act.getSvopObjetivoProy(), act.getSvopObjetivoProy().toLowerCase());
                                TimelineGroup group = new TimelineGroup(act.getSvopId().toString(), act);
                                modelActividades.addGroup(group);

                                TimelineEvent event = new TimelineEvent(act, act.getFechaInicio(), act.getFechaFin(), true, act.getSvopId().toString());
                                modelActividades.add(event);
                            }
                        }
                    }
                }
            }
        }
        start = getFechaInicioActividades();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(start);
        cal1.add(Calendar.DATE, -5);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        start = cal1.getTime();

        end = getFechaInicioActividades();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(end);
        cal2.add(Calendar.MONTH, 3);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        end = cal2.getTime();
    }

    public void onEditActividad(TimelineModificationEvent e) {
        // get clone of the TimelineEvent to be edited  
        event = e.getTimelineEvent();
    }

    private Date getFechaInicioActividades() {
        Date fechaInicio = null;
        if (proyectoSelected.getObjetivoProyectoList() != null && objetivoProyectoSelected != null) {
            for (ObjetivoPrograma obj1 : proyectoSelected.getObjetivoProyectoList()) {
                if (obj1.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                    for (ObjetivoPrograma comp : obj1.getSvinObjetivoHijoList()) {
                        if (comp.getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                            for (ObjetivoPrograma act : comp.getSvinObjetivoHijoList()) {
                                if (fechaInicio == null || act.getFechaInicio().before(fechaInicio)) {
                                    fechaInicio = act.getFechaInicio();
                                }
                            }
                        }
                    }
                }
            }
        }
        if (fechaInicio == null) {
            fechaInicio = new Date();
        }
        return fechaInicio;
    }

    public String registraCronogramaHitos() {
        try {
            for (Iterator<TimelineEvent> iterator = modelHitos.getEvents().iterator(); iterator.hasNext();) {
                TimelineEvent t = iterator.next();
                HitoProyecto h = (HitoProyecto) t.getData();
                boolean encontro = false;
                for (HitoProyecto h2 : proyectoSelected.getHitoProyectoList()) {
                    if ((h.equals(h2) && h.getId() > 0) || (h.getId() < 0)) {
                        if (h.equals(h2) && h.getId() > 0) {
                            h.setDescripcion(h2.getDescripcion());
                            h.setFecha(h2.getFecha());
                            h.setLogro(h2.getLogro());
                        }
                        if (h.getId() < 0) {
                            h.setId(null);
                        }
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    iterator.remove();
                }
            }
            proyectoFacade.edit(proyectoSelected);

            cancelarCronogramaHitos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void onAdd(TimelineAddEvent e) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(e.getStartDate());
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);

        HitoProyecto hitoProyecto = new HitoProyecto(proyectoSelected);
        hitoProyecto.setComponenteEspecifico(objetivoProyectoSelected);
        hitoProyecto.setFecha(cal1.getTime());

        Integer idNuevo = 0;
        for (HitoProyecto hito : proyectoSelected.getHitoProyectoList()) {
            if (idNuevo > hito.getId()) {
                idNuevo = hito.getId();
            }
        }
        idNuevo--;
        hitoProyecto.setId(idNuevo);

        proyectoSelected.addHitoProyecto(hitoProyecto);
        TimelineEvent eventNuevo = new TimelineEvent(hitoProyecto, hitoProyecto.getFecha(), null, true, "Hitos");
        modelHitos.add(eventNuevo);
        event = eventNuevo;
    }

    public void onEdit(TimelineModificationEvent e) {
        // get clone of the TimelineEvent to be edited  
        event = e.getTimelineEvent();
        HitoProyecto temp = (HitoProyecto) e.getTimelineEvent().getData();
        hitoProyectoSelected = new HitoProyecto();
        hitoProyectoSelected.setFecha(temp.getFecha());
        hitoProyectoSelected.setDescripcion(temp.getDescripcion());
        hitoProyectoSelected.setLogro(temp.getLogro());
    }

    public void registraHitoProyecto() {
        /*for (ObjetivoPrograma comp : proyectoSelected.getComponentes()) {
         if (comp.getSvopId().equals(codComponenteSelected))
         {
         ((HitoProyecto) event.getData()).setComponenteEspecifico(comp);
         break;
         }
            
         }*/
        TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":formPrincipal:timelineHitos");
        ((HitoProyecto) event.getData()).setFecha(event.getStartDate());
        ((HitoProyecto) event.getData()).setComponenteEspecifico(objetivoProyectoSelected);
        modelHitos.update(event, timelineUpdater);
    }

    public void cancelarRegistroHitoProyecto() {
        HitoProyecto hitoProyecto = (HitoProyecto) event.getData();
        if (hitoProyecto.getId() == null) {
            proyectoSelected.removeHitoProyecto(hitoProyecto);
            modelHitos.delete(event);
        } else {
            hitoProyecto.setFecha(hitoProyectoSelected.getFecha());
            hitoProyecto.setDescripcion(hitoProyectoSelected.getDescripcion());
            hitoProyecto.setLogro(hitoProyectoSelected.getLogro());
        }
    }

    public void onDelete(TimelineModificationEvent e) {
        event = e.getTimelineEvent();
        proyectoSelected.removeHitoProyecto((HitoProyecto) event.getData());
        TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":formPrincipal:timelineHitos");
        modelHitos.delete(event);
        //modelHitos.delete(e.getTimelineEvent(), timelineUpdater);

    }

    public void onChange2(TimelineModificationEvent e) {
        TimelineEvent event = e.getTimelineEvent();
        ((HitoProyecto) event.getData()).setFecha(event.getStartDate());
        modelHitos.update(event);
    }

    public void initCronogramaHitos() {
        objetivoProyectoSelected = null;
        cancelarCronogramaHitos();
    }

    public void cancelarCronogramaHitos() {
        controlGrabar = false;
        datosCompletos = false;
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());

        modelHitos = new TimelineModel();
        if (objetivoProyectoSelected != null) {
            for (HitoProyecto hito : proyectoSelected.getHitoProyectoList()) {
                if (hito.getComponenteEspecifico().getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                    TimelineEvent event = new TimelineEvent(hito, hito.getFecha(), null, true, "Hitos");
                    modelHitos.add(event);
                }
            }
        }
        start = getFechaInicioHitos();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(start);
        cal1.add(Calendar.DATE, -5);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        start = cal1.getTime();

        end = getFechaInicioHitos();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(end);
        cal2.add(Calendar.MONTH, 3);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        end = cal2.getTime();
    }

    private Date getFechaInicioHitos() {
        Date fechaInicio = null;
        if (proyectoSelected.getHitoProyectoList() != null && objetivoProyectoSelected != null) {
            for (HitoProyecto hito : proyectoSelected.getHitoProyectoList()) {
                if (hito.getComponenteEspecifico().getSvopId().equals(objetivoProyectoSelected.getSvopId())) {
                    if (fechaInicio == null || hito.getFecha().before(fechaInicio)) {
                        fechaInicio = hito.getFecha();
                    }
                }
            }
        }
        if (fechaInicio == null) {
            fechaInicio = new Date();
        }
        return fechaInicio;
    }

//</editor-fold>         
//<editor-fold defaultstate="collapsed" desc="Tab13-Viabilidad y Plan de Sostenibilidad">
    public String validarVaciosP13() {
        datosCompletos = true;
        if (proyectoSelected.getViabilidadTecnica() == null || proyectoSelected.getViabilidadTecnica().trim().isEmpty()
                || proyectoSelected.getPerderiaPais() == null || proyectoSelected.getPerderiaPais().trim().isEmpty()
                || proyectoSelected.getResultadosEsperados() == null || proyectoSelected.getResultadosEsperados().trim().isEmpty()
                || proyectoSelected.getImpactoAmbiental() == null || proyectoSelected.getImpactoAmbiental().trim().isEmpty()
                || proyectoSelected.getSostenibilidadSocial() == null || proyectoSelected.getSostenibilidadSocial().trim().isEmpty()) {
            datosCompletos = false;
        }
        return "";
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tab15-Matriz del Marco Lógico">
    public void eliminarP15() {
        try {
            objetivoProyectoSelected.getSvinObjetivoPadre().removeObjetivo(objetivoProyectoSelected);
            objetivoProgramaFacade.edit(objetivoProyectoSelected.getSvinObjetivoPadre());
            //objetivoProgramaFacade.remove(objetivoProyectoSelected);
            estadoExpandidoObjetivo.remove(objetivoProyectoSelected.getSvopId());
            cancelarP15(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public String agregarP15() {
        objetivoProyectoSelected = new ObjetivoPrograma(proyectoSelected);
        objetivoProyectoSelected.setSvopTipo(objetivoProyectoPadreSelected.getSvopTipo() + 1);
        objetivoProyectoSelected.setSvinObjetivoPadre(objetivoProyectoPadreSelected);
        objetivoProyectoSelected.setSvopOrden(objetivoProyectoPadreSelected.getSvinObjetivoHijoList().size() + 1);
        proyectoSelected.addObjetivoProyecto(objetivoProyectoSelected);
        if (objetivoProyectoSelected.getSvopTipo().equals(ObjetivoPrograma.TIPO_COMPONENTE)) {
            HitoProyecto hito = new HitoProyecto(proyectoSelected);
            hito.setComponenteEspecifico(objetivoProyectoSelected);
            hito.setFecha(proyectoSelected.getFechaInicio());
            hito.setDescripcion(objetivoProyectoSelected.getSvopObjetivoProy());
            proyectoSelected.addHitoProyecto(hito);
        }
        controlGrabar = true;
        return "";
    }

    public String registraP15() {
        try {
            //if (objetivoProyectoSelected.getSvopId() == null) {
            //objetivoProgramaFacade.create(objetivoProyectoSelected);
            //proyectoFacade.edit(proyectoSelected);
            //objetivoProyectoSelected.setearEstadoExpanded();
            //estadoExpandidoObjetivo.put(objetivoProyectoSelected.getSvopId(), objetivoProyectoSelected.isExpanded());
            //}
            boolean error = false;
            if (objetivoProyectoSelected.getSvopObjetivoProy().trim().length() < 10) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtObjetivo15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
                error = true;
            }
            if (objetivoProyectoSelected.getSvopIndicador().trim().length() < 10) {
                error = true;
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtIndicador15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
            }
            if (objetivoProyectoSelected.getSvopMverifica().trim().length() < 10) {
                error = true;
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtMedioVerificacion15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
            }
            if (objetivoProyectoSelected.getSvopSupuestos().trim().length() < 10) {
                error = true;
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtSupuestos15", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar como mínimo 10 caracteres"));
            }
            if (!error) {
                proyectoFacade.edit(proyectoSelected);
                cancelarP15(true);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public void cancelarP15(boolean setearEstadoExpansion) {
        controlGrabar = false;
        datosCompletos = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (setearEstadoExpansion) {
            estadoExpandidoObjetivo = null;
            proyectoSelected.resetEstadoExpandidoObjetivo();
            estadoExpandidoObjetivo = proyectoSelected.getEstadoExpandidoObjetivo();
        } else {
            proyectoSelected.setEstadoExpandidoObjetivo(estadoExpandidoObjetivo);
        }
    }

    public void onRowToggleObjetivoProyecto(ToggleEvent event) {
        ObjetivoPrograma obj = (ObjetivoPrograma) event.getData();
        estadoExpandidoObjetivo.put(obj.getSvopId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public ObjetivoPrograma getObjetivoProyectoPadreSelected() {
        return objetivoProyectoPadreSelected;
    }

    public void setObjetivoProyectoPadreSelected(ObjetivoPrograma objetivoProyectoPadreSelected) {
        this.objetivoProyectoPadreSelected = objetivoProyectoPadreSelected;
    }

    private Map<BigDecimal, Boolean> estadoExpandidoObjetivo = new HashMap<BigDecimal, Boolean>();
    private Map<BigDecimal, Boolean> estadoExpandidoObjetivoBVivir = new HashMap<BigDecimal, Boolean>();

    public String cambiarOrdenActividad(Integer cambio) {
        try {
            objetivoProyectoSelected.cambiarOrdenObjetivo(cambio);
            objetivoProgramaFacade.edit(objetivoProyectoSelected.getSvinObjetivoPadre());
            cancelarP15(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }

        return "";
    }

    //</editor-fold>    
//<editor-fold defaultstate="collapsed" desc="Tab16: Alineamiento del Proyecto-Objetivos PLNBV">
    public void agregarP16(ActionEvent event) {
        objBVivirPadre = null;
        objetivoBVivirSelected = new ObjetivoBVivirPrograma(proyectoSelected);
        controlGrabar = true;
    }

    public void cancelarP16(boolean setearBotones, boolean setearExpanded) {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.setearObjetivoBVivirProyectoPadreList();
        if (setearBotones) {
            objBVivirPadre = null;
            datosCompletos = false;
            controlGrabar = false;
        }
        if (setearExpanded) {
            proyectoSelected.setEstadoExpandidoObjetivoBVivir(new HashMap<BigDecimal, Boolean>());
            estadoExpandidoObjetivoBVivir = proyectoSelected.getEstadoExpandidoObjetivoBVivir();
        } else {
            proyectoSelected.setEstadoExpandidoObjetivoBVivir(estadoExpandidoObjetivoBVivir);
        }
    }

    public String registraP16() {
        try {
            proyectoSelected.addObjetivoBVivir(objetivoBVivirSelected);
            proyectoFacade.edit(proyectoSelected);
            estadoExpandidoObjetivoBVivir = proyectoSelected.getEstadoExpandidoObjetivoBVivir();
            cancelarP16(true, false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                cancelarP16(false, false);
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage() != null && t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para el Objetivo seleccionado";
                    controlMsgError = "formPrincipal:subojPlan1";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void onRowToggleObjetivoBVivir(ToggleEvent event) {
        ObjetivoBVivirPrograma subObj = (ObjetivoBVivirPrograma) event.getData();
        //proyectoSelected.addEstadoExpandidoObjetivoBVivir(subObj.getObjetivoBVivir().getSvobviId(), event.getVisibility() == Visibility.VISIBLE);
        estadoExpandidoObjetivoBVivir.put(subObj.getObjetivoBVivir().getSvobviId(), event.getVisibility() == Visibility.VISIBLE);
        /*if (event.getVisibility() == Visibility.VISIBLE) {
         subObj.setExpanded(true);
         } else {
         subObj.setExpanded(false);
         }*/
    }

    public void eliminarP16() {
        try {
            proyectoSelected.removeObjetivoBVivir(objetivoBVivirSelected);
            proyectoFacade.edit(proyectoSelected);
            estadoExpandidoObjetivoBVivir = proyectoSelected.getEstadoExpandidoObjetivoBVivir();
            cancelarP16(true, false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            cancelarP16(true, false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void bsqSubObjetivos() {
        if (objBVivirPadre != null) {
            objBVivirHijoList = svinObjBVivirFacade.findObjXPadre(objBVivirPadre.getSvobviId());
        } else {
            objBVivirHijoList = new ArrayList<>();
        }
        //objetivoBVivirSelected.setObjetivoBVivir(null);
    }

    //</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="tab19: Objetivos de desarrollo sostenible del milenio">
    private void initObjetivoMilenio(){
        if (milenioList == null) {
            milenioList = objetivoEstrategicoFacade.findObjetivosMilenio();
        }
        perspectivaSelected = null;
        objetivoEstrategicoSelected = null;
        cancelarIndicadorEstrategia();
    }

 
    
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="tab121: Campo de conocimiento UNESCO">
    private void initCampoUnesco(){
        if (unescoList == null) {
            unescoList = objetivoEstrategicoFacade.findCampoUnesco();
        }
        perspectivaSelected = null;
        objetivoEstrategicoSelected = null;
        cancelarIndicadorEstrategia();
    }  
    
    
//</editor-fold>    
    
//<editor-fold defaultstate="collapsed" desc="tab20: Impactos Esperados">
    
    private void initImpactoEsperado(){
        if(impactoEsperadoTipoList == null){
           impactoEsperadoTipoList = impactoEsperadoTipoFacade.findAll();          
        }
        controlGrabar = false;
        cancelarImpactoEsperado();
    }
    
//    public void cancelarImpactoEsperado() {
//        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
//        impactoEsperadoSelected = null;
//    }
    
    public void cancelarImpactoEsperado() {
        controlGrabar = false;
        datosCompletos = false;
        impactoEsperadoList = impactoEsperadoFacade.findByProyecto(proyectoSelected.getId());
    }
    
    public void nuevoImpactoEsperado(ActionEvent event){
        impactoEsperadoSelected = new ImpactoEsperado(proyectoSelected);
        nomCarreraSeleccionada = "";
        controlGrabar = true;
        datosCompletos = false;
    }
    
    public String registraImpactoEsperado() {
        try {
           
            if (impactoEsperadoSelected.getId() == null) {
                impactoEsperadoFacade.create(impactoEsperadoSelected);
            } else {
                impactoEsperadoFacade.edit(impactoEsperadoSelected);
            }
            cancelarImpactoEsperado();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            RequestContext.getCurrentInstance().update("formPrincipal:panelImpactoEsperado");
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para el Impacto seleccionada";
                    impactoEsperadoList = impactoEsperadoFacade.findByProyecto(proyectoSelected.getId());
                    RequestContext.getCurrentInstance().update("formPrincipal:dataTImpactoEsperado");
                    controlMsgError = "formPrincipal:selCarrera";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }
    
    public String editarImpactoEsperado() {
        controlGrabar = true;
        datosCompletos = true;
        return "";
    }
    
    public void eliminarImpacto() {
        try {
            impactoEsperadoFacade.remove(impactoEsperadoSelected);
            cancelarImpactoEsperado();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }
  
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="tab17: Alineamiento del Proyecto-Objetivos Estratégicos Institucionales">
    private Integer tipoObjetivoEstrategico;
    @EJB
    private IndicadorEstrategiaProyectoFacade indicadorEstrategiaProyectoFacade;

    private void initIndicadorEstrategia() {
        if (perspectivasList == null) {
            perspectivasList = objetivoEstrategicoFacade.findPrespectivas();
        }
        perspectivaSelected = null;
        objetivoEstrategicoSelected = null;
        cancelarIndicadorEstrategia();
    }

    public Integer getTipoObjetivoEstrategico() {
        return tipoObjetivoEstrategico;
    }

    public void setTipoObjetivoEstrategico(Integer tipoObjetivoEstrategico) {
        this.tipoObjetivoEstrategico = tipoObjetivoEstrategico;
    }

    public void nuevoIndicador(ActionEvent event) {
        indicadorEstrategiaProyectoSelected = new IndicadorEstrategiaProyecto(proyectoSelected);
        tipoObjetivoEstrategico = ObjetivoEstrategico.TIPO_INDICADOR;
    }

    public void nuevoEstrategia(ActionEvent event) {
        indicadorEstrategiaProyectoSelected = new IndicadorEstrategiaProyecto(proyectoSelected);
        tipoObjetivoEstrategico = ObjetivoEstrategico.TIPO_ESTRATEGIA;
    }

    public String grabarIndicadorEstrategia() {
        try {
            indicadorEstrategiaProyectoFacade.create(indicadorEstrategiaProyectoSelected);
            cancelarIndicadorEstrategia();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para el Objetivo seleccionado";
                    controlMsgError = "formPrincipal:selIndicadorEstrategia";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void cancelarIndicadorEstrategia() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        indicadorEstrategiaProyectoSelected = null;
    }

    public void eliminarIndicadorEstrategia() {
        try {
            IndicadorEstrategiaProyecto ind = proyectoSelected.getIndicadorEstrategia(objetivoEstrategicoSelected.getId());
            indicadorEstrategiaProyectoFacade.remove(ind);
            cancelarIndicadorEstrategia();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }
//</editor-fold>     
//<editor-fold defaultstate="collapsed" desc="tab18: Alineamiento del Proyecto-Objetivos Provinciales, Cantonales o Paroquiales">    

    public String editarP18() {
        controlGrabar = true;
        return "";
    }

    public String registraP18() {
        try {
            proyectoFacade.edit(proyectoSelected);
            cancelarP18();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        }
        return "";
    }

    public String cancelarP18() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        controlGrabar = false;
        return "";
    }

    //</editor-fold>     
//<editor-fold defaultstate="collapsed" desc="Metodos generales">
    /*public String agregarProyecto() {
        proyectoSelected = new Proyecto();
        proyectoSelected.setConvocatoria(convocatoriaFacade.findByActiva());
        if (proyectoSelected.getConvocatoria() == null) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:btnAgregarProyecto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No existe una convocatoria abierta a la fecha actual. Por favor, previamente debe crear una convocatoria."));
            return "";
        } else {
            docenteSelected = new VDocenteVinculacion2();
            nomDocenteBusqueda = "";
            tipoPoblacionSelectedList = new ArrayList<>();
            controlGrabar = true;
            crearArbolMenu(Proyecto.ESTADO_CREADO);
            return "proyecto";
        }
    }*/
    private void seleccionarProyecto() {
        indiceTabActivo = 0;
        indiceTabActivoEjecucion = 0;
        if (proyectoSelected.getDirector() != null) {
            llenarDatosDocenteXUsuId(proyectoSelected.getDirector().getUsuario().getUsuId());
        }
        tipoPoblacionSelectedList = new ArrayList<>();
        for (TipoPoblacionProyecto tipoPoblacionProyecto : proyectoSelected.getTipoPoblacionList()) {
            tipoPoblacionSelectedList.add(tipoPoblacionProyecto.getTipoPoblacion());
        }
        for (Stvcamp cam : campusList) {
            if (cam.equals(proyectoSelected.getCampus())) {
                proyectoSelected.setCampus(cam);
                break;
            }
        }
        observacionesEvaluacionFinal = null;
        fechaEvaluacionFinal = null;
        if (proyectoSelected.getEvaluacionFinal() != null) {
            fechaEvaluacionFinal = proyectoSelected.getEvaluacionFinal().getFecha();
            observacionesEvaluacionFinal = proyectoSelected.getEvaluacionFinal().getObservaciones();
        }
        if (proyectoSelected.isEstadoEnviadoRevision() && verificarDirectorProyecto()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            mensajeFechaMaximaCorreccion = "Fecha máxima para corrección de observaciones enviadas por comisión de vinculación: " + sdf.format(proyectoSelected.getFechaMaximaCorreccion());
        }

    }

    private String tipoProyecto;
    private String codDepartamento;

    public String seleccionarEdicion() {
        modoEdicion = true;
        controlGrabar = true;
        datosCompletos = false;
        tipoProyecto = proyectoSelected.getTipo();
        codDepartamento = proyectoSelected.getDepartamento().getStvsubjCode();
        return "";
    }

    public void seleccionarEdicionDatosGenerales() {
        permitirEditarTipoProyecto = false;
        modoEdicion = true;
        if (!this.proyectoSelected.isEstadoEnviadoRevision()
                || this.proyectoSelected.getTipo().equals(Proyecto.TIPO_GASTO_NO_PERMANENTE)) {
            permitirEditarTipoProyecto = true;
        }
        controlGrabar = true;
        datosCompletos = false;
        tipoProyecto = proyectoSelected.getTipo();
        codDepartamento = proyectoSelected.getDepartamento().getStvsubjCode();
    }

//</editor-fold>
    public void subirDocAprobacionConcejoDep(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "aprobacion_concejo_departamento";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            proyectoSelected.setNombreDocAprobacionConcejoDep(event.getFile().getFileName());
            proyectoSelected.setUrlDocAprobacionConcejoDep("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }

    }

    public int getIndiceTabActivoEjecucion() {
        return indiceTabActivoEjecucion;
    }

    public void setIndiceTabActivoEjecucion(int indiceTabActivoEjecucion) {
        this.indiceTabActivoEjecucion = indiceTabActivoEjecucion;
    }

    public void cambiarTabEjecucion(TabChangeEvent e) {
        try {
            datosCompletos = false;
            if (e.getTab() != null) {
                String[] aux = e.getTab().getClientId().split(":");
                if (aux[aux.length - 1].equals("tabP2_1")) {//tab1: 
                    cancelarPerfil();
                }
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }

    }

    public void eliminarDocenteParticipante() {
        try {
            responsableProyectoFacade.remove(responsableProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            cancelarDocenteProyecto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void eliminarActaDesignacionDocente(ActaDesignacionResponsable acta) {
        try {
            for (ResponsableProyecto r : acta.getResponsableList()) {
                r.setActaDesignacionResponsable(null);
                responsableProyectoFacade.edit(r);
            }
            actaDesignacionResponsableFacade.remove(acta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            cancelarDocenteProyecto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void abrirBusquedaDocenteEvaluador(ActionEvent event) {
        abrirBusquedaDocente(TipoResponsable.TIPO_EVALUADOR_FINAL);
    }

    public void abrirBusquedaDocenteParticipante(ActionEvent event) {
        abrirBusquedaDocente(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE);
    }

    private void abrirBusquedaDocente(Integer tipoResponsable) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("contentHeight", 380);
        options.put("contentWidth", 800);
        //options.put("closeOnEscape", true); 
        options.put("includeViewParams", true);

        Map<String, List<String>> params = new HashMap<String, List<String>>();
        if (tipoResponsable.equals(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE)) {
            List<String> values = new ArrayList<String>();
            values.add(proyectoSelected.getId().toString());
            params.put("idProyecto", values);
            List<String> values2 = new ArrayList<String>();
            values2.add(tipoResponsable.toString());
            params.put("tipoResponsable", values2);
        }

        RequestContext.getCurrentInstance().openDialog("busquedaDocente", options, params);
    }

    public void nuevoDocenteParticipante() {
        responsableProyectoSelected = new ResponsableProyecto(new TipoResponsable(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE));
    }

    private ResponsableProyecto responsableProyectoSelected;

    public ResponsableProyecto getResponsableProyectoSelected() {
        return responsableProyectoSelected;
    }

    public void setResponsableProyectoSelected(ResponsableProyecto responsableProyectoSelected) {
        this.responsableProyectoSelected = responsableProyectoSelected;
    }

    public void seleccionarDocente(SelectEvent event) {
        VDocenteVinculacion2 docente = (VDocenteVinculacion2) event.getObject();
        responsableProyectoSelected.setDepartamento(docente.getDepartamento());
        responsableProyectoSelected.setCampus(docente.getCampus());
        responsableProyectoSelected.setUsuario(docente.getUsuario());
    }

    @EJB
    private ResponsableProyectoFacade responsableProyectoFacade;

    public String grabarDocenteParticipante() {
        try {
            if (responsableProyectoSelected.getId() == null) {
                responsableProyectoSelected.setProyecto(proyectoSelected);
                responsableProyectoFacade.create(responsableProyectoSelected);
            } else {
                responsableProyectoFacade.edit(responsableProyectoSelected);
            }
            cancelarDocenteProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }
    private List<TipoResponsable> tipoResponsableList;

    public List<TipoResponsable> getTipoResponsableList() {
        return tipoResponsableList;
    }

    public void setTipoResponsableList(List<TipoResponsable> tipoResponsableList) {
        this.tipoResponsableList = tipoResponsableList;
    }

    @EJB
    private ActaDesignacionResponsableFacade actaDesignacionResponsableFacade;
    private ActaDesignacionResponsable actaDesignacionResponsableSelected;

    public ActaDesignacionResponsable getActaDesignacionResponsableSelected() {
        return actaDesignacionResponsableSelected;
    }

    public void setActaDesignacionResponsableSelected(ActaDesignacionResponsable actaDesignacionResponsableSelected) {
        this.actaDesignacionResponsableSelected = actaDesignacionResponsableSelected;
    }

    public boolean isPermitirGenerarActaDesignacionDocente() {
        for (ResponsableProyecto r : proyectoSelected.getParticipanteDocenteTodosList()) {
            if (r.getActaDesignacionResponsable() == null) {
                return true;
            }
        }
        return false;
    }

    public void generarActaDesignacionDocente() {
        try {
            for (ResponsableProyecto r : proyectoSelected.getParticipanteDocenteTodosList()) {
                if (r.getActaDesignacionResponsable()==null){
                    if (r.getHorasPlanificadas()==null){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar el número de horas planificadas para todos los docentes."));
                        return;
                    }
                }
            }
            
            ActaDesignacionResponsable a = actaDesignacionResponsableFacade.findByMaximoSecuencial(proyectoSelected.getId(), TipoResponsable.TIPO_PARTICIPANTE_DOCENTE);
            Integer secuencial = 1;
            if (a != null) {
                secuencial = a.getSecuencial() + 1;
            }
            a = new ActaDesignacionResponsable();
            a.setUsuario(usuarioActual);
            a.setSecuencial(secuencial);
            actaDesignacionResponsableFacade.create(a);
            
            for (ResponsableProyecto r : proyectoSelected.getParticipanteDocenteTodosList()) {
                if (r.getActaDesignacionResponsable()==null){
                    r.setActaDesignacionResponsable(a);
                    responsableProyectoFacade.edit(r);
                }
            }
            
            cancelarDocenteProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
            } catch (Exception e2) {
            }
        }
    }

    private void initDocenteProyecto() {
        if (tipoResponsableList == null) {
            tipoResponsableList = new ArrayList<>();
            tipoResponsableList.add(new TipoResponsable(TipoResponsable.TIPO_DIRECTOR, "DIRECTOR"));
            tipoResponsableList.add(new TipoResponsable(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE, "COLABORADOR"));
        }
        cancelarDocenteProyecto();
    }

    public void cancelarActaDesignacionDocente() {
        actaDesignacionResponsableSelected = null;
        actaDesignacionResponsableList = actaDesignacionResponsableFacade.findByTipo(proyectoSelected.getId(), TipoResponsable.TIPO_PARTICIPANTE_DOCENTE);
        List<ActaDesignacionResponsable> temp= actaDesignacionResponsableFacade.findByTipo(proyectoSelected.getId(), TipoResponsable.TIPO_DIRECTOR);
        for (ActaDesignacionResponsable a : temp) {
            boolean encontro=false;
            for (ActaDesignacionResponsable a2 : actaDesignacionResponsableList) {
                if (a.getId().equals(a2.getId())){
                    encontro=true;
                    break;
                }
            }
            if (!encontro){
                actaDesignacionResponsableList.add(a);
            }
        }
    }

    public void subirDocDesignacionDocenteFirmas(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "acta_designacion_docentes";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + actaDesignacionResponsableSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            actaDesignacionResponsableSelected.setDocumentoFirmadoNombre(event.getFile().getFileName());
            actaDesignacionResponsableSelected.setDocumentoFirmadoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + actaDesignacionResponsableSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }

    }

    public void imprimirActaDesignacionDocente(ActaDesignacionResponsable acta) {
        imprimirActaDesignacionDocente(JasperReportUtil.TIPO_PDF, acta);
    }
    private StreamedContent archivoActaDesignacionDocente;

    public StreamedContent getArchivoActaDesignacionDocente() {
        return archivoActaDesignacionDocente;
    }

    public void setArchivoActaDesignacionDocente(StreamedContent archivoActaDesignacionDocente) {
        this.archivoActaDesignacionDocente = archivoActaDesignacionDocente;
    }

    public void prepararActaDesignacionDocenteDownload(ActaDesignacionResponsable acta) {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + acta.getDocumentoFirmadoUrlFinal();
            this.archivoActaDesignacionDocente = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", acta.getDocumentoFirmadoNombre());
        } catch (Exception e) {

        }
    }

    private void imprimirActaDesignacionDocente(String tipoReporte, ActaDesignacionResponsable acta) {
        try {
            acta.llenarDatosDirectores(directorDepartamentoList);
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            parametros.put("proyecto", proyectoSelected.getNombre());

            String departamentos= "";
            for (VDirectorDepartamento c : acta.getDirectorDepartamentoList()) {
                if (!departamentos.isEmpty()){
                    if (c.equals(acta.getDirectorDepartamentoList().get(acta.getDirectorDepartamentoList().size()-1))){
                        departamentos+=" y ";
                    }
                    else{
                        departamentos+=", ";
                    }
                }
                departamentos+=c.getDepartamento().getStvsubjDesc();
            }
            parametros.put("departamentos", departamentos);            
            SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy", new Locale("ES"));
            String fechaActual = "Sangolquí, " + formatter.format(new Date());
            parametros.put("fechaActual", fechaActual);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            List<ActaDesignacionResponsable> listaActas = new ArrayList<>();
            listaActas.add(acta);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_ACTA_DESIGNACION_DOCENTES, tipoReporte, parametros, listaActas);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void grabarActaDesignacionDocente() {
        try {
            actaDesignacionResponsableFacade.edit(actaDesignacionResponsableSelected);
            cancelarDocenteProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
            } catch (Exception e2) {
            }
        }
    }

    public void cancelarDocenteProyecto() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        responsableProyectoSelected = null;
        cancelarActaDesignacionDocente();
    }

    public void eliminarDocentesParticipantes() {
        try {
            boolean encontro = false;
            for (Iterator<ResponsableProyecto> iterator = proyectoSelected.getResponsableList().iterator(); iterator.hasNext();) {
                ResponsableProyecto resp = iterator.next();
                if (resp.isSelected()) {
                    iterator.remove();
                    encontro = true;
                }
            }
            if (encontro) {
                proyectoFacade.edit(proyectoSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Los docentes seleccionados fueron eliminados exitosamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar el/los items a eliminar."));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar los registros seleccionados"));
        }
    }

    public String seleccionarTodosEliminar() {
        for (ResponsableProyecto resp : proyectoSelected.getParticipanteDocenteList()) {
            resp.setSelected(seleccionadoTodos);
        }
        return "";
    }

    public String seleccionarEliminar() {
        boolean seleccionadoTodos = true;
        for (ResponsableProyecto resp : proyectoSelected.getParticipanteDocenteList()) {
            if (!resp.isSelected()) {
                seleccionadoTodos = false;
                break;
            }
        }
        this.seleccionadoTodos = seleccionadoTodos;
        return "";
    }
    private boolean seleccionadoTodos;

    public boolean isSeleccionadoTodos() {
        return seleccionadoTodos;
    }

    public void setSeleccionadoTodos(boolean seleccionadoTodos) {
        this.seleccionadoTodos = seleccionadoTodos;
    }

    public boolean getSeleccionadoAlguno() {
        for (ResponsableProyecto resp : proyectoSelected.getParticipanteDocenteList()) {
            if (resp.isSelected()) {
                return true;
            }
        }
        return false;
    }

    private TreeNode rootMenu;

    public TreeNode getRootMenu() {
        return rootMenu;
    }

    public void setRootMenu(TreeNode rootMenu) {
        this.rootMenu = rootMenu;
    }

    public void crearArbolMenu(Long estadoProyecto) {
        rootMenu = new DefaultTreeNode("Root", null);
        TreeNode nodePerfil = new DefaultTreeNode(new OpcionMenu("1", "Perfil"), rootMenu);
        TreeNode node11 = new DefaultTreeNode(new OpcionMenu("1.1", "1. Datos Generales"), nodePerfil);
        TreeNode node111 = new DefaultTreeNode(new OpcionMenu("1.1.1", "1.1. Datos Generales"), node11);
        if (estadoProyecto.equals(SeaParametrosDet.ESTADO_CREADO) || estadoProyecto.equals(SeaParametrosDet.ESTADO_REVISION)) {
            nodePerfil.setExpanded(true);
            node11.setExpanded(true);
            node111.setExpanded(true);
            node111.setSelected(true);
        }

        if (proyectoSelected.getId() != null) {
            TreeNode node112 = new DefaultTreeNode(new OpcionMenu("1.1.2", "1.2. Cobertura y Localización"), node11);
            //TreeNode node113 = new DefaultTreeNode(new OpcionMenu("1.1.3", "1.3. Origen de los fondos"), node11);
            TreeNode node114 = new DefaultTreeNode(new OpcionMenu("1.1.4", "1.3. Detalle de entregables del proyecto"), node11);
            TreeNode node115 = new DefaultTreeNode(new OpcionMenu("1.1.5", "1.4. Impactos esperados"), node11);
            TreeNode node12 = new DefaultTreeNode(new OpcionMenu("1.2", "2. Diagnóstico y Problema"), nodePerfil);
            TreeNode node121 = new DefaultTreeNode(new OpcionMenu("1.2.1", "2.1. Diagnóstico y Problema"), node12);
            TreeNode node1211 = new DefaultTreeNode(new OpcionMenu("1.2.5", "2.2. Anexos imágenes"), node12);
            TreeNode node122 = new DefaultTreeNode(new OpcionMenu("1.2.2", "2.3. Identificación de Población"), node12);
            TreeNode node123 = new DefaultTreeNode(new OpcionMenu("1.2.3", "2.4. Docentes Participantes"), node12);
            TreeNode node124 = new DefaultTreeNode(new OpcionMenu("1.2.4", "2.5. Estudiantes Participantes"), node12);
            TreeNode node13 = new DefaultTreeNode(new OpcionMenu("1.3", "3. Alineamiento del Proyecto"), nodePerfil);
            TreeNode node136 = new DefaultTreeNode(new OpcionMenu("1.3.5", "3.1. Objetivos de desarrollo sostenible del milenio"), node13);
            TreeNode node131 = new DefaultTreeNode(new OpcionMenu("1.3.1", "3.2. Objetivos PLNBV"), node13);
            TreeNode node133 = new DefaultTreeNode(new OpcionMenu("1.3.3", "3.3. Objetivos Provinciales, Cantonales o Parroquiales"), node13);
            TreeNode node132 = new DefaultTreeNode(new OpcionMenu("1.3.2", "3.4. Objetivos Estratégicos Institucionales"), node13);
            TreeNode node135 = new DefaultTreeNode(new OpcionMenu("1.3.4", "3.5. Líneas de Investigación"), node13);
            TreeNode node137 = new DefaultTreeNode(new OpcionMenu("1.3.6", "3.6. Campo de conocimiento UNESCO"), node13);           
            TreeNode node134 = new DefaultTreeNode(new OpcionMenu("1.4", "4. Matriz del Marco Lógico"), nodePerfil);
            TreeNode node15 = new DefaultTreeNode(new OpcionMenu("1.5", "5. Viabilidad y Plan de Sostenibilidad"), nodePerfil);
            TreeNode node16 = new DefaultTreeNode(new OpcionMenu("1.6", "6. Presupuesto Detallado y Fuentes de Financiamiento"), nodePerfil);
            TreeNode node17 = new DefaultTreeNode(new OpcionMenu("1.7", "7. Estrategia de Ejecución-Cronograma"), nodePerfil);
            TreeNode node171 = new DefaultTreeNode(new OpcionMenu("1.7.1", "7.1. Cronograma Actividades"), node17);
            TreeNode node172 = new DefaultTreeNode(new OpcionMenu("1.7.2", "7.2. Cronograma Hitos"), node17);
            TreeNode node18 = new DefaultTreeNode(new OpcionMenu("1.8", "8. Acta de Consejo de Departamento"), nodePerfil);
            TreeNode node19 = new DefaultTreeNode(new OpcionMenu("1.10", "9. Acta Compromiso Director Proyecto"), nodePerfil);
            TreeNode node20 = new DefaultTreeNode(new OpcionMenu("1.11", "10. Acta Compromiso Carreras"), nodePerfil);
            TreeNode node21 = new DefaultTreeNode(new OpcionMenu("1.9", "11. Finalizar perfil"), nodePerfil);
            if (estadoProyecto.equals(SeaParametrosDet.ESTADO_CERRADO_PERFIL)) {
                nodePerfil.setExpanded(true);
                node21.setSelected(true);
            }
        }

        if (proyectoSelected.getId() != null) {
            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION)
                    || verificarDirectorProyecto()) {
                TreeNode node2 = new DefaultTreeNode(new OpcionMenu("2", "Calificación Comisión Vinculación"), rootMenu);
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)) {
                    TreeNode node21 = new DefaultTreeNode(new OpcionMenu("2.1", "1. Asignación de Comisión de Calificación"), node2);
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION)) {
                    TreeNode node22 = new DefaultTreeNode(new OpcionMenu("2.2", "2. Registro Calificación"), node2);
                    TreeNode node23 = new DefaultTreeNode(new OpcionMenu("2.3", "3. Consolidación Calificación"), node2);
                    if (estadoProyecto.equals(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION)) {
                        node2.setExpanded(true);
                        node23.setSelected(true);
                    }
                }
                TreeNode node23 = new DefaultTreeNode(new OpcionMenu("2.4", "4. Resumen Consolidación Calificación"), node2);
            }
            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)) {
                TreeNode node3 = new DefaultTreeNode(new OpcionMenu("10", "Aprobación Vicerrectorado"), rootMenu);
                TreeNode node4 = new DefaultTreeNode(new OpcionMenu("3", "Aprobación Consejo Académico"), rootMenu);
                if (estadoProyecto.equals(SeaParametrosDet.ESTADO_APROBADO_CONSEJO_ACADEMICO)) {
                    node4.setSelected(true);
                }
            }

            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_IMPRESION_CERTIFICADOS)
                    || verificarDirectorProyecto()) {
                TreeNode node8 = new DefaultTreeNode(new OpcionMenu("4", "Inicio Ejecución"), rootMenu);
                TreeNode node31 = new DefaultTreeNode(new OpcionMenu("4.1", "1. Asignación de Docentes"), node8);
                TreeNode node32 = new DefaultTreeNode(new OpcionMenu("4.2", "2. Asignación de Estudiantes"), node8);
                TreeNode node34 = new DefaultTreeNode(new OpcionMenu("4.3", "3. Compromiso de Participación"), node8);
                TreeNode node35 = new DefaultTreeNode(new OpcionMenu("4.4", "4. Carta Compromiso Comunidad"), node8);
                TreeNode node3 = new DefaultTreeNode(new OpcionMenu("5", "Ejecución"), rootMenu);
                TreeNode node33 = new DefaultTreeNode(new OpcionMenu("5.1", "1. Informes de avance"), node3);
                TreeNode node311 = new DefaultTreeNode(new OpcionMenu("5.2", "2. Horas dedicación docente"), node3);
                TreeNode node322 = new DefaultTreeNode(new OpcionMenu("5.3", "3. Horas dedicación estudiante"), node3);
                TreeNode node333 = new DefaultTreeNode(new OpcionMenu("5.4", "4. Finalizar proceso de ejecución"), node3);
            }
            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION)) {
                TreeNode node6 = new DefaultTreeNode(new OpcionMenu("6", "Seguimiento"), rootMenu);
            }
            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || verificarDirectorProyecto()
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)) {
                TreeNode node7 = new DefaultTreeNode(new OpcionMenu("7", "Cierre"), rootMenu);
                TreeNode node71 = new DefaultTreeNode(new OpcionMenu("7.1", "1. Numérico de Beneficiarios"), node7);
                TreeNode node72 = new DefaultTreeNode(new OpcionMenu("7.2", "2. Objetivos ejecutados"), node7);
                TreeNode node73 = new DefaultTreeNode(new OpcionMenu("7.3", "3. Presupuesto ejecutado"), node7);
                TreeNode node74 = new DefaultTreeNode(new OpcionMenu("7.4", "4. Resultados proyecto"), node7);
                TreeNode node75 = new DefaultTreeNode(new OpcionMenu("7.5", "5. Finalizar proceso de cierre"), node7);
            }

            TreeNode node9 = new DefaultTreeNode(new OpcionMenu("8", "Anexos"), rootMenu);

            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)
                    || verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)) {
                TreeNode nodeEvaluacion = new DefaultTreeNode(new OpcionMenu("9", "Evaluación"), rootMenu);
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)) {
                    TreeNode nodeConfigEvaluadorFinal = new DefaultTreeNode(new OpcionMenu("9.1", "1. Designar Evaluador final"), nodeEvaluacion);
                }
                if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                        || verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)
                        || isPermitirEvaluacionFinal()) {
                    TreeNode nodeEvaluacionFinal = new DefaultTreeNode(new OpcionMenu("9.2", "2. Evaluación Final"), nodeEvaluacion);
                    TreeNode nodeFinalizarEvaluacionFinal = new DefaultTreeNode(new OpcionMenu("9.3", "3. Finalizar Proceso Evaluación"), nodeEvaluacion);

                }
            }
        }
    }

    public void onNodeSelect(NodeSelectEvent event) {
        try {
            /*FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
         FacesContext.getCurrentInstance().addMessage(null, message);*/
            modoEdicion = false;
            OpcionMenu opcionMenu = (OpcionMenu) selectedNode.getData();
            switch (opcionMenu.getCodigo()) {
                case "1.1.1":
                    cancelarPerfil();
                    break;
                case "1.1.2":
                    cancelarP3();
                    break;
                case "1.1.3":
                    cancelarPerfil();
                    break;
                case "1.1.4":
                    cancelarPerfil();
                    break;
                case "1.1.5":
                    initImpactoEsperado();
                    break;
                case "1.2.1":
                    cancelarPerfil();
                    break;
                case "1.2.5":
                    cancelarAnexo();
                    break;
                case "1.2.2":
                    cancelarPerfil();
                    break;
                case "1.2.3":
                    cancelarP5();
                    break;
                case "1.2.4":
                    cancelarP6();
                    break;
                case "1.3.1":
                    cancelarP16(true, true);
                    break;
                case "1.3.2":
                    initIndicadorEstrategia();
                    break;
                case "1.3.3":
                    cancelarP18();
                    break;
                case "1.3.4":
                    initLineaInvestigacion();
                    break;
                case "1.3.5":
                    initObjetivoMilenio();
                    break;
                case "1.3.6":
                    initCampoUnesco();
                    break;
                case "1.4":
                    cancelarP15(true);
                    break;
                case "1.5":
                    cancelarPerfil();
                    break;
                case "1.6":
                    initP7();
                    break;
                case "1.7.1":
                    initCronogramaActividades();
                    break;
                case "1.7.2":
                    initCronogramaHitos();
                    break;
                case "1.8":
                    cancelarEdicionProyecto();
                    break;
                case "1.10":
                    cancelarActaCompromisoParticipacionDirectorProyecto();
                    break;
                case "1.11":
                    cancelarActaCompromisoParticipacionCarreras();
                    break;
                case "1.9":
                    initFinalizarPerfil();
                    break;
                case "2.1"://Asignacion de comision de Calificacion
                    cancelarEdicionComisionCalificacion();
                    break;
                case "2.2"://Calificacion
                    initCalificacion();
                    break;
                case "2.3":
                    initConsolidacionCalificacion();
                    break;
                case "2.4":
                    initConsolidacionCalificacion();
                    break;
                case "3":
                    cancelarAprobacionConsejoAcademico();
                    break;
                case "4.1":
                    initDocenteProyecto();
                    break;
                case "4.2":
                    initEstudianteParticipante();
                    break;
                case "4.3":
                    initCompromisoParticipacionProyecto();
                    break;
                case "5.1":
                    inicioAvance();
                    break;
                case "5.2":
                    initHorasDedicacionDocente();
                    break;
                case "5.3":
                    initHorasDedicacionDocente();
                    break;
                case "5.4":
                    cancelarEdicionProyecto();
                    break;
                case "7.1":
                    initCompromisoParticipacionProyecto();
                    break;
                case "7.2":
                    initObjetivosEjecutados();
                    break;
                case "7.3":
                    cancelarPresupuestoEjecutado();
                    break;
                case "7.4":
                    cancelarEdicionProyecto();
                    break;
                case "7.5":
                    cancelarEdicionProyecto();
                    break;
                case "8":
                    cancelarAnexo();
                    break;
                case "9.1":
                    cancelarEvaluadorFinal();
                    break;
                case "9.2":
                    initEvaluacionFinal();
                    break;
                case "9.3":
                    cancelarFinalizarEvaluacion();
                    break;

                default:
                    selectedNode.setExpanded(true);
                    opcionMenu.setExpanded(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onNodeExpand(NodeExpandEvent event) {
        OpcionMenu opcionMenu = (OpcionMenu) event.getTreeNode();
        opcionMenu.setExpanded(event.getTreeNode().isExpanded());
    }

    public void onNodeCollapse(NodeCollapseEvent event) {
        OpcionMenu opcionMenu = (OpcionMenu) event.getTreeNode();
        opcionMenu.setExpanded(event.getTreeNode().isExpanded());
    }

    private TreeNode selectedNode;

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public String getSelectedNodeCode() {
        if (selectedNode != null) {
            return ((OpcionMenu) selectedNode.getData()).getCodigo();
        } else {
            return "";
        }
    }

    public void onRowToggleOpcionMenu(ToggleEvent event) {
        /*OpcionMenu opcionMenu = (OpcionMenu) event.getData();
         estadoExpandidoObjetivoBVivir.put(subObj.getObjetivoBVivir().getSvobviId(), event.getVisibility() == Visibility.VISIBLE);*/
    }

    private boolean modoEdicion;
    private boolean modoEdicionEvaluacionFinal;

    public boolean isModoEdicionEvaluacionFinal() {
        return modoEdicionEvaluacionFinal;
    }

    public void setModoEdicionEvaluacionFinal(boolean modoEdicionEvaluacionFinal) {
        this.modoEdicionEvaluacionFinal = modoEdicionEvaluacionFinal;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    private AvanceComponente avanceComponenteSelected;

    public AvanceComponente getAvanceComponenteSelected() {
        return avanceComponenteSelected;
    }

    public void setAvanceComponenteSelected(AvanceComponente avanceComponenteSelected) {
        this.avanceComponenteSelected = avanceComponenteSelected;
    }

    public void agregarAvance(ActionEvent event) {
        avanceComponenteSelected = new AvanceComponente();
        avanceComponenteSelected.setComponenteEspecifico(objetivoProyectoSelected);
        avanceComponenteSelected.setFecha(new Date());
        for (ObjetivoPrograma actividad : objetivoProyectoSelected.getSvinObjetivoHijoList()) {
            AvanceActividad seguimientoActividad = new AvanceActividad();
            seguimientoActividad.setAvanceComponente(avanceComponenteSelected);
            seguimientoActividad.setActividad(actividad);
            if (objetivoProyectoSelected.getSeguimientoProyectoActual().getAvanceActividadList() != null) {
                for (AvanceActividad seg : objetivoProyectoSelected.getSeguimientoProyectoActual().getAvanceActividadList()) {
                    if (seg.getActividad().getSvopId().equals(actividad.getSvopId())) {
                        seguimientoActividad.setPorcentajeAvance(seg.getPorcentajeAvance());
                        break;
                    }
                }
            }
            avanceComponenteSelected.addSeguimientoActividad(seguimientoActividad);
        }

    }

    public void cancelarAvance() {
        avanceComponenteSelected = null;
    }

    private void inicioAvance() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        objetivoProyectoSelected = null;
        avanceComponenteSelected = null;
    }

    public String registrarAvance() {
        try {
            if (avanceComponenteSelected.getId() == null) {
                objetivoProyectoSelected.addSeguimientoProyecto(avanceComponenteSelected);
            }
            proyectoFacade.edit(proyectoSelected);
            cancelarAvance();
            proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para el componente y la fecha seleccionados";
                }
                controlMsgError = "formPrincipal:txtFechaAvance_input";
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                if (avanceComponenteSelected.getId() == null) {
                    objetivoProyectoSelected.removeSeguimientoProyecto(avanceComponenteSelected);
                }
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void eliminarAvance() {
        try {
            objetivoProyectoSelected.removeSeguimientoProyecto(avanceComponenteSelected);
            proyectoFacade.edit(proyectoSelected);
            cancelarAvance();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            cancelarAvance();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    private boolean actualizarProyectoComision;

    public void nuevoCalificacion(ActionEvent event) {
        actualizarProyectoComision = false;
        if (proyectoSelected.getConfiguracionParametrosEvaluacion() == null) {
            proyectoSelected.setConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionFacade.findXEvaluacionInicialAndActivo());
            if (proyectoSelected.getConfiguracionParametrosEvaluacion() == null) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:btnAgregarCalificacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No existe una configuración de parámetros de evaluación activa"));
                return;
            }
            actualizarProyectoComision = true;
        }
        if (proyectoSelected.getComisionCalificacion() == null) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:btnAgregarCalificacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se ha asignado aún la comisión de evaluación para el proyecto actual"));
            return;
        }
        MiembroComisionCalificacion miembroComisionCalificacion = verificarMiembroComision();
        if (miembroComisionCalificacion == null) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:btnAgregarCalificacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ud. no se encuentra registrado como integrante de la comisión de evaluación para el proyecto actual"));
            return;
        }

        calificacionProyectoSelected = new CalificacionProyecto();
        calificacionProyectoSelected.setProyecto(proyectoSelected);
        calificacionProyectoSelected.setMiembroComisionCalificacion(miembroComisionCalificacion);
        CalificacionProyecto calificacionProyectoActual = proyectoSelected.getCalificacionActualXUsuario();
        if (calificacionProyectoActual != null) {
            calificacionProyectoSelected.setCumpleRequisitos(calificacionProyectoActual.getCumpleRequisitos());
            //if (permitirEditarCalificacion) {
            if (isEdicionCalificacion()) {
                calificacionProyectoSelected.setObservaciones(calificacionProyectoActual.getObservaciones());
            }
            for (DetalleCalificacionProyecto detalleCalificacionProyecto : calificacionProyectoActual.getDetalleCalificacionList()) {
                DetalleCalificacionProyecto det = new DetalleCalificacionProyecto();
                det.setParametroEvaluacion(detalleCalificacionProyecto.getParametroEvaluacion());
                //det.setPuntaje(detalleCalificacionProyecto.getValoracionParametroEvaluacion().getPuntaje());
                det.setValoracionParametroEvaluacion(detalleCalificacionProyecto.getValoracionParametroEvaluacion());
                det.setCalificacionProyecto(detalleCalificacionProyecto.getCalificacionProyecto());
                //if (permitirEditarCalificacion) {
                if (isEdicionCalificacion()) {
                    det.setObservaciones(detalleCalificacionProyecto.getObservaciones());
                }
                calificacionProyectoSelected.addDetalleCalificacion(det);
            }
        } else {
            for (ParametroEvaluacion parametroEvaluacion : proyectoSelected.getConfiguracionParametrosEvaluacion().getParametroEvaluacionList()) {
                DetalleCalificacionProyecto det = new DetalleCalificacionProyecto();
                det.setParametroEvaluacion(parametroEvaluacion);

                calificacionProyectoSelected.addDetalleCalificacion(det);
            }
        }
        for (DetalleCalificacionProyecto det : calificacionProyectoSelected.getDetalleCalificacionList()) {
            if (null != det.getParametroEvaluacion().getOrden()) {
                switch (det.getParametroEvaluacion().getOrden()) {
                    case 10:
                        //número de departamentos
                        if (proyectoSelected.getDepartamentoProyectoList().isEmpty()) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(0));
                        } else if (proyectoSelected.getDepartamentoProyectoList().size() == 1) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(1));
                        } else if (proyectoSelected.getDepartamentoProyectoList().size() == 2) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(2));
                        } else {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(3));
                        }
                        break;
                    case 11:
                        //número de beneficiarios
                        if (proyectoSelected.getTotalDirectos() < 100) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(0));
                        } else if (proyectoSelected.getTotalDirectos() < 500) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(1));
                        } else if (proyectoSelected.getTotalDirectos() < 1000) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(2));
                        } else if (proyectoSelected.getTotalDirectos() < 2000) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(3));
                        } else {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(4));
                        }
                        break;
                    case 12:
                        //número de estudiantes
                        if (promedioEstudiantes.compareTo(BigDecimal.ONE) < 0) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(0));
                        } else if (promedioEstudiantes.compareTo(BigDecimal.ONE) == 0) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(1));
                        } else if (promedioEstudiantes.compareTo(new BigDecimal(2)) <= 0) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(2));
                        } else {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(3));
                        }
                        break;
                    case 13:
                        //número de docentes
                        if (promedioDocentes.compareTo(BigDecimal.ONE) < 0) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(0));
                        } else if (promedioDocentes.compareTo(BigDecimal.ONE) == 0) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(1));
                        } else if (promedioDocentes.compareTo(new BigDecimal(2)) <= 0) {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(2));
                        } else {
                            det.setValoracionParametroEvaluacion(det.getParametroEvaluacion().getValoracionList().get(3));
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("calificacion", calificacionProyectoSelected);
    }

    public CalificacionProyecto getCalificacionProyectoSelected() {
        return calificacionProyectoSelected;
    }

    public void setCalificacionProyectoSelected(CalificacionProyecto calificacionProyectoSelected) {
        this.calificacionProyectoSelected = calificacionProyectoSelected;
    }

    public String grabarCalificacion() {
        try {
            if (actualizarProyectoComision) { //Asignar al proyecto la configuracion de parametros de evaluacion
                //proyectoFacade.edit(proyectoSelected);
                proyectoFacade.actualizarComisionProyecto2(proyectoSelected);
            }
            if (calificacionProyectoSelected.getCumpleRequisitos().equals(CalificacionProyecto.CUMPLE_REQUISITOS_NO)) {
                for (DetalleCalificacionProyecto det : calificacionProyectoSelected.getDetalleCalificacionList()) {
                    det.setValoracionParametroEvaluacion(null);
                    det.setObservaciones("NO CUMPLE CON REQUISITOS");
                }
            }
            calificacionProyectoFacade.create(calificacionProyectoSelected);
            cancelarEdicionCalificacion(true, true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionCalificacion(false, false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void finalizarCalificacion() {
        try {
            calificacionProyectoSelected = proyectoSelected.getCalificacionActualXUsuario();
            if (calificacionProyectoSelected.getCumpleRequisitos().equals(CalificacionProyecto.CUMPLE_REQUISITOS_SI)) {
                for (DetalleCalificacionProyecto det : calificacionProyectoSelected.getDetalleCalificacionList()) {
                    if (det.getValoracionParametroEvaluacion() == null) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar la calificación de todos los parámetros."));
                        calificacionProyectoSelected = null;
                        return;
                    }
                }
            }
            calificacionProyectoSelected.setEstadoFinalizado(CalificacionProyecto.ESTADO_FINALIZADO_SI);
            calificacionProyectoFacade.edit(calificacionProyectoSelected);
            proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
            int cont = 0;
            for (MiembroComisionCalificacion miembroComisionCalificacion : proyectoSelected.getComisionCalificacion().getMiembroActivoList()) {
                proyectoSelected.setUsuarioActual(miembroComisionCalificacion.getUsuario());
                CalificacionProyecto cal = proyectoSelected.getCalificacionActualXUsuario();
                if (cal != null && cal.getEstadoFinalizado() != null && cal.getEstadoFinalizado().equals(CalificacionProyecto.ESTADO_FINALIZADO_SI)) {
                    cont++;
                }
            }
            if (cont == proyectoSelected.getComisionCalificacion().getMiembroActivoList().size()) {
                proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_CERRADO_CALIFICACION));
                proyectoFacade.edit(proyectoSelected);
            }
            cancelarEdicionCalificacion(true, true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionCalificacion(false, false);
            } catch (Exception e2) {
            }
        }
    }

    private String idPeriodoAereo;
    private String idPeriodoNaval1;
    private String idPeriodoNaval2;
    private String idPeriodoNormal;

    /**
     * Carga los periodos activos para cada tipo : aereo, naval, normal
     */
    private void cargarPeriodos() {
        List<Stvterm> temp = periodoFacade.findPeriodoEstadoActivo();
        idPeriodoAereo = "";
        idPeriodoNaval1 = "";
        idPeriodoNaval2 = "";
        idPeriodoNormal = "";
        for (Stvterm per : temp) {
            if (per.getStvtermDesc().substring(0, 5).equals("CCMM ")) {
                if (idPeriodoAereo.isEmpty()) {
                    idPeriodoAereo = per.getStvtermCode();
                } else if (per.getStvtermCode().compareToIgnoreCase(idPeriodoAereo) > 0) {
                    idPeriodoAereo = per.getStvtermCode();
                }
            } else if ((per.getStvtermDesc().substring(0, 5).equals("GAMA "))) {
                if (idPeriodoNaval1.isEmpty()) {
                    idPeriodoNaval1 = per.getStvtermCode();
                } else if (per.getStvtermCode().compareToIgnoreCase(idPeriodoNaval1) > 0) {
                    idPeriodoNaval1 = per.getStvtermCode();
                }
            } else if (per.getStvtermDesc().substring(0, 13).equals("PREGRADO-GAMA")) {
                if (idPeriodoNaval2.isEmpty()) {
                    idPeriodoNaval2 = per.getStvtermCode();
                } else if (per.getStvtermCode().compareToIgnoreCase(idPeriodoNaval2) > 0) {
                    idPeriodoNaval2 = per.getStvtermCode();
                }
            } else if ((per.getStvtermDesc().substring(0, 9).equals("PREGRADO "))
                    && (per.getStvtermDesc().indexOf("UGT")) == -1) {
                if (idPeriodoNormal.isEmpty()) {
                    idPeriodoNormal = per.getStvtermCode();
                } else if (per.getStvtermCode().compareToIgnoreCase(idPeriodoNormal) > 0) {
                    idPeriodoNormal = per.getStvtermCode();
                }
            }
        }
    }

    private BigDecimal promedioEstudiantes;
    private BigDecimal promedioDocentes;

    /**
     * Calcula el promedio de estudiantes en base al numero de estudiantes
     * planificados a participar en el proyecto sobre el total de estudiantes
     * del periodo actual
     */
    private void calcularPromedioEstudiantes() {
        promedioEstudiantes = BigDecimal.ZERO;
        int nroEstudiantesEspe = 0;
        String codCampus = proyectoSelected.getCampus().getStvcampCode();
        if (codCampus.equals("18")) {
            codCampus = "02";
        }
        for (CarreraProyecto car : proyectoSelected.getCarreraProyectoList()) {
            if (!idPeriodoAereo.isEmpty()) {
                List<VEstudianteCarreraPregrado> temp1 = vEstudianteCarreraPregradoFacade.findByPeriodoCampusCarrera(idPeriodoAereo, codCampus, car.getCarrera().getStvmajrCode());
                for (VEstudianteCarreraPregrado est : temp1) {
                    nroEstudiantesEspe += est.getNroEstudiantes();
                }
            }
            if (!idPeriodoNaval1.isEmpty()) {
                List<VEstudianteCarreraPregrado> temp2 = vEstudianteCarreraPregradoFacade.findByPeriodoCampusCarrera(idPeriodoNaval1, codCampus, car.getCarrera().getStvmajrCode());
                for (VEstudianteCarreraPregrado est : temp2) {
                    nroEstudiantesEspe += est.getNroEstudiantes();
                }
            }
            if (!idPeriodoNaval2.isEmpty()) {
                List<VEstudianteCarreraPregrado> temp3 = vEstudianteCarreraPregradoFacade.findByPeriodoCampusCarrera(idPeriodoNaval2, codCampus, car.getCarrera().getStvmajrCode());
                for (VEstudianteCarreraPregrado est : temp3) {
                    nroEstudiantesEspe += est.getNroEstudiantes();
                }
            }
            if (!idPeriodoNormal.isEmpty()) {
                List<VEstudianteCarreraPregrado> temp4 = vEstudianteCarreraPregradoFacade.findByPeriodoCampusCarrera(idPeriodoNormal, codCampus, car.getCarrera().getStvmajrCode());
                for (VEstudianteCarreraPregrado est : temp4) {
                    nroEstudiantesEspe += est.getNroEstudiantes();
                }
            }
        }
        try {
            promedioEstudiantes = new BigDecimal(proyectoSelected.getTotalEstudiantesParticipantes()).divide(new BigDecimal(nroEstudiantesEspe), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calcula el promedio de docentes en base al numero de docentes
     * planificados a participar en el proyecto sobre el total de docentes del
     * periodo actual
     */
    private void calcularPromedioDocentes() {
        promedioDocentes = BigDecimal.ZERO;
        int nroDocentesEspe = 0;
        for (DepartamentoProyecto dep : proyectoSelected.getDepartamentoProyectoList()) {
            String codCampus = dep.getCampus().getStvcampCode();
            /*if (codCampus.equals("18")){
                codCampus="02";
            }*/
            nroDocentesEspe += vistaDocenteFacade.findCountByCampusDepartamento(codCampus, dep.getDepartamento().getStvsubjCode());
        }
        try {
            promedioDocentes = new BigDecimal(proyectoSelected.getTotalDocentesParticipantes()).divide(new BigDecimal(nroDocentesEspe), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initCalificacion() {
        cargarPeriodos();
        calcularPromedioEstudiantes();
        calcularPromedioDocentes();
        cancelarEdicionCalificacion(true, false);
        mensajeCalificacion = "";
        if (verificarMiembroComision() == null) {
            mensajeCalificacion = "Ud. no se encuentra registrado como integrante de la comisión de evaluación para el proyecto actual";
        }
        calificacionProyectoSelected = (CalificacionProyecto) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("calificacion");
        /*if (calificacionProyectoSelected != null && !calificacionProyectoSelected.getProyecto().equals(proyectoSelected)) {
            calificacionProyectoSelected = null;
        }*/

        //proyectoSelected.setearObjetivoBVivirProyectoPadreList();
    }

    public void cancelarEdicionCalificacion(boolean ocultarPanelEdicion, boolean inicializarVariableSesion) {
        if (ocultarPanelEdicion) {
            calificacionProyectoSelected = null;
        }
        if (inicializarVariableSesion) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("calificacion");
        }
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.setUsuarioActual(usuarioActual);
        //verificarCalificacion();
    }
    private Date fechaActual;

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public void enviarRevisionConsolidacionCalificacion() {
        try {
            visualizarMsgPermitirConsolidacion = false;
            visualizarMsgConsolidacion = false;
            proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_REVISION));
            for (CalificacionProyecto cal : proyectoSelected.getCalificacionList()) {
                cal.setEstadoFinalizado(CalificacionProyecto.ESTADO_FINALIZADO_NO);
            }
            ConsolidacionCalificacionProyecto con = proyectoSelected.getConsolidacionCalificacionUltimaList().get(0);
            con.setEstadoFinalizado(ConsolidacionCalificacionProyecto.ESTADO_FINALIZADO_SI);
            con.setFechaFinalizacionConsolidacion(new Date());
            proyectoFacade.edit(proyectoSelected);

            if (con.getDireccionCorreo() != null && !con.getDireccionCorreo().trim().isEmpty()
                    && con.getAsuntoCorreo() != null && !con.getAsuntoCorreo().trim().isEmpty()
                    && con.getMensajeCorreo() != null && !con.getMensajeCorreo().trim().isEmpty()) {
                try {
                    StringBuilder mensaje = new StringBuilder();
                    mensaje.append(con.getMensajeCorreo().replace("\r\n", "<br>"));
                    mensaje.append("<br><br>")
                            .append("<font color=\"#277C4B\">Saludos Cordiales,<br><br>")
                            .append("UNIDAD DE VINCULACIÓN CON LA SOCIEDAD<br>")
                            .append("Telf. 3989400 ext. 2520 / 2526<br>")
                            .append("</font>")
                            .append("<br><font size=\"1\">Este correo ha sido generado automáticamente, por favor no responder al mismo. Cualquier inquietud comunicarse a los teléfono detallados.</font>")
                            .append("</body>")
                            .append("</html>");
                    WSEnvioMail wSEnvioMail = new WSEnvioMail_Service().getWSEnvioMailPort();
                    wSEnvioMail.enviarMail("aa@gmail.com", con.getDireccionCorreo(), con.getAsuntoCorreo(), mensaje.toString(), true, null, null, null, null);      
                } catch (Exception e) {
                }
            }
            crearArbolMenu(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente, el proyecto fue enviado a revisión al director del proyecto"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {
            cancelarEdicionConsolidacionCalificacion(true);
        }
    }

    private boolean visualizarMsgConsolidacion;

    public boolean isVisualizarMsgConsolidacion() {
        return visualizarMsgConsolidacion;
    }

    public void setVisualizarMsgConsolidacion(boolean visualizarMsgConsolidacion) {
        this.visualizarMsgConsolidacion = visualizarMsgConsolidacion;
    }

    private boolean visualizarMsgPermitirConsolidacion;

    public boolean isVisualizarMsgPermitirConsolidacion() {
        return visualizarMsgPermitirConsolidacion;
    }

    public void setVisualizarMsgPermitirConsolidacion(boolean visualizarMsgPermitirConsolidacion) {
        this.visualizarMsgPermitirConsolidacion = visualizarMsgPermitirConsolidacion;
    }

    //disabled="#{!proyectoController.permitirAgregarConsolidacion || (proyectoController.proyectoSelected.estado!='CEC' and proyectoController.proyectoSelected.estado!='CEP')}"
    public void finalizarConsolidacionCalificacion(ActionEvent event) {
        try {
            visualizarMsgPermitirConsolidacion = false;
            visualizarMsgConsolidacion = false;
            ConsolidacionCalificacionProyecto con = proyectoSelected.getConsolidacionCalificacionUltimaList().get(0);
            if (con.getTotalPuntaje() < proyectoSelected.getConfiguracionParametrosEvaluacion().getPuntajeMinimoRequerido()) {
                proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_RECHAZADO_COMISION_VINCULACION));
            } else {
                proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION));
            }
            con.setEstadoFinalizado(ConsolidacionCalificacionProyecto.ESTADO_FINALIZADO_SI);
            con.setFechaFinalizacionConsolidacion(new Date());
            proyectoSelected.setFechaMaximaCorreccion(null);
            proyectoFacade.edit(proyectoSelected);
            if (con.getDireccionCorreo() != null && !con.getDireccionCorreo().trim().isEmpty()
                    && con.getAsuntoCorreo() != null && !con.getAsuntoCorreo().trim().isEmpty()
                    && con.getMensajeCorreo() != null && !con.getMensajeCorreo().trim().isEmpty()) {
                try {
                    StringBuilder mensaje = new StringBuilder();
                    mensaje.append(con.getMensajeCorreo().replace("\r\n", "<br>"));

                    mensaje.append("<br><br>")
                            .append("<font color=\"#277C4B\">Saludos Cordiales,<br><br>")
                            .append("UNIDAD DE VINCULACIÓN CON LA SOCIEDAD<br>")
                            .append("Telf. 3989400 ext. 2520 / 2526<br>")
                            .append("</font>")
                            .append("<br><font size=\"1\">Este correo ha sido generado automáticamente, por favor no responder al mismo. Cualquier inquietud comunicarse a los teléfono detallados.</font>")
                            .append("</body>")
                            .append("</html>");

                    //Descomentar lo siguiente si se quiere enviar mail automatico al director, cuando el proyecto es aprobado por la comision
                    WSEnvioMail wSEnvioMail = new WSEnvioMail_Service().getWSEnvioMailPort();
                    wSEnvioMail.enviarMail("aa@gmail.com", con.getDireccionCorreo(), con.getAsuntoCorreo(), mensaje.toString(), true, null, null, null, null);
                } catch (Exception e) {
                }
            }

            crearArbolMenu(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {
            cancelarEdicionConsolidacionCalificacion(true);
        }
    }

    public void cancelarEdicionComisionCalificacion() {
        comisionCalificacionList = comisionCalificacionFacade.findAll();
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        modoEdicion = false;
    }

    public String grabarComisionCalificacion() {
        try {
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {
            cancelarEdicionComisionCalificacion();
        }
        return "";
    }

    public List<ComisionCalificacion> getComisionCalificacionList() {
        return comisionCalificacionList;
    }

    public void setComisionCalificacionList(List<ComisionCalificacion> comisionCalificacionList) {
        this.comisionCalificacionList = comisionCalificacionList;
    }

    private ConsolidacionCalificacionProyecto consolidacionCalificacionProyectoSelected;

    public ConsolidacionCalificacionProyecto getConsolidacionCalificacionProyectoSelected() {
        return consolidacionCalificacionProyectoSelected;
    }

    public void setConsolidacionCalificacionProyectoSelected(ConsolidacionCalificacionProyecto consolidacionCalificacionProyectoSelected) {
        this.consolidacionCalificacionProyectoSelected = consolidacionCalificacionProyectoSelected;
    }

    public void nuevoConsolidacionCalificacion(ActionEvent event) {
        if (proyectoSelected.isEstadoEnviadoRevision()) {
            consolidacionCalificacionProyectoSelected = proyectoSelected.getConsolidacionCalificacionUltimaList().get(0);
        } else {
            consolidacionCalificacionProyectoSelected = new ConsolidacionCalificacionProyecto();
            consolidacionCalificacionProyectoSelected.setProyecto(proyectoSelected);
            if (proyectoSelected.getComisionCalificacion() != null) {
                for (MiembroComisionCalificacion miembroComisionCalificacion : proyectoSelected.getComisionCalificacion().getMiembroActivoList()) {
                    proyectoSelected.setUsuarioActual(miembroComisionCalificacion.getUsuario());
                    CalificacionProyecto cal = proyectoSelected.getCalificacionActualXUsuario();
                    if (cal != null && cal.getEstadoFinalizado() != null && cal.getEstadoFinalizado().equals(CalificacionProyecto.ESTADO_FINALIZADO_SI)) {
                        consolidacionCalificacionProyectoSelected.addCalificacionProyecto(cal);
                    }
                }
            }
            boolean encontro = false;
            if (!proyectoSelected.getConsolidacionCalificacionUltimaList().isEmpty()) {
                ConsolidacionCalificacionProyecto con = proyectoSelected.getConsolidacionCalificacionUltimaList().get(0);
                if (con.getEstadoFinalizado().equals(ConsolidacionCalificacionProyecto.ESTADO_FINALIZADO_NO)) {
                    //existe una consolidacion anterior que no ha sido finalizada
                    encontro = true;
                    consolidacionCalificacionProyectoSelected.setDireccionCorreo(con.getDireccionCorreo());
                    consolidacionCalificacionProyectoSelected.setAsuntoCorreo(con.getAsuntoCorreo());
                    consolidacionCalificacionProyectoSelected.setMensajeCorreo(con.getMensajeCorreo());
                    consolidacionCalificacionProyectoSelected.setObservaciones(con.getObservaciones());
                }
            }
            if (!encontro) {//es una nueva consolidación
                consolidacionCalificacionProyectoSelected.setDireccionCorreo(proyectoSelected.getDirector().getUsuario().getUsuEmail());
                //consolidacionCalificacionProyectoSelected.setAsuntoCorreo("Observaciones a la evaluación del proyecto: " + proyectoSelected.getNombre());
                consolidacionCalificacionProyectoSelected.setAsuntoCorreo("Observaciones a la evaluación de proyecto de vinculación");
                consolidacionCalificacionProyectoSelected.setMensajeCorreo("Estimado/a: \r\n" + proyectoSelected.getDirector().getUsuario().getUsuNombres() + " " + proyectoSelected.getDirector().getUsuario().getUsuApellidos() + ",\r\n\r\n");
                consolidacionCalificacionProyectoSelected.setObservaciones(consolidacionCalificacionProyectoSelected.getObservacionesConsolidado());

            }
        }

    }

    private void verificarPermitirConsolidacionCalificacion() {
        mensajeConsolidacion1 = "";
        mensajeConsolidacion2 = "";
        mensajeConsolidacion3 = "";
        if (proyectoSelected.getComisionCalificacion() == null) {
            mensajeConsolidacion1 = "No se ha asignado aún la comisión de evaluación para el proyecto actual.";
        } else if (proyectoSelected.isEstadoEnCalificacionComision()) {
            String temp = "";
            int cont = 0;
            for (MiembroComisionCalificacion miembroComisionCalificacion : proyectoSelected.getComisionCalificacion().getMiembroActivoList()) {
                proyectoSelected.setUsuarioActual(miembroComisionCalificacion.getUsuario());
                CalificacionProyecto cal = proyectoSelected.getCalificacionActualXUsuario();
                if (cal == null || cal.getEstadoFinalizado() == null || cal.getEstadoFinalizado().equals(CalificacionProyecto.ESTADO_FINALIZADO_NO)) {
                    if (!temp.isEmpty()) {
                        temp += ", ";
                    }
                    temp += miembroComisionCalificacion.getUsuario().getNombresCompletos();
                    cont++;
                }
            }
            if (proyectoSelected.getComisionCalificacion().getMiembroActivoList().size() == cont) {
                mensajeConsolidacion2 = "Ningún integrante de la comisión ha ingresado su calificación.";
            } else if (!temp.isEmpty()) {
                mensajeConsolidacion3 = "Los siguientes integrantes de la comisión no han ingresado su calificación: " + temp;
            }

        }
    }

    public String grabarConsolidacionCalificacion() {
        try {
            if (consolidacionCalificacionProyectoSelected.getId() == null) {
                consolidacionCalificacionProyectoSelected.setProyecto(proyectoSelected);
                consolidacionCalificacionProyectoFacade.create(consolidacionCalificacionProyectoSelected);
                for (CalificacionProyecto cal : consolidacionCalificacionProyectoSelected.getCalificacionProyectoList()) {
                    calificacionProyectoFacade.edit(cal);
                }
            } else {
                //consolidacionCalificacionProyectoFacade.edit(consolidacionCalificacionProyectoSelected);
                proyectoFacade.edit(proyectoSelected);
            }

            cancelarEdicionConsolidacionCalificacion(true);
            //verificarPermitirConsolidacionCalificacion();
            mensajeConsolidacion1 = "";
            mensajeConsolidacion2 = "";
            mensajeConsolidacion3 = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConsolidacionCalificacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    private void verificarConsolidacionCalificacion() {
        pendienteConsolidar = false;
        if (proyectoSelected.getComisionCalificacion() != null) {
            for (MiembroComisionCalificacion miembroComisionCalificacion : proyectoSelected.getComisionCalificacion().getMiembroActivoList()) {
                proyectoSelected.setUsuarioActual(miembroComisionCalificacion.getUsuario());
                CalificacionProyecto cal = proyectoSelected.getCalificacionActualXUsuario();
                if (cal != null && cal.getConsolidacionCalificacionProyecto() == null) {
                    pendienteConsolidar = true;
                    break;
                }
            }
        }

    }

    private void initConsolidacionCalificacion() {
        fechaActual = new Date();
        visualizarMsgPermitirConsolidacion = true;
        visualizarMsgConsolidacion = true;
        cancelarEdicionConsolidacionCalificacion(true);
    }

    public void cancelarEdicionConsolidacionCalificacion(boolean ocultarPanelEdicion) {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (proyectoSelected.isEstadoEnviadoRevision() || proyectoSelected.isEstadoEnCalificacionComision()) {
            visualizarMsgPermitirConsolidacion = false;
        }
        verificarConsolidacionCalificacion();
        if (ocultarPanelEdicion) {
            consolidacionCalificacionProyectoSelected = null;
        }

        verificarPermitirConsolidacionCalificacion();
    }

    @EJB
    private ConfiguracionParametrosEvaluacionFacade configuracionParametrosEvaluacionFacade;

    public String abrirReportePorSegmento(String opcionMenu) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);

        /*if (opcionMenu.equals("1.1") || opcionMenu.equals("1.2") || opcionMenu.equals("3.3") || opcionMenu.equals("3.2") || opcionMenu.equals("3.4") || opcionMenu.equals("5") || opcionMenu.equals("6")) {
            options.put("contentWidth", "800");
        }
        if (opcionMenu.equals("6")) {
            options.put("contentHeight", 500);
        } else {
            options.put("contentHeight", 380);
        }*/
        options.put("contentHeight", "100%");
        options.put("contentWidth", "100%");
        options.put("height", "90vh");
        options.put("width", "90%");

        //options.put("closeOnEscape", true); 
        options.put("includeViewParams", true);

        Map<String, List<String>> params = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        values.add(proyectoSelected.getId().toString());
        List<String> values2 = new ArrayList<String>();
        values2.add(opcionMenu);
        params.put("idProyecto", values);
        params.put("opcionMenu", values2);
        RequestContext.getCurrentInstance().openDialog("reportePorOpcion", options, params);
        return "";
    }

    public void cancelarAprobacionConsejoAcademico() {
        modoEdicion = false;
        activeIndexTabAprobacionConsejoAcademico = 0;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (proyectoSelected.getAdjuntarActaAprobacionConsejoAcademico() != null && proyectoSelected.getAdjuntarActaAprobacionConsejoAcademico().equals(Proyecto.ADJUNTAR_ACTA_APROBACION_CONSEJO_ACADEMICO_SI)) {
            adjuntarActaAprobacionConsejoAcademico = true;
        } else {
            adjuntarActaAprobacionConsejoAcademico = false;
        }
        if (proyectoSelected.getAdjuntarMemorandoNotificacionConsejoAcademico() != null && proyectoSelected.getAdjuntarMemorandoNotificacionConsejoAcademico().equals(Proyecto.ADJUNTAR_MEMO_NOTIFICACION_CONSEJO_ACADEMICO_SI)) {
            adjuntarMemoNotificacionConsejoAcademico = true;
        } else {
            adjuntarMemoNotificacionConsejoAcademico = false;
        }
        estadoProyecto = null;
        if (proyectoSelected.isEstadoNoAprobadoConsejoAcademico()) {
            estadoProyecto = "REC";
        } else if (proyectoSelected.isEstadoEjecucion() || proyectoSelected.getMensajePermitirEjecucion().isEmpty()) {
            estadoProyecto = "APR";
        }

    }

    public void subirDocActaAprobacionConsejoAcademico(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "aprobacion_consejo_academico";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            proyectoSelected.setPdfActaAprobacionConsejoAcademicoNombre(event.getFile().getFileName());
            proyectoSelected.setPdfActaAprobacionConsejoAcademicoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    public void subirDocMemorandoAprobacionConsejoAcademico(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "aprobacion_consejo_academico_memorando_notificacion";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            proyectoSelected.setPdfMemorandoAprobacionConsejoAcademicoNombre(event.getFile().getFileName());
            proyectoSelected.setPdfMemorandoAprobacionConsejoAcademicoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }

    }

    public void editarAprobacionConsejoAcademico(ActionEvent event) {
        modoEdicion = true;
        if (proyectoSelected.getFechaAprobacionConsejoAcademico() == null) {
            proyectoSelected.setDireccionCorreo(proyectoSelected.getDirector().getUsuario().getUsuEmail());
            //proyectoSelected.setAsuntoCorreo("Resultado final de aprobación de proyecto: " + proyectoSelected.getNombre());
            proyectoSelected.setAsuntoCorreo("Resultado final de aprobación de proyecto de vinculación");
            proyectoSelected.setMensajeCorreo("Estimado/a: \r\n" + proyectoSelected.getDirector().getUsuario().getUsuNombres() + " " + proyectoSelected.getDirector().getUsuario().getUsuApellidos() + ",\r\n\r\n");
        }
        proyectoSelected.setFechaAprobacionConsejoAcademico(new Date());
    }

    public String grabarAprobacionConsejoAcademico() {
        try {
            if (proyectoSelected.isEstadoAprobacionConsejoAcademico()) {
                proyectoSelected.setFechaAprobacionConsejoAcademico(new Date());
                if (adjuntarActaAprobacionConsejoAcademico) {
                    proyectoSelected.setAdjuntarActaAprobacionConsejoAcademico(Proyecto.ADJUNTAR_ACTA_APROBACION_CONSEJO_ACADEMICO_SI);
                } else {
                    proyectoSelected.setAdjuntarActaAprobacionConsejoAcademico(Proyecto.ADJUNTAR_ACTA_APROBACION_CONSEJO_ACADEMICO_NO);
                }
                if (adjuntarMemoNotificacionConsejoAcademico) {
                    proyectoSelected.setAdjuntarMemorandoNotificacionConsejoAcademico(Proyecto.ADJUNTAR_MEMO_NOTIFICACION_CONSEJO_ACADEMICO_SI);
                } else {
                    proyectoSelected.setAdjuntarMemorandoNotificacionConsejoAcademico(Proyecto.ADJUNTAR_MEMO_NOTIFICACION_CONSEJO_ACADEMICO_NO);
                }
                if (proyectoSelected.isEstadoAprobacionConsejoAcademico()) {
                    if (estadoProyecto.equals("APR")) {
                        proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_APROBADO_CONSEJO_ACADEMICO));
                    } else {
                        proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_RECHAZADO_CONSEJO_ACADEMICO));
                    }

                }
                proyectoFacade.edit(proyectoSelected);
                crearArbolMenu(SeaParametrosDet.ESTADO_APROBADO_CONSEJO_ACADEMICO);
                if (proyectoSelected.getDireccionCorreo() != null && !proyectoSelected.getDireccionCorreo().trim().isEmpty()
                        && proyectoSelected.getAsuntoCorreo() != null && !proyectoSelected.getAsuntoCorreo().trim().isEmpty()
                        && proyectoSelected.getMensajeCorreo() != null && !proyectoSelected.getMensajeCorreo().trim().isEmpty()) {
                    try {
                        StringBuilder mensaje = new StringBuilder();
                        mensaje.append(proyectoSelected.getMensajeCorreo().replace("\r\n", "<br>"));

                        mensaje.append("<br><br>")
                                .append("<font color=\"#277C4B\">Saludos Cordiales,<br><br>")
                                .append("UNIDAD DE VINCULACIÓN CON LA SOCIEDAD<br>")
                                .append("Telf. 3989400 ext. 2520 / 2526<br>")
                                .append("</font>")
                                .append("<br><font size=\"1\">Este correo ha sido generado automáticamente, por favor no responder al mismo. Cualquier inquietud comunicarse a los teléfono detallados.</font>")
                                .append("</body>")
                                .append("</html>");

                        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                        byte[] adjunto1 = null;
                        String nombreAdunto1 = null;
                        if (proyectoSelected.getAdjuntarActaAprobacionConsejoAcademico().equals(Proyecto.ADJUNTAR_ACTA_APROBACION_CONSEJO_ACADEMICO_SI)) {
                            String path = servletContext.getRealPath("") + proyectoSelected.getUrlFinalPdfAprobacionConsejoAcademico();
                            try {
                                adjunto1 = Files.readAllBytes(Paths.get(path));
                                nombreAdunto1 = proyectoSelected.getPdfActaAprobacionConsejoAcademicoNombre();
                            } catch (Exception e) {
                            }
                        }
                        byte[] adjunto2 = null;
                        String nombreAdunto2 = null;
                        if (proyectoSelected.getAdjuntarMemorandoNotificacionConsejoAcademico().equals(Proyecto.ADJUNTAR_MEMO_NOTIFICACION_CONSEJO_ACADEMICO_SI)) {
                            String path = servletContext.getRealPath("") + proyectoSelected.getUrlFinalPdfMemorandoNotificacionConsejoAcademico();
                            try {
                                adjunto2 = Files.readAllBytes(Paths.get(path));
                                nombreAdunto2 = proyectoSelected.getPdfMemorandoAprobacionConsejoAcademicoNombre();
                            } catch (Exception e) {
                            }
                        }
                        WSEnvioMail wSEnvioMail = new WSEnvioMail_Service().getWSEnvioMailPort();
                        wSEnvioMail.enviarMail("aa@gmail.com", proyectoSelected.getDireccionCorreo(), proyectoSelected.getAsuntoCorreo(), mensaje.toString(), true, adjunto1, nombreAdunto1, adjunto2, nombreAdunto2);
                         
                        
                    } catch (Exception e) {
                    }
                }
            } else {
                proyectoFacade.edit(proyectoSelected);  //Solamente se actualiza el memorando de notificacion adjunto.
            }
            cancelarAprobacionConsejoAcademico();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }
    private List<PartidaPresupuestaria> partidaPresupuestariaGastoCorrienteList;
    private List<PartidaPresupuestaria> partidaPresupuestariaGastoInversionList;

    public List<PartidaPresupuestaria> getPartidaPresupuestariaGastoInversionList() {
        return partidaPresupuestariaGastoInversionList;
    }

    public void setPartidaPresupuestariaGastoInversionList(List<PartidaPresupuestaria> partidaPresupuestariaGastoInversionList) {
        this.partidaPresupuestariaGastoInversionList = partidaPresupuestariaGastoInversionList;
    }

    public List<PartidaPresupuestaria> getPartidaPresupuestariaGastoCorrienteList() {
        return partidaPresupuestariaGastoCorrienteList;
    }

    public void setPartidaPresupuestariaGastoCorrienteList(List<PartidaPresupuestaria> partidaPresupuestariaGastoCorrienteList) {
        this.partidaPresupuestariaGastoCorrienteList = partidaPresupuestariaGastoCorrienteList;
    }

    public void nuevoPresupuestoProyecto(ActionEvent event) {
        presupuestoProyectoSelected = new PresupuestoProyecto(proyectoSelected);
        presupuestoProyectoSelected.setPartidaPresupuestaria(null);
        
    }

    @EJB
    private PresupuestoProyectoFacade presupuestoProyectoFacade;

    public String grabarPresupuestoProyecto() {
        try {
            if (presupuestoProyectoSelected.getId() == null) {
                if (!presupuestoProyectoSelected.getTipo().equals(PresupuestoProyecto.TIPO_APORTE_UNIVERSIDAD)) {
                    presupuestoProyectoSelected.setPartidaPresupuestaria(null);
                }
                presupuestoProyectoFacade.create(presupuestoProyectoSelected);
            } else {
                presupuestoProyectoFacade.edit(presupuestoProyectoSelected);
            }
            cancelarPresupuestoProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void cancelarPresupuestoProyecto() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.inicializarListadoPresupuestos();
       
        presupuestoProyectoSelected = null;
    }

    public void eliminarPresupuestoProyecto() {
        try {
            presupuestoProyectoFacade.remove(presupuestoProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            cancelarPresupuestoProyecto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void nuevoPresupuestoProyAporteComunidadBeneficiaria(ActionEvent event) {
        presupuestoProyectoSelected = new PresupuestoProyecto(proyectoSelected, PresupuestoProyecto.TIPO_APORTE_COMUNIDAD_BENEFICIARIA);
        presupuestoProyectoSelected.setPartidaPresupuestaria(null);
    }

    public void onchangeTipoAporte() {
        presupuestoProyectoSelected.setTipoGasto(null);
        presupuestoProyectoSelected.setEspecificacionesTecnicas(null);
        onchangeTipoGasto();
    }

    public void onchangeTipoGasto() {
        presupuestoProyectoSelected.setBienServicio(null);
        presupuestoProyectoSelected.setPartidaPresupuestaria(null);
        presupuestoProyectoSelected.setEspecificacionesTecnicas(null);
    }

    private HorasResponsableProyecto horasResponsableProyectoSelected;

    public HorasResponsableProyecto getHorasResponsableProyectoSelected() {
        return horasResponsableProyectoSelected;
    }

    public void setHorasResponsableProyectoSelected(HorasResponsableProyecto horasResponsableProyectoSelected) {
        this.horasResponsableProyectoSelected = horasResponsableProyectoSelected;
    }

    public String nuevoHorasDedicacionDocente() {
        horasResponsableProyectoSelected = new HorasResponsableProyecto(responsableProyectoSelected);
        return "";
    }
    @EJB
    private HorasResponsableProyectoFacade horasResponsableProyectoFacade;

    public String grabarHorasDedicacionDocente() {
        try {
            if (horasResponsableProyectoSelected.getFechaDesde().after(horasResponsableProyectoSelected.getFechaHasta())) {
                if (horasResponsableProyectoSelected.getResponsableProyecto().getTipoResponsable().getId().equals(TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE)) {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:calFechaHastaHorasDedicacionEstudiante", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La 'fecha hasta' debe ser mayor que la 'fecha desde'"));
                } else {
                    FacesContext.getCurrentInstance().addMessage("formPrincipal:calFechaHastaHorasDedicacionDocente", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La 'fecha hasta' debe ser mayor que la 'fecha desde'"));
                }
            } else {
                if (horasResponsableProyectoSelected.getId() == null) {
                    horasResponsableProyectoFacade.create(horasResponsableProyectoSelected);
                } else {
                    horasResponsableProyectoFacade.edit(horasResponsableProyectoSelected);
                }
                cancelarHorasDedicacionDocente();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));

            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }
    @EJB
    private ConfiguracionFacade configuracionFacade;
    private Configuracion configuracionSelected;

    public Configuracion getConfiguracionSelected() {
        return configuracionSelected;
    }

    public void setConfiguracionSelected(Configuracion configuracionSelected) {
        this.configuracionSelected = configuracionSelected;
    }

    private void initHorasDedicacionDocente() {
        configuracionSelected = configuracionFacade.findAll().get(0);
        cancelarHorasDedicacionDocente();
    }

    public void cancelarHorasDedicacionDocente() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        horasResponsableProyectoSelected = null;
    }

    public void eliminarHorasDedicacionDocente() {
        try {
            horasResponsableProyectoFacade.remove(horasResponsableProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            cancelarHorasDedicacionDocente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    private EvaluacionFinalProyecto evaluacionFinalProyectoSelected;

    public EvaluacionFinalProyecto getEvaluacionFinalProyectoSelected() {
        return evaluacionFinalProyectoSelected;
    }

    public void setEvaluacionFinalProyectoSelected(EvaluacionFinalProyecto evaluacionFinalProyectoSelected) {
        this.evaluacionFinalProyectoSelected = evaluacionFinalProyectoSelected;
    }

    private boolean esPrimeraEvaluacion;
    private Integer activeIndexTabEvaluacion;

    public Integer getActiveIndexTabEvaluacion() {
        return activeIndexTabEvaluacion;
    }

    public void setActiveIndexTabEvaluacion(Integer activeIndexTabEvaluacion) {
        this.activeIndexTabEvaluacion = activeIndexTabEvaluacion;
    }

    public String grabarEvaluacionFinal() {
        try {
            if (esPrimeraEvaluacion) {
                evaluacionFinalProyectoSelected.setProyecto(proyectoSelected);
            }
            evaluacionFinalProyectoSelected.setFecha(fechaEvaluacionFinal);
            evaluacionFinalProyectoSelected.setObservaciones(observacionesEvaluacionFinal);
            for (ParametroEvaluacionFinalCabecera cab : configuracionParametrosEvaluacionActual.getParametroEvaluacionFinalCabeceraList()) {
                //if (!cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)
                            && par.getIdAspectoEvaluacion() != null) {
                        continue;
                    }
                    if (esPrimeraEvaluacion) {
                        DetalleEvaluacionFinalProyecto det = new DetalleEvaluacionFinalProyecto();
                        det.setEvaluacionFinalProyecto(evaluacionFinalProyectoSelected);
                        det.setValoracionParametroEvaluacion(par.getValoracionParametroEvaluacion());
                        det.setInfoAdicional(par.getRespuestaInfoAdicional());
                        evaluacionFinalProyectoSelected.addDetalleEvaluacionFinalProyecto(det);
                    } else {
                        for (DetalleEvaluacionFinalProyecto det : evaluacionFinalProyectoSelected.getDetalleEvaluacionFinalProyectoList()) {
                            if (det.getValoracionParametroEvaluacion() != null && det.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(par)) {
                                det.setValoracionParametroEvaluacion(par.getValoracionParametroEvaluacion());
                                det.setInfoAdicional(par.getRespuestaInfoAdicional());
                                break;
                            }
                        }
                    }
                }
                //}
            }
            //if (evaluacionFinalProyectoSelected.getId()==null){
            evaluacionFinalProyectoFacade.create(evaluacionFinalProyectoSelected);
            if (actualizarConfigEvaluacionFinalProyecto) {
                proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
                proyectoSelected.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionActual);
                proyectoFacade.edit(proyectoSelected);
            }

            /*}
            else
            {
                evaluacionFinalProyectoFacade.edit(evaluacionFinalProyectoSelected);
            }*/
            cancelarEvaluacionFinal(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                //cancelarEdicionCalificacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public String grabarEvaluacionFinal2() {
        try {
            evaluacionFinalProyectoSelected.setProyecto(proyectoSelected);
            evaluacionFinalProyectoSelected.setFecha(fechaEvaluacionFinal);
            evaluacionFinalProyectoSelected.setObservaciones(observacionesEvaluacionFinal);
            for (ParametroEvaluacionFinalCabecera cab : configuracionParametrosEvaluacionActual.getParametroEvaluacionFinalCabeceraList()) {
                for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                    DetalleEvaluacionFinalProyecto det = new DetalleEvaluacionFinalProyecto();
                    det.setEvaluacionFinalProyecto(evaluacionFinalProyectoSelected);
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)
                            && par.getIdAspectoEvaluacion() != null) {
                        det.setObjetivoMatrizMarcoLogico(par.getObjetivoPrograma());
                        det.setPuntaje(par.getValoracionParametroEvaluacion().getPuntaje());
                    } else {
                        det.setValoracionParametroEvaluacion(par.getValoracionParametroEvaluacion());
                        det.setInfoAdicional(par.getRespuestaInfoAdicional());
                    }
                    evaluacionFinalProyectoSelected.addDetalleEvaluacionFinalProyecto(det);
                }
            }
            evaluacionFinalProyectoFacade.create(evaluacionFinalProyectoSelected);
            if (actualizarConfigEvaluacionFinalProyecto) {
                proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
                proyectoSelected.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionActual);
                proyectoFacade.edit(proyectoSelected);
            }
            cancelarEvaluacionFinal2(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                //cancelarEdicionCalificacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    @EJB
    EvaluacionFinalProyectoFacade evaluacionFinalProyectoFacade;

    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionActual;

    public ConfiguracionParametrosEvaluacion getConfiguracionParametrosEvaluacionActual() {
        return configuracionParametrosEvaluacionActual;
    }

    public void setConfiguracionParametrosEvaluacionActual(ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionActual) {
        this.configuracionParametrosEvaluacionActual = configuracionParametrosEvaluacionActual;
    }

    private Date fechaEvaluacionFinal;
    private String observacionesEvaluacionFinal;

    public Date getFechaEvaluacionFinal() {
        return fechaEvaluacionFinal;
    }

    public void setFechaEvaluacionFinal(Date fechaEvaluacionFinal) {
        this.fechaEvaluacionFinal = fechaEvaluacionFinal;
    }

    public String getObservacionesEvaluacionFinal() {
        return observacionesEvaluacionFinal;
    }

    public void setObservacionesEvaluacionFinal(String observacionesEvaluacionFinal) {
        this.observacionesEvaluacionFinal = observacionesEvaluacionFinal;
    }

    private ParametroEvaluacion crearParametroEvaluacionMatrizMarcoLogico(ObjetivoPrograma obj) {
        ParametroEvaluacion par = new ParametroEvaluacion();
        par.setIdAspectoEvaluacion(AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO);
        par.setObjetivoPrograma(obj);
        if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
            par.setDescripcion("FIN: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
            par.setDescripcion("OBJETIVO GENERAL: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_COMPONENTE)) {
            par.setDescripcion("COMPONENTE: " + obj.getSvopObjetivoProy());
        } else {
            par.setDescripcion("ACTIVIDAD: " + obj.getSvopObjetivoProy());
        }

        for (int i = 0; i <= 5; i++) {
            ValoracionParametroEvaluacion val = new ValoracionParametroEvaluacion();
            val.setId(i);
            val.setDescripcion(String.valueOf(i));
            val.setPuntaje(i);
            par.addValoracion(val);
        }
        return par;
    }

    private void initEvaluacionFinal() {
        activeIndexTabEvaluacion = 0;
        cancelarEvaluacionFinal2(false);
        EvaluacionFinalProyecto ev = (EvaluacionFinalProyecto) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("calificacionFinal");
        ConfiguracionParametrosEvaluacion conf = (ConfiguracionParametrosEvaluacion) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("configuracionParametrosEvaluacionActual");
        if (ev != null) {
            evaluacionFinalProyectoSelected = ev;
            configuracionParametrosEvaluacionActual = conf;
        }

    }

    private boolean actualizarConfigEvaluacionFinalProyecto;

    public void cancelarEvaluacionFinal(boolean setearModoEdicion) {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (setearModoEdicion) {
            modoEdicionEvaluacionFinal = false;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("calificacionFinal");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("configuracionParametrosEvaluacionActual");
            observacionesEvaluacionFinal = null;
            fechaEvaluacionFinal = null;
            if (proyectoSelected.getEvaluacionFinal() != null) {
                fechaEvaluacionFinal = proyectoSelected.getEvaluacionFinal().getFecha();
                observacionesEvaluacionFinal = proyectoSelected.getEvaluacionFinal().getObservaciones();
            }
        }
        esPrimeraEvaluacion = true;
        evaluacionFinalProyectoSelected = new EvaluacionFinalProyecto();
        actualizarConfigEvaluacionFinalProyecto = false;
        if (proyectoSelected.getConfiguracionParametrosEvaluacionFinal() == null) {
            actualizarConfigEvaluacionFinalProyecto = true;
            proyectoSelected.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo());
        }
        configuracionParametrosEvaluacionActual = proyectoSelected.getConfiguracionParametrosEvaluacionFinal();
        if (configuracionParametrosEvaluacionActual != null) {
            for (ParametroEvaluacionFinalCabecera cab : configuracionParametrosEvaluacionActual.getParametroEvaluacionFinalCabeceraList()) {
                if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                    for (ObjetivoPrograma obj : proyectoSelected.getObjetivoProyectoPadreList()) {
                        if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
                            cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                            cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                            for (ObjetivoPrograma comp : obj.getSvinObjetivoHijoList()) {
                                cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(comp));
                                for (ObjetivoPrograma act : comp.getSvinObjetivoHijoList()) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(act));
                                }
                            }
                        }
                    }
                }
                ParametroEvaluacion parametroEliminar = null;
                for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA)
                            && proyectoSelected.getTipo().equals(Proyecto.TIPO_GASTO_PERMANENTE)
                            && par.getIdAspectoEvaluacion() != null
                            && par.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD)) {
                        parametroEliminar = par;
                    }
                    par.setProyecto(proyectoSelected);
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)
                            && par.getIdAspectoEvaluacion() != null) {
                        continue;
                    }

                    if (proyectoSelected.getEvaluacionFinal() != null) {
                        for (DetalleEvaluacionFinalProyecto det : proyectoSelected.getEvaluacionFinal().getDetalleEvaluacionFinalProyectoList()) {
                            if (det.getValoracionParametroEvaluacion() != null && det.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(par)) {
                                par.setValoracionParametroEvaluacion(det.getValoracionParametroEvaluacion());
                                par.setRespuestaInfoAdicional(det.getInfoAdicional());
                                break;
                            }
                        }
                    }
                }
                if (parametroEliminar != null) {
                    cab.removeParametro(parametroEliminar);
                }
            }
            configuracionParametrosEvaluacionActual.initValoracion();
        }
    }

    public void cancelarEvaluacionFinal2(boolean setearModoEdicion) {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (setearModoEdicion) {
            modoEdicionEvaluacionFinal = false;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("calificacionFinal");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("configuracionParametrosEvaluacionActual");
            observacionesEvaluacionFinal = null;
            fechaEvaluacionFinal = null;
            if (proyectoSelected.getEvaluacionFinal() != null) {
                fechaEvaluacionFinal = proyectoSelected.getEvaluacionFinal().getFecha();
                observacionesEvaluacionFinal = proyectoSelected.getEvaluacionFinal().getObservaciones();
            }
        }
        esPrimeraEvaluacion = true;
        evaluacionFinalProyectoSelected = new EvaluacionFinalProyecto();
        actualizarConfigEvaluacionFinalProyecto = false;
        if (proyectoSelected.getConfiguracionParametrosEvaluacionFinal() == null) {
            actualizarConfigEvaluacionFinalProyecto = true;
            proyectoSelected.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo());
        }
        configuracionParametrosEvaluacionActual = proyectoSelected.getConfiguracionParametrosEvaluacionFinal();
        if (configuracionParametrosEvaluacionActual != null) {
            for (ParametroEvaluacionFinalCabecera cab : configuracionParametrosEvaluacionActual.getParametroEvaluacionFinalCabeceraList()) {
                if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)) {
                    for (ObjetivoPrograma obj : proyectoSelected.getObjetivoProyectoPadreList()) {
                        if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
                            cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                            cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(obj));
                            for (ObjetivoPrograma comp : obj.getSvinObjetivoHijoList()) {
                                cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(comp));
                                for (ObjetivoPrograma act : comp.getSvinObjetivoHijoList()) {
                                    cab.addParametro(crearParametroEvaluacionMatrizMarcoLogico(act));
                                }
                            }
                        }
                    }
                }
                ParametroEvaluacion parametroEliminar = null;
                for (ParametroEvaluacion par : cab.getParametroEvaluacionList()) {
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICIENCIA)
                            && proyectoSelected.getTipo().equals(Proyecto.TIPO_GASTO_PERMANENTE)
                            && par.getIdAspectoEvaluacion() != null
                            && par.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD)) {
                        parametroEliminar = par;
                    }
                    par.setProyecto(proyectoSelected);
                    if (cab.getTipo().equals(ParametroEvaluacionFinalCabecera.TIPO_ANALISIS_EFICACIA)
                            && par.getIdAspectoEvaluacion() != null) {
                        continue;
                    }

                    if (proyectoSelected.getEvaluacionFinal() != null) {
                        for (DetalleEvaluacionFinalProyecto det : proyectoSelected.getEvaluacionFinal().getDetalleEvaluacionFinalProyectoList()) {
                            if (det.getValoracionParametroEvaluacion() != null && det.getValoracionParametroEvaluacion().getParametroEvaluacion().equals(par)) {
                                par.setValoracionParametroEvaluacion(det.getValoracionParametroEvaluacion());
                                par.setRespuestaInfoAdicional(det.getInfoAdicional());
                                break;
                            }
                        }
                    }
                }
                if (parametroEliminar != null) {
                    cab.removeParametro(parametroEliminar);
                }
            }
            configuracionParametrosEvaluacionActual.initValoracion();
        }
    }

    public void nuevoEvaluacionFinal() {
        modoEdicionEvaluacionFinal = true;
        evaluacionFinalProyectoSelected.setId(null);
        if (evaluacionFinalProyectoSelected.getDetalleEvaluacionFinalProyectoList() != null) {
            for (DetalleEvaluacionFinalProyecto det : evaluacionFinalProyectoSelected.getDetalleEvaluacionFinalProyectoList()) {
                det.setId(null);
            }
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("calificacionFinal", evaluacionFinalProyectoSelected);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("configuracionParametrosEvaluacionActual", configuracionParametrosEvaluacionActual);
    }

    public void onRowToggleEvaluacionFinal(ToggleEvent event) {
        /*ParametroEvaluacionFinalCabecera cab = (ParametroEvaluacionFinalCabecera) event.getData();
        expandedEvaluacionFinal.put(cab.getId(), event.getVisibility() == Visibility.VISIBLE);
        cab.setExpanded(expandedEvaluacionFinal.get(cab.getId()));*/
        ParametroEvaluacionFinalCabecera cab = (ParametroEvaluacionFinalCabecera) event.getData();
        cab.setExpanded(event.getVisibility() == Visibility.VISIBLE);
    }
    private boolean expandedPertinencia;
    private boolean expandedEficacia;
    private boolean expandedEficiencia;
    private boolean expandedSostenibilidad;

    public boolean isExpandedPertinencia() {
        return expandedPertinencia;
    }

    public void setExpandedPertinencia(boolean expandedPertinencia) {
        this.expandedPertinencia = expandedPertinencia;
    }

    public boolean isExpandedEficacia() {
        return expandedEficacia;
    }

    public void setExpandedEficacia(boolean expandedEficacia) {
        this.expandedEficacia = expandedEficacia;
    }

    public boolean isExpandedEficiencia() {
        return expandedEficiencia;
    }

    public void setExpandedEficiencia(boolean expandedEficiencia) {
        this.expandedEficiencia = expandedEficiencia;
    }

    public boolean isExpandedSostenibilidad() {
        return expandedSostenibilidad;
    }

    public void setExpandedSostenibilidad(boolean expandedSostenibilidad) {
        this.expandedSostenibilidad = expandedSostenibilidad;
    }

    private void initFinalizarPerfil() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        msgCoberturaLocalizacion = false;
        msgDiagnosticoProblema = false;
        msgDocentesParticipantes = false;
        msgEntregablesProducto = false;
        msgEstudiantesParticipantes = false;
        msgIdentificacionPoblacion = false;
        msgMatrizMarcoLogicoFin = false;
        msgMatrizMarcoLogicoProposito = false;
        msgMatrizMarcoLogicoComponente = false;
        msgMatrizMarcoLogicoActividad = false;
        msgObjetivosBuenVivir = false;
        msgObjetivosEstrategicos = false;
        msgObjetivosProvCantParr = false;
        msgViabilidad = false;
        msgPresupuestoDetallado = false;
        msgPresupuestoDetalladoGastoPermanente = false;
        msgCronogramaActividades = false;
        msgActaConsejoDepartamento = false;
        msgLineasInvestigacion = false;
        msgActaCompromisoParticipacionDirectorProyecto = false;
        msgActaCompromisoParticipacionCarreras = false;
    }

    private boolean msgCoberturaLocalizacion;
    private boolean msgEntregablesProducto;
    private boolean msgDiagnosticoProblema;
    private boolean msgIdentificacionPoblacion;
    private boolean msgDocentesParticipantes;
    private boolean msgEstudiantesParticipantes;
    private boolean msgObjetivosBuenVivir;
    private boolean msgObjetivosProvCantParr;
    private boolean msgObjetivosEstrategicos;
    private boolean msgLineasInvestigacion;
    private boolean msgMatrizMarcoLogicoFin;
    private boolean msgMatrizMarcoLogicoProposito;
    private boolean msgMatrizMarcoLogicoComponente;
    private boolean msgMatrizMarcoLogicoActividad;
    private boolean msgPresupuestoDetallado;
    private boolean msgPresupuestoDetalladoGastoPermanente;
    private boolean msgCronogramaActividades;
    private boolean msgViabilidad;
    private boolean msgActaConsejoDepartamento;
    private boolean msgActaCompromisoParticipacionDirectorProyecto;
    private boolean msgActaCompromisoParticipacionCarreras;

    public boolean isMsgCronogramaActividades() {
        return msgCronogramaActividades;
    }

    public void setMsgCronogramaActividades(boolean msgCronogramaActividades) {
        this.msgCronogramaActividades = msgCronogramaActividades;
    }

    public boolean isMsgActaCompromisoParticipacionCarreras() {
        return msgActaCompromisoParticipacionCarreras;
    }

    public void setMsgActaCompromisoParticipacionCarreras(boolean msgActaCompromisoParticipacionCarreras) {
        this.msgActaCompromisoParticipacionCarreras = msgActaCompromisoParticipacionCarreras;
    }

    public boolean isMsgActaCompromisoParticipacionDirectorProyecto() {
        return msgActaCompromisoParticipacionDirectorProyecto;
    }

    public void setMsgActaCompromisoParticipacionDirectorProyecto(boolean msgActaCompromisoParticipacionDirectorProyecto) {
        this.msgActaCompromisoParticipacionDirectorProyecto = msgActaCompromisoParticipacionDirectorProyecto;
    }

    public boolean isMsgActaConsejoDepartamento() {
        return msgActaConsejoDepartamento;
    }

    public void setMsgActaConsejoDepartamento(boolean msgActaConsejoDepartamento) {
        this.msgActaConsejoDepartamento = msgActaConsejoDepartamento;
    }

    public boolean isMsgViabilidad() {
        return msgViabilidad;
    }

    public void setMsgViabilidad(boolean msgViabilidad) {
        this.msgViabilidad = msgViabilidad;
    }

    public boolean isMsgPresupuestoDetalladoGastoPermanente() {
        return msgPresupuestoDetalladoGastoPermanente;
    }

    public void setMsgPresupuestoDetalladoGastoPermanente(boolean msgPresupuestoDetalladoGastoPermanente) {
        this.msgPresupuestoDetalladoGastoPermanente = msgPresupuestoDetalladoGastoPermanente;
    }

    public boolean isMsgPresupuestoDetallado() {
        return msgPresupuestoDetallado;
    }

    public void setMsgPresupuestoDetallado(boolean msgPresupuestoDetallado) {
        this.msgPresupuestoDetallado = msgPresupuestoDetallado;
    }

    public boolean isMsgCoberturaLocalizacion() {
        return msgCoberturaLocalizacion;
    }

    public void setMsgCoberturaLocalizacion(boolean msgCoberturaLocalizacion) {
        this.msgCoberturaLocalizacion = msgCoberturaLocalizacion;
    }

    public boolean isMsgEntregablesProducto() {
        return msgEntregablesProducto;
    }

    public void setMsgEntregablesProducto(boolean msgEntregablesProducto) {
        this.msgEntregablesProducto = msgEntregablesProducto;
    }

    public boolean isMsgDiagnosticoProblema() {
        return msgDiagnosticoProblema;
    }

    public void setMsgDiagnosticoProblema(boolean msgDiagnosticoProblema) {
        this.msgDiagnosticoProblema = msgDiagnosticoProblema;
    }

    public boolean isMsgIdentificacionPoblacion() {
        return msgIdentificacionPoblacion;
    }

    public void setMsgIdentificacionPoblacion(boolean msgIdentificacionPoblacion) {
        this.msgIdentificacionPoblacion = msgIdentificacionPoblacion;
    }

    public boolean isMsgDocentesParticipantes() {
        return msgDocentesParticipantes;
    }

    public void setMsgDocentesParticipantes(boolean msgDocentesParticipantes) {
        this.msgDocentesParticipantes = msgDocentesParticipantes;
    }

    public boolean isMsgEstudiantesParticipantes() {
        return msgEstudiantesParticipantes;
    }

    public void setMsgEstudiantesParticipantes(boolean msgEstudiantesParticipantes) {
        this.msgEstudiantesParticipantes = msgEstudiantesParticipantes;
    }

    public boolean isMsgObjetivosBuenVivir() {
        return msgObjetivosBuenVivir;
    }

    public void setMsgObjetivosBuenVivir(boolean msgObjetivosBuenVivir) {
        this.msgObjetivosBuenVivir = msgObjetivosBuenVivir;
    }

    public boolean isMsgObjetivosProvCantParr() {
        return msgObjetivosProvCantParr;
    }

    public void setMsgObjetivosProvCantParr(boolean msgObjetivosProvCantParr) {
        this.msgObjetivosProvCantParr = msgObjetivosProvCantParr;
    }

    public boolean isMsgObjetivosEstrategicos() {
        return msgObjetivosEstrategicos;
    }

    public void setMsgObjetivosEstrategicos(boolean msgObjetivosEstrategicos) {
        this.msgObjetivosEstrategicos = msgObjetivosEstrategicos;
    }

    public boolean isMsgLineasInvestigacion() {
        return msgLineasInvestigacion;
    }

    public void setMsgLineasInvestigacion(boolean msgLineasInvestigacion) {
        this.msgLineasInvestigacion = msgLineasInvestigacion;
    }

    public boolean isMsgMatrizMarcoLogicoFin() {
        return msgMatrizMarcoLogicoFin;
    }

    public void setMsgMatrizMarcoLogicoFin(boolean msgMatrizMarcoLogicoFin) {
        this.msgMatrizMarcoLogicoFin = msgMatrizMarcoLogicoFin;
    }

    public boolean isMsgMatrizMarcoLogicoProposito() {
        return msgMatrizMarcoLogicoProposito;
    }

    public void setMsgMatrizMarcoLogicoProposito(boolean msgMatrizMarcoLogicoProposito) {
        this.msgMatrizMarcoLogicoProposito = msgMatrizMarcoLogicoProposito;
    }

    public boolean isMsgMatrizMarcoLogicoComponente() {
        return msgMatrizMarcoLogicoComponente;
    }

    public void setMsgMatrizMarcoLogicoComponente(boolean msgMatrizMarcoLogicoComponente) {
        this.msgMatrizMarcoLogicoComponente = msgMatrizMarcoLogicoComponente;
    }

    public boolean isMsgMatrizMarcoLogicoActividad() {
        return msgMatrizMarcoLogicoActividad;
    }

    public void setMsgMatrizMarcoLogicoActividad(boolean msgMatrizMarcoLogicoActividad) {
        this.msgMatrizMarcoLogicoActividad = msgMatrizMarcoLogicoActividad;
    }

    public void finalizarPerfil() {
        try {
            if (proyectoSelected.getObjetivosProvCanParr() == null || proyectoSelected.getObjetivosProvCanParr().isEmpty()) {
                msgCoberturaLocalizacion = true;
            }
            if ((proyectoSelected.getBienes() == null || proyectoSelected.getBienes().trim().isEmpty())
                    && (proyectoSelected.getServicios() == null || proyectoSelected.getServicios().trim().isEmpty())
                    && (proyectoSelected.getBienesServicios() == null || proyectoSelected.getBienesServicios().trim().isEmpty())) {
                msgEntregablesProducto = true;
            }
            if (proyectoSelected.getAreaIntervencion2() == null || proyectoSelected.getAreaIntervencion2().isEmpty()) {
                msgDiagnosticoProblema = true;
            }
            if (proyectoSelected.getNroBeneficiariosDirectosHombres() == null) {
                msgIdentificacionPoblacion = true;
            }
            if (proyectoSelected.getDepartamentoProyectoList() == null || proyectoSelected.getDepartamentoProyectoList().isEmpty()) {
                msgDocentesParticipantes = true;
            }
            if (proyectoSelected.getCarreraProyectoList() == null || proyectoSelected.getCarreraProyectoList().isEmpty()) {
                msgEstudiantesParticipantes = true;
            }
            if (proyectoSelected.getObjetivoBVivirProyectoList() == null || proyectoSelected.getObjetivoBVivirProyectoList().isEmpty()) {
                msgObjetivosBuenVivir = true;
            }
            boolean encontro = false;
            for (LocalizacionPrograma parr : proyectoSelected.getObjetivosProvCanParr()) {
                if (parr.getObjetivos() != null && !parr.getObjetivos().isEmpty()) {
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                msgObjetivosProvCantParr = true;
            }
            if (proyectoSelected.getObjetivoEstrategicoList() == null || proyectoSelected.getObjetivoEstrategicoList().isEmpty()) {
                msgObjetivosEstrategicos = true;
            }
            if (proyectoSelected.getLineaInvestigacionProyectoList() == null || proyectoSelected.getLineaInvestigacionProyectoList().isEmpty()) {
                msgLineasInvestigacion = true;
            }

            for (ObjetivoPrograma obj : proyectoSelected.getObjetivoProyectoList()) {
                if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN) && (obj.getSvopObjetivoProy() == null || obj.getSvopObjetivoProy().isEmpty())) {
                    msgMatrizMarcoLogicoFin = true;
                }
                if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
                    if (obj.getSvopObjetivoProy() == null || obj.getSvopObjetivoProy().isEmpty()) {
                        msgMatrizMarcoLogicoProposito = true;
                    }
                    if (obj.getSvinObjetivoHijoList() == null || obj.getSvinObjetivoHijoList().isEmpty()) {
                        msgMatrizMarcoLogicoComponente = true;
                    } else {
                        for (ObjetivoPrograma comp : obj.getSvinObjetivoHijoList()) {
                            if (comp.getSvinObjetivoHijoList() == null || comp.getSvinObjetivoHijoList().isEmpty()) {
                                msgMatrizMarcoLogicoActividad = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (proyectoSelected.getViabilidadTecnica() == null || proyectoSelected.getViabilidadTecnica().isEmpty()) {
                msgViabilidad = true;
            }
            if (proyectoSelected.getPresupuestoProyectoList() == null || proyectoSelected.getPresupuestoProyectoList().isEmpty()) {
                msgPresupuestoDetallado = true;
            } else {
                encontro = false;
                for (PresupuestoProyecto pre : proyectoSelected.getPresupuestoProyectoList()) {
                    if (pre.getTipoGasto() != null && pre.getTipoGasto().equals(PresupuestoProyecto.TIPO_GASTO_CORRIENTE)) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    msgPresupuestoDetalladoGastoPermanente = true;
                }
            }
            if (!proyectoSelected.verificarCronogramaIngresado()) {
                msgCronogramaActividades = true;
            }
            /*if (proyectoSelected.getUrlDocAprobacionConcejoDep() == null || proyectoSelected.getUrlDocAprobacionConcejoDep().isEmpty()) {
                msgActaConsejoDepartamento = true;
            }*/
            if (proyectoSelected.getActaCompromisoDirectorProyectoUrl() == null || proyectoSelected.getActaCompromisoDirectorProyectoUrl().isEmpty()) {
                msgActaCompromisoParticipacionDirectorProyecto = true;
            }
            if (proyectoSelected.getActaCompromisoCarrerasUrl() == null || proyectoSelected.getActaCompromisoCarrerasUrl().isEmpty()) {
                msgActaCompromisoParticipacionCarreras = true;
            }

            if (!(msgCoberturaLocalizacion || msgDiagnosticoProblema || msgDocentesParticipantes || msgEntregablesProducto || msgEstudiantesParticipantes
                    || msgIdentificacionPoblacion || msgMatrizMarcoLogicoFin || msgMatrizMarcoLogicoProposito || msgMatrizMarcoLogicoComponente || msgMatrizMarcoLogicoActividad
                    || msgObjetivosBuenVivir || msgObjetivosEstrategicos || msgLineasInvestigacion || msgObjetivosProvCantParr || msgViabilidad || msgPresupuestoDetallado || msgPresupuestoDetalladoGastoPermanente || msgCronogramaActividades
                    || msgActaConsejoDepartamento || msgActaCompromisoParticipacionDirectorProyecto || msgActaCompromisoParticipacionCarreras)) {
                proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_CERRADO_PERFIL));
                proyectoSelected.setFechaFinalizacionPerfil(new Date());
                for (CalificacionProyecto cal : proyectoSelected.getCalificacionList()) {
                    cal.setEstadoFinalizado(CalificacionProyecto.ESTADO_FINALIZADO_NO);
                }
                proyectoSelected.setFechaMaximaCorreccion(null);
                proyectoFacade.edit(proyectoSelected);
                mensajeFechaMaximaCorreccion = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
                initFinalizarPerfil();
                crearArbolMenu(SeaParametrosDet.ESTADO_CERRADO_PERFIL);
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    private boolean pendienteConsolidar;

    public boolean isPendienteConsolidar() {
        return pendienteConsolidar;
    }

    public void setPendienteConsolidar(boolean pendienteConsolidar) {
        this.pendienteConsolidar = pendienteConsolidar;
    }

    private Integer activeIndexTabAprobacionConsejoAcademico;

    public Integer getActiveIndexTabAprobacionConsejoAcademico() {
        return activeIndexTabAprobacionConsejoAcademico;
    }

    public void setActiveIndexTabAprobacionConsejoAcademico(Integer activeIndexTabAprobacionConsejoAcademico) {
        this.activeIndexTabAprobacionConsejoAcademico = activeIndexTabAprobacionConsejoAcademico;
    }

    private boolean adjuntarActaAprobacionConsejoAcademico;
    private boolean adjuntarMemoNotificacionConsejoAcademico;

    public boolean isAdjuntarActaAprobacionConsejoAcademico() {
        return adjuntarActaAprobacionConsejoAcademico;
    }

    public void setAdjuntarActaAprobacionConsejoAcademico(boolean adjuntarActaAprobacionConsejoAcademico) {
        this.adjuntarActaAprobacionConsejoAcademico = adjuntarActaAprobacionConsejoAcademico;
    }

    public boolean isAdjuntarMemoNotificacionConsejoAcademico() {
        return adjuntarMemoNotificacionConsejoAcademico;
    }

    public void setAdjuntarMemoNotificacionConsejoAcademico(boolean adjuntarMemoNotificacionConsejoAcademico) {
        this.adjuntarMemoNotificacionConsejoAcademico = adjuntarMemoNotificacionConsejoAcademico;
    }

    public void seleccionarCobertura() {
        root3 = crearArbolCobertura();;
    }

    @EJB
    private SeaLineainvesFacade lineaInvestigacionFacade;

    private void initLineaInvestigacion() {
        lineaInvestigacionList = lineaInvestigacionFacade.findLineas();
        lineaInvestigacionSelected = null;
        if (expandedLineaInvestigacion == null) {
            expandedLineaInvestigacion = new HashMap<>();
        } else {
            expandedLineaInvestigacion.clear();
        }

        estadoExpandidoObjetivo = null;
        proyectoSelected.resetEstadoExpandidoObjetivo();
        estadoExpandidoObjetivo = proyectoSelected.getEstadoExpandidoObjetivo();

        cancelarLineaInvestigacion();

    }

    public void cancelarLineaInvestigacion() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.setearLineaInvestigacionList();
        lineaInvestigacionProyectoSelected = null;
        for (SeaLineainves lineaInves : proyectoSelected.getLineaInvestigacionList()) {
            Boolean expanded = (expandedLineaInvestigacion.get(lineaInves.getLineaId()) != null) ? expandedLineaInvestigacion.get(lineaInves.getLineaId()) : false;
            lineaInves.setExpanded(expanded);
        }

    }
    private LineaInvestigacionProyecto lineaInvestigacionProyectoSelected;

    public LineaInvestigacionProyecto getLineaInvestigacionProyectoSelected() {
        return lineaInvestigacionProyectoSelected;
    }

    public void setLineaInvestigacionProyectoSelected(LineaInvestigacionProyecto lineaInvestigacionProyectoSelected) {
        this.lineaInvestigacionProyectoSelected = lineaInvestigacionProyectoSelected;
    }

    public void nuevoLineaInvestigacion() {
        lineaInvestigacionProyectoSelected = new LineaInvestigacionProyecto();
    }

    private List<SeaLineainves> lineaInvestigacionList;

    public List<SeaLineainves> getLineaInvestigacionList() {
        return lineaInvestigacionList;
    }

    public void setLineaInvestigacionList(List<SeaLineainves> lineaInvestigacionList) {
        this.lineaInvestigacionList = lineaInvestigacionList;
    }
    private SeaLineainves lineaInvestigacionSelected;

    public SeaLineainves getLineaInvestigacionSelected() {
        return lineaInvestigacionSelected;
    }

    public void setLineaInvestigacionSelected(SeaLineainves lineaInvestigacionSelected) {
        this.lineaInvestigacionSelected = lineaInvestigacionSelected;
    }
    @EJB
    private LineaInvestigacionProyectoFacade lineaInvestigacionProyectoFacade;

    public void eliminarLineaInvestigacion() {
        try {
            for (LineaInvestigacionProyecto lin : proyectoSelected.getLineaInvestigacionProyectoList()) {
                if (lin.getLineaInvestigacion().getLineaId().equals(lineaInvestigacionSelected.getLineaId())) {
                    lineaInvestigacionProyectoFacade.remove(lin);
                    break;
                }
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarLineaInvestigacion();
        }
    }

    public void grabarLineaInvestigacion() {
        try {
            lineaInvestigacionProyectoSelected.setProyecto(proyectoSelected);
            lineaInvestigacionProyectoFacade.create(lineaInvestigacionProyectoSelected);
            expandedLineaInvestigacion.put(lineaInvestigacionProyectoSelected.getLineaInvestigacion().getLineaIdPadre().getLineaId(), true);
            cancelarLineaInvestigacion();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro para el item seleccionado";
                    lineaInvestigacionProyectoSelected.setId(null);
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    private Map<BigDecimal, Boolean> expandedLineaInvestigacion = new HashMap<BigDecimal, Boolean>();

    public void onRowToggleLineaInvestigacion(ToggleEvent event) {
        SeaLineainves lineaInvestigacion = (SeaLineainves) event.getData();
        expandedLineaInvestigacion.put(lineaInvestigacion.getLineaId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public void seleccionarEvaluadorFinal(SelectEvent event) {
        docenteSelected = (VDocenteVinculacion2) event.getObject();
    }

    public void grabarEvaluadorFinal() {
        try {
            //if (docenteSelected.getUsuCc() == null) {
            if (docenteSelected.getUsuario().getUsuId() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar el docente a designar como evaluador final"));
            } else {
                proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
                proyectoSelected.asignarEvaluadorFinal(docenteSelected.getUsuario());
                proyectoFacade.edit(proyectoSelected);
                cancelarEvaluadorFinal();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void cancelarEvaluadorFinal() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (proyectoSelected.getConfiguracionParametrosEvaluacionFinal() == null) {
            proyectoSelected.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo());
        }

        modoEdicion = false;
        docenteSelected = new VDocenteVinculacion2();
        if (proyectoSelected.getEvaluadorFinal() != null) {
            docenteSelected.setUsuario(proyectoSelected.getEvaluadorFinal().getUsuario());
        }

    }

    private AnexoProyecto anexoProyectoSelected;

    public AnexoProyecto getAnexoProyectoSelected() {
        return anexoProyectoSelected;
    }

    public void setAnexoProyectoSelected(AnexoProyecto anexoProyectoSelected) {
        this.anexoProyectoSelected = anexoProyectoSelected;
    }

    public void nuevoAnexo() {
        anexoProyectoSelected = new AnexoProyecto();
    }

    public void cancelarAnexo() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.initAnexos();
        anexoProyectoSelected = null;
    }

    @EJB
    private AnexoProyectoFacade anexoProyectoFacade;

    public void grabarAnexo() {
        try {
            if (proyectoSelected.existeAnexo(anexoProyectoSelected)) {
                String idControl = "formPrincipal:hidNombreAnexo";
                if (anexoProyectoSelected.getTipo().equals(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA)) {
                    idControl = "formPrincipal:hidNombreAnexoDiagnosticoProblema";
                }
                FacesContext.getCurrentInstance().addMessage(idControl, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ya existe un anexo con el nombre ingresado"));
            } else {
                anexoProyectoSelected.setUsuario(usuarioActual);
                anexoProyectoSelected.setProyecto(proyectoSelected);
                anexoProyectoFacade.create(anexoProyectoSelected);
                cancelarAnexo();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }

        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void subirAnexo(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "anexos";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            anexoProyectoSelected.setArchivoNombre(event.getFile().getFileName());
            anexoProyectoSelected.setArchivoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    public void eliminarAnexo() {
        try {
            anexoProyectoFacade.remove(anexoProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarAnexo();
        }
    }

    private StreamedContent archivoAdjunto;

    public StreamedContent getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(StreamedContent archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public void prepararArchivoDownload(AnexoProyecto anexoProyecto) {
        /*byte[] conteudo = convocatoria.getDocumento();
         String nom = convocatoria.getNombreDocumento();
         //this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(conteudo), "application/octet-stream", nom);
         this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(conteudo), "application/pdf", nom);
         */

        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + anexoProyecto.getArchivoUrlFinal();
            this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", anexoProyecto.getArchivoNombre());
        } catch (Exception e) {

        }

    }

    private CompromisoParticipacionProyecto compromisoParticipacionProyectoSelected;

    public CompromisoParticipacionProyecto getCompromisoParticipacionProyectoSelected() {
        return compromisoParticipacionProyectoSelected;
    }

    public void setCompromisoParticipacionProyectoSelected(CompromisoParticipacionProyecto compromisoParticipacionProyectoSelected) {
        this.compromisoParticipacionProyectoSelected = compromisoParticipacionProyectoSelected;
    }

    public void nuevoCompromisoParticipacionProyecto() {
        compromisoParticipacionProyectoSelected = new CompromisoParticipacionProyecto();
        tipoOrganizacionList2 = new ArrayList<>();
    }
    @EJB
    private CompromisoParticipacionProyectoFacade compromisoParticipacionProyectoFacade;

    private void initCompromisoParticipacionProyecto() {
        tipoCompromisoParticipacionList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_TIPO_COMPROMISO_PARTICIPACION);
        tipoOrganizacionList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_TIPO_ORGANIZACION);
        cancelarCompromisoParticipacionProyecto();
    }

    public void cancelarCompromisoParticipacionProyecto() {
        compromisoParticipacionProyectoSelected = null;
        documentoCompromisoParticipacionSelected=null;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
    }

    public void grabarCompromisoParticipacionProyecto() {
        try {
            if (compromisoParticipacionProyectoSelected.getId() == null) {
                compromisoParticipacionProyectoSelected.setProyecto(proyectoSelected);
                compromisoParticipacionProyectoFacade.create(compromisoParticipacionProyectoSelected);
            } else {
                compromisoParticipacionProyectoFacade.edit(compromisoParticipacionProyectoSelected);
            }
            cancelarCompromisoParticipacionProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void abrirBusquedaInstitucion(ActionEvent event) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("contentHeight", 380);
        options.put("contentWidth", 800);
        //options.put("closeOnEscape", true); 
        options.put("includeViewParams", true);

        RequestContext.getCurrentInstance().openDialog("busquedaInstitucion", options, null);
    }

    public void seleccionarInstitucion(SelectEvent event) {
        Institucion institucion = (Institucion) event.getObject();
        compromisoParticipacionProyectoSelected.setInstitucion(institucion);
    }

    private List<SeaParametrosDet> tipoCompromisoParticipacionList;
    private List<SeaParametrosDet> tipoOrganizacionList;
    private List<SeaParametrosDet> tipoOrganizacionList2;

    public List<SeaParametrosDet> getTipoCompromisoParticipacionList() {
        return tipoCompromisoParticipacionList;
    }

    public void setTipoCompromisoParticipacionList(List<SeaParametrosDet> tipoCompromisoParticipacionList) {
        this.tipoCompromisoParticipacionList = tipoCompromisoParticipacionList;
    }

    public List<SeaParametrosDet> getTipoOrganizacionList2() {
        return tipoOrganizacionList2;
    }

    public void setTipoOrganizacionList2(List<SeaParametrosDet> tipoOrganizacionList2) {
        this.tipoOrganizacionList2 = tipoOrganizacionList2;
    }

    public void seleccionarTipoCompromisoParticipacion(boolean setearTipoOrganizacion) {
        tipoOrganizacionList2 = new ArrayList<>();
        if (setearTipoOrganizacion) {
            compromisoParticipacionProyectoSelected.setTipoOrganizacion(null);
        }

        for (SeaParametrosDet tipoOrg : tipoOrganizacionList) {
            if (compromisoParticipacionProyectoSelected.getTipoParticipacion().getPrdId().equals(SeaParametrosDet.PARAM_TIPO_COMPROMISO_PARTICIPACION_COMUNIDAD)) {
                if (tipoOrg.getPrdId().equals(SeaParametrosDet.PARAM_TIPO_ORGANIZACION_RURAL)
                        || tipoOrg.getPrdId().equals(SeaParametrosDet.PARAM_TIPO_ORGANIZACION_URBANO_MARGINAL)
                        || tipoOrg.getPrdId().equals(SeaParametrosDet.PARAM_TIPO_ORGANIZACION_GRUPO_ATENCION_PRIORITARIA)) {
                    tipoOrganizacionList2.add(tipoOrg);
                }
            } else if (tipoOrg.getPrdId().equals(SeaParametrosDet.PARAM_TIPO_ORGANIZACION_INSTITUCION_PUBLICA)
                    || tipoOrg.getPrdId().equals(SeaParametrosDet.PARAM_TIPO_ORGANIZACION_INSTITUCION_PRIVADA)
                    || tipoOrg.getPrdId().equals(SeaParametrosDet.PARAM_TIPO_ORGANIZACION_ONG)
                    || tipoOrg.getPrdId().equals(SeaParametrosDet.PARAM_TIPO_ORGANIZACION_OTROS)) {
                tipoOrganizacionList2.add(tipoOrg);
            }
        }
    }

    public void eliminarCompromisoParticipacionProyecto() {
        try {
            compromisoParticipacionProyectoFacade.remove(compromisoParticipacionProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarCompromisoParticipacionProyecto();
        }
    }

    public void seleccionarCompromisoParticipacionProyecto() {
        seleccionarTipoCompromisoParticipacion(false);
    }

    public void nuevoEstudianteParticipante() {
        responsableProyectoSelected = new ResponsableProyecto(new TipoResponsable(TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE));
    }
    

    public String grabarEstudianteParticipante() {
        try {
            if (responsableProyectoSelected.getId() == null) {
                responsableProyectoSelected.setProyecto(proyectoSelected);
                responsableProyectoFacade.create(responsableProyectoSelected);
            } else {
                responsableProyectoFacade.edit(responsableProyectoSelected);
            }
            cancelarEstudianteParticipante();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void initEstudianteParticipante() {
        directorCarreraList = directorCarreraFacade.findAll();
        cancelarEstudianteParticipante();
    }
    public void cancelarEstudianteParticipante() {
                
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        responsableProyectoSelected = null;
        cancelarActaDesignacionEstudiante();
    }

    public void abrirBusquedaEstudiante(ActionEvent event) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("contentHeight", 380);
        options.put("contentWidth", 800);
        //options.put("closeOnEscape", true); 
        options.put("includeViewParams", true);

        Map<String, List<String>> params = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        values.add(proyectoSelected.getId().toString());
        params.put("idProyecto", values);
        RequestContext.getCurrentInstance().openDialog("busquedaEstudiante", options, params);
    }

    public void seleccionarEstudiante(SelectEvent event) {
        VEstudiante estudiante = (VEstudiante) event.getObject();
        responsableProyectoSelected.setDepartamento(estudiante.getDepartamento());
        responsableProyectoSelected.setUsuario(estudiante.getUsuario());
        responsableProyectoSelected.setCarrera(estudiante.getCarrera());
    }

    public void eliminarEstudianteParticipante() {
        try {
            responsableProyectoFacade.remove(responsableProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEstudianteParticipante();
        }
    }

    public void cancelarActaDesignacionEstudiante() {
        actaDesignacionResponsableSelected = null;
        actaDesignacionResponsableList = actaDesignacionResponsableFacade.findByTipo(proyectoSelected.getId(), TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE);
    }
    public boolean isPermitirGenerarActaDesignacionEstudiante() {
        for (ResponsableProyecto r : proyectoSelected.getParticipanteEstudianteList()) {
            if (r.getActaDesignacionResponsable() == null) {
                return true;
            }
        }
        return false;
    }

    public void generarActaDesignacionEstudiante() {
        try {
            for (ResponsableProyecto r : proyectoSelected.getParticipanteEstudianteList()) {
                if (r.getActaDesignacionResponsable()==null){
                    if (r.getHorasPlanificadas()==null){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar el número de horas planificadas para todos los estudiantes."));
                        return;
                    }
                }
            }
            
            ActaDesignacionResponsable a = actaDesignacionResponsableFacade.findByMaximoSecuencial(proyectoSelected.getId(), TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE);
            Integer secuencial = 1;
            if (a != null) {
                secuencial = a.getSecuencial() + 1;
            }
            a = new ActaDesignacionResponsable();
            a.setUsuario(usuarioActual);
            a.setSecuencial(secuencial);
            actaDesignacionResponsableFacade.create(a);
            
            for (ResponsableProyecto r : proyectoSelected.getParticipanteEstudianteList()) {
                if (r.getActaDesignacionResponsable()==null){
                    r.setActaDesignacionResponsable(a);
                    responsableProyectoFacade.edit(r);
                }
            }
            
            cancelarEstudianteParticipante();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
            } catch (Exception e2) {
            }
        }
    }
    public void eliminarActaDesignacionEstudiante(ActaDesignacionResponsable acta) {
        try {
            for (ResponsableProyecto r : acta.getResponsableList()) {
                r.setActaDesignacionResponsable(null);
                responsableProyectoFacade.edit(r);
            }
            actaDesignacionResponsableFacade.remove(acta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            cancelarEstudianteParticipante();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }
    
    public void subirDocDesignacionEstudianteFirmas(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "acta_designacion_estudiantes";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + actaDesignacionResponsableSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            actaDesignacionResponsableSelected.setDocumentoFirmadoNombre(event.getFile().getFileName());
            actaDesignacionResponsableSelected.setDocumentoFirmadoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + actaDesignacionResponsableSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }

    }

    public void imprimirActaDesignacionEstudiante(ActaDesignacionResponsable acta) {
        imprimirActaDesignacionEstudiante(JasperReportUtil.TIPO_PDF, acta);
    }
    private StreamedContent archivoActaDesignacionEstudiante;

    public StreamedContent getArchivoActaDesignacionEstudiante() {
        return archivoActaDesignacionEstudiante;
    }

    public void setArchivoActaDesignacionEstudiante(StreamedContent archivoActaDesignacionEstudiante) {
        this.archivoActaDesignacionEstudiante = archivoActaDesignacionEstudiante;
    }

    public void prepararActaDesignacionEstudianteDownload(ActaDesignacionResponsable acta) {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + acta.getDocumentoFirmadoUrlFinal();
            this.archivoActaDesignacionEstudiante = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", acta.getDocumentoFirmadoNombre());
        } catch (Exception e) {

        }
    }

    private void imprimirActaDesignacionEstudiante(String tipoReporte, ActaDesignacionResponsable acta) {
        try {
            acta.llenarDatosDirectorCarrera(directorCarreraList);
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            parametros.put("proyecto", proyectoSelected.getNombre());
            String carreras= "";
            for (VDirectorCarrera c : acta.getDirectorCarreraList()) {
                if (!carreras.isEmpty()){
                    if (c.equals(acta.getDirectorCarreraList().get(acta.getDirectorCarreraList().size()-1))){
                        carreras+=" y ";
                    }
                    else{
                        carreras+=", ";
                    }
                }
                carreras+=c.getCarrera().getStvmajrDesc();
            }
            parametros.put("carreras", carreras);
            parametros.put("proyecto", proyectoSelected.getNombre());

            SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy", new Locale("ES"));
            String fechaActual = "Sangolquí, " + formatter.format(new Date());
            parametros.put("fechaActual", fechaActual);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            List<ActaDesignacionResponsable> listaActas = new ArrayList<>();
            listaActas.add(acta);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_ACTA_DESIGNACION_ESTUDIANTES, tipoReporte, parametros, listaActas);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void grabarActaDesignacionEstudiante() {
        try {
            actaDesignacionResponsableFacade.edit(actaDesignacionResponsableSelected);
            cancelarEstudianteParticipante();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
            } catch (Exception e2) {
            }
        }
    }

    public void grabarPresupuestoEjecutado() {
        try {
            for (PresupuestoProyecto pres : proyectoSelected.getPresupuestoProyectoList()) {
                if (pres.getTotalEjecutado().compareTo(pres.getTotal()) > 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El valor ejecutado no debe ser mayor al valor planificado"));
                    return;
                }
            }
            proyectoFacade.edit(proyectoSelected);
            cancelarPresupuestoEjecutado();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void cancelarPresupuestoEjecutado() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.inicializarListadoPresupuestos();
        modoEdicion = false;
    }

    private void initObjetivosEjecutados() {
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        estadoExpandidoObjetivo = null;
        proyectoSelected.resetEstadoExpandidoObjetivo();
        estadoExpandidoObjetivo = proyectoSelected.getEstadoExpandidoObjetivo();

    }

    public void cancelarObjetivosEjecutados() {
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.setEstadoExpandidoObjetivo(estadoExpandidoObjetivo);
    }

    public void grabarObjetivosEjecutados() {
        try {
            proyectoFacade.edit(proyectoSelected);
            cancelarObjetivosEjecutados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }

        }
    }

    public void registraProyecto() {
        try {
            proyectoFacade.edit(proyectoSelected);
            cancelarEdicionProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }

        }
    }

    public void cancelarEdicionProyecto() {
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        msgEjecucionEstudiantes = false;
        msgEjecucionCompromisoParticipacion = false;
        msgEjecucionDocumentoCompromisoParticipacion = false;
        msgEjecucionCartaCompromisoComunidad = false;
        msgEjecucionInformeAvance = false;
        msgEjecucionHorasEstudiantes = false;
        msgEjecucionHorasDocentes = false;

        msgCierreBeneficiarios = false;
        msgCierreObjetivos = false;
        msgCierrePresupuesto = false;
        msgCierreResultados = false;

    }

    public void finalizarCierre() {
        try {
            for (CompromisoParticipacionProyecto com : proyectoSelected.getCompromisoParticipacionList()) {
                if (com.getNroBeneficiariosDirectosHombres() == null) {
                    msgCierreBeneficiarios = true;
                    break;
                }
            }
            for (ObjetivoPrograma obj : proyectoSelected.getObjetivoProyectoList()) {
                if (obj.getIndicadorValorEjecutado() == null) {
                    msgCierreObjetivos = true;
                    break;
                }
            }
            for (PresupuestoProyecto pre : proyectoSelected.getPresupuestoProyectoList()) {
                if (pre.getTotalEjecutado() == null) {
                    msgCierrePresupuesto = true;
                    break;
                }
            }
            if (proyectoSelected.getCierreProductos() == null) {
                msgCierreResultados = true;
            }
            if (!(msgCierreBeneficiarios || msgCierreObjetivos || msgCierrePresupuesto || msgCierreResultados)) {
                proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_CERRADO));
                proyectoSelected.setFechaCierre(new Date());
                proyectoFacade.edit(proyectoSelected);
                cancelarEdicionProyecto();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    private boolean msgEjecucionEstudiantes;
    private boolean msgEjecucionCompromisoParticipacion;
    private boolean msgEjecucionDocumentoCompromisoParticipacion;
    private boolean msgEjecucionCartaCompromisoComunidad;
    private boolean msgEjecucionInformeAvance;
    private boolean msgEjecucionHorasEstudiantes;
    private boolean msgEjecucionHorasDocentes;

    public boolean isMsgEjecucionDocumentoCompromisoParticipacion() {
        return msgEjecucionDocumentoCompromisoParticipacion;
    }

    public void setMsgEjecucionDocumentoCompromisoParticipacion(boolean msgEjecucionDocumentoCompromisoParticipacion) {
        this.msgEjecucionDocumentoCompromisoParticipacion = msgEjecucionDocumentoCompromisoParticipacion;
    }

    
    public boolean isMsgEjecucionEstudiantes() {
        return msgEjecucionEstudiantes;
    }

    public void setMsgEjecucionEstudiantes(boolean msgEjecucionEstudiantes) {
        this.msgEjecucionEstudiantes = msgEjecucionEstudiantes;
    }

    public boolean isMsgEjecucionCompromisoParticipacion() {
        return msgEjecucionCompromisoParticipacion;
    }

    public void setMsgEjecucionCompromisoParticipacion(boolean msgEjecucionCompromisoParticipacion) {
        this.msgEjecucionCompromisoParticipacion = msgEjecucionCompromisoParticipacion;
    }

    public boolean isMsgEjecucionCartaCompromisoComunidad() {
        return msgEjecucionCartaCompromisoComunidad;
    }

    public void setMsgEjecucionCartaCompromisoComunidad(boolean msgEjecucionCartaCompromisoComunidad) {
        this.msgEjecucionCartaCompromisoComunidad = msgEjecucionCartaCompromisoComunidad;
    }

    public boolean isMsgEjecucionInformeAvance() {
        return msgEjecucionInformeAvance;
    }

    public void setMsgEjecucionInformeAvance(boolean msgEjecucionInformeAvance) {
        this.msgEjecucionInformeAvance = msgEjecucionInformeAvance;
    }

    public boolean isMsgEjecucionHorasEstudiantes() {
        return msgEjecucionHorasEstudiantes;
    }

    public void setMsgEjecucionHorasEstudiantes(boolean msgEjecucionHorasEstudiantes) {
        this.msgEjecucionHorasEstudiantes = msgEjecucionHorasEstudiantes;
    }

    public boolean isMsgEjecucionHorasDocentes() {
        return msgEjecucionHorasDocentes;
    }

    public void setMsgEjecucionHorasDocentes(boolean msgEjecucionHorasDocentes) {
        this.msgEjecucionHorasDocentes = msgEjecucionHorasDocentes;
    }

    public void finalizarEjecucion() {
        try {
            if (proyectoSelected.getParticipanteEstudianteList().isEmpty()) {
                msgEjecucionEstudiantes = true;
            }
            if (proyectoSelected.getCompromisoParticipacionList() == null || proyectoSelected.getCompromisoParticipacionList().isEmpty()) {
                msgEjecucionCompromisoParticipacion = true;
            }
            else{
                for (CompromisoParticipacionProyecto c : proyectoSelected.getCompromisoParticipacionList()) {
                    if (c.getDocumentoList()==null || c.getDocumentoList().isEmpty()){
                        msgEjecucionDocumentoCompromisoParticipacion = true;
                    }
                }
            }
            if (proyectoSelected.getCartaCompromisoComunidadNombre() == null) {
                msgEjecucionCartaCompromisoComunidad = true;
            }
            for (ObjetivoPrograma obj : proyectoSelected.getComponentes()) {
                if (obj.getAvanceComponenteList() == null || obj.getAvanceComponenteList().isEmpty()) {
                    msgEjecucionInformeAvance = true;
                    break;
                }
            }

            for (ResponsableProyecto res : proyectoSelected.getParticipanteDocenteTodosList()) {
                if (res.getTotalHorasDedicadas() == 0) {
                    msgEjecucionHorasDocentes = true;
                    break;
                }
            }
            for (ResponsableProyecto res : proyectoSelected.getParticipanteEstudianteList()) {
                if (res.getTotalHorasDedicadas() == 0) {
                    msgEjecucionHorasEstudiantes = true;
                    break;
                }
            }
            if (!(msgEjecucionCartaCompromisoComunidad || msgEjecucionCompromisoParticipacion || msgEjecucionDocumentoCompromisoParticipacion || msgEjecucionEstudiantes || msgEjecucionHorasDocentes
                    || msgEjecucionHorasEstudiantes || msgEjecucionInformeAvance)) {
                proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_CERRADO_EJECUCION));
                proyectoSelected.setFechaFinalizacioEjecucion(new Date());
                proyectoFacade.edit(proyectoSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
                cancelarEdicionProyecto();
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void finalizarEvaluacionFinal() {
        try {
            if (!proyectoSelected.verificarEvaluacionFinal()) {
                msgEvaluacionFinal = true;
            } else {
                proyectoSelected.setEstado(new SeaParametrosDet(SeaParametrosDet.ESTADO_EVALUADO));
                proyectoSelected.setFechaEvaluacionFinal(new Date());
                proyectoFacade.edit(proyectoSelected);
                cancelarFinalizarEvaluacion();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {

        }
    }

    public void cancelarFinalizarEvaluacion() {
        msgEvaluacionFinal = false;
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        if (proyectoSelected.getConfiguracionParametrosEvaluacionFinal() == null) {
            proyectoSelected.setConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo());
        }
    }

    private List<Proyecto> proyectoList;

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    private String estadoProyecto;

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public void nuevoAnexoDiagnosticoProblema() {
        anexoProyectoSelected = new AnexoProyecto();
        anexoProyectoSelected.setTipo(AnexoProyecto.TIPO_IMG_DIAGNOSTICO_PROBLEMA);
    }

    /*public void cancelarAnexoDiagnosticoProblema() {
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        proyectoSelected.initAnexos();
        anexoProyectoSelected = null;
    }
    public void grabarAnexoDiagnosticoProblema() {
        try {
            anexoProyectoSelected.setUsuario(usuarioActual);
            anexoProyectoSelected.setProyecto(proyectoSelected);
            anexoProyectoFacade.create(anexoProyectoSelected);
            cancelarAnexoDiagnosticoProblema();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }
     */
    public void subirAnexoDiagnosticoProblema(FileUploadEvent event) {
        try {

            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "anexosDiagnosticoProblema";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            anexoProyectoSelected.setArchivoNombre(event.getFile().getFileName());
            anexoProyectoSelected.setArchivoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    /*public void eliminarAnexoDiagnosticoProblema() {
        try {
            anexoProyectoFacade.remove(anexoProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarAnexo();
        }
    }*/
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public boolean verificarDirectorProyecto() {
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_PROYECTO)
                && proyectoSelected.getDirector() != null
                && proyectoSelected.getDirector().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    private boolean verificarPerfil(String perfil) {
        for (SegPerfil per : perfilUsuarioActual) {
            if (per.getPerNombre().toUpperCase().equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    public void generarReportePerfilPDF() {
        generarReportePerfil(JasperReportUtil.TIPO_PDF);

    }

    private void generarReportePerfil(String tipoReporte) {
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            System.out.println("SUBREPORT_DIR" + JasperReportUtil.PATH);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            parametros.put("idProyecto", proyectoSelected.getId());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PERFIL_PROYECTO, tipoReporte, parametros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*public void imprimirCertificadoParticipacionEstudiante(ResponsableProyecto responsableProyecto) {
        generarCertificadoParticipacionEstudiante(JasperReportUtil.TIPO_PDF, responsableProyecto);
    }

    private void generarCertificadoParticipacionEstudiante(String tipoReporte, ResponsableProyecto responsableProyecto) {
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            System.out.println("SUBREPORT_DIR" + JasperReportUtil.PATH);
            //parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            Date fechaDesde= null;
            Date fechaHasta= null;
            for (HorasResponsableProyecto hora : responsableProyecto.getHorasDedicadasList()) {
                if (fechaDesde==null){
                    fechaDesde= hora.getFechaDesde();
                }
                else if (fechaDesde.after(hora.getFechaDesde())){
                    fechaDesde= hora.getFechaDesde();
                }
                if (fechaHasta==null){
                    fechaHasta= hora.getFechaHasta();
                }
                else if(fechaHasta.before(hora.getFechaHasta())){
                    fechaHasta= hora.getFechaHasta();
                }
            }
            String fechaDesdeStr="";
            String fechaHastaStr="";
            if (fechaDesde != null){
                Calendar cal = Calendar.getInstance();
                cal.setTime(fechaDesde);
                fechaDesdeStr = String.valueOf(cal.get(Calendar.DATE)) + " de " + getMesDescripcion(cal.getActualMaximum(Calendar.MONTH)) + " de " + cal.get(Calendar.YEAR);
                cal.setTime(fechaHasta);
                fechaHastaStr = String.valueOf(cal.get(Calendar.DATE)) + " de " + getMesDescripcion(cal.getActualMaximum(Calendar.MONTH)) + " de " + cal.get(Calendar.YEAR);
            }
            NumeroALetras numeroALetras = new NumeroALetras();
            String nroHorasTexto= numeroALetras.convertir(responsableProyecto.getTotalHorasDedicadas().toString(), false);
            
            parametros.put("idParticipante", responsableProyecto.getId());
            parametros.put("fechaDesde", fechaDesdeStr);
            parametros.put("fechaHasta", fechaHastaStr);
            parametros.put("nroHoras", responsableProyecto.getTotalHorasDedicadas());
            parametros.put("nroHorasTexto", nroHorasTexto);
            
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CERTIFICADO_PARTICIPACION_ESTUDIANTE, tipoReporte, null, parametros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     */
    public void imprimirCertificadoParticipacionPDF(ResponsableProyecto responsableProyecto) {
        imprimirCertificadoParticipacion(JasperReportUtil.TIPO_PDF, responsableProyecto);
    }

    public void imprimirCertificadoParticipacionXLS(ResponsableProyecto responsableProyecto) {
        imprimirCertificadoParticipacion(JasperReportUtil.TIPO_XLS, responsableProyecto);
    }

    private void imprimirCertificadoParticipacion(String tipoReporte, ResponsableProyecto responsableProyecto) {
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            System.out.println("SUBREPORT_DIR" + JasperReportUtil.PATH);
            //parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            Date fechaDesde = null;
            Date fechaHasta = null;
            for (HorasResponsableProyecto hora : responsableProyecto.getHorasDedicadasList()) {
                if (fechaDesde == null) {
                    fechaDesde = hora.getFechaDesde();
                } else if (fechaDesde.after(hora.getFechaDesde())) {
                    fechaDesde = hora.getFechaDesde();
                }
                if (fechaHasta == null) {
                    fechaHasta = hora.getFechaHasta();
                } else if (fechaHasta.before(hora.getFechaHasta())) {
                    fechaHasta = hora.getFechaHasta();
                }
            }
            String fechaDesdeStr = "";
            String fechaHastaStr = "";
            SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy", new Locale("ES"));
            if (fechaDesde != null) {
                fechaDesdeStr = formatter.format(fechaDesde);
                fechaHastaStr = formatter.format(fechaHasta);
            }
            NumeroALetras numeroALetras = new NumeroALetras();
            String nroHorasTexto = numeroALetras.convertir(responsableProyecto.getTotalHorasDedicadas().toString(), false);
            String fechaActual = "Sangolquí, " + formatter.format(new Date());
            parametros.put("idParticipante", responsableProyecto.getId());
            parametros.put("fechaDesde", fechaDesdeStr);
            parametros.put("fechaHasta", fechaHastaStr);
            parametros.put("fechaActual", fechaActual);
            parametros.put("nroHoras", responsableProyecto.getTotalHorasDedicadas());
            parametros.put("nroHorasTexto", nroHorasTexto);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);

            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            if (responsableProyecto.getTipoResponsable().getId().equals(TipoResponsable.TIPO_PARTICIPANTE_ESTUDIANTE)) {
                jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CERTIFICADO_PARTICIPACION_ESTUDIANTE, tipoReporte, parametros);
            } else {
                jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CERTIFICADO_PARTICIPACION_DOCENTE, tipoReporte, parametros);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        responsableProyecto.agregarNroCertificadoEntregado();
        responsableProyectoFacade.edit(responsableProyecto);

    }

    private String mensajeConsolidacion1;

    public String getMensajeConsolidacion1() {
        return mensajeConsolidacion1;
    }

    public void setMensajeConsolidacion1(String mensajeConsolidacion1) {
        this.mensajeConsolidacion1 = mensajeConsolidacion1;
    }
    private String mensajeConsolidacion2;

    public String getMensajeConsolidacion2() {
        return mensajeConsolidacion2;
    }

    public void setMensajeConsolidacion2(String mensajeConsolidacion2) {
        this.mensajeConsolidacion2 = mensajeConsolidacion2;
    }
    private String mensajeConsolidacion3;

    public String getMensajeConsolidacion3() {
        return mensajeConsolidacion3;
    }

    public void setMensajeConsolidacion3(String mensajeConsolidacion3) {
        this.mensajeConsolidacion3 = mensajeConsolidacion3;
    }
    private String mensajeCalificacion;

    public String getMensajeCalificacion() {
        return mensajeCalificacion;
    }

    public void setMensajeCalificacion(String mensajeCalificacion) {
        this.mensajeCalificacion = mensajeCalificacion;
    }

    private StreamedContent actaCompromisoParticipacionDirectorProyecto;

    public StreamedContent getActaCompromisoParticipacionDirectorProyecto() {
        return actaCompromisoParticipacionDirectorProyecto;
    }

    public void setActaCompromisoParticipacionDirectorProyecto(StreamedContent actaCompromisoParticipacionDirectorProyecto) {
        this.actaCompromisoParticipacionDirectorProyecto = actaCompromisoParticipacionDirectorProyecto;
    }

    public void subirActaCompromisoParticipacionDirectorProyecto(FileUploadEvent event) {
        try {

            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "actaCompromisoParticipacionDirectorProyecto";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            proyectoSelected.setActaCompromisoDirectorProyectoNombre(event.getFile().getFileName());
            proyectoSelected.setActaCompromisoDirectorProyectoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
            prepararArchivoActaCompromisoParticipacionDirectorProyecto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    public void cancelarActaCompromisoParticipacionDirectorProyecto() throws Exception {
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        prepararArchivoActaCompromisoParticipacionDirectorProyecto();
    }

    private void prepararArchivoActaCompromisoParticipacionDirectorProyecto() throws Exception {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("") + separatorChar + proyectoSelected.getActaCompromisoDirectorProyectoUrlFinal();
        this.actaCompromisoParticipacionDirectorProyecto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", proyectoSelected.getActaCompromisoDirectorProyectoNombre());
    }

    public void registraActaCompromisoParticipacionDirectorProyecto() {
        try {
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarActaCompromisoParticipacionDirectorProyecto();
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void registraActaCompromisoParticipacionCarreras() {
        try {
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarActaCompromisoParticipacionCarreras();
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void cancelarActaCompromisoParticipacionCarreras() throws Exception {
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        prepararArchivoActaCompromisoParticipacionCarreras();
    }

    private void prepararArchivoActaCompromisoParticipacionCarreras() throws Exception {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("") + separatorChar + proyectoSelected.getActaCompromisoCarrerasUrlFinal();
        this.actaCompromisoParticipacionCarreras = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", proyectoSelected.getActaCompromisoCarrerasNombre());
    }
    private StreamedContent actaCompromisoParticipacionCarreras;

    public StreamedContent getActaCompromisoParticipacionCarreras() {
        return actaCompromisoParticipacionCarreras;
    }

    public void setActaCompromisoParticipacionCarreras(StreamedContent actaCompromisoParticipacionCarreras) {
        this.actaCompromisoParticipacionCarreras = actaCompromisoParticipacionCarreras;
    }

    public void subirActaCompromisoParticipacionCarreras(FileUploadEvent event) {
        try {

            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "actaCompromisoCarreras";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            proyectoSelected.setActaCompromisoCarrerasNombre(event.getFile().getFileName());
            proyectoSelected.setActaCompromisoCarrerasUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
            prepararArchivoActaCompromisoParticipacionCarreras();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    private boolean permitirEditarTipoProyecto;

    public boolean isPermitirEditarTipoProyecto() {
        return permitirEditarTipoProyecto;
    }

    public void setPermitirEditarTipoProyecto(boolean permitirEditarTipoProyecto) {
        this.permitirEditarTipoProyecto = permitirEditarTipoProyecto;
    }

    public void subirDocAprobacionVicerrectorado(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "aprobacion_vicerrectorado";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            proyectoSelected.setNombreDocAprobacionVicerrectorado(event.getFile().getFileName());
            proyectoSelected.setUrlDocAprobacionVicerrectorado("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    public void registraCartaCompromisoComunidad() {
        try {
            proyectoFacade.edit(proyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            cancelarCartaCompromisoComunidad();
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void cancelarCartaCompromisoComunidad() throws Exception {
        modoEdicion = false;
        proyectoSelected = proyectoFacade.find(proyectoSelected.getId());
        prepararArchivoCartaCompromisoComunidad();
    }

    private void prepararArchivoCartaCompromisoComunidad() throws Exception {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("") + separatorChar + proyectoSelected.getCartaCompromisoComunidadUrlFinal();
        this.cartaCompromisoComunidad = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", proyectoSelected.getCartaCompromisoComunidadNombre());
    }

    private StreamedContent cartaCompromisoComunidad;

    public StreamedContent getCartaCompromisoComunidad() {
        return cartaCompromisoComunidad;
    }

    public void setCartaCompromisoComunidad(StreamedContent cartaCompromisoComunidad) {
        this.cartaCompromisoComunidad = cartaCompromisoComunidad;
    }

    public void subirCartaCompromisoComunidad(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "cartaCompromisoComunidad";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + proyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            proyectoSelected.setCartaCompromisoComunidadNombre(event.getFile().getFileName());
            proyectoSelected.setCartaCompromisoComunidadUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + proyectoSelected.getId() + "/");
            prepararArchivoCartaCompromisoComunidad();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }
    }

    private boolean msgCierreBeneficiarios;
    private boolean msgCierreObjetivos;
    private boolean msgCierrePresupuesto;
    private boolean msgCierreResultados;

    public boolean isMsgCierreBeneficiarios() {
        return msgCierreBeneficiarios;
    }

    public void setMsgCierreBeneficiarios(boolean msgCierreBeneficiarios) {
        this.msgCierreBeneficiarios = msgCierreBeneficiarios;
    }

    public boolean isMsgCierreObjetivos() {
        return msgCierreObjetivos;
    }

    public void setMsgCierreObjetivos(boolean msgCierreObjetivos) {
        this.msgCierreObjetivos = msgCierreObjetivos;
    }

    public boolean isMsgCierrePresupuesto() {
        return msgCierrePresupuesto;
    }

    public void setMsgCierrePresupuesto(boolean msgCierrePresupuesto) {
        this.msgCierrePresupuesto = msgCierrePresupuesto;
    }

    public boolean isMsgCierreResultados() {
        return msgCierreResultados;
    }

    public void setMsgCierreResultados(boolean msgCierreResultados) {
        this.msgCierreResultados = msgCierreResultados;
    }

    private boolean msgEvaluacionFinal;

    public boolean isMsgEvaluacionFinal() {
        return msgEvaluacionFinal;
    }

    public void setMsgEvaluacionFinal(boolean msgEvaluacionFinal) {
        this.msgEvaluacionFinal = msgEvaluacionFinal;
    }

    private String mensajeFechaMaximaCorreccion;

    public String getMensajeFechaMaximaCorreccion() {
        return mensajeFechaMaximaCorreccion;
    }

    public void setMensajeFechaMaximaCorreccion(String mensajeFechaMaximaCorreccion) {
        this.mensajeFechaMaximaCorreccion = mensajeFechaMaximaCorreccion;
    }

    /*public boolean verificarEvaluadorComision() {
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION)
                && proyectoSelected.getComisionCalificacion() != null) {
            for (MiembroComisionCalificacion m : proyectoSelected.getComisionCalificacion().getMiembroActivoList()) {
                if (m.getUsuario().equals(usuarioActual)) {
                    return true;
                }
            }
        }
        return false;
    }*/
    private MiembroComisionCalificacion verificarMiembroComision() {
        if (proyectoSelected.getComisionCalificacion() != null) {
            for (MiembroComisionCalificacion m : proyectoSelected.getComisionCalificacion().getMiembroActivoList()) {
                if (m.getUsuario().getUsuId().equals(usuarioActual.getUsuId())) {
                    return m;
                }
            }
        }
        return null;
    }

    public boolean isVerificarPerfilAdministrador() {
        return (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION));
    }

    public boolean isPermitirEditarPerfil() {
        if (isVerificarPerfilAdministrador()) {
            return true;
        }
        if (!verificarDirectorProyecto()) {
            return false;
        }
        if (!(proyectoSelected.isEstadoIngresoPerfil() || proyectoSelected.isEstadoEnviadoRevision())) {
            return false;
        }
        Calendar calFechaMaxima = null;
        if (proyectoSelected.getFechaMaximaCorreccion() != null) {
            calFechaMaxima = Calendar.getInstance();
            calFechaMaxima.setTime(proyectoSelected.getFechaMaximaCorreccion());
            calFechaMaxima.set(Calendar.HOUR_OF_DAY, 23);
            calFechaMaxima.set(Calendar.MINUTE, 59);
            calFechaMaxima.set(Calendar.SECOND, 59);
        }
        if (proyectoSelected.isEstadoEnviadoRevision() && calFechaMaxima != null && calFechaMaxima.getTime().before(new Date())) {
            return false;
        }
        if ((proyectoSelected.isEstadoIngresoPerfil() || proyectoSelected.isEstadoEnviadoRevision())
                && verificarDirectorProyecto()) {
            return true;
        }
        return false;
    }

    public boolean isPermitirEditarPerfilTemp() {
        if (isVerificarPerfilAdministrador()) {
            return true;
        }
        return (verificarDirectorProyecto());
    }

    public boolean isPermitirEliminarProyecto() {
        if (proyectoSelected.getId() != null) {
            if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)) {
                return true;
            }
            return (isPermitirEditarPerfil());
        }
        return false;
    }

    public boolean isPermitirAsignacionComisionCalificacion() {
        //disabled="#{proyectoController.proyectoSelected.calificacionList!=null and proyectoController.proyectoSelected.calificacionList.size()>0}"
        return ((proyectoSelected.getCalificacionList() == null || proyectoSelected.getCalificacionList().isEmpty())
                && isVerificarPerfilAdministrador());
    }

    public boolean isPermitirCalificacionComision() {
        //disabled="#{proyectoController.mensajeCalificacion!='' || proyectoController.proyectoSelected.estado!='CEP' || (proyectoController.proyectoSelected.calificacionActualXUsuario!=null and proyectoController.proyectoSelected.calificacionActualXUsuario.estadoFinalizado!=null and proyectoController.proyectoSelected.calificacionActualXUsuario.estadoFinalizado=='S')}"
        if (!mensajeCalificacion.isEmpty() || !proyectoSelected.isEstadoEnCalificacionComision()) {
            return false;
        }
        if (proyectoSelected.getCalificacionActualXUsuario() != null
                && proyectoSelected.getCalificacionActualXUsuario().getEstadoFinalizado() != null
                && proyectoSelected.getCalificacionActualXUsuario().getEstadoFinalizado().equals(CalificacionProyecto.ESTADO_FINALIZADO_SI)) {
            return false;
        }
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION) && verificarMiembroComision() != null) {
            return true;
        }
        return false;
    }

    public boolean isPermitirFinalizarCalificacionComision() {
        //disabled="#{proyectoController.mensajeCalificacion!='' || !proyectoController.permitirFinalizarCalificacion}"
        if (!mensajeCalificacion.isEmpty() || !proyectoSelected.isEstadoEnCalificacionComision()) {
            return false;
        }
        CalificacionProyecto cal = proyectoSelected.getCalificacionActualXUsuario();
        if (!proyectoSelected.isEstadoEnCalificacionComision() || cal == null) {
            return false;
        } else if (cal.getEstadoFinalizado() != null && cal.getEstadoFinalizado().equals(CalificacionProyecto.ESTADO_FINALIZADO_SI)) {
            return false;
        } else if (proyectoSelected.getFechaFinalizacionPerfil() != null && cal.getFecha() != null && proyectoSelected.getFechaFinalizacionPerfil().after(cal.getFecha())) {
            return false;
        }
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION) && verificarMiembroComision() != null) {
            return true;
        }
        return false;
    }

    public boolean isPermitirConsolidacionCalificacionComision() {
        if (!isVerificarPerfilAdministrador()) {
            return false;
        }

        if ((mensajeConsolidacion1 != null && !mensajeConsolidacion1.isEmpty())
                || (mensajeConsolidacion2 != null && !mensajeConsolidacion2.isEmpty())) {
            return false;
        }
        if (!proyectoSelected.isEstadoEnConsolidacionCalificacionComision() && !proyectoSelected.isEstadoEnviadoRevision()) {
            return false;
        }
        return true;
    }

    public boolean isPermitirFinalizarConsolidacionCalificacion() {
        if (!isVerificarPerfilAdministrador()
                || proyectoSelected.getCalificacionList() == null
                || proyectoSelected.getCalificacionList().isEmpty()
                || !proyectoSelected.isEstadoEnConsolidacionCalificacionComision()
                || pendienteConsolidar) {
            return false;
        }
        return true;
    }

    public boolean isPermitirActaAprobacionVicerrectorado() {
        return isVerificarPerfilAdministrador();
    }

    public boolean isPermitirAprobacionConsejoAcademico() {
        //return (proyectoSelected.isEstadoAprobacionConsejoAcademico() && isVerificarPerfilAdministrador());
        return (isVerificarPerfilAdministrador()
                && (proyectoSelected.isEstadoAprobacionConsejoAcademico()
                || proyectoSelected.isEstadoNoAprobadoConsejoAcademico()
                || proyectoSelected.isEstadoEjecucion()
                || proyectoSelected.isEstadoCierre()
                || proyectoSelected.isEstadoEvaluacionFinal()
                || proyectoSelected.isEstadoFinalizado()));
    }

    public boolean isPermitirEjecucion() {
        return proyectoSelected.isEstadoEjecucion()
                && verificarDirectorProyecto();
    }

    public boolean isPermitirCierre() {
        return proyectoSelected.isEstadoCierre()
                && verificarDirectorProyecto();

    }

    public boolean isPermitirDesignarEvaluadorFinal() {
        //disabled="#{proyectoController.proyectoSelected.mensajePermitirEvaluacionFinal!='' or !proyectoController.verificarPerfilAdministrador}"
        return (proyectoSelected.getMensajePermitirEvaluacionFinal().isEmpty() && isVerificarPerfilAdministrador());
    }

    public boolean isPermitirEvaluacionFinal() {
        //disabled="#{proyectoController.proyectoSelected.mensajePermitirEvaluacionFinal!='' or proyectoController.proyectoSelected.estado=='EVA' or !proyectoController.verificarPerfilAdministrador}" 
        if (!proyectoSelected.getMensajePermitirEvaluacionFinal().isEmpty()
                || !proyectoSelected.isEstadoEvaluacionFinal()) {
            return false;
        }
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)
                && proyectoSelected.getEvaluadorFinal() != null
                && proyectoSelected.getEvaluadorFinal().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    public boolean isPermitirFinalizarEvaluacionFinal() {
        //disabled="#{proyectoController.proyectoSelected.mensajePermitirFinalizarEvaluacionFinal!='' or proyectoController.proyectoSelected.estado=='EVA' or !proyectoController.verificarPerfilAdministrador}"
        if (!proyectoSelected.getMensajePermitirFinalizarEvaluacionFinal().isEmpty()
                || !proyectoSelected.isEstadoEvaluacionFinal()) {
            return false;
        }
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)
                && proyectoSelected.getEvaluadorFinal() != null
                && proyectoSelected.getEvaluadorFinal().getUsuario().equals(usuarioActual)) {
            return true;
        }
        return false;
    }

    /*private void verificarCalificacion() {
        permitirEditarCalificacion = true;
        CalificacionProyecto cal = proyectoSelected.getCalificacionActualXUsuario();
        if (cal == null) {
            permitirEditarCalificacion = false;
        } else if (proyectoSelected.getFechaFinalizacionPerfil() != null && cal.getFecha() != null && proyectoSelected.getFechaFinalizacionPerfil().after(cal.getFecha())) {
            permitirEditarCalificacion = false;
        }

        permitirFinalizarCalificacion = true;
        if (!proyectoSelected.getEstado().equals(Proyecto.ESTADO_CERRADO_PERFIL) || cal == null) {
            permitirFinalizarCalificacion = false;
        } else if (cal.getEstadoFinalizado() != null && cal.getEstadoFinalizado().equals(CalificacionProyecto.ESTADO_FINALIZADO_SI)) {
            permitirFinalizarCalificacion = false;
        } else if (proyectoSelected.getFechaFinalizacionPerfil() != null && cal.getFecha() != null && proyectoSelected.getFechaFinalizacionPerfil().after(cal.getFecha())) {
            permitirFinalizarCalificacion = false;
        }

    }*/
    //private boolean permitirEditarCalificacion;
    //private boolean permitirFinalizarCalificacion;
    /*public void setPermitirFinalizarCalificacion(boolean permitirFinalizarCalificacion) {
        this.permitirFinalizarCalificacion = permitirFinalizarCalificacion;
    }*/
    public boolean isEdicionCalificacion() {
        //return permitirEditarCalificacion;
        CalificacionProyecto cal = proyectoSelected.getCalificacionActualXUsuario();
        if (cal == null) {
            return false;
        } else if (proyectoSelected.getFechaFinalizacionPerfil() != null && cal.getFecha() != null && proyectoSelected.getFechaFinalizacionPerfil().after(cal.getFecha())) {
            return false;
        }
        return true;
    }

    public List<SeaParametrosDet> getCoberturaList() {
        return coberturaList;
    }

    public void setCoberturaList(List<SeaParametrosDet> coberturaList) {
        this.coberturaList = coberturaList;
    }

    public void seleccionarTipoProyecto() {
        if (!proyectoSelected.getTipo().equals(tipoProyecto) && proyectoSelected.getTipo().equals(Proyecto.TIPO_GASTO_NO_PERMANENTE)) {
            proyectoSelected.setConvocatoria(convocatoriaFacade.findByActiva());
        }
    }
    public boolean isPermitirImprimirCertificados() {
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_IMPRESION_CERTIFICADOS)) {
            return true;
        }
        return false;
    }
    
    private List<ActaDesignacionResponsable> actaDesignacionResponsableList;

    public List<ActaDesignacionResponsable> getActaDesignacionResponsableList() {
        return actaDesignacionResponsableList;
    }

    public void setActaDesignacionResponsableList(List<ActaDesignacionResponsable> actaDesignacionResponsableList) {
        this.actaDesignacionResponsableList = actaDesignacionResponsableList;
    }

    
    public void generarReporteCronogramaPDF() {
        generarReporteCronograma(JasperReportUtil.TIPO_PDF);

    }
    private void generarReporteCronograma(String tipoReporte) {
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            System.out.println("SUBREPORT_DIR" + JasperReportUtil.PATH);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            parametros.put("idProyecto", proyectoSelected.getId());
            parametros.put("nomProyecto", proyectoSelected.getNombre());
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_CRONOGRAMA, tipoReporte, parametros);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void prepararDownloadDocCompromisoParticipacion(DocumentoCompromisoParticipacion documento) {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + documento.getDocumentoUrlFinal();
            this.archivoAdjunto = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", documento.getDocumentoNombre());
        } catch (Exception e) {

        }
    }
    
    private DocumentoCompromisoParticipacion documentoCompromisoParticipacionSelected;

    public DocumentoCompromisoParticipacion getDocumentoCompromisoParticipacionSelected() {
        return documentoCompromisoParticipacionSelected;
    }

    public void setDocumentoCompromisoParticipacionSelected(DocumentoCompromisoParticipacion documentoCompromisoParticipacionSelected) {
        this.documentoCompromisoParticipacionSelected = documentoCompromisoParticipacionSelected;
    }
    
    public void nuevoDocumentoCompromisoParticipacion(){
        documentoCompromisoParticipacionSelected = new DocumentoCompromisoParticipacion();
    }
    public void grabarDocumentoCompromisoParticipacion() {
        try {
            if (documentoCompromisoParticipacionSelected.getId() == null) {
                documentoCompromisoParticipacionSelected.setCompromisoParticipacion(compromisoParticipacionProyectoSelected);
                compromisoParticipacionProyectoSelected.addDocumento(documentoCompromisoParticipacionSelected);
                compromisoParticipacionProyectoFacade.edit(compromisoParticipacionProyectoSelected);
            } else {
                compromisoParticipacionProyectoFacade.edit(compromisoParticipacionProyectoSelected);
            }
            cancelarCompromisoParticipacionProyecto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada: " + e.getMessage();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }    
    public void subirDocumentoCompromisoParticipacion(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "compromiso_participacion";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + compromisoParticipacionProyectoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            documentoCompromisoParticipacionSelected.setDocumentoNombre(event.getFile().getFileName());
            documentoCompromisoParticipacionSelected.setDocumentoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + compromisoParticipacionProyectoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }

        
    }
    public void eliminarDocumentoCompromisoParticipacion(DocumentoCompromisoParticipacion documento) {
        try {
            compromisoParticipacionProyectoSelected.getDocumentoList().remove(documento);
            compromisoParticipacionProyectoFacade.edit(compromisoParticipacionProyectoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarCompromisoParticipacionProyecto();
        }
    }

    
    //disabled="#{!proyectoController.permitirEjecucion || docentePar.actaDesignacionResponsable!=null}"
    public boolean isPermitirEliminarDocente(){
        if (isVerificarPerfilAdministrador()){
            return true;
        }
        return isPermitirEjecucion();
    }
}
