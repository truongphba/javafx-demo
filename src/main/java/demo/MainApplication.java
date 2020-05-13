package demo;

import demo.entity.Game;
import demo.model.InDatabaseGameModel;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainApplication extends Application {

    public void start(Stage primaryStage) throws Exception {
        // stage -> scene -> group -> items (nodes: button, textfield)
        final InDatabaseGameModel model = new InDatabaseGameModel();
        Group group = new Group(); // hold child items
        // define nodes
        Label lblCode = new Label("Code");
        lblCode.setLayoutX(150);
        lblCode.setLayoutY(50);
        final TextField txtCode = new TextField();
        txtCode.setLayoutX(220);
        txtCode.setLayoutY(50);

        Label lblName = new Label("Name");
        lblName.setLayoutX(150);
        lblName.setLayoutY(100);
        final TextField txtName = new TextField();
        txtName.setLayoutX(220);
        txtName.setLayoutY(100);

        Label lblPrice = new Label("Price");
        lblPrice.setLayoutX(150);
        lblPrice.setLayoutY(150);
        final TextField txtPrice = new TextField();
        txtPrice.setLayoutX(220);
        txtPrice.setLayoutY(150);

        Button btnSave = new Button("Save");
        btnSave.setLayoutX(220);
        btnSave.setLayoutY(200);
        Button btnReset = new Button("Reset");
        btnReset.setLayoutX(290);
        btnReset.setLayoutY(200);

        btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Do save");
                String code = txtCode.getText();
                String name = txtName.getText();
                String price = txtPrice.getText();
                System.out.println("Code: " + code);
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                Game game = new Game();
                game.setCode(code);
                game.setName(name);
                game.setPrice(Double.valueOf(price));
                game.setPublicBy("Unknown");
                game.setPublicDate("2000-10-21");
                model.save(game);
                System.out.println("Do reset");
                txtCode.clear();
                txtName.clear();
                txtPrice.clear();
            }
        });
        btnReset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Do reset");
                txtCode.clear();
                txtName.clear();
                txtPrice.clear();
            }
        });

        // add nodes to group
        group.getChildren().addAll(lblCode, txtCode, lblName, txtName, lblPrice, txtPrice, btnSave, btnReset);
        // add group to scene
        Scene scene = new Scene(group, 600, 350);
        // add scene to stage.
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello Javafx");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
