package com.example.jfinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    double x,y = 0;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("usuario-view.fxml")));
        Scene homeScene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        //move around
        root.setOnMousePressed(evt ->{
            x = evt.getSceneX();
            y = evt.getSceneY();
        });
        root.setOnMouseDragged(evt ->{
            stage.setX(evt.getScreenX()- x);
            stage.setY(evt.getScreenY()- y);
        });


        stage.setScene(homeScene);
        stage.show();


        stage.setScene(homeScene);
        stage.show();
        /*FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("usuario-view.fxml"));
        Scene homeScene = new Scene(fxmlLoader.load(), 802, 497);
        stage.setScene(homeScene);
        stage.show();*/

    }

    public static void main(String[] args) {
        launch();
    }
}