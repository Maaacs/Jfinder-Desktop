package com.example.jfinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //private static Scene homeScene;
    @Override
    public void start(Stage stage) throws IOException {
        //Parent fxmlHome = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home-view.fxml"));
        Scene homeScene = new Scene(fxmlLoader.load(), 802, 497);

        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(homeScene);
        stage.show();

        /*FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }
}