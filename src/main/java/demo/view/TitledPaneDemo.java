package demo.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitledPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBoxTitle01 = new VBox();
        Label lblTitle01 = new Label("Content of title 01");
        Button btnTitle01 = new Button("Button 01");
        vBoxTitle01.getChildren().addAll(lblTitle01, btnTitle01);
        TitledPane titledPane = new TitledPane("Title 01", vBoxTitle01);
        titledPane.setExpanded(false);
        Label lblTitle02 = new Label("Content of title 02");
        TitledPane titledPane02 = new TitledPane("Title 02", lblTitle02);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(titledPane, titledPane02);
        Scene scene = new Scene(vBox, 600, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
