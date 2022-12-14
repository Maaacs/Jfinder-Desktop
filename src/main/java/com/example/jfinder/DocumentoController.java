package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DocumentoController {
    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private Button documentoCadastrar;
    @FXML
    private Button documentoAlterar;
    @FXML
    private Button documentoRemover;
    @FXML
    private Button documentoBuscar;

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

    public void documentoCadastrarOnAction(ActionEvent event){
        Main.changeScreen("cadastrarDocumento-view");
    }

    public void documentoAlterarOnAction(ActionEvent event){
        Main.changeScreen("alterarDocumento-view");
    }

    public void documentoBuscarOnAction(ActionEvent event){
        Main.changeScreen("buscarDocumento-view");
    }

    public void documentoRemoverOnAction(ActionEvent event){
        Main.changeScreen("removerDocumento-view");
    }
}
