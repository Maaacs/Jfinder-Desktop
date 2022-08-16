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
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioUsuarioController implements Initializable {
    @FXML private Label tabelaMessageLabel;
    @FXML private TableView<Usuario> tabelaDeUsuarios;
    @FXML private TableColumn<Usuario, String> colunaNome;
    @FXML private TableColumn<Usuario, String> colunaSobrenome;
    @FXML private TableColumn<Usuario, String> colunaCpf;
    @FXML private TableColumn<Usuario, String> colunaCargo;
    @FXML
    private JFXButton voltarRelatorioUsuario;
    @FXML
    private ChoiceBox<String> choiceButton;
    @FXML
    private TextField itemMessageLabel;
    @FXML
    private JFXButton buscarButton;

    private String[]consultas = new String[]{"Nome", "Sobrenome", "Cargo"};


    @Override
    public void initialize (URL url, ResourceBundle rb){
        choiceButton.getItems().addAll(consultas);
    }

    @FXML
    private void consultaPorDiferentesEntradas(ActionEvent event) {

        String selecionador = choiceButton.getValue();
        System.out.println(selecionador);

        Usuario usr = new Usuario();
        String itemAserBuscado = itemMessageLabel.getText();

        if (selecionador == "Nome"){//Botao 1
            if(usr.buscarPorNome(itemAserBuscado) == null){
                System.out.println("Não encontrado");

            }else{
                System.out.println("Encontrei o usuario com esse nome!");

                //Inicializa a tabela com os valores recebidos do BuscaPorNome
                colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));//exatamente como está escrito no tipo Usuario
                colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
                colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
                colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

                tabelaDeUsuarios.setItems(atualizaTabelaPorNome());
            }
        }else{
            System.out.println("nao");
        }
       /* else if(selecionador == "Tipo"){ //Botao 2
            if(usr.buscarPorTipoDeDocumento(itemAserBuscado) == null){
                System.out.println("Não encontrado");
            }else{

                System.out.println("Encontrei o tipo de documento!");

                //Inicializa a tabela com os valores recebidos do BuscarPorTipo
                colunaNumReferencia.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));//exatamente como está escrito no tipo Documento
                colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
                colunaInteressado.setCellValueFactory(new PropertyValueFactory("interessado"));
                colunaArmazenamento.setCellValueFactory(new PropertyValueFactory("tipoDeArmazenamento"));
                colunaArquivamento.setCellValueFactory(new PropertyValueFactory("dataArquivamento"));
                tabelaDocumentos.setItems(atualizaTabelaTipodeDocumento());
            }
        }
        else if(selecionador == "Palavra-chave"){ //Botao 3
            if(usr.buscarPorTipoDeDocumento(itemAserBuscado) == null){
                System.out.println("Não encontrado");
            }else{

                System.out.println("Encontrei a palavra-chave!");

                //Inicializa a tabela com os valores recebidos do BuscarPorPalavraChave
                colunaNumReferencia.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));//exatamente como está escrito no tipo Documento
                colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
                colunaInteressado.setCellValueFactory(new PropertyValueFactory("interessado"));
                colunaArmazenamento.setCellValueFactory(new PropertyValueFactory("tipoDeArmazenamento"));
                colunaArquivamento.setCellValueFactory(new PropertyValueFactory("dataArquivamento"));
                tabelaDocumentos.setItems(atualizaTabelaPalavraChave());
            }
        }*/

    }


    public ObservableList<Usuario> atualizaTabelaPorNome(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Usuario dao = new Usuario();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscarPorNome(itemAserBuscado));
    }



    /*public void initTable(){//inicializa a tebela com os valores atuais do DB
        colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        tabelaDeUsuarios.setItems(atualizaTabela());
    }*/



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


}



   /* public ObservableList<Usuario> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
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
    }*/
