/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVCONVOCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convocatoria.findAll", query = "SELECT s FROM Convocatoria s")})
public class Convocatoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = " SEQ_SZDTAVCONVOCA", sequenceName = " SEQ_SZDTAVCONVOCA", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " SEQ_SZDTAVCONVOCA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCONV_ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "SCONV_NOMBRE")
    private String nombre;
    @Size(max = 150)
    @Column(name = "SCONV_OBSERVACION")
    private String observacion;
    @Lob
    @Column(name = "SCONV_DIGITAL")
    private byte[] documento;
    @Size(max = 100)
    @Column(name = "SCONV_DIGITAL_NOMBRE")
    private String nombreDocumento;
    @Size(max = 250)
    @Column(name = "SCONV_DIGITAL_URL")
    private String urlDocumento;

    /*@Size(max = 1)
    @Column(name = "SCONV_ESTADO")
    private String estado;*/
    @Column(name = "SCONV_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "SCONV_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    public Convocatoria() {
        //this.estado = "A";
    }

    public Convocatoria(BigDecimal sconvId) {
        this.id = sconvId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /*public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }*/

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

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public String getNombreDocumentoSeleccionado() {
        if (nombreDocumento == null || nombreDocumento.isEmpty()) {
            return "Ningún documento seleccionado.";
        } else {
            return nombreDocumento;
        }
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public String getUrlFinalDocumento() {
        try {
            return this.urlDocumento + this.nombreDocumento;
        } catch (Exception e) {
            return null;
        }
    }

    public String getFechaInicioTexto() {
        String fechaTexto = "";
        if (fechaInicio != null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", new Locale("ES"));
            fechaTexto = sdf1.format(fechaInicio);
        }
        return fechaTexto;
    }
    public String getFechaFinTexto() {
        String fechaTexto = "";
        if (fechaFin != null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", new Locale("ES"));
            fechaTexto = sdf1.format(fechaFin);
        }
        return fechaTexto;
    }
    
    public boolean getEstadoActivo(){
        Date now = new Date();
        if (fechaInicio!=null && fechaFin!=null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaFin);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            if (now.after(fechaInicio) && now.before(cal.getTime())){
                return true;
            }
        }
        return false;
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
        if (!(object instanceof Convocatoria)) {
            return false;
        }
        Convocatoria other = (Convocatoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Convocatoria[ id=" + id + " ]";
    }

}
