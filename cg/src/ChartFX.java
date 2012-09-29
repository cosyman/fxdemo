import com.cosysoft.charts.StockChart;
import com.cosysoft.ui.window.RootDecorator;
import com.javafx.experiments.scenicview.ScenicView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Bluesky
 */
public class ChartFX extends Application {

    @Override
    public void start(Stage primaryStage) {


        BorderPane root2 = new BorderPane();
        root2.setCenter(new StockChart());

        Scene scene = new Scene(new RootDecorator(root2), 900, 600, Color.TRANSPARENT);

        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        ScenicView.show(scene);

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
