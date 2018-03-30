/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC1
 */
public class Test {
    public static List<Programa> createProgram(){
        List<Programa> l= new ArrayList<>();
        Programa p1 = new Programa();
        p1.setNombre("Holaaaa");
        LeccionAprendidaPrograma leccion1= new  LeccionAprendidaPrograma();
        leccion1.setDescripcion("Descripcion 1");
        LeccionAprendidaPrograma leccion2= new  LeccionAprendidaPrograma();
        leccion2.setDescripcion("Descripcion 2");
        LeccionAprendidaPrograma leccion3= new  LeccionAprendidaPrograma();
        leccion3.setDescripcion("Descripcion 3");
        
        p1.setLeccionAprendidaList(new ArrayList<LeccionAprendidaPrograma>());
        p1.getLeccionAprendidaList().add(leccion1);
        p1.getLeccionAprendidaList().add(leccion2);
        p1.getLeccionAprendidaList().add(leccion3);
        l.add(p1);
       
        Proyecto proy= new Proyecto();
        proy.setCodigo("111");
        proy.setNombre("Hijo");
        p1.setProyectoList(new ArrayList<Proyecto>());
        p1.getProyectoList().add(proy);
        return l;
    }
 
}
