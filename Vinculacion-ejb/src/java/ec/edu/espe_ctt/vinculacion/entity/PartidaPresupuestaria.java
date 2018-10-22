/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
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
@Table(name = "SZDTAVCLASPRE")
@XmlRootElement
public class PartidaPresupuestaria implements Serializable {
   
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVCLASPRE", sequenceName = "SEQ_SZDTAVCLASPRE", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVCLASPRE")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVCLASPRE_CODE")
    private Integer id;
    @JoinColumn(name = "SCP_ID", referencedColumnName = "SCP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaClasificadorPresup clasificadorPresupuesto;
    @Size(max = 1)
    @Column(name = "SZTVCLASPRE_ESTADO")
    private String estado;
    @Size(max = 1)
    @Column(name = "SZTVCLASPRE_TIPO")
    private String tipo;
    public final static String TIPO_CORRIENTE= "C";
    public final static String TIPO_INVERSION= "I";

    public PartidaPresupuestaria() {
        this.estado = "A";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SeaClasificadorPresup getClasificadorPresupuesto() {
        return clasificadorPresupuesto;
    }

    public void setClasificadorPresupuesto(SeaClasificadorPresup clasificadorPresupuesto) {
        this.clasificadorPresupuesto = clasificadorPresupuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof PartidaPresupuestaria)) {
            return false;
        }
        PartidaPresupuestaria other = (PartidaPresupuestaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.PartidaPresupuestaria[ id=" + id + " ]";
    }

    @Transient
    private String nombreCompleto;
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto=nombreCompleto;
    }
    public String getNombreCompleto() {
        StringBuilder nom = new StringBuilder();
        if (clasificadorPresupuesto != null) {
            nom.append(this.clasificadorPresupuesto.getScpPadre().getScpPadre().getScpPadre().getScpId())
                    .append(". ").append(this.clasificadorPresupuesto.getScpPadre().getScpPadre().getScpPadre().getScpNombre())
                    .append("\r\n").append(this.clasificadorPresupuesto.getScpPadre().getScpPadre().getScpId())
                    .append(". ").append(this.clasificadorPresupuesto.getScpPadre().getScpPadre().getScpNombre())
                    .append("\r\n").append(this.clasificadorPresupuesto.getScpPadre().getScpId())
                    .append(". ").append(this.clasificadorPresupuesto.getScpPadre().getScpNombre())
                    .append("\r\n").append(this.clasificadorPresupuesto.getScpId())
                    .append(". ").append(this.clasificadorPresupuesto.getScpNombre());
        }
        return nom.toString();
    }
    public String getNombrePartida() {
        if (clasificadorPresupuesto != null) {
            return (clasificadorPresupuesto.getScpId().toString() + ". " + clasificadorPresupuesto.getScpNombre());
        }
        else{
            return "";
        }
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
