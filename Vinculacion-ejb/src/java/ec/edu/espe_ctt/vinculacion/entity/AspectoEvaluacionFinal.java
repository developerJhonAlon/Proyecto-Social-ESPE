/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PC1
 */
public class AspectoEvaluacionFinal {

    private String codigo;
    private String nombre;

    private AspectoEvaluacionFinal aspectoEvaluacionFinalPadre;
    private List<AspectoEvaluacionFinal> aspectoEvaluacionFinalHijoList;
    public final static String TIPO_BENEFICIARIO = "1";
    public final static String TIPO_PRESUPUESTO = "2";
    public final static String TIPO_OTRO = "3";
    public final static String TIPO_BENEFICIARIO_DIRECTO = "1.1";
    public final static String TIPO_PRESUPUESTO_UNIVERSIDAD = "2.1";
    public final static String TIPO_PRESUPUESTO_UNIVERSIDAD_VALORADO = "2.2";
    public final static String TIPO_PRESUPUESTO_ENTIDAD_AUSPICIANTE = "2.3";
    public final static String TIPO_PRESUPUESTO_CONTRAPARTE = "2.4";
    public final static String TIPO_MATRIZ_MARCO_LOGICO = "4";

    public AspectoEvaluacionFinal() {

    }

    public AspectoEvaluacionFinal(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AspectoEvaluacionFinal getAspectoEvaluacionFinalPadre() {
        return aspectoEvaluacionFinalPadre;
    }

    public void setAspectoEvaluacionFinalPadre(AspectoEvaluacionFinal aspectoEvaluacionFinalPadre) {
        this.aspectoEvaluacionFinalPadre = aspectoEvaluacionFinalPadre;
    }

    public List<AspectoEvaluacionFinal> getAspectoEvaluacionFinalHijoList() {
        return aspectoEvaluacionFinalHijoList;
    }

    public void setAspectoEvaluacionFinalHijoList(List<AspectoEvaluacionFinal> aspectoEvaluacionFinalHijoList) {
        this.aspectoEvaluacionFinalHijoList = aspectoEvaluacionFinalHijoList;
    }

    public void addAspectoEvaluacionHijo(AspectoEvaluacionFinal aspectoEvaluacionFinal) {
        if (aspectoEvaluacionFinalHijoList == null) {
            aspectoEvaluacionFinalHijoList = new ArrayList<>();
        }
        aspectoEvaluacionFinalHijoList.add(aspectoEvaluacionFinal);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AspectoEvaluacionFinal other = (AspectoEvaluacionFinal) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

}
