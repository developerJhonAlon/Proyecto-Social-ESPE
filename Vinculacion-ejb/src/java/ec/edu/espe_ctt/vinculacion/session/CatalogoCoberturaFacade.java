/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.CatalogoCobertura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class CatalogoCoberturaFacade extends AbstractFacade<CatalogoCobertura> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU") ///conexion de la base de datos
    private EntityManager em;

    public CatalogoCoberturaFacade() {
        super(CatalogoCobertura.class);

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override //SIGNIFICA SOBRESCRIBIR EL METODO FINDALL LA CLASE PADRE ABSTRACT FACADE
     public List<CatalogoCobertura> findAll() {
        //CatalogoCobertura ES EL NOMBRE COMO SE DEFINIO O MAPEO EN LA CLASE LA TABLA
         Query query = em.createQuery("SELECT o FROM CatalogoCobertura as o ORDER BY o.id");
        return query.getResultList();
     }
    
    
    
    
    
}
