/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.CellEditEvent;



/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class EstadoProyectoController implements Serializable {
    
    @EJB
    private ProyectoFacade proyectoFacade;
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    
  
    private List<Proyecto> proyectoList;
     
    /** Creates a new instance of ControlarProyectoController */
    public EstadoProyectoController() {
      
    }

    public List<Proyecto> getProyectoList() {
        return proyectoFacade.findAll();
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }
    
    public void onCellEdit(CellEditEvent event){
        Object idProyecto = event.getRowKey();
        Object oldValue = event.getRowIndex();
        Object newValue = event.getNewValue();
        Proyecto proy = proyectoList.get(event.getRowIndex());
        SeaParametrosDet parametroEstado = parametrosDetFacade.find((Long)event.getNewValue());
        proy.setEstado(parametroEstado);
        //proyectoFacade.edit(proy);
        
        System.out.println("ID VALUE: "+idProyecto.toString());
        System.out.println("OLD VALUE: "+oldValue.toString());
        System.out.println("NEW VALUE: "+newValue.toString());
    
    }
    
    public List<SeaParametrosDet> getEstadoList() {
        return parametrosDetFacade.findByCodigoParametroActivos(SeaParametros.PARAM_ESTADO_PROYECTO_VINCULACION);
     
    }
    
}
