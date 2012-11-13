/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@javax.persistence.Table(name = "SQLTABLES", catalog = "", schema = "SYSIBM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Table.findAll", query = "SELECT t FROM Table t"),
    @NamedQuery(name = "Table.findByTableCat", query = "SELECT t FROM Table t WHERE t.tableCat = :tableCat"),
    @NamedQuery(name = "Table.findByTableSchem", query = "SELECT t FROM Table t WHERE t.tableSchem = :tableSchem"),
    @NamedQuery(name = "Table.findByTableName", query = "SELECT t FROM Table t WHERE t.tableName = :tableName"),
    @NamedQuery(name = "Table.findByTableType", query = "SELECT t FROM Table t WHERE t.tableType = :tableType"),
    @NamedQuery(name = "Table.findByRemarks", query = "SELECT t FROM Table t WHERE t.remarks = :remarks"),
    @NamedQuery(name = "Table.findByTypeCat", query = "SELECT t FROM Table t WHERE t.typeCat = :typeCat"),
    @NamedQuery(name = "Table.findByTypeSchem", query = "SELECT t FROM Table t WHERE t.typeSchem = :typeSchem"),
    @NamedQuery(name = "Table.findByTypeName", query = "SELECT t FROM Table t WHERE t.typeName = :typeName"),
    @NamedQuery(name = "Table.findBySelfRefColName", query = "SELECT t FROM Table t WHERE t.selfRefColName = :selfRefColName"),
    @NamedQuery(name = "Table.findByRefGeneration", query = "SELECT t FROM Table t WHERE t.refGeneration = :refGeneration"),
    @NamedQuery(name = "Table.findByDbname", query = "SELECT t FROM Table t WHERE t.dbname = :dbname")})
public class Table implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TABLE_CAT")
    private String tableCat;
    @Basic(optional = false)
    @Column(name = "TABLE_SCHEM")
    private String tableSchem;
    @Id
    @Basic(optional = false)
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Column(name = "TABLE_TYPE")
    private String tableType;
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "TYPE_CAT")
    private String typeCat;
    @Column(name = "TYPE_SCHEM")
    private String typeSchem;
    @Column(name = "TYPE_NAME")
    private String typeName;
    @Column(name = "SELF_REF_COL_NAME")
    private String selfRefColName;
    @Column(name = "REF_GENERATION")
    private String refGeneration;
    @Column(name = "DBNAME")
    private String dbname;

    public Table() {
    }

    public String getTableCat() {
        return tableCat;
    }

    public void setTableCat(String tableCat) {
        this.tableCat = tableCat;
    }

    public String getTableSchem() {
        return tableSchem;
    }

    public void setTableSchem(String tableSchem) {
        this.tableSchem = tableSchem;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeCat() {
        return typeCat;
    }

    public void setTypeCat(String typeCat) {
        this.typeCat = typeCat;
    }

    public String getTypeSchem() {
        return typeSchem;
    }

    public void setTypeSchem(String typeSchem) {
        this.typeSchem = typeSchem;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSelfRefColName() {
        return selfRefColName;
    }

    public void setSelfRefColName(String selfRefColName) {
        this.selfRefColName = selfRefColName;
    }

    public String getRefGeneration() {
        return refGeneration;
    }

    public void setRefGeneration(String refGeneration) {
        this.refGeneration = refGeneration;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    
}
