/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC1
 */
@Entity
@Table(name = "SZDTAVEVALPROYF")
@XmlRootElement
public class DetalleEvaluacionFinalProyecto implements Serializable{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVEVALPROYF", sequenceName = "SEQ_SZDTAVEVALPROYF", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVEVALPROYF")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVEVALPROYF_CODE")
    private Integer id;

    @JoinColumn(name = "SZTVCABEVALPF_CODE", referencedColumnName = "SZTVCABEVALPF_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private EvaluacionFinalProyecto evaluacionFinalProyecto;
    
    @JoinColumn(name = "SZTVALORPAR_CODE", referencedColumnName = "SZTVALORPAR_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ValoracionParametroEvaluacion valoracionParametroEvaluacion;
    
    @Size(max = 500)
    @Column(name = "SZTVEVALPROYF_INFOADIC")
    private String infoAdicional;
    
    

    
    
 
    @Column(name = "SZTVEVALPROYF_ASPEVA")
    private String idAspectoEvaluacion;
    public static final String ASPECTO_EVALUACION_BENEFICIARIO_DIRECTO = "1.1";
    public static final String ASPECTO_EVALUACION_PRESUPUESTO_UNIVERSIDAD = "2.1";
    public static final String ASPECTO_EVALUACION_PRESUPUESTO_UNIVERSIDAD_VALORADO = "2.2";
    public static final String ASPECTO_EVALUACION_PRESUPUESTO_ENTIDAD_AUSPICIANTE = "2.3";
    public static final String ASPECTO_EVALUACION_PRESUPUESTO_COMUNIDAD_BENEFICIARIA = "2.4";
    
    @JoinColumn(name = "SVOP_ID", referencedColumnName = "SVOP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoPrograma objetivoMatrizMarcoLogico;

    @Column(name = "SZTVEVALPROYF_PUNTAJE")
    private Integer puntaje;

    public DetalleEvaluacionFinalProyecto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ValoracionParametroEvaluacion getValoracionParametroEvaluacion() {
        return valoracionParametroEvaluacion;
    }

    public void setValoracionParametroEvaluacion(ValoracionParametroEvaluacion valoracionParametroEvaluacion) {
        this.valoracionParametroEvaluacion = valoracionParametroEvaluacion;
    }

    public EvaluacionFinalProyecto getEvaluacionFinalProyecto() {
        return evaluacionFinalProyecto;
    }

    public void setEvaluacionFinalProyecto(EvaluacionFinalProyecto evaluacionFinalProyecto) {
        this.evaluacionFinalProyecto = evaluacionFinalProyecto;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
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
        if (!(object instanceof DetalleEvaluacionFinalProyecto)) {
            return false;
        }
        DetalleEvaluacionFinalProyecto other = (DetalleEvaluacionFinalProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetalleEvaluacionFinalProyecto[ id=" + id + " ]";
    }

    public String getIdAspectoEvaluacion() {
        return idAspectoEvaluacion;
    }

    public void setIdAspectoEvaluacion(String idAspectoEvaluacion) {
        this.idAspectoEvaluacion = idAspectoEvaluacion;
    }

 
    public ObjetivoPrograma getObjetivoMatrizMarcoLogico() {
        return objetivoMatrizMarcoLogico;
    }

    public void setObjetivoMatrizMarcoLogico(ObjetivoPrograma objetivoMatrizMarcoLogico) {
        this.objetivoMatrizMarcoLogico = objetivoMatrizMarcoLogico;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    
    

}