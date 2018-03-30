/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.CatalogoCobertura;
import ec.edu.espe_ctt.vinculacion.session.CatalogoCoberturaFacade;
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
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class matenimientoCoberturaController implements Serializable {

    @EJB
    private CatalogoCoberturaFacade catalogoCoberturaFacade;
    private CatalogoCobertura catalogoCobertura;
    private List<CatalogoCobertura> catalogoCoberturaList;

    @PostConstruct   /// una solo vez se ejecuta antes 
    public void init() {
        /// cargar el listado de todas las coberturas y se ejacuta una sola vez

        catalogoCoberturaList = catalogoCoberturaFacade.findAll();

    }

    public List<CatalogoCobertura> getCatalogoCoberturaList() {
        return catalogoCoberturaList;
    }

    public void setCatalogoCoberturaList(List<CatalogoCobertura> catalogoCoberturaList) {
        this.catalogoCoberturaList = catalogoCoberturaList;
    }

    public CatalogoCobertura getCatalogoCobertura() {
        return catalogoCobertura;
    }

    public void setCatalogoCobertura(CatalogoCobertura catalogoCobertura) {
        this.catalogoCobertura = catalogoCobertura;
    }

    public void grabarCobertura() {
        try {
            if (catalogoCobertura.getId() == null) {
                catalogoCoberturaFacade.create(catalogoCobertura);
            } else {
                catalogoCoberturaFacade.edit(catalogoCobertura);
            }
            /// cargar el listado de todas las coberturas y cada vez que grabemos
            catalogoCoberturaList = catalogoCoberturaFacade.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información " + catalogoCobertura.getDescripcion() + " se guardó exitosamente"));
            catalogoCobertura = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errorrr", "No fue posible grabar la información ingresada"));

        }
    }

    public void agregarCobertura() {
        catalogoCobertura = new CatalogoCobertura();   /// inicializar variable
    }

    public void cancelarCobertura() {
        catalogoCobertura = null;
    }

    public void eliminarCobertura(CatalogoCobertura catalogoCobertura) {

        try {
            catalogoCoberturaFacade.remove(catalogoCobertura);
            //Este metodo se muestra un listado de todos almacenado en la base despues de eliminar 
            catalogoCoberturaList = catalogoCoberturaFacade.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El catalogo " + catalogoCobertura.getDescripcion() + " se eliminó exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errorrr", "No fue posible eliminar la información ingresada"));

        }
    }

    public void editarCobertura(CatalogoCobertura catalogoSeleccionado) {
        catalogoCobertura = catalogoSeleccionado;

    }
}
