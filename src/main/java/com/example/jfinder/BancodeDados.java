package com.example.jfinder;
//import java.sql.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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


    public static boolean adicionarUsuario(Usuario usuario) {
        try {
            System.out.println("Inserindo...");
            Statement st = getConexao().createStatement();
            //ResultSet rs = st.executeQuery("INSERT INTO usuarios VALUES ('" + usuario.getPrimeiroNome() + "', '" + usuario.getUltimoNome() + "', '"+ usuario.getCPF() +"', '"+ usuario.getCargo()+" ') ");
            //System.out.println(rs);
            st.executeUpdate("INSERT INTO usuarios VALUES ('" + usuario.getPrimeiroNome() + "', '" + usuario.getUltimoNome() + "', '"+ usuario.getCPF() +"', '"+ usuario.getCargo()+" ') ");
            System.out.println("Acabei de inserir o novo usuário em nosso banco de dados!");
            return true;
        } catch (SQLException e) {
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

}
