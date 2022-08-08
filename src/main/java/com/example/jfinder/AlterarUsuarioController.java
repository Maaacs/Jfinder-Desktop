package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AlterarUsuarioController {
    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private TextField cpfAlterarUsuario;
    @FXML
    private JFXButton okAlterarUsuario;
    @FXML
    private TextField nomeAlterarUsuario;
    @FXML
    private TextField sobrenomeAlterarUsuario;
    @FXML
    private TextField cargoAlterarUsuario;
    @FXML
    private JFXButton confirmarAlteracaoUsuario;
    @FXML
    private JFXButton voltarAlteracaoUsuario;


    public void voltarOnAction(ActionEvent event){
        Main.changeScreen("usuario-view");
    }

    public void encerrarSessaoOnAction(ActionEvent event){
        Main.changeScreen("login-view");
    }
    public void UsuariosOnAction(ActionEvent event) {
        Main.changeScreen("usuario-view");
    }

    public void DocumentosOnAction(ActionEvent event) {
        Main.changeScreen("documento-view");
    }

    public void RelatoriosOnAction(ActionEvent event) {
        Main.changeScreen("relatorio-view");
    }
}
