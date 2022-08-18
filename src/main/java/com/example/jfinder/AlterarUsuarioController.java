package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlterarUsuarioController {
    @FXML
    private TextField nomeAlterarUsuario;
    @FXML
    private TextField sobrenomeAlterarUsuario;
    @FXML
    private TextField cargoAlterarUsuario;
    @FXML private TextField cpfTextField;
    @FXML private Label resultadoMessageLabel;
    @FXML private Label alterarLabelMessage;
    @FXML
    private Button voltarAlteracaoUsuario;
    @FXML
    private Button buscarUsuario;
    @FXML
    private Button confirmarAlteracaoUsuario;


    @FXML
    private void buscarOnAction(ActionEvent event) {
        nomeAlterarUsuario.setText("");
        sobrenomeAlterarUsuario.setText("");
        cargoAlterarUsuario.setText("");

        try{

            if(cpfTextField.getText().isBlank() == false){

                Usuario tabelaCpf = new Usuario();
                Usuario usr = new Usuario();
                String cpf = cpfTextField.getText();
                usr = usr.buscarCPF(cpf);

                if (usr == null){
                    System.out.println("Nao encontrado");
                    alterarLabelMessage.setText("");
                    resultadoMessageLabel.setText("Usuário não encontrado!");

                }else{
                    alterarLabelMessage.setText("");
                    resultadoMessageLabel.setText("");
                    tabelaCpf = usr.buscarCPF(cpf);
                    nomeAlterarUsuario.setText(tabelaCpf.getPrimeiroNome());
                    sobrenomeAlterarUsuario.setText(tabelaCpf.getUltimoNome());
                    cargoAlterarUsuario.setText(tabelaCpf.getCargo());

                }
            }
            else{
                alterarLabelMessage.setText("");
                resultadoMessageLabel.setText("Insira o CPF!");
            }

        }catch (NumberFormatException e){
            alterarLabelMessage.setText("");
            resultadoMessageLabel.setText("Insira os dados corretamente!");
        }

    }

    @FXML private void alteracaoOnAction(ActionEvent event) {
        if(nomeAlterarUsuario.getText().isBlank() == false && sobrenomeAlterarUsuario.getText().isBlank() == false && cpfTextField.getText().isBlank() == false && cargoAlterarUsuario.getText().isBlank() == false){
            atualiza();
        }else{
            resultadoMessageLabel.setText("Insira o CPF!");
        }

    }

    public void atualiza(){
        BancodeDados dao = new BancodeDados();
        String cpf = cpfTextField.getText();
        String nome = nomeAlterarUsuario.getText();
        String sobrenome = sobrenomeAlterarUsuario.getText();
        String cargo = cargoAlterarUsuario.getText();

        Usuario p = new Usuario(nome, sobrenome, cpf, cargo);

        if (dao.alterarUsuario(p)){
            System.out.println("Usuário atualizado!");// apenas para terminal
            resultadoMessageLabel.setText("");
            alterarLabelMessage.setText("Usuário alterado com sucesso!");
        }else{
            System.out.println("Alteração não realizada!");
        }
    }



    public void voltarOnAction(ActionEvent event){
        cpfTextField.setText("");
        nomeAlterarUsuario.setText("");
        sobrenomeAlterarUsuario.setText("");
        cargoAlterarUsuario.setText("");
        alterarLabelMessage.setText("");
        resultadoMessageLabel.setText("");
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


















   /* @FXML
    private void alteracaoOnAction(ActionEvent event) { // apenas adiciona um novo

        BancodeDados bd = new BancodeDados();
        //bd.conecta();
        try {
            String nome = nomeAlterarUsuario.getText();
            String sobrenome = sobrenomeAlterarUsuario.getText();
            String cpf = cpfTextField.getText();
            String cargo = cargoAlterarUsuario.getText();

            Usuario usuario = new Usuario(nome, sobrenome, cpf , cargo);
            System.out.println("1");

            if (bd.adicionarUsuario(usuario)){
                System.out.println("Alteração realizada com sucesso!");
                confrmaAlteracaoMessageLabel.setText("Alteração realizada com sucesso!");
            }else {
                System.out.println("Alteração não cadastrado!");
                //cadastroMessageLabel.setText("Insira os dados!");
            }
        }catch (NumberFormatException e){
            //cadastroMessageLabel.setText("");
            confirmarAlteracaoUsuario.setText("Entrada Inválida!");
        }
    }*/
