/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import ec.edu.espe_ctt.vinculacion.entity.TipoResponsable;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "busquedaDocenteController2")
@ViewScoped
public class BusquedaDocenteController2 implements Serializable {

    @EJB
    private VDocenteVinculacion2Facade docenteFacade;
    private Proyecto proyectoSelected;
    @EJB
    private ProyectoFacade proyectoFacade;
    private Integer tipoResponsable;
    
    private String idCampus;
    private String idDepartamento;
    private List<VDocenteVinculacion2> docentes;
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
        docentes = docenteFacade.findByFiltro(-1, -1, null, null, null, idCampus, idDepartamento);        
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

    public List<VDocenteVinculacion2> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<VDocenteVinculacion2> docentes) {
        this.docentes = docentes;
    }
    

    
}
