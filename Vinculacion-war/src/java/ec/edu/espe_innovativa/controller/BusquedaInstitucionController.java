/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.Institucion;
import ec.edu.espe_ctt.vinculacion.session.InstitucionFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "busquedaInstitucionController")
@ViewScoped
public class BusquedaInstitucionController implements Serializable {

    @EJB
    private InstitucionFacade institucionFacade;
    private List<Institucion> institucionList;

    @PostConstruct
    public void init() {
        institucionList = institucionFacade.findByActivo();
    }

    public InstitucionFacade getInstitucionFacade() {
        return institucionFacade;
    }

    public void setInstitucionFacade(InstitucionFacade institucionFacade) {
        this.institucionFacade = institucionFacade;
    }

    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    public void seleccionarInsitucion(Institucion institucion) {
        RequestContext.getCurrentInstance().closeDialog(institucion);
    }

}
