/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author PC1
 */
@ManagedBean
@ApplicationScoped
public class ParametrosApplication implements Serializable {

    
    
    
    private TimeZone timeZone;
    private Locale locale;
    private String formatoFecha;
    private String formatoFechaHora;
    private String formatoFechaHoraSMS;
    private String formatoMesAnio;
    private String formatoHora;
    private String formatoHoraSMS;
    private String local;
    private Integer numeroFilasTabla;
    private Boolean iniciarConteoManual;
    private List<String> codigosBodega;
    private List<String> pacientesAlta;
   
    

    /**
     * Creates a new instance of ParametrosApplication
     */
    public ParametrosApplication() {
        this.timeZone = TimeZone.getTimeZone("GMT-5");
        this.locale = new Locale("ISO-8859-1", "es_EC");
        this.local = "es";
        this.formatoHora = "HH:mm:ss";
        this.formatoHoraSMS = "HH:mm";
        this.formatoFecha = "dd/MM/yyyy";
        this.formatoFechaHora = "dd/MM/yyyy HH:mm:ss";
        this.formatoFechaHoraSMS = "dd/MM/yyyy HH:mm";
        this.formatoMesAnio = "MM/yyyy";
        //this.numeroFilasTabla = Integer.parseInt(FacesUtils.getResourceBundle().getString("FILAS_TABLA"));
        this.iniciarConteoManual=false;
        this.codigosBodega=new ArrayList<String>();
        this.pacientesAlta = new ArrayList<String>();
    }
    
    @PostConstruct
    void init() {
        
        
    }

    
    public Boolean existeBodega(String codigoBodega){
        for (String codigo:this.codigosBodega){
            if (codigo.equals(codigoBodega)){
                return true;
            }
        }
        return false;
    }

    
    public void cerrarBodega(String codigoBodega){
        if (this.codigosBodega != null){
            this.codigosBodega.remove(codigoBodega);
        
        }
    }
    
    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public String getFormatoFechaHora() {
        return formatoFechaHora;
    }

    public void setFormatoFechaHora(String formatoFechaHora) {
        this.formatoFechaHora = formatoFechaHora;
    }

    public String getFormatoFechaHoraSMS() {
        return formatoFechaHoraSMS;
    }

    public void setFormatoFechaHoraSMS(String formatoFechaHoraSMS) {
        this.formatoFechaHoraSMS = formatoFechaHoraSMS;
    }

    public String getFormatoMesAnio() {
        return formatoMesAnio;
    }

    public void setFormatoMesAnio(String formatoMesAnio) {
        this.formatoMesAnio = formatoMesAnio;
    }

    public String getFormatoHora() {
        return formatoHora;
    }

    public void setFormatoHora(String formatoHora) {
        this.formatoHora = formatoHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getNumeroFilasTabla() {
        return numeroFilasTabla;
    }

    public void setNumeroFilasTabla(Integer numeroFilasTabla) {
        this.numeroFilasTabla = numeroFilasTabla;
    }

    public Boolean getIniciarConteoManual() {
        return iniciarConteoManual;
    }

    public void setIniciarConteoManual(Boolean iniciarConteoManual) {
        this.iniciarConteoManual = iniciarConteoManual;
    }

    public List<String> getCodigosBodega() {
        return codigosBodega;
    }

    public void setCodigosBodega(List<String> codigosBodega) {
        this.codigosBodega = codigosBodega;
    }

    public List<String> getPacientesAlta() {
        return pacientesAlta;
    }

    public void setPacientesAlta(List<String> pacientesAlta) {
        this.pacientesAlta = pacientesAlta;
    }

    public String getFormatoHoraSMS() {
        return formatoHoraSMS;
    }

    public void setFormatoHoraSMS(String formatoHoraSMS) {
        this.formatoHoraSMS = formatoHoraSMS;
    }
    
}
