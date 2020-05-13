package demo.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class RadioButtonDemo extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final HBox hBox = new HBox();
        final RadioButton radioButtonFemale = new RadioButton("Female");
        final RadioButton radioButtonMale = new RadioButton("Male");
        final RadioButton radioButtonOther = new RadioButton("Other");
        radioButtonMale.fire();
        Button btnSubmit = new Button("Save");

        final ToggleGroup radioGender = new ToggleGroup();
        radioButtonFemale.setToggleGroup(radioGender);
        radioButtonMale.setToggleGroup(radioGender);
        radioButtonOther.setToggleGroup(radioGender);

        hBox.getChildren().addAll(radioButtonMale, radioButtonFemale, radioButtonOther, btnSubmit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                if (radioButtonFemale.isSelected()) {
//                    System.out.println("Female");
//                } else if (radioButtonMale.isSelected()){
//                    System.out.println("Male");
//                }else if(radioButtonOther.isSelected()){
//                    System.out.println("Other");
//                }
                RadioButton selectedGender = (RadioButton) radioGender.getSelectedToggle();
                System.out.println(selectedGender.getText());
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
