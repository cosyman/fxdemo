/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.session;

import com.ewell.db2.entity.Schema;
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
public class SchemaJpaController implements Serializable {

    public SchemaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Schema> findSchemaEntities() {
        return findSchemaEntities(true, -1, -1);
    }

    public List<Schema> findSchemaEntities(int maxResults, int firstResult) {
        return findSchemaEntities(false, maxResults, firstResult);
    }

    private List<Schema> findSchemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Schema.class));
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

    public Schema findSchema(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Schema.class, id);
        } finally {
            em.close();
        }
    }

    public int getSchemaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Schema> rt = cq.from(Schema.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
