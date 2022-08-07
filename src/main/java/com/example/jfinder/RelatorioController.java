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

    public void encerrarSessaoOnAction(ActionEvent event){
        Stage stage = (Stage) encerrarSessao.getScene().getWindow();
        stage.close();
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
}
