/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.fx.grid;

import com.ewell.db2.entity.Table;
import javafx.scene.control.ListCell;

/**
 *
 * @author Administrator
 */
public class TableListCell extends ListCell<Table> {

    @Override
    public void updateItem(Table item, boolean empty) {
        super.updateItem(item, empty);
        
        if (item != null) {
            setText(item.getTableSchem() + "|" + item.getTableName());
        }
    }
}
