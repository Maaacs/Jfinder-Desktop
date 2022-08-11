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

public class BuscarUsuarioController implements Initializable {
    @FXML private TextField cpfBuscarMessageLabel;
    @FXML private Label resultadoMessageLabel;
    @FXML private TableColumn colunaNome;
    @FXML private TableColumn colunaSobrenome;
    @FXML private TableColumn colunaCargo;
    @FXML
    private TableView tabelaUsuarios;

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

    public void initialize (URL url, ResourceBundle rb){
        initTable();
    }

    public void initTable(){//inicializa a tebela com os valores atuais do DB
        colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));//exatamente como está escrito no tipo Usuario
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

        tabelaUsuarios.setItems(atualizaTabela());
    }

    public ObservableList<Usuario> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListUsuarios());
    }

    @FXML
    private void buscarUsuarioButtoOnAction() {
        Usuario valor = new Usuario();
        Usuario usr = new Usuario();
        String cpf = cpfBuscarMessageLabel.getText();
        usr = usr.buscarCPF(cpf);

        if (usr == null){
            System.out.println("Nao encontrado");
            resultadoMessageLabel.setText("Tente novamente");

        }else{
            System.out.println("Encontrei o fulano");
            valor = usr.buscarCPF(cpf);
           // valor.getPrimeiroNome()
            //System.out.println(usr.buscarCPF());
            //rs.getString("nome")
            resultadoMessageLabel.setText(valor.getPrimeiroNome());
        }
    }
}
