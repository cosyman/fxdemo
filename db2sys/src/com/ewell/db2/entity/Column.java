/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.db2.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "SQLCOLUMNS", catalog = "", schema = "SYSIBM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Column.findAll", query = "SELECT c FROM Column c"),
    @NamedQuery(name = "Column.findByTableCat", query = "SELECT c FROM Column c WHERE c.tableCat = :tableCat"),
    @NamedQuery(name = "Column.findByTableSchem", query = "SELECT c FROM Column c WHERE c.tableSchem = :tableSchem"),
    @NamedQuery(name = "Column.findByTableName", query = "SELECT c FROM Column c WHERE c.tableName = :tableName"),
    @NamedQuery(name = "Column.findByTable", query = "SELECT c FROM Column c WHERE c.tableName = :tableName and c.tableSchem=:tableSchem ORDER BY c.columnName"),
    @NamedQuery(name = "Column.findByColumnName", query = "SELECT c FROM Column c WHERE c.columnName = :columnName"),
    @NamedQuery(name = "Column.findByDataType", query = "SELECT c FROM Column c WHERE c.dataType = :dataType"),
    @NamedQuery(name = "Column.findByTypeName", query = "SELECT c FROM Column c WHERE c.typeName = :typeName"),
    @NamedQuery(name = "Column.findByNullable", query = "SELECT c FROM Column c WHERE c.nullable = :nullable"),
    @NamedQuery(name = "Column.findByRemarks", query = "SELECT c FROM Column c WHERE c.remarks = :remarks"),
    @NamedQuery(name = "Column.findByColumnDef", query = "SELECT c FROM Column c WHERE c.columnDef = :columnDef"),
    @NamedQuery(name = "Column.findBySqlDataType", query = "SELECT c FROM Column c WHERE c.sqlDataType = :sqlDataType"),
    @NamedQuery(name = "Column.findBySqlDatetimeSub", query = "SELECT c FROM Column c WHERE c.sqlDatetimeSub = :sqlDatetimeSub"),
    @NamedQuery(name = "Column.findByCharOctetLength", query = "SELECT c FROM Column c WHERE c.charOctetLength = :charOctetLength"),
    @NamedQuery(name = "Column.findByOrdinalPosition", query = "SELECT c FROM Column c WHERE c.ordinalPosition = :ordinalPosition"),
    @NamedQuery(name = "Column.findByIsNullable", query = "SELECT c FROM Column c WHERE c.isNullable = :isNullable"),
    @NamedQuery(name = "Column.findByJdbcDataType", query = "SELECT c FROM Column c WHERE c.jdbcDataType = :jdbcDataType"),
})
public class Column implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @javax.persistence.Column(name = "TABLE_CAT")
    private String tableCat;
    @Basic(optional = false)
    @javax.persistence.Column(name = "TABLE_SCHEM")
    private String tableSchem;
    @Basic(optional = false)
    @javax.persistence.Column(name = "TABLE_NAME")
    private String tableName;
    @Id
    @Basic(optional = false)
    @javax.persistence.Column(name = "COLUMN_NAME")
    private String columnName;
    @Basic(optional = false)
    @javax.persistence.Column(name = "DATA_TYPE")
    private short dataType;
    @Basic(optional = false)
    @javax.persistence.Column(name = "TYPE_NAME")
    private String typeName;
    @Basic(optional = false)
    @javax.persistence.Column(name = "COLUMN_SIZE")
    private int columnSize;
    @javax.persistence.Column(name = "BUFFER_LENGTH")
    private Integer bufferLength;
    @javax.persistence.Column(name = "DECIMAL_DIGITS")
    private Short decimalDigits;
    @javax.persistence.Column(name = "NUM_PREC_RADIX")
    private Short numPrecRadix;
    @Basic(optional = false)
    @javax.persistence.Column(name = "NULLABLE")
    private short nullable;
    @javax.persistence.Column(name = "REMARKS")
    private String remarks;
    @javax.persistence.Column(name = "COLUMN_DEF")
    private String columnDef;
    @Basic(optional = false)
    @javax.persistence.Column(name = "SQL_DATA_TYPE")
    private short sqlDataType;
    @javax.persistence.Column(name = "SQL_DATETIME_SUB")
    private Short sqlDatetimeSub;
    @javax.persistence.Column(name = "CHAR_OCTET_LENGTH")
    private Integer charOctetLength;
    @Basic(optional = false)
    @javax.persistence.Column(name = "ORDINAL_POSITION")
    private int ordinalPosition;
    @Basic(optional = false)
    @javax.persistence.Column(name = "IS_NULLABLE")
    private String isNullable;
    @Basic(optional = false)
    @javax.persistence.Column(name = "JDBC_DATA_TYPE")
    private short jdbcDataType;
    @javax.persistence.Column(name = "SCOPE_CATLOG")
    private String scopeCatlog;
    @javax.persistence.Column(name = "SCOPE_SCHEMA")
    private String scopeSchema;
    @javax.persistence.Column(name = "SCOPE_TABLE")
    private String scopeTable;
    @javax.persistence.Column(name = "SOURCE_DATA_TYPE")
    private Short sourceDataType;
    @javax.persistence.Column(name = "DBNAME")
    private String dbname;
    @Basic(optional = false)
    @javax.persistence.Column(name = "PSEUDO_COLUMN")
    private short pseudoColumn;

    public Column() {
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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public short getDataType() {
        return dataType;
    }

    public void setDataType(short dataType) {
        this.dataType = dataType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public Integer getBufferLength() {
        return bufferLength;
    }

    public void setBufferLength(Integer bufferLength) {
        this.bufferLength = bufferLength;
    }

    public Short getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Short decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public Short getNumPrecRadix() {
        return numPrecRadix;
    }

    public void setNumPrecRadix(Short numPrecRadix) {
        this.numPrecRadix = numPrecRadix;
    }

    public short getNullable() {
        return nullable;
    }

    public void setNullable(short nullable) {
        this.nullable = nullable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getColumnDef() {
        return columnDef;
    }

    public void setColumnDef(String columnDef) {
        this.columnDef = columnDef;
    }

    public short getSqlDataType() {
        return sqlDataType;
    }

    public void setSqlDataType(short sqlDataType) {
        this.sqlDataType = sqlDataType;
    }

    public Short getSqlDatetimeSub() {
        return sqlDatetimeSub;
    }

    public void setSqlDatetimeSub(Short sqlDatetimeSub) {
        this.sqlDatetimeSub = sqlDatetimeSub;
    }

    public Integer getCharOctetLength() {
        return charOctetLength;
    }

    public void setCharOctetLength(Integer charOctetLength) {
        this.charOctetLength = charOctetLength;
    }

    public int getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(int ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public short getJdbcDataType() {
        return jdbcDataType;
    }

    public void setJdbcDataType(short jdbcDataType) {
        this.jdbcDataType = jdbcDataType;
    }

    public String getScopeCatlog() {
        return scopeCatlog;
    }

    public void setScopeCatlog(String scopeCatlog) {
        this.scopeCatlog = scopeCatlog;
    }

    public String getScopeSchema() {
        return scopeSchema;
    }

    public void setScopeSchema(String scopeSchema) {
        this.scopeSchema = scopeSchema;
    }

    public String getScopeTable() {
        return scopeTable;
    }

    public void setScopeTable(String scopeTable) {
        this.scopeTable = scopeTable;
    }

    public Short getSourceDataType() {
        return sourceDataType;
    }

    public void setSourceDataType(Short sourceDataType) {
        this.sourceDataType = sourceDataType;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public short getPseudoColumn() {
        return pseudoColumn;
    }

    public void setPseudoColumn(short pseudoColumn) {
        this.pseudoColumn = pseudoColumn;
    }
    
}
