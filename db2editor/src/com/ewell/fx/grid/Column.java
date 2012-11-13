/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.fx.grid;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Administrator
 */
public class Column {

    private final BooleanProperty selected = new SimpleBooleanProperty();

    public boolean isSelected() {
        return selected.get();
    }

    public void setSelected(boolean value) {
        selected.set(value);
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }
    private String tableSchem;
    private String tableName;
    private String columnName;
    private short dataType;
    private String typeName;
    private int columnSize;
    private Integer bufferLength;
    private Short decimalDigits;
    private Short numPrecRadix;
    private short nullable;
    private String remarks;
    private String columnDef;
    private short sqlDataType;
    private Short sqlDatetimeSub;
    private Integer charOctetLength;
    private int ordinalPosition;
    private String isNullable;
    private short jdbcDataType;

    public Column() {
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
}
