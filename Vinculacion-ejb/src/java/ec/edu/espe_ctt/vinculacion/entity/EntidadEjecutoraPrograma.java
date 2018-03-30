/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SZDTAVOPCION_INSTITUCION")
@XmlRootElement
public class EntidadEjecutoraPrograma implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = " SEQ_SZDTAVOPCION_INSTITUCION", sequenceName = " SEQ_SZDTAVOPCION_INSTITUCION", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " SEQ_SZDTAVOPCION_INSTITUCION")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOPIN_ID")
    private BigDecimal sopinId;
    @Column(name = "SOPIN_ORDEN")
    private BigInteger sopinOrden;
    @Size(max = 100)
    @Column(name = "SOPIN_NOMBRE")
    private String sopinNombre;
    @Column(name = "SOPIN_FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sopinFechaCrea;
    @Size(max = 100)
    @Column(name = "SOPIN_DIRECCION")
    private String sopinDireccion;
    @Size(max = 25)
    @Column(name = "SOPIN_CIUDAD")
    private String sopinCiudad;
    @Size(max = 15)
    @Column(name = "SOPIN_TELEFONO")
    private String sopinTelefono;
    @Size(max = 25)
    @Column(name = "SOPIN_PAGUINA_WEB")
    private String sopinPaguinaWeb;
    @Size(max = 25)
    @Column(name = "SOPIN_MAIL")
    private String sopinMail;
    @Size(max = 15)
    @Column(name = "SOPIN_FAX")
    private String sopinFax;
    @Size(max = 50)
    @Column(name = "SOPIN_REPRESENTA_LEGAL")
    private String sopinRepresentaLegal;
    @Size(max = 10)
    @Column(name = "SOPIN_CEDULA_RL")
    private String sopinCedulaRl;
    @Size(max = 200)
    @Column(name = "SOPIN_ORGANO_EJECUTOR")
    private String sopinOrganoEjecutor;
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaProvincia proId;
    
    /*
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    */

    public EntidadEjecutoraPrograma() {
        sopinTelefono= "(593-2)";
    }

    public EntidadEjecutoraPrograma(BigDecimal sopinId) {
        this.sopinId = sopinId;
    }

    public BigDecimal getSopinId() {
        return sopinId;
    }

    public void setSopinId(BigDecimal sopinId) {
        this.sopinId = sopinId;
    }

    public BigInteger getSopinOrden() {
        return sopinOrden;
    }

    public void setSopinOrden(BigInteger sopinOrden) {
        this.sopinOrden = sopinOrden;
    }

    public String getSopinNombre() {
        return sopinNombre;
    }

    public void setSopinNombre(String sopinNombre) {
        this.sopinNombre = sopinNombre;
    }

    public Date getSopinFechaCrea() {
        return sopinFechaCrea;
    }

    public void setSopinFechaCrea(Date sopinFechaCrea) {
        this.sopinFechaCrea = sopinFechaCrea;
    }

    public String getSopinDireccion() {
        return sopinDireccion;
    }

    public void setSopinDireccion(String sopinDireccion) {
        this.sopinDireccion = sopinDireccion;
    }

    public String getSopinCiudad() {
        return sopinCiudad;
    }

    public void setSopinCiudad(String sopinCiudad) {
        this.sopinCiudad = sopinCiudad;
    }

    public String getSopinTelefono() {
        return sopinTelefono;
    }

    public void setSopinTelefono(String sopinTelefono) {
        this.sopinTelefono = sopinTelefono;
    }

    public String getSopinPaguinaWeb() {
        return sopinPaguinaWeb;
    }

    public void setSopinPaguinaWeb(String sopinPaguinaWeb) {
        this.sopinPaguinaWeb = sopinPaguinaWeb;
    }

    public String getSopinMail() {
        return sopinMail;
    }

    public void setSopinMail(String sopinMail) {
        this.sopinMail = sopinMail;
    }

    public String getSopinFax() {
        return sopinFax;
    }

    public void setSopinFax(String sopinFax) {
        this.sopinFax = sopinFax;
    }

    public String getSopinRepresentaLegal() {
        return sopinRepresentaLegal;
    }

    public void setSopinRepresentaLegal(String sopinRepresentaLegal) {
        this.sopinRepresentaLegal = sopinRepresentaLegal;
    }

    public String getSopinCedulaRl() {
        return sopinCedulaRl;
    }

    public void setSopinCedulaRl(String sopinCedulaRl) {
        this.sopinCedulaRl = sopinCedulaRl;
    }

    public String getSopinOrganoEjecutor() {
        return sopinOrganoEjecutor;
    }

    public void setSopinOrganoEjecutor(String sopinOrganoEjecutor) {
        this.sopinOrganoEjecutor = sopinOrganoEjecutor;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public SeaProvincia getProId() {
        return proId;
    }

    public void setProId(SeaProvincia proId) {
        this.proId = proId;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sopinId != null ? sopinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadEjecutoraPrograma)) {
            return false;
        }
        EntidadEjecutoraPrograma other = (EntidadEjecutoraPrograma) object;
        if ((this.sopinId == null && other.sopinId != null) || (this.sopinId != null && !this.sopinId.equals(other.sopinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EntidadEjecutoraPrograma[ sopinId=" + sopinId + " ]";
    }
}
