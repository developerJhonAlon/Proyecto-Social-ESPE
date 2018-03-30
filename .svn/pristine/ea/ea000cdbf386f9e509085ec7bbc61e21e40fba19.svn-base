/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_innovativa.seguridades.navegacion;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.dialog.Dialog;

/**
 *
 * @author Ing. Cristian Asimbaya
 */
@ManagedBean(name = "mensajeBean")
@ViewScoped
public class MensajeController implements Serializable{

    /**
     * Creates a new instance of MensajeController
     */
      private Dialog panelPopupMensaje = new Dialog();
    private String urlIcon = "visto.jpg";
    private static String urlIconError = "error.png";
    private static String urlIconMensaje = "visto.jpg";
    private String mensaje;
    public MensajeController() {
    }
    
    
      public void tooglePanelPopupMensaje(ActionEvent ae) {
       if (ae!=null){
        if (ae.getComponent().getId().equals("buttonOk")) {
            this.urlIcon = urlIconMensaje;
            this.setMensaje("Registro Eliminado");
        } else if (ae.getComponent().getId().equals("buttonOkSalvar")) {
            this.urlIcon = urlIconMensaje;
            this.setMensaje("Registro Realizado");
        }
       }
        panelPopupMensaje.setModal(!panelPopupMensaje.isModal());

    }
    
     public void tooglePanelPopupMensajeError(String msgError) {
        this.mensaje = msgError;
        this.urlIcon = urlIconError;
        panelPopupMensaje.setModal(!panelPopupMensaje.isModal());
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Dialog getPanelPopupMensaje() {
        return panelPopupMensaje;
    }

    public void setPanelPopupMensaje(Dialog panelPopupMensaje) {
        this.panelPopupMensaje = panelPopupMensaje;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }
    
    
    public void ponerMensajeInfo(final String summary, final String detail) {
        FacesMessage infoMessage = new FacesMessage();
        infoMessage.setSummary(summary);
        infoMessage.setDetail(detail);
        infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage("messages", infoMessage);
    }
    
}
