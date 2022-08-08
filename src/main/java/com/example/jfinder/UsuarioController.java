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
        @FXML
        private Button usuarioAdicionar;
        @FXML
        private Button usuarioBuscar;
        @FXML
        private Button usuarioRemover;
        @FXML
        private Button usuarioAlterar;

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

        public void usuarioAdicionarOnAction(ActionEvent event){
                Main.changeScreen("cadastrarUsuario-view");
        }

        public void usuarioBuscarOnAction(ActionEvent event){
                Main.changeScreen("buscarUsuario-view");
        }

        public void usuarioRemoverOnAction(ActionEvent event){
                Main.changeScreen("removerUsuario-view");
        }
        public void usuarioAlterarOnAction(ActionEvent event){
                Main.changeScreen("alterarUsuario-view");
        }

}
