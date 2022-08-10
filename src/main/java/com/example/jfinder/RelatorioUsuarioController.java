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
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioUsuarioController implements Initializable {
    @FXML
    private Button Usuarios;
    @FXML
    private Button Documentos;
    @FXML
    private Button Relatorios;
    @FXML
    private Button encerrarSessao;
    @FXML
    private JFXButton voltarRelatorioUsuario;
    @FXML
    private JFXButton atualizarTabelaUsuarios;
    @FXML
    private Label tabelaMessageLabel;
    @FXML private TableView<Usuario> tabelaDeUsuarios;
    @FXML private TableColumn<Usuario, String> colunaNome;
    @FXML private TableColumn<Usuario, String> colunaSobrenome;
    @FXML private TableColumn<Usuario, String> colunaCpf;
    @FXML private TableColumn<Usuario, String> colunaCargo;

    @Override
    public void initialize (URL url, ResourceBundle rb){
        initTable();
    }

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


    public void initTable(){
        colunaNome.setCellValueFactory(new PropertyValueFactory("primeiroNome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("ultimoNome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("CPF"));
        colunaCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        tabelaDeUsuarios.setItems(atualizaTabela());
    }
    public ObservableList<Usuario> atualizaTabela(){
        BancodeDados dao = new BancodeDados();
        return FXCollections.observableArrayList(dao.getList());
    }
    /*@FXML private void atualizarTabelaUsuariosOnAction(ActionEvent event) {

        try {
            List<Usuario> usuarios = (List<Usuario>) BancodeDados.relatorioUsuarios;

            TableView<Usuario> tabela = new TableView<>();
            TableColumn<Usuario, String> colunaNome = new TableColumn<>("Nome");
            TableColumn<Usuario, String> colunaSobrenome = new TableColumn<>("Sobrenome");
            TableColumn<Usuario, String> colunaCPF = new TableColumn<>("CPF");
            TableColumn<Usuario, String> colunaCargo = new TableColumn<>("Cargo");



            tabela.setItems(FXCollections.observableArrayList(usuarios));
            tabela.getColumns().addAll(colunaNome,colunaSobrenome,colunaCPF,colunaCargo);
            Usuario usuario = new Usuario(nome, sobrenome, cpf, cargo);
            System.out.println(usuario.getPrimeiroNome());
            System.out.println("Novo usuário cadastrado!");
            BancodeDados.adicionarUsuario(usuario);
            //BancodeDados.relatorioUsuarios();
            //System.out.println("foi!");
        }catch (NumberFormatException e){
            tabelaMessageLabel.setText("Lista atualizada!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    @FXML private void atualizarTabelaUsuariosOnAction(ActionEvent event) {
        BancodeDados bd = new BancodeDados();
        List<Usuario> usuarios = new BancodeDados().getList();
        atualizaTabela();
        System.out.println("Atualizei");
        // para testar no terminal
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
    }
}
