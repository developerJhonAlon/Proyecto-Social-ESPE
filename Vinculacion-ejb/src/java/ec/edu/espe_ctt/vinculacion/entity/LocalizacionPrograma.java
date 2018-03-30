/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVZONA_DETALLE")
@XmlRootElement
public class LocalizacionPrograma implements Serializable, Comparable<LocalizacionPrograma> {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name = "SEQ_SZDTAVZONA_DETALLE", sequenceName = "SEQ_SZDTAVZONA_DETALLE", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVZONA_DETALLE")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZONDETA_ID")
    private BigDecimal id;
    @JoinColumn(name = "SPRV_ID", referencedColumnName = "SPRV_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;
    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaProvincia provincia;
    @JoinColumn(name = "CAN_ID", referencedColumnName = "CAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaCanton canton;
    @JoinColumn(name = "PRQ_ID", referencedColumnName = "PRQ_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParroquia parroquia;
    @Size(max = 2000)
    @Column(name = "ZONDETA_OBJETIVOS")
    private String objetivos;


    public LocalizacionPrograma() {
    }

    public LocalizacionPrograma(BigDecimal zondetaId) {
        this.id = zondetaId;
    }
    public LocalizacionPrograma(SeaProvincia provincia) {
        this.provincia = provincia;
    }
    public LocalizacionPrograma(SeaCanton canton) {
        this.canton = canton;
        this.provincia = this.canton.getProId();
    }
    public LocalizacionPrograma(SeaParroquia parroquia) {
        
        this.parroquia = parroquia;
        this.canton = this.parroquia.getCanId();
        this.provincia = this.canton.getProId();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public SeaProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(SeaProvincia provincia) {
        this.provincia = provincia;
    }

    public SeaCanton getCanton() {
        return canton;
    }

    public void setCanton(SeaCanton canton) {
        this.canton = canton;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public SeaParroquia getParroquia() {
        return parroquia;
    }

    public void setParroquia(SeaParroquia parroquia) {
        this.parroquia = parroquia;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
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
        if (!(object instanceof LocalizacionPrograma)) {
            return false;
        }
        LocalizacionPrograma other = (LocalizacionPrograma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitty.LocalizacionPrograma[ zondetaId=" + id + " ]";
    }
    
    @Transient
    public String getNombre()
    {
        if (this.parroquia!=null)
            return this.parroquia.getPrqNombre();
        else if (this.canton!=null)
            return this.canton.getCanNombre();
        else if (this.provincia!=null)
            return this.provincia.getProNombre();
        else
            return "";
    }

    public boolean comparar(LocalizacionPrograma svinZonaDetalleBuscar)
    {
        if (svinZonaDetalleBuscar.getParroquia()!=null)
        {
            if (this.getParroquia()!=null 
                    && this.getProvincia().getProId().equals(svinZonaDetalleBuscar.getProvincia().getProId())
                    && this.getCanton().getCanId().equals(svinZonaDetalleBuscar.getCanton().getCanId())
                    && this.getParroquia().getPrqId().equals(svinZonaDetalleBuscar.getParroquia().getPrqId())
                    )
            {
                return true;
            }
        }
        else if (svinZonaDetalleBuscar.getCanton()!=null)
        {
            if (this.getCanton()!=null 
                    && this.getProvincia().getProId().equals(svinZonaDetalleBuscar.getProvincia().getProId())
                    && this.getCanton().getCanId().equals(svinZonaDetalleBuscar.getCanton().getCanId())
                    && this.getParroquia()==null)
            {
                return true;
            }
        }
        else
        {
            if (this.getProvincia().getProId().equals(svinZonaDetalleBuscar.getProvincia().getProId())
                    && this.getCanton()==null
                    && this.getParroquia()==null)
            {
                return true;
            }
        }
        return false;
    }
    
    public String getNomProvincia()
    {
        if (this.provincia!=null)
        {
            return this.provincia.getProNombre();
        }
        return "";
    }
    public String getNomCanton()
    {
        if (this.canton!=null)
        {
            return this.canton.getCanNombre();
        }
        return "";
    }
    public String getNomParroquia()
    {
        if (this.parroquia!=null)
        {
            return this.parroquia.getPrqNombre();
        }
        return "";
    }

    @Override
    public int compareTo(LocalizacionPrograma o) {
        int comp=0;
        comp = this.getNomProvincia().compareTo(o.getNomProvincia());
        if (comp!=0){
            return comp;
        }
        comp  = this.getNomCanton().compareTo(o.getNomCanton());
        if (comp!=0){
            return comp;
        }
        return this.getNomParroquia().compareTo(o.getNomParroquia());
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    

}
