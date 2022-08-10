package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    @FXML
    private JFXButton cadastrarUsuario;
    @FXML
    private TextField nomeUsuarioTextField;
    @FXML
    private TextField sobrenomeUsuarioTextField;
    @FXML
    private TextField cpfUsuarioTextField;
    @FXML
    private TextField cargoUsuarioTextField;
    @FXML
    private Label cadastroMessageLabel;
    @FXML
    private Label cadastroUsuarioMessageLabel;

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


    @FXML
    private void cadastrarUsuarioOnAction(ActionEvent event) {
        BancodeDados bd = new BancodeDados();
        //bd.conecta();
        try {
            //Usuario usuario = new Usuario(" ", "", "", "");
            String nome = nomeUsuarioTextField.getText();
            String sobrenome = sobrenomeUsuarioTextField.getText();
            String cpf = cpfUsuarioTextField.getText();
            String cargo = cargoUsuarioTextField.getText();

            Usuario usuario = new Usuario(nome, sobrenome, cpf, cargo);
            System.out.println(usuario.getPrimeiroNome());
            System.out.println("1");

            //bd.adicionarUsuario(usuario);
            System.out.println("2");

            if (bd.adicionarUsuario(usuario)){
                System.out.println("Novo usuário cadastrado com sucesso!");
                cadastroUsuarioMessageLabel.setText("Cadastro realizado com sucesso!");
            }else {
                System.out.println("Usuário não cadastrado!");
                cadastroMessageLabel.setText("Insira os dados!");
            }
        }catch (NumberFormatException e){
            cadastroMessageLabel.setText("");
            cadastroMessageLabel.setText("Entrada Inválida!");
        }
    }
}
