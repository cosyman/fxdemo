/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cosysoft.ui.window;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.AnchorPaneBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Window;

/**
 *
 * @author Bluesky
 */
public class RootDecorator extends VBox {

    private Region header;
    private Pane root = new Pane();
    private boolean initialized = false;

    public RootDecorator(Pane root) {
        this.root = root;
        buildHeader();
    }

    private void buildHeader() {

        if (initialized) {
            return;
        }
        this.setOpacity(1);

        Path close = PathBuilder.create()
                .elements(new MoveTo(5, 5), new LineTo(15, 15), new MoveTo(15, 5), new LineTo(5, 15)).build();
        Pane closeBtn = PaneBuilder.create().children(close).onMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                RootDecorator.this.getScene().getWindow().hide();
            }
        }).build();
        closeBtn.setPrefSize(20, 20);

        Rectangle minmax = new Rectangle(10, 8, Color.TRANSPARENT);
        minmax.setStroke(Color.BLACK);
        Rectangle minmax2 = new Rectangle(10, 8, Color.TRANSPARENT);
        minmax2.setStroke(Color.BLACK);
        Pane minMaxBtn = PaneBuilder.create().children(minmax, minmax2).build();
        minmax.setLayoutX(8);
        minmax.setLayoutY(5);
        minmax2.setLayoutX(5);
        minmax2.setLayoutY(8);
        minMaxBtn.setPrefSize(20, 20);
        minMaxBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Window p = RootDecorator.this.getScene().getWindow();
                if (isMaxed) {
                    p.setX(oldWinSize.getMinX());
                    p.setY(oldWinSize.getMinY());
                    p.setWidth(oldWinSize.getWidth());
                    p.setHeight(oldWinSize.getHeight());
                } else {
                    oldWinSize = new Rectangle2D(p.getX(), p.getY(), p.getWidth(), p.getHeight());
                    p.setX(0);
                    p.setY(0);
                    p.setWidth(Screen.getPrimary().getBounds().getWidth());
                    p.setHeight(Screen.getPrimary().getBounds().getHeight());
                }
                isMaxed = !isMaxed;

            }
        });



        final Line tbDiv = new Line();
        tbDiv.setStartX(0);
        tbDiv.setStartY(21);
        tbDiv.setEndY(21);
        tbDiv.setStroke(Color.web("0xC0C0C0"));

        this.header = AnchorPaneBuilder.create().children(closeBtn, minMaxBtn, tbDiv).build();


        AnchorPane.setRightAnchor(closeBtn, 0d);
        AnchorPane.setRightAnchor(minMaxBtn, 18d);
        AnchorPane.setBottomAnchor(tbDiv, 0d);
        tbDiv.endXProperty().bind(header.widthProperty());

        this.header.setPrefHeight(21);


        this.header.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                anchorPt = new Point2D(event.getScreenX(), event.getScreenY());
                header.setCursor(Cursor.MOVE);
            }
        });

        this.header.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (anchorPt != null && previousLocation != null) {
                    RootDecorator.this.getScene().getWindow().setX(previousLocation.getX() + event.getScreenX() - anchorPt.getX());
                    RootDecorator.this.getScene().getWindow().setY(previousLocation.getY() + event.getScreenY() - anchorPt.getY());
                }
            }
        });

        this.header.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                header.setCursor(Cursor.DEFAULT);
                previousLocation = new Point2D(RootDecorator.this.getScene().getWindow().getX(), RootDecorator.this.getScene().getWindow().getY());
            }
        });




        this.getChildren().addAll(header, root);

        initialized = true;

    }
    private EventHandler<MouseEvent> mouseMove = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };
    private Point2D anchorPt;
    private Point2D previousLocation;
    private Rectangle2D oldWinSize;
    private boolean isMaxed;
}
