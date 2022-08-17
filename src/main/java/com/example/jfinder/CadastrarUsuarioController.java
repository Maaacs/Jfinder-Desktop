package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class CadastrarUsuarioController {
    @FXML private TextField nomeUsuarioTextField;
    @FXML private TextField sobrenomeUsuarioTextField;
    @FXML private TextField cpfUsuarioTextField;
    @FXML private TextField cargoUsuarioTextField;
    @FXML private Label cadastroMessageLabel;
    @FXML private Label cadastroUsuarioMessageLabel;



    @FXML
    private void cadastrarUsuarioOnAction(ActionEvent event) {
        BancodeDados bd = new BancodeDados();
        try {

            if(nomeUsuarioTextField.getText().isBlank() == false && sobrenomeUsuarioTextField.getText().isBlank() == false && cpfUsuarioTextField.getText().isBlank() == false && cargoUsuarioTextField.getText().isBlank() == false) {//campo nao for vazio
                String nome = nomeUsuarioTextField.getText();
                String sobrenome = sobrenomeUsuarioTextField.getText();
                int cpf = Integer.parseInt(cpfUsuarioTextField.getText());
                String cargo = cargoUsuarioTextField.getText();

                Usuario usuario = new Usuario(nome, sobrenome, cpf, cargo);

                if (bd.adicionarUsuario(usuario)){
                    System.out.println("Novo usuário cadastrado com sucesso!");//apenas terminal
                    cadastroMessageLabel.setText("");
                    nomeUsuarioTextField.setText("");
                    sobrenomeUsuarioTextField.setText("");
                    cpfUsuarioTextField.setText("");
                    cargoUsuarioTextField.setText("");
                    cadastroUsuarioMessageLabel.setText("Cadastro realizado com sucesso!");
                }else {
                    System.out.println("Usuário não cadastrado!");
                    cadastroMessageLabel.setText("Este CPF já está cadastrado!");
                }

            }else{
                cadastroMessageLabel.setText("Insira os dados!");
            }

        }catch (NumberFormatException e){
            cadastroMessageLabel.setText("Dados incorretos!");
        }
    }

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
