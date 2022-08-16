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

public class RelatorioDocumentoController implements Initializable {
    @FXML private TableView<Documento> tabelaDocumentos;
    @FXML private TableColumn<Documento, String> colunaNumReferencia;
    @FXML private TableColumn<Documento, String> colunaTipoDocumento;
    @FXML private TableColumn<Documento, String> colunaInteressado;
    @FXML private TableColumn<Documento, String> colunaArmazenamento;
    @FXML private TableColumn<Documento, String> colunaArquivamento;
    @FXML private TextField itemMessageLabel;
    @FXML private Label RelatorioDocumentoLabelMessage;
    @FXML
    private ChoiceBox<String> choiceButton;
    @FXML private  String[] consultas = new String[]{"Interessado", "Tipo", "Palavra-chave"};


    private ObservableList<Documento> palavras = FXCollections.observableArrayList();


    @Override
    public void initialize (URL url, ResourceBundle rb){
        choiceButton.getItems().addAll(consultas);
        //choiceButton.setOnAction(this::getTipoConsulta);
    }

    @FXML
    private void consultaPorDiferentesEntradas(ActionEvent event) {//Buscar com os filtros Tipo e Interessado
        String selecionador = choiceButton.getValue();
        System.out.println(selecionador);

        Documento doc = new Documento();
        String itemAserBuscado = itemMessageLabel.getText();

        if (selecionador == "Interessado"){//Botao 1
            if(doc.buscarPorInteressado(itemAserBuscado) == null){
                System.out.println("Não encontrado");

            }else{
                System.out.println("Encontrei o interessado!");

                //Inicializa a tabela com os valores recebidos do BuscarPorInteressado
                colunaNumReferencia.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));//exatamente como está escrito no tipo Documento
                colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
                colunaInteressado.setCellValueFactory(new PropertyValueFactory("interessado"));
                colunaArmazenamento.setCellValueFactory(new PropertyValueFactory("tipoDeArmazenamento"));
                colunaArquivamento.setCellValueFactory(new PropertyValueFactory("dataArquivamento"));
                tabelaDocumentos.setItems(atualizaTabelaInteressado());
            }
        }
        else if(selecionador == "Tipo"){ //Botao 2
            if(doc.buscarPorTipoDeDocumento(itemAserBuscado) == null){
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
            if(doc.buscarPorTipoDeDocumento(itemAserBuscado) == null){
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
        }

    }


    public ObservableList<Documento> atualizaTabelaInteressado(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Documento dao = new Documento();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscarPorInteressado(itemAserBuscado));
    }

    public ObservableList<Documento> atualizaTabelaTipodeDocumento(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Documento dao = new Documento();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscarPorTipoDeDocumento(itemAserBuscado));
    }

    public ObservableList<Documento> atualizaTabelaPalavraChave(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Documento dao = new Documento();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscarPorPalavraChave(itemAserBuscado));
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



}


    /*public ObservableList<Documento> atualizaTabela(){ // Pega TODOS os itens do DB e preenche em uma tabela
        BancodeDados dao = new BancodeDados();
        palavras = FXCollections.observableArrayList(dao.getListDocumentos());
        return palavras;
    }

    @FXML private void atualizarTabelaOnAction(ActionEvent event) {
        //initTable();
        System.out.println("Atualizei os documentos");
        // para testar no terminal
        List<Documento> documentos = new BancodeDados().getListDocumentos();
       try {
            if (documentos != null){
                for (int i = 0; i < documentos.size(); i++){
                    documentos.get(i).mostraDocumento();
                    System.out.println("------------");
                }
            }else{
                System.out.println("Lista nula");

            }

        }catch (NumberFormatException e){
           RelatorioDocumentoLabelMessage.setText("Tabela está vazia!");
        }
    }*/