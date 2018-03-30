/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "V_DOCENTE_VINCULACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VDocenteVinculacion.findAll", query = "SELECT v FROM VDocenteVinculacion v"),
    @NamedQuery(name = "VDocenteVinculacion.findById", query = "SELECT v FROM VDocenteVinculacion v WHERE v.id = :id"),
    @NamedQuery(name = "VDocenteVinculacion.findByUsuId", query = "SELECT v FROM VDocenteVinculacion v WHERE v.usuId = :usuId"),
    @NamedQuery(name = "VDocenteVinculacion.findByUsuNombres", query = "SELECT v FROM VDocenteVinculacion v WHERE v.usuNombres = :usuNombres"),
    @NamedQuery(name = "VDocenteVinculacion.findByUsuApellidos", query = "SELECT v FROM VDocenteVinculacion v WHERE v.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "VDocenteVinculacion.findByPebemplCollCode", query = "SELECT v FROM VDocenteVinculacion v WHERE v.pebemplCollCode = :pebemplCollCode"),
    @NamedQuery(name = "VDocenteVinculacion.findByStvcollDesc", query = "SELECT v FROM VDocenteVinculacion v WHERE v.stvcollDesc = :stvcollDesc"),
    @NamedQuery(name = "VDocenteVinculacion.findByStvsubjCode", query = "SELECT v FROM VDocenteVinculacion v WHERE v.stvsubjCode = :stvsubjCode"),
    @NamedQuery(name = "VDocenteVinculacion.findByStvsubjDesc", query = "SELECT v FROM VDocenteVinculacion v WHERE v.stvsubjDesc = :stvsubjDesc"),
    @NamedQuery(name = "VDocenteVinculacion.findByStvcampCode", query = "SELECT v FROM VDocenteVinculacion v WHERE v.stvcampCode = :stvcampCode"),
    @NamedQuery(name = "VDocenteVinculacion.findByStvcampDesc", query = "SELECT v FROM VDocenteVinculacion v WHERE v.stvcampDesc = :stvcampDesc"),
    @NamedQuery(name = "VDocenteVinculacion.findByNbrjobsDesc", query = "SELECT v FROM VDocenteVinculacion v WHERE v.nbrjobsDesc = :nbrjobsDesc")})
public class VDocenteVinculacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    private BigInteger id;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private BigInteger usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_NOMBRES")
    private String usuNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_APELLIDOS")
    private String usuApellidos;
    @Size(max = 2)
    @Column(name = "PEBEMPL_COLL_CODE")
    private String pebemplCollCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "STVCOLL_DESC")
    private String stvcollDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STVSUBJ_CODE")
    private String stvsubjCode;
    @Size(max = 30)
    @Column(name = "STVSUBJ_DESC")
    private String stvsubjDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "STVCAMP_CODE")
    private String stvcampCode;
    @Size(max = 30)
    @Column(name = "STVCAMP_DESC")
    private String stvcampDesc;
    @Size(max = 30)
    @Column(name = "NBRJOBS_DESC")
    private String nbrjobsDesc;
    @Transient
    private String docente;
    public VDocenteVinculacion() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUsuId() {
        return usuId;
    }

    public void setUsuId(BigInteger usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getPebemplCollCode() {
        return pebemplCollCode;
    }

    public void setPebemplCollCode(String pebemplCollCode) {
        this.pebemplCollCode = pebemplCollCode;
    }

    public String getStvcollDesc() {
        return stvcollDesc;
    }

    public void setStvcollDesc(String stvcollDesc) {
        this.stvcollDesc = stvcollDesc;
    }

    public String getStvsubjCode() {
        return stvsubjCode;
    }

    public void setStvsubjCode(String stvsubjCode) {
        this.stvsubjCode = stvsubjCode;
    }

    public String getStvsubjDesc() {
        return stvsubjDesc;
    }

    public void setStvsubjDesc(String stvsubjDesc) {
        this.stvsubjDesc = stvsubjDesc;
    }

    public String getStvcampCode() {
        return stvcampCode;
    }

    public void setStvcampCode(String stvcampCode) {
        this.stvcampCode = stvcampCode;
    }

    public String getStvcampDesc() {
        return stvcampDesc;
    }

    public void setStvcampDesc(String stvcampDesc) {
        this.stvcampDesc = stvcampDesc;
    }

    public String getNbrjobsDesc() {
        return nbrjobsDesc;
    }

    public void setNbrjobsDesc(String nbrjobsDesc) {
        this.nbrjobsDesc = nbrjobsDesc;
    }

    public String getDocente() {
         if(nbrjobsDesc!=null){
           
         docente = "DOCENTE  "+nbrjobsDesc;
        
        }
      
      
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }
    
}
