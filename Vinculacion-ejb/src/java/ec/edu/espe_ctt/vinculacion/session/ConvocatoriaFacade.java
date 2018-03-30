/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.Convocatoria;
import java.util.Date;
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
public class ConvocatoriaFacade extends AbstractFacade<Convocatoria> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em; ///em tiene los metodos para conectar a la base
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConvocatoriaFacade() {
        super(Convocatoria.class);
    }
    //@Override
    public List<Convocatoria> findAll(){
        Query query = em.createQuery("SELECT o FROM Convocatoria o order by o.fechaInicio desc");
        return query.getResultList();
    }
    public Convocatoria findByActiva(){
        Query query = em.createQuery("SELECT o FROM Convocatoria o where CURRENT_DATE BETWEEN o.fechaInicio AND o.fechaFin ");
        List<Convocatoria> list = query.getResultList();
        return list.isEmpty()?null:list.get(0);
    }
}
