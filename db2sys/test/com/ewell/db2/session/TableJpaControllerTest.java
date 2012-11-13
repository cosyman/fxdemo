/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.session;

import com.ewell.db2.entity.Table;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class TableJpaControllerTest {

    TableJpaController instance;

    public TableJpaControllerTest() {
    }

    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db2sysPU");
        instance = new TableJpaController(emf);
    }

    @After
    public void tearDown() {
    }

   
    /**
     * Test of findTableEntities method, of class TableJpaController.
     */
    @Test
    public void testFindTableEntities_0args() {
        System.out.println("findTableEntities");

         List<Table> result = instance.findTableEntities();
          for (Table object : result) {
            System.out.println(object.getTableSchem()+"_"+object.getTableName());
        }
    }

    /**
     * Test of findTablesBySchema method, of class TableJpaController.
     */
    @Test
    public void testFindTablesBySchema() {
        System.out.println("findTablesBySchema");
        String schema = "UNIDIM";

        List expResult = null;
        List<Table> result = instance.findTablesBySchema(schema);
        
//        for (Table object : result) {
//            System.out.println(object.getDbname()+object.getTableName());
//        }
    }

    
    @Test
    public void testGetTableCount() {
//        int result = instance.getTableCount();
    }
}
