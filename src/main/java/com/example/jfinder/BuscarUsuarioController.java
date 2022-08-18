package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;




public class BuscarUsuarioController{
    @FXML private TextField cpfBuscarMessageLabel;
    @FXML private Label resultadoMessageLabel;
    @FXML private Label resultado3MessageLabel;
    @FXML private Label resultado4MessageLabel;
    @FXML private Label resultado5MessageLabel;
    @FXML private Label resultado6MessageLabel;
    @FXML
    private Button buscarUsuarioButtoOnAction;
    @FXML
    private Button voltarBuscarUsuario;

    @FXML
    private void buscarOnAction() {
        Usuario bancoPorCPF = new Usuario();
        Usuario usr = new Usuario();

        try{
            if(cpfBuscarMessageLabel.getText().isBlank() == false){//campo nao for vazio
                String cpf = cpfBuscarMessageLabel.getText();
                usr = usr.buscarCPF(cpf);

                if (usr == null){ //usuario nao encontrado
                    System.out.println("Nao encontrado");
                    resultado6MessageLabel.setText("Usuario não encontrado!");
                    resultadoMessageLabel.setText("");
                    resultado3MessageLabel.setText("");
                    resultado4MessageLabel.setText("");
                    resultado5MessageLabel.setText("");
                }
                else{
                    resultado6MessageLabel.setText("");
                    bancoPorCPF = usr.buscarCPF(cpf);
                    resultadoMessageLabel.setText(bancoPorCPF.getPrimeiroNome());
                    resultado3MessageLabel.setText(bancoPorCPF.getUltimoNome());
                    resultado4MessageLabel.setText(bancoPorCPF.getCPF());
                    resultado5MessageLabel.setText(bancoPorCPF.getCargo());
                }

            }
            else{ // campo vazio solicita para preencher com o CPF
                resultado6MessageLabel.setText("Insira o CPF!");
            }

        }catch (NumberFormatException e){ // Caso insira outro tipo que nao seja INT CPF
            resultado6MessageLabel.setText("CPF incorreto!");
        }
    }


    public void voltarBuscarOnAction(ActionEvent event){
        resultadoMessageLabel.setText("");
        resultado3MessageLabel.setText("");
        resultado4MessageLabel.setText("");
        resultado5MessageLabel.setText("");
        cpfBuscarMessageLabel.setText("");
        resultado6MessageLabel.setText("");
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
    private void buscaAvancadaOnaction(MouseEvent mouseEvent) {
        Main.changeScreen("relatorioUsuario-view");
    }
}















    /*public void initialize (URL url, ResourceBundle rb){
        initTable();
    }
    /*public void initTable(){//inicializa a tebela com os valores atuais do DB
        /*Usuario bancoAtual = new Usuario();
        colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));//exatamente como está escrito no tipo Usuario
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

        /*colunaNome.setCellValueFactory(new PropertyValueFactory(bancoAtual.getPrimeiroNome()));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory(bancoAtual.getUltimoNome()));
        colunaCargo.setCellValueFactory(new PropertyValueFactory(bancoAtual.getCargo()));

        tabelaUsuarios.setItems(atualizaTabela());
    }
    public ObservableList<Usuario> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListUsuarios());
    }*/