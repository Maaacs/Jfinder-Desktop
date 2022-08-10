package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioDocumentoController implements Initializable {
    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private JFXButton voltarRelatorioDocumento;
    @FXML
    private TableView<Documento> tabelaDocumentos;
    @FXML
    private TableColumn<Documento, String> colunaNumReferencia;
    @FXML
    private TableColumn<Documento, String> colunaTipoDocumento;
    @FXML
    private TableColumn<Documento, String> colunaInteressadoDocumento;
    @FXML
    private TableColumn<Documento, String> ColunaDescricaoDocumento;
    @FXML
    private JFXButton atualizarTabela;

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

    public void initTable(){
        colunaNumReferencia.setCellValueFactory(new PropertyValueFactory("numeroUnicoReferencia"));//exatamente como está escrito no tipo Documento
        colunaTipoDocumento.setCellValueFactory(new PropertyValueFactory("tipoDeDocumento"));
        colunaInteressadoDocumento.setCellValueFactory(new PropertyValueFactory("interessado"));
        ColunaDescricaoDocumento.setCellValueFactory(new PropertyValueFactory("descriçãoDocumento"));
        tabelaDocumentos.setItems(atualizaTabela());
    }

    public ObservableList<Documento> atualizaTabela(){
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListDocumentos());
    }


    @FXML
    private void atualizarTabelaOnAction(ActionEvent event) {
        BancodeDados bd = new BancodeDados();
        List<Documento> documentos = new BancodeDados().getListDocumentos();
        atualizaTabela();
        System.out.println("Atualizei os documentos");
        // para testar no terminal
       /* try {
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
        }*/
    }
}
