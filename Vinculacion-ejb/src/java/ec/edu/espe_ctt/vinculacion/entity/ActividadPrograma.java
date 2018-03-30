/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVACTIVPROG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadPrograma.findAll", query = "SELECT s FROM ActividadPrograma s"),
    @NamedQuery(name = "ActividadPrograma.findById", query = "SELECT s FROM ActividadPrograma s WHERE s.id = :id")})
public class ActividadPrograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SZDTAVACTIVPROG", sequenceName = "SEQ_SZDTAVACTIVPROG", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVACTIVPROG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVACTIVPROG_CODE")
    private Integer id;
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @Column(name = "SZTVACTIVPROG_FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "SZTVACTIVPROG_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "SZTVACTIVPROG_PRESUPUESTO")
    private BigDecimal presupuestoGastoPermanente;
    @Column(name = "SZTVACTIVPROG_PRESUPUESTO2")
    private BigDecimal presupuestoGastoNoPermanente;
    
    @Column(name = "SZTVACTIVPROG_BENEFICIARIOS")
    private Integer nroBeneficiarios;
    @Size(max = 500)
    @Column(name = "SZTVACTIVPROG_DESCRIPCION")
    private String descripcion;
    @Column(name = "SZTVACTIVPROG_ANIO")
    private Integer anio;

    public ActividadPrograma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPresupuestoGastoPermanente() {
        return presupuestoGastoPermanente;
    }

    public void setPresupuestoGastoPermanente(BigDecimal presupuestoGastoPermanente) {
        this.presupuestoGastoPermanente = presupuestoGastoPermanente;
    }

    public Integer getNroBeneficiarios() {
        return nroBeneficiarios;
    }

    public void setNroBeneficiarios(Integer nroBeneficiarios) {
        this.nroBeneficiarios = nroBeneficiarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public BigDecimal getPresupuestoGastoNoPermanente() {
        return presupuestoGastoNoPermanente;
    }

    public void setPresupuestoGastoNoPermanente(BigDecimal presupuestoGastoNoPermanente) {
        this.presupuestoGastoNoPermanente = presupuestoGastoNoPermanente;
    }

    
}
