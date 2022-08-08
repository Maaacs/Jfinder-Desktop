package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastrarUsuarioController {
    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private JFXButton confirmarCadastroUsuario;
    @FXML
    private JFXButton voltarCadastroUsuario;
    @FXML
    private TextField nomeCadastroUsuario;
    @FXML
    private TextField sobrenomeCadastroUsuario;
    @FXML
    private TextField cpfCadastroUsuario;
    @FXML
    private TextField cargoCadastroUsuario;

    public void voltarOnAction(ActionEvent event){
        Main.changeScreen("usuario-view");
    }
    /*public void confirmarOnAction(ActionEvent event){
        Main.changeScreen("login-view");
    }*/
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
