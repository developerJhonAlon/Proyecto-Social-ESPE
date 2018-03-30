/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SZDTAVPRESUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoProyecto.findAll", query = "SELECT p FROM PresupuestoProyecto p")})
public class PresupuestoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVPRESUP", sequenceName = "SEQ_SZDTAVPRESUP", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVPRESUP")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTVPRESUP_CODE")
    private BigInteger id;
    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    @JoinColumn(name = "SZTVCLASPRE_CODE", referencedColumnName = "SZTVCLASPRE_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PartidaPresupuestaria partidaPresupuestaria = new PartidaPresupuestaria();
    @Column(name = "SZTVPRESUP_TIPO")
    private Integer tipo;
    public static final Integer TIPO_APORTE_UNIVERSIDAD = 1;
    public static final Integer TIPO_APORTE_ENTIDAD_AUSPICIANTE = 2;
    public static final Integer TIPO_APORTE_COMUNIDAD_BENEFICIARIA = 3;
    
    @Column(name = "SZTVPRESUP_CANTIDAD")
    private Integer cantidad;
    @Column(name = "SZTVPRESUP_VALOR")
    private BigDecimal valor;
    @Column(name = "SZTVPRESUP_TOTAL_EJEC")
    private BigDecimal totalEjecutado;
    @Size(max = 250)
    @Column(name = "SZTVPRESUP_BIEN_SERVICIO")
    private String bienServicio;
    @Size(max = 250)
    @Column(name = "SZTVPRESUP_ESPTECNIC")
    private String especificacionesTecnicas;
    
    @Size(max = 1)
    @Column(name = "SZTVPRESUP_TIPOGASTO")
    private String tipoGasto;
    public static final String TIPO_GASTO_CORRIENTE = "C";   //Gasto Permanente
    public static final String TIPO_GASTO_INVERSION = "I";   //Gasto No Permanente

    public PresupuestoProyecto() {
    }

    public PresupuestoProyecto(Proyecto proyecto, Integer tipo) {
        this.proyecto = proyecto;
        this.tipo = tipo;
    }

    public PresupuestoProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public PresupuestoProyecto(BigInteger sztvpresupCode) {
        this.id = sztvpresupCode;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public PartidaPresupuestaria getPartidaPresupuestaria() {
        return partidaPresupuestaria;
    }

    public void setPartidaPresupuestaria(PartidaPresupuestaria partidaPresupuestaria) {
        this.partidaPresupuestaria = partidaPresupuestaria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public String getTipoGastoStr() {
        if (tipoGasto!=null && tipoGasto.equals("C")) {
            return "Permanente";
        } else {
            return "No Permanente";
        }
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
        if (!(object instanceof PresupuestoProyecto)) {
            return false;
        }
        PresupuestoProyecto other = (PresupuestoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.PresupuestoProyecto[ id=" + id + " ]";
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getBienServicio() {
        return bienServicio;
    }

    public void setBienServicio(String bienServicio) {
        this.bienServicio = bienServicio;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getTotal() {
        if (valor == null || cantidad == null) {
            return BigDecimal.ZERO;
        }
        return valor.multiply(new BigDecimal(cantidad));
    }

    @Transient
    private String nombreCompleto;

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        if (partidaPresupuestaria != null) {
            return partidaPresupuestaria.getNombreCompleto();
        } else {
            return bienServicio;
        }
    }

    public String getNombrePartida() {
        if (partidaPresupuestaria != null) {
            return (partidaPresupuestaria.getNombrePartida());
        } else {
            return bienServicio;
        }
    }

    public BigDecimal getTotalEjecutado() {
        return totalEjecutado;
    }

    public void setTotalEjecutado(BigDecimal totalEjecutado) {
        this.totalEjecutado = totalEjecutado;
    }

    public String getTipoStr() {
        if (null!=tipo) switch (tipo) {
            case 1:
                return "APORTE UNIVERSIDAD";
            case 2:
                return "APORTE ENTIDAD AUSPICIANTE";
            default:
                return "APORTE COMUNIDAD BENEFICIARIA";
        }
        return "";
    }

}
