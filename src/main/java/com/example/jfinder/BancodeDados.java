package com.example.jfinder;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BancodeDados {
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
            System.out.println("Valide seu usuário para que eu possa me conectar!");
            return true;
        }
        catch (SQLException e){
                System.out.println("Falha na conexão com o servidor: "+e.getMessage());
                return false;
        }
    }

    public boolean desconecta() {
        try {
            conexao.close();
            System.out.println("Estou desconectando do servidor...");
            return true;
        }
        catch (SQLException e){
            System.out.println("Falha em me desconectar do servidor: "+e.getMessage());
            return false;
        }
    }

    public static Connection getConexao() {
        System.out.println("Método banco conexao");
        return BancodeDados.conexao;
    }


    public boolean adicionarUsuario(Usuario usuario) {

        String sql = "INSERT  INTO usuarios (nome , sobrenome , cpf , cargo) VALUES (?,?,?,?);";
        try {
            System.out.println("Inserindo dados...");
            PreparedStatement stmt = BancodeDados.getConexao().prepareStatement(sql);
            stmt.setString(1,usuario.getPrimeiroNome());
            stmt.setString(2,usuario.getUltimoNome());
            stmt.setInt(3,usuario.getCPF());
            stmt.setString(4,usuario.getCargo());

            stmt.execute();
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
            st.executeUpdate("INSERT INTO documentos VALUES ('" + documento.getNumeroUnicoReferencia() + "', '" + documento.getTipoDeDocumento() + "', '"+ documento.getInteressado() +"', '"+ documento.getTipoDeArmazenamento() +"', '"+ documento.getDataArquivamento() +"', '"+ documento.getDescriçãoDocumento()+ "', '"+ documento.getLocalCompletoDeArmazenamento()+" ') ");
            System.out.println("Acabei de inserir o novo documento em nosso banco de dados!");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Usuario> getListUsuarios(){// Seleciona toda a lista de usuarios do DB
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
                usr.setCPF(rs.getInt("cpf"));//string nome da coluna do banco
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


    public List<Documento> getListDocumentos(){ // Seleciona toda a lista de documentos do DB
        List<Documento> documentos = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            System.out.println("Tentando recuperar informações...");
            ResultSet rs = st.executeQuery("SELECT * FROM documentos");
            System.out.println("Aguarde um pouco...");

            while(rs.next()){ //enquanto tiver uma posicao na array preenchida
                Documento doc = new Documento();
                doc.setNumeroUnicoReferencia(rs.getInt("numeroReferencia"));//string nome da coluna do banco
                doc.setTipoDeDocumento(rs.getString("tipo"));//string nome da coluna do banco
                doc.setInteressado(rs.getString("interessado"));//string nome da coluna do banco
                doc.setTipoDeArmazenamento(rs.getString("tipoArmazenamento"));
                doc.setDataArquivamento(rs.getString("dataArquivamento"));
                doc.setDescriçãoDocumento(rs.getString("descricao"));//string nome da coluna do banco
                doc.setLocalCompletoDeArmazenamento(rs.getString("localCompletoArmazenamento"));

                documentos.add(doc);
            }
            rs.close();

        }catch (SQLException ex){
            System.out.println("Lista de documentos não retornada");
            return null;
        }
        return documentos;
    }

        public boolean removerUsuario(String cpf) {
            try {
                Statement st = BancodeDados.getConexao().createStatement();
                st.executeUpdate("DELETE FROM usuarios WHERE " + "cpf='" + cpf + "'");
                return true;

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

    public boolean removerDocumento(int numeroReferencia) {
        try {
            Statement st = BancodeDados.getConexao().createStatement();
            st.executeUpdate("DELETE FROM documentos WHERE " + "numeroReferencia='" + numeroReferencia + "'");
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    public boolean alterarUsuario(Usuario usuario) {

        String sql = "UPDATE usuarios SET nome = ? , sobrenome = ? ,  cargo = ? WHERE cpf = ?";
        try {
            System.out.println("Alterando dados...");
            PreparedStatement stmt = BancodeDados.getConexao().prepareStatement(sql);
            stmt.setString(1,usuario.getPrimeiroNome());
            stmt.setString(2,usuario.getUltimoNome());
            stmt.setString(3,usuario.getCargo());
            stmt.setInt(4,usuario.getCPF());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean alterarDocumento(Documento documento) {

        String sql = "UPDATE documentos SET tipo = ? ,  interessado = ? , tipoArmazenamento = ? , dataArquivamento = ? , descricao = ? , localCompletoArmazenamento = ? WHERE numeroReferencia = ?";
        try {
            System.out.println("Alterando dados...");
            PreparedStatement stmt = BancodeDados.getConexao().prepareStatement(sql);
            stmt.setString(1,documento.getTipoDeDocumento());
            stmt.setString(2,documento.getInteressado());
            stmt.setString(3,documento.getTipoDeArmazenamento());
            stmt.setString(4,documento.getDataArquivamento());
            stmt.setString(5,documento.getDescriçãoDocumento());
            stmt.setString(6,documento.getLocalCompletoDeArmazenamento());
            stmt.setInt(7,documento.getNumeroUnicoReferencia());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

}



















    /*public boolean adicionarUsuario(Usuario usuario) { // outra forma de fazer
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
    }*/