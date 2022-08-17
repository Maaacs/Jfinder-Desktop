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
import java.util.ResourceBundle;

public class RemoverDocumentoController implements Initializable {

    @FXML private JFXButton voltarDocumento;
    @FXML private TableView tabelaDocumentos;
    @FXML private TableColumn colunaNumeroReferenciaDocumento;
    @FXML private TableColumn colunaTipoDocumento;
    @FXML private TableColumn colunaInteressadoDocumento;
    @FXML private TableColumn colunaArquivamentoDocumento;
    @FXML
    private TextField documentoRemoverMessageLabel;
    @FXML
    private Label documentoMessageLabel;
    @FXML
    private Label tabelaMessageLabel;

    @Override
    public void initialize (URL url, ResourceBundle rb){
        initTable();
    }

    public void initTable(){//inicializa a tebela com os valores atuais do DB
        colunaNumeroReferenciaDocumento.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));
        colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
        colunaInteressadoDocumento.setCellValueFactory(new PropertyValueFactory("interessado"));
        colunaArquivamentoDocumento.setCellValueFactory(new PropertyValueFactory("dataArquivamento"));

        tabelaDocumentos.setItems(atualizaTabela());
    }

    public ObservableList<Documento> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListDocumentos());
    }
    @FXML
    private void atualizarTabelaDocumentosOnAction(ActionEvent event) {
        tabelaMessageLabel.setText("");
        documentoMessageLabel.setText("");
        initTable();
    }
    @FXML
    private void removerDocumentoOnAction(ActionEvent event) {
        BancodeDados doc = new BancodeDados();
        Documento busca = new Documento();

        try{

            if(documentoRemoverMessageLabel.getText().isBlank() == false){
                int numeroReferencia = Integer.parseInt(documentoRemoverMessageLabel.getText());

                if (busca.buscarPorNumeroReferencia(numeroReferencia) != null){
                    doc.removerDocumento(numeroReferencia);
                    tabelaMessageLabel.setText("");
                    documentoMessageLabel.setText("Documento removido com sucesso!");
                }else{
                    documentoMessageLabel.setText("");
                    tabelaMessageLabel.setText("Documento não encontrado!");
                }
            }else{
                documentoMessageLabel.setText("");
                tabelaMessageLabel.setText("Insira o nº de Referencia!");
            }

        }catch (NumberFormatException e){
            documentoMessageLabel.setText("");
            tabelaMessageLabel.setText("Nº de Referencia incorreto!");
        }
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

    public void voltarOnAction(ActionEvent event){
        Main.changeScreen("documento-view");
        tabelaMessageLabel.setText("");
        documentoMessageLabel.setText("");
    }
}
