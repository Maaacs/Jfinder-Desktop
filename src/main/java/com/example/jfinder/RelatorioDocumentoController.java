package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioDocumentoController implements Initializable {
    @FXML private TableView<Documento> tabelaDocumentos;
    @FXML private TableColumn<Documento, String> colunaNumReferencia;
    @FXML private TableColumn<Documento, String> colunaTipoDocumento;
    @FXML private TableColumn<Documento, String> colunaInteressadoDocumento;
    @FXML private TableColumn<Documento, String> ColunaDescricaoDocumento;
    @FXML private Label RelatorioDocumentoLabelMessage;

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

    @Override
    public void initialize (URL url, ResourceBundle rb){
        initTable();
    }

    public void initTable(){//inicializa a tebela com os valores atuais do DB
        colunaNumReferencia.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));//exatamente como está escrito no tipo Documento
        colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
        colunaInteressadoDocumento.setCellValueFactory(new PropertyValueFactory("interessado"));
        ColunaDescricaoDocumento.setCellValueFactory(new PropertyValueFactory("descriçãoDocumento"));
        tabelaDocumentos.setItems(atualizaTabela());
    }

    public ObservableList<Documento> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListDocumentos());
    }


    @FXML private void atualizarTabelaOnAction(ActionEvent event) {
        initTable();
        //atualizaTabela();
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
    }
}
