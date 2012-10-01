package javafx2introbyexample.chapter4.recipe4_02;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

 
/**
 *
 * @author cdea
 */
public class DisplayHtml5Content extends Application {
    private Scene scene;
    @Override public void start(Stage stage) {
        // create the scene
        stage.setTitle("Chapter 4-2 Display Html5 Content");
        final WebView browser = new WebView();

        String svgFileAsString = new Scanner(DisplayHtml5Content.class.getResourceAsStream("clock3.svg")).useDelimiter("\\Z").next();
        //URL url = DisplayHtml5Content.class.getResourceAsStream("clock3.svg");
        //browser.getEngine().load(url.toExternalForm());
        browser.getEngine().loadContent(svgFileAsString);
        scene = new Scene(browser,320,250, Color.rgb(0, 0, 0, .80));
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        Application.launch(args);
    }
}
