package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class RemoverUsuarioController implements Initializable{


    @FXML private TableView<Usuario> tabelaUsuarios;
    @FXML private TableColumn<Usuario, String> colunaNome;
    @FXML private TableColumn<Usuario, String> colunaSobrenome;
    @FXML private TableColumn<Usuario, String> colunaCargo;
    @FXML private JFXButton voltarCadastroUsuario;
    @FXML
    private Label tabelaMessageLabel;
    @FXML
    private JFXButton buscarUsuarioButton;
    @FXML
    private TextField cpfBuscarMessageLabel;
    @FXML
    private Label nome;
    @FXML
    private JFXButton removerUsuario;


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
    private void buscarUsuarioButtoOnAction(){
        Usuario usr = new Usuario();
        Usuario dados = new Usuario();
        String cpf = cpfBuscarMessageLabel.getText();
        usr = usr.buscarCPF(cpf);

        if (usr == null){
            System.out.println("Nao encontrado");
            nome.setText("Tente novamente");

        }else{
            System.out.println("Encontrei o fulano");
            nome.setText(dados.getPrimeiroNome());
        }
    }


    @FXML
    private void removerUsuarioOnAction(ActionEvent event) {
        BancodeDados usr = new BancodeDados();

        String cpf = cpfBuscarMessageLabel.getText();
        boolean u = usr.removerUsuario(cpf);

        if (u == true){
            System.out.println("OK");
        }else{
            System.out.println("Erro");
        }
    }






    @FXML private void atualizarTabelaUsuariosOnAction(ActionEvent event) {
        initTable();
    }

}
