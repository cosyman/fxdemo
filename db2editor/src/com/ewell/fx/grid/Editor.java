/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewell.fx.grid;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import jfxtras.labs.scene.control.grid.GridCell;
import jfxtras.labs.scene.control.grid.GridView;
import jfxtras.labs.util.grid.GridPaginationHelper;

/**
 *
 * @author Administrator
 */
public class Editor extends VBox {

    List<Column> columns1;
    ObservableList<Column> list;
    TextArea ta = new TextArea();
    GridView<Column> myGrid;

    public Editor(List<Column> columns) {
        columns1 = columns;
        list = FXCollections.<Column>observableArrayList(columns1);
        myGrid = new GridView<>(list);

        myGrid.setCellHeight(20);
        myGrid.setCellWidth(150);
        myGrid.setVerticalCellSpacing(2d);
        myGrid.setHorizontalCellSpacing(2d);
        myGrid.horizontalAlignmentProperty().setValue(HPos.CENTER);

        Pagination pagination = new Pagination();

        Callback<GridView<Column>, GridCell<Column>> cellFactory = new Callback<GridView<Column>, GridCell<Column>>() {
            @Override
            public GridCell<Column> call(GridView<Column> p) {
                return new CheckBoxGridCell();
            }
        };

        new GridPaginationHelper<>(pagination, list, cellFactory);
        myGrid.setCellFactory(cellFactory);

        ToolBar hb = new ToolBar();
        TextField tf = new TextField();
        tf.setPrefWidth(200);
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                System.out.println(t + "_" + t1);
                List<Column> lasts = new ArrayList<>();
                for (Column c : columns1) {
                    if (c.getColumnName().startsWith(t1.toUpperCase())) {
                        lasts.add(c);
                    }
                }
                list = FXCollections.observableArrayList(lasts);
                myGrid.setItems(list);
            }
        });



        hb.getItems().addAll(tf);

        //
        AnchorPane anchorPane = new AnchorPane();
        ta.setPrefHeight(200);

        AnchorPane.setLeftAnchor(myGrid, 0d);
        AnchorPane.setRightAnchor(myGrid, 0d);
        AnchorPane.setTopAnchor(myGrid, 0d);
        AnchorPane.setBottomAnchor(myGrid, 200d);
        AnchorPane.setLeftAnchor(ta, 0d);
        AnchorPane.setRightAnchor(ta, 0d);
        AnchorPane.setBottomAnchor(ta, 0d);

        anchorPane.getChildren().addAll(myGrid, ta);

        VBox.setVgrow(anchorPane, Priority.ALWAYS);
        getChildren().addAll(hb, anchorPane);

        myGrid.addEventHandler(GridCellItemEvent.ItemChange, new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                ta.clear();
                List<Column> seColumns = new ArrayList<>();
                for (Column column : columns1) {
                    if (column.isSelected()) {
                        seColumns.add(column);
                    }
                }
                if (seColumns.size() > 0) {
                    ta.appendText("SELECT ");
                    int i = 0;
                    for (; i < seColumns.size() - 1; i++) {
                        Column c = seColumns.get(i);
                        ta.appendText("\t");
                        ta.appendText(c.getColumnName());
                        ta.appendText(",\n");
                    }
                    ta.appendText("\t");
                    ta.appendText(seColumns.get(i).getColumnName() + "\n  FROM ");
                    ta.appendText("\t");
                    ta.appendText(columns1.get(0).getTableName());
                }

            }
        });
    }
}
