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
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author PC1
 */
public class ProgramaReporte {
    private Integer id;
    private String nombre;
    private ResponsableProyecto director;
    private Stvsubj departamento;
    private Stvcamp campus;
    private Stvsubj departamentoParticipante;
    private Stvcamp campusParticipante;
    private Stvmajr carrera;
    private String cobertura;
    private SeaProvincia provincia;
    private SeaCanton canton;
    private SeaParroquia parroquia;
    private Proyecto proyecto;
    private Estado estado;
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
    
    private BigDecimal presupuestoTotalPlanificado;
    private BigDecimal presupuestoTotalEjecutado;

    private Date fechaInicio;
    private Date fechaFinalizacion;
    
    private Integer puntajePertinencia;
    private Integer puntajeMaximoPertinencia;
    private Integer puntajeEficacia;
    private Integer puntajeMaximoEficacia;
    private Integer puntajeEficiencia;
    private Integer puntajeMaximoEficiencia;
    private Integer puntajeSostenibilidad;
    private Integer puntajeMaximoSostenibilidad;
    
    private BigDecimal presupuestoPlanificado;
    private BigDecimal presupuestoEjecutado;


    
    public ProgramaReporte(){
        
    }
    public ProgramaReporte(Integer id, String nombre){
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
    public ProgramaReporte clon(){
        ProgramaReporte p = new ProgramaReporte();
        p.setId(id);
        p.setProyecto(proyecto);
        p.setDirector(director);
        p.setNombre(nombre);
        p.setCampus(campus);
        p.setDepartamento(departamento);
        p.setCampusParticipante(campusParticipante);
        p.setDepartamentoParticipante(departamentoParticipante);
        p.setCobertura(cobertura);
        p.setCarrera(carrera);
        p.setProvincia(provincia);
        p.setCanton(canton);
        p.setParroquia(parroquia);
        p.setEstado(estado);
        p.setNroBeneficiariosDirectosHombres(nroBeneficiariosDirectosHombres);
        p.setNroBeneficiariosDirectosMujeres(nroBeneficiariosDirectosMujeres);
        p.setNroBeneficiariosDirectosNinios(nroBeneficiariosDirectosNinios);
        p.setNroBeneficiariosDirectosDiscapac(nroBeneficiariosDirectosDiscapac);
        p.setNroBeneficiariosIndirectos(nroBeneficiariosIndirectos);
        
        p.setNroBeneficiariosDirectosHombresEjec(nroBeneficiariosDirectosHombresEjec);
        p.setNroBeneficiariosDirectosMujeresEjec(nroBeneficiariosDirectosMujeresEjec);
        p.setNroBeneficiariosDirectosNiniosEjec(nroBeneficiariosDirectosNiniosEjec);
        p.setNroBeneficiariosDirectosDiscapacEjec(nroBeneficiariosDirectosDiscapacEjec);
        p.setNroBeneficiariosIndirectosEjec(nroBeneficiariosIndirectosEjec);
        
        p.setTotalBeneficiariosPlanificados(totalBeneficiariosPlanificados);
        p.setTotalBeneficiariosEjecutados(totalBeneficiariosEjecutados);
        
        p.setPresupuestoTotalPlanificado(presupuestoTotalPlanificado);
        p.setPresupuestoTotalEjecutado(presupuestoTotalEjecutado);
        
        p.setFechaInicio(fechaInicio);
        p.setFechaFinalizacion(fechaFinalizacion);
        
        p.setPuntajePertinencia(puntajePertinencia);
        p.setPuntajeMaximoPertinencia(puntajeMaximoPertinencia);
        p.setPuntajeEficacia(puntajeEficacia);
        p.setPuntajeMaximoEficacia(puntajeMaximoEficacia);
        p.setPuntajeEficiencia(puntajeEficiencia);
        p.setPuntajeMaximoEficiencia(puntajeMaximoEficiencia);
        p.setPuntajeSostenibilidad(puntajeSostenibilidad);
        p.setPuntajeMaximoSostenibilidad(puntajeMaximoSostenibilidad);

        
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaReporte)) {
            return false;
        }
        ProgramaReporte other = (ProgramaReporte) object;
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


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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

    public Stvsubj getDepartamento() {
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
    }

    public Integer getPuntajePertinencia() {
        return puntajePertinencia;
    }

    public void setPuntajePertinencia(Integer puntajePertinencia) {
        this.puntajePertinencia = puntajePertinencia;
    }

    public Integer getPuntajeMaximoPertinencia() {
        return puntajeMaximoPertinencia;
    }

    public void setPuntajeMaximoPertinencia(Integer puntajeMaximoPertinencia) {
        this.puntajeMaximoPertinencia = puntajeMaximoPertinencia;
    }

    public Integer getPuntajeEficacia() {
        return puntajeEficacia;
    }

    public void setPuntajeEficacia(Integer puntajeEficacia) {
        this.puntajeEficacia = puntajeEficacia;
    }

    public Integer getPuntajeMaximoEficacia() {
        return puntajeMaximoEficacia;
    }

    public void setPuntajeMaximoEficacia(Integer puntajeMaximoEficacia) {
        this.puntajeMaximoEficacia = puntajeMaximoEficacia;
    }

    public Integer getPuntajeEficiencia() {
        return puntajeEficiencia;
    }

    public void setPuntajeEficiencia(Integer puntajeEficiencia) {
        this.puntajeEficiencia = puntajeEficiencia;
    }

    public Integer getPuntajeMaximoEficiencia() {
        return puntajeMaximoEficiencia;
    }

    public void setPuntajeMaximoEficiencia(Integer puntajeMaximoEficiencia) {
        this.puntajeMaximoEficiencia = puntajeMaximoEficiencia;
    }

    public Integer getPuntajeSostenibilidad() {
        return puntajeSostenibilidad;
    }

    public void setPuntajeSostenibilidad(Integer puntajeSostenibilidad) {
        this.puntajeSostenibilidad = puntajeSostenibilidad;
    }

    public Integer getPuntajeMaximoSostenibilidad() {
        return puntajeMaximoSostenibilidad;
    }

    public void setPuntajeMaximoSostenibilidad(Integer puntajeMaximoSostenibilidad) {
        this.puntajeMaximoSostenibilidad = puntajeMaximoSostenibilidad;
    }

    public Integer getPuntajeTotal() {
        return puntajeEficacia+puntajeEficiencia+puntajePertinencia+puntajeSostenibilidad;
    }
    public Integer getPuntajeMaximo() {
        return puntajeMaximoEficacia+puntajeMaximoEficiencia+puntajeMaximoPertinencia+puntajeMaximoSostenibilidad;
    }

    
    
    
}
