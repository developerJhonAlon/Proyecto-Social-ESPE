/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.controller;

import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.vinculacion.entity.PresupuestoProyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class ProyectoController2 extends ProyectoController implements Serializable {

    public ProyectoController2() {
    }

    private TreeNode rootMenu2;

    public TreeNode getRootMenu2() {
        return rootMenu2;
    }

    public void setRootMenu2(TreeNode rootMenu2) {
        this.rootMenu2 = rootMenu2;
    }
    
    @Override
    public void crearArbolMenu(Long estadoProyecto) {
        rootMenu2 = new DefaultTreeNode("Root", null);
        TreeNode nodePerfil = new DefaultTreeNode(new OpcionMenu("1", "Perfil"), rootMenu2);
        TreeNode node11 = new DefaultTreeNode(new OpcionMenu("1.1", "1. Datos Generales"), nodePerfil);
        TreeNode node111 = new DefaultTreeNode(new OpcionMenu("1.1.1", "1.1. Datos Generales"), node11);
        if (estadoProyecto.equals(SeaParametrosDet.ESTADO_CREADO) || estadoProyecto.equals(SeaParametrosDet.ESTADO_REVISION)) {
            nodePerfil.setExpanded(true);
            node11.setExpanded(true);
            node111.setExpanded(true);
            node111.setSelected(true);
        }

        if (super.getProyectoSelected().getId() != null) {
            TreeNode node112 = new DefaultTreeNode(new OpcionMenu("1.1.2", "1.2. Cobertura y Localización"), node11);
            //TreeNode node113 = new DefaultTreeNode(new OpcionMenu("1.1.3", "1.3. Origen de los fondos"), node11);
            TreeNode node114 = new DefaultTreeNode(new OpcionMenu("1.1.4", "1.3. Entregables del proyecto"), node11);
            TreeNode node115 = new DefaultTreeNode(new OpcionMenu("1.1.5", "1.4. Impactos Esperados"), node11);
            TreeNode node12 = new DefaultTreeNode(new OpcionMenu("1.2", "2. Diagnóstico y Problema"), nodePerfil);
            TreeNode node121 = new DefaultTreeNode(new OpcionMenu("1.2.1", "2.1. Diagnóstico y Problema"), node12);
            TreeNode node1211 = new DefaultTreeNode(new OpcionMenu("1.2.5", "2.2. Anexos imágenes"), node12);
            TreeNode node122 = new DefaultTreeNode(new OpcionMenu("1.2.2", "2.3. Identificación de Población"), node12);
            TreeNode node123 = new DefaultTreeNode(new OpcionMenu("1.2.3", "2.4. Docentes Participantes"), node12);
            TreeNode node124 = new DefaultTreeNode(new OpcionMenu("1.2.4", "2.5. Estudiantes Participantes"), node12);
            TreeNode node13 = new DefaultTreeNode(new OpcionMenu("1.3", "3. Alineamiento del Proyecto"), nodePerfil);
            TreeNode node136 = new DefaultTreeNode(new OpcionMenu("1.3.5", "3.1. Objetivos de Desarrollo Sostenible del Milenio"), node13);
            TreeNode node131 = new DefaultTreeNode(new OpcionMenu("1.3.1", "3.2. Objetivos Plan Nacional de Desarrollo"), node13);
            TreeNode node133 = new DefaultTreeNode(new OpcionMenu("1.3.3", "3.3. Objetivos Provinciales, Cantonales o Parroquiales"), node13);
            TreeNode node132 = new DefaultTreeNode(new OpcionMenu("1.3.2", "3.4. Objetivos Estratégicos Institucionales"), node13);
            TreeNode node135 = new DefaultTreeNode(new OpcionMenu("1.3.4", "3.5. Líneas de Investigación"), node13);
            TreeNode node137 = new DefaultTreeNode(new OpcionMenu("1.3.6", "3.6. Campo de Conocimiento UNESCO"), node13);
            TreeNode node138 = new DefaultTreeNode(new OpcionMenu("1.3.7", "3.7. Dominios"), node13);
            TreeNode node134 = new DefaultTreeNode(new OpcionMenu("1.4", "4. Matriz del Marco Lógico"), nodePerfil);
            TreeNode node15 = new DefaultTreeNode(new OpcionMenu("1.5", "5. Viabilidad y Plan de Sostenibilidad"), nodePerfil);
            TreeNode node16 = new DefaultTreeNode(new OpcionMenu("1.6", "6. Presupuesto Detallado y Fuentes de Financiamiento"), nodePerfil);
            TreeNode node17 = new DefaultTreeNode(new OpcionMenu("1.7", "7. Estrategia de Ejecución-Cronograma"), nodePerfil);
            TreeNode node171 = new DefaultTreeNode(new OpcionMenu("1.7.1", "7.1. Cronograma Actividades"), node17);
            TreeNode node172 = new DefaultTreeNode(new OpcionMenu("1.7.2", "7.2. Cronograma Hitos"), node17);
            TreeNode node18 = new DefaultTreeNode(new OpcionMenu("1.8", "8. Acta de Consejo de Departamento"), nodePerfil);
            TreeNode node19 = new DefaultTreeNode(new OpcionMenu("1.10", "9. Acta Compromiso Director Proyecto"), nodePerfil);
            TreeNode node20 = new DefaultTreeNode(new OpcionMenu("1.11", "10. Acta Compromiso Carreras"), nodePerfil);
            TreeNode node21 = new DefaultTreeNode(new OpcionMenu("1.9", "11. Finalizar perfil"), nodePerfil);
            if (estadoProyecto.equals(SeaParametrosDet.ESTADO_CERRADO_PERFIL)) {
                nodePerfil.setExpanded(true);
                node21.setSelected(true);
            }
        }
        
        
        
        if (super.getProyectoSelected().getId() != null) {
            if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION)
                    || verificarDirectorProyecto()) {
                TreeNode node2 = new DefaultTreeNode(new OpcionMenu("2", "Calificación Comisión Vinculación"), rootMenu2);
                if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)) {
                    TreeNode node21 = new DefaultTreeNode(new OpcionMenu("2.1", "1. Asignación de Comisión de Calificación"), node2);
                }
                if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                        || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_UNIDAD_VINCULACION)) {
                    TreeNode node22 = new DefaultTreeNode(new OpcionMenu("2.2", "2. Registro Calificación"), node2);
                    TreeNode node23 = new DefaultTreeNode(new OpcionMenu("2.3", "3. Consolidación Calificación"), node2);
                    if (estadoProyecto.equals(SeaParametrosDet.ESTADO_APROBADO_COMISION_VINCULACION)) {
                        node2.setExpanded(true);
                        node23.setSelected(true);
                    }
                }
                TreeNode node23 = new DefaultTreeNode(new OpcionMenu("2.4", "4. Resumen Consolidación Calificación"), node2);
            }
            if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)) {
                TreeNode node3 = new DefaultTreeNode(new OpcionMenu("10", "Aprobación Vicerrectorado"), rootMenu2);
                TreeNode node4 = new DefaultTreeNode(new OpcionMenu("3", "Aprobación Consejo Académico"), rootMenu2);
                if (estadoProyecto.equals(SeaParametrosDet.ESTADO_APROBADO_CONSEJO_ACADEMICO)) {
                    node4.setSelected(true);
                }
            }

            if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_IMPRESION_CERTIFICADOS)
                    || super.verificarDirectorProyecto()) {
                TreeNode node8 = new DefaultTreeNode(new OpcionMenu("4", "Inicio Ejecución"), rootMenu2);
                TreeNode node31 = new DefaultTreeNode(new OpcionMenu("4.1", "1. Asignación de Docentes"), node8);
                TreeNode node32 = new DefaultTreeNode(new OpcionMenu("4.2", "2. Asignación de Estudiantes"), node8);
                TreeNode node34 = new DefaultTreeNode(new OpcionMenu("4.3", "3. Compromiso de Participación"), node8);
                TreeNode node35 = new DefaultTreeNode(new OpcionMenu("4.4", "4. Carta Compromiso Comunidad"), node8);
                TreeNode node3 = new DefaultTreeNode(new OpcionMenu("5", "Ejecución"), rootMenu2);
                TreeNode node33 = new DefaultTreeNode(new OpcionMenu("5.1", "1. Informes de avance"), node3);
                TreeNode node311 = new DefaultTreeNode(new OpcionMenu("5.2", "2. Horas dedicación docente"), node3);
                TreeNode node322 = new DefaultTreeNode(new OpcionMenu("5.3", "3. Horas dedicación estudiante"), node3);
                TreeNode node333 = new DefaultTreeNode(new OpcionMenu("5.4", "4. Finalizar proceso de ejecución"), node3);
            }
            if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_COORDINADOR_VINCULACION)) {
                TreeNode node6 = new DefaultTreeNode(new OpcionMenu("6", "Seguimiento"), rootMenu2);
            }
            if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || super.verificarDirectorProyecto()
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)) {
                TreeNode node7 = new DefaultTreeNode(new OpcionMenu("7", "Cierre"), rootMenu2);
                TreeNode node71 = new DefaultTreeNode(new OpcionMenu("7.1", "1. Numérico de Beneficiarios"), node7);
                TreeNode node72 = new DefaultTreeNode(new OpcionMenu("7.2", "2. Objetivos ejecutados"), node7);
                TreeNode node73 = new DefaultTreeNode(new OpcionMenu("7.3", "3. Presupuesto ejecutado"), node7);
                TreeNode node74 = new DefaultTreeNode(new OpcionMenu("7.4", "4. Resultados proyecto"), node7);
                TreeNode node75 = new DefaultTreeNode(new OpcionMenu("7.5", "5. Finalizar proceso de cierre"), node7);
            }

            TreeNode node9 = new DefaultTreeNode(new OpcionMenu("8", "Anexos"), rootMenu2);

            if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)
                    || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)) {
                TreeNode nodeEvaluacion = new DefaultTreeNode(new OpcionMenu("9", "Evaluación"), rootMenu2);
                if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                        || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_DIRECTOR_DEPARTAMENTO)) {
                    TreeNode nodeConfigEvaluadorFinal = new DefaultTreeNode(new OpcionMenu("9.1", "1. Designar Evaluador final"), nodeEvaluacion);
                }
                if (super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION)
                        || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_ADMINISTRADOR_VINCULACION_LECTURA)
                        || super.verificarPerfil(SegPerfil.PERFIL_VINCULACION_EVALUADOR_FINAL_PROYECTO)
                        || super.isPermitirEvaluacionFinal()) {
                    TreeNode nodeEvaluacionFinal = new DefaultTreeNode(new OpcionMenu("9.2", "2. Evaluación Final"), nodeEvaluacion);
                    TreeNode nodeFinalizarEvaluacionFinal = new DefaultTreeNode(new OpcionMenu("9.3", "3. Finalizar Proceso Evaluación"), nodeEvaluacion);

                }
            }
        }
    }
    
    
    @Override
    public String abrirReportePorSegmento(String opcionMenu){
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
    
        options.put("contentHeight", "100%");
        options.put("contentWidth", "100%");
        options.put("height", "90vh");
        options.put("width", "90%");

        options.put("includeViewParams", true);

        Map<String, List<String>> params = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        values.add(super.getProyectoSelected().getId().toString());
        List<String> values2 = new ArrayList<String>();
        values2.add(opcionMenu);
        params.put("idProyecto", values);
        params.put("opcionMenu", values2);
        RequestContext.getCurrentInstance().openDialog("reportePorOpcion2", options, params);
        return "";
    
    }
    
    @Override
    public void nuevoPresupuestoProyecto(ActionEvent event) {
        super.setPresupuestoProyectoSelected(new PresupuestoProyecto(super.getProyectoSelected()));
        super.getPresupuestoProyectoSelected().setearCantidadAnual();
        super.getPresupuestoProyectoSelected().setPartidaPresupuestaria(null);        
    }
    
    

}
