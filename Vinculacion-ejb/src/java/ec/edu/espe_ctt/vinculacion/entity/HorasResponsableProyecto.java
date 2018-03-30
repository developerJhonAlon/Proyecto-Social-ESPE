/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVHOREJEC")
@XmlRootElement
public class HorasResponsableProyecto implements Serializable, Comparable<HorasResponsableProyecto> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVHOREJEC", sequenceName = "SEQ_SZDTAVHOREJEC", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVHOREJEC")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVHOREJEC_CODE")
    private Integer id;
    @JoinColumn(name = "SRESPROG_ID", referencedColumnName = "SRESPROG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ResponsableProyecto responsableProyecto;
    @Column(name = "SZTVHOREJEC_FEC_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;
    @Column(name = "SZTVHOREJEC_FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;
    @Column(name = "SZTVHOREJEC_TOTAL")
    private Integer cantidadHoras;

    public HorasResponsableProyecto() {
    }
    public HorasResponsableProyecto(ResponsableProyecto responsableProyecto) {
        this.responsableProyecto= responsableProyecto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResponsableProyecto getResponsableProyecto() {
        return responsableProyecto;
    }

    public void setResponsableProyecto(ResponsableProyecto responsableProyecto) {
        this.responsableProyecto = responsableProyecto;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Integer getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(Integer cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    @Override
    public int compareTo(HorasResponsableProyecto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
