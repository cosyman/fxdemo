/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.session;

import com.ewell.db2.entity.Table;
import com.ewell.db2.entity.Table_;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
public class TableJpaController implements Serializable {

    public TableJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Table> findTableEntities() {
        return findTableEntities(true, -1, -1);
    }

    public List<Table> findTableEntities(int maxResults, int firstResult) {
        return findTableEntities(false, maxResults, firstResult);
    }

    private List<Table> findTableEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Table> r = cq.from(Table.class);
            cq.where(cb.and(cb.notLike(r.get(Table_.tableSchem), "SYS%"), cb.notLike(r.get(Table_.tableSchem), "S_%")));
            cq.orderBy(cb.asc(r.get(Table_.tableSchem)));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Table findTable(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Table.class, id);
        } finally {
            em.close();
        }
    }

    public int getTableCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Table> rt = cq.from(Table.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Table> findTablesBySchema(String schema) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Table.findByTableSchem", Table.class);
            q.setParameter("tableSchem", schema);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
