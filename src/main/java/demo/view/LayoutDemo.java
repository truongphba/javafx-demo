package demo.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class LayoutDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Hbox, Vbox, GridPane.
        GridPane group = new GridPane(); // bootstrap
        group.setAlignment(Pos.CENTER);
        group.setPadding(new Insets(20));
        group.setVgap(20);
        group.setHgap(30);

        Label lblUsername = new Label("Username");
        Label lblPassword = new Label("Password");
        final Label lblUsernameMsg = new Label();
        final Label lblPasswordMsg = new Label();
        lblUsernameMsg.setTextFill(Paint.valueOf("red"));
        lblPasswordMsg.setTextFill(Paint.valueOf("red"));
        final TextField txtUsername = new TextField();
        final PasswordField txtPassword = new PasswordField();
        Button btnSave = new Button("Save");
        Button btnReset = new Button("Reset");
        group.add(lblUsername, 0, 0);
        group.add(txtUsername, 1, 0);
        group.add(lblUsernameMsg, 2, 0);
        group.add(lblPassword, 0, 1);
        group.add(txtPassword, 1, 1);
        group.add(lblPasswordMsg, 2, 1);
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(btnSave, btnReset);
        group.add(hBox, 1, 2);

        btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                if (username == null || username.length() == 0) {
                    lblUsernameMsg.setText("* Username's required!");
                } else {
                    lblUsernameMsg.setText("");
                }
                if (password == null || password.length() == 0) {
                    lblPasswordMsg.setText("* Password's required!");
                } else {
                    lblPasswordMsg.setText("");
                }
            }
        });

        Scene scene = new Scene(group, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
