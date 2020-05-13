package demo.view;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplitPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.2f, 0.8f);

        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        Label lblPane01 = new Label("Pane01");
        vBox1.getChildren().add(lblPane01);
        Label lblPane02 = new Label("Pane02");
        vBox2.getChildren().add(lblPane02);

        splitPane.getItems().addAll(vBox1, vBox2);

        Scene scene = new Scene(splitPane, 600, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
