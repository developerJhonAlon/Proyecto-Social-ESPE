/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.OneToMany;
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
@Table(name = "SZDTAVINSTPROY")
@XmlRootElement
public class CompromisoParticipacionProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVINSTPROY", sequenceName = "SEQ_SZDTAVINSTPROY", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVINSTPROY")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZVTAINSTPROY_CODE")
    private Integer id;
    @JoinColumn(name = "SZTVPROYEC_CODE", referencedColumnName = "SZTVPROYEC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto proyecto;
    @JoinColumn(name = "SZVTAINSTITUC_CODE", referencedColumnName = "SZVTAINSTITUC_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institucion institucion = new Institucion();
    @JoinColumn(name = "PRD_ID_ENTIDAD", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet tipoParticipacion;
    @JoinColumn(name = "PRD_ID_ORGANIZACION", referencedColumnName = "PRD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SeaParametrosDet tipoOrganizacion;
    @Size(max = 100)
    @Column(name = "SZVTAINSTPROY_DETAOTRO")
    private String tipoOrganizacionOtrosDesc;
    @Size(max = 500)
    @Column(name = "SZVTAINSTPROY_DECLARACION")
    private String declaracionRepresentante;
    @Column(name = "SZVTAINSTPROY_DIR_HOMBRES")
    private Integer nroBeneficiariosDirectosHombres;
    @Column(name = "SZVTAINSTPROY_DIR_MUJERES")
    private Integer nroBeneficiariosDirectosMujeres;
    @Column(name = "SZVTAINSTPROY_DIR_NINIOS")
    private Integer nroBeneficiariosDirectosNinios;
    @Column(name = "SZVTAINSTPROY_DIR_DISCAPACIDAD")
    private Integer nroBeneficiariosDirectosDiscapacidad;
    @Column(name = "SZVTAINSTPROY_INDIRECTOS")
    private Integer nroBeneficiariosIndirectos;
    @Size(max = 150)
    @Column(name = "SZVTAINSTPROY_DESC_BENEFIC")
    private String descripcionBeneficiarios;

    @OneToMany(mappedBy = "compromisoParticipacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentoCompromisoParticipacion> documentoList = new ArrayList<>();

    public CompromisoParticipacionProyecto() {
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

    public Integer getNroBeneficiariosDirectosHombres() {
        return nroBeneficiariosDirectosHombres;
    }

    public void setNroBeneficiariosDirectosHombres(Integer nroBeneficiariosDirectosHombres) {
        this.nroBeneficiariosDirectosHombres = nroBeneficiariosDirectosHombres;
    }

    public Integer getNroBeneficiariosDirectosMujeres() {
        return nroBeneficiariosDirectosMujeres;
    }

    public void setNroBeneficiariosDirectosMujeres(Integer nroBeneficiariosDirectosMujeres) {
        this.nroBeneficiariosDirectosMujeres = nroBeneficiariosDirectosMujeres;
    }

    public Integer getNroBeneficiariosDirectosNinios() {
        return nroBeneficiariosDirectosNinios;
    }

    public void setNroBeneficiariosDirectosNinios(Integer nroBeneficiariosDirectosNinios) {
        this.nroBeneficiariosDirectosNinios = nroBeneficiariosDirectosNinios;
    }

    public Integer getNroBeneficiariosDirectosDiscapacidad() {
        return nroBeneficiariosDirectosDiscapacidad;
    }

    public void setNroBeneficiariosDirectosDiscapacidad(Integer nroBeneficiariosDirectosDiscapacidad) {
        this.nroBeneficiariosDirectosDiscapacidad = nroBeneficiariosDirectosDiscapacidad;
    }

    public Integer getNroBeneficiariosIndirectos() {
        return nroBeneficiariosIndirectos;
    }

    public void setNroBeneficiariosIndirectos(Integer nroBeneficiariosIndirectos) {
        this.nroBeneficiariosIndirectos = nroBeneficiariosIndirectos;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public SeaParametrosDet getTipoParticipacion() {
        return tipoParticipacion;
    }

    public void setTipoParticipacion(SeaParametrosDet tipoParticipacion) {
        this.tipoParticipacion = tipoParticipacion;
    }

    public SeaParametrosDet getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(SeaParametrosDet tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public String getTipoOrganizacionOtrosDesc() {
        return tipoOrganizacionOtrosDesc;
    }

    public void setTipoOrganizacionOtrosDesc(String tipoOrganizacionOtrosDesc) {
        this.tipoOrganizacionOtrosDesc = tipoOrganizacionOtrosDesc;
    }

    public String getDeclaracionRepresentante() {
        return declaracionRepresentante;
    }

    public void setDeclaracionRepresentante(String declaracionRepresentante) {
        this.declaracionRepresentante = declaracionRepresentante;
    }

    public Integer getTotalBeneficiariosDirectos() {
        Integer result = 0;
        if (nroBeneficiariosDirectosHombres != null) {
            result += nroBeneficiariosDirectosHombres;
        }
        if (nroBeneficiariosDirectosMujeres != null) {
            result += nroBeneficiariosDirectosMujeres;
        }
        if (nroBeneficiariosDirectosNinios != null) {
            result += nroBeneficiariosDirectosNinios;
        }
        if (nroBeneficiariosDirectosDiscapacidad != null) {
            result += nroBeneficiariosDirectosDiscapacidad;
        }
        return result;
    }

    public Integer getTotalBeneficiarios() {
        Integer result = getTotalBeneficiariosDirectos();
        if (nroBeneficiariosIndirectos != null) {
            result += nroBeneficiariosIndirectos;
        }
        return result;
    }

    public String getDescripcionBeneficiarios() {
        return descripcionBeneficiarios;
    }

    public void setDescripcionBeneficiarios(String descripcionBeneficiarios) {
        this.descripcionBeneficiarios = descripcionBeneficiarios;
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
        if (!(object instanceof CompromisoParticipacionProyecto)) {
            return false;
        }
        CompromisoParticipacionProyecto other = (CompromisoParticipacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CompromisoParticipacionProyecto[ id=" + id + " ]";
    }

    public List<DocumentoCompromisoParticipacion> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<DocumentoCompromisoParticipacion> documentoList) {
        this.documentoList = documentoList;
    }

    public void addDocumento(DocumentoCompromisoParticipacion documento) throws Exception{
        if (documentoList!=null){
            for (DocumentoCompromisoParticipacion d : documentoList) {
                if (d.getDocumentoNombre().trim().toUpperCase().equals(documento.getDocumentoNombre().trim().toUpperCase())){
                    throw new Exception("Ya existe un documento con este nombre.");
                }
            }
        }
        else{
            documentoList = new ArrayList<>();
        }
        documentoList.add(documento);
    }
    
    
}
