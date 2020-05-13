package demo.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ColorPickerDemo extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final HBox hBox = new HBox();
        final ColorPicker picker = new ColorPicker();
        final Label labelText = new Label("Hello World");
        labelText.setFont(Font.font(30));
        Button btnSubmit = new Button("Save");

        hBox.getChildren().addAll(labelText, picker, btnSubmit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        picker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Color color = picker.getValue();
                labelText.setTextFill(color);
                System.out.println(color);
            }
        });
//        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Color color = picker.getValue();
//                labelText.setTextFill(color);
//                System.out.println(color);
//            }
//        });

        Scene scene = new Scene(hBox, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
