package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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
    private Button voltarDocumentos;
    @FXML
    private Button buscarDocumento;
    @FXML
    private Label resultado6MessageLabel;
    @FXML
    private Label resultado7MessageLabel;

    @FXML
    private void buscarDocumentOnAction(ActionEvent event) {
        Documento bancoPorNreferencia= new Documento();
        Documento doc = new Documento();

        try{
            if(numeroReferencia.getText().isBlank() == false){
                int nReferencia = Integer.parseInt(numeroReferencia.getText());
                doc = doc.buscarPorNumeroReferencia(nReferencia);

                if (doc == null){
                    System.out.println("Documento não encontrado!");
                    resultadoMessageLabel.setText("Documento não encontrado!");
                    resultado2MessageLabel.setText("");
                    resultado3MessageLabel.setText("");
                    resultado4MessageLabel.setText("");
                    resultado5MessageLabel.setText("");
                    resultado6MessageLabel.setText("");
                    resultado7MessageLabel.setText("");

                }else{
                    resultadoMessageLabel.setText("");
                    bancoPorNreferencia = doc.buscarPorNumeroReferencia(nReferencia);
                    resultado2MessageLabel.setText(bancoPorNreferencia.getTipoDeDocumento());
                    resultado3MessageLabel.setText(bancoPorNreferencia.getInteressado());
                    resultado4MessageLabel.setText(bancoPorNreferencia.getLocalCompletoDeArmazenamento());
                    resultado5MessageLabel.setText(bancoPorNreferencia.getDescriçãoDocumento());
                    resultado6MessageLabel.setText(bancoPorNreferencia.getTipoDeArmazenamento());
                    resultado7MessageLabel.setText(bancoPorNreferencia.getDataArquivamento());
                }
            }else{
                resultadoMessageLabel.setText("Insira o nº de referência!");
                resultado2MessageLabel.setText("");
                resultado3MessageLabel.setText("");
                resultado4MessageLabel.setText("");
                resultado5MessageLabel.setText("");
                resultado6MessageLabel.setText("");
                resultado7MessageLabel.setText("");
            }
        }catch (NumberFormatException e){
            resultadoMessageLabel.setText("Nº de referência inválido!");
            resultado2MessageLabel.setText("");
            resultado3MessageLabel.setText("");
            resultado4MessageLabel.setText("");
            resultado5MessageLabel.setText("");
            resultado6MessageLabel.setText("");
            resultado7MessageLabel.setText("");
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

    @FXML
    private void buscaAvancadaOnAction(MouseEvent mouseEvent) {
        Main.changeScreen("relatorioDocumento-view");
    }
}
