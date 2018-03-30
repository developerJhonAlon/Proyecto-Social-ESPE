/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.VistaCampusDeptoCarrera;
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
public class VistaCampusDeptoCarreraFacade extends AbstractFacade<VistaCampusDeptoCarrera> {
    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VistaCampusDeptoCarreraFacade() {
        super(VistaCampusDeptoCarrera.class);
    }
    public List<VistaCampusDeptoCarrera> findDepartamentosByCampus(String codCamp){
        Query query = em.createQuery("SELECT distinct o.departamento FROM VistaCampusDeptoCarrera o where o.campus.stvcampCode =:codCamp");
        query.setParameter("codCamp", codCamp);
        return query.getResultList();
    }
}
