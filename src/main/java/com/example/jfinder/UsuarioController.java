package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsuarioController{

        @FXML
        private Button Usuarios;
        @FXML
        private Button Documentos;
        @FXML
        private Button Relatorios;
        @FXML
        private TextField Nome;
        @FXML
        private TextField Sobrenome;
        @FXML
        private TextField Cpf;
        @FXML
        private Button Confirmar;
        @FXML
        private Button Cancelar;
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
