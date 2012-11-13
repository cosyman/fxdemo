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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "SQLSCHEMAS", catalog = "", schema = "SYSIBM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schema.findAll", query = "SELECT s FROM Schema s"),
    @NamedQuery(name = "Schema.findByTableCat", query = "SELECT s FROM Schema s WHERE s.tableCat = :tableCat"),
    @NamedQuery(name = "Schema.findByTableSchem", query = "SELECT s FROM Schema s WHERE s.tableSchem = :tableSchem"),
    @NamedQuery(name = "Schema.findByTableName", query = "SELECT s FROM Schema s WHERE s.tableName = :tableName"),
    @NamedQuery(name = "Schema.findByTableType", query = "SELECT s FROM Schema s WHERE s.tableType = :tableType"),
    @NamedQuery(name = "Schema.findByRemarks", query = "SELECT s FROM Schema s WHERE s.remarks = :remarks"),
    @NamedQuery(name = "Schema.findByTypeCat", query = "SELECT s FROM Schema s WHERE s.typeCat = :typeCat"),
    @NamedQuery(name = "Schema.findByTypeSchem", query = "SELECT s FROM Schema s WHERE s.typeSchem = :typeSchem"),
    @NamedQuery(name = "Schema.findByTypeName", query = "SELECT s FROM Schema s WHERE s.typeName = :typeName"),
    @NamedQuery(name = "Schema.findBySelfRefColName", query = "SELECT s FROM Schema s WHERE s.selfRefColName = :selfRefColName"),
    @NamedQuery(name = "Schema.findByRefGeneration", query = "SELECT s FROM Schema s WHERE s.refGeneration = :refGeneration"),
    @NamedQuery(name = "Schema.findByDbname", query = "SELECT s FROM Schema s WHERE s.dbname = :dbname")})
public class Schema implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "TABLE_CAT")
    private String tableCat;
    @Id
    @Basic(optional = false)
    @Column(name = "TABLE_SCHEM")
    private String tableSchem;
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

    public Schema() {
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
