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
@Table(name = "SZDTAVDOCOMPAR")
@XmlRootElement
public class DocumentoCompromisoParticipacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(name = "SEQ_SZDTAVDOCOMPAR", sequenceName = "SEQ_SZDTAVDOCOMPAR", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SZDTAVDOCOMPAR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZDTAVDOCOMPAR_CODE")
    private Integer id;
    @JoinColumn(name = "SZVTAINSTPROY_CODE", referencedColumnName = "SZVTAINSTPROY_CODE")
    @ManyToOne(fetch = FetchType.LAZY)
    private CompromisoParticipacionProyecto compromisoParticipacion;
    @Size(max = 100)
    @Column(name = "SZDTAVDOCOMPAR_NOMBRE_DOC")
    private String documentoNombre;
    @Size(max = 100)
    @Column(name = "SZDTAVDOCOMPAR_NOMBRE_URL")
    private String documentoUrl;


    public DocumentoCompromisoParticipacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CompromisoParticipacionProyecto getCompromisoParticipacion() {
        return compromisoParticipacion;
    }

    public void setCompromisoParticipacion(CompromisoParticipacionProyecto compromisoParticipacion) {
        this.compromisoParticipacion = compromisoParticipacion;
    }

    public String getDocumentoNombre() {
        return documentoNombre;
    }

    public void setDocumentoNombre(String documentoNombre) {
        this.documentoNombre = documentoNombre;
    }

    public String getDocumentoUrl() {
        return documentoUrl;
    }

    public void setDocumentoUrl(String documentoUrl) {
        this.documentoUrl = documentoUrl;
    }

    public String getDocumentoUrlFinal() {
        try {
            return this.documentoUrl  + this.documentoNombre;
        } catch (Exception e) {
            return null;
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
        if (!(object instanceof DocumentoCompromisoParticipacion)) {
            return false;
        }
        DocumentoCompromisoParticipacion other = (DocumentoCompromisoParticipacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DocumentoCompromisoParticipacion[ id=" + id + " ]";
    }

}
