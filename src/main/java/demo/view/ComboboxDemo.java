package demo.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboboxDemo extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final HBox hBox = new HBox();
        final ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("Hà Nội");
        comboBox.getItems().add("Hồ Chí Minh");
        comboBox.getItems().add("Huế");
        Button btnSubmit = new Button("Save");

        hBox.getChildren().addAll(comboBox, btnSubmit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(comboBox.getSelectionModel().getSelectedItem());
            }
        });

        Scene scene = new Scene(hBox, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
