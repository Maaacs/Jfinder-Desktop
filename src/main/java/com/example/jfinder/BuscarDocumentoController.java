package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BuscarDocumentoController {
    @FXML
    private TextField numeroReferencia;
    @FXML
    private Label resultadoMessageLabel;
    @FXML
    private Label resultado2MessageLabel;
    @FXML
    private Label resultado3MessageLabel;
    @FXML
    private Label resultado4MessageLabel;
    @FXML
    private TextArea resultado5MessageLabel;
    @FXML
    private Label resultado6MessageLabel;

    @FXML
    private void buscarDocumentOnAction(ActionEvent event) {
        Documento bancoPorNreferencia= new Documento();
        Documento doc = new Documento();
        String nReferencia = numeroReferencia.getText();
        doc = doc.buscarPorNumeroReferencia(nReferencia);

        if (doc == null){
            System.out.println("Documento não encontrado!");
            resultado6MessageLabel.setText("Resultados encontrados (0)");

        }else{
            System.out.println("Encontrei o fulano");
            bancoPorNreferencia = doc.buscarPorNumeroReferencia(nReferencia);

            resultadoMessageLabel.setText("Resultados encontrados (1)");
            resultado2MessageLabel.setText(bancoPorNreferencia.getTipoDeDocumento());
            resultado3MessageLabel.setText(bancoPorNreferencia.getInteressado());
            resultado4MessageLabel.setText(bancoPorNreferencia.getLocalCompletoDeArmazenamento());
            resultado5MessageLabel.setText(bancoPorNreferencia.getDescriçãoDocumento());
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
    }



}
