/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.Convocatoria;
import ec.edu.espe_ctt.vinculacion.session.ConvocatoriaFacade;
import static java.io.File.separatorChar;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ConvocatoriaController implements Serializable {

    private boolean modoEdicion;

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public void agregarConvocatoria(ActionEvent event) {
        convocatoriaSelected = new Convocatoria();
        modoEdicion = true;
    }

    private Convocatoria convocatoriaSelected;
    private List<Convocatoria> convocatoriaList;

    public List<Convocatoria> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<Convocatoria> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    public Convocatoria getConvocatoriaSelected() {
        return convocatoriaSelected;
    }

    public void setConvocatoriaSelected(Convocatoria convocatoriaSelected) {
        this.convocatoriaSelected = convocatoriaSelected;
    }
    @EJB
    private ConvocatoriaFacade convocatoriaFacade;

    public String seleccionarConvocatoria() {
        //prepararArchivoDownload(convocatoriaSelected);
        modoEdicion = true;
        return "";
    }

    public void cancelarEdicion() {
        modoEdicion = false;
        convocatoriaList = convocatoriaFacade.findAll();
    }

    public String grabar() {
        try {
            boolean datosValidos = true;
            if (!convocatoriaSelected.getFechaFin().after(convocatoriaSelected.getFechaInicio())) {
                FacesContext.getCurrentInstance().addMessage("formPrincipal:txtFechaFin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de finalización debe ser mayor que la fecha de inicio"));
                datosValidos = false;
            }
            for (Convocatoria convocatoria : convocatoriaList) {
                if (convocatoriaSelected.getId() == null || !convocatoriaSelected.getId().equals(convocatoria.getId())) {
                    if ((!convocatoriaSelected.getFechaInicio().before(convocatoria.getFechaInicio())
                            && !convocatoriaSelected.getFechaInicio().after(convocatoria.getFechaFin()))
                            || (!convocatoriaSelected.getFechaFin().before(convocatoria.getFechaInicio())
                            && !convocatoriaSelected.getFechaFin().after(convocatoria.getFechaFin()))) {
                        FacesContext.getCurrentInstance().addMessage("formPrincipal:txtFechaInicio", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El período (fecha inicio-fecha fin) ingresado se encuentra dentro del período de otra convocatoria existente"));
                        datosValidos = false;
                    }
                }
            }
            if (datosValidos) {
                if (convocatoriaSelected.getId() == null) {
                    convocatoriaFacade.create(convocatoriaSelected);
                    String carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "bases_convocatorias";
                    convocatoriaSelected.setUrlDocumento("/" + carpetaAdjuntos.replace("\\", "/") + "/" + convocatoriaSelected.getId() + "/");
                    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                    String pathOriginal = servletContext.getRealPath("") + separatorChar + "temp" + separatorChar + idTempConvocatoria + separatorChar + convocatoriaSelected.getNombreDocumento();
                    String pathFinal = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + convocatoriaSelected.getId();
                    if (!Files.isDirectory(Paths.get(pathFinal))) {
                        Files.createDirectories(Paths.get(pathFinal));
                    }
                    pathFinal = pathFinal + separatorChar + convocatoriaSelected.getNombreDocumento();
                    Files.move(Paths.get(pathOriginal), Paths.get(pathFinal));
                }
                convocatoriaFacade.edit(convocatoriaSelected);
                convocatoriaList = convocatoriaFacade.findAll();
                modoEdicion = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
                RequestContext.getCurrentInstance().update("formPrincipal:panelBase");
                FacesContext.getCurrentInstance().getExternalContext().redirect("listadoConvocatorias.xhtml");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible grabar la información ingresada"));
            RequestContext.getCurrentInstance().update("formPrincipal:message1");
        }
        return "";
    }

    private String idTempConvocatoria;

    public void subirArchivo(FileUploadEvent event) {
        try {
            /*byte[] doc = IOUtils.toByteArray(event.getFile().getInputstream());
            convocatoriaSelected.setDocumento(doc);
            convocatoriaSelected.setNombreDocumento(event.getFile().getFileName());
            prepararArchivoDownload(convocatoriaSelected);*/

            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = "";
            if (convocatoriaSelected.getId() != null) {
                String carpetaAdjuntos = "";
                carpetaAdjuntos = "documentos_adjuntos" + separatorChar + "bases_convocatorias";
                path = servletContext.getRealPath("") + separatorChar + carpetaAdjuntos + separatorChar + convocatoriaSelected.getId();
                convocatoriaSelected.setUrlDocumento("/" + carpetaAdjuntos.replace("\\", "/") + "/" + convocatoriaSelected.getId() + "/");
            } else {
                Date temp = new Date();
                idTempConvocatoria = "tmp" + temp.getTime();
                path = servletContext.getRealPath("") + separatorChar + "temp" + separatorChar + idTempConvocatoria;
                convocatoriaSelected.setUrlDocumento("/temp/" + idTempConvocatoria + "/");
            }
            if (!Files.isDirectory(Paths.get(path))) {
                Files.createDirectories(Paths.get(path));
            }
            path = path + separatorChar + event.getFile().getFileName();
            Files.copy(event.getFile().getInputstream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            convocatoriaSelected.setNombreDocumento(event.getFile().getFileName());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cargar el archivo seleccionado"));
        }

    }

    private StreamedContent archivo;

    public StreamedContent getArchivo() {
        return archivo;
    }

    public void setArchivo(StreamedContent archivo) {
        this.archivo = archivo;
    }

    /*public void prepararArchivoDownload(Convocatoria convocatoria) {
        byte[] conteudo = convocatoria.getDocumento();
         String nom = convocatoria.getNombreDocumento();
         //this.archivo = new DefaultStreamedContent(new ByteArrayInputStream(conteudo), "application/octet-stream", nom);
         this.archivo = new DefaultStreamedContent(new ByteArrayInputStream(conteudo), "application/pdf", nom);
    }*/
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    //</editor-fold>
    public ConvocatoriaController() {
    }

    @PostConstruct
    public void init() {
        convocatoriaList = convocatoriaFacade.findAll();
        Object idConvocatoria = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idConvocatoria");
        if (idConvocatoria != null) {
            convocatoriaSelected = convocatoriaFacade.find(new BigDecimal(idConvocatoria.toString()));
        } else {
            convocatoriaSelected = new Convocatoria();
        }
    }
}
