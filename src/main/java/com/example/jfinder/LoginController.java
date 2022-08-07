package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController{


    @FXML
    private TextField usuarioLogin;
    @FXML
    private PasswordField senhaLogin;
    @FXML
    private JFXButton entrar;
    @FXML
    private JFXButton sair;

    public void sairOnAction(ActionEvent event){
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.close();
    }

    public void entrarOnAction(ActionEvent event){
        Main.changeScreen("usuario-view");
    }

    /*public void senhaLoginOnAction(ActionEvent event) {
        Main.changeScreen("documento-view");
    }

    public void RelatoriosOnAction(ActionEvent event) {
        Main.changeScreen("relatorio-view");
    }*/
}
