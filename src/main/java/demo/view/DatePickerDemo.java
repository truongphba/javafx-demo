package demo.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DatePickerDemo extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final HBox hBox = new HBox();
        final DatePicker datePicker = new DatePicker();
        Button btnSubmit = new Button("Save");

        hBox.getChildren().addAll(datePicker, btnSubmit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate localDate = datePicker.getValue();
                System.out.println(localDate.toString());
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
