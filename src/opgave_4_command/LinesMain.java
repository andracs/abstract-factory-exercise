/* 
* Lav et simpelt tegneprogram, hvor man kan tegne en figur vha. streger. 
* Lav programmet, så man kan fortryde et vilkårligt antal streger.
*
* Insoired by http://www.java2s.com/Code/Java/JavaFX/FreehanddrawwithPath.htm 
* 
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
import javafx.scene.control.TextField;
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
    TextField undoTextField;

    @Override
    public void start(Stage stage) {
        // Setting the scene
        root = new Group();
        scene = new Scene(root, 300, 250);
        scene.setFill(null);        
        stage.setScene(scene);
        stage.show();
        
        // Adding event handlers for drawing
        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMousePressed(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);
        
        // Rigging a textfield for text input
        undoTextField = new TextField();
        undoTextField.setPrefColumnCount(3);
        undoTextField.setText("1");
        root.getChildren().add(undoTextField);

        // Adding a button to the scene
        button = new Button();
        button.setText("Undo");
        button.setLayoutX(250);
        button.setOnMouseReleased(undoMouseHandler);
        root.getChildren().add(button);
         
    }

    /* Event handler for drawing */
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            // Drawing a line on key press
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                line = new Line();
                line.setStartX(mouseEvent.getX());
                line.setStartY(mouseEvent.getY());
                line.setVisible(false);
                root.getChildren().add(line);

                // Paint p = new Paint();
                // Circle x = new Circle(mouseEvent.getX(), mouseEvent.getY(), 12);
                // root.getChildren().add(x);
                // DEBUG 
                // System.out.println(x);
            }
            // Visualising the line while dragging
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                line.setVisible(true);
                line.setEndX(mouseEvent.getX());
                line.setEndY(mouseEvent.getY());
                // DEBUG System.out.println(line);
            }
            // Finalizing the line when mouse released.
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                line.setEndX(mouseEvent.getX());
                line.setEndY(mouseEvent.getY());
                line.setVisible(true);
                // Circle x = new Circle(mouseEvent.getX(), mouseEvent.getY(), 12);
                // root.getChildren().add(x);
                // DEBUG System.out.println(line);
            }

        }

    };
    
    /* Event handler for undo */
    EventHandler<MouseEvent> undoMouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            // Undoing the lastItem drawn line(s) on click
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                int lastItem = root.getChildren().size();
                int remainingItems = lastItem - Integer.parseInt(undoTextField.getText());
                
                // The first 2 items, textbox and button should not be removed
                if (remainingItems >= 2) {
                    System.out.println("Items removed from " + lastItem + " to " +remainingItems);
                    root.getChildren().remove(remainingItems, lastItem);
                }

            }

        }

    };

    public static void main(String[] args) {
        launch(args);
    }
}
