package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CadastrarDocumentoController {

    @FXML private TextField numeroReferenciaTextField;
    @FXML private TextField tipoDocumentoTextField;
    @FXML private TextField interessadoTextField;
    @FXML private TextArea descricaoDocumentoTextField;
    @FXML private TextArea localArmazenamentoTextField;
    @FXML private TextField tipoArmazenamentoTextField;
    @FXML private DatePicker dataArquivamentoDatePicker;
    @FXML
    private Label resultadoMessageLabel;
    @FXML
    private Label resultado2MessageLabel;
    @FXML
    private Button voltarCadastroDocumento;
    @FXML
    private Button cadastrarDocumento;


    @FXML
    private void cadastrarDocumentoOnAction(ActionEvent event) {
        try {
            if (numeroReferenciaTextField.getText().isBlank() == false && tipoDocumentoTextField.getText().isBlank() == false && interessadoTextField.getText().isBlank() == false && tipoArmazenamentoTextField.getText().isBlank() == false && dataArquivamentoDatePicker.getValue() !=null && descricaoDocumentoTextField.getText().isBlank() == false && localArmazenamentoTextField.getText().isBlank() == false){
                int numeroReferencia = Integer.parseInt(numeroReferenciaTextField.getText());
                String tipoDocumento = tipoDocumentoTextField.getText();
                String interessado = interessadoTextField.getText();
                String tipoArmazenamento = tipoArmazenamentoTextField.getText();
                LocalDate dataArquivamento = dataArquivamentoDatePicker.getValue();
                String descricao = descricaoDocumentoTextField.getText();
                String localArmazenamento = localArmazenamentoTextField.getText();

                String formatandoDateToString = dataArquivamento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                Documento documento = new Documento(numeroReferencia, tipoDocumento, interessado, tipoArmazenamento, formatandoDateToString, descricao, localArmazenamento);
                if (BancodeDados.adicionarDocumento(documento)){
                    resultadoMessageLabel.setText("");
                    numeroReferenciaTextField.setText("");
                    tipoDocumentoTextField.setText("");
                    interessadoTextField.setText("");
                    tipoArmazenamentoTextField.setText("");
                    descricaoDocumentoTextField.setText("");
                    localArmazenamentoTextField.setText("");
                    dataArquivamentoDatePicker.setValue(null);
                    resultado2MessageLabel.setText("Cadastro realizado com sucesso!");
                }else{
                    resultado2MessageLabel.setText("");
                    resultadoMessageLabel.setText("Este Nº de referência já está cadastrado!");
                }

            }else{
                resultado2MessageLabel.setText("");
                resultadoMessageLabel.setText("Verifique se os dados estão preenchidos corretamente!");
            }

        }catch (NumberFormatException e){
            resultado2MessageLabel.setText("");
            resultadoMessageLabel.setText("Nº de referência inválido!");
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
        resultadoMessageLabel.setText("");
        resultado2MessageLabel.setText("");
        Main.changeScreen("documento-view");
    }

}
