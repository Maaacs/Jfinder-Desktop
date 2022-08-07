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
    private static Stage stage;
    private static Scene loginScene;
    private static Scene usuarioScene;

    private static Scene documentoScene;

    private static Scene relatorioScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;


        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        loginScene = new Scene(fxmlLogin, 800, 500);

        Parent fxmlUsuario = FXMLLoader.load(getClass().getResource("usuario-view.fxml"));
        usuarioScene = new Scene(fxmlUsuario, 800, 500);

        Parent fxmlDocumento = FXMLLoader.load(getClass().getResource("documento-view.fxml"));
        documentoScene = new Scene(fxmlDocumento, 800, 500);

        Parent fxmlRelatorio = FXMLLoader.load(getClass().getResource("relatorio-view.fxml"));
        relatorioScene = new Scene(fxmlRelatorio, 800, 500);


        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
    public static void changeScreen(String scr) {
        switch(scr) {
            case "login-view":
                stage.setScene(loginScene);
                break;
            case "usuario-view":
                stage.setScene(usuarioScene);
                break;
            case "documento-view":
                stage.setScene(documentoScene);
                break;
            case "relatorio-view":
                stage.setScene(relatorioScene);
                break;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}