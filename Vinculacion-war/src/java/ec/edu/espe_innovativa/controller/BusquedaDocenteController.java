/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import ec.edu.espe_ctt.vinculacion.entity.TipoResponsable;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.entity.VEstudiante;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "busquedaDocenteController")
@ViewScoped
public class BusquedaDocenteController extends LazyDataModel<VDocenteVinculacion2> implements Serializable {

    @EJB
    private VDocenteVinculacion2Facade docenteFacade;
    private Proyecto proyectoSelected;
    @EJB
    private ProyectoFacade proyectoFacade;
    private Integer tipoResponsable;
    
    private String idCampus;
    private String idDepartamento;

    @PostConstruct
    public void init() {
        Object idProyecto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProyecto");
        if (idProyecto != null) {
            proyectoSelected = proyectoFacade.findById(Integer.valueOf(idProyecto.toString()));
        }
        Object tipoResp = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tipoResponsable");
        if (tipoResp != null) {
            tipoResponsable = Integer.valueOf(tipoResp.toString());
        }
        Object idCamp = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCampus");
        if (idCamp != null) {
            idCampus = idCamp.toString();
        }
        Object idDep = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idDepartamento");
        if (idDep != null) {
            idDepartamento = idDep.toString();
        }
        
    }

    @Override
    public List<VDocenteVinculacion2> load(
            int first, int pageSize,
            String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {
        List<VDocenteVinculacion2> docentes = docenteFacade.findByFiltro(first, pageSize, sortField, sortOrder, filters, idCampus, idDepartamento);
        setRowCount(docenteFacade.count(filters, idCampus, idDepartamento));
        return docentes;
    }
    
    public void selectDocenteFromDialog(VDocenteVinculacion2 docente) {
        if (docente ==null && proyectoSelected != null && tipoResponsable != null && tipoResponsable.equals(TipoResponsable.TIPO_PARTICIPANTE_DOCENTE)) {
            for (ResponsableProyecto resp : proyectoSelected.getParticipanteDocenteList()) {
                if (resp.getUsuario().getUsuId().equals(docente.getUsuario().getUsuId())) {
                    FacesContext.getCurrentInstance().addMessage("j_idt6:txtCedula", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El docente ya se encuentra asignado al proyecto."));
                    return;
                }
            }
        }
        RequestContext.getCurrentInstance().closeDialog(docente);
    }

    public String getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(String idCampus) {
        this.idCampus = idCampus;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    
}
