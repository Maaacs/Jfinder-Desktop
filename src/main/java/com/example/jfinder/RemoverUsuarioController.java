package com.example.jfinder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoverUsuarioController implements Initializable{


    @FXML private TableView<Usuario> tabelaUsuarios;
    @FXML private TableColumn<Usuario, String> colunaNome;
    @FXML private TableColumn<Usuario, String> colunaSobrenome;
    @FXML private TableColumn<Usuario, String> colunaCargo;
    @FXML private Label tabelaMessageLabel;
    @FXML private TextField cpfBuscarMessageLabel;
    @FXML private TableColumn colunaCpf;
    @FXML private Label resultadoMessageLabel;
    @FXML
    private Button voltarCadastroUsuario1;
    @FXML
    private Button atualizarTabela;


    public void initialize (URL url, ResourceBundle rb){
        initTable();
    }

    public void initTable(){//inicializa a tebela com os valores atuais do DB
        colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));//exatamente como está escrito no tipo Usuario
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

        tabelaUsuarios.setItems(atualizaTabela());
    }

    public ObservableList<Usuario> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListUsuarios());
    }

    @FXML private void atualizarTabelaUsuariosOnAction(ActionEvent event) {
        initTable();
        tabelaMessageLabel.setText("");
        resultadoMessageLabel.setText("");
        cpfBuscarMessageLabel.setText("");
    }

    @FXML
    private void removerUsuarioOnAction(ActionEvent event) {
        BancodeDados usr = new BancodeDados();
        Usuario busca = new Usuario();

        try {

            if(cpfBuscarMessageLabel.getText().isBlank() == false) {//campo nao for vazio
                String cpf = cpfBuscarMessageLabel.getText();

                if(busca.buscarCPF(cpf) != null){
                    String cpf2 = cpfBuscarMessageLabel.getText();
                    usr.removerUsuario(cpf2);
                    resultadoMessageLabel.setText("");
                    tabelaMessageLabel.setText("Usuário removido com sucesso!");
                }else{
                    tabelaMessageLabel.setText("");
                    resultadoMessageLabel.setText("Usuário não encontrado!");
                }

            }else{
                tabelaMessageLabel.setText("");
                resultadoMessageLabel.setText("Insira o CPF!");
            }

        }catch (NumberFormatException e){
            tabelaMessageLabel.setText("");
            resultadoMessageLabel.setText("CPF incorreto!");
        }

    }


    public void voltarOnAction(ActionEvent event){
        resultadoMessageLabel.setText("");
        tabelaMessageLabel.setText("");
        cpfBuscarMessageLabel.setText("");
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
