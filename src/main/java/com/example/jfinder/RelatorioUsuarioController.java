package com.example.jfinder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioUsuarioController implements Initializable {
    @FXML private Label tabelaMessageLabel;
    @FXML private TableView<Usuario> tabelaDeUsuarios;
    @FXML private TableColumn<Usuario, String> colunaNome;
    @FXML private TableColumn<Usuario, String> colunaSobrenome;
    @FXML private TableColumn<Usuario, String> colunaCpf;
    @FXML private TableColumn<Usuario, String> colunaCargo;

    @Override
    public void initialize (URL url, ResourceBundle rb){
        initTable();
    }

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

    public void voltarOnAction(ActionEvent event){
        Main.changeScreen("relatorio-view");
    }


    public void initTable(){//inicializa a tebela com os valores atuais do DB
        colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        tabelaDeUsuarios.setItems(atualizaTabela());
    }
    public ObservableList<Usuario> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListUsuarios());
    }

    @FXML private void atualizarTabelaUsuariosOnAction(ActionEvent event) {
        initTable();
        //atualizaTabela();
        System.out.println("Atualizei os usuarios");
        // para testar no terminal
        List<Usuario> usuarios = new BancodeDados().getListUsuarios();
        try {
            if (usuarios != null){
                for (int i = 0; i < usuarios.size(); i++){
                    usuarios.get(i).mostraUsuario();

                    System.out.println("------------");
                }
            }else{
                System.out.println("Lista nula");

            }

        }catch (NumberFormatException e){
            tabelaMessageLabel.setText("Lista é nula!");
        }
    }
}
