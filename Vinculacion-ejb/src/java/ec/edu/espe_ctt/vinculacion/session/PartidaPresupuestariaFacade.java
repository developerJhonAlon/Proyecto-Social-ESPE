/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.PartidaPresupuestaria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class PartidaPresupuestariaFacade extends AbstractFacade<PartidaPresupuestaria> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartidaPresupuestariaFacade() {
        super(PartidaPresupuestaria.class);
    }

    public List<PartidaPresupuestaria> findByGastoInversion() {
        return findByTipo(PartidaPresupuestaria.TIPO_INVERSION);
    }   

    public List<PartidaPresupuestaria> findByGastoCorriente() {
        return findByTipo(PartidaPresupuestaria.TIPO_CORRIENTE);
    }   
    
    private List<PartidaPresupuestaria> findByTipo(String tipo) {
        Query query = em.createQuery("SELECT o FROM PartidaPresupuestaria o WHERE o.tipo = :tipo ORDER BY o.clasificadorPresupuesto.scpId");
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }   

    public List<PartidaPresupuestaria> findByEstadoActivo() {
        Query query = em.createQuery("SELECT o FROM PartidaPresupuestaria o WHERE o.estado = 'A'");
        return query.getResultList();
    }   
    
   
}
