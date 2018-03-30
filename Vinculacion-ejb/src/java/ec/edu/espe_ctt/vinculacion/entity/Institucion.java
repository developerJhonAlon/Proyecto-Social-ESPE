/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVINSTITUC")
@XmlRootElement
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVINSTITUC", sequenceName = "SEQ_SZDTAVINSTITUC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVINSTITUC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZVTAINSTITUC_CODE")
    private Integer id;
    @Size(max = 100)
    @Column(name = "SZVTAINSTITUC_NOMBRE")
    private String nombre;
    @JoinColumn(name = "PRQ_ID", referencedColumnName = "PRQ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParroquia parroquia;
    @Size(max = 100)
    @Column(name = "SZVTAINSTITUC_CALLE")
    private String direccion;
    @Size(max = 30)
    @Column(name = "SZVTAINSTITUC_TELEFONO")
    private String telefono;
    @Size(max = 50)
    @Column(name = "SZVTAINSTITUC_NOMREPL")
    private String representanteNombres;
    @Size(max = 50)
    @Column(name = "SZVTAINSTITUC_APELLIRL")
    private String representanteApellidos;
    @Size(max = 50)
    @Column(name = "SZVTAINSTITUC_CARGORL")
    private String representanteCargo;
    @Size(max = 30)
    @Column(name = "SZVTAINSTITUC_TELREPL")
    private String representanteTelefono;
    @Size(max = 50)
    @Column(name = "SZVTAINSTITUC_MAILRL1")
    private String representanteEmail;
    @Size(max = 1)
    @Column(name = "SZVTAINSTITUC_ESTADO")
    private String estado;
    
    public final static String ESTADO_ACTIVO="A";
    public final static String ESTADO_INACTIVO="I";

    public Institucion() {
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

    public SeaParroquia getParroquia() {
        return parroquia;
    }

    public void setParroquia(SeaParroquia parroquia) {
        this.parroquia = parroquia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRepresentanteNombres() {
        return representanteNombres;
    }

    public void setRepresentanteNombres(String representanteNombres) {
        this.representanteNombres = representanteNombres;
    }

    public String getRepresentanteApellidos() {
        return representanteApellidos;
    }

    public void setRepresentanteApellidos(String representanteApellidos) {
        this.representanteApellidos = representanteApellidos;
    }

    public String getRepresentanteCargo() {
        return representanteCargo;
    }

    public void setRepresentanteCargo(String representanteCargo) {
        this.representanteCargo = representanteCargo;
    }

    public String getRepresentanteTelefono() {
        return representanteTelefono;
    }

    public void setRepresentanteTelefono(String representanteTelefono) {
        this.representanteTelefono = representanteTelefono;
    }

    public String getRepresentanteEmail() {
        return representanteEmail;
    }

    public void setRepresentanteEmail(String representanteEmail) {
        this.representanteEmail = representanteEmail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Transient
    private boolean activa;

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
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
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Institucion[ id=" + id + " ]";
    }

}
