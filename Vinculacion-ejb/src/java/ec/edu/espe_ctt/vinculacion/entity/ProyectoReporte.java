/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author PC1
 */
public class ProyectoReporte {
    private Integer id;
    private String codigo;
    private String nombre;
    private String programa;
    private ResponsableProyecto director;
    /*private Stvsubj departamento;
    private Stvcamp campus;*/
    private SeaLineainves lineaInvestigacion;
    private Stvsubj departamentoParticipante;
    private Stvcamp campusParticipante;
    private Stvmajr carrera;
    private Convocatoria convocatoria;
    private String tipo; //TIPO_GASTO_NO_PERMANENTE = "I";
                          //TIPO_GASTO_PERMANENTE = "C";
    private String cobertura;
    private SeaProvincia provincia;
    private SeaCanton canton;
    private SeaParroquia parroquia;
    private ResponsableProyecto docenteParticipante;
    private ResponsableProyecto estudianteParticipante;
    private Estado estado;    
    private Integer puntajeEvaluacionFinalMaximo;
    private Integer puntajeEvaluacionFinalTotal;
    private Integer puntajeEvaluacionFinalPertinencia;
    private Integer puntajeEvaluacionFinalEficacia;
    private Integer puntajeEvaluacionFinalEficiencia;
    private Integer puntajeEvaluacionFinalSostenibilidad;
    private Integer puntajeEvaluacionFinalPertinenciaMaximo;
    private Integer puntajeEvaluacionFinalEficaciaMaximo;
    private Integer puntajeEvaluacionFinalEficienciaMaximo;
    private Integer puntajeEvaluacionFinalSostenibilidadMaximo;
    
    private Integer nroBeneficiariosDirectosHombres;
    private Integer nroBeneficiariosDirectosMujeres;
    private Integer nroBeneficiariosDirectosNinios;
    private Integer nroBeneficiariosDirectosDiscapac;
    private Integer nroBeneficiariosIndirectos;
    private Integer totalBeneficiariosPlanificados;
    private Integer nroBeneficiariosDirectosHombresEjec;
    private Integer nroBeneficiariosDirectosMujeresEjec;
    private Integer nroBeneficiariosDirectosNiniosEjec;
    private Integer nroBeneficiariosDirectosDiscapacEjec;
    private Integer nroBeneficiariosIndirectosEjec;
    private Integer totalBeneficiariosEjecutados;
    
    private boolean poblacionBeneficiariaUrbanoMarginal;
    private boolean poblacionBeneficiariaRural;
    private boolean poblacionBeneficiariaGrupoAtencionPrioritaria;
    private BigDecimal presupuestoTotalPlanificado;
    private BigDecimal presupuestoTotalEjecutado;
    private boolean documentacionPerfil;
    private boolean documentacionCronograma;
    private boolean documentacionCosteo;
    private boolean documentacionCompromisoParticipacion;
    private boolean documentacionBeneficiarios;
    private boolean documentacionNroDocentes;
    private boolean documentacionNroEstudiantes;
    private boolean documentacionAvance;
    private boolean documentacionHorasDocentes;
    private boolean documentacionHorasEstudiantes;
    private boolean documentacionCierre;
    private boolean documentacionEvaluacionFinal;
    private boolean documentacionAnexos;
    private Date fechaInicio;
    private Date fechaFinalizacion;


    public boolean isDocumentacionPerfil() {
        return documentacionPerfil;
    }

    public void setDocumentacionPerfil(boolean documentacionPerfil) {
        this.documentacionPerfil = documentacionPerfil;
    }

    public boolean isDocumentacionCronograma() {
        return documentacionCronograma;
    }

    public void setDocumentacionCronograma(boolean documentacionCronograma) {
        this.documentacionCronograma = documentacionCronograma;
    }

    public boolean isDocumentacionCosteo() {
        return documentacionCosteo;
    }

    public void setDocumentacionCosteo(boolean documentacionCosteo) {
        this.documentacionCosteo = documentacionCosteo;
    }

    public boolean isDocumentacionCompromisoParticipacion() {
        return documentacionCompromisoParticipacion;
    }

    public void setDocumentacionCompromisoParticipacion(boolean documentacionCompromisoParticipacion) {
        this.documentacionCompromisoParticipacion = documentacionCompromisoParticipacion;
    }

    public boolean isDocumentacionBeneficiarios() {
        return documentacionBeneficiarios;
    }

    public void setDocumentacionBeneficiarios(boolean documentacionBeneficiarios) {
        this.documentacionBeneficiarios = documentacionBeneficiarios;
    }

    public boolean isDocumentacionNroDocentes() {
        return documentacionNroDocentes;
    }

    public void setDocumentacionNroDocentes(boolean documentacionNroDocentes) {
        this.documentacionNroDocentes = documentacionNroDocentes;
    }

    public boolean isDocumentacionNroEstudiantes() {
        return documentacionNroEstudiantes;
    }

    public void setDocumentacionNroEstudiantes(boolean documentacionNroEstudiantes) {
        this.documentacionNroEstudiantes = documentacionNroEstudiantes;
    }

    public boolean isDocumentacionAvance() {
        return documentacionAvance;
    }

    public void setDocumentacionAvance(boolean documentacionAvance) {
        this.documentacionAvance = documentacionAvance;
    }

    public boolean isDocumentacionHorasDocentes() {
        return documentacionHorasDocentes;
    }

    public void setDocumentacionHorasDocentes(boolean documentacionHorasDocentes) {
        this.documentacionHorasDocentes = documentacionHorasDocentes;
    }

    public boolean isDocumentacionHorasEstudiantes() {
        return documentacionHorasEstudiantes;
    }

    public void setDocumentacionHorasEstudiantes(boolean documentacionHorasEstudiantes) {
        this.documentacionHorasEstudiantes = documentacionHorasEstudiantes;
    }

    public boolean isDocumentacionCierre() {
        return documentacionCierre;
    }

    public void setDocumentacionCierre(boolean documentacionCierre) {
        this.documentacionCierre = documentacionCierre;
    }

    public boolean isDocumentacionEvaluacionFinal() {
        return documentacionEvaluacionFinal;
    }

    public void setDocumentacionEvaluacionFinal(boolean documentacionEvaluacionFinal) {
        this.documentacionEvaluacionFinal = documentacionEvaluacionFinal;
    }

    public boolean isDocumentacionAnexos() {
        return documentacionAnexos;
    }

    public void setDocumentacionAnexos(boolean documentacionAnexos) {
        this.documentacionAnexos = documentacionAnexos;
    }
    
    
    
    private PresupuestoProyecto presupuestoProyecto;
    private AvanceActividad avanceActividad;
    

    public ProyectoReporte(){
        
    }
    public ProyectoReporte(Integer id, String nombre){
        this.id=id;
        this.nombre=nombre;
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public SeaLineainves getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(SeaLineainves lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }
    
    
    
    
    public ProyectoReporte clon(){
        ProyectoReporte p = new ProyectoReporte();
        p.setId(id);
        p.setCodigo(codigo);
        p.setConvocatoria(convocatoria);
        p.setDirector(director);
        p.setNombre(nombre);
        p.setPrograma(programa);
        p.setTipo(tipo);
        p.setCampusParticipante(campusParticipante);
        p.setDepartamentoParticipante(departamentoParticipante);
        p.setCobertura(cobertura);
        p.setCarrera(carrera);
        p.setLineaInvestigacion(lineaInvestigacion);
        p.setProvincia(provincia);
        p.setCanton(canton);
        p.setParroquia(parroquia);
        p.setDocenteParticipante(docenteParticipante);
        p.setEstudianteParticipante(estudianteParticipante);
        p.setEstado(estado);
        p.setPuntajeEvaluacionFinalEficacia(puntajeEvaluacionFinalEficacia);
        p.setPuntajeEvaluacionFinalEficiencia(puntajeEvaluacionFinalEficiencia);
        p.setPuntajeEvaluacionFinalPertinencia(puntajeEvaluacionFinalPertinencia);
        p.setPuntajeEvaluacionFinalSostenibilidad(puntajeEvaluacionFinalSostenibilidad);
        p.setPuntajeEvaluacionFinalEficaciaMaximo(puntajeEvaluacionFinalEficaciaMaximo);
        p.setPuntajeEvaluacionFinalEficienciaMaximo(puntajeEvaluacionFinalEficienciaMaximo);
        p.setPuntajeEvaluacionFinalPertinenciaMaximo(puntajeEvaluacionFinalPertinenciaMaximo);
        p.setPuntajeEvaluacionFinalSostenibilidadMaximo(puntajeEvaluacionFinalSostenibilidadMaximo);
        p.setPuntajeEvaluacionFinalMaximo(puntajeEvaluacionFinalMaximo);
        p.setPuntajeEvaluacionFinalTotal(puntajeEvaluacionFinalTotal);
        p.setNroBeneficiariosDirectosDiscapac(nroBeneficiariosDirectosDiscapac);
        p.setNroBeneficiariosDirectosDiscapacEjec(nroBeneficiariosDirectosDiscapacEjec);
        p.setNroBeneficiariosDirectosHombres(nroBeneficiariosDirectosHombres);
        p.setNroBeneficiariosDirectosHombresEjec(nroBeneficiariosDirectosHombresEjec);
        p.setNroBeneficiariosDirectosMujeres(nroBeneficiariosDirectosMujeres);
        p.setNroBeneficiariosDirectosMujeresEjec(nroBeneficiariosDirectosMujeresEjec);
        p.setNroBeneficiariosDirectosNinios(nroBeneficiariosDirectosNinios);
        p.setNroBeneficiariosDirectosNiniosEjec(nroBeneficiariosDirectosNiniosEjec);
        p.setNroBeneficiariosIndirectos(nroBeneficiariosIndirectos);
        p.setNroBeneficiariosIndirectosEjec(nroBeneficiariosIndirectosEjec);
        p.setTotalBeneficiariosPlanificados(totalBeneficiariosPlanificados);
        p.setTotalBeneficiariosEjecutados(totalBeneficiariosEjecutados);
        p.setPoblacionBeneficiariaGrupoAtencionPrioritaria(poblacionBeneficiariaGrupoAtencionPrioritaria);
        p.setPoblacionBeneficiariaRural(poblacionBeneficiariaRural);
        p.setPoblacionBeneficiariaUrbanoMarginal(poblacionBeneficiariaUrbanoMarginal);
        p.setPresupuestoTotalPlanificado(presupuestoTotalPlanificado);
        p.setPresupuestoTotalEjecutado(presupuestoTotalEjecutado);
        p.setPresupuestoProyecto(presupuestoProyecto);
        p.setAvanceActividad(avanceActividad);
        p.setDocenteParticipante(docenteParticipante);
        p.setDocumentacionAnexos(documentacionAnexos);
        p.setDocumentacionAvance(documentacionAvance);
        p.setDocumentacionBeneficiarios(documentacionBeneficiarios);
        p.setDocumentacionCierre(documentacionCierre);
        p.setDocumentacionCompromisoParticipacion(documentacionCompromisoParticipacion);
        p.setDocumentacionCosteo(documentacionCosteo);
        p.setDocumentacionCronograma(documentacionCronograma);
        p.setDocumentacionEvaluacionFinal(documentacionEvaluacionFinal);
        p.setDocumentacionHorasDocentes(documentacionHorasDocentes);
        p.setDocumentacionHorasEstudiantes(documentacionHorasEstudiantes);
        p.setDocumentacionNroDocentes(documentacionNroDocentes);
        p.setDocumentacionNroEstudiantes(documentacionNroEstudiantes);
        p.setDocumentacionPerfil(documentacionPerfil);
        p.setFechaInicio(fechaInicio);
        p.setFechaFinalizacion(fechaFinalizacion);
        return p;
    }

    public Stvsubj getDepartamentoParticipante() {
        return departamentoParticipante;
    }

    public void setDepartamentoParticipante(Stvsubj departamentoParticipante) {
        this.departamentoParticipante = departamentoParticipante;
    }

    public Stvcamp getCampusParticipante() {
        return campusParticipante;
    }

    public void setCampusParticipante(Stvcamp campusParticipante) {
        this.campusParticipante = campusParticipante;
    }

    public Stvmajr getCarrera() {
        return carrera;
    }

    public void setCarrera(Stvmajr carrera) {
        this.carrera = carrera;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /*public Stvsubj getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Stvsubj departamento) {
        this.departamento = departamento;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }*/

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoReporte)) {
            return false;
        }
        ProyectoReporte other = (ProyectoReporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public ResponsableProyecto getDirector() {
        return director;
    }

    public void setDirector(ResponsableProyecto director) {
        this.director = director;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public SeaProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(SeaProvincia provincia) {
        this.provincia = provincia;
    }

    public SeaCanton getCanton() {
        return canton;
    }

    public void setCanton(SeaCanton canton) {
        this.canton = canton;
    }

    public SeaParroquia getParroquia() {
        return parroquia;
    }

    public void setParroquia(SeaParroquia parroquia) {
        this.parroquia = parroquia;
    }

    public ResponsableProyecto getDocenteParticipante() {
        return docenteParticipante;
    }

    public void setDocenteParticipante(ResponsableProyecto docenteParticipante) {
        this.docenteParticipante = docenteParticipante;
    }

    public ResponsableProyecto getEstudianteParticipante() {
        return estudianteParticipante;
    }

    public void setEstudianteParticipante(ResponsableProyecto estudianteParticipante) {
        this.estudianteParticipante = estudianteParticipante;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPuntajeEvaluacionFinalPertinencia() {
        return puntajeEvaluacionFinalPertinencia;
    }

    public void setPuntajeEvaluacionFinalPertinencia(Integer puntajeEvaluacionFinalPertinencia) {
        this.puntajeEvaluacionFinalPertinencia = puntajeEvaluacionFinalPertinencia;
    }

    public Integer getPuntajeEvaluacionFinalEficacia() {
        return puntajeEvaluacionFinalEficacia;
    }

    public void setPuntajeEvaluacionFinalEficacia(Integer puntajeEvaluacionFinalEficacia) {
        this.puntajeEvaluacionFinalEficacia = puntajeEvaluacionFinalEficacia;
    }

    public Integer getPuntajeEvaluacionFinalEficiencia() {
        return puntajeEvaluacionFinalEficiencia;
    }

    public void setPuntajeEvaluacionFinalEficiencia(Integer puntajeEvaluacionFinalEficiencia) {
        this.puntajeEvaluacionFinalEficiencia = puntajeEvaluacionFinalEficiencia;
    }

    public Integer getPuntajeEvaluacionFinalSostenibilidad() {
        return puntajeEvaluacionFinalSostenibilidad;
    }

    public void setPuntajeEvaluacionFinalSostenibilidad(Integer puntajeEvaluacionFinalSostenibilidad) {
        this.puntajeEvaluacionFinalSostenibilidad = puntajeEvaluacionFinalSostenibilidad;
    }

    public Integer getPuntajeEvaluacionFinalMaximo() {
        return puntajeEvaluacionFinalMaximo;
    }

    public void setPuntajeEvaluacionFinalMaximo(Integer puntajeEvaluacionFinalMaximo) {
        this.puntajeEvaluacionFinalMaximo = puntajeEvaluacionFinalMaximo;
    }

    public Integer getPuntajeEvaluacionFinalTotal() {
        return puntajeEvaluacionFinalTotal;
    }

    public void setPuntajeEvaluacionFinalTotal(Integer puntajeEvaluacionFinalTotal) {
        this.puntajeEvaluacionFinalTotal = puntajeEvaluacionFinalTotal;
    }

    public Integer getNroBeneficiariosDirectosHombres() {
        return nroBeneficiariosDirectosHombres;
    }

    public void setNroBeneficiariosDirectosHombres(Integer nroBeneficiariosDirectosHombres) {
        this.nroBeneficiariosDirectosHombres = nroBeneficiariosDirectosHombres;
    }

    public Integer getNroBeneficiariosDirectosMujeres() {
        return nroBeneficiariosDirectosMujeres;
    }

    public void setNroBeneficiariosDirectosMujeres(Integer nroBeneficiariosDirectosMujeres) {
        this.nroBeneficiariosDirectosMujeres = nroBeneficiariosDirectosMujeres;
    }

    public Integer getNroBeneficiariosDirectosNinios() {
        return nroBeneficiariosDirectosNinios;
    }

    public void setNroBeneficiariosDirectosNinios(Integer nroBeneficiariosDirectosNinios) {
        this.nroBeneficiariosDirectosNinios = nroBeneficiariosDirectosNinios;
    }

    public Integer getNroBeneficiariosDirectosDiscapac() {
        return nroBeneficiariosDirectosDiscapac;
    }

    public void setNroBeneficiariosDirectosDiscapac(Integer nroBeneficiariosDirectosDiscapac) {
        this.nroBeneficiariosDirectosDiscapac = nroBeneficiariosDirectosDiscapac;
    }

    public Integer getNroBeneficiariosIndirectos() {
        return nroBeneficiariosIndirectos;
    }

    public void setNroBeneficiariosIndirectos(Integer nroBeneficiariosIndirectos) {
        this.nroBeneficiariosIndirectos = nroBeneficiariosIndirectos;
    }

    public Integer getNroBeneficiariosDirectosHombresEjec() {
        return nroBeneficiariosDirectosHombresEjec;
    }

    public void setNroBeneficiariosDirectosHombresEjec(Integer nroBeneficiariosDirectosHombresEjec) {
        this.nroBeneficiariosDirectosHombresEjec = nroBeneficiariosDirectosHombresEjec;
    }

    public Integer getNroBeneficiariosDirectosMujeresEjec() {
        return nroBeneficiariosDirectosMujeresEjec;
    }

    public void setNroBeneficiariosDirectosMujeresEjec(Integer nroBeneficiariosDirectosMujeresEjec) {
        this.nroBeneficiariosDirectosMujeresEjec = nroBeneficiariosDirectosMujeresEjec;
    }

    public Integer getNroBeneficiariosDirectosNiniosEjec() {
        return nroBeneficiariosDirectosNiniosEjec;
    }

    public void setNroBeneficiariosDirectosNiniosEjec(Integer nroBeneficiariosDirectosNiniosEjec) {
        this.nroBeneficiariosDirectosNiniosEjec = nroBeneficiariosDirectosNiniosEjec;
    }

    public Integer getNroBeneficiariosDirectosDiscapacEjec() {
        return nroBeneficiariosDirectosDiscapacEjec;
    }

    public void setNroBeneficiariosDirectosDiscapacEjec(Integer nroBeneficiariosDirectosDiscapacEjec) {
        this.nroBeneficiariosDirectosDiscapacEjec = nroBeneficiariosDirectosDiscapacEjec;
    }

    public Integer getNroBeneficiariosIndirectosEjec() {
        return nroBeneficiariosIndirectosEjec;
    }

    public void setNroBeneficiariosIndirectosEjec(Integer nroBeneficiariosIndirectosEjec) {
        this.nroBeneficiariosIndirectosEjec = nroBeneficiariosIndirectosEjec;
    }

    public Integer getTotalBeneficiariosPlanificados() {
        return totalBeneficiariosPlanificados;
    }

    public void setTotalBeneficiariosPlanificados(Integer totalBeneficiariosPlanificados) {
        this.totalBeneficiariosPlanificados = totalBeneficiariosPlanificados;
    }

    public Integer getTotalBeneficiariosEjecutados() {
        return totalBeneficiariosEjecutados;
    }

    public void setTotalBeneficiariosEjecutados(Integer totalBeneficiariosEjecutados) {
        this.totalBeneficiariosEjecutados = totalBeneficiariosEjecutados;
    }

    public boolean isPoblacionBeneficiariaUrbanoMarginal() {
        return poblacionBeneficiariaUrbanoMarginal;
    }

    public void setPoblacionBeneficiariaUrbanoMarginal(boolean poblacionBeneficiariaUrbanoMarginal) {
        this.poblacionBeneficiariaUrbanoMarginal = poblacionBeneficiariaUrbanoMarginal;
    }

    public boolean isPoblacionBeneficiariaRural() {
        return poblacionBeneficiariaRural;
    }

    public void setPoblacionBeneficiariaRural(boolean poblacionBeneficiariaRural) {
        this.poblacionBeneficiariaRural = poblacionBeneficiariaRural;
    }

    public boolean isPoblacionBeneficiariaGrupoAtencionPrioritaria() {
        return poblacionBeneficiariaGrupoAtencionPrioritaria;
    }

    public void setPoblacionBeneficiariaGrupoAtencionPrioritaria(boolean poblacionBeneficiariaGrupoAtencionPrioritaria) {
        this.poblacionBeneficiariaGrupoAtencionPrioritaria = poblacionBeneficiariaGrupoAtencionPrioritaria;
    }

    public BigDecimal getPresupuestoTotalPlanificado() {
        return presupuestoTotalPlanificado;
    }

    public void setPresupuestoTotalPlanificado(BigDecimal presupuestoTotalPlanificado) {
        this.presupuestoTotalPlanificado = presupuestoTotalPlanificado;
    }

    public BigDecimal getPresupuestoTotalEjecutado() {
        return presupuestoTotalEjecutado;
    }

    public void setPresupuestoTotalEjecutado(BigDecimal presupuestoTotalEjecutado) {
        this.presupuestoTotalEjecutado = presupuestoTotalEjecutado;
    }

    public PresupuestoProyecto getPresupuestoProyecto() {
        return presupuestoProyecto;
    }

    public void setPresupuestoProyecto(PresupuestoProyecto presupuestoProyecto) {
        this.presupuestoProyecto = presupuestoProyecto;
    }

    public AvanceActividad getAvanceActividad() {
        return avanceActividad;
    }

    public void setAvanceActividad(AvanceActividad avanceActividad) {
        this.avanceActividad = avanceActividad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Integer getPuntajeEvaluacionFinalPertinenciaMaximo() {
        return puntajeEvaluacionFinalPertinenciaMaximo;
    }

    public void setPuntajeEvaluacionFinalPertinenciaMaximo(Integer puntajeEvaluacionFinalPertinenciaMaximo) {
        this.puntajeEvaluacionFinalPertinenciaMaximo = puntajeEvaluacionFinalPertinenciaMaximo;
    }

    public Integer getPuntajeEvaluacionFinalEficaciaMaximo() {
        return puntajeEvaluacionFinalEficaciaMaximo;
    }

    public void setPuntajeEvaluacionFinalEficaciaMaximo(Integer puntajeEvaluacionFinalEficaciaMaximo) {
        this.puntajeEvaluacionFinalEficaciaMaximo = puntajeEvaluacionFinalEficaciaMaximo;
    }

    public Integer getPuntajeEvaluacionFinalEficienciaMaximo() {
        return puntajeEvaluacionFinalEficienciaMaximo;
    }

    public void setPuntajeEvaluacionFinalEficienciaMaximo(Integer puntajeEvaluacionFinalEficienciaMaximo) {
        this.puntajeEvaluacionFinalEficienciaMaximo = puntajeEvaluacionFinalEficienciaMaximo;
    }

    public Integer getPuntajeEvaluacionFinalSostenibilidadMaximo() {
        return puntajeEvaluacionFinalSostenibilidadMaximo;
    }

    public void setPuntajeEvaluacionFinalSostenibilidadMaximo(Integer puntajeEvaluacionFinalSostenibilidadMaximo) {
        this.puntajeEvaluacionFinalSostenibilidadMaximo = puntajeEvaluacionFinalSostenibilidadMaximo;
    }
    
    private boolean verificarEstado(Long estado){
        return this.estado.getId().equals(estado.toString());
    }
            
    public boolean isEstadoFinalizado(){
        return verificarEstado(SeaParametrosDet.ESTADO_EVALUADO);
    }
         



    
    
}
