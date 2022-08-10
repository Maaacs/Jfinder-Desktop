package com.example.jfinder;
//import java.sql.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BancodeDados {
    String user;

    private static String url = "jdbc:mysql://localhost:3306/JfinderDB";
    String userBD = "max";
    String pass = "10121114";
    protected static Connection conexao = null;

    public BancodeDados() {

        if (conexao == null) conecta();
    }
    public BancodeDados(String userBD, String pass) {
        this.userBD = userBD;
        this.pass = pass;
    }
    public boolean conecta() {
        System.out.println("Estou tentando conectar ao servidor...");
        try {
            BancodeDados.conexao = DriverManager.getConnection(url, userBD, pass);
            System.out.println("Estou quase conseguindo conexão!");
            return true;
        }
        catch (SQLException e){
                System.out.println("Erro na conexão com o Banco: "+e.getMessage());
                return false;
        }

    }

    public static Connection getConexao() {
        System.out.println("Método banco conexao");
        return BancodeDados.conexao;
    }


    public boolean adicionarUsuario(Usuario usuario) {
        try {
            System.out.println("Inserindo...");
            Statement st = getConexao().createStatement();
            //ResultSet rs = st.executeQuery("INSERT INTO usuarios VALUES ('" + usuario.getPrimeiroNome() + "', '" + usuario.getUltimoNome() + "', '"+ usuario.getCPF() +"', '"+ usuario.getCargo()+" ') ");
            //System.out.println(rs);
            st.executeUpdate("INSERT INTO usuarios VALUES ('" + usuario.getPrimeiroNome() + "', '" + usuario.getUltimoNome() + "', '"+ usuario.getCPF() +"', '"+ usuario.getCargo()+" ') ");
            System.out.println("Acabei de inserir o novo usuário em nosso banco de dados!");
            return true;

        } catch (SQLException e) {
            System.out.println("Tenho que retornar false");
            return false;
        }
    }

    public static boolean adicionarDocumento(Documento documento) {
        try {
            System.out.println("Inserindo...");
            Statement st = getConexao().createStatement();
            //ResultSet rs = st.executeQuery("INSERT INTO usuarios VALUES ('" + usuario.getPrimeiroNome() + "', '" + usuario.getUltimoNome() + "', '"+ usuario.getCPF() +"', '"+ usuario.getCargo()+" ') ");
            //System.out.println(rs);
            st.executeUpdate("INSERT INTO documentos VALUES ('" + documento.getNumeroUnicoReferencia() + "', '" + documento.getTipoDeDocumento() + "', '"+ documento.getInteressado() +"', '"+ documento.getTipoDeArmazenamento() +"', '"+ documento.getDataArquivamento() +"', '"+ documento.getDescriçãoDocumento()+ "', '"+ documento.getLocalCompletoDeArmazenamento()+" ') ");
            System.out.println("Acabei de inserir o novo documento em nosso banco de dados!");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Usuario> getList(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            System.out.println("Tentando recuperar informações...");
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            System.out.println("Aguarde um pouco...");

            while(rs.next()){ //enquanto tiver uma posicao na array preenchida
                Usuario usr = new Usuario();
                usr.setPrimeiroNome(rs.getString("nome"));//string nome da coluna do banco
                usr.setUltimoNome(rs.getString("sobrenome"));//string nome da coluna do banco
                usr.setCPF(rs.getString("cpf"));//string nome da coluna do banco
                usr.setCargo(rs.getString("cargo"));//string nome da coluna do banco

                usuarios.add(usr);
            }
            rs.close();

        }catch (SQLException ex){
            System.out.println("Lista não retornada");
            return null;
        }
        return usuarios;
    }


    public List<Documento> getListDocumentos(){
        List<Documento> documentos = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            System.out.println("Tentando recuperar informações...");
            ResultSet rs = st.executeQuery("SELECT * FROM documentos");
            System.out.println("Aguarde um pouco...");

            while(rs.next()){ //enquanto tiver uma posicao na array preenchida
                Documento doc = new Documento();
                doc.setNumeroUnicoReferencia(rs.getString("numeroReferencia"));//string nome da coluna do banco
                doc.setTipoDeDocumento(rs.getString("tipo"));//string nome da coluna do banco
                doc.setInteressado(rs.getString("interessado"));//string nome da coluna do banco
                doc.setDescriçãoDocumento(rs.getString("descricao"));//string nome da coluna do banco

                documentos.add(doc);
            }
            rs.close();

        }catch (SQLException ex){
            System.out.println("Lista de documentos não retornada");
            return null;
        }
        return documentos;
    }










    /*public void relatorioUsuarios() {
        RelatorioUsuarioController usuario = new RelatorioUsuarioController();
        usuario.s
        String query = "SELECT nome FROM Pessoas WHERE Usuarios=?";
        try {
            Connection conn = null;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(usuario));
            ResultSet rs = ps.executeQuery();
            String nomes = "";
            while (rs.next()) {
                nomes += rs.getString("Nome") + "\t";
            }
            return nomes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    /*public static ResultSet relatorioUsuarios() throws SQLException {
            //String nomes = " ";
            System.out.println("coletando...");
            Statement st = getConexao().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

            /*while(rs.next()){
                System.out.println(rs);
                //nomes += rs.getString("nomes") + "\t";
            }
            System.out.println("Acabei de listar os usuarios do nosso banco de dados!");
            //System.out.println(nomes);
        return rs;
    }*/

    /*public static Usuario relatorioUsuarios(Usuario usuario) {
        String query = "SELECT nome FROM Pessoas WHERE Usuarios=?";
        try {
            Connection conn = null;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(usuario));
            ResultSet rs = ps.executeQuery();
            String nomes = "";
            while (rs.next()) {
                nomes += rs.getString("Nome") + "\t";
            }
            return nomes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
