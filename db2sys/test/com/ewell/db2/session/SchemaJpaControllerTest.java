/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.session;

import com.ewell.db2.entity.Schema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class SchemaJpaControllerTest {

    public SchemaJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    private SchemaJpaController instance;

    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db2sysPU");
        instance = new SchemaJpaController(emf);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class .
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSchemaEntities method, of class .
     */
    @Test
    public void testFindSchemaEntities_0args() {
        System.out.println("findSchemaEntities");
        
        List expResult = null;
        List result = instance.findSchemaEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSchemaEntities method, of class .
     */
    @Test
    public void testFindSchemaEntities_int_int() {
        System.out.println("findSchemaEntities");
        int maxResults = 0;
        int firstResult = 0;
        List expResult = null;
        List result = instance.findSchemaEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSchema method, of class .
     */
    @Test
    public void testFindSchema() {
        System.out.println("findSchema");
        String id = "";
        
        Schema expResult = null;
        Schema result = instance.findSchema(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSchemaCount method, of class .
     */
    @Test
    public void testGetSchemaCount() {
        System.out.println("getSchemaCount");
        
        int expResult = 0;
        int result = instance.getSchemaCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
