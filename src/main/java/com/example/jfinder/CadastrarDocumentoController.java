package com.example.jfinder;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastrarDocumentoController {
    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private JFXButton voltarCadastroDocumento;

    @FXML
    private TextField numeroReferenciaTextField;
    @FXML
    private TextField tipoDocumentoTextField;
    @FXML
    private TextField interessadoTextField;
    @FXML
    private JFXButton cadastrarDocumento;
    @FXML
    private TextArea descricaoDocumentoTextField;
    @FXML
    private TextArea localArmazenamentoTextField;
    @FXML
    private TextField tipoArmazenamentoTextField;
    @FXML
    private TextField dataArquivamento2TextField;
    @FXML
    private Label cadastroMessageLabel;


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
    private void cadastrarDocumentoOnAction(ActionEvent event) {
        //BancodeDados bd = new BancodeDados("max", "10121114");
        //bd.conecta();
        try {
            //Usuario usuario = new Usuario(" ", "", "", "");
            String numeroReferencia = numeroReferenciaTextField.getText();
            String tipoDocumento = tipoDocumentoTextField.getText();
            String interessado = interessadoTextField.getText();
            String tipoArmazenamento = tipoArmazenamentoTextField.getText();
            String dataArquivamento = dataArquivamento2TextField.getText();
            String descricao = descricaoDocumentoTextField.getText();
            String localArmazenamento = localArmazenamentoTextField.getText();



            Documento documento = new Documento(numeroReferencia, tipoDocumento, interessado, tipoArmazenamento, dataArquivamento, descricao, localArmazenamento);
            //System.out.println(documento.getNumeroUnicoReferencia());
            System.out.println("Novo está sendo cadastrado!");
            BancodeDados.adicionarDocumento(documento);
            cadastroMessageLabel.setText("Documento cadastrado com sucesso!");
            //System.out.println("foi!");
        }catch (NumberFormatException e){
            cadastroMessageLabel.setText("");
            cadastroMessageLabel.setText("Entrada Inválida!");
        }
    }
}
