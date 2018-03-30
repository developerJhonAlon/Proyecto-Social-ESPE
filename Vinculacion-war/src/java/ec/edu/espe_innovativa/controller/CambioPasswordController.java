/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.session.*;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author Ing. Cristian Asimbaya
 */
@ManagedBean(name = "cambioPasswordController")
@ViewScoped
public class CambioPasswordController implements Serializable {

    /**
     * Creates a new instance of LoginController
     */
//    @EJB
//    private BzdtusuFacade usuarioFacade;
//    @EJB
//    private BzdtusuperFacade usuPerfilFacade;
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private String password;
    private String passwordConfirmacion;

    public CambioPasswordController() {

    }

    @PostConstruct
    public void init() {
        passwordCambiado=false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmacion() {
        return passwordConfirmacion;
    }

    public void setPasswordConfirmacion(String passwordConfirmacion) {
        this.passwordConfirmacion = passwordConfirmacion;
    }

    public void cambiarPassword() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            SegUsuario usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
            if (!password.equals(passwordConfirmacion)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La nueva contraseña debe coincidir con el de la confirmación."));
            }
            else{
                usuarioFacade.UpdateClaveByIdUsuCodUsu(password, usuarioActual.getUsuId());
                passwordCambiado = true;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No fue posible cambiar la contreña."));
        }
    }
    
    private boolean passwordCambiado;

    public boolean isPasswordCambiado() {
        return passwordCambiado;
    }

    public void setPasswordCambiado(boolean passwordCambiado) {
        this.passwordCambiado = passwordCambiado;
    }

}
