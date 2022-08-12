package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.jfinder.BancodeDados.conexao;

public class BuscarUsuarioController{
    @FXML private TextField cpfBuscarMessageLabel;
    @FXML private Label resultadoMessageLabel;
    @FXML private TableColumn colunaNome;
    @FXML private TableColumn colunaSobrenome;
    @FXML private TableColumn colunaCargo;
    @FXML
    private TableView tabelaUsuarios;
    @FXML
    private Label resultado2MessageLabel;
    @FXML
    private Label resultado3MessageLabel;
    @FXML
    private Label resultado4MessageLabel;
    @FXML
    private Label resultado5MessageLabel;
    @FXML
    private Label resultado6MessageLabel;

    public void voltarBuscarOnAction(ActionEvent event){
        Main.changeScreen("usuario-view");
    }
    public void confirmarOnAction(ActionEvent event){
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

    @FXML
    private void buscarOnAction() {
        Usuario bancoPorCPF = new Usuario();
        Usuario usr = new Usuario();
        String cpf = cpfBuscarMessageLabel.getText();
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
            resultado4MessageLabel.setText(bancoPorCPF.getCPF());
            resultado5MessageLabel.setText(bancoPorCPF.getCargo());
        }
    }
}
