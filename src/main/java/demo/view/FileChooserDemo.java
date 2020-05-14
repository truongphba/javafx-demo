package demo.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        final Label fileName = new Label();
        final Label filePath = new Label();
        fileName.setVisible(false);
        filePath.setVisible(false);
        HBox hBox = new HBox();
        Button btnSubmit = new Button("Choose file");
        Button btnSave = new Button("Save");
        Button btnSaveAs = new Button("Save as");
        TextArea textAreaContent = new TextArea();
        hBox.getChildren().addAll(btnSubmit, btnSave, btnSaveAs);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        vBox.getChildren().addAll(fileName, filePath, textAreaContent, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);


        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(primaryStage);
                String fileChooserName = file.getAbsolutePath();
                filePath.setText(fileChooserName);
                fileName.setText(file.getName());
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
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FileWriter fileWriter = new FileWriter(filePath.getText());
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(textAreaContent.getText());
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSaveAs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setInitialFileName(fileName.getText());
                    File file = fileChooser.showSaveDialog(primaryStage);
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(textAreaContent.getText());
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.getMessage();
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
