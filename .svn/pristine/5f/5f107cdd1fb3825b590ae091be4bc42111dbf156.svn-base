/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.saturno.session.StvcampFacade;
import ec.edu.espe_ctt.saturno.session.StvmajrFacade;
import ec.edu.espe_ctt.saturno.session.StvsubjFacade;
import ec.edu.espe_ctt.vinculacion.entity.AspectoEvaluacionFinal;
import ec.edu.espe_ctt.vinculacion.entity.CarreraPrograma;
import ec.edu.espe_ctt.vinculacion.entity.Cobertura;
import ec.edu.espe_ctt.vinculacion.entity.ConfiguracionParametrosEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.DetalleEvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Estado;
import ec.edu.espe_ctt.vinculacion.entity.EvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.LocalizacionPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.ProgramaReporte;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import ec.edu.espe_ctt.vinculacion.entity.VDirectorDepartamento;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.session.ConfiguracionParametrosEvaluacionFacade;
import ec.edu.espe_ctt.vinculacion.session.ProgramaFacade;
import ec.edu.espe_ctt.vinculacion.session.VDirectorDepartamentoFacade;
import ec.edu.espe_ctt.vinculacion.session.VDocenteVinculacion2Facade;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.session.SeaCantonFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParroquiaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProvinciaFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.data.SortEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class ReportesProgramasController implements Serializable {

    @EJB
    private StvcampFacade sedesFacade;

    @EJB
    private VDirectorDepartamentoFacade vDirectorDepartamentoFacade;
    @EJB
    private SeaProvinciaFacade provinciasFacade;
    @EJB
    private SeaCantonFacade cantonesFacade;
    @EJB
    private SeaParroquiaFacade parroquiasFacade;
    @EJB
    private VDocenteVinculacion2Facade vistaDocenteFacade;
    @EJB
    private StvmajrFacade carrerasFacade;
    @EJB

    private ProgramaFacade programaFacade;

    @EJB
    private StvsubjFacade departamentoFacade;
    private List<Stvsubj> departamentos;
    private List<Stvmajr> carreras;
    private Date fechaDesde;
    private Date fechaHasta;
    private List<SeaProvincia> provincias;
    private List<SeaCanton> cantones;
    private List<SeaParroquia> parroquias;
    private List<Cobertura> coberturaList;
    private List<Programa> programas;
    private List<Stvcamp> sedes;
    private List<Estado> estadoList;
    private List<Stvcamp> campusList;
    private ConfiguracionParametrosEvaluacion configuracionParametrosEvaluacionFinal;

    public ReportesProgramasController() {
    }

    @PostConstruct
    public void init() {
        campusList = new ArrayList<>();
        List<VDirectorDepartamento> vDirectorDepartamentoList = vDirectorDepartamentoFacade.findAll();
        for (VDirectorDepartamento dir : vDirectorDepartamentoList) {
            if (dir.getCampus() != null) {
                boolean encontro = false;
                for (Stvcamp camp : campusList) {
                    if (camp.equals(dir.getCampus())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    campusList.add(dir.getCampus());
                }
            }

        }
        Collections.sort(campusList);
        this.departamentos = departamentoFacade.findAll();
        this.programas = programaFacade.findXEstado("");
        this.carreras = carrerasFacade.findAll();
        this.sedes = sedesFacade.findAll();
        this.provincias = provinciasFacade.findAll();
        this.cantones = cantonesFacade.findAll();
        this.parroquias = parroquiasFacade.findAll();

        coberturaList = new ArrayList<>();
        coberturaList.add(new Cobertura("1", "Nacional"));
        coberturaList.add(new Cobertura("2", "Provincial"));
        coberturaList.add(new Cobertura("3", "Cantonal"));
        coberturaList.add(new Cobertura("4", "Parroquial"));

        estadoList = new ArrayList<>();
        estadoList.add(new Estado("CRE", "INGRESO DE PERFIL"));
        estadoList.add(new Estado("CEP", "SEGUIMIENTO"));
        estadoList.add(new Estado("CES", "EN CIERRE"));
        estadoList.add(new Estado("CER", "EN EVALUACION"));
        estadoList.add(new Estado("EVA", "EVALUADO"));

        visualizarDirector = true;
        visualizarCampus = true;
        visualizarDepartamento = true;
        visualizarEstado = true;
        visualizarFechaInicio = true;
        visualizarFechaFinalizacion = true;
        configuracionParametrosEvaluacionFinal= configuracionParametrosEvaluacionFacade.findXEvaluacionFinalAndActivo();
    }

    private List<Programa> programaList;
    private List<ProgramaReporte> programasReporteList;

    public Boolean verificarFiltro(Integer filtroReporte) {
        switch (filtroReporte) {
            case 1:
                for (Programa p : programas) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 2:
                for (Estado p : estadoList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 3:
                for (Stvmajr p : carreras) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 4:
                for (Cobertura p : coberturaList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 5:
                for (SeaProvincia p : provincias) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 6:
                for (SeaCanton p : cantones) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 7:
                for (SeaParroquia p : parroquias) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 8:
                for (Stvcamp p : campusList) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;
            case 9:
                for (Stvsubj p : departamentos) {
                    if (p.getSelected() != null && p.getSelected()) {
                        return true;
                    }
                }
                break;

        }
        return false;
    }

    public String getFiltroReporteStr() {
        switch (filtroReporte) {
            case 1:
                return "Programa";
            case 2:
                return "Estado";
            case 3:
                return "Carrera";
            case 4:
                return "Cobertura";
            case 5:
                return "Provincia";
            case 6:
                return "Cantón";
            case 7:
                return "Parroquia";
            case 8:
                return "Campus";
            case 9:
                return "Departamento";

            default:
                break;
        }
        return "";
    }

    private boolean visualizarTodos;
    private boolean visualizarEstado;
    private boolean visualizarFechaInicio;
    private boolean visualizarFechaFinalizacion;
    private boolean visualizarDirector;
    private boolean visualizarCampus;
    private boolean visualizarDepartamento;
    private boolean visualizarCampusParticipante;
    private boolean visualizarDepartamentoParticipante;
    private boolean visualizarCobertura;
    private boolean visualizarProyectos;
    private boolean visualizarCarrera;
    private boolean visualizarProvincia;
    private boolean visualizarCanton;
    private boolean visualizarParroquia;
    private boolean visualizarEvaluacionFinal;
    private boolean visualizarBeneficiarios;
    private boolean visualizarPresupuesto;

    public List<Stvmajr> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Stvmajr> carreras) {
        this.carreras = carreras;
    }

    public boolean isVisualizarEvaluacionFinal() {
        return visualizarEvaluacionFinal;
    }

    public void setVisualizarEvaluacionFinal(boolean visualizarEvaluacionFinal) {
        this.visualizarEvaluacionFinal = visualizarEvaluacionFinal;
    }

    public boolean isVisualizarBeneficiarios() {
        return visualizarBeneficiarios;
    }

    public void setVisualizarBeneficiarios(boolean visualizarBeneficiarios) {
        this.visualizarBeneficiarios = visualizarBeneficiarios;
    }

    public boolean isVisualizarPresupuesto() {
        return visualizarPresupuesto;
    }

    public void setVisualizarPresupuesto(boolean visualizarPresupuesto) {
        this.visualizarPresupuesto = visualizarPresupuesto;
    }

    
    
    public boolean isVisualizarCampus() {
        return visualizarCampus;
    }

    public void setVisualizarCampus(boolean visualizarCampus) {
        this.visualizarCampus = visualizarCampus;
    }

    public boolean isVisualizarDepartamento() {
        return visualizarDepartamento;
    }

    public void setVisualizarDepartamento(boolean visualizarDepartamento) {
        this.visualizarDepartamento = visualizarDepartamento;
    }

    public boolean isVisualizarProvincia() {
        return visualizarProvincia;
    }

    public void setVisualizarProvincia(boolean visualizarProvincia) {
        this.visualizarProvincia = visualizarProvincia;
    }

    public boolean isVisualizarCanton() {
        return visualizarCanton;
    }

    public void setVisualizarCanton(boolean visualizarCanton) {
        this.visualizarCanton = visualizarCanton;
    }

    public boolean isVisualizarParroquia() {
        return visualizarParroquia;
    }

    public void setVisualizarParroquia(boolean visualizarParroquia) {
        this.visualizarParroquia = visualizarParroquia;
    }

    public boolean isVisualizarProyectos() {
        return visualizarProyectos;
    }

    public void setVisualizarProyectos(boolean visualizarProyectos) {
        this.visualizarProyectos = visualizarProyectos;
    }

    private ParametroEvaluacion crearParametroEvaluacionMatrizMarcoLogico(ObjetivoPrograma obj) {
        ParametroEvaluacion par = new ParametroEvaluacion();
        par.setIdAspectoEvaluacion(AspectoEvaluacionFinal.TIPO_MATRIZ_MARCO_LOGICO);
        par.setObjetivoPrograma(obj);
        if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_FIN)) {
            par.setDescripcion("FIN: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_PROPOSITO)) {
            par.setDescripcion("OBJETIVO GENERAL: " + obj.getSvopObjetivoProy());
        } else if (obj.getSvopTipo().equals(ObjetivoPrograma.TIPO_COMPONENTE)) {
            par.setDescripcion("COMPONENTE: " + obj.getSvopObjetivoProy());
        } else {
            par.setDescripcion("ACTIVIDAD: " + obj.getSvopObjetivoProy());
        }

        for (int i = 0; i <= 5; i++) {
            ValoracionParametroEvaluacion val = new ValoracionParametroEvaluacion();
            val.setId(i);
            val.setDescripcion(String.valueOf(i));
            val.setPuntaje(i);
            par.addValoracion(val);
        }
        return par;
    }
    @EJB
    private ConfiguracionParametrosEvaluacionFacade configuracionParametrosEvaluacionFacade;

    private ProgramaReporte crearObjetoReportePrograma(Programa programa) {
        ProgramaReporte reportePrograma = new ProgramaReporte();
        reportePrograma.setId(programa.getId());

        reportePrograma.setNombre(programa.getNombre().toUpperCase());
        reportePrograma.setEstado(new Estado(programa.getEstado(), programa.getEstadoStr().toUpperCase()));
        reportePrograma.setCobertura(programa.getCoberturaStr().toUpperCase());
        reportePrograma.setCampus(programa.getCampus());
        reportePrograma.setDepartamento(programa.getDepartamento());
        VDocenteVinculacion2 doc = vistaDocenteFacade.findByUsuId(programa.getDirector().getUsuario().getUsuId());
        ResponsableProyecto director = new ResponsableProyecto();
        director.setUsuario(doc.getUsuario());
        director.setCampus(doc.getCampus());
        director.setDepartamento(doc.getDepartamento());
        reportePrograma.setDirector(director);
        reportePrograma.setFechaInicio(programa.getFechaInicio());
        reportePrograma.setFechaFinalizacion(programa.getFechaFin());

        Integer puntajePertinencia = 0;
        Integer puntajeEficacia = 0;
        Integer puntajeEficiencia = 0;
        Integer puntajeSostenibilidad = 0;
        Integer puntajeMaximoPertinencia = 0;
        Integer puntajeMaximoEficacia = 0;
        Integer puntajeMaximoEficiencia = 0;
        Integer puntajeMaximoSostenibilidad = 0;
        
        Integer nroBeneficiariosDirectosHombres = 0;
        Integer nroBeneficiariosDirectosMujeres = 0;
        Integer nroBeneficiariosDirectosNinios = 0;
        Integer nroBeneficiariosDirectosDiscapac = 0;
        Integer nroBeneficiariosIndirectos = 0;
        Integer nroBeneficiariosDirectosHombresEjec = 0;
        Integer nroBeneficiariosDirectosMujeresEjec = 0;
        Integer nroBeneficiariosDirectosNiniosEjec = 0;
        Integer nroBeneficiariosDirectosDiscapacEjec = 0;
        Integer nroBeneficiariosIndirectosEjec = 0;
        
        BigDecimal presupuestoPlanificado= BigDecimal.ZERO;
        BigDecimal presupuestoEjecutado= BigDecimal.ZERO;
        
        
        for (Proyecto proy : programa.getProyectoActivoList()) {
            if (proy.isEstadoFinalizado()) {
                puntajePertinencia+= proy.getEvaluacionFinal().getPuntajeEvaluacionFinalPertinencia();
                puntajeMaximoPertinencia+= proy.getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalPertinencia();
                puntajeEficacia+= proy.getEvaluacionFinal().getPuntajeEvaluacionFinalEficacia();
                puntajeMaximoEficacia+= proy.getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalEficacia();
                puntajeEficiencia+= proy.getEvaluacionFinal().getPuntajeEvaluacionFinalEficiencia();
                puntajeMaximoEficiencia+= proy.getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalEficiencia();
                puntajeSostenibilidad+= proy.getEvaluacionFinal().getPuntajeEvaluacionFinalSostenibilidad();
                puntajeMaximoSostenibilidad+= proy.getEvaluacionFinal().getPuntajeMaximoEvaluacionFinalSostenibilidad();
            }
            if (proy.isEstadoEvaluacionFinal() || proy.isEstadoFinalizado()){
                nroBeneficiariosDirectosHombres+=proy.getNroBeneficiariosDirectosHombres();
                nroBeneficiariosDirectosMujeres+=proy.getNroBeneficiariosDirectosMujeres();
                nroBeneficiariosDirectosNinios+=proy.getNroBeneficiariosDirectosNinios();
                nroBeneficiariosDirectosDiscapac+=proy.getNroBeneficiariosDirectosDiscapac();
                if (proy.getNroBeneficiariosIndirectos()!=null){
                    nroBeneficiariosIndirectos+=proy.getNroBeneficiariosIndirectos();
                }
                nroBeneficiariosDirectosHombresEjec+=proy.getTotalBeneficiariosDirectosEjecutadosHombres();
                nroBeneficiariosDirectosMujeresEjec+=proy.getTotalBeneficiariosDirectosEjecutadosMujeres();
                nroBeneficiariosDirectosNiniosEjec+=proy.getTotalBeneficiariosDirectosEjecutadosNinios();
                nroBeneficiariosDirectosDiscapacEjec+=proy.getTotalBeneficiariosDirectosEjecutadosDiscapacidad();
                nroBeneficiariosIndirectosEjec+=proy.getTotalBeneficiariosIndirectosEjecutados();
                
                presupuestoPlanificado=presupuestoPlanificado.add(proy.getTotalPresupuesto());
                presupuestoEjecutado=presupuestoEjecutado.add(proy.getTotalPresupuestoEjecutado());
            }
        }
        reportePrograma.setPuntajePertinencia(puntajePertinencia);
        reportePrograma.setPuntajeMaximoPertinencia(puntajeMaximoPertinencia);
        reportePrograma.setPuntajeEficacia(puntajeEficacia);
        reportePrograma.setPuntajeMaximoEficacia(puntajeMaximoEficacia);
        reportePrograma.setPuntajeEficiencia(puntajeEficiencia);
        reportePrograma.setPuntajeMaximoEficiencia(puntajeMaximoEficiencia);
        reportePrograma.setPuntajeSostenibilidad(puntajeSostenibilidad);
        reportePrograma.setPuntajeMaximoSostenibilidad(puntajeMaximoSostenibilidad);
        
        reportePrograma.setNroBeneficiariosDirectosHombres(nroBeneficiariosDirectosHombres);
        reportePrograma.setNroBeneficiariosDirectosMujeres(nroBeneficiariosDirectosMujeres);
        reportePrograma.setNroBeneficiariosDirectosNinios(nroBeneficiariosDirectosNinios);
        reportePrograma.setNroBeneficiariosDirectosDiscapac(nroBeneficiariosDirectosDiscapac);
        reportePrograma.setNroBeneficiariosIndirectos(nroBeneficiariosIndirectos);
        
        reportePrograma.setNroBeneficiariosDirectosHombresEjec(nroBeneficiariosDirectosHombresEjec);
        reportePrograma.setNroBeneficiariosDirectosMujeresEjec(nroBeneficiariosDirectosMujeresEjec);
        reportePrograma.setNroBeneficiariosDirectosNiniosEjec(nroBeneficiariosDirectosNiniosEjec);
        reportePrograma.setNroBeneficiariosDirectosDiscapacEjec(nroBeneficiariosDirectosDiscapacEjec);
        reportePrograma.setNroBeneficiariosIndirectosEjec(nroBeneficiariosIndirectosEjec);
        reportePrograma.setTotalBeneficiariosPlanificados(nroBeneficiariosDirectosHombres+nroBeneficiariosDirectosMujeres+nroBeneficiariosDirectosNinios+nroBeneficiariosDirectosDiscapac+nroBeneficiariosIndirectos);
        reportePrograma.setTotalBeneficiariosEjecutados(nroBeneficiariosDirectosHombresEjec+nroBeneficiariosDirectosMujeresEjec+nroBeneficiariosDirectosNiniosEjec+nroBeneficiariosDirectosDiscapacEjec+nroBeneficiariosIndirectosEjec);
        
        reportePrograma.setPresupuestoTotalPlanificado(presupuestoPlanificado);
        reportePrograma.setPresupuestoTotalEjecutado(presupuestoEjecutado);

        return reportePrograma;
    }

    private Integer filtroReporte;

    public Integer getFiltroReporte() {
        return filtroReporte;
    }

    public void setFiltroReporte(Integer filtroReporte) {
        this.filtroReporte = filtroReporte;
    }

    public void cancelarFiltro(Integer filtroReporte) {
        switch (filtroReporte) {
            case 1:
                for (Programa p : programas) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 2:
                for (Estado p : estadoList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 3:
                for (Stvmajr p : carreras) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 4:
                for (Cobertura p : coberturaList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 5:
                for (SeaProvincia p : provincias) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 6:
                for (SeaCanton p : cantones) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 7:
                for (SeaParroquia p : parroquias) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 8:
                for (Stvcamp p : campusList) {
                    p.setSelected(Boolean.FALSE);
                }
                break;
            case 9:
                for (Stvsubj p : departamentos) {
                    p.setSelected(Boolean.FALSE);
                }
                break;

        }
    }

    private void filtrarProgramas() {
        //Filtro por programas
        if (verificarFiltro(1)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (Programa progFiltro : programas) {
                    if (progFiltro.getSelected() != null && progFiltro.getSelected() && progFiltro.equals(prog)) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por estado
        if (verificarFiltro(2)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (Estado estadoFiltro : estadoList) {
                    if (estadoFiltro.getSelected() != null && estadoFiltro.getSelected()) {
                        if (estadoFiltro.getId().equals(prog.getEstado())) {
                            encontro = true;
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por carrera
        if (verificarFiltro(3)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (Stvmajr carreraFiltro : carreras) {
                    if (carreraFiltro.getSelected() != null && carreraFiltro.getSelected()) {
                        for (CarreraPrograma car : prog.getCarreraProgramaList()) {
                            if (carreraFiltro.equals(car.getCarrera())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por cobertura
        if (verificarFiltro(4)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (Cobertura cobertura : coberturaList) {
                    if (cobertura.getSelected() != null && cobertura.getSelected() && cobertura.getId().equals(prog.getCobertura().toString())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Provincia
        if (verificarFiltro(5)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (SeaProvincia provinciaFiltro : provincias) {
                    if (provinciaFiltro.getSelected() != null && provinciaFiltro.getSelected()) {
                        for (LocalizacionPrograma car : prog.getLocalizacionDistinctProvinciaList()) {
                            if (provinciaFiltro.equals(car.getProvincia())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Canton
        if (verificarFiltro(6)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (SeaCanton cantonFiltro : cantones) {
                    if (cantonFiltro.getSelected() != null && cantonFiltro.getSelected()) {
                        for (LocalizacionPrograma car : prog.getLocalizacionDistinctCantonList()) {
                            if (cantonFiltro.equals(car.getCanton())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Parroquia
        if (verificarFiltro(7)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (SeaParroquia parroquiaFiltro : parroquias) {
                    if (parroquiaFiltro.getSelected() != null && parroquiaFiltro.getSelected()) {
                        for (LocalizacionPrograma car : prog.getLocalizacionDistinctParroquiaList()) {
                            if (parroquiaFiltro.equals(car.getParroquia())) {
                                encontro = true;
                                break;
                            }

                        }
                        if (encontro) {
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Campus
        if (verificarFiltro(8)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (Stvcamp campusFiltro : campusList) {
                    if (campusFiltro.getSelected() != null && campusFiltro.getSelected()) {
                        if (prog.getCampus() != null && campusFiltro.equals(prog.getCampus())) {
                            encontro = true;
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }

        //Filtro por Departamento
        if (verificarFiltro(9)) {
            Iterator it = programaList.iterator();
            while (it.hasNext()) {
                Programa prog = (Programa) it.next();
                boolean encontro = false;
                for (Stvsubj departamentoFiltro : departamentos) {
                    if (departamentoFiltro.getSelected() != null && departamentoFiltro.getSelected()) {
                        if (prog.getDepartamento() != null && departamentoFiltro.equals(prog.getDepartamento())) {
                            encontro = true;
                            break;
                        }
                    }
                }
                if (!encontro) {
                    it.remove();
                }
            }
        }
    }

    public void generarReporte() {
        programasReporteList = new ArrayList<>();
        programaList = programaFacade.findAll();
        Iterator it = programaList.iterator();
        while (it.hasNext()) {
            Programa p = (Programa) it.next();
            if (fechaDesde != null && p.getFechaInicio() != null && p.getFechaInicio().before(fechaDesde)) {
                it.remove();
                continue;
            }
            if (fechaHasta != null && (p.getFechaCierre() == null || p.getFechaCierre().after(fechaHasta))) {
                it.remove();
            }
        }
        filtrarProgramas();
        //agregaEvaluacionFinal();

        for (Programa p : programaList) {
            if ((p.getProyectoActivoList() == null || p.getProyectoActivoList().isEmpty())
                    && (p.getDepartamentoProgramaList() == null || p.getDepartamentoProgramaList().isEmpty())
                    && (p.getCarreraProgramaList() == null || p.getCarreraProgramaList().isEmpty())
                    && (p.getObjetivosProvCanParr() == null || p.getObjetivosProvCanParr().isEmpty())) {
                programasReporteList.add(crearObjetoReportePrograma(p));
            }
        }

        //Carreras
        for (Programa p : programaList) {
            List<CarreraPrograma> lista = p.getCarreraProgramaList();
            if (lista == null || lista.isEmpty() || !visualizarCarrera) {
                agregarPrograma(p);
            } else if (visualizarCarrera) {
                for (CarreraPrograma item : lista) {
                    agregarProgramaCarrera(p, item.getCarrera());
                }
            }
        }

        //Provincias
        for (Programa p : programaList) {
            List<LocalizacionPrograma> lista = p.getLocalizacionDistinctProvinciaList();
            if (lista == null || lista.isEmpty() || !visualizarProvincia) {
                agregarPrograma(p);
            } else if (visualizarProvincia) {
                for (LocalizacionPrograma item : lista) {
                    agregarProgramaProvincia(p, item.getProvincia());
                }
            }
        }

        //Cantones
        for (Programa p : programaList) {
            List<LocalizacionPrograma> lista = p.getLocalizacionDistinctCantonList();
            if (lista == null || lista.isEmpty() || !visualizarCanton) {
                agregarPrograma(p);
            } else if (visualizarCanton) {
                for (LocalizacionPrograma item : lista) {
                    agregarProgramaCanton(p, item.getCanton());
                }
            }
        }

        //Parroquias
        for (Programa p : programaList) {
            List<LocalizacionPrograma> lista = p.getLocalizacionDistinctParroquiaList();
            if (lista == null || lista.isEmpty() || !visualizarParroquia) {
                agregarPrograma(p);
            } else if (visualizarParroquia) {
                for (LocalizacionPrograma item : lista) {
                    agregarProgramaParroquia(p, item.getParroquia());
                }
            }
        }

        //Proyectos
        for (Programa p : programaList) {
            List<Proyecto> lista = p.getProyectoList();
            if (lista == null || lista.isEmpty() || !visualizarProyectos) {
                agregarPrograma(p);
            } else if (visualizarProyectos) {
                for (Proyecto item : lista) {
                    agregarProgramaProyecto(p, item);
                }
            }
        }
        for (ProgramaReporte p : programasReporteList) {
            if (p.getCarrera() == null) {
                p.setCarrera(new Stvmajr("-1", ""));
            }
            if (p.getCampusParticipante() == null) {
                p.setCampusParticipante(new Stvcamp("-1", ""));
            }
            if (p.getDepartamentoParticipante() == null) {
                p.setDepartamentoParticipante(new Stvsubj("-1", ""));
            }
            if (p.getProvincia() == null) {
                p.setProvincia(new SeaProvincia("-1", ""));
            }
            if (p.getCanton() == null) {
                p.setCanton(new SeaCanton("-1", ""));
            }
            if (p.getParroquia() == null) {
                p.setParroquia(new SeaParroquia("-1", ""));
            }
        }

    }

    private enum TipoBusqueda {
        DEPARTAMENTO, CARRERA, PROVINCIA, CANTON, PARROQUIA, PROYECTO
    }

    private List<ProgramaReporte> buscarProgramas(Integer idPrograma, TipoBusqueda tipoBusqueda) {
        List<ProgramaReporte> result = new ArrayList<>();
        for (ProgramaReporte p : programasReporteList) {
            if (p.getId().equals(idPrograma)) {
                if (tipoBusqueda == null) {
                    result.add(p);
                } else if (tipoBusqueda.equals(TipoBusqueda.DEPARTAMENTO)) {
                    if (p.getDepartamentoParticipante() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.CARRERA)) {
                    if (p.getCarrera() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.PROVINCIA)) {
                    if (p.getProvincia() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.CANTON)) {
                    if (p.getCanton() == null) {
                        result.add(p);
                    }
                } else if (tipoBusqueda.equals(TipoBusqueda.PARROQUIA)) {
                    if (p.getParroquia() == null) {
                        result.add(p);
                    }
                }
            }
        }
        return result;
    }

    private List<ProgramaReporte> buscarProgramas(Integer idPrograma, String idBuscar, TipoBusqueda tipoBusqueda) {
        List<ProgramaReporte> result = new ArrayList<>();
        for (ProgramaReporte p : programasReporteList) {
            if (p.getId().equals(idPrograma)) {
                if (tipoBusqueda.equals(TipoBusqueda.DEPARTAMENTO)) {
                    if (p.getDepartamentoParticipante() != null && p.getDepartamentoParticipante().getStvsubjCode().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.CARRERA)) {
                    if (p.getCarrera().getStvmajrCode().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.PROVINCIA)) {
                    if (p.getProvincia() != null && p.getProvincia().getProId().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.CANTON)) {
                    if (p.getCanton() != null && p.getCanton().getCanId().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.PARROQUIA)) {
                    if (p.getParroquia() != null && p.getParroquia().getPrqId().equals(idBuscar)) {
                        result.add(p);
                    }
                }
                if (tipoBusqueda.equals(TipoBusqueda.PROYECTO)) {
                    if (p.getProyecto().getId().toString().equals(idBuscar)) {
                        result.add(p);
                    }
                }
            }
        }
        return result;
    }

    private void agregarPrograma(Programa p) {
        if (buscarProgramas(p.getId(), null).isEmpty()) {
            ProgramaReporte prog = crearObjetoReportePrograma(p);
            programasReporteList.add(prog);
        }
    }

    private void agregarProgramaCarrera(Programa programa, Stvmajr carrera) {
        boolean encontro = false;
        for (ProgramaReporte p : buscarProgramas(programa.getId(), TipoBusqueda.CARRERA)) {
            p.setCarrera(carrera);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProgramaReporte p : programasReporteList) {
                if (p.getId().equals(programa.getId()) && p.getCarrera() != null) {
                    idBuscar = p.getCarrera().getStvmajrCode();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProgramaReporte p : buscarProgramas(programa.getId(), null)) {
                    p.setCarrera(carrera);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProgramaReporte prog = crearObjetoReportePrograma(programa);
                    prog.setCarrera(carrera);
                    programasReporteList.add(prog);
                }
            } else {
                for (ProgramaReporte p : buscarProgramas(programa.getId(), idBuscar, TipoBusqueda.CARRERA)) {
                    ProgramaReporte programaReporteNuevo = p.clon();
                    programaReporteNuevo.setCarrera(carrera);
                    programasReporteList.add(programaReporteNuevo);
                }
            }

        }
    }

    private void agregarProgramaProyecto(Programa programa, Proyecto proyecto) {
        boolean encontro = false;
        for (ProgramaReporte p : buscarProgramas(programa.getId(), TipoBusqueda.PROYECTO)) {
            p.setProyecto(proyecto);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProgramaReporte p : programasReporteList) {
                if (p.getId().equals(programa.getId()) && p.getProyecto() != null) {
                    idBuscar = p.getProyecto().getId().toString();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProgramaReporte p : buscarProgramas(programa.getId(), null)) {
                    p.setProyecto(proyecto);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProgramaReporte prog = crearObjetoReportePrograma(programa);
                    prog.setProyecto(proyecto);
                    programasReporteList.add(prog);
                }
            } else {
                for (ProgramaReporte p : buscarProgramas(programa.getId(), idBuscar, TipoBusqueda.PROYECTO)) {
                    ProgramaReporte programaReporteNuevo = p.clon();
                    programaReporteNuevo.setProyecto(proyecto);
                    programasReporteList.add(programaReporteNuevo);
                }
            }

        }
    }

    private void agregarProgramaProvincia(Programa programa, SeaProvincia provincia) {
        boolean encontro = false;
        for (ProgramaReporte p : buscarProgramas(programa.getId(), TipoBusqueda.PROVINCIA)) {
            p.setProvincia(provincia);
            encontro = true;
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProgramaReporte p : programasReporteList) {
                if (p.getId().equals(programa.getId()) && p.getProvincia() != null) {
                    idBuscar = p.getProvincia().getProId();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProgramaReporte p : buscarProgramas(programa.getId(), null)) {
                    p.setProvincia(provincia);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProgramaReporte prog = crearObjetoReportePrograma(programa);
                    prog.setProvincia(provincia);
                    programasReporteList.add(prog);
                }
            } else {
                for (ProgramaReporte p : buscarProgramas(programa.getId(), idBuscar, TipoBusqueda.PROVINCIA)) {
                    ProgramaReporte programaReporteNuevo = p.clon();
                    programaReporteNuevo.setProvincia(provincia);
                    programasReporteList.add(programaReporteNuevo);
                }

            }
        }
    }

    private void agregarProgramaCanton(Programa programa, SeaCanton canton) {
        boolean encontro = false;
        for (ProgramaReporte p : buscarProgramas(programa.getId(), TipoBusqueda.CANTON)) {
            if (p.getProvincia() != null && p.getProvincia().equals(canton.getProId())) {
                p.setCanton(canton);
                encontro = true;
            }
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProgramaReporte p : programasReporteList) {
                if (p.getId().equals(programa.getId()) && p.getCanton() != null) {
                    idBuscar = p.getCanton().getCanId();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProgramaReporte p : buscarProgramas(programa.getId(), null)) {
                    p.setCanton(canton);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProgramaReporte proy = crearObjetoReportePrograma(programa);
                    proy.setCanton(canton);
                    programasReporteList.add(proy);
                }
            } else {
                for (ProgramaReporte p : buscarProgramas(programa.getId(), idBuscar, TipoBusqueda.CANTON)) {
                    ProgramaReporte programaReporteNuevo = p.clon();
                    programaReporteNuevo.setCanton(canton);
                    programasReporteList.add(programaReporteNuevo);
                }

            }
        }
    }

    private void agregarProgramaParroquia(Programa programa, SeaParroquia parroquia) {
        boolean encontro = false;
        for (ProgramaReporte p : buscarProgramas(programa.getId(), TipoBusqueda.PARROQUIA)) {
            if (p.getCanton() != null && p.getCanton().equals(parroquia.getCanId())) {
                p.setParroquia(parroquia);
                encontro = true;
            }
        }
        if (!encontro) {
            String idBuscar = null;
            for (ProgramaReporte p : programasReporteList) {
                if (p.getId().equals(programa.getId()) && p.getParroquia() != null) {
                    idBuscar = p.getParroquia().getPrqId();
                    break;
                }
            }
            if (idBuscar == null) {
                boolean encontro2 = false;
                for (ProgramaReporte p : buscarProgramas(programa.getId(), null)) {
                    p.setParroquia(parroquia);
                    encontro2 = true;
                }
                if (!encontro2) {
                    ProgramaReporte proy = crearObjetoReportePrograma(programa);
                    proy.setParroquia(parroquia);
                    programasReporteList.add(proy);
                }
            } else {
                for (ProgramaReporte p : buscarProgramas(programa.getId(), idBuscar, TipoBusqueda.PARROQUIA)) {
                    ProgramaReporte programasReporteNuevo = p.clon();
                    programasReporteNuevo.setParroquia(parroquia);
                    programasReporteList.add(programasReporteNuevo);
                }

            }
        }
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public boolean isVisualizarTodos() {
        return visualizarTodos;
    }

    public void setVisualizarTodos(boolean visualizarTodos) {
        this.visualizarTodos = visualizarTodos;
    }

    public boolean isVisualizarCarrera() {
        return visualizarCarrera;
    }

    public void setVisualizarCarrera(boolean visualizarCarrera) {
        this.visualizarCarrera = visualizarCarrera;
    }

    public void seleccionarDeseleccionarTodos() {
        visualizarCanton = visualizarTodos;
        visualizarCarrera = visualizarTodos;
        visualizarEvaluacionFinal = visualizarTodos;
        visualizarParroquia = visualizarTodos;
        visualizarProvincia = visualizarTodos;
        visualizarProyectos = visualizarTodos;
        visualizarDirector = visualizarTodos;
        visualizarEstado = visualizarTodos;
        visualizarFechaFinalizacion = visualizarTodos;
        visualizarFechaInicio = visualizarTodos;
        visualizarBeneficiarios=visualizarTodos;
        visualizarPresupuesto=visualizarTodos;
    }

    public void seleccionarFiltro() {

        filtroReporte = null;
    }

    public List<Stvsubj> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Stvsubj> departamentos) {
        this.departamentos = departamentos;
    }

    public List<SeaProvincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<SeaProvincia> provincias) {
        this.provincias = provincias;
    }

    public List<SeaCanton> getCantones() {
        return cantones;
    }

    public void setCantones(List<SeaCanton> cantones) {
        this.cantones = cantones;
    }

    public List<SeaParroquia> getParroquias() {
        return parroquias;
    }

    public void setParroquias(List<SeaParroquia> parroquias) {
        this.parroquias = parroquias;
    }

    public List<Cobertura> getCoberturaList() {
        return coberturaList;
    }

    public void setCoberturaList(List<Cobertura> coberturaList) {
        this.coberturaList = coberturaList;
    }

    public List<Stvcamp> getSedes() {
        return sedes;
    }

    public void setSedes(List<Stvcamp> sedes) {
        this.sedes = sedes;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public List<ProgramaReporte> getProgramasReporteList() {
        return programasReporteList;
    }

    public void setProgramasReporteList(List<ProgramaReporte> programasReporteList) {
        this.programasReporteList = programasReporteList;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public boolean isVisualizarEstado() {
        return visualizarEstado;
    }

    public void setVisualizarEstado(boolean visualizarEstado) {
        this.visualizarEstado = visualizarEstado;
    }

    public boolean isVisualizarFechaInicio() {
        return visualizarFechaInicio;
    }

    public void setVisualizarFechaInicio(boolean visualizarFechaInicio) {
        this.visualizarFechaInicio = visualizarFechaInicio;
    }

    public boolean isVisualizarFechaFinalizacion() {
        return visualizarFechaFinalizacion;
    }

    public void setVisualizarFechaFinalizacion(boolean visualizarFechaFinalizacion) {
        this.visualizarFechaFinalizacion = visualizarFechaFinalizacion;
    }

    public boolean isVisualizarDirector() {
        return visualizarDirector;
    }

    public void setVisualizarDirector(boolean visualizarDirector) {
        this.visualizarDirector = visualizarDirector;
    }

    public List<Stvcamp> getCampusList() {
        return campusList;
    }

    public void setCampusList(List<Stvcamp> campusList) {
        this.campusList = campusList;
    }

    public boolean isVisualizarCobertura() {
        return visualizarCobertura;
    }

    public void setVisualizarCobertura(boolean visualizarCobertura) {
        this.visualizarCobertura = visualizarCobertura;
    }

    public boolean isVisualizarCampusParticipante() {
        return visualizarCampusParticipante;
    }

    public void setVisualizarCampusParticipante(boolean visualizarCampusParticipante) {
        this.visualizarCampusParticipante = visualizarCampusParticipante;
    }

    public boolean isVisualizarDepartamentoParticipante() {
        return visualizarDepartamentoParticipante;
    }

    public void setVisualizarDepartamentoParticipante(boolean visualizarDepartamentoParticipante) {
        this.visualizarDepartamentoParticipante = visualizarDepartamentoParticipante;
    }

}
