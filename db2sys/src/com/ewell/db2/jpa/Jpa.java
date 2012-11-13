/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrator
 */
public class Jpa {

    public static EntityManagerFactory EMF;

    public static void load() {
        if (EMF == null) {
            EMF = Persistence.createEntityManagerFactory("db2sysPU");
        }
    }
}
