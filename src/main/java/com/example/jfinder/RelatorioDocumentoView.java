package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RelatorioDocumentoView {
    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private JFXButton voltarRelatorioDocumento;

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

    public void voltarOnAction(ActionEvent event){
        Main.changeScreen("relatorio-view");
    }
}
