/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVCONFIGURACION")
@XmlRootElement
public class Configuracion implements Serializable, Comparable<Configuracion> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCONFIGURACION", sequenceName = "SEQ_SZDTAVCONFIGURACION", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCONFIGURACION")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAVCONFIGURACION_ID")
    private Integer id;

    @Size(max = 10)
    @Column(name = "VICERRECTOR_CED")
    private String vicerrectorCedula;

    @Size(max = 50)
    @Column(name = "VICERRECTOR_NOM")
    private String vicerrectorNombres;

    @Size(max = 50)
    @Column(name = "VICERRECTOR_APE")
    private String vicerrectorApellidos;
    
    @Size(max = 30)
    @Column(name = "VICERRECTOR_ABREV")
    private String vicerrectorAbreviatura;

    @Size(max = 20)
    @Column(name = "VICERRECTOR_GRADO_MIL")
    private String vicerrectorGradoMilitar;


    @Size(max = 10)
    @Column(name = "DIRECTOR_UNID_VINCU_CED")
    private String directorUnidadVinculacionCedula;

    @Size(max = 50)
    @Column(name = "DIRECTOR_UNID_VINCU_NOM")
    private String directorUnidadVinculacionNombres;

    @Size(max = 50)
    @Column(name = "DIRECTOR_UNID_VINCU_APE")
    private String directorUnidadVinculacionApellidos;
    
    @Size(max = 30)
    @Column(name = "DIRECTOR_UNID_VINCU_ABREV")
    private String directorUnidadVinculacionAbreviatura;
    
    @Size(max = 20)
    @Column(name = "DIRECTOR_UNID_VINCU_GRADO_MIL")
    private String directorUnidadVinculacionGradoMilitar;

    @Column(name = "NRO_HORAS_MINIMO_CERTIFICADO_E")
    private Integer nroHorasMinimoCertificadoEstudiante;

    @Column(name = "NRO_HORAS_MINIMO_CERTIFICADO_D")
    private Integer nroHorasMinimoCertificadoDocente;
            
    public Configuracion() {
        nroHorasMinimoCertificadoEstudiante=0;
        nroHorasMinimoCertificadoDocente=0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVicerrectorCedula() {
        return vicerrectorCedula;
    }

    public void setVicerrectorCedula(String vicerrectorCedula) {
        this.vicerrectorCedula = vicerrectorCedula;
    }

    public String getVicerrectorNombres() {
        return vicerrectorNombres;
    }

    public void setVicerrectorNombres(String vicerrectorNombres) {
        this.vicerrectorNombres = vicerrectorNombres;
    }

    public String getVicerrectorApellidos() {
        return vicerrectorApellidos;
    }

    public void setVicerrectorApellidos(String vicerrectorApellidos) {
        this.vicerrectorApellidos = vicerrectorApellidos;
    }

    public String getVicerrectorAbreviatura() {
        return vicerrectorAbreviatura;
    }

    public void setVicerrectorAbreviatura(String vicerrectorAbreviatura) {
        this.vicerrectorAbreviatura = vicerrectorAbreviatura;
    }

    public String getDirectorUnidadVinculacionCedula() {
        return directorUnidadVinculacionCedula;
    }

    public void setDirectorUnidadVinculacionCedula(String directorUnidadVinculacionCedula) {
        this.directorUnidadVinculacionCedula = directorUnidadVinculacionCedula;
    }

    public String getDirectorUnidadVinculacionNombres() {
        return directorUnidadVinculacionNombres;
    }

    public void setDirectorUnidadVinculacionNombres(String directorUnidadVinculacionNombres) {
        this.directorUnidadVinculacionNombres = directorUnidadVinculacionNombres;
    }

    public String getDirectorUnidadVinculacionApellidos() {
        return directorUnidadVinculacionApellidos;
    }

    public void setDirectorUnidadVinculacionApellidos(String directorUnidadVinculacionApellidos) {
        this.directorUnidadVinculacionApellidos = directorUnidadVinculacionApellidos;
    }

    public String getDirectorUnidadVinculacionAbreviatura() {
        return directorUnidadVinculacionAbreviatura;
    }

    public void setDirectorUnidadVinculacionAbreviatura(String directorUnidadVinculacionAbreviatura) {
        this.directorUnidadVinculacionAbreviatura = directorUnidadVinculacionAbreviatura;
    }

    public String getVicerrectorGradoMilitar() {
        return vicerrectorGradoMilitar;
    }

    public void setVicerrectorGradoMilitar(String vicerrectorGradoMilitar) {
        this.vicerrectorGradoMilitar = vicerrectorGradoMilitar;
    }

    public String getDirectorUnidadVinculacionGradoMilitar() {
        return directorUnidadVinculacionGradoMilitar;
    }

    public void setDirectorUnidadVinculacionGradoMilitar(String directorUnidadVinculacionGradoMilitar) {
        this.directorUnidadVinculacionGradoMilitar = directorUnidadVinculacionGradoMilitar;
    }

    public Integer getNroHorasMinimoCertificadoEstudiante() {
        return nroHorasMinimoCertificadoEstudiante;
    }

    public void setNroHorasMinimoCertificadoEstudiante(Integer nroHorasMinimoCertificadoEstudiante) {
        this.nroHorasMinimoCertificadoEstudiante = nroHorasMinimoCertificadoEstudiante;
    }

    public Integer getNroHorasMinimoCertificadoDocente() {
        return nroHorasMinimoCertificadoDocente;
    }

    public void setNroHorasMinimoCertificadoDocente(Integer nroHorasMinimoCertificadoDocente) {
        this.nroHorasMinimoCertificadoDocente = nroHorasMinimoCertificadoDocente;
    }

    
    @Override
    public int compareTo(Configuracion o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.Configuracion[ id=" + id + " ]";
    }
    

    
}
