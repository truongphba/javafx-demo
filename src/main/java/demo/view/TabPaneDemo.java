package demo.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabPane = new TabPane(); // group
        Tab tab1 = new Tab("Student.java");
        Tab tab2 = new Tab("Main.java");
        Tab tab3 = new Tab("StudentModel.java");
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        Scene scene = new Scene(tabPane, 600, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
