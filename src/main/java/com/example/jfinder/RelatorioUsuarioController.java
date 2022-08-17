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

public class RelatorioUsuarioController implements Initializable {
    @FXML private Label tabelaMessageLabel;
    @FXML private TableView<Usuario> tabelaDeUsuarios;
    @FXML private TableColumn<Usuario, String> colunaNome;
    @FXML private TableColumn<Usuario, String> colunaSobrenome;
    @FXML private TableColumn<Usuario, String> colunaCpf;
    @FXML private TableColumn<Usuario, String> colunaCargo;
    @FXML
    private JFXButton voltarRelatorioUsuario;
    @FXML
    private ChoiceBox<String> choiceButton;
    @FXML
    private TextField itemMessageLabel;
    @FXML
    private JFXButton buscarButton;

    private String[]consultas = new String[]{"Nome", "Sobrenome", "Cargo"};
    @FXML
    private Label resultadoMessageLabel;


    @Override
    public void initialize (URL url, ResourceBundle rb){
        choiceButton.getItems().addAll(consultas);
    }

    @FXML
    private void consultaPorDiferentesEntradas(ActionEvent event) {

        String selecionador = choiceButton.getValue();
        System.out.println(selecionador);

        Usuario usr = new Usuario();
        String itemAserBuscado = itemMessageLabel.getText();

        if (selecionador == "Nome"){//Botao 1
            if(usr.buscarPorNome(itemAserBuscado) == null){
                System.out.println("Não encontrado");
                resultadoMessageLabel.setText("Não encontrei resultados!");

            }else{
                //Inicializa a tabela com os valores recebidos do BuscaPorNome
                colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));//exatamente como está escrito no tipo Usuario
                colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
                colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
                colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

                tabelaDeUsuarios.setItems(atualizaTabelaPorNome());
            }
        }
       else if(selecionador == "Sobrenome"){ //Botao 2
            if(usr.buscarPorSobrenome(itemAserBuscado) == null){
                System.out.println("Não encontrado");
                resultadoMessageLabel.setText("Não encontrei resultados!");
            }else{

                System.out.println("Encontrei o usuario com esse sobrenome!");

                //Inicializa a tabela com os valores recebidos do BuscarPorTipo
                colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));//exatamente como está escrito no tipo Usuario
                colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
                colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
                colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

                tabelaDeUsuarios.setItems(atualizaTabelaPorSobrenome());
            }
        }
        else if(selecionador == "Cargo"){ //Botao 3
            if(usr.buscaPorCargo(itemAserBuscado) == null){
                System.out.println("Não encontrado");
                resultadoMessageLabel.setText("Não encontrei resultados!");
            }else{

                System.out.println("Encontrei o usuario com esse sobrenome!");

                //Inicializa a tabela com os valores recebidos do BuscarPorTipo
                colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));//exatamente como está escrito no tipo Usuario
                colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
                colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
                colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

                tabelaDeUsuarios.setItems(atualizaTabelaPorCargo());
            }
        }
    }


    public ObservableList<Usuario> atualizaTabelaPorNome(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Usuario dao = new Usuario();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscarPorNome(itemAserBuscado));
    }

    public ObservableList<Usuario> atualizaTabelaPorSobrenome(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Usuario dao = new Usuario();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscarPorSobrenome(itemAserBuscado));
    }

    public ObservableList<Usuario> atualizaTabelaPorCargo(){ //serve para retornar a tabela com os valores atuais do Jfinder
        Usuario dao = new Usuario();
        String itemAserBuscado = itemMessageLabel.getText();
        return FXCollections.observableArrayList(dao.buscaPorCargo(itemAserBuscado));
    }





    /*public void initTable(){//inicializa a tebela com os valores atuais do DB
        colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        tabelaDeUsuarios.setItems(atualizaTabela());
    }*/



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



   /* public ObservableList<Usuario> atualizaTabela(){ //serve para retornar a tabela com os valores atuais do Jfinder
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getListUsuarios());
    }

    @FXML private void atualizarTabelaUsuariosOnAction(ActionEvent event) {
        initTable();
        //atualizaTabela();
        System.out.println("Atualizei os usuarios");
        // para testar no terminal
        List<Usuario> usuarios = new BancodeDados().getListUsuarios();
        try {
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
        }
    }*/
