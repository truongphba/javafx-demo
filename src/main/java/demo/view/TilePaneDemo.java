package demo.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class TilePaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane group = new TilePane(); // bootstrap
        group.setAlignment(Pos.CENTER);
        group.setPadding(new Insets(20));
        group.setVgap(20);
        group.setHgap(30);
        Button btnButton01 = new Button("Button 01");
        Button btnButton02 = new Button("Button 02");
        Button btnButton03 = new Button("Button 03");
        Button btnButton04 = new Button("Button 04");
        Button btnButton05 = new Button("Button 05");
        Button btnButton06 = new Button("Button 06");
        Button btnButton07 = new Button("Button 07");
        group.getChildren().addAll(btnButton01, btnButton02, btnButton03, btnButton04, btnButton05, btnButton06, btnButton07);

        Scene scene = new Scene(group, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
