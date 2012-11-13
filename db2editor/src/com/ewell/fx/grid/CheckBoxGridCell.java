/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.fx.grid;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import jfxtras.labs.scene.control.grid.GridCell;

/**
 *
 * @author Administrator
 */
public class CheckBoxGridCell extends GridCell<Column> {

    CheckBox ckb;

    public CheckBoxGridCell() {
        getChildren().clear();
        getStyleClass().add("image-grid-cell");
        itemProperty().addListener(new ChangeListener<Column>() {
            @Override
            public void changed(ObservableValue<? extends Column> arg0,
                    Column arg1, Column arg2) {
                getChildren().clear();
                ckb = CheckBoxBuilder.create().text(arg2.getColumnName()).selected(arg2.isSelected()).build();
                ckb.selectedProperty().bindBidirectional(arg2.selectedProperty());

                ckb.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                        fireEvent(new GridCellItemEvent(GridCellItemEvent.ItemChange));
                    }
                });
                setGraphic(ckb);
            }
        });
    }
}
