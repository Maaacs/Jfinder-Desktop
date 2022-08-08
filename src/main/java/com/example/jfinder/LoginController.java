package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController{


    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField idAcessoTextField;
    @FXML
    private JFXButton entrar;
    @FXML
    private JFXButton sair;
    @FXML
    private Label loginMessageLabel;

    public String texto;

    public void sairOnAction(ActionEvent event){
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.close();
    }

    /*public void entrarOnAction(ActionEvent event){
        Main.changeScreen("usuario-view");
    }*/

    public void entrarOnAction(ActionEvent event){
        if(idAcessoTextField.getText().isBlank() == false){
            int id = Integer.parseInt(idAcessoTextField.getText());
            if(id == 123){//id cadastrado
                Main.changeScreen("usuario-view");
            } else{
                loginMessageLabel.setText("ID de acesso incorreto!");
            }
        } else{
            loginMessageLabel.setText("Insira o ID");
        }
    }

    public void RelatoriosOnAction(ActionEvent event) {
        Main.changeScreen("relatorio-view");
    }
}
