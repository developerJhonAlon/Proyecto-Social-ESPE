/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

//<editor-fold defaultstate="collapsed" desc="Import">
import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.MiembroComisionCalificacion;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.session.ProyectoFacade;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.session.SeaParametrosDetFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

//</editor-fold>
/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ListadoProyectosEvaluacionComisionController implements Serializable {
//<editor-fold defaultstate="collapsed" desc="Constructor">

    public ListadoProyectosEvaluacionComisionController() {

    }

    //</editor-fold>
    @EJB
    private ProyectoFacade proyectoFacade;
    @EJB
    private SeaParametrosDetFacade parametrosDetFacade;
    private List<SeaParametrosDet> estadoList;
    private SegUsuario usuarioActual;

//<editor-fold defaultstate="collapsed" desc="Init">
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        estadoList = parametrosDetFacade.findByCodigoParametro(SeaParametros.PARAM_ESTADO_PROYECTO_VINCULACION);
        listarProyectos();
    }
   
    private List<Proyecto> proyectoList;

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public void listarProyectos() {
        List<Proyecto> temp = proyectoFacade.findByProgramaEstado(null, null);
        proyectoList = new ArrayList<>();

        for (Proyecto proy : temp) {
            if (proy.getComisionCalificacion() != null && !proy.isEstadoIngresoPerfil() && !proy.isEstadoEnviadoRevision()) {
                for (MiembroComisionCalificacion m : proy.getComisionCalificacion().getMiembroList()) {
                    if (m.getEstado().equals(MiembroComisionCalificacion.ESTADO_ACTIVO) && m.getUsuario().equals(usuarioActual)) {
                        proy.setUsuarioActual(usuarioActual);
                        proyectoList.add(proy);
                        break;
                    }
                }
            }
        }
    }

    public List<SeaParametrosDet> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<SeaParametrosDet> estadoList) {
        this.estadoList = estadoList;
    }

   

    
   
}
