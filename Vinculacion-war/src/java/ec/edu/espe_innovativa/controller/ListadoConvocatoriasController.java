/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.Convocatoria;
import ec.edu.espe_ctt.vinculacion.entity.IndicadorEstrategiaProyecto;
import ec.edu.espe_ctt.vinculacion.session.ConvocatoriaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ListadoConvocatoriasController implements Serializable {
    @EJB
    private ConvocatoriaFacade convocatoriaFacade;
    private List<Convocatoria> convocatoriaList;

    public ListadoConvocatoriasController() {
    }

    @PostConstruct
    public void init() {
        convocatoriaList = convocatoriaFacade.findAll();
    }

    public List<Convocatoria> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<Convocatoria> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }
    
    public void eliminarConvocatoria() {
        try {
            convocatoriaFacade.remove(convocatoriaSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente"));
        } catch (Exception e) {
            try {
                Throwable t = (Throwable) e;
                while (t.getCause() != null) {
                    t = t.getCause();
                }
                String msgError = "No fue posible eliminar la convocatoria seleccionada";
                String controlMsgError = null;
                if (t.getMessage().toUpperCase().contains("ORA-02292")) {
                    msgError = msgError + ", porque existen proyectos registrados para esta convocatoria";
                }
                FacesContext.getCurrentInstance().addMessage(controlMsgError, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msgError));
            } catch (Exception e2) {
            }
        }
        finally{
            convocatoriaList = convocatoriaFacade.findAll();
        }
    }    
    private Convocatoria convocatoriaSelected;

    public Convocatoria getConvocatoriaSelected() {
        return convocatoriaSelected;
    }

    public void setConvocatoriaSelected(Convocatoria convocatoriaSelected) {
        this.convocatoriaSelected = convocatoriaSelected;
    }
    
}
