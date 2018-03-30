/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.vinculacion.session;

import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ProyectoReporte;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

/**
 *
 * @author PC1
 */
@Stateless(mappedName = "ProyectoFacade")
public class ProyectoFacade extends AbstractFacade<Proyecto> {

    @PersistenceContext(unitName = "Vinculacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }

    public List<Proyecto> findByProgramaEstado(Integer codProg, Long estado) {
        String where = "WHERE o.estadoActivo= 'A' ";
        if (codProg != null) {
            where += " and o.programa.id = " + codProg;
        }
        /*if (estado != null && !estado.isEmpty()) {
            if (estado.equals(Proyecto.ESTADO_CREADO)) {
                where += " and (o.estado = 'CRE' or o.estado= 'REV')";
            } else {
                where += " and o.estado = '" + estado + "'";
            }
        }*/
        if (estado != null) {
            where += " and o.estado.prdId = '" + estado + "'";
        }
        
        Query query = em.createQuery("SELECT o FROM Proyecto o " + where);
        return (query.getResultList());
    }

    /*public List<Proyecto> findByAprobadoComisionVinculacion(Programa programa, Integer codigoProyecto, String tipoGasto, String codigoCarrera, String codigoDepartamento, Integer cobertura, SeaProvincia provincia, SeaCanton canton, SeaParroquia parroquia, String codigoCampus) {
        StringBuilder where = new StringBuilder();
        if (programa != null) {
            where.append(" and o.programa.id = ").append(programa.getId());
            if (codigoProyecto != null) {
                where.append(" and o.id = ").append(codigoProyecto);
            }
        }
        if (tipoGasto != null) {
            where.append(" and o.tipo = '").append(tipoGasto).append("'");
        }
        if (codigoCarrera != null && !codigoCarrera.isEmpty()) {
            where.append(" and o in (select car.proyecto from CarreraProyecto car where car.carrera.stvmajrCode = '").append(codigoCarrera).append("')");
        }
        if (codigoDepartamento != null && !codigoDepartamento.isEmpty()) {
            where.append(" and o in (select dep.proyecto from DepartamentoProyecto dep where dep.departamento.stvsubjCode = '").append(codigoDepartamento).append("')");
        }
        if (cobertura != null && !cobertura.equals(0)) {
            where.append(" and o.cobertura = ").append(cobertura);
        }
        if (provincia != null) {
            where.append(" and o in (select prov.proyecto from LocalizacionPrograma prov where prov.provincia.proId = '").append(provincia.getProId()).append("')");
        }
        if (canton != null) {
            where.append(" and o in (select can.proyecto from LocalizacionPrograma can where can.canton.canId = '").append(canton.getCanId()).append("')");
        }
        if (parroquia != null) {
            where.append(" and o in (select parr.proyecto from LocalizacionPrograma parr where parr.parroquia.prqId = '").append(parroquia.getPrqId()).append("')");
        }
        if (codigoCampus != null && !codigoCampus.isEmpty()) {
            where.append(" and o in (select s.proyecto from DepartamentoProyecto s where s.campus.stvcampCode = '").append(codigoCampus).append("')");
        }
        Query query = em.createQuery("SELECT o FROM Proyecto o where o.estadoActivo = 'A' and o.estado != 'CRE' and o.estado != 'REV' and o.estado != 'CEP' and o.estado != 'CEC' and o.estado != 'REC0'" + where.toString());
        return (query.getResultList());
    }*/

    /*public List<Proyecto> findXCampos(
            Date fechaInicio,
            Date fechaFinalizacion,
            Programa programa,
            Integer idProyecto,
            String tipoGasto,
            String estado,
            String idCarrera,
            String idDepartamento,
            SeaProvincia provincia,
            SeaCanton canton,
            SeaParroquia parroquia,
            String idCampus,
            Integer cobertura,
            SegUsuario docente,
            SegUsuario estudiante) {
        StringBuilder where = new StringBuilder();
        if (fechaInicio != null) {
            where.append(" and o.fechaInicio >= :fechaInicio");
        }
        if (fechaFinalizacion != null) {
            where.append(" and o.fechaFinalizacion <= :fechaFinalizacion");
        }
        if (programa != null) {
            where.append(" and o.programa.id = ").append(programa.getId());
            if (idProyecto != null) {
                where.append(" and o.id = ").append(idProyecto);
            }
        }
        if (tipoGasto != null) {
            where.append(" and o.tipo = '").append(tipoGasto).append("'");
        }
        if (estado != null && !estado.isEmpty()) {
            where.append(" and o.estado = '").append(estado).append("'");
        }
        if (idCarrera != null && !idCarrera.isEmpty()) {
            where.append(" and o in (select car.proyecto from CarreraProyecto car where car.carrera.stvmajrCode = '").append(idCarrera).append("')");
        }
        if (idDepartamento != null && !idDepartamento.isEmpty()) {
            where.append(" and o in (select dep.proyecto from DepartamentoProyecto dep where dep.departamento.stvsubjCode = '").append(idDepartamento).append("')");
        }
        if (provincia != null) {
            where.append(" and o in (select prov.proyecto from LocalizacionPrograma prov where prov.provincia.proId = '").append(provincia.getProId()).append("')");
        }
        if (canton != null) {
            where.append(" and o in (select can.proyecto from LocalizacionPrograma can where can.canton.canId = '").append(canton.getCanId()).append("')");
        }
        if (parroquia != null) {
            where.append(" and o in (select parr.proyecto from LocalizacionPrograma parr where parr.parroquia.prqId = '").append(parroquia.getPrqId()).append("')");
        }
        if (idCampus != null && !idCampus.isEmpty()) {
            where.append(" and o in (select s.proyecto from DepartamentoProyecto s where s.campus.stvcampCode = '").append(idCampus).append("')");
        }
        if (cobertura != null && !cobertura.equals(0)) {
            where.append(" and o.cobertura = ").append(cobertura);
        }
        if (docente != null) {
            where.append(" and o in (select s.proyecto from ResponsableProyecto s where s.tipoResponsable.id=2 and s.usuario.usuId= ").append(docente.getUsuId()).append(")");
        }
        if (estudiante != null) {
            where.append(" and o in (select s.proyecto from ResponsableProyecto s where s.tipoResponsable.id=5 and s.usuario.usuId= ").append(estudiante.getUsuId()).append(")");
        }

        Query query = em.createQuery("SELECT o FROM Proyecto o where o.estadoActivo = 'A'" + where.toString());
        if (fechaInicio != null) {
            query.setParameter("fechaInicio", fechaInicio);
        }
        if (fechaFinalizacion != null) {
            query.setParameter("fechaFinalizacion", fechaFinalizacion);
        }

        return (query.getResultList());
    }*/

    public List<Proyecto> findByPorAutorizarVicerrectorado(Integer codConfiguracionParametrosEvaluacion) {
        String select = "SELECT o FROM Proyecto o WHERE o.estadoActivo = 'A' and ("
                + " o.estado.prdId != " + SeaParametrosDet.ESTADO_CREADO
                + " AND o.estado.prdId != " + SeaParametrosDet.ESTADO_REVISION
                + " AND o.estado.prdId != " + SeaParametrosDet.ESTADO_CERRADO_PERFIL
                + " AND o.estado.prdId != " + SeaParametrosDet.ESTADO_CERRADO_CALIFICACION
                + " AND o.estado.prdId != " + SeaParametrosDet.ESTADO_RECHAZADO_COMISION_VINCULACION
                + ")";
        if (codConfiguracionParametrosEvaluacion != null) {
            select += " AND o.configuracionParametrosEvaluacion.id = :codConfiguracionParametrosEvaluacion";
        }
        Query query = em.createQuery(select);
        if (codConfiguracionParametrosEvaluacion != null) {
            query.setParameter("codConfiguracionParametrosEvaluacion", codConfiguracionParametrosEvaluacion);
        }
        return (query.getResultList());
    }

    /*public List<Proyecto> findByEstadoAprobadoComisionVinculacion(String estado) {
        String where = "WHERE o.estadoActivo= 'A' ";
        if (estado != null && !estado.isEmpty()) {
            where += " and o.estado2.prdId = '" + estado + "'";
        } else {
            where += " and (o.estado = '" + Proyecto.ESTADO_RECHAZADO_COMISION_VINCULACION + "' or o.estado = '" + Proyecto.ESTADO_APROBADO_COMISION_VINCULACION + "')";
        }
        Query query = null;
        query = em.createQuery("SELECT o FROM Proyecto o " + where);
        return (query.getResultList());
    }*/

    public List<Proyecto> findByPorAutorizarConsejoAcadémico() {
        Query query = em.createQuery("SELECT o FROM Proyecto o WHERE o.estadoActivo='A' AND o.estado.prdId = " + SeaParametrosDet.ESTADO_APROBADO_VICERRECTORADO);
        return (query.getResultList());
    }

    public List<Proyecto> findByPorAutorizarVicerrectorado() {
        return (findByPorAutorizarVicerrectorado(null));
    }

    public Integer findCountByDepartamento(String codDep) {
        Query query = em.createQuery("SELECT count(o) FROM Proyecto o WHERE o.departamento.stvsubjCode = :codDep ");
        query.setParameter("codDep", codDep);
        return Integer.valueOf(query.getSingleResult().toString());
    }
    public Integer findSecuencialByDepartamento(String codDep) {
        Query query = em.createQuery("SELECT max(o.secuencial) FROM Proyecto o WHERE o.departamento.stvsubjCode = :codDep ");
        query.setParameter("codDep", codDep);
        if (query.getSingleResult()==null)
            return 0;
        return Integer.valueOf(query.getSingleResult().toString());
    }    

    public Proyecto findById(Integer id) {
        Query query = em.createQuery("SELECT o FROM Proyecto o WHERE o.id = :id ");
        query.setParameter("id", id);
        return ((Proyecto) query.getResultList().get(0));
    }

    public boolean verificarPermitirEdicionConfParamEvaluacion(Integer idConfiguracionParametrosEvaluacion) {
        Query query = em.createQuery("SELECT COUNT(o) FROM Proyecto o WHERE o.configuracionParametrosEvaluacion.id = :idConfiguracionParametrosEvaluacion");
        query.setParameter("idConfiguracionParametrosEvaluacion", idConfiguracionParametrosEvaluacion);
        return (Integer.valueOf(query.getSingleResult().toString()) == 0);
    }
    
    public boolean verificarPermitirEdicionConfParamEvaluacionFinal(Integer idConfiguracionParametrosEvaluacion) {
        Query query = em.createQuery("SELECT COUNT(o) FROM Proyecto o WHERE o.configuracionParametrosEvaluacionFinal.id = :idConfiguracionParametrosEvaluacion");
        query.setParameter("idConfiguracionParametrosEvaluacion", idConfiguracionParametrosEvaluacion);
        return (Integer.valueOf(query.getSingleResult().toString()) == 0);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizarProyectos(List<Proyecto> proyectoList) {
        for (Proyecto proyecto : proyectoList) {
            
            this.edit(proyecto);
            
        }
    }

    public List<ProyectoReporte> findByA() {
        String sql = "SELECT FROM SZDTAVPROYEC o left join ";
        TypedQuery<ProyectoReporte> query = em.createQuery(sql, ProyectoReporte.class);
        List<ProyectoReporte> results = query.getResultList();
        return (results);
    }

    public List<Proyecto> find22(Integer id) {
        Query query = em.createQuery("SELECT o FROM Proyecto o WHERE o.id = :id ");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public void actualizarComisionProyecto2(Proyecto proyecto) {
        String sql = "UPDATE SZDTAVPROYEC SET SZTVCONPARAEVA_CODE = ? WHERE SZTVPROYEC_CODE = ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, proyecto.getConfiguracionParametrosEvaluacion().getId());
        query.setParameter(2, proyecto.getId());
        query.executeUpdate();
    }
    /*public void actualizarCumpleRequisitos(Proyecto proyecto) {
        String sql = "UPDATE SZDTAVPROYEC SET SZTVPROYEC_CUMPLE_REQ = ? WHERE SZTVPROYEC_CODE = ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, proyecto.getCumpleRequisitos());
        query.setParameter(2, proyecto.getId());
        query.executeUpdate();
    }*/        
}
