/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvterm;
import ec.edu.espe_ctt.saturno.session.StvmajrFacade;
import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt.vinculacion.entity.ComisionCalificacion;
import ec.edu.espe_ctt.vinculacion.entity.ConfiguracionParametrosEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.MiembroComisionCalificacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera;
import ec.edu.espe_ctt.vinculacion.entity.PartidaPresupuestaria;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.session.ComisionCalificacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionParametrosEvaluacionFacade;
import ec.edu.espe_ctt.vinculacion.session.MiembroComisionCalificacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ParametroEvaluacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ParametroEvaluacionFinalCabeceraFacade;
import ec.edu.espe_ctt.vinculacion.session.PartidaPresupuestariaFacade;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ValoracionParametroEvaluacionFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.session.SeaClasificadorPresupFacade;
import ec.edu.espe_ctt.vinculacion.entity.AspectoEvaluacionFinal;
import ec.edu.espe_ctt.vinculacion.entity.Configuracion;
import ec.edu.espe_ctt.vinculacion.entity.CoordinadorVinculacion;
import ec.edu.espe_ctt.vinculacion.entity.Institucion;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivir;
import ec.edu.espe_ctt.vinculacion.entity.PlanNacional;
import ec.edu.espe_ctt.vinculacion.entity.VDirectorDepartamento;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionFacade;
import ec.edu.espe_ctt.vinculacion.session.CoordinadorVinculacionFacade;
import ec.edu.espe_ctt.vinculacion.session.InstitucionFacade;
import ec.edu.espe_ctt.vinculacion.session.ObjetivoBVivirFacade;
import ec.edu.espe_ctt.vinculacion.session.PlanNacionalFacade;
import ec.edu.espe_ctt.vinculacion.session.VDirectorDepartamentoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProvinciaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.Visibility;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ConfiguracionesController implements Serializable {

    @EJB
    private SeaParametrosDetFacade catalogoItemFacade;
    @EJB
    private ParametroEvaluacionFacade parametroEvaluacionFacade;
    @EJB
    private ValoracionParametroEvaluacionFacade valoracionParametroEvaluacionFacade;
    @EJB
    private ComisionCalificacionFacade comisionCalificacionFacade;
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;
    @EJB
    private SegUsuarioFacade usuarioFacade;
    @EJB
    private ConfiguracionParametrosEvaluacionFacade configuracionParametrosEvaluacionFacade;
    @EJB
    private StvmajrFacade carreraFacade;

    private TreeNode opcionesMenu;
    private ParametroEvaluacion parametroEvaluacionSelected;
    private TreeNode opcionMenuSelected;
    private ValoracionParametroEvaluacion valoracionParametroEvaluacionSelected;
    private SegUsuario usuarioActual;
    private List<SegPerfil> perfilUsuarioActual;
    private List<Stvmajr> carreraList;
    private List<SeaParametros> catalogoList;

    private SeaParametros catalogoSelected;

    public ConfiguracionesController() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        perfilUsuarioActual = (List<SegPerfil>) context.getExternalContext().getSessionMap().get("usu_perfil");

        catalogoList = new ArrayList<>();
        catalogoList.add(new SeaParametros(SeaParametros.PARAM_ESTADO_PROYECTO_VINCULACION, "Estado Proyecto", null));
        catalogoList.add(new SeaParametros(SeaParametros.PARAM_COBERTURA, "Cobertura Proyecto", null));

        inicializarOpcionesMenu();
        initConfiguracionParametrosEvaluacion();
    }

    public ParametroEvaluacion getParametroEvaluacionSelected() {
        return parametroEvaluacionSelected;
    }

    public void setParametroEvaluacionSelected(ParametroEvaluacion parametroEvaluacionSelected) {
        this.parametroEvaluacionSelected = parametroEvaluacionSelected;
    }

    public TreeNode getOpcionesMenu() {
        return opcionesMenu;
    }

    public void setOpcionesMenu(TreeNode opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }

    public TreeNode getOpcionMenuSelected() {
        return opcionMenuSelected;
    }

    public void setOpcionMenuSelected(TreeNode opcionMenuSelected) {
        this.opcionMenuSelected = opcionMenuSelected;
    }

    public void onMenuSelect(NodeSelectEvent event) {
        OpcionMenu opcionMenu = (OpcionMenu) opcionMenuSelected.getData();
        switch (opcionMenu.getCodigo()) {
            case "1":
                initConfiguracionParametrosEvaluacion();
                break;
            case "2":
                cancelarEdicionComisionCalificacion(true);
                break;
            case "3":
                initPartidaPresupuestaria();
                break;
            case "4":
                initConfiguracionParametrosEvaluacionFinal();
                break;
            case "5":
                initInstitucion();
                break;
            case "6":
                initCoordinadorVinculacion();
                break;
            case "7":
                cancelarConfiguracion();
                break;
            case "8":
                cancelarConfiguracion();
                break;
            case "9":
                cancelarConfiguracion();
                break;
            case "10":
                cancelarConfiguracion();
                break;
            case "11":
                initCatalogoPartidaPresupuestaria();
                break;
            case "12":
                initCatalogosGenerales();
                break;
            case "13":
                initConfiguracionPlanNacional();
                break;

        }

    }

    public String getOpcionMenuCodeSelected() {
        if (opcionMenuSelected != null) {
            return ((OpcionMenu) opcionMenuSelected.getData()).getCodigo();
        } else {
            return "";
        }
    }

    public String nuevoParametroEvaluacion() {
        opcionMenuParametroSelected = null;
        if (!verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId())) {
            configuracionParametrosEvaluacionSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
        } else {
            parametroEvaluacionSelected = new ParametroEvaluacion();
            RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescripcionParamEvaluacion').focus();");
        }
        return "";
    }

    public String grabarParametroEvaluacion() {
        try {
            parametroEvaluacionSelected.setOpcionMenu(opcionMenuParametroSelected.getCodigo());
            if (parametroEvaluacionSelected.getId() == null) {
                parametroEvaluacionSelected.setConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected);
                parametroEvaluacionSelected.setOrden(configuracionParametrosEvaluacionSelected.getParametroEvaluacionList().size() + 1);
                parametroEvaluacionFacade.create(parametroEvaluacionSelected);
            } else {
                parametroEvaluacionFacade.edit(parametroEvaluacionSelected);
            }
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void initConfiguracionParametrosEvaluacion() {
        if (expandedParametroEvaluacion == null) {
            expandedParametroEvaluacion = new HashMap<>();
        } else {
            expandedParametroEvaluacion.clear();
        }
        if (expandedConfigParametroEvaluacion == null) {
            expandedConfigParametroEvaluacion = new HashMap<>();
        } else {
            expandedConfigParametroEvaluacion.clear();;
        }

        llenarOpcionesMenuParametro();
        cancelarEdicionConfiguracionParametrosEvaluacion(true);
        for (ConfiguracionParametrosEvaluacion conf : configuracionParametrosEvaluacionList) {
            expandedConfigParametroEvaluacion.put(conf.getId(), conf.isExpanded());
            for (ParametroEvaluacion parametroEvaluacion : conf.getParametroEvaluacionList()) {
                expandedParametroEvaluacion.put(parametroEvaluacion.getId(), parametroEvaluacion.isExpanded());
            }
        }
    }
    
    
    //Autor: Jhonny Jami, Descripcion: Funciones de Configuracion PlanNacional
    @EJB
    private PlanNacionalFacade configuracionPlanNacionalFacade;
    @EJB
    private ObjetivoBVivirFacade objetivoBVivirFacade;
    private List<PlanNacional> configuracionPlanNacionalList;
    private PlanNacional configuracionPlanNacionalSelected;
    private ObjetivoBVivir objetivoPlanNacionalSelected, politicaPlanNacionalSelected;
    private Map<Integer, Boolean> expandedConfigPlanNacional = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> expandedObjetivoPlanNacional = new HashMap<Integer, Boolean>();
    private boolean permitirEdicionConfigPlanNacional, estadoActivoConfiguracionPlanNacional;
    
    public void initConfiguracionPlanNacional(){
        if(expandedObjetivoPlanNacional == null){
            expandedObjetivoPlanNacional = new HashMap<>();
            
        }else{
            expandedObjetivoPlanNacional.clear();
        }
        if(expandedConfigPlanNacional == null){
            expandedConfigPlanNacional = new HashMap<>();
        }else{
            expandedConfigPlanNacional.clear();
        }
        
        cancelarEdicionConfiguracionPlanNacional(true);
        for (PlanNacional conf : configuracionPlanNacionalList) {
            expandedConfigPlanNacional.put(conf.getId(), conf.isExpanded());
            for (ObjetivoBVivir objetivo : conf.getObjetivoBVivirList()) {
                expandedObjetivoPlanNacional.put(objetivo.getSvobviId().intValue(), objetivo.isExpanded());
            }
        }
        
    }
   
    public void cancelarEdicionConfiguracionPlanNacional(boolean ocultarPanelEdicion){
        if(ocultarPanelEdicion){
            configuracionPlanNacionalSelected = null;
            objetivoPlanNacionalSelected = null;
            politicaPlanNacionalSelected = null;
        }
        configuracionPlanNacionalList = configuracionPlanNacionalFacade.findAll();
        Collections.sort(configuracionPlanNacionalList);
        setExpandedConfigPlanNacional();
    }
    
    public void onRowTooglePlanNacional(ToggleEvent event){
        PlanNacional planNacional = (PlanNacional) event.getData();
        expandedConfigPlanNacional.put(planNacional.getId(),event.getVisibility() == Visibility.VISIBLE);
    }      
       
    public void seleccionarEditarConfigPlanNacional(){
        try{
            permitirEdicionConfigPlanNacional = true;
            if(configuracionPlanNacionalSelected.getEstado() != null && configuracionPlanNacionalSelected.getEstado().equals(PlanNacional.ESTADO_ACTIVA)){
                estadoActivoConfiguracionPlanNacional = true;
            }else{
                estadoActivoConfiguracionPlanNacional = false;
            }
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
        
    }
       
    private boolean verificarEdicionConfiguracionPlanNacional(Integer idPlanNacional){
        return (configuracionPlanNacionalFacade.verificarPermitiriEdicionPlanNacional(idPlanNacional));
    }
    
     public void eliminarConfigPlanNacional() {
        try {
            if (!verificarEdicionConfiguracionPlanNacional(configuracionPlanNacionalSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigPlanNacional", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen proyectos realizadas con esta configuracion"));
            } else {
                configuracionPlanNacionalFacade.remove(configuracionPlanNacionalSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionPlanNacional(true);
        }
    }
     
    public String nuevoObjetivoPlanNacional() {
        //opcionMenuParametroSelected = null;
        if (!verificarEdicionConfiguracionPlanNacional(configuracionPlanNacionalSelected.getId())) {
            configuracionPlanNacionalSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigPlanNacional", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen Proyectos realizadas con esta configuración Plan Nacional"));
        } else {
            objetivoPlanNacionalSelected = new ObjetivoBVivir();
            RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescObjetivoPlanNacional').focus();");
        }
        return "";
    }
     
     public void onRowToggleObjetivoPlanNacional(ToggleEvent event) {
        ObjetivoBVivir objetivoBVivir = (ObjetivoBVivir) event.getData();
        expandedParametroEvaluacion.put(objetivoBVivir.getSvobviId().intValue(), event.getVisibility() == Visibility.VISIBLE);
    }
     
    public String cambiarOrdenObjetivoPlanNacional(ObjetivoBVivir objetivoBVivir, Integer cambio) {
        try {
            objetivoBVivir.cambiarOrden(cambio);
            configuracionPlanNacionalFacade.edit(objetivoBVivir.getConfiguracionPlanNacional());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }

        return "";
    }
    
    public void seleccionarEditarObjetivoPlanNacional() {
        try {
            if (!verificarEdicionConfiguracionPlanNacional(objetivoPlanNacionalSelected.getConfiguracionPlanNacional().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigPlanNacional", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionPlanNacional(true);
            } else {
//                //opcionMenuParametroSelected = null;
//                for (OpcionMenu op : opcionesMenuParametroList) {
//                    if (op.getCodigo().equals(parametroEvaluacionSelected.getOpcionMenu())) {
//                        opcionMenuParametroSelected = op;
//                        break;
//                    }
//                }
                //RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescripcionParamEvaluacion').focus();");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }
    
    public void eliminarObjetivoPlanNacional() {
        try {
            if (!verificarEdicionConfiguracionPlanNacional(configuracionPlanNacionalSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigPlanNacional", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen proyectos realizadas con esta configuraciónn Plan Nacional"));
            } else {
                configuracionPlanNacionalSelected.removeObjetivoPlanNacional(objetivoPlanNacionalSelected);
                configuracionPlanNacionalFacade.edit(configuracionPlanNacionalSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionPlanNacional(true);
        }
    }
    
    public String nuevoPoliticaPlanNacional() {
        if (!verificarEdicionConfiguracionPlanNacional(objetivoPlanNacionalSelected.getConfiguracionPlanNacional().getId())) {
            objetivoPlanNacionalSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigPlanNacional", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen proyectos realizadas con esta configuración Plan Nacional"));
        } else {
            politicaPlanNacionalSelected = new ObjetivoBVivir();
        }
        return "";
    }
    
    public String cambiarOrdenPoliticaPlanNacional(ObjetivoBVivir politicaPlanNacional, Integer cambio) {
        try {
            politicaPlanNacional.cambiarOrden(cambio);
            objetivoBVivirFacade.edit(politicaPlanNacional);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }

        return "";
    }
    
    public void seleccionarEditarPoliticaPlanNacional(){
        try {
            if (!verificarEdicionConfiguracionPlanNacional(politicaPlanNacionalSelected.getConfiguracionPlanNacional().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigPlanNacional", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen proyectos realizadas con esta configuración Plan Nacional"));
                cancelarEdicionConfiguracionPlanNacional(true);
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionPlanNacional(true);
        }
    }
    
    public void eliminarPoliticaPlanNacional() {
        try {
            if (!verificarEdicionConfiguracionPlanNacional(objetivoPlanNacionalSelected.getConfiguracionPlanNacional().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigPlanNacional", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                objetivoPlanNacionalSelected.removePolitica(politicaPlanNacionalSelected);
                objetivoBVivirFacade.edit(objetivoPlanNacionalSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionPlanNacional(true);
        }
    }
    
    public String nuevoConfiguracionPlanNacional() {
        permitirEdicionConfigPlanNacional = true;
        estadoActivoConfiguracionPlanNacional = false;
        configuracionPlanNacionalSelected = new PlanNacional();
        //configuracionPlanNacionalSelected.setTipo(ConfiguracionParametrosEvaluacion.TIPO_EVALUACION_INICIAL);
        return "";
    }
    
    public String grabarConfiguracionPlanNacional() {
        try {
            boolean actualizarEstado = false;
            if (estadoActivoConfiguracionPlanNacional) {
                if (configuracionPlanNacionalSelected.getId() != null && (configuracionPlanNacionalSelected.getEstado() == null || configuracionPlanNacionalSelected.getEstado().equals(PlanNacional.ESTADO_INACTIVA))) {
                    actualizarEstado = true;
                }
                configuracionPlanNacionalSelected.setEstado(PlanNacional.ESTADO_ACTIVA);
            } else {
                configuracionPlanNacionalSelected.setEstado(PlanNacional.ESTADO_INACTIVA);
            }
            if (configuracionPlanNacionalSelected.getId() == null) {
                configuracionPlanNacionalFacade.create(configuracionPlanNacionalSelected);
            } else {
                configuracionPlanNacionalFacade.edit(configuracionPlanNacionalSelected, actualizarEstado);
            }
            cancelarEdicionConfiguracionPlanNacional(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionPlanNacional(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }
    
    public String grabarObjetivoPlanNacional() {
        try {
            //parametroEvaluacionSelected.setOpcionMenu(opcionMenuParametroSelected.getCodigo());
            if (objetivoPlanNacionalSelected.getSvobviId() == null) {
                objetivoPlanNacionalSelected.setConfiguracionPlanNacional(configuracionPlanNacionalSelected);
                objetivoPlanNacionalSelected.setOrden(configuracionPlanNacionalSelected.getObjetivoBVivirList().size() + 1);
                objetivoBVivirFacade.create(objetivoPlanNacionalSelected);
            } else {
                objetivoBVivirFacade.edit(objetivoPlanNacionalSelected);
            }
            cancelarEdicionConfiguracionPlanNacional(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionPlanNacional(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }   
    
     public String grabarPoliticaPlanNacional() {
        try {
            if (politicaPlanNacionalSelected.getSvobviId() == null) {
                politicaPlanNacionalSelected.setSvobviIdPadre(objetivoPlanNacionalSelected);
                politicaPlanNacionalSelected.setOrden(objetivoPlanNacionalSelected.getSvinObjetivoBVivirCollection().size() + 1);
                objetivoBVivirFacade.create(politicaPlanNacionalSelected);
            } else {
                objetivoBVivirFacade.edit(politicaPlanNacionalSelected);
            }
            cancelarEdicionConfiguracionPlanNacional(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionPlanNacional(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }
    
    public boolean isPermitirEdicionConfigPlanNacional() {
        return permitirEdicionConfigPlanNacional;
    }

    public void setPermitirEdicionConfigPlanNacional(boolean permitirEdicionConfigPlanNacional) {
        this.permitirEdicionConfigPlanNacional = permitirEdicionConfigPlanNacional;
    }

    public boolean isEstadoActivoConfiguracionPlanNacional() {
        return estadoActivoConfiguracionPlanNacional;
    }

    public void setEstadoActivoConfiguracionPlanNacional(boolean estadoActivoConfiguracionPlanNacional) {
        this.estadoActivoConfiguracionPlanNacional = estadoActivoConfiguracionPlanNacional;
    }
     
    public Map<Integer, Boolean> getExpandedConfigPlanNacional() {
        return expandedConfigPlanNacional;
    }

    public void setExpandedConfigPlanNacional(Map<Integer, Boolean> expandedConfigPlanNacional) {
        this.expandedConfigPlanNacional = expandedConfigPlanNacional;
    }

    private void setExpandedConfigPlanNacional() {
        for (PlanNacional conf : configuracionPlanNacionalList) {
            
            Boolean expandedConf = (expandedConfigPlanNacional.get(conf.getId()) != null) ? expandedConfigPlanNacional.get(conf.getId()) : false;
            conf.setExpanded(expandedConf);

            for (ObjetivoBVivir objetivo : conf.getObjetivoBVivirList()) {
                Boolean expanded = (expandedObjetivoPlanNacional.get(objetivo.getSvobviId().intValue()) != null) ? expandedObjetivoPlanNacional.get(objetivo.getSvobviId().intValue()) : false;
                objetivo.setExpanded(expanded);
            }
        }
    }
    
    public Map<Integer, Boolean> getExpandedObjetivoPlanNacional() {
        return expandedObjetivoPlanNacional;
    }

    public void setExpandedObjetivoPlanNacional(Map<Integer, Boolean> expandedObjetivoPlanNacional) {
        this.expandedObjetivoPlanNacional = expandedObjetivoPlanNacional;
    }

    public List<PlanNacional> getConfiguracionPlanNacionalList() {
        return configuracionPlanNacionalList;
    }

    public void setConfiguracionPlanNacionalList(List<PlanNacional> configuracionPlanNacionalList) {
        this.configuracionPlanNacionalList = configuracionPlanNacionalList;
    }

    public PlanNacional getConfiguracionPlanNacionalSelected() {
        return configuracionPlanNacionalSelected;
    }

    public void setConfiguracionPlanNacionalSelected(PlanNacional configuracionPlanNacionalSelected) {
        this.configuracionPlanNacionalSelected = configuracionPlanNacionalSelected;
    }

    public ObjetivoBVivir getObjetivoPlanNacionalSelected() {
        return objetivoPlanNacionalSelected;
    }

    public void setObjetivoPlanNacionalSelected(ObjetivoBVivir objetivoPlanNacionalSelected) {
        this.objetivoPlanNacionalSelected = objetivoPlanNacionalSelected;
    }

    public ObjetivoBVivir getPoliticaPlanNacionalSelected() {
        return politicaPlanNacionalSelected;
    }

    public void setPoliticaPlanNacionalSelected(ObjetivoBVivir politicaPlanNacionalSelected) {
        this.politicaPlanNacionalSelected = politicaPlanNacionalSelected;
    }
    
    ////----Fin Funciones de Configuracion PlanNacional
    
    public String cambiarOrdenValoracionParametroEvaluacion(ValoracionParametroEvaluacion valoracionParametroEvaluacion, Integer cambio) {
        try {
            valoracionParametroEvaluacion.cambiarOrden(cambio);
            parametroEvaluacionFacade.edit(valoracionParametroEvaluacion.getParametroEvaluacion());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }

        return "";
    }

    public String cambiarOrdenParametroEvaluacion(ParametroEvaluacion parametroEvaluacion, Integer cambio) {
        try {
            parametroEvaluacion.cambiarOrden(cambio);
            configuracionParametrosEvaluacionFacade.edit(parametroEvaluacion.getConfiguracionParametrosEvaluacion());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }

        return "";
    }

    public void inicializarOpcionesMenu() {
        opcionesMenu = new DefaultTreeNode("Root", null);
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)) {
            TreeNode node1 = new DefaultTreeNode(new OpcionMenu("1", "- Parámetros de evaluación"), opcionesMenu);
            node1.setExpanded(true);
            node1.setSelected(true);
            initConfiguracionParametrosEvaluacion();
            TreeNode node2 = new DefaultTreeNode(new OpcionMenu("4", "- Parámetros de evaluación final"), opcionesMenu);
            TreeNode node3 = new DefaultTreeNode(new OpcionMenu("2", "- Comisión de evaluación"), opcionesMenu);
            TreeNode node4 = new DefaultTreeNode(new OpcionMenu("3", "- Partidas Presupuestarias"), opcionesMenu);

        }
        TreeNode node5 = new DefaultTreeNode(new OpcionMenu("5", "- Instituciones"), opcionesMenu);
        if (!verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)) {
            node5.setExpanded(true);
            node5.setSelected(true);
            initInstitucion();
        }
        if (verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)) {
            TreeNode node6 = new DefaultTreeNode(new OpcionMenu("6", "- Coordinadores de Vinculación"), opcionesMenu);
            TreeNode node7 = new DefaultTreeNode(new OpcionMenu("7", "- Vicerrector de IITT"), opcionesMenu);
            TreeNode node8 = new DefaultTreeNode(new OpcionMenu("8", "- Director de Unidad de Vinculación"), opcionesMenu);
            TreeNode node9 = new DefaultTreeNode(new OpcionMenu("9", "- Nro. horas mínimo para entrega de certificado estudiante"), opcionesMenu);
            TreeNode node10 = new DefaultTreeNode(new OpcionMenu("10", "- Nro. horas mínimo para entrega de certificado docente"), opcionesMenu);
            TreeNode node11 = new DefaultTreeNode(new OpcionMenu("11", "- Catálogo Partidas Presupuestarias"), opcionesMenu);
            TreeNode node12 = new DefaultTreeNode(new OpcionMenu("12", "- Catálogos Generales"), opcionesMenu);
            TreeNode node13 = new DefaultTreeNode(new OpcionMenu("13", "- Catálogo Objetivos del Plan Nacional"), opcionesMenu);
            
        }
    }

    public void eliminarParametroEvaluacion() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                configuracionParametrosEvaluacionSelected.removeParametroEvaluacion(parametroEvaluacionSelected);
                configuracionParametrosEvaluacionFacade.edit(configuracionParametrosEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    public ValoracionParametroEvaluacion getValoracionParametroEvaluacionSelected() {
        return valoracionParametroEvaluacionSelected;
    }

    public void setValoracionParametroEvaluacionSelected(ValoracionParametroEvaluacion valoracionParametroEvaluacionSelected) {
        this.valoracionParametroEvaluacionSelected = valoracionParametroEvaluacionSelected;
    }

    public String nuevoValoracionParametro() {
        if (!verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId())) {
            parametroEvaluacionSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
        } else {
            valoracionParametroEvaluacionSelected = new ValoracionParametroEvaluacion();
        }
        return "";
    }

    public String grabarValoracionParametro() {
        try {
            if (valoracionParametroEvaluacionSelected.getId() == null) {
                valoracionParametroEvaluacionSelected.setParametroEvaluacion(parametroEvaluacionSelected);
                valoracionParametroEvaluacionSelected.setOrden(parametroEvaluacionSelected.getValoracionList().size() + 1);
                valoracionParametroEvaluacionFacade.create(valoracionParametroEvaluacionSelected);
            } else {
                valoracionParametroEvaluacionFacade.edit(valoracionParametroEvaluacionSelected);
            }
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void eliminarValoracionParametroEvaluacion() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                parametroEvaluacionSelected.removeValoracion(valoracionParametroEvaluacionSelected);
                parametroEvaluacionFacade.edit(parametroEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }
    private Map<Integer, Boolean> expandedParametroEvaluacion = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> expandedParametroEvaluacionFinalCabecera = new HashMap<Integer, Boolean>();
    private Map<Integer, Boolean> expandedConfigParametroEvaluacion = new HashMap<Integer, Boolean>();
      
    public Map<Integer, Boolean> getExpandedParametroEvaluacionFinalCabecera() {
        return expandedParametroEvaluacionFinalCabecera;
    }

    public void setExpandedParametroEvaluacionFinalCabecera(Map<Integer, Boolean> expandedParametroEvaluacionFinalCabecera) {
        this.expandedParametroEvaluacionFinalCabecera = expandedParametroEvaluacionFinalCabecera;
    }

    public Map<Integer, Boolean> getExpandedConfigParametroEvaluacion() {
        return expandedConfigParametroEvaluacion;
    }

    public void setExpandedConfigParametroEvaluacion(Map<Integer, Boolean> expandedConfigParametroEvaluacion) {
        this.expandedConfigParametroEvaluacion = expandedConfigParametroEvaluacion;
    }

    public Map<Integer, Boolean> getExpandedParametroEvaluacion() {
        return expandedParametroEvaluacion;
    }

    public void setExpandedParametroEvaluacion(Map<Integer, Boolean> expandedParametroEvaluacion) {
        this.expandedParametroEvaluacion = expandedParametroEvaluacion;
    }

    public void onRowToggleParametroEvaluacion(ToggleEvent event) {
        ParametroEvaluacion parametroEvaluacion = (ParametroEvaluacion) event.getData();
        expandedParametroEvaluacion.put(parametroEvaluacion.getId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public void onRowToggleConfigParametroEvaluacion(ToggleEvent event) {
        ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacion = (ConfiguracionParametrosEvaluacion) event.getData();
        expandedConfigParametroEvaluacion.put(configuracionParametrosEvaluacion.getId(), event.getVisibility() == Visibility.VISIBLE);
    }
    
    private void setExpandedConfigParametroEvaluacion() {
        for (ConfiguracionParametrosEvaluacion conf : configuracionParametrosEvaluacionList) {
            Boolean expandedConf = (expandedConfigParametroEvaluacion.get(conf.getId()) != null) ? expandedConfigParametroEvaluacion.get(conf.getId()) : false;
            conf.setExpanded(expandedConf);

            for (ParametroEvaluacion parametroEvaluacion : conf.getParametroEvaluacionList()) {
                Boolean expanded = (expandedParametroEvaluacion.get(parametroEvaluacion.getId()) != null) ? expandedParametroEvaluacion.get(parametroEvaluacion.getId()) : false;
                parametroEvaluacion.setExpanded(expanded);
            }
        }
    }

    private ComisionCalificacion comisionCalificacionSelected;

    public ComisionCalificacion getComisionCalificacionSelected() {
        return comisionCalificacionSelected;
    }

    public void setComisionCalificacionSelected(ComisionCalificacion comisionCalificacionSelected) {
        this.comisionCalificacionSelected = comisionCalificacionSelected;
    }

    public void nuevoComisionCalificacion(ActionEvent event) {
        comisionCalificacionSelected = new ComisionCalificacion();
    }

    public String grabarComisionCalificacion() {
        try {
            if (comisionCalificacionSelected.getId() == null) {
                comisionCalificacionFacade.create(comisionCalificacionSelected);
            } else {
                comisionCalificacionFacade.edit(comisionCalificacionSelected);
            }
            cancelarEdicionComisionCalificacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionComisionCalificacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public String grabarMiembroComisionCalificacion() {
        try {
            if (miembroComisionCalificacionSelected == null || miembroComisionCalificacionSelected.getUsuario() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Dato requerido: Debe seleccionar un docente válido"));
                return "";
            }
            if (miembroComisionCalificacionSelected.getId() == null) {
                comisionCalificacionSelected.addMiembro(miembroComisionCalificacionSelected);
            }
            comisionCalificacionFacade.edit(comisionCalificacionSelected);
            cancelarEdicionComisionCalificacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionComisionCalificacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }
    private List<ComisionCalificacion> comisionCalificacionList;

    public List<ComisionCalificacion> getComisionCalificacionList() {
        return comisionCalificacionList;
    }

    public void setComisionCalificacionList(List<ComisionCalificacion> comisionCalificacionList) {
        this.comisionCalificacionList = comisionCalificacionList;
    }

    public void cancelarEdicionComisionCalificacion(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            comisionCalificacionSelected = null;
            miembroComisionCalificacionSelected = null;
        }
        comisionCalificacionList = comisionCalificacionFacade.findAll();
    }

    private MiembroComisionCalificacion miembroComisionCalificacionSelected;

    public MiembroComisionCalificacion getMiembroComisionCalificacionSelected() {
        return miembroComisionCalificacionSelected;
    }

    public void setMiembroComisionCalificacionSelected(MiembroComisionCalificacion miembroComisionCalificacionSelected) {
        this.miembroComisionCalificacionSelected = miembroComisionCalificacionSelected;
    }

    public void onItemSelectDocente(SelectEvent event) {
        llenarDatosDocenteXNombres(event.getObject().toString());
        //validarVaciosP1();
    }

    private void llenarDatosDocenteXNombres(String nombresApellidos) {
        List<VDocenteVinculacion2> doceVincuLista = vistaDocenteFacade.findByName(nombresApellidos);
        miembroComisionCalificacionSelected.setUsuario(doceVincuLista.get(0).getUsuario());
    }

    private String nomDocenteBusqueda = "";

    public String getNomDocenteBusqueda() {
        return nomDocenteBusqueda;
    }

    public void setNomDocenteBusqueda(String nomDocenteBusqueda) {
        this.nomDocenteBusqueda = nomDocenteBusqueda;
    }

    public List<String> completeText(String query) {
        List<VDocenteVinculacion2> doceVincuLista = vistaDocenteFacade.findByName(query);
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < doceVincuLista.size(); i++) {
            results.add(doceVincuLista.get(i).getUsuario().getUsuApellidos() + " " + doceVincuLista.get(i).getUsuario().getUsuNombres());
        }
        return results;
    }

    public String nuevoMiembroComisionCalificacion() {
        nomDocenteBusqueda = null;
        miembroComisionCalificacionSelected = new MiembroComisionCalificacion();
        return "";
    }

    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionSelected;
   
    public ConfiguracionParametrosEvaluacion getConfiguracionParametrosEvaluacionSelected() {
        return configuracionParametrosEvaluacionSelected;
    }

    public void setConfiguracionParametrosEvaluacionSelected(ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionSelected) {
        this.configuracionParametrosEvaluacionSelected = configuracionParametrosEvaluacionSelected;
    }

    public String nuevoConfiguracionParametrosEvaluacion() {
        permitirEdicionConfigParametroEvaluacion = true;
        estadoActivoConfiguracionParametros = false;
        configuracionParametrosEvaluacionSelected = new ConfiguracionParametrosEvaluacion();
        configuracionParametrosEvaluacionSelected.setTipo(ConfiguracionParametrosEvaluacion.TIPO_EVALUACION_INICIAL);
        return "";
    }

    public String grabarConfiguracionParametrosEvaluacion() {
        try {
            boolean actualizarEstado = false;
            if (estadoActivoConfiguracionParametros) {
                if (configuracionParametrosEvaluacionSelected.getId() != null && (configuracionParametrosEvaluacionSelected.getEstado() == null || configuracionParametrosEvaluacionSelected.getEstado().equals(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA))) {
                    actualizarEstado = true;
                }
                configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_ACTIVA);
            } else {
                configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA);
            }
            if (configuracionParametrosEvaluacionSelected.getId() == null) {
                configuracionParametrosEvaluacionFacade.create(configuracionParametrosEvaluacionSelected);
            } else {
                configuracionParametrosEvaluacionFacade.edit(configuracionParametrosEvaluacionSelected, actualizarEstado);
            }
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public String clonarConfiguracionParametrosEvaluacion() {
        try {
            configuracionParametrosEvaluacionSelected.setId(null);
            configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA);
            configuracionParametrosEvaluacionSelected.setFechaConfiguracion(new Date());
            configuracionParametrosEvaluacionSelected.setDescripcion("Configuración replicada de: " + configuracionParametrosEvaluacionSelected.getDescripcion());
            configuracionParametrosEvaluacionSelected.setExpanded(true);
            for (ParametroEvaluacion param : configuracionParametrosEvaluacionSelected.getParametroEvaluacionList()) {
                param.setId(null);
                for (ValoracionParametroEvaluacion val : param.getValoracionList()) {
                    val.setId(null);
                }
            }
            configuracionParametrosEvaluacionFacade.create(configuracionParametrosEvaluacionSelected);
            expandedConfigParametroEvaluacion.put(configuracionParametrosEvaluacionSelected.getId(), true);

            cancelarEdicionConfiguracionParametrosEvaluacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacion(true);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void cancelarEdicionConfiguracionParametrosEvaluacion(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            opcionMenuParametroSelected = null;
            configuracionParametrosEvaluacionSelected = null;
            parametroEvaluacionSelected = null;
            valoracionParametroEvaluacionSelected = null;
        }
        configuracionParametrosEvaluacionList = configuracionParametrosEvaluacionFacade.findXEvaluacionInicial();
        Collections.sort(configuracionParametrosEvaluacionList);
        setExpandedConfigParametroEvaluacion();
    }
    private List<ConfiguracionParametrosEvaluacion> configuracionParametrosEvaluacionList;

    public List<ConfiguracionParametrosEvaluacion> getConfiguracionParametrosEvaluacionList() {
        return configuracionParametrosEvaluacionList;
    }

    public void setConfiguracionParametrosEvaluacionList(List<ConfiguracionParametrosEvaluacion> configuracionParametrosEvaluacionList) {
        this.configuracionParametrosEvaluacionList = configuracionParametrosEvaluacionList;
    }

    @EJB
    private ProyectoFacade proyectoFacade;

    private boolean verificarEdicionConfiguracionParametrosEvaluacion(Integer idConfiguracionParametrosEvaluacion) {
        return (proyectoFacade.verificarPermitirEdicionConfParamEvaluacion(idConfiguracionParametrosEvaluacion));
    }
   
    private boolean verificarEdicionConfiguracionParametrosEvaluacionFinal(Integer idConfiguracionParametrosEvaluacion) {
        return (proyectoFacade.verificarPermitirEdicionConfParamEvaluacionFinal(idConfiguracionParametrosEvaluacion));
    }

    public void eliminarConfigParametroEvaluacion() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                configuracionParametrosEvaluacionFacade.remove(configuracionParametrosEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }
    
    

    public void seleccionarEditarValoracionParametroEvaluacion() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacion(valoracionParametroEvaluacionSelected.getParametroEvaluacion().getConfiguracionParametrosEvaluacion().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionParametrosEvaluacion(true);
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    public void seleccionarEditarParametroEvaluacion() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacion(parametroEvaluacionSelected.getConfiguracionParametrosEvaluacion().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionParametrosEvaluacion(true);
            } else {
                opcionMenuParametroSelected = null;
                for (OpcionMenu op : opcionesMenuParametroList) {
                    if (op.getCodigo().equals(parametroEvaluacionSelected.getOpcionMenu())) {
                        opcionMenuParametroSelected = op;
                        break;
                    }
                }
                //RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescripcionParamEvaluacion').focus();");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    private boolean permitirEdicionConfigParametroEvaluacion;

    public boolean isPermitirEdicionConfigParametroEvaluacion() {
        return permitirEdicionConfigParametroEvaluacion;
    }

    public void setPermitirEdicionConfigParametroEvaluacion(boolean permitirEdicionConfigParametroEvaluacion) {
        this.permitirEdicionConfigParametroEvaluacion = permitirEdicionConfigParametroEvaluacion;
    }

    public void seleccionarEditarConfigParametroEvaluacion() {
        try {
            //permitirEdicionConfigParametroEvaluacion = verificarEdicionConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected.getId());
            permitirEdicionConfigParametroEvaluacion = true;
            if (configuracionParametrosEvaluacionSelected.getEstado() != null && configuracionParametrosEvaluacionSelected.getEstado().equals(ConfiguracionParametrosEvaluacion.ESTADO_ACTIVA)) {
                estadoActivoConfiguracionParametros = true;
            } else {
                estadoActivoConfiguracionParametros = false;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    private List<OpcionMenu> opcionesMenuParametroList;

    public List<OpcionMenu> getOpcionesMenuParametroList() {
        return opcionesMenuParametroList;
    }

    public void setOpcionesMenuParametroList(List<OpcionMenu> opcionesMenuParametroList) {
        this.opcionesMenuParametroList = opcionesMenuParametroList;
    }

    private void llenarOpcionesMenuParametro() {
        if (opcionesMenuParametroList == null) {
            opcionesMenuParametroList = new ArrayList<>();
        } else {
            opcionesMenuParametroList.clear();
        }
        opcionesMenuParametroList.add(new OpcionMenu("1.1", "1.1. Datos Generales"));
        opcionesMenuParametroList.add(new OpcionMenu("1.2", "1.2. Cobertura y Localización"));
        //opcionesMenuParametroList.add(new OpcionMenu("1.3", "1.3. Origen de los fondos"));
        opcionesMenuParametroList.add(new OpcionMenu("1.4", "1.3. Detalle de entregables del proyecto"));
        opcionesMenuParametroList.add(new OpcionMenu("2.1", "2.1. Diagnóstico y Problema"));
        opcionesMenuParametroList.add(new OpcionMenu("2.2", "2.3. Identificación de Población"));
        opcionesMenuParametroList.add(new OpcionMenu("2.3", "2.4. Docentes Participantes"));
        opcionesMenuParametroList.add(new OpcionMenu("2.4", "2.5. Estudiantes Participantes"));
        opcionesMenuParametroList.add(new OpcionMenu("3.1", "3.1. Objetivos PLNBV"));
        opcionesMenuParametroList.add(new OpcionMenu("3.2", "3.2. Objetivos Provinciales, Cantonales o Parroquiales"));
        opcionesMenuParametroList.add(new OpcionMenu("3.3", "3.3. Objetivos Estratégicos Institucionales"));
        opcionesMenuParametroList.add(new OpcionMenu("3.4", "4. Matriz del Marco Lógico"));
        opcionesMenuParametroList.add(new OpcionMenu("4", "5. Viabilidad y Plan de Sostenibilidad"));
        opcionesMenuParametroList.add(new OpcionMenu("5", "6. Presupuesto Detallado y Fuentes de Financiamiento"));
        opcionesMenuParametroList.add(new OpcionMenu("6", "7. Estrategia de Ejecución-Cronograma"));
        opcionesMenuParametroList.add(new OpcionMenu("7", "8. Acta de Consejo de Departamento"));

    }

    private OpcionMenu opcionMenuParametroSelected;

    public OpcionMenu getOpcionMenuParametroSelected() {
        return opcionMenuParametroSelected;
    }

    public void setOpcionMenuParametroSelected(OpcionMenu opcionMenuParametroSelected) {
        this.opcionMenuParametroSelected = opcionMenuParametroSelected;
    }

    private TreeNode root;

    public TreeNode getRoot() {
        if (selectedNodes2 != null) {
            selectedNodes2 = null;
        }
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private PartidaPresupuestaria partidaPresupuestariaSelected;

    public PartidaPresupuestaria getPartidaPresupuestariaSelected() {
        return partidaPresupuestariaSelected;
    }

    public void setPartidaPresupuestariaSelected(PartidaPresupuestaria partidaPresupuestariaSelected) {
        this.partidaPresupuestariaSelected = partidaPresupuestariaSelected;
    }

    @EJB
    private SeaClasificadorPresupFacade clasificadorPresupuestoFacade;
    @EJB
    private PartidaPresupuestariaFacade partidaPresupuestariaFacade;

    private void cargarArbol() {
        this.root = new DefaultTreeNode("Grupo", null);
        List<SeaClasificadorPresup> principales = clasificadorPresupuestoFacade.findClasificadorPadre();
        for (SeaClasificadorPresup opcion : principales) {
            TreeNode itemHijo = new DefaultTreeNode(opcion, root);
            itemHijo.setSelectable(true);
            llenarHijos(opcion, itemHijo);
        }
    }

    private void initPartidaPresupuestaria() {
        cargarArbol();
        tipoPartida = null;
        cancelarPartidaPresupuestria();
    }

    public void cancelarPartidaPresupuestria() {
        if (tipoPartida != null && tipoPartida.equals(PartidaPresupuestaria.TIPO_CORRIENTE)) {
            partidaPresupuestariaList = partidaPresupuestariaFacade.findByGastoCorriente();
        } else if (tipoPartida != null && tipoPartida.equals(PartidaPresupuestaria.TIPO_INVERSION)) {
            partidaPresupuestariaList = partidaPresupuestariaFacade.findByGastoInversion();
        } else if (partidaPresupuestariaList != null) {
            partidaPresupuestariaList.clear();
        }
        partidaPresupuestariaSelected = null;
    }

    /*private void llenarHijos(SeaClasificadorPresup opc, TreeNode menuPadre) {
        List<SeaClasificadorPresup> aux = partidaPresupuestariaFacade.findClasificadorByPadre(opc.getScpId());
        for (SeaClasificadorPresup opcion : aux) {
            TreeNode itemHijo = new DefaultTreeNode(opcion, menuPadre);
            itemHijo.setExpanded(true);
            itemHijo.setSelectable(true);
        }
    }*/
    private void llenarHijos(SeaClasificadorPresup opc, TreeNode menuPadre) {
        //List<SeaClasificadorPresup> aux = partidaPresupuestariaFacade.findClasificadorByPadre(opc.getScpId());
        for (SeaClasificadorPresup opcion : opc.getSeaClasificadorPresupList()) {
            TreeNode itemHijo = new DefaultTreeNode(opcion, menuPadre);
            //itemHijo.setExpanded(true);
            itemHijo.setSelectable(true);
            if (opcion.getSeaClasificadorPresupList() != null && !opcion.getSeaClasificadorPresupList().isEmpty()) {
                llenarHijos(opcion, itemHijo);
            }
        }
    }

    public void onNodeSelect(NodeSelectEvent event) {
        SeaClasificadorPresup nodo = (SeaClasificadorPresup) event.getTreeNode().getData();
        if (event.getTreeNode().getChildren().isEmpty()) {
            this.llenarHijos(nodo, event.getTreeNode());
            if (event.getTreeNode().getChildren().isEmpty()) {
                /*this.rubroProyecto.setPartida(nodo);
                this.numeroBuscar = nodo.getNumero();*/
            }
        } else {
            /*if (!nodo.getPartidaPresupuestariaList().isEmpty()) {
                FacesUtils.addErrorMessage("Debe seleccionar una Partida Presupuestaria");
            } else {
                this.rubroProyecto.setPartida(nodo);
                this.numeroBuscar = nodo.getNumero();
            }*/
        }
    }

    private List<PartidaPresupuestaria> partidaPresupuestariaList;

    public List<PartidaPresupuestaria> getPartidaPresupuestariaList() {
        return partidaPresupuestariaList;
    }

    public void setPartidaPresupuestariaList(List<PartidaPresupuestaria> partidaPresupuestariaList) {
        this.partidaPresupuestariaList = partidaPresupuestariaList;
    }

    private TreeNode[] selectedNodes2;

    public TreeNode[] getSelectedNodes2() {
        return selectedNodes2;
    }

    public void setSelectedNodes2(TreeNode[] selectedNodes2) {
        this.selectedNodes2 = selectedNodes2;
    }

    public void grabarPartidaPresupuestaria() {
        try {
            for (TreeNode node : selectedNodes2) {
                SeaClasificadorPresup clasificadorPresup = (SeaClasificadorPresup) node.getData();
                if (clasificadorPresup.getSeaClasificadorPresupList().isEmpty()) {
                    PartidaPresupuestaria partidaPresupuestaria = new PartidaPresupuestaria();
                    partidaPresupuestaria.setTipo(tipoPartida);
                    partidaPresupuestaria.setClasificadorPresupuesto(clasificadorPresup);
                    boolean encontro = false;
                    if (partidaPresupuestariaList != null && !partidaPresupuestariaList.isEmpty()) {
                        for (PartidaPresupuestaria part : partidaPresupuestariaList) {
                            if (partidaPresupuestaria.getClasificadorPresupuesto().equals(part.getClasificadorPresupuesto())) {
                                encontro = true;
                                break;
                            }
                        }
                    }
                    if (!encontro) {
                        partidaPresupuestariaFacade.create(partidaPresupuestaria);
                    }

                }
            }
            cancelarPartidaPresupuestria();
            RequestContext.getCurrentInstance().execute("PF('dlgPartidaPresupuestaria').hide();");

        } catch (Exception e) {
        }
    }

    public void seleccionarEdicionPartidaPresupuestaria() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacion(valoracionParametroEvaluacionSelected.getParametroEvaluacion().getConfiguracionParametrosEvaluacion().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfig", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionParametrosEvaluacion(true);
            } else {
                RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescripcionValoracionParam').focus();");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacion(true);
        }
    }

    public String grabarEdicionPartidaPresupuestaria() {
        try {
            partidaPresupuestariaFacade.edit(partidaPresupuestariaSelected);
            cancelarPartidaPresupuestria();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarPartidaPresupuestria();
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void eliminarPartidaPresupuestaria() {
        try {
            partidaPresupuestariaFacade.remove(partidaPresupuestariaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            cancelarPartidaPresupuestria();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }

    public void nuevoPartidaPresupuestaria() {
        for (TreeNode nodePadre : root.getChildren()) {
            nodePadre.setExpanded(false);
            nodePadre.setSelected(false);
            resetearHijosArbol(nodePadre);
        }

        selectedNodes2 = null;
        RequestContext.getCurrentInstance().execute("PF('dlgPartidaPresupuestaria').show();");
    }

    private void resetearHijosArbol(TreeNode node) {
        if (node.getChildCount() > 0) {
            for (TreeNode nodeHijo : node.getChildren()) {
                nodeHijo.setExpanded(false);
                nodeHijo.setSelected(false);
                resetearHijosArbol(nodeHijo);
            }
        }

    }

    private String tipoPartida;

    public String getTipoPartida() {
        return tipoPartida;
    }

    public void setTipoPartida(String tipoPartida) {
        this.tipoPartida = tipoPartida;
    }

    public void onchangeTipoPartida() {
        cancelarPartidaPresupuestria();

    }

    @EJB
    MiembroComisionCalificacionFacade miembroComisionCalificacionFacade;

    public void eliminarMiembroComisionEvaluacion() {
        try {
            miembroComisionCalificacionFacade.remove(miembroComisionCalificacionSelected);
            cancelarEdicionComisionCalificacion(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible eliminar el integrante seleccionado";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-02292")) {
                    msgError = msgError + ", porque ya ha registrado una evaluación de proyecto";

                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    public void eliminarComisionEvaluacion() {
        try {
            comisionCalificacionFacade.remove(comisionCalificacionSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible eliminar la comisicón seleccionada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-02292")) {
                    msgError = "No se puede eliminar la comisión seleccionada, porque ya ha sido asignada a un proyecto";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {
            cancelarEdicionComisionCalificacion(true);
        }
    }

    public String grabarConfiguracionParametrosEvaluacionFinal() {
        try {
            boolean actualizarEstado = false;
            if (estadoActivoConfiguracionParametros) {
                if (configuracionParametrosEvaluacionSelected.getId() != null && (configuracionParametrosEvaluacionSelected.getEstado() == null || configuracionParametrosEvaluacionSelected.getEstado().equals(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA))) {
                    actualizarEstado = true;
                }
                configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_ACTIVA);
            } else {
                configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA);
            }
            if (configuracionParametrosEvaluacionSelected.getId() == null) {
                configuracionParametrosEvaluacionFacade.create(configuracionParametrosEvaluacionSelected);
            } else {
                configuracionParametrosEvaluacionFacade.edit(configuracionParametrosEvaluacionSelected, actualizarEstado);
            }
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacionFinal(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }
    private ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabeceraSelected;

    public ParametroEvaluacionFinalCabecera getParametroEvaluacionFinalCabeceraSelected() {
        return parametroEvaluacionFinalCabeceraSelected;
    }

    public void setParametroEvaluacionFinalCabeceraSelected(ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabeceraSelected) {
        this.parametroEvaluacionFinalCabeceraSelected = parametroEvaluacionFinalCabeceraSelected;
    }

    public String nuevoConfiguracionParametrosEvaluacionFinal() {
        configuracionParametrosEvaluacionSelected = new ConfiguracionParametrosEvaluacion(ConfiguracionParametrosEvaluacion.TIPO_EVALUACION_FINAL);
        estadoActivoConfiguracionParametros = false;
        return "";
    }
    @EJB
    private ParametroEvaluacionFinalCabeceraFacade parametroEvaluacionFinalCabeceraFacade;

    public String grabarGrupoParametrosEvaluacionFinal() {
        try {
            if (parametroEvaluacionFinalCabeceraSelected.getId() == null) {
                parametroEvaluacionFinalCabeceraSelected.setConfiguracionParametrosEvaluacion(configuracionParametrosEvaluacionSelected);
                parametroEvaluacionFinalCabeceraSelected.setOrden(configuracionParametrosEvaluacionSelected.getParametroEvaluacionFinalCabeceraList().size() + 1);
                parametroEvaluacionFinalCabeceraFacade.create(parametroEvaluacionFinalCabeceraSelected);
            } else {
                parametroEvaluacionFinalCabeceraFacade.edit(parametroEvaluacionFinalCabeceraSelected);
            }
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacionFinal(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void cancelarEdicionConfiguracionParametrosEvaluacionFinal(boolean ocultarPanelEdicion) {
        if (ocultarPanelEdicion) {
            opcionMenuParametroSelected = null;
            configuracionParametrosEvaluacionSelected = null;
            parametroEvaluacionFinalCabeceraSelected = null;
            parametroEvaluacionSelected = null;
            valoracionParametroEvaluacionSelected = null;
            aspectoEvaluacionFinalDetalleSelected = new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_OTRO, "Otro");
        }
        configuracionParametrosEvaluacionList = configuracionParametrosEvaluacionFacade.findXEvaluacionFinal();
        Collections.sort(configuracionParametrosEvaluacionList);
        setExpandedConfigParametroEvaluacionFinal();
    }

    private void setExpandedConfigParametroEvaluacionFinal() {
        for (ConfiguracionParametrosEvaluacion conf : configuracionParametrosEvaluacionList) {
            Boolean expandedConf = (expandedConfigParametroEvaluacion.get(conf.getId()) != null) ? expandedConfigParametroEvaluacion.get(conf.getId()) : false;
            conf.setExpanded(expandedConf);
            for (ParametroEvaluacionFinalCabecera paramCab : conf.getParametroEvaluacionFinalCabeceraList()) {
                Boolean expandedParamCab = (expandedParametroEvaluacionFinalCabecera.get(paramCab.getId()) != null) ? expandedParametroEvaluacionFinalCabecera.get(paramCab.getId()) : false;
                paramCab.setExpanded(expandedParamCab);
                for (ParametroEvaluacion param : paramCab.getParametroEvaluacionList()) {
                    Boolean expandedParam = (expandedParametroEvaluacion.get(param.getId()) != null) ? expandedParametroEvaluacion.get(param.getId()) : false;
                    param.setExpanded(expandedParam);
                }
            }
        }
    }

    public String grabarParametroEvaluacionFinal() {
        try {
            if (aspectoEvaluacionFinalSelected.getCodigo().equals(AspectoEvaluacionFinal.TIPO_OTRO)) {
                parametroEvaluacionSelected.setIdAspectoEvaluacion(null);
            } else {
                parametroEvaluacionSelected.setDescripcion(null);
                parametroEvaluacionSelected.setIdAspectoEvaluacion(aspectoEvaluacionFinalDetalleSelected.getCodigo());
            }
            if (solicitarInfoAdicional) {
                parametroEvaluacionSelected.setSolicitarInfoAdicional("S");
            } else {
                parametroEvaluacionSelected.setSolicitarInfoAdicional("N");
                parametroEvaluacionSelected.setPreguntaInfoAdicional(null);
            }
            if (parametroEvaluacionSelected.getId() == null) {
                parametroEvaluacionSelected.setParametroEvaluacionFinalCabecera(parametroEvaluacionFinalCabeceraSelected);
                parametroEvaluacionSelected.setOrden(parametroEvaluacionFinalCabeceraSelected.getParametroEvaluacionList().size() + 1);
                parametroEvaluacionFacade.create(parametroEvaluacionSelected);
            } else {
                parametroEvaluacionFacade.edit(parametroEvaluacionSelected);
            }
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacionFinal(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public String grabarValoracionParametroFinal() {
        try {
            if (valoracionParametroEvaluacionSelected.getId() == null) {
                valoracionParametroEvaluacionSelected.setParametroEvaluacion(parametroEvaluacionSelected);
                valoracionParametroEvaluacionSelected.setOrden(parametroEvaluacionSelected.getValoracionList().size() + 1);
                valoracionParametroEvaluacionFacade.create(valoracionParametroEvaluacionSelected);
            } else {
                valoracionParametroEvaluacionFacade.edit(valoracionParametroEvaluacionSelected);
            }
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacionFinal(false);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public String clonarConfiguracionParametrosEvaluacionFinal() {
        try {
            configuracionParametrosEvaluacionSelected.setId(null);
            configuracionParametrosEvaluacionSelected.setEstado(ConfiguracionParametrosEvaluacion.ESTADO_INACTIVA);
            configuracionParametrosEvaluacionSelected.setFechaConfiguracion(new Date());
            configuracionParametrosEvaluacionSelected.setDescripcion("Configuración replicada de: " + configuracionParametrosEvaluacionSelected.getDescripcion());
            configuracionParametrosEvaluacionSelected.setExpanded(true);
            for (ParametroEvaluacionFinalCabecera paramCab : configuracionParametrosEvaluacionSelected.getParametroEvaluacionFinalCabeceraList()) {
                paramCab.setId(null);
                for (ParametroEvaluacion param : paramCab.getParametroEvaluacionList()) {
                    param.setId(null);
                    for (ValoracionParametroEvaluacion val : param.getValoracionList()) {
                        val.setId(null);
                    }
                }

            }
            configuracionParametrosEvaluacionFacade.create(configuracionParametrosEvaluacionSelected);
            expandedConfigParametroEvaluacion.put(configuracionParametrosEvaluacionSelected.getId(), true);

            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            } catch (Exception e2) {
            }
        }
        return "";
    }

    public void seleccionarEditarConfigParametroEvaluacionFinal() {
        try {
            /*if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones finales de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            } else */
            if (configuracionParametrosEvaluacionSelected.getEstado() != null && configuracionParametrosEvaluacionSelected.getEstado().equals(ConfiguracionParametrosEvaluacion.ESTADO_ACTIVA)) {
                estadoActivoConfiguracionParametros = true;
            } else {
                estadoActivoConfiguracionParametros = false;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }
    }

    public void eliminarConfigParametroEvaluacionFinal() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                configuracionParametrosEvaluacionFacade.remove(configuracionParametrosEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }
    }

    public String nuevoGrupoParametroEvaluacionFinal() {
        if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionSelected.getId())) {
            configuracionParametrosEvaluacionSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
        } else {
            parametroEvaluacionFinalCabeceraSelected = new ParametroEvaluacionFinalCabecera();
        }
        return "";
    }

    public void onRowToggleGrupoParametroEvaluacionFinal(ToggleEvent event) {
        ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabecera = (ParametroEvaluacionFinalCabecera) event.getData();
        expandedParametroEvaluacionFinalCabecera.put(parametroEvaluacionFinalCabecera.getId(), event.getVisibility() == Visibility.VISIBLE);
    }

    public String cambiarOrdenGrupoParametroEvaluacionFinal(ParametroEvaluacionFinalCabecera parametroEvaluacionFinalCabecera, Integer cambio) {
        try {
            parametroEvaluacionFinalCabecera.cambiarOrden(cambio);
            configuracionParametrosEvaluacionFacade.edit(parametroEvaluacionFinalCabecera.getConfiguracionParametrosEvaluacion());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }

        return "";
    }

    public void seleccionarEditarGrupoParametroEvaluacionFinal() {
        if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(parametroEvaluacionFinalCabeceraSelected.getConfiguracionParametrosEvaluacion().getId())) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones finales de proyectos realizadas con esta configuración"));
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        } else {
            //RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescripcionParamEvaluacion').focus();");
        }
    }

    public void eliminarGrupoParametroEvaluacionFinal() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(configuracionParametrosEvaluacionSelected.getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                configuracionParametrosEvaluacionSelected.removeParametroEvaluacionFinalCabecera(parametroEvaluacionFinalCabeceraSelected);
                configuracionParametrosEvaluacionFacade.edit(configuracionParametrosEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }
    }

    public String nuevoParametroEvaluacionFinal() {
        aspectoEvaluacionFinalSelected = new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_OTRO, "");
        solicitarInfoAdicional = false;
        if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(parametroEvaluacionFinalCabeceraSelected.getConfiguracionParametrosEvaluacion().getId())) {
            parametroEvaluacionFinalCabeceraSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
        } else {
            parametroEvaluacionSelected = new ParametroEvaluacion();
        }
        return "";
    }

    public String cambiarOrdenParametroEvaluacionFinal(ParametroEvaluacion parametroEvaluacion, Integer cambio) {
        try {
            parametroEvaluacion.cambiarOrdenEvaluacionFinal(cambio);
            parametroEvaluacionFinalCabeceraFacade.edit(parametroEvaluacion.getParametroEvaluacionFinalCabecera());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }

        return "";
    }

    public void seleccionarEditarParametroEvaluacionFinal() {
        if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(parametroEvaluacionSelected.getParametroEvaluacionFinalCabecera().getConfiguracionParametrosEvaluacion().getId())) {
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones finales de proyectos realizadas con esta configuración"));
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        } else {
            if (parametroEvaluacionSelected.getDescripcion() == null) {
                if (parametroEvaluacionSelected.getIdAspectoEvaluacion().equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO)) {
                    for (AspectoEvaluacionFinal asp : aspectoEvaluacionFinalList) {
                        if (asp.getCodigo().equals(AspectoEvaluacionFinal.TIPO_BENEFICIARIO)) {
                            aspectoEvaluacionFinalSelected = asp;
                            break;
                        }
                    }
                } else {
                    for (AspectoEvaluacionFinal asp : aspectoEvaluacionFinalList) {
                        if (asp.getCodigo().equals(AspectoEvaluacionFinal.TIPO_PRESUPUESTO)) {
                            aspectoEvaluacionFinalSelected = asp;
                            break;
                        }
                    }
                }
                aspectoEvaluacionFinalDetalleSelected = new AspectoEvaluacionFinal(parametroEvaluacionSelected.getIdAspectoEvaluacion(), "");
            } else {
                aspectoEvaluacionFinalSelected = new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_OTRO, "");
            }
            if (parametroEvaluacionSelected.getSolicitarInfoAdicional() != null && parametroEvaluacionSelected.getSolicitarInfoAdicional().equals("S")) {
                solicitarInfoAdicional = true;
            } else {
                solicitarInfoAdicional = false;
            }

            //RequestContext.getCurrentInstance().execute("document.getElementById('formPrincipal:txtDescripcionParamEvaluacion').focus();");
        }
    }

    public void eliminarParametroEvaluacionFinal() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(parametroEvaluacionFinalCabeceraSelected.getConfiguracionParametrosEvaluacion().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                parametroEvaluacionFinalCabeceraSelected.removeParametroEvaluacion(parametroEvaluacionSelected);
                parametroEvaluacionFinalCabeceraFacade.edit(parametroEvaluacionFinalCabeceraSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }
    }

    public void seleccionarEditarValoracionParametroEvaluacionFinal() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(valoracionParametroEvaluacionSelected.getParametroEvaluacion().getParametroEvaluacionFinalCabecera().getConfiguracionParametrosEvaluacion().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones finales de proyectos realizadas con esta configuración"));
                cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }
    }
    private List<AspectoEvaluacionFinal> aspectoEvaluacionFinalList;

    public List<AspectoEvaluacionFinal> getAspectoEvaluacionFinalList() {
        return aspectoEvaluacionFinalList;
    }

    public void setAspectoEvaluacionFinalList(List<AspectoEvaluacionFinal> aspectoEvaluacionFinalList) {
        this.aspectoEvaluacionFinalList = aspectoEvaluacionFinalList;
    }

    public void initConfiguracionParametrosEvaluacionFinal() {

        if (expandedParametroEvaluacion == null) {
            expandedParametroEvaluacion = new HashMap<>();
        } else {
            expandedParametroEvaluacion.clear();
        }
        if (expandedParametroEvaluacionFinalCabecera == null) {
            expandedParametroEvaluacionFinalCabecera = new HashMap<>();
        } else {
            expandedParametroEvaluacionFinalCabecera.clear();
        }

        if (expandedConfigParametroEvaluacion == null) {
            expandedConfigParametroEvaluacion = new HashMap<>();
        } else {
            expandedConfigParametroEvaluacion.clear();;
        }
        if (aspectoEvaluacionFinalList == null) {
            aspectoEvaluacionFinalList = new ArrayList<>();
            AspectoEvaluacionFinal aspectoEvaluacionFinal = new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_BENEFICIARIO, "Beneficiarios");
            aspectoEvaluacionFinal.addAspectoEvaluacionHijo(new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_BENEFICIARIO_DIRECTO, "Directos"));
            aspectoEvaluacionFinalList.add(aspectoEvaluacionFinal);
            aspectoEvaluacionFinal = new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_PRESUPUESTO, "Ejecución presupuestaria del Proyecto");
            aspectoEvaluacionFinal.addAspectoEvaluacionHijo(new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD, "Presupuesto Aporte Universidad"));
            aspectoEvaluacionFinal.addAspectoEvaluacionHijo(new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_UNIVERSIDAD_VALORADO, "Presupuesto Aporte Universidad Valorado"));
            aspectoEvaluacionFinal.addAspectoEvaluacionHijo(new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_ENTIDAD_AUSPICIANTE, "Presupuesto Entidad Auspiciante"));
            aspectoEvaluacionFinal.addAspectoEvaluacionHijo(new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_PRESUPUESTO_CONTRAPARTE, "Presupuesto Contraparte – Comunidad Beneficiaria"));
            aspectoEvaluacionFinalList.add(aspectoEvaluacionFinal);
            aspectoEvaluacionFinal = new AspectoEvaluacionFinal(AspectoEvaluacionFinal.TIPO_OTRO, "Otro");
            aspectoEvaluacionFinalList.add(aspectoEvaluacionFinal);
        }

        cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        for (ConfiguracionParametrosEvaluacion conf : configuracionParametrosEvaluacionList) {
            expandedConfigParametroEvaluacion.put(conf.getId(), conf.isExpanded());
            for (ParametroEvaluacionFinalCabecera paramCab : conf.getParametroEvaluacionFinalCabeceraList()) {
                expandedParametroEvaluacionFinalCabecera.put(paramCab.getId(), paramCab.isExpanded());
                for (ParametroEvaluacion param : paramCab.getParametroEvaluacionList()) {
                    expandedParametroEvaluacion.put(param.getId(), param.isExpanded());
                }
            }
        }

    }

    public String nuevoValoracionParametroFinal() {
        if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(parametroEvaluacionSelected.getParametroEvaluacionFinalCabecera().getConfiguracionParametrosEvaluacion().getId())) {
            parametroEvaluacionSelected = null;
            FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones finales de proyectos realizadas con esta configuración"));
        } else {
            valoracionParametroEvaluacionSelected = new ValoracionParametroEvaluacion();
        }
        return "";
    }

    public void eliminarValoracionParametroEvaluacionFinal() {
        try {
            if (!verificarEdicionConfiguracionParametrosEvaluacionFinal(parametroEvaluacionSelected.getParametroEvaluacionFinalCabecera().getConfiguracionParametrosEvaluacion().getId())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:lblConfigEvaluacionFinal", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No es posible modificar/eliminar información de la configuración seleccionada, porque existen evaluaciones de proyectos realizadas con esta configuración"));
            } else {
                parametroEvaluacionSelected.removeValoracion(valoracionParametroEvaluacionSelected);
                parametroEvaluacionFacade.edit(parametroEvaluacionSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }
    }

    public String cambiarOrdenValoracionParametroEvaluacionFinal(ValoracionParametroEvaluacion valoracionParametroEvaluacion, Integer cambio) {
        try {
            valoracionParametroEvaluacion.cambiarOrden(cambio);
            parametroEvaluacionFacade.edit(valoracionParametroEvaluacion.getParametroEvaluacion());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
        } finally {
            cancelarEdicionConfiguracionParametrosEvaluacionFinal(true);
        }

        return "";
    }
    private AspectoEvaluacionFinal aspectoEvaluacionFinalSelected;
    private AspectoEvaluacionFinal aspectoEvaluacionFinalDetalleSelected;

    public AspectoEvaluacionFinal getAspectoEvaluacionFinalSelected() {
        return aspectoEvaluacionFinalSelected;
    }

    public void setAspectoEvaluacionFinalSelected(AspectoEvaluacionFinal aspectoEvaluacionFinalSelected) {
        this.aspectoEvaluacionFinalSelected = aspectoEvaluacionFinalSelected;
    }

    public AspectoEvaluacionFinal getAspectoEvaluacionFinalDetalleSelected() {
        return aspectoEvaluacionFinalDetalleSelected;
    }

    public void setAspectoEvaluacionFinalDetalleSelected(AspectoEvaluacionFinal aspectoEvaluacionFinalDetalleSelected) {
        this.aspectoEvaluacionFinalDetalleSelected = aspectoEvaluacionFinalDetalleSelected;
    }

    private boolean solicitarInfoAdicional;

    public boolean isSolicitarInfoAdicional() {
        return solicitarInfoAdicional;
    }

    public void setSolicitarInfoAdicional(boolean solicitarInfoAdicional) {
        this.solicitarInfoAdicional = solicitarInfoAdicional;
    }

    private boolean estadoActivoConfiguracionParametros;

    public boolean isEstadoActivoConfiguracionParametros() {
        return estadoActivoConfiguracionParametros;
    }

    public void setEstadoActivoConfiguracionParametros(boolean estadoActivoConfiguracionParametros) {
        this.estadoActivoConfiguracionParametros = estadoActivoConfiguracionParametros;
    }
    private Institucion institucionSelected;

    public Institucion getInstitucionSelected() {
        return institucionSelected;
    }

    public void setInstitucionSelected(Institucion institucionSelected) {
        this.institucionSelected = institucionSelected;
    }

    public void nuevoInstitucion() {
        institucionSelected = new Institucion();
        institucionSelected.setActiva(true);
        provinciaSelected = null;
        cantonSelected = null;
    }
    @EJB
    private InstitucionFacade institucionFacade;

    public void grabarInstitucion() {
        try {
            institucionSelected.setEstado(institucionSelected.isActiva() ? Institucion.ESTADO_ACTIVO : Institucion.ESTADO_INACTIVO);
            if (institucionSelected.getId() == null) {
                institucionFacade.create(institucionSelected);
            } else {
                institucionFacade.edit(institucionSelected);
            }
            cancelarInstitucion();
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

    private List<Institucion> institucionList;

    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    private void initInstitucion() {
        provinciaList = provinciaFacade.findAllOrdenados();
        cancelarInstitucion();
    }

    public void cancelarInstitucion() {
        institucionList = institucionFacade.findAll();
        institucionSelected = null;
    }

    private List<SeaProvincia> provinciaList;

    public List<SeaProvincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<SeaProvincia> provinciaList) {
        this.provinciaList = provinciaList;
    }
    private SeaProvincia provinciaSelected;

    public SeaProvincia getProvinciaSelected() {
        return provinciaSelected;
    }

    public void setProvinciaSelected(SeaProvincia provinciaSelected) {
        this.provinciaSelected = provinciaSelected;
    }

    private SeaCanton cantonSelected;

    public SeaCanton getCantonSelected() {
        return cantonSelected;
    }

    public void setCantonSelected(SeaCanton cantonSelected) {
        this.cantonSelected = cantonSelected;
    }
    @EJB
    private SeaProvinciaFacade provinciaFacade;

    public void eliminarInstitucion() {
        try {
            institucionFacade.remove(institucionSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarInstitucion();
        }
    }

    public void seleccionarInstitucion() {
        if (institucionSelected.getEstado() != null && institucionSelected.getEstado().equals(Institucion.ESTADO_ACTIVO)) {
            institucionSelected.setActiva(true);
        }
        provinciaSelected = institucionSelected.getParroquia().getCanId().getProId();
        cantonSelected = institucionSelected.getParroquia().getCanId();
    }

    public void seleccionarProvincia() {
        cantonSelected = null;
        institucionSelected.setParroquia(null);
    }

    public void seleccionarCanton() {
        institucionSelected.setParroquia(null);
    }

    private boolean verificarPerfil(String perfil) {
        for (SegPerfil per : perfilUsuarioActual) {
            if (per.getPerNombre().toUpperCase().equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    private CoordinadorVinculacion coordinadorVinculacionSelected;

    public CoordinadorVinculacion getCoordinadorVinculacionSelected() {
        return coordinadorVinculacionSelected;
    }

    public void setCoordinadorVinculacionSelected(CoordinadorVinculacion coordinadorVinculacionSelected) {
        this.coordinadorVinculacionSelected = coordinadorVinculacionSelected;
    }

    public void nuevoCoordinadorVinculacion() {
        coordinadorVinculacionSelected = new CoordinadorVinculacion();
    }

    public void grabarCoordinadorVinculacion() {
        try {
            if (coordinadorVinculacionSelected.getDepartamento() == null && coordinadorVinculacionSelected.getCarrera() != null) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:selDepartamentoCoordinador", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un departamento"));
                return;
            }
            if (coordinadorVinculacionSelected.getId() == null) {
                coordinadorVinculacionFacade.create(coordinadorVinculacionSelected);
            } else {
                coordinadorVinculacionFacade.edit(coordinadorVinculacionSelected);
            }
            cancelarCoordinadorVinculacion();
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
                    msgError = "Ya existe un registro para el campus/departamento/carrera seleccionado";
                }
                controlMsgError = "formPrincipal:selDepartamentoCoordinador";
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            } finally {
                listarCoordinadorVinculacion();
            }
        }
    }
    @EJB
    private CoordinadorVinculacionFacade coordinadorVinculacionFacade;

    private List<CoordinadorVinculacion> coordinadorVinculacionList;

    public List<CoordinadorVinculacion> getCoordinadorVinculacionList() {
        return coordinadorVinculacionList;
    }

    public void setCoordinadorVinculacionList(List<CoordinadorVinculacion> coordinadorVinculacionList) {
        this.coordinadorVinculacionList = coordinadorVinculacionList;
    }

    private List<Stvcamp> campusList;

    public List<Stvcamp> getCampusList() {
        return campusList;
    }

    public void setCampusList(List<Stvcamp> campusList) {
        this.campusList = campusList;
    }

    private void initCoordinadorVinculacion() {
        campusList = new ArrayList<>();
        List<VDirectorDepartamento> vDirectorDepartamentoList = vDirectorDepartamentoFacade.findAll();
        for (VDirectorDepartamento dir : vDirectorDepartamentoList) {
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
                    for (VDirectorDepartamento dir2 : vDirectorDepartamentoList) {
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
        carreraList = carreraFacade.findCarrera();
        cancelarCoordinadorVinculacion();
    }

    private void listarCoordinadorVinculacion() {
        coordinadorVinculacionList = coordinadorVinculacionFacade.findAll();
        Collections.sort(coordinadorVinculacionList);
    }

    public void cancelarCoordinadorVinculacion() {
        listarCoordinadorVinculacion();
        coordinadorVinculacionSelected = null;
    }

    public void abrirBusquedaDocenteCoordinador(ActionEvent event) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("contentHeight", 380);
        options.put("contentWidth", 800);
        //options.put("closeOnEscape", true); 
        options.put("includeViewParams", true);
        options.put("closeable", false);

        Map<String, List<String>> params = new HashMap<String, List<String>>();

        List<String> values = new ArrayList<String>();
        values.add(coordinadorVinculacionSelected.getCampus().getStvcampCode());
        params.put("idCampus", values);
        if (coordinadorVinculacionSelected.getDepartamento() != null) {
            List<String> values2 = new ArrayList<String>();
            values2.add(coordinadorVinculacionSelected.getDepartamento().getStvsubjCode());
            params.put("idDepartamento", values2);
        }

        modoPopup = true;
        RequestContext.getCurrentInstance().openDialog("busquedaDocente", options, params);
    }

    private boolean modoPopup;

    public boolean isModoPopup() {
        return modoPopup;
    }

    public void setModoPopup(boolean modoPopup) {
        this.modoPopup = modoPopup;
    }

    public void seleccionarDocente(SelectEvent event) {
        VDocenteVinculacion2 docente = (VDocenteVinculacion2) event.getObject();
        if (docente != null) {
            //coordinadorVinculacionSelected.setDepartamento(docente.getDepartamento());
            coordinadorVinculacionSelected.setUsuario(docente.getUsuario());
        }
        modoPopup = false;
    }

    @EJB
    private VDirectorDepartamentoFacade vDirectorDepartamentoFacade;

    public void eliminarCoordinadorVinculacion() {
        try {
            coordinadorVinculacionFacade.remove(coordinadorVinculacionSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        } finally {
            cancelarCoordinadorVinculacion();
        }
    }

    public void seleccionarCampusCoordinador() {
        for (Stvcamp camp : campusList) {
            if (camp.equals(coordinadorVinculacionSelected.getCampus())) {
                coordinadorVinculacionSelected.setCampus(camp);
                break;
            }
        }
    }

    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    @EJB
    private ConfiguracionFacade configuracionFacade;

    public void cancelarConfiguracion() {
        modoEdicion = false;
        List<Configuracion> configuracionList = configuracionFacade.findAll();
        if (configuracionList.size() > 0) {
            configuracionSelected = configuracionList.get(0);
        } else {
            configuracionSelected = new Configuracion();
        }
    }

    public void seleccionarEdicion() {
        modoEdicion = true;
    }
    private Configuracion configuracionSelected;

    public Configuracion getConfiguracionSelected() {
        return configuracionSelected;
    }

    public void setConfiguracionSelected(Configuracion configuracionSelected) {
        this.configuracionSelected = configuracionSelected;
    }

    public void grabarConfiguracion() {
        try {
            if (configuracionSelected.getId() == null) {
                configuracionFacade.create(configuracionSelected);
            } else {
                configuracionFacade.edit(configuracionSelected);
            }
            cancelarConfiguracion();
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

    public List<Stvmajr> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Stvmajr> carreraList) {
        this.carreraList = carreraList;
    }

    private List<Stvterm> periodoList;

    public List<Stvterm> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Stvterm> periodoList) {
        this.periodoList = periodoList;
    }

    private List<SeaClasificadorPresup> clasificadorPresupuestarioList;

    public List<SeaClasificadorPresup> getClasificadorPresupuestarioList() {
        return clasificadorPresupuestarioList;
    }

    public void setClasificadorPresupuestarioList(List<SeaClasificadorPresup> clasificadorPresupuestarioList) {
        this.clasificadorPresupuestarioList = clasificadorPresupuestarioList;
    }

    public void initCatalogoPartidaPresupuestaria() {
        modoEdicion = false;
        clasificadorPresupuestoSelected = null;
        clasificadorPresupuestoPadreSelected = null;
        clasificadorPresupuestarioList = clasificadorPresupuestoFacade.findAll();
        Collections.sort(clasificadorPresupuestarioList);
    }
    private SeaClasificadorPresup clasificadorPresupuestoSelected;
    private SeaClasificadorPresup clasificadorPresupuestoPadreSelected;

    public SeaClasificadorPresup getClasificadorPresupuestoPadreSelected() {
        return clasificadorPresupuestoPadreSelected;
    }

    public void setClasificadorPresupuestoPadreSelected(SeaClasificadorPresup clasificadorPresupuestoPadreSelected) {
        this.clasificadorPresupuestoPadreSelected = clasificadorPresupuestoPadreSelected;
    }

    public SeaClasificadorPresup getClasificadorPresupuestoSelected() {
        return clasificadorPresupuestoSelected;
    }

    public void setClasificadorPresupuestoSelected(SeaClasificadorPresup clasificadorPresupuestoSelected) {
        this.clasificadorPresupuestoSelected = clasificadorPresupuestoSelected;
    }

    public void nuevoClasificadorPresupuesto() {
        modoEdicion = false;
        clasificadorPresupuestoSelected = new SeaClasificadorPresup();
        if (clasificadorPresupuestoPadreSelected != null) {
            clasificadorPresupuestoSelected.setScpPadre(clasificadorPresupuestoPadreSelected);
        }
    }

    public void grabarClasificadorPresupuesto() {
        try {
            if (!modoEdicion) {
                clasificadorPresupuestoFacade.create(clasificadorPresupuestoSelected);
            } else {
                clasificadorPresupuestoFacade.edit(clasificadorPresupuestoSelected);
            }
            initCatalogoPartidaPresupuestaria();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible grabar la información ingresada";
                if (t.getMessage().toUpperCase().contains("ORA-00001")) {
                    msgError = "Ya existe un registro con este código.";
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
                //initCatalogoPartidaPresupuestaria();
            } catch (Exception e2) {
            }
        }
    }

    public String getTituloEdicionClasificador() {
        if (clasificadorPresupuestoSelected.getScpId() == null) {//NUEVO
            if (clasificadorPresupuestoSelected.isEsPartida()) {
                return "NUEVA PARTIDA PRESUPUESTARIA";
            } else if (clasificadorPresupuestoSelected.isEsSubGrupo2()) {
                return "NUEVO SUBGRUPO2";
            } else if (clasificadorPresupuestoSelected.isEsSubGrupo1()) {
                return "NUEVO SUBGRUPO1";
            } else {
                return "NUEVO GRUPO";
            }
        } else//EDICION
        {
            if (clasificadorPresupuestoSelected.isEsPartida()) {
                return "EDICIÓN DE PARTIDA PRESUPUESTARIA";
            } else if (clasificadorPresupuestoSelected.isEsSubGrupo2()) {
                return "EDICIÓN DE SUBGRUPO2";
            } else if (clasificadorPresupuestoSelected.isEsSubGrupo1()) {
                return "EDICIÓN DE SUBGRUPO1";
            } else {
                return "EDICIÓN DE GRUPO";
            }
        }
    }

    public String getLabelCodigoCatalogo() {
        if (clasificadorPresupuestoSelected.isEsPartida()) {
            return "Código Partida Presupuestaria:";
        } else if (clasificadorPresupuestoSelected.isEsSubGrupo2()) {
            return "Código Subgrupo2:";
        } else if (clasificadorPresupuestoSelected.isEsSubGrupo1()) {
            return "Código Subgrupo1:";
        } else {
            return "Código Grupo:";
        }
    }

    public String getLabelNombreCatalogo() {
        if (clasificadorPresupuestoSelected.isEsPartida()) {
            return "Nombre Partida Presupuestaria:";
        } else if (clasificadorPresupuestoSelected.isEsSubGrupo2()) {
            return "Nombre Subgrupo2:";
        } else if (clasificadorPresupuestoSelected.isEsSubGrupo1()) {
            return "Nombre Subgrupo1:";
        } else {
            return "Nombre Grupo:";
        }
    }

    public String getLabelNuevoCatalogo(SeaClasificadorPresup clasificadorPresupuestoPadreSelected) {
        if (clasificadorPresupuestoPadreSelected != null) {
            if (clasificadorPresupuestoPadreSelected.isEsSubGrupo2()) {
                return "Nueva Partida Presupuestaria";
            } else if (clasificadorPresupuestoPadreSelected.isEsSubGrupo1()) {
                return "Nuevo Subgrupo1:";
            } else {
                return "Nombre Subgrupo2:";
            }
        }
        return "";
    }

    public void eliminarClasificadorPresupuesto() {
        try {
            clasificadorPresupuestoFacade.remove(clasificadorPresupuestoSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible eliminar el item seleccionado";
                if (t.getMessage().toUpperCase().contains("ORA-02292")) {
                    msgError = "No es posible eliminar el item, ya que está relacionado con otro registro.";
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        } finally {
            initCatalogoPartidaPresupuestaria();
        }
    }

    public List<SeaParametros> getCatalogoList() {
        return catalogoList;
    }

    public void setCatalogoList(List<SeaParametros> catalogoList) {
        this.catalogoList = catalogoList;
    }

    public SeaParametros getCatalogoSelected() {
        return catalogoSelected;
    }

    public void setCatalogoSelected(SeaParametros catalogoSelected) {
        this.catalogoSelected = catalogoSelected;
    }

    private SeaParametrosDet catalogoItemSelected;
    private List<SeaParametrosDet> catalogoItemList;

    public List<SeaParametrosDet> getCatalogoItemList() {
        return catalogoItemList;
    }

    public void setCatalogoItemList(List<SeaParametrosDet> catalogoItemList) {
        this.catalogoItemList = catalogoItemList;
    }

    public SeaParametrosDet getCatalogoItemSelected() {
        return catalogoItemSelected;
    }

    public void setCatalogoItemSelected(SeaParametrosDet catalogoItemSelected) {
        this.catalogoItemSelected = catalogoItemSelected;
    }

    public void nuevoCatalogoGeneral() {
        catalogoItemSelected = new SeaParametrosDet();
    }

    public void grabarCatalogoGeneral() {
        try {
            if (catalogoItemSelected.getPrdId() == null) {
                catalogoItemSelected.setSeaParametros(catalogoSelected);
                catalogoItemFacade.create(catalogoItemSelected);
            } else {
                catalogoItemFacade.edit(catalogoItemSelected);
            }
            cancelarCatalogoGeneral();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible registrar la información."));
        }
    }

    public void cancelarCatalogoGeneral() {
        catalogoItemSelected = null;
        catalogoItemList = catalogoItemFacade.findByCodigoParametro(catalogoSelected.getParId());
    }

    public void seleccionarCatalogo() {

    }

    public void eliminarCatalogoGeneral() {
        try {
            catalogoItemFacade.remove(catalogoItemSelected);
            cancelarCatalogoGeneral();
        } catch (Exception e) {
            try {
                catalogoItemSelected=null;
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible eliminar el item seleccionado";
                if (t.getMessage().toUpperCase().contains("ORA-02292")) {
                    msgError = "No es posible eliminar el item, ya que está relacionado con otro registro.";
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
    }

    private void initCatalogosGenerales() {
        catalogoSelected = new SeaParametros(SeaParametros.PARAM_ESTADO_PROYECTO_VINCULACION);
        cancelarCatalogoGeneral();
    }

}
