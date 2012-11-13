/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db2editor;

import com.ewell.db2.entity.Table;
import com.ewell.db2.jpa.Jpa;
import com.ewell.db2.session.ColumnJpaController;
import com.ewell.db2.session.TableJpaController;
import com.ewell.fx.grid.Column;
import com.ewell.fx.grid.Editor;
import com.ewell.fx.grid.TableListCell;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Administrator
 */
public class SampleController implements Initializable {

    TableJpaController tjc = null;
    ColumnJpaController cjc = null;
    List<Table> tableList;
    List<Column> columns1 = new ArrayList<>();
    ObservableList<Table> otableList;
    ObservableList<Column> list;
    @FXML
    private Label label;
    @FXML
    private ListView<Table> tableListView;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField tableTF;

    @FXML
    private void handleGenerateAction(ActionEvent event) {
        Table item = tableListView.getSelectionModel().getSelectedItem();
        if (item != null) {
            columns1 = new ArrayList<>();
            List<com.ewell.db2.entity.Column> columns = cjc.findColumnsByTable(item);

            Tab tab = new Tab(item.getTableName());
            for (com.ewell.db2.entity.Column column : columns) {
                try {
                    Column c = new Column();
                    BeanUtils.copyProperties(c, column);
                    columns1.add(c);
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Editor editor = new Editor(columns1);
            tab.setContent(editor);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        }
    }

    @FXML
    private void handleTableChange(ObservableValue<? extends String> ov, String t, String t1) {
        System.out.println("ddd" + t1.toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                System.out.println(t + "_" + t1);
                List<Table> lasts = new ArrayList<>();
                for (Table table : tableList) {
                    if (table.getTableName().startsWith(t1.toUpperCase())) {
                        lasts.add(table);
                    }
                }
                otableList = FXCollections.observableArrayList(lasts);
                tableListView.setItems(otableList);
            }
        });


        tableListView.setCellFactory(new Callback<ListView<Table>, ListCell<Table>>() {
            @Override
            public ListCell<Table> call(ListView<Table> p) {
                return new TableListCell();
            }
        });
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                updateMessage("开始连接......初始化JPA要等待8秒....");
                Jpa.load();
                tjc = new TableJpaController(Jpa.EMF);
                cjc = new ColumnJpaController(Jpa.EMF);
                cjc.getColumnCount();
                updateMessage("连接成功了.......");
                return null;
            }
        };
        new Thread(task).start();
        label.textProperty().bind(task.messageProperty());
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                tableList = tjc.findTableEntities();
                otableList = FXCollections.observableArrayList(tableList);
                tableListView.setItems(otableList);
            }
        });
    }
}
