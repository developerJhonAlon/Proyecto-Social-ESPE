/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_innovativa.recursos;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC1
 */
public final class ValidatorUtil {
 
 private static final String VALIDATE = "VALIDATE";
 
 public static boolean check() {
  return check(FacesContext.getCurrentInstance());
 }
 
 public static boolean check(final FacesContext context) {
  final ExternalContext externalContext = context.getExternalContext();
  final Object validate = externalContext.getRequestMap().get(VALIDATE);
  if (validate != null) {
   return (Boolean) validate;
  }
  for (final Map.Entry<String, String[]> requestParameters : externalContext.getRequestParameterValuesMap()
    .entrySet()) {
   final String key = requestParameters.getKey();
   if (key.contains(":do")) {
    externalContext.getRequestMap().put(VALIDATE, Boolean.TRUE);
    return true;
   }
  }
  externalContext.getRequestMap().put(VALIDATE, Boolean.FALSE);
  return false;
 }
 
}