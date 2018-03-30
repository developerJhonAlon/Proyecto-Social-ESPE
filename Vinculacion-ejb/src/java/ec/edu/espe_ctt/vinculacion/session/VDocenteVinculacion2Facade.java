/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion;
import ec.edu.espe_ctt.vinculacion.entity.VDocenteVinculacion2;
import ec.edu.espe_ctt.vinculacion.entity.VEstudiante;
import java.math.BigDecimal;
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
public class VDocenteVinculacion2Facade extends AbstractFacade<VDocenteVinculacion2> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VDocenteVinculacion2Facade() {
        super(VDocenteVinculacion2.class);
    }

    public List<VDocenteVinculacion2> findByCedNomApe(String cedula, String nombres, String apellidos, String idCampus, String idDepartamento) {
        String hql = "SELECT o FROM VDocenteVinculacion2 o WHERE ";
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
        if (idCampus != null && !idCampus.trim().isEmpty()) {
            if (!where.isEmpty()) {
                where += "AND ";
            }
            where += "o.campus.stvcampCode = :idCampus ";
        }

        if (idDepartamento != null && !idDepartamento.trim().isEmpty()) {
            if (!where.isEmpty()) {
                where += "AND ";
            }
            where += "o.departamento.stvsubjCode = :idDepartamento ";
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
        if (idCampus != null && !idCampus.trim().isEmpty()) {
            query.setParameter("idCampus", idCampus.trim());
        }
        if (idDepartamento != null && !idDepartamento.trim().isEmpty()) {
            query.setParameter("idDepartamento", idDepartamento.trim());
        }

        return query.getResultList();
    }

    public List<VDocenteVinculacion2> findByName(String nombres) {
        StringBuilder sb = new StringBuilder("SELECT u FROM VDocenteVinculacion2 u where ");
        if (nombres.isEmpty()) {
            sb.append(" u.usuario.usuId < 1000 ");
        } else {
            sb.append(" CONCAT (u.usuario.usuApellidos, ' ', u.usuario.usuNombres) like :nombres ");
        }
        sb.append(" order by u.usuario.usuApellidos asc, u.usuario.usuNombres asc");
        Query result = em.createQuery(sb.toString());
        if (!nombres.isEmpty()) {
            result.setParameter("nombres", "%" + nombres.toUpperCase() + "%");
        }
        return result.getResultList();
    }

    public VDocenteVinculacion2 findByUsuId(BigDecimal codUsu) {
        List<VDocenteVinculacion2> result = null;
        Query query = em.createQuery("SELECT o FROM VDocenteVinculacion2 o WHERE o.usuario.usuId =:codUsu");
        query.setParameter("codUsu", codUsu);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    /*public List<VDocenteVinculacion2> findByDepart(String codCampus, String codDepartamento) {
        List<VDocenteVinculacion2> result = null;
        Query query = em.createQuery("SELECT o FROM VDocenteVinculacion2 o WHERE o.stvcampCode = :codCampus AND o.stvsubjCode = :codDepartamento order by o.usuApellidos asc ");
        query.setParameter("codCampus", codCampus);
        query.setParameter("codDepartamento", codDepartamento);
        result = query.getResultList();
        return result;
    }*/

    public List<VDocenteVinculacion2> findByFiltro(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters,
            String idCampus, 
            String idDepartamento) {
        
        /*idDepartamento=null;
        idCampus=null;*/
        StringBuilder hql = new StringBuilder("SELECT o FROM VDocenteVinculacion2 o WHERE 1=1 ");
        //StringBuilder hql = new StringBuilder("SELECT distinct o FROM VDocenteVinculacion2 o left join fetch o.usuario left join fetch o.campus left join fetch o.departamento WHERE 1=1 ");
        if (idCampus != null && !idCampus.trim().isEmpty()) {
            hql.append("and o.campus.stvcampCode = :idCampus ");
        }
        if (idDepartamento != null && !idDepartamento.trim().isEmpty()) {
            hql.append("and o.departamento.stvsubjCode = :idDepartamento ");
        }      
        String filtroCedula = null;
        String filtroApellidos = null;
        String filtroNombres = null;
        String filtroCampus = null;
        String filtroDepartamento = null;
        
        if (filters!=null){
             filtroCedula = (String) filters.get("usuario.usuCc");
             filtroApellidos = (String) filters.get("usuario.usuApellidos");
             filtroNombres = (String) filters.get("usuario.usuNombres");
             filtroCampus = (String) filters.get("campus.stvcampDesc");
             filtroDepartamento = (String) filters.get("departamento.stvsubjDesc");
        }
        if (filtroCedula != null) {
            hql.append("and o.usuario.usuCc like :cedula ");
        }
        if (filtroApellidos != null) {
            hql.append("and upper(o.usuario.usuApellidos) like :apellidos ");
        }
        if (filtroNombres != null) {
            hql.append("and upper(o.usuario.usuNombres) like :nombres ");
        }
        if (filtroCampus != null) {
            hql.append("and upper(o.campus.stvcampDesc) like :campus ");
        }
        if (filtroDepartamento != null) {
            hql.append("and upper(o.departamento.stvsubjDesc) like :departamento ");
        }

        if (sortField != null) {
            hql.append(" order by o.").append(sortField).append(" ").append((sortOrder.equals(SortOrder.ASCENDING) ? "ASC" : "DESC"));
        }
        Query query = em.createQuery(hql.toString());
        //query.setFirstResult(first);
        //query.setMaxResults(pageSize);

        if (idCampus != null && !idCampus.trim().isEmpty()) {
            query.setParameter("idCampus", idCampus);
        }
        if (idDepartamento != null && !idDepartamento.trim().isEmpty()) {
            query.setParameter("idDepartamento", idDepartamento);
        }        
        if (filtroCedula != null) {
            query.setParameter("cedula", "%" + filtroCedula.trim() + "%");
        }
        if (filtroApellidos != null) {
            query.setParameter("apellidos", "%" + filtroApellidos.trim().toUpperCase() + "%");
        }
        if (filtroNombres != null) {
            query.setParameter("nombres", "%" + filtroNombres.trim().toUpperCase() + "%");
        }
        if (filtroCampus != null) {
            query.setParameter("campus", "%" + filtroCampus.trim().toUpperCase() + "%");
        }
        if (filtroDepartamento != null) {
            query.setParameter("departamento", "%" + filtroDepartamento.trim().toUpperCase() + "%");
        }
        List<VDocenteVinculacion2> a = query.getResultList();
        return a;
    }

    public int count(Map<String, Object> filters, String idCampus, String idDepartamento) {
        StringBuilder hql = new StringBuilder("SELECT count(o) FROM VDocenteVinculacion2 o WHERE 1=1 ");
        if (idCampus != null && !idCampus.trim().isEmpty()) {
            hql.append("and o.campus.stvcampCode = :idCampus ");
        }
        if (idDepartamento != null && !idDepartamento.trim().isEmpty()) {
            hql.append("and o.departamento.stvsubjCode = :idDepartamento ");
        }        
        String filtroCedula = null;
        String filtroApellidos = null;
        String filtroNombres = null;
        String filtroCampus = null;
        String filtroDepartamento = null;

        if (filters!=null){
            filtroCedula = (String) filters.get("usuario.usuCc");
            filtroApellidos = (String) filters.get("usuario.usuApellidos");
            filtroNombres = (String) filters.get("usuario.usuNombres");
            filtroCampus = (String) filters.get("campus.stvcampDesc");
            filtroDepartamento = (String) filters.get("departamento.stvsubjDesc");
            
        }
        if (filtroCedula != null) {
            hql.append("and o.usuario.usuCc like :cedula ");
        }
        if (filtroApellidos != null) {
            hql.append("and upper(o.usuario.usuApellidos) like :apellidos ");
        }
        if (filtroNombres != null) {
            hql.append("and upper(o.usuario.usuNombres) like :nombres ");
        }
        if (filtroCampus != null) {
            hql.append("and upper(o.campus.stvcampDesc) like :campus ");
        }
        if (filtroDepartamento != null) {
            hql.append("and upper(o.departamento.stvsubjDesc) like :departamento ");
        }

        TypedQuery<Long> query = em.createQuery(hql.toString(), Long.class);
        if (idCampus != null && !idCampus.trim().isEmpty()) {
            query.setParameter("idCampus", idCampus);
        }
        if (idDepartamento != null && !idDepartamento.trim().isEmpty()) {
            query.setParameter("idDepartamento", idDepartamento);
        }        
        if (filtroCedula != null) {
            query.setParameter("cedula", "%" + filtroCedula.trim() + "%");
        }
        if (filtroApellidos != null) {
            query.setParameter("apellidos", "%" + filtroApellidos.trim().toUpperCase() + "%");
        }
        if (filtroNombres != null) {
            query.setParameter("nombres", "%" + filtroNombres.trim().toUpperCase() + "%");
        }
        if (filtroCampus != null) {
            query.setParameter("campus", "%" + filtroCampus.trim().toUpperCase() + "%");
        }
        if (filtroDepartamento != null) {
            query.setParameter("departamento", "%" + filtroDepartamento.trim().toUpperCase() + "%");
        }

        return query.getSingleResult().intValue();
    }
    
    public Integer findCountByCampusDepartamento(String idCampus, String idDepartamento) {
        Query query = em.createQuery("SELECT count(o) FROM VDocenteVinculacion2 o WHERE o.campus.stvcampCode = :idCampus and o.departamento.stvsubjCode = :idDepartamento");
        query.setParameter("idCampus", idCampus);
        query.setParameter("idDepartamento", idDepartamento);
        return Integer.valueOf(query.getSingleResult().toString());    
    }
}

