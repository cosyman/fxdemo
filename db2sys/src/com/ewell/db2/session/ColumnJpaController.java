/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.session;

import com.ewell.db2.entity.Column;
import com.ewell.db2.entity.Table;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
public class ColumnJpaController implements Serializable {

    public ColumnJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Column> findColumnEntities() {
        return findColumnEntities(true, -1, -1);
    }

    public List<Column> findColumnEntities(int maxResults, int firstResult) {
        return findColumnEntities(false, maxResults, firstResult);
    }

    private List<Column> findColumnEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Column.class));
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

    public Column findColumn(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Column.class, id);
        } finally {
            em.close();
        }
    }

    public int getColumnCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Column> rt = cq.from(Column.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Column> findColumnsByTableName(String table) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Column.findByTableName", Column.class);
            q.setParameter("tableName", table);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Column> findColumnsByTable(Table table) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Column.findByTable", Column.class);
            q.setParameter("tableName", table.getTableName());
            q.setParameter("tableSchem", table.getTableSchem());
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
