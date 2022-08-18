package com.example.jfinder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigInteger;
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
    @FXML
    private ChoiceBox<String> choiceButton;
    @FXML private  String[] consultas = new String[]{"Ano", "Tipo", "Interessado" , "Palavra-chave"};

    private ObservableList<Documento> palavras = FXCollections.observableArrayList();
    @FXML
    private Button atualizaTabela;


    @Override
    public void initialize (URL url, ResourceBundle rb){
        initiTable();
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
            if(doc.buscarPorPalavraChave(itemAserBuscado) == null){
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

        else if(selecionador == "Ano"){ //Botao 3
            if(doc.buscarPorAno(itemAserBuscado) == null){
                System.out.println("Não encontrado");
            }else{

                System.out.println("Encontrei!");

                //Inicializa a tabela com os valores recebidos do BuscarPorPalavraChave
                colunaNumReferencia.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));//exatamente como está escrito no tipo Documento
                colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
                colunaInteressado.setCellValueFactory(new PropertyValueFactory("interessado"));
                colunaArmazenamento.setCellValueFactory(new PropertyValueFactory("tipoDeArmazenamento"));
                colunaArquivamento.setCellValueFactory(new PropertyValueFactory("dataArquivamento"));
                tabelaDocumentos.setItems(atualizaTabelaAno());
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

    public ObservableList<Documento> atualizaTabelaAno(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Documento dao = new Documento();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscarPorAno(itemAserBuscado));
    }


    @FXML
    private void atualizaTabelaOnAction(ActionEvent event) {
        itemMessageLabel.setText("");
        initiTable();
    }

    public ObservableList<Documento> atualizaTabela(){ // Pega TODOS os itens do DB e preenche em uma tabela
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListDocumentos());
    }

    public void initiTable(){
        colunaNumReferencia.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));//exatamente como está escrito no tipo Documento
        colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
        colunaInteressado.setCellValueFactory(new PropertyValueFactory("interessado"));
        colunaArmazenamento.setCellValueFactory(new PropertyValueFactory("tipoDeArmazenamento"));
        colunaArquivamento.setCellValueFactory(new PropertyValueFactory("dataArquivamento"));
        tabelaDocumentos.setItems(atualizaTabela());
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















    /*@FXML private void atualizarTabelaOnAction(ActionEvent event) {
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