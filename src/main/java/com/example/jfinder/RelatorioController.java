package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RelatorioController {


    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private Button relatorioDocumento;
    @FXML
    private Button relatorioUsuarios;

    public void encerrarSessaoOnAction(ActionEvent event){
        Main.changeScreen("login-view");
    }

    public void DocumentosOnAction(ActionEvent event) {
        Main.changeScreen("documento-view");
    }

    public void UsuariosOnAction(ActionEvent event) {
        Main.changeScreen("usuario-view");
    }

    public void RelatoriosOnAction(ActionEvent event) {
        Main.changeScreen("relatorio-view");
    }

    public void relatorioUsuarioOnAction(ActionEvent event) {
        Main.changeScreen("relatorioUsuario-view");
    }

    public void relatorioDocumentoOnAction(ActionEvent event) {
        Main.changeScreen("relatorioDocumento-view");
    }


}
