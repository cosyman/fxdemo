package com.cosysoft.charts;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Bluesky
 */
public class StockChart extends VBox {

    private AreaChart<Integer, Integer> mainChart;
    private AnchorPane sliderPane;
    private AreaChart sliderChart;

    public StockChart() {

        NumberAxis xAxis = new NumberAxis("X Values", 1.0d, 9.0d, 2.0d);
        xAxis.setTickLength(12.0f);
        xAxis.labelProperty().set(null);
        NumberAxis yAxis = new NumberAxis("Y Values", 0.0d, 10.0d, 2.0d);
        yAxis.labelProperty().set(null);
//        yAxis.setTickMarkVisible(false);
//        yAxis.setTickLabelsVisible(false);
        ObservableList<AreaChart.Series> areaChartData = FXCollections.observableArrayList(
                new AreaChart.Series("Series 1", FXCollections.observableArrayList(
                new AreaChart.Data(0, 4),
                new AreaChart.Data(2, 5),
                new AreaChart.Data(4, 4),
                new AreaChart.Data(6, 2),
                new AreaChart.Data(8, 6),
                new AreaChart.Data(10, 8))));
        mainChart = new AreaChart(xAxis, yAxis, areaChartData);
        mainChart.legendVisibleProperty().set(false);

        sliderPane = new AnchorPane();

        final NumberAxis sxAxis = new NumberAxis(null, 1.0d, 9.0d, 2.0d);
        sxAxis.setTickLength(12.0f);
        NumberAxis syAxis = new NumberAxis(null, 0.0d, 10.0d, 5.0d);
        ObservableList<AreaChart.Series> sareaChartData = FXCollections.observableArrayList(
                new AreaChart.Series("Series 1", FXCollections.observableArrayList(
                new AreaChart.Data(0, 4),
                new AreaChart.Data(2, 5),
                new AreaChart.Data(4, 4),
                new AreaChart.Data(6, 2),
                new AreaChart.Data(8, 6),
                new AreaChart.Data(10, 8))));
        
        sliderChart = new AreaChart(sxAxis, syAxis, sareaChartData);
        sliderChart.legendVisibleProperty().set(false);
        sliderChart.setMinHeight(20);
        sliderChart.setPrefHeight(100);
        

        AnchorPane.setLeftAnchor(sliderChart, 0.0);
        AnchorPane.setRightAnchor(sliderChart, 0.0);
        AnchorPane.setBottomAnchor(sliderChart, 0.0);
        AnchorPane.setTopAnchor(sliderChart, 0.0);
         

        this.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                sliderPane.setPrefWidth(t1.doubleValue());
            }
        });
        this.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                sliderPane.setPrefWidth(t1.doubleValue());
                
            }
        });

        sliderPane.getChildren().add(sliderChart);
        getChildren().addAll(mainChart, sliderPane);

    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
    }
}
