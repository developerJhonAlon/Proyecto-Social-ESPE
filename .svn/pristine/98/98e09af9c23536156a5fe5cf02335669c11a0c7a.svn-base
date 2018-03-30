/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.ActaAprobacionVicerrectorado;
import ec.edu.espe_ctt.vinculacion.entity.Configuracion;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.session.ActaAprobacionVicerrectoradoFacade;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionFacade;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_innovativa.util.FacesUtils;
import ec.edu.espe_innovativa.util.JasperReportUtil;
import java.io.ByteArrayInputStream;
import static java.io.File.separatorChar;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.apache.poi.xssf.usermodel.*;
/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class AprobacionVicerrectoradoController implements Serializable {

    @EJB
    private ProyectoFacade proyectoFacade;
    private List<Proyecto> proyectoList;
    private List<Proyecto> proyectoTodosList;

    private List<ActaAprobacionVicerrectorado> actaAprobacionVicerrectoradoList;
    @EJB
    private ActaAprobacionVicerrectoradoFacade actaAprobacionVicerrectoradoFacade;
    private SegUsuario usuarioActual;

    public AprobacionVicerrectoradoController() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        initAprobacion();
        
    }
    @EJB
    private ConfiguracionFacade configuracionFacade;
    private Configuracion configuracionSelected;

    private void initAprobacion(){
        estadoAprobacionVicerrectorado= "P";
        configuracionSelected= configuracionFacade.findAll().get(0);
        cancelarAprobacion();
    }
    
    private void cancelarAprobacion(){
        proyectoList = new ArrayList<>();
        proyectoTodosList = proyectoFacade.findByPorAutorizarVicerrectorado();
        for (Proyecto p : proyectoTodosList) {
            if (p.isEstadoAprobacionVicerrectorado()) {
                proyectoList.add(p);
            }
        }
        onChangeEstado();
        cancelarActa();
    }

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public void generarActa() {
        try {
            ActaAprobacionVicerrectorado a = actaAprobacionVicerrectoradoFacade.findByMaximoSecuencial();
            Integer secuencial = 1;
            if (a != null) {
                secuencial = a.getSecuencial() + 1;
            }            
            
            
            a = new ActaAprobacionVicerrectorado();
            a.setUsuario(usuarioActual);
            a.setSecuencial(secuencial);
            actaAprobacionVicerrectoradoFacade.create(a);
            
            for (Proyecto p : proyectoList) {
                if (!p.isEstadoAprobacionVicerrectorado()
                        && p.getActaAprobacionVicerrectorado()==null){
                    p.setActaAprobacionVicerrectorado(a);
                    proyectoFacade.edit(p);
                }
            }
            cancelarAprobacion();
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

    public String grabarAprobacionVicerrectorado() {
        try {
            boolean encontro = false;
            for (Proyecto proyecto : proyectoList) {
                if (proyecto.getAprobadoVicerrectorado() != null) {
                    proyecto.setEstado(new SeaParametrosDet(proyecto.getAprobadoVicerrectorado()));
                    proyecto.setFechaAprobacionVicerrectorado(new Date());
                    encontro = true;
                }
            }
            if (!encontro) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar la aprobación de uno o más proyectos"));
            } else {
                proyectoFacade.actualizarProyectos(proyectoList);
                cancelarAprobacion();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
            }
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
        return "";
    }

    public List<ActaAprobacionVicerrectorado> getActaAprobacionVicerrectoradoList() {
        return actaAprobacionVicerrectoradoList;
    }

    public void setActaAprobacionVicerrectoradoList(List<ActaAprobacionVicerrectorado> actaAprobacionVicerrectoradoList) {
        this.actaAprobacionVicerrectoradoList = actaAprobacionVicerrectoradoList;
    }

    private ActaAprobacionVicerrectorado actaAprobacionVicerrectoradoSelected;

    public ActaAprobacionVicerrectorado getActaAprobacionVicerrectoradoSelected() {
        return actaAprobacionVicerrectoradoSelected;
    }

    public void setActaAprobacionVicerrectoradoSelected(ActaAprobacionVicerrectorado actaAprobacionVicerrectoradoSelected) {
        this.actaAprobacionVicerrectoradoSelected = actaAprobacionVicerrectoradoSelected;
    }

    public void imprimirActa(ActaAprobacionVicerrectorado acta) {
        imprimirActa(JasperReportUtil.TIPO_PDF, acta);
    }

    private void imprimirActa(String tipoReporte, ActaAprobacionVicerrectorado acta) {
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            parametros.put("idActa", acta.getId());
            /*parametros.put("idActa", acta.getId());
            parametros.put("idActa", acta.getId());
            parametros.put("idActa", acta.getId());
            parametros.put("idActa", acta.getId());*/
            Calendar cal = Calendar.getInstance();
            String fechaActual = String.valueOf(cal.get(Calendar.DATE)) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
            parametros.put("fechaActual", fechaActual);
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            List<ActaAprobacionVicerrectorado> listaActas = new ArrayList<>();
            listaActas.add(acta);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_ACTA_APROBACION_VICERRECTORADO, tipoReporte, parametros, listaActas);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void grabarActa() {
        try {
            actaAprobacionVicerrectoradoFacade.edit(actaAprobacionVicerrectoradoSelected);
            cancelarActa();
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

    public void cancelarActa() {
        actaAprobacionVicerrectoradoSelected = null;
        actaAprobacionVicerrectoradoList = actaAprobacionVicerrectoradoFacade.findAll();
    }

    public void subirDocActaFirmas(FileUploadEvent event) {
        try {
            String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "aprobacion_vicerrectorado";
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + actaAprobacionVicerrectoradoSelected.getId();
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            actaAprobacionVicerrectoradoSelected.setDocumentoFirmadoNombre(event.getFile().getFileName());
            actaAprobacionVicerrectoradoSelected.setDocumentoFirmadoUrl("/" + carpetaAdjuntos.replace("\\", "/") + "/" + actaAprobacionVicerrectoradoSelected.getId() + "/");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }

    }

    public void prepararActaDownload(ActaAprobacionVicerrectorado acta) {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("") + separatorChar + acta.getDocumentoUrlFinal();
            this.archivoActaAprobacion = new DefaultStreamedContent(new ByteArrayInputStream(Files.readAllBytes(Paths.get(path))), "application/octet-stream", acta.getDocumentoFirmadoNombre());
        } catch (Exception e) {

        }
    }
    private StreamedContent archivoActaAprobacion;

    public StreamedContent getArchivoActaAprobacion() {
        return archivoActaAprobacion;
    }

    public void setArchivoActaAprobacion(StreamedContent archivoActaAprobacion) {
        this.archivoActaAprobacion = archivoActaAprobacion;
    }

    private String estadoAprobacionVicerrectorado;

    public String getEstadoAprobacionVicerrectorado() {
        return estadoAprobacionVicerrectorado;
    }

    public void setEstadoAprobacionVicerrectorado(String estadoAprobacionVicerrectorado) {
        this.estadoAprobacionVicerrectorado = estadoAprobacionVicerrectorado;
    }
    
    

    public ActaAprobacionVicerrectoradoFacade getActaAprobacionVicerrectoradoFacade() {
        return actaAprobacionVicerrectoradoFacade;
    }

    public void setActaAprobacionVicerrectoradoFacade(ActaAprobacionVicerrectoradoFacade actaAprobacionVicerrectoradoFacade) {
        this.actaAprobacionVicerrectoradoFacade = actaAprobacionVicerrectoradoFacade;
    }

    public void onChangeEstado() {
        proyectoList = new ArrayList<>();
        for (Proyecto p : proyectoTodosList) {
            if (p.getEstadoAprobVicerrectorado().equals(estadoAprobacionVicerrectorado)) {
                proyectoList.add(p);
            }
        }
    }

    
    public boolean isPermitirGenerarActa() {
        for (Proyecto p : proyectoList) {
            if (!p.getEstadoAprobVicerrectorado().equals("P") && p.getActaAprobacionVicerrectorado()==null) {
                return true;
            }
        }
        return false;
    }
    public boolean isPermitirAprobacion() {
        for (Proyecto p : proyectoList) {
            if (p.getEstadoAprobVicerrectorado().equals("P")) {
                return true;
            }
        }
        return false;

    }
    public void eliminarActa(ActaAprobacionVicerrectorado acta) {
        try {
            for (Proyecto p : acta.getProyectoList()) {
                p.setActaAprobacionVicerrectorado(null);
                proyectoFacade.edit(p);
            }
            actaAprobacionVicerrectoradoFacade.remove(acta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
            cancelarAprobacion();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible eliminar el registro seleccionado"));
        }
    }
    
     /*public void postProcessXLSX(Object document) {
        XSSFWorkbook wb = (XSSFWorkbook) document;
        XSSFSheet sheet = wb.getSheetAt(0);
        sheet.setColumnWidth(1, 1);
        sheet.setColumnWidth(2, 1);
        XSSFRow header = sheet.getRow(0);
    }*/
     public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header;
        sheet.setColumnWidth(1, 20000);
        sheet.setColumnWidth(2, 20000);
        sheet.setColumnWidth(3, 10000);
        sheet.setColumnWidth(4, 20000);
        sheet.setColumnWidth(5, 10000);
        sheet.setColumnWidth(6, 10000);
        sheet.setColumnWidth(7, 10000);
        sheet.setColumnWidth(8, 5000);
        sheet.setColumnWidth(9, 5000);
        sheet.setColumnWidth(10, 5000);
        sheet.setColumnWidth(11, 5000);
        sheet.setColumnWidth(12, 5000);
        sheet.setColumnWidth(13, 5000);
        sheet.setColumnWidth(14, 5000);
        sheet.setColumnWidth(15, 5000);
        sheet.setColumnWidth(16, 5000);
        sheet.setColumnWidth(17, 5000);
        sheet.setColumnWidth(18, 5000);
        sheet.setColumnWidth(19, 5000);
        sheet.setColumnWidth(20, 5000);


        HSSFCellStyle cellStyle = wb.createCellStyle();  
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    }   
}
