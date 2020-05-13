package demo.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CheckboxDemo extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final HBox hBox = new HBox();
        final CheckBox checkBox1 = new CheckBox("Sport");
        final CheckBox checkBox2 = new CheckBox("Gaming");
        final CheckBox checkBox3 = new CheckBox("Music");
        final CheckBox checkBox4 = new CheckBox("Book");
        Button btnSubmit = new Button("Save");

        hBox.getChildren().addAll(checkBox1, checkBox2, checkBox3, checkBox4, btnSubmit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkBox1.isSelected()) {
                    System.out.println("Sport");
                }
                if (checkBox2.isSelected()) {
                    System.out.println("Gaming");
                }
                if (checkBox3.isSelected()) {
                    System.out.println("Music");
                }
                if (checkBox4.isSelected()) {
                    System.out.println("Book");
                }
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
