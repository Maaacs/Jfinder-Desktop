package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController{


    @FXML private Label loginMessageLabel;
    @FXML private TextField usuarioTextField;
    @FXML private PasswordField senhaTextField;
    @FXML private Button sair;
    @FXML private Button entrar;



    public boolean verificarLogin() {
        BancodeDados bd = new BancodeDados(usuarioTextField.getText(), senhaTextField.getText());
        bd.conecta();
        if(bd.conecta()) {
            return true;
        }else {
            return false;
        }
    }

    public void entrarOnAction(ActionEvent event){
        if(usuarioTextField.getText().isBlank() == false && senhaTextField.getText().isBlank() == false){
            if(verificarLogin()){
                Main.changeScreen("usuario-view");
                usuarioTextField.setText("");
                senhaTextField.setText("");
                loginMessageLabel.setText("");
                System.out.println("Estou no servidor :)");
            } else{
                System.out.println("Não obtive permissão para me conectar ao servidor :(");
                loginMessageLabel.setText("Usuário ou senha incorreto!");
            }
        } else{
            System.out.println("Não obtive permissão para me conectar ao servidor :(");
            loginMessageLabel.setText("Insira os dados!");
        }
    }

    public void sairOnAction(ActionEvent event){
        BancodeDados bd = new BancodeDados();
        bd.desconecta();
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.close();
    }

}
