/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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

    @Size(max = 100)
    @Column(name = "SZTVPRESUP_VALORANUAL")
    private String valorAnual;
    
    @OneToMany(mappedBy = "presupuestoProyecto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CantidadAnualProyecto> cantidadAnualProyectoList;

    
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

//    public BigDecimal getTotalAnual(){
//        if(valorAnualUSD == null){
//            return BigDecimal.ZERO;
//        }
//        else{
//            BigDecimal valor2 = new BigDecimal(0);
//            for (CantidadAnual usb : valorAnualUSD) {
//                System.out.println(usb.getCantidad());
//                valor2 = valor2.add(usb.getCantidad()); 
//            }
//            return valor2;
//        }
//               
//    }
//    
    
    public BigDecimal getTotalCantidadAnual(){
        if(cantidadAnualProyectoList == null){
            return BigDecimal.ZERO;
        }
        else{
            BigDecimal valor2 = new BigDecimal(0);
            for (CantidadAnualProyecto usb : cantidadAnualProyectoList) {
                System.out.println(usb.getCantidadAnual());
                valor2 = valor2.add(usb.getCantidadAnual()); 
            }
            return valor2;
        }
               
    }
    
    @Transient
    private String nombreCompleto;
    
//    @Transient
//    private BigDecimal anio1;
//    
//    @Transient
//    private BigDecimal anio2;
//    
//    @Transient
//    private BigDecimal anio3;
//    
//    @Transient
//    private BigDecimal anio4;
//
//    @Transient
//    private BigDecimal anio5;
//
//    public BigDecimal getAnio1() {
//        return cantidadAnualProyectoList.size()==1?cantidadAnualProyectoList.get(0).getCantidadAnual():null;
//    }
//
//
//    public BigDecimal getAnio2() {
//         return cantidadAnualProyectoList.size()==2?cantidadAnualProyectoList.get(1).getCantidadAnual():null;
//    }
//
//   
//    public BigDecimal getAnio3() {
//         return cantidadAnualProyectoList.size()==3?cantidadAnualProyectoList.get(2).getCantidadAnual():null;
//    }
//
//    public void setAnio3(BigDecimal anio3) {
//        this.anio3 = anio3;
//    }
//
//    public BigDecimal getAnio4() {
//         return cantidadAnualProyectoList.size()==4?cantidadAnualProyectoList.get(3).getCantidadAnual():null;
//    }
//
//    public void setAnio4(BigDecimal anio4) {
//        this.anio4 = anio4;
//    }
//
//    public BigDecimal getAnio5() {
//         return cantidadAnualProyectoList.size()==5?cantidadAnualProyectoList.get(4).getCantidadAnual():null;
//        
//    }
//
//    public void setAnio5(BigDecimal anio5) {
//        this.anio5 = anio5;
//    }
//   
    
    
    
//    @Transient
//    private List<CantidadAnual> valorAnualUSD = new ArrayList<>();

    
    
    
//    public List<CantidadAnual> getValorAnualUSD() {
//        return valorAnualUSD;
//    }
//
//    public void setValorAnualUSD(List<CantidadAnual> valorAnualUSD) {
//        this.valorAnualUSD = valorAnualUSD;
//    }

     public List<CantidadAnualProyecto> setearCantidadAnual() {
        cantidadAnualProyectoList = new ArrayList<>();
        int[] tiempo = proyecto.getDuracionNum();
        int anios = tiempo[0];
        int meses = tiempo[1];
        anios = meses>0?anios+1:anios;
        for (int i = 1; i <= anios; i++) {
            CantidadAnualProyecto m = new CantidadAnualProyecto(i+"º año:",new BigDecimal(0),this);
            cantidadAnualProyectoList.add(m);
         }
        return cantidadAnualProyectoList;
    }
    
    
//    public List<CantidadAnual> setearValorAnualUSD() {
//        int[] dur = proyecto.getDuracionNum();
//        
//        int aux2 = dur[0];
//        int aux1 = dur[1];
//        if(valorAnual != null){
//            if(aux1 == 0){
//                    String[] valores = valorAnual.split(";");
//                    int i = 0;
//                    for (String valore : valores) {
//                        i++;
//                        CantidadAnual m = new CantidadAnual(i+"º año:",new BigDecimal(valore));
//                        valorAnualUSD.add(m);
//                    }
//           
//            }else{
//                    String[] valores = valorAnual.split(";");
//                   
//                    for (int i=1;i<=valores.length;i++) {
//                        if(i!=valores.length){ 
//                            CantidadAnual m = new CantidadAnual(i+"º año:",new BigDecimal(valores[i--]));
//                        valorAnualUSD.add(m);}
//                        else{
//                              CantidadAnual m = new CantidadAnual(aux1+" mes(es):",new BigDecimal(valores[i--]));
//                        valorAnualUSD.add(m);}
//                      
//                    }
//            }
//           return valorAnualUSD;
//        }else{
//            for (int i = 1; i <= aux2; i++) {
//            CantidadAnual m = new CantidadAnual(i+"º año:",new BigDecimal(0));
//            valorAnualUSD.add(m);
//                }
//                if(aux1 > 0){
//            CantidadAnual m = new CantidadAnual(aux1+" mes(es):",new BigDecimal(0));
//            valorAnualUSD.add(m);
//                };
//                return valorAnualUSD;
//        }
//    }

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

//    //Mostrar en tabla
//    public String getValorAnual() {
//        int[] dur = proyecto.getDuracionNum();
//        int aux1 = dur[1];
//        
//        StringBuilder anual = new StringBuilder();
//        if(valorAnual != null){
//            if(aux1 == 0){
//                    String[] valores = valorAnual.split(";");
//                    int i = 0;
//                    for (String valore : valores) {
//                        anual.append(i++).append("º año:").append(valore).append("\r\n");
//                    }
//           
//            }else{
//                    String[] valores = valorAnual.split(";");
//                   
//                    for (int i=1;i<=valores.length;i++) {
//                        if(i!=valores.length){  anual.append(i).append("º año:").append(valores[i--]).append("\r\n");}
//                        else{anual.append(i).append(" mes(es):").append(valores[i--]).append("\r\n");}
//                      
//                    }
//            }
//           return anual.toString();
//        }else{
//            return null;
//        }
//       
//    }
    
    private String decimalToString(BigDecimal valor) {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0.00";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }

    public String getMostrarCantidadAnual(){
        StringBuilder anual = new StringBuilder();
        Collections.sort(cantidadAnualProyectoList);
        for (CantidadAnualProyecto var : cantidadAnualProyectoList) {
             anual.append(var.getDescripcion()).append("  ").append(decimalToString(var.getCantidadAnual())).append("\r\n");
        }
        return anual.toString();
       
    }
    
    public void setValorAnual(String valorAnual) {
        this.valorAnual = valorAnual;
    }


    @XmlTransient
    public List<CantidadAnualProyecto> getCantidadAnualProyectoList() {
       
        return cantidadAnualProyectoList;
    }

    public void setCantidadAnualProyectoList(List<CantidadAnualProyecto> cantidadAnualProyectoList) {
        this.cantidadAnualProyectoList = cantidadAnualProyectoList;
    }        
}
