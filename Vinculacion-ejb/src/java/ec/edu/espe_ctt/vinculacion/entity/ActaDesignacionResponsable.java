/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVACTARESPONSA")
@XmlRootElement
public class ActaDesignacionResponsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SZDTAVACTARESPONSA", sequenceName = "SEQ_SZDTAVACTARESPONSA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVACTARESPONSA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAVACTARESPONSA_CODE")
    private Integer id;

    @Column(name = "SZDTAVACTARESPONSA_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "SZDTAVACTARESPONSA_SECUENCIAL")
    private Integer secuencial;

    @JoinColumn(name = "USU_ID_CREA", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;

    /*@Size(max = 1)
    @Column(name = "SZDTAVACTARESPONSA_CERRADO")
    private String estadoCerrado;
    public final static String ESTADO_CERRADO_SI = "S";
    public final static String ESTADO_CERRADO_NO = "N";*/
    
    @Size(max = 250)
    @Column(name = "SZDTAVACTARESPONSA_DOC_NOM")
    private String documentoFirmadoNombre;
    @Size(max = 100)
    @Column(name = "SZDTAVACTARESPONSA_DOC_URL")
    private String documentoFirmadoUrl;
    
    @OneToMany(mappedBy = "actaDesignacionResponsable", fetch = FetchType.LAZY)
    private List<ResponsableProyecto> responsableList = new ArrayList<>();


    public ActaDesignacionResponsable() {
        fechaCreacion = new Date();
        //estadoCerrado = ESTADO_CERRADO_NO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    /*public String getEstadoCerrado() {
        return estadoCerrado;
    }

    public void setEstadoCerrado(String estadoCerrado) {
        this.estadoCerrado = estadoCerrado;
    }*/

    public String getDocumentoFirmadoNombre() {
        return documentoFirmadoNombre;
    }

    public void setDocumentoFirmadoNombre(String documentoFirmadoNombre) {
        this.documentoFirmadoNombre = documentoFirmadoNombre;
    }

    public String getDocumentoFirmadoUrl() {
        return documentoFirmadoUrl;
    }

    public void setDocumentoFirmadoUrl(String documentoFirmadoUrl) {
        this.documentoFirmadoUrl = documentoFirmadoUrl;
    }

    public List<ResponsableProyecto> getResponsableList() {
        Collections.sort(responsableList);
        return responsableList;
    }

    public void setResponsableList(List<ResponsableProyecto> responsableList) {
        this.responsableList = responsableList;
    }


    public String getDocumentoFirmadoUrlFinal() {
        try {
            return this.documentoFirmadoUrl + this.documentoFirmadoNombre;
        } catch (Exception e) {
            return null;
        }
    }    
    
      
    @Transient
    private List<VDirectorDepartamento> directorDepartamentoList;

    public List<VDirectorDepartamento> getDirectorDepartamentoList() {
        Collections.sort(directorDepartamentoList);
        return directorDepartamentoList;
    }

    public void setDirectorDepartamentoList(List<VDirectorDepartamento> directorDepartamentoList) {
        this.directorDepartamentoList = directorDepartamentoList;
    }
    @Transient
    private List<VDirectorCarrera> directorCarreraList;

    public List<VDirectorCarrera> getDirectorCarreraList() {
        Collections.sort(directorCarreraList);
        return directorCarreraList;
    }

    public void setDirectorCarreraList(List<VDirectorCarrera> directorCarreraList) {
        this.directorCarreraList = directorCarreraList;
    }
    
    public void llenarDatosDirectores(List<VDirectorDepartamento> directorList){
        directorDepartamentoList = new ArrayList<>();
        for (ResponsableProyecto r : responsableList) {
            boolean encontro=false;
            for (VDirectorDepartamento d : directorDepartamentoList) {
                if (d.getCampus().equals(r.getCampus()) && d.getDepartamento().equals(r.getDepartamento())){
                    encontro=true;
                    break;
                }
            }
            if (!encontro){
                for (VDirectorDepartamento d : directorList) {
                    if (d.getCampus()!=null && d.getDepartamento()!=null){
                        if (r.getCampus()!=null && r.getDepartamento()!=null){
                            if (r.getCampus().equals(d.getCampus()) && r.getDepartamento().equals(d.getDepartamento())){
                                directorDepartamentoList.add(d);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void llenarDatosDirectorCarrera(List<VDirectorCarrera> directorList){
        directorCarreraList = new ArrayList<>();
        for (ResponsableProyecto r : responsableList) {
            boolean encontro=false;
            for (VDirectorCarrera d : directorCarreraList) {
                if (d.getCarrera().equals(r.getCarrera())){
                    encontro=true;
                    break;
                }
            }
            if (!encontro){
                for (VDirectorCarrera d : directorList) {
                    if (d.getCarrera()!=null){
                        if (r.getCarrera().equals(d.getCarrera())){
                            directorCarreraList.add(d);
                            break;
                        }
                    }
                }
            }
        }
    }
    public String getSecuencialStr() {
        String result = null;
        if (secuencial < 10) {
            result = "00" + secuencial.toString();
        } else if (secuencial < 100) {
            result = "0" + secuencial.toString();
        }
        else{
            result = secuencial.toString();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCreacion);
        result = result + "-" + cal.get(Calendar.YEAR);
        return result;
    }

    public Integer getDirectorCarreraListSize(){
        if (directorCarreraList==null){
            return 0;
        }
        return directorCarreraList.size();
    }
    
    public Integer getDirectorDepartamentoListSize(){
        if (directorDepartamentoList==null){
            return 0;
        }
        return directorDepartamentoList.size();
    }

}
