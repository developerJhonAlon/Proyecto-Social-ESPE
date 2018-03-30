/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.entity;

import java.util.Comparator;

/**
 *
 * @author PC1
 */
public class ValoracionParametroEvaluacionComparator implements Comparator<ValoracionParametroEvaluacion>{

    public int compare(ValoracionParametroEvaluacion o1, ValoracionParametroEvaluacion o2) {
        return o1.getPuntaje().compareTo(o2.getPuntaje());
    }
    
}
