package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlterarDocumentoController {

    @FXML
    private TextField tipoDocumentoTextField;
    @FXML
    private TextField interessadoTextField;
    @FXML
    private TextField tipoArmazenamentoTextField;
    @FXML
    private TextField dataArquivamentoTextField;
    @FXML
    private TextArea localArmazenamentoTextField;
    @FXML
    private TextArea descricaoTextField;
    @FXML
    private TextField numeroReferenciaTextField;
    @FXML
    private Label resultadoMessageLabel;
    @FXML
    private Label resultado2MessageLabel;
    @FXML
    private Label resultado3MessageLabel;
    @FXML
    private Label resultado4LabelMessage;


    @FXML
    private void buscarDocumentoOnAction(ActionEvent event) {
        if(numeroReferenciaTextField.getText().isBlank() == false){

            Documento tabelaNReferencia = new Documento();
            Documento doc = new Documento();
            String numeroDeReferencia = numeroReferenciaTextField.getText();
            doc = doc.buscarPorNumeroReferencia(numeroDeReferencia);

            if (doc == null){
                System.out.println("Documento encontrado");
                resultado2MessageLabel.setText("Documento informado não encontrado!");

            }else{
                tabelaNReferencia = doc.buscarPorNumeroReferencia(numeroDeReferencia);
                tipoDocumentoTextField.setText(tabelaNReferencia.getTipoDeDocumento());
                interessadoTextField.setText(tabelaNReferencia.getInteressado());
                tipoArmazenamentoTextField.setText(tabelaNReferencia.getTipoDeArmazenamento());
                dataArquivamentoTextField.setText(tabelaNReferencia.getDataArquivamento());
                localArmazenamentoTextField.setText(tabelaNReferencia.getLocalCompletoDeArmazenamento());
                descricaoTextField.setText(tabelaNReferencia.getDescriçãoDocumento());
                resultadoMessageLabel.setText("Resultados encontrados (1)");
            }
        }
        else{
            resultado3MessageLabel.setText("Insira o número de referência!");
        }
    }


    public void atualiza(){
        BancodeDados dao = new BancodeDados();
        String numeroDeReferencia = numeroReferenciaTextField.getText();
        String tipoDeDoumento = tipoArmazenamentoTextField.getText();
        String interessadoDocumento = interessadoTextField.getText();
        String tipoArmazenamentoDocumento = tipoArmazenamentoTextField.getText();
        String dataArquivamentoDocumento = dataArquivamentoTextField.getText();
        String descricaoDocumento = descricaoTextField.getText();
        String localCompletoDocumento = localArmazenamentoTextField.getText();

        Documento p = new Documento(numeroDeReferencia, tipoDeDoumento, interessadoDocumento, tipoArmazenamentoDocumento, dataArquivamentoDocumento, descricaoDocumento, localCompletoDocumento);

        if (dao.alterarDocumento(p)){
            System.out.println("Documento atualizado!");
            resultado4LabelMessage.setText("Documento atualizado com sucesso!");
        }else{
            System.out.println("Alteração não realizada!");
        }
    }
    @FXML
    private void confirmarAlteracaoOnAction(ActionEvent event) {
        atualiza();
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
