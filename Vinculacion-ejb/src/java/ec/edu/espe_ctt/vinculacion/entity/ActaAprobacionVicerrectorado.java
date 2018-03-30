/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
@Table(name = "SZDTAVACTAPRUEBA")
@XmlRootElement
public class ActaAprobacionVicerrectorado implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SZDTAVACTAPRUEBA", sequenceName = "SEQ_SZDTAVACTAPRUEBA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVACTAPRUEBA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAVACTAPRUEBA_CODE")
    private Integer id;

    @Column(name = "SZDTAVACTAPRUEBA_FECHA_APRUEBA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "SZDTAVACTAPRUEBA_SECUENCIAL_A")
    private Integer secuencial;

    
    @JoinColumn(name = "USU_ID_APRUEBA", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;

    /*@Size(max = 1)
    @Column(name = "SZDTAVACTAPRUEBA_CERRADO")
    private String estadoCerrado;
    public final static String ESTADO_CERRADO_SI = "S";
    public final static String ESTADO_CERRADO_NO = "N";*/
    @Size(max = 250)
    @Column(name = "SZDTAVACTAPRUEBA_DOC_NOM")
    private String documentoFirmadoNombre;
    @Size(max = 100)
    @Column(name = "SZDTAVACTAPRUEBA_DOC_URL")
    private String documentoFirmadoUrl;

    @OneToMany(mappedBy = "actaAprobacionVicerrectorado", fetch = FetchType.LAZY)
    private List<Proyecto> proyectoList = new ArrayList<>();

    public ActaAprobacionVicerrectorado() {
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

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public String getDocumentoUrlFinal() {
        try {
            return this.documentoFirmadoUrl + this.documentoFirmadoNombre;
        } catch (Exception e) {
            return null;
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
        result = result + "-" + cal.get(Calendar.YEAR) + "-VIITT";
        return result;
    }

    /*@Transient
    private List<ComisionCalificacion> comisionList;*/

    public List<ComisionCalificacion> getComisionList() {
        List<ComisionCalificacion> comisionList = new ArrayList<>();
        for (Proyecto p : proyectoList) {
            if (!p.isEstadoNoAprobadoVicerrectorado() && p.getComisionCalificacion()!=null) {
                boolean encontro = false;
                for (ComisionCalificacion c : comisionList) {
                    if (c.equals(p.getComisionCalificacion())) {
                        encontro = true;
                        break;
                    }
                }
                if (!encontro) {
                    comisionList.add(p.getComisionCalificacion());
                }
            }
        }
        for (ComisionCalificacion c : comisionList) {
            c.setNroProyectos(0);
            for (Proyecto p : proyectoList) {
                if (!p.isEstadoNoAprobadoVicerrectorado()) {
                    if (p.getComisionCalificacion()!=null && p.getComisionCalificacion().equals(c)){
                        c.addNroProyectos();
                    }
                }
            }
        }
        return comisionList;
    }
    public Integer getNroProyectosAprobados(){
        Integer result = 0;
        for (Proyecto p : proyectoList) {
            if (!p.isEstadoNoAprobadoVicerrectorado() && p.getComisionCalificacion()!=null) {
                result++;
            }
        }
        return result;
    }

    /*public void setComisionList(List<ComisionCalificacion> comisionList) {
        this.comisionList = comisionList;
    }*/


}
