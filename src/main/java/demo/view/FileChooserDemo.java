package demo.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.Charset;

public class FileChooserDemo extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final VBox vBox = new VBox();
        final FileChooser fileChooser = new FileChooser();
        Button btnSubmit = new Button("Choose file");
        TextArea textAreaContent = new TextArea();
        vBox.getChildren().addAll(textAreaContent, btnSubmit);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);


        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(primaryStage);
                try {
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(file), "UTF-8"));
                    String content = null;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((content = bufferedReader.readLine()) != null) {
                        stringBuilder.append(content);
                    }
                    textAreaContent.setText(stringBuilder.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(vBox, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
