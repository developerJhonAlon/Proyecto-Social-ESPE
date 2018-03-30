package ec.edu.espe_innovativa.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * JSF utilities.
 */
public class FacesUtils {

    /**
     * Obtiene el valor de FacesContext.
     *
     * @return Objeto FacesContext
     */
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Get servlet context.
     *
     * @return the servlet context
     */
    public static ServletContext getServletContext() {
        return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }

    public static ExternalContext getExternalContext() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return fc.getExternalContext();
    }

    public static HttpSession getHttpSession(boolean create) {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
    }

    /**
     * Get managed bean based on the bean name.
     *
     * @param beanName the bean name
     * @return the managed bean associated with the bean name
     */
    public static Object getManagedBean(String beanName) {
        return getValueBinding(getJsfEl(beanName)).getValue(FacesContext.getCurrentInstance());
    }

    /**
     * Remove the managed bean based on the bean name.
     *
     * @param beanName the bean name of the managed bean to be removed
     */
    public static void resetManagedBean(String beanName) {
        getValueBinding(getJsfEl(beanName)).setValue(FacesContext.getCurrentInstance(), null);
    }

    /**
     * Store the managed bean inside the session scope.
     *
     * @param beanName the name of the managed bean to be stored
     * @param managedBean the managed bean to be stored
     */
    public static void setManagedBeanInSession(String beanName, Object managedBean) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
    }

    /**
     * Get parameter value from request scope.
     *
     * @param name the name of the parameter
     * @return the parameter value
     */
    public static String getRequestParameter(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

    /**
     * Get parameter value from request scope.
     *
     * @param name the name of the parameter
     * @return the parameter value
     */
    public static Object getRequestParameterObjeto(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

    /**
     * Add information message.
     *
     * @param msg the information message
     */
    public static void addInfoMessage(String msg) {
        addInfoMessage(null, msg);
    }

    /**
     * Add information message to a specific client.
     *
     * @param clientId the client id
     * @param msg the information message
     */
    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId,
                new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    /**
     * Add error message.
     *
     * @param msg the error message
     */
    public static void addErrorMessage(String msg) {
        addErrorMessage(null, msg);
    }

    public static void addWarningMessage(String msg) {
        addWarnigMessage(null, msg);
    }

    /**
     * Add error message por medio de exception
     *
     * @param msg the error message
     */
    public static void addErrorMessage(Exception ex) {
        addErrorMessage(null, "Mensaje: Informe al Administrador del Sistema.");
        ex.printStackTrace();
    }

    /**
     * Add error message to a specific client.
     *
     * @param clientId the client id
     * @param msg the error message
     */
    public static void addErrorMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
    }

    public static void addWarnigMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId,
                new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
    }

    public static void AddErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    private static Application getApplication() {
        ApplicationFactory appFactory = (ApplicationFactory) FactoryFinder
                .getFactory(FactoryFinder.APPLICATION_FACTORY);
        return appFactory.getApplication();
    }

    private static ValueBinding getValueBinding(String el) {
        return getApplication().createValueBinding(el);
    }

    public static HttpServletRequest getServletRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    private static Object getElValue(String el) {
        return getValueBinding(el).getValue(FacesContext.getCurrentInstance());
    }

    private static String getJsfEl(String value) {
        return "#{" + value + "}";
    }

    /**
     * Retorna el nombre del usuario que esta logeado en el sistema-
     *
     * @return
     */
    public static String usuarioLogueado() {

        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
                .getUserPrincipal().getName();
    }

    /**
     * Permite generar una lista de selectItems a partir de uns lista.
     *
     * @param entities Lista de entidades
     * @param selectOne Variable para determinar si la lista de selectItems se
     * llena con un valor inicial
     * @return
     */
    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem(".", "--Seleccione--");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    /**
     * Obtiene el archivo de internacionalización de los mensajes del sistema.
     *
     * @return
     */
    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("com.jvc.medisys.recursos.messages");
    }

    /**
     * Permite redireccionar las páginas web.
     *
     * @param url Url al cual deseamos ir. Para el caso de la aplicación, simpre
     * debe ir con /faces al inicio de la cadena.
     */
    public static void redireccionar(final String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(
                    getServletRequest().getContextPath() + url);
        } catch (IOException ex) {
            Logger.getLogger(FacesUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Eliminas los beans de session que son generados al pasar por historia
     * clínica, notas de evolución, interconsultas,
     */
    public static void limpiarHistoriaClinica() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos nota de evolución
            if ("historiaClinicaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Eliminas los beans de session que son generados al pasar por historia
     * clínica, notas de evolución, interconsultas,
     */
    public static void limpiarNotasEvolucion() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos nota de evolución
            if ("notaEvolucionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos interconsulta
            if ("interconsultaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos respuesta interconsulta
            if ("respuestaInterconsultaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos cita previa
            if ("citaPreviaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos transferencia
            if ("transferenciaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos reportes
            if ("reportesBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos cita previa
            if ("citaPreviaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos pedidos de laboratorio
            if ("examenLaboratorioUtil".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            // quitamos pedidos de rehabilitación
            if ("pedidoRehabilitacionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos procedimientos
            if ("procedimientosEMBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos examenes generales
            if ("pedidoExamenGeneralBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //agregar el resto de cosas q se van a quitar de session
        }
    }

    public static void limpiarNotasEvolucionReporte() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos nota de evolución
            if ("reportesBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //agregar el resto de cosas q se van a quitar de session
        }
    }

    public static void limpiarFichaEmergencia() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("emergenciaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos nota de evolución
            if ("notaEvolucionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
//             //quitamos interconsulta
            if ("interconsultaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos respuesta interconsulta
            if ("respuestaInterconsultaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos cita previa
            if ("citaPreviaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos transferencia
            if ("transferenciaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos pedidos de laboratorio
            if ("examenLaboratorioUtil".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            // quitamos pedidos de rehabilitación
            if ("pedidoRehabilitacionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos procedimientos
            if ("procedimientosEMBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos examenes generales
            if ("pedidoExamenGeneralBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //agregar el resto de cosas q se van a quitar de session
        }
    }

    public static void limpiarFichaEmergencia1() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("emergenciaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos nota de evolución
            if ("notaEvolucionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos nota de evolución
            if ("entidadesProcesos".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos transferencia
            if ("transferenciaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos reportes
            if ("reportesBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos cita previa
            if ("citaPreviaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos pedidos de laboratorio
            if ("examenLaboratorioUtil".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            // quitamos pedidos de rehabilitación
            if ("pedidoRehabilitacionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos procedimientos
            if ("procedimientosEMBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //quitamos examenes generales
            if ("pedidoExamenGeneralBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            //agregar el resto de cosas q se van a quitar de session
        }
    }

    public static void limpiarBusquedaEmergencia() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("entidadesProcesos".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Eliminas de session el bean de cita previa
     */
    public static void limpiarCitaPrevia() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("citaPreviaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de la solicitud de examen general.
     */
    public static void limpiarExamenGeneral() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("pedidoExamenGeneralBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de la solicitud de examen general.
     */
    public static void limpiarRecetaNTE() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("recetaMedicamentoBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de la solicitud de interconsulta.
     */
    public static void limpiarInterconsulta() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("interconsultaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de la solicitud de transferencia.
     */
    public static void limpiarTransferencia() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos ficha emergencia
            if ("transferenciaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de la solicitud de pedido de rehabilitación.
     */
    public static void limpiarPedidoRehabilitacion() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos examenes de laboratorio

            if ("pedidoRehabilitacionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarInformePedidoRehabilitacion() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos el informe de rehabilitación

            if ("informeRehabilitacionBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de la solicitud de pedido de laboratorio.
     */
    public static void limpiarPedidoLaboratorio() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos examenes de laboratorio

            if ("examenLaboratorioUtil".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de la solicitud de pedido de laboratorio.
     */
    public static void limpiarPedidoCirugia() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos examenes de laboratorio

            if ("pedidoCirugiaBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     * Elimina el bean de sesión de ficha perinatal.
     */
    public static void limpiarFichaPerinatal() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos examenes de laboratorio

            if ("fichaPerinatalBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    /**
     *
     */
    public static void limpiarProcedimiento() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("procedimientosEMBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarProductos() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("productosBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarActividadesRealizadasPaciente() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("registroActividadesEjecutadasBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarDietas() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("dietasBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarPrescripcionMedica() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("prescripcionMedBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarResultadosGenerales() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("resultadoExamenesGeneralesBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarDescargaResultadosGenerales() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("descargaResultadoExamnesGeneralesBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }

    public static void limpiarResultadosInternos() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("resultadosInternosBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            



        }
    }
    public static void limpiarBusquedaProyectos() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("buscarProyectosBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }
    public static void limpiarAplazamientos() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("aplazamientosBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }
    public static void limpiarRubros() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("rubrosBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }
    public static void limpiarReformas() {
         HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("reformasBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }
    public static void limpiarProyectos() {
        HttpSession sesion = FacesUtils.getHttpSession(false);
        Enumeration<String> e = sesion.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            //quitamos procedimientos de emergencia

            if ("buscarProyectosBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
            if ("proyectosBean".equals(attr)) {
                sesion.removeAttribute(attr);
                break;
            }
        }
    }
}
