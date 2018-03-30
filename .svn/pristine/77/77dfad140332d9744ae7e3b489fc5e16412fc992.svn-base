/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import ec.edu.espe_ctt.vinculacion.entity.VEstudiante;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.VistaEstudianteFacade;
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

@ManagedBean(name = "busquedaEstudianteController")
@ViewScoped
public class BusquedaEstudianteController extends LazyDataModel<VEstudiante> implements Serializable {

    @EJB
    private VistaEstudianteFacade estudianteFacade;
    @EJB
    private ProyectoFacade proyectoFacade;
    private Proyecto proyectoSelected;

    @PostConstruct
    public void init() {
        Object idProyecto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProyecto");
        proyectoSelected = proyectoFacade.findById(Integer.valueOf(idProyecto.toString()));
    }

    @Override
    public List<VEstudiante> load(
            int first, int pageSize,
            String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {
        List<VEstudiante> estudiantes = estudianteFacade.findByFiltro(first, pageSize, sortField, sortOrder, filters);
        setRowCount(estudianteFacade.count(filters));
        return estudiantes;
    }

    public void selectEstudianteFromDialog(VEstudiante estudiante) {
        for (ResponsableProyecto resp : proyectoSelected.getParticipanteEstudianteList()) {
            if (resp.getUsuario().equals(estudiante.getUsuario()) && resp.getCarrera().equals(estudiante.getCarrera()) && resp.getDepartamento().equals(estudiante.getDepartamento())) {
                FacesContext.getCurrentInstance().addMessage("j_idt6:txtCedula", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El estudiante seleccionado ya se encuentra asignado al proyecto."));
                return;
            }
        }
        RequestContext.getCurrentInstance().closeDialog(estudiante);
    }

    /*private LazyDataModel<VEstudiante> model;

    public LazyDataModel<VEstudiante> getModel() {
        try {
            this.model = new LazyDataModel<VEstudiante>() {
                private static final long serialVersionUID = 1L;

                public List<VEstudiante> load(
                        int first, int pageSize,
                        String sortField, SortOrder sortOrder,
                        Map<String, Object> filters) {
                    List<VEstudiante> users = estudianteFacade.findByFiltro(first, pageSize, sortField, sortOrder, filters);
                    setRowCount(estudianteFacade.count(filters));
                    return users;
                }
            };
        } catch (Exception e) {
        }
        return model;
    }

    public void setModel(LazyDataModel<VEstudiante> model) {
        this.model = model;
    }
*/
}
