package com.example.jfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Date;

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
    private Label resultado3MessageLabel;
    @FXML
    private Label resultado4LabelMessage;
    @FXML
    private Button voltarAlteracaoDocumento;
    @FXML
    private Button confirmarAlteracaoUsuario;
    @FXML
    private Button buscarDocumento;


    @FXML
    private void buscarDocumentoOnAction(ActionEvent event) {
        tipoDocumentoTextField.setText("");
        interessadoTextField.setText("");
        tipoArmazenamentoTextField.setText("");
        dataArquivamentoTextField.setText("");
        localArmazenamentoTextField.setText("");
        descricaoTextField.setText("");

        try{

            if(numeroReferenciaTextField.getText().isBlank() == false){

                Documento tabelaNReferencia = new Documento();
                Documento doc = new Documento();
                int numeroDeReferencia = Integer.parseInt(numeroReferenciaTextField.getText());
                doc = doc.buscarPorNumeroReferencia(numeroDeReferencia);

                if (doc == null){
                    System.out.println("Documento encontrado");
                    resultado4LabelMessage.setText("");
                    resultado3MessageLabel.setText("Documento informado não encontrado!");

                }else{
                    resultado4LabelMessage.setText("");
                    resultado3MessageLabel.setText("");
                    tabelaNReferencia = doc.buscarPorNumeroReferencia(numeroDeReferencia);
                    tipoDocumentoTextField.setText(tabelaNReferencia.getTipoDeDocumento());
                    interessadoTextField.setText(tabelaNReferencia.getInteressado());
                    tipoArmazenamentoTextField.setText(tabelaNReferencia.getTipoDeArmazenamento());
                    dataArquivamentoTextField.setText(tabelaNReferencia.getDataArquivamento());
                    localArmazenamentoTextField.setText(tabelaNReferencia.getLocalCompletoDeArmazenamento());
                    descricaoTextField.setText(tabelaNReferencia.getDescriçãoDocumento());
                }
            }
            else{
                resultado4LabelMessage.setText("");
                resultado3MessageLabel.setText("Insira o nº de referência!");
            }

        }catch (NumberFormatException e){
            resultado3MessageLabel.setText("Insira o nº de referência corretamente!");
            resultado4LabelMessage.setText("");
        }

    }


    public void atualiza(){
        BancodeDados dao = new BancodeDados();
        int numeroDeReferencia = Integer.parseInt(numeroReferenciaTextField.getText());
        String tipoDeDoumento = tipoDocumentoTextField.getText();
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
        resultado4LabelMessage.setText("");
        if (tipoDocumentoTextField.getText().isBlank() == false && interessadoTextField.getText().isBlank() == false && tipoArmazenamentoTextField.getText().isBlank() == false && dataArquivamentoTextField.getText().isBlank() == false && localArmazenamentoTextField.getText().isBlank() == false && descricaoTextField.getText().isBlank() == false) {
            atualiza();
        } else{
            resultado3MessageLabel.setText("Verifique se todos os campos estão preenchidos!");
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
        resultado3MessageLabel.setText("");
        resultado4LabelMessage.setText("");
        Main.changeScreen("documento-view");
    }



}
