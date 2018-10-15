/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "SZDTAVOBJETIVOS_ESTRA_INSTI")
@XmlRootElement
public class ObjetivoEstrategico implements Serializable {
    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOESI_ID")
    private Integer id;
    @Size(max = 600)
    @Column(name = "SOESI_DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "objetivoEstrategicoPadre", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjetivoEstrategico> objetivoEstrategicoHijoList;
    @JoinColumn(name = "SOESI_PADRE", referencedColumnName = "SOESI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ObjetivoEstrategico objetivoEstrategicoPadre;
    @Column(name = "SZTVTIPESTR_CODE")
    private Integer tipo;
    @JoinColumn(name = "SZTVCONFOBJ_CODE", referencedColumnName = "SZTVCONFOBJ_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConfiguraObjetivo configuraObjetivo;
    
    public final static Integer TIPO_PERSPECTIVA = 1;
    public final static Integer TIPO_OBJETIVO = 2;
    public final static Integer TIPO_INDICADOR = 3;
    public final static Integer TIPO_ESTRATEGIA = 4;

    public ObjetivoEstrategico() {
    }

    public ObjetivoEstrategico(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<ObjetivoEstrategico> getObjetivoEstrategicoHijoList() {
        return objetivoEstrategicoHijoList;
    }

    public void setObjetivoEstrategicoHijoList(List<ObjetivoEstrategico> objetivoEstrategicoHijoList) {
        this.objetivoEstrategicoHijoList = objetivoEstrategicoHijoList;
    }

    public ObjetivoEstrategico getObjetivoEstrategicoPadre() {
        return objetivoEstrategicoPadre;
    }

    public void setObjetivoEstrategicoPadre(ObjetivoEstrategico objetivoEstrategicoPadre) {
        this.objetivoEstrategicoPadre = objetivoEstrategicoPadre;
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
        if (!(object instanceof ObjetivoEstrategico)) {
            return false;
        }
        ObjetivoEstrategico other = (ObjetivoEstrategico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe_ctt.vinculacion.entity.ObjetivoEstrategico[ soesiId=" + id + " ]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ObjetivoEstrategico> getIndicadorList() {
        return getObjetivoEstrategicoHijoList(ObjetivoEstrategico.TIPO_INDICADOR);
    }

    public List<ObjetivoEstrategico> getEstrategiaList() {
        return getObjetivoEstrategicoHijoList(ObjetivoEstrategico.TIPO_ESTRATEGIA);
    }

    private List<ObjetivoEstrategico> getObjetivoEstrategicoHijoList(Integer tipo) {
        List<ObjetivoEstrategico> temp = new ArrayList<>();
        if (objetivoEstrategicoHijoList!=null){
            for (ObjetivoEstrategico obj : objetivoEstrategicoHijoList) {
                if (obj.getTipo().equals(tipo)) {
                    temp.add(obj);
                }
            }
            
        }
        return temp;
    }
    public void addObjetivoEstrategicoHijo(ObjetivoEstrategico objetivoEstrategico){
        if (objetivoEstrategicoHijoList==null){
            objetivoEstrategicoHijoList=new ArrayList<>();
        }
        objetivoEstrategicoHijoList.add(objetivoEstrategico);
        
    }

    public ConfiguraObjetivo getConfiguraObjetivo() {
        return configuraObjetivo;
    }

    public void setConfiguraObjetivo(ConfiguraObjetivo configuraObjetivo) {
        this.configuraObjetivo = configuraObjetivo;
    }
    
    

}
