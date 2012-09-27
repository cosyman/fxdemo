/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.cosysoft.cg.GraphicUtil;
import java.util.Arrays;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Administrator
 */
public class Cg extends Application {

  @Override
  public void start(Stage primaryStage) {

    Pane root = new TilePane();
    
    Button b = new Button("hello dkfj");
    b.setOnMouseClicked((new EventHandler<MouseEvent>() {

          @Override
          public void handle(MouseEvent t) {
              Platform.exit();
          }
      }));
    b.setLayoutX(-10);
    root.getChildren().addAll(b,line(), line(), circle(), new Circle(100, new RadialGradient(0, 50, 50, 50, 50, true, CycleMethod.REPEAT, Arrays.asList(new Stop(.2, Color.GREEN),new Stop(.6, Color.CHARTREUSE),new Stop(.6, Color.RED)))), new Circle(100,Color.RED));


    Scene scene = new Scene(root, 800, 600,Color.TRANSPARENT);

    scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.initStyle(StageStyle.TRANSPARENT);
    primaryStage.show();
  }

  /**
   * The main() method is ignored in correctly deployed JavaFX application.
   * main() serves only as fallback in case the application can not be launched
   * through deployment artifacts, e.g., in IDEs with limited FX support.
   * NetBeans ignores main().
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  static ImageView line() {
    WritableImage i = new WritableImage(201, 301);
    PixelWriter pw = i.getPixelWriter();
    GraphicUtil.drawLine(new Point2D(0, 0), new Point2D(200, 200), Color.AQUA, pw);
    ImageView a = new ImageView(i);
    return a;
  }

  static ImageView circle() {
    WritableImage i = new WritableImage(301, 301);
    PixelWriter pw = i.getPixelWriter();
    GraphicUtil.drawCircle(new Point2D(150, 150), 150, Color.AQUA, pw);
    ImageView a = new ImageView(i);
    return a;
  }
}
