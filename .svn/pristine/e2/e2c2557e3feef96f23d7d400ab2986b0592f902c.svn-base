/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.ws;

import static java.io.File.separatorChar;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author PC1
 */
@WebService(serviceName = "WSEnvioMail")
public class WSEnvioMail {

    /**
     * This is a sample web service operation
     */
    @Resource
    private WebServiceContext context;

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "enviarMail")
    public void enviarMail(@WebParam(name = "remitente") String remitente,
            @WebParam(name = "destinatarios") String destinatarios,
            @WebParam(name = "asunto") String asunto,
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "esHtml") Boolean esHtml,
            @WebParam(name = "archivoAdjunto") byte[] archivoAdjunto,
            @WebParam(name = "nombreArchivoAdjunto") String nombreArchivoAdjunto,
            @WebParam(name = "archivoAdjunto2") byte[] archivoAdjunto2,
            @WebParam(name = "nombreArchivoAdjunto2") String nombreArchivoAdjunto2) {

        ServletContext servletContext = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        String path = servletContext.getRealPath("") + separatorChar + "temp";

        EnvioMailThread envioMailThread = new EnvioMailThread(remitente, destinatarios, asunto, mensaje, esHtml, archivoAdjunto, nombreArchivoAdjunto, archivoAdjunto2, nombreArchivoAdjunto2, path);
        envioMailThread.start();
    }
}
