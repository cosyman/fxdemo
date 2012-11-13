/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.session;

import com.ewell.db2.entity.Column;
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
public class ColumnJpaControllerTest {

    public ColumnJpaControllerTest() {
    }
    ColumnJpaController cjc = null;

    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db2sysPU");
        cjc = new ColumnJpaController(emf);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetEntityManager() {
    }

    @Test
    public void testFindColumnEntities_0args() {
    }

    @Test
    public void testFindColumnEntities_int_int() {
    }

    @Test
    public void testFindColumn() {
    }

    @Test
    public void testGetColumnCount() {
    }

    @Test
    public void testFindColumnsByTable() {
        List<Column> result = cjc.findColumnsByTableName("DAY") ;
        for (Column column : result) {
            System.out.println(column.getTableSchem()+column.getTableName()+column.getColumnName());
        }
    }
}
