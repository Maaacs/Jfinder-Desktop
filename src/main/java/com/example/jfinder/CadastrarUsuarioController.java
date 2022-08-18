package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigInteger;


public class CadastrarUsuarioController {
    @FXML private TextField nomeUsuarioTextField;
    @FXML private TextField sobrenomeUsuarioTextField;
    @FXML private TextField cpfUsuarioTextField;
    @FXML private TextField cargoUsuarioTextField;
    @FXML private Label cadastroMessageLabel;
    @FXML private Label cadastroUsuarioMessageLabel;
    @FXML private Button voltarCadastroUsuario;
    @FXML private Button cadastrarUsuario;



    public static boolean isInt(String input) {
        try {
            for(int i = 0;i<input.length();i++){
                if( !Character.isDigit( input.charAt(i) ) ){
                    System.out.println(i + " ruim"); // inteiro + string
                    return false;
                }
            }
            System.out.println("é um inteiro");
            return true;
        } catch (Exception e) {
            System.out.println("é uma string");
            return false;
        }
    }
    @FXML
    private void cadastrarUsuarioOnAction(ActionEvent event) {
        BancodeDados bd = new BancodeDados();
        try {

            if(nomeUsuarioTextField.getText().isBlank() == false && sobrenomeUsuarioTextField.getText().isBlank() == false && cpfUsuarioTextField.getText().isBlank() == false && cargoUsuarioTextField.getText().isBlank() == false) {//campo nao for vazio
                String nome = nomeUsuarioTextField.getText();
                String sobrenome = sobrenomeUsuarioTextField.getText();
                String cpf = cpfUsuarioTextField.getText();
                String cargo = cargoUsuarioTextField.getText();
                Usuario usuario = new Usuario(nome, sobrenome, cpf, cargo);

                if (isInt(cpf) && bd.adicionarUsuario(usuario)){
                    System.out.println("Novo usuário cadastrado com sucesso!");//apenas terminal
                    cadastroMessageLabel.setText("");
                    nomeUsuarioTextField.setText("");
                    sobrenomeUsuarioTextField.setText("");
                    cpfUsuarioTextField.setText("");
                    cargoUsuarioTextField.setText("");
                    cadastroUsuarioMessageLabel.setText("Cadastro realizado com sucesso!");
                }else {
                    System.out.println("Usuário não cadastrado!");
                    cadastroUsuarioMessageLabel.setText("");
                    cadastroMessageLabel.setText("Dados incorretos ou CPF já existe!");
                }

            }else{
                cadastroMessageLabel.setText("Insira os dados!");
            }

        }catch (Exception e){
            System.out.println(e);
            cadastroMessageLabel.setText("Dados incorretos!");
        }
    }

    public void voltarOnAction(ActionEvent event){
        cadastroMessageLabel.setText("");
        cadastroUsuarioMessageLabel.setText("");
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
