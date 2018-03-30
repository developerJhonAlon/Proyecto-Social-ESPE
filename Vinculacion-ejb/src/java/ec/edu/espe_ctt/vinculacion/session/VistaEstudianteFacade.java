/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.VEstudiante;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Administrador
 */
@Stateless
public class VistaEstudianteFacade extends AbstractFacade<VEstudiante> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VistaEstudianteFacade() {
        super(VEstudiante.class);
    }

    public List<VEstudiante> findByCedNomApe(String cedula, String nombres, String apellidos) {
        /*Query query = em.createQuery("SELECT o FROM VEstudiante o where o.usuario.usuCc = :cedula AND UPPER(o.usuario.usuApellidos) like :apellidos AND UPPER(o.usuario.usuNombres) like :nombres");
        query.setParameter("cedula", cedula);
        query.setParameter("nombres", "%" + nombres.toUpperCase() + "%");
        query.setParameter("apellidos", "%" + apellidos.toUpperCase() + "%");
        return query.getResultList();*/

        String hql = "SELECT o FROM VEstudiante o WHERE ";
        String where = "";
        if (cedula != null && !cedula.trim().isEmpty()) {
            where = "o.usuario.usuCc = :cedula ";
        }
        if (apellidos != null && !apellidos.trim().isEmpty()) {
            if (!where.isEmpty()) {
                where += "AND ";
            }
            where += "UPPER(o.usuario.usuApellidos) like :apellidos ";
        }
        if (nombres != null && !nombres.trim().isEmpty()) {
            if (!where.isEmpty()) {
                where += "AND ";
            }
            where += "UPPER(o.usuario.usuNombres) like :nombres ";
        }

        Query query = em.createQuery(hql + where + "order by o.usuario.usuApellidos asc ");
        if (cedula != null && !cedula.trim().isEmpty()) {
            query.setParameter("cedula", cedula.trim());
        }
        if (apellidos != null && !apellidos.trim().isEmpty()) {
            query.setParameter("apellidos", "%" + apellidos.trim().toUpperCase() + "%");
        }
        if (nombres != null && !nombres.trim().isEmpty()) {
            query.setParameter("nombres", "%" + nombres.trim().toUpperCase() + "%");
        }
        return query.getResultList();
    }
    public List<VEstudiante> findByFiltro(int first, int pageSize,
                                            String sortField,
                                            SortOrder sortOrder,
                                            Map<String, Object> filters) {
        StringBuilder hql = new StringBuilder("SELECT o FROM VEstudiante o WHERE 1=1 ");
        String filtroCedula = (String) filters.get("usuario.usuCc");
        String filtroApellidos = (String) filters.get("usuario.usuApellidos");
        String filtroNombres = (String) filters.get("usuario.usuNombres");
        String filtroCarrera = (String) filters.get("carrera.stvmajrDesc");
        String filtroDepartamento = (String) filters.get("departamento.stvsubjDesc");
        if (filtroCedula != null) {
            hql.append("and o.usuario.usuCc like :cedula ");
        }
        if (filtroApellidos != null) {
            hql.append("and upper(o.usuario.usuApellidos) like :apellidos ");
        }
        if (filtroNombres != null) {
            hql.append("and upper(o.usuario.usuNombres) like :nombres ");
        }
        if (filtroCarrera != null) {
            hql.append("and upper(o.carrera.stvmajrDesc) like :carrera ");
        }
        if (filtroDepartamento != null) {
            hql.append("and upper(o.departamento.stvsubjDesc) like :departamento ");
        }
        
        if (sortField != null) {
            hql.append(" order by o.").append(sortField).append(" ").append((sortOrder.equals(SortOrder.ASCENDING) ? "ASC" : "DESC"));
        }    
        Query query = em.createQuery(hql.toString()).setFirstResult(first).setMaxResults(pageSize);
        if (filtroCedula != null) {
            query.setParameter("cedula", "%" + filtroCedula.trim() + "%");
        }
        if (filtroApellidos != null) {
            query.setParameter("apellidos", "%" + filtroApellidos.trim().toUpperCase() + "%");
        }
        if (filtroNombres != null) {
            query.setParameter("nombres", "%" + filtroNombres.trim().toUpperCase() + "%");
        }
        if (filtroCarrera != null) {
            query.setParameter("carrera", "%" + filtroCarrera.trim().toUpperCase() + "%");
        }
        if (filtroDepartamento != null) {
            query.setParameter("departamento", "%" + filtroDepartamento.trim().toUpperCase() + "%");
        }
        
        return query.getResultList();
    }    
    
    public int count(Map<String, Object> filters) {
        StringBuilder hql = new StringBuilder("SELECT count(o) FROM VEstudiante o WHERE 1=1 ");
        String filtroCedula = (String) filters.get("usuario.usuCc");
        String filtroApellidos = (String) filters.get("usuario.usuApellidos");
        String filtroNombres = (String) filters.get("usuario.usuNombres");
        String filtroCarrera = (String) filters.get("carrera.stvmajrDesc");
        String filtroDepartamento = (String) filters.get("departamento.stvsubjDesc");
        if (filtroCedula != null) {
            hql.append("and o.usuario.usuCc like :cedula ");
        }
        if (filtroApellidos != null) {
            hql.append("and upper(o.usuario.usuApellidos) like :apellidos ");
        }
        if (filtroNombres != null) {
            hql.append("and upper(o.usuario.usuNombres) like :nombres ");
        }
        if (filtroCarrera != null) {
            hql.append("and upper(o.carrera.stvmajrDesc) like :carrera ");
        }
        if (filtroDepartamento != null) {
            hql.append("and upper(o.departamento.stvsubjDesc) like :departamento ");
        }

        TypedQuery<Long> query = em.createQuery(hql.toString(), Long.class);
 
        if (filtroCedula != null) {
            query.setParameter("cedula", "%" + filtroCedula.trim() + "%");
        }
        if (filtroApellidos != null) {
            query.setParameter("apellidos", "%" + filtroApellidos.trim().toUpperCase() + "%");
        }
        if (filtroNombres != null) {
            query.setParameter("nombres", "%" + filtroNombres.trim().toUpperCase() + "%");
        }
        if (filtroCarrera != null) {
            query.setParameter("carrera", "%" + filtroCarrera.trim().toUpperCase() + "%");
        }
        if (filtroDepartamento != null) {
            query.setParameter("departamento", "%" + filtroDepartamento.trim().toUpperCase() + "%");
        }

        return query.getSingleResult().intValue();
    }    
}
