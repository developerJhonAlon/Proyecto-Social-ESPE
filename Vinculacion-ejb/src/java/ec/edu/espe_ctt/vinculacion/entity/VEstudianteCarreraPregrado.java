/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvterm;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "VM_ESTUDIANTE_CARRERA_PREG")
@XmlRootElement
public class VEstudianteCarreraPregrado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "COD")
    private Integer id;
       
    @JoinColumn(name = "CODIGO_PERIODO", referencedColumnName = "STVTERM_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvterm periodo;

    @JoinColumn(name = "CODIGO_CAMPUS", referencedColumnName = "STVCAMP_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvcamp campus;

    @JoinColumn(name = "CODIGO_CARRERA", referencedColumnName = "STVMAJR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stvmajr carrera;

    @Column(name = "NUMERICO")
    private Integer nroEstudiantes;

    public VEstudianteCarreraPregrado() {
    }

   

    public Stvterm getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Stvterm periodo) {
        this.periodo = periodo;
    }
  
    public Stvmajr getCarrera() {
        return carrera;
    }

    public void setCarrera(Stvmajr carrera) {
        this.carrera = carrera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stvcamp getCampus() {
        return campus;
    }

    public void setCampus(Stvcamp campus) {
        this.campus = campus;
    }

    public Integer getNroEstudiantes() {
        return nroEstudiantes;
    }

    public void setNroEstudiantes(Integer nroEstudiantes) {
        this.nroEstudiantes = nroEstudiantes;
    }

}
