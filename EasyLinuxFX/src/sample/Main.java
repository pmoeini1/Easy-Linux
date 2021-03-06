package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    // show window and add icon image
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Command Line GUI");
        primaryStage.setScene(new Scene(root, 450, 400));
        primaryStage.show();
        primaryStage.getIcons().add(new Image("/sample/codepic.jpg"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
