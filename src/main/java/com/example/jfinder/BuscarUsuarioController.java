package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BuscarUsuarioController{
    @FXML private TextField cpfBuscarMessageLabel;
    @FXML private Label resultadoMessageLabel;
    @FXML private Label resultado2MessageLabel;
    @FXML private Label resultado3MessageLabel;
    @FXML private Label resultado4MessageLabel;
    @FXML private Label resultado5MessageLabel;
    @FXML private Label resultado6MessageLabel;

    public void voltarBuscarOnAction(ActionEvent event){
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
    private void buscarOnAction() {
        Usuario bancoPorCPF = new Usuario();
        Usuario usr = new Usuario();
        int cpf = Integer.parseInt(cpfBuscarMessageLabel.getText());
        usr = usr.buscarCPF(cpf);

        if (usr == null){
            System.out.println("Nao encontrado");
            resultado6MessageLabel.setText("Resultados encontrados (0)");

        }else{
            System.out.println("Encontrei o fulano");
            bancoPorCPF = usr.buscarCPF(cpf);

            resultado2MessageLabel.setText("Resultados encontrados (1)");
            resultadoMessageLabel.setText(bancoPorCPF.getPrimeiroNome());
            resultado3MessageLabel.setText(bancoPorCPF.getUltimoNome());
            resultado4MessageLabel.setText(Integer.toString(bancoPorCPF.getCPF()));
            resultado5MessageLabel.setText(bancoPorCPF.getCargo());
        }
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