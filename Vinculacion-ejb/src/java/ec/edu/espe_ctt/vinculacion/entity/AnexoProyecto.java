/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.io.Serializable;
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
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVANEXOSPR")
@XmlRootElement
public class AnexoProyecto implements Serializable{

    private static final long serialVersionUID = 1L;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVANEXOSPR", sequenceName = "SEQ_SZDTAVANEXOSPR", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVANEXOSPR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZVTANEXOSPR_CODE")
    private Integer id;
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usuario;
    @Column(name = "SZVTANEXOSPR_FECH_SUBIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSubida;
    @Size(max = 100)
    @Column(name = "SZVTANEXOSPR_NOMBRE")
    private String archivoNombre;
    @Size(max = 250)
    @Column(name = "SZVTANEXOSPR_URL")
    private String archivoUrl;
    @Column(name = "SZVTANEXOSPR_TIPO")
    private Integer tipo;
    
    
    public final static Integer TIPO_IMG_DIAGNOSTICO_PROBLEMA=0;
    public final static Integer TIPO_ACTA_REUNION=1;
    public final static Integer TIPO_FOTOGRAFIA_VIDEO=2;
    public final static Integer TIPO_REGISTRO_BENEFICIARIOS=3;
    public final static Integer TIPO_OTROS=4;
    

    public AnexoProyecto() {
        fechaSubida= new Date();
    }

    public AnexoProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getArchivoNombre() {
        return archivoNombre;
    }

    public void setArchivoNombre(String archivoNombre) {
        this.archivoNombre = archivoNombre;
    }

    public String getArchivoUrl() {
        return archivoUrl;
    }

    public String getArchivoUrlFinal() {
        try {
            return this.archivoUrl + this.archivoNombre;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void setArchivoUrl(String archivoUrl) {
        this.archivoUrl = archivoUrl;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof AnexoProyecto)) {
            return false;
        }
        AnexoProyecto other = (AnexoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.AnexoProyecto[ id=" + id + " ]";
    }

    public String getTipoDesc(){
        switch (tipo){
            case 1:
                return "Acta de Reunión";
            case 2:
                return "Fotografía o Video";
            case 3:
                return "Registro de Beneficiarios";
            case 4:
                return "Otros";
            default:
                return "";
        }
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
    
}
