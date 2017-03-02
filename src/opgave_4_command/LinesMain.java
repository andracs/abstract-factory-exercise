/*
* Command Pattern
* Lav et simpelt tegneprogram, hvor man kan tegne en figur vha. streger. 
* Lav programmet, så man kan fortryde et vilkårligt antal streger.
*
* Insoired by http://www.java2s.com/Code/Java/JavaFX/FreehanddrawwithPath.htm 
 */
package opgave_4_command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;


/*from   w w w . ja  v a  2 s . co  m*/
public class LinesMain extends Application {

    Path path;
    Line line;
    Button button;
    protected Scene scene;
    private Group root;

    @Override
    public void start(Stage stage) {
        root = new Group();
        scene = new Scene(root, 300, 250);
        scene.setFill(null);

        line = new Line();
        root.getChildren().add(line);

        button = new Button();
        button.setText("Undo");
        button.setAlignment(Pos.CENTER);
        button.setOnMouseReleased(undoMouseHandler);
        root.getChildren().add(button);

        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMousePressed(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);

        stage.setScene(scene);
        stage.show();
    }

    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                line = new Line();
                line.setVisible(false);
                line.setStartX(mouseEvent.getX());
                line.setStartY(mouseEvent.getY());
                root.getChildren().add(line);

                //Paint p = new Paint();
//                Circle x = new Circle(mouseEvent.getX(), mouseEvent.getY(), 12);
//                root.getChildren().add(x);
                // DEBUG 
//                System.out.println(x);
            }
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                line.setVisible(true);
                line.setEndX(mouseEvent.getX());
                line.setEndY(mouseEvent.getY());
                // DEBUG System.out.println(line);
            }
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                line.setEndX(mouseEvent.getX());
                line.setEndY(mouseEvent.getY());
                line.setVisible(true);
//                              Circle x = new Circle(mouseEvent.getX(), mouseEvent.getY(), 12);
                //              root.getChildren().add(x);
                // DEBUG System.out.println(line);
            }

        }

    };

    EventHandler<MouseEvent> undoMouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {

                // DEBUG 
                System.out.println("Undo event");
                int last = root.getChildren().size();
                System.out.println(last);
                if (last > 2) {
                    root.getChildren().remove(last - 1);
                }

            }

        }

    };

    public static void main(String[] args) {
        launch(args);
    }
}
