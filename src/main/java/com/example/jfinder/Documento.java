package com.example.jfinder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.jfinder.BancodeDados.conexao;


public class Documento {


    //atributos
    private String numeroUnicoReferencia;
    private String tipoDeDocumento;
    private String interessado;
    private String tipoDeArmazenamento;
    private String dataArquivamento;
    private String descriçãoDocumento;
    private String localCompletoDeArmazenamento;

    public Documento (){

    }

    //Construtor que inicializa o objeto Documento
    Documento(String NovoNumeroUnicoReferencia, String NovoTipoDeDocumento, String NovoInteressado, String NovoTipoDeArmazenamento, String NovoDataArquivamento,
              String NovoDescriçãoDocumento, String NovoLocalCompletoDeArmazenamento){
        this.setNumeroUnicoReferencia(NovoNumeroUnicoReferencia);
        this.setDataArquivamento(NovoDataArquivamento);
        this.setInteressado(NovoInteressado);
        this.setTipoDeDocumento(NovoTipoDeDocumento);
        this.setDescriçãoDocumento(NovoDescriçãoDocumento);
        this.setTipoDeArmazenamento(NovoTipoDeArmazenamento);
        this.setLocalCompletoDeArmazenamento(NovoLocalCompletoDeArmazenamento);
    }

    //Get Set dos atributos

    public String getNumeroUnicoReferencia() {

        return numeroUnicoReferencia;
    }
    public void setNumeroUnicoReferencia(String numeroUnicoReferencia) {
        this.numeroUnicoReferencia = numeroUnicoReferencia;
    }

    public String getDataArquivamento() {

        return dataArquivamento;
    }

    public void setDataArquivamento(String dataArquivamento) {

        this.dataArquivamento = dataArquivamento;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {

        this.interessado = interessado;
    }

    public String getTipoDeDocumento() {

        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {

        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getDescriçãoDocumento() {

        return descriçãoDocumento;
    }

    public void setDescriçãoDocumento(String descriçãoDocumento) {

        this.descriçãoDocumento = descriçãoDocumento;
    }

    public String getTipoDeArmazenamento() {

        return tipoDeArmazenamento;
    }

    public void setTipoDeArmazenamento(String tipoDeArmazenamento) {

        this.tipoDeArmazenamento = tipoDeArmazenamento;
    }

    public String getLocalCompletoDeArmazenamento() {

        return localCompletoDeArmazenamento;
    }

    public void setLocalCompletoDeArmazenamento(String localCompletoDeArmazenamento) {
        this.localCompletoDeArmazenamento = localCompletoDeArmazenamento;
    }


    public Documento buscarPorNumeroReferencia(String numeroDeReferencia){// Seleciona a lista de usuarios do DB
        Documento docs = new Documento();
        try{
            Statement st = conexao.createStatement();
            System.out.println("Tentando recuperar informações...");
            ResultSet rs = st.executeQuery("SELECT * FROM documentos WHERE " + "numeroReferencia='" + numeroDeReferencia + "'");
            System.out.println("Aguarde um pouco...");

            if(rs.next()){ //enquanto tiver uma posicao na array preenchida

                return new Documento(rs.getString("numeroReferencia"), rs.getString("tipo"), rs.getString("interessado"), rs.getString("tipoArmazenamento"), rs.getString("dataArquivamento"), rs.getString("descricao"), rs.getString("localCompletoArmazenamento"));

            }else{
                System.out.println("infelizmente nao encontrei o documento");
                return null;
            }

        }catch (SQLException ex){
            System.out.println("Lista não retornada");
            return null;
        }
    }

    public List<Documento> buscarPorInteressado(String interessado){// Seleciona a lista de usuarios do DB
        List<Documento> docs = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM documentos WHERE " + "interessado='" + interessado + "'");
            System.out.println("Buscando...");

            while(rs.next()){ //enquanto tiver uma posicao na array preenchida

                Documento doc = new Documento();
                doc.setNumeroUnicoReferencia(rs.getString("numeroReferencia"));//string nome da coluna do banco
                doc.setTipoDeDocumento(rs.getString("tipo"));//string nome da coluna do banco
                doc.setInteressado(rs.getString("interessado"));//string nome da coluna do banco
                doc.setTipoDeArmazenamento(rs.getString("tipoArmazenamento"));
                doc.setDataArquivamento(rs.getString("dataArquivamento"));
                doc.setDescriçãoDocumento(rs.getString("descricao"));//string nome da coluna do banco
                doc.setLocalCompletoDeArmazenamento(rs.getString("localCompletoArmazenamento"));

                docs.add(doc);
            }
            rs.close();

        }catch (SQLException ex){
            System.out.println("Infelizmente nao encontrei o documento com esse interessado");
            return null;
        }
        return docs;
    }


    public List<Documento> buscarPorTipoDeDocumento(String tipoDocumento){// Seleciona a lista de usuarios do DB
        List<Documento> documentos = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM documentos WHERE " + "tipo='" + tipoDocumento + "'");
            System.out.println("Buscando...");

            while(rs.next()){
                 //enquanto tiver uma posicao na array preenchida
                    Documento doc = new Documento();
                    doc.setNumeroUnicoReferencia(rs.getString("numeroReferencia"));//string nome da coluna do banco
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
            System.out.println("Infelizmente nao encontrei esse tipo de documento");
            return null;
        }
        return documentos;
    }

    public List<Documento> buscarPorPalavraChave(String palavraChave){// Seleciona a lista de usuarios do DB
        List<Documento> documentos = new ArrayList<>();

        try{
            Statement st = conexao.createStatement();
            String sql = "SELECT * FROM documentos WHERE descricao LIKE ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + palavraChave + "%");
            ResultSet rs = stmt.executeQuery();
            System.out.println("Buscando...");

            while(rs.next()){
                //enquanto tiver uma posicao na array preenchida
                Documento doc = new Documento();
                doc.setNumeroUnicoReferencia(rs.getString("numeroReferencia"));//string nome da coluna do banco
                doc.setTipoDeDocumento(rs.getString("tipo"));//string nome da coluna do banco
                doc.setInteressado(rs.getString("interessado"));//string nome da coluna do banco
                doc.setTipoDeArmazenamento(rs.getString("tipoArmazenamento"));
                doc.setDataArquivamento(rs.getString("dataArquivamento"));
                doc.setDescriçãoDocumento(rs.getString("descricao"));//string nome da coluna do banco
                doc.setLocalCompletoDeArmazenamento(rs.getString("localCompletoArmazenamento"));

                documentos.add(doc);

            }
            rs.close();
        }
        catch (SQLException ex){
            System.out.println("Infelizmente nao encontrei o documento com essa palavra-chave");
            return null;
        }
        return documentos;
    }




    public void mostraDocumento(){// Apenas para o terminal
        System.out.println("Numero de Referência :" + getNumeroUnicoReferencia());
        System.out.println("Tipo de documento :" + getTipoDeDocumento());
        System.out.println("Interessado :" + getInteressado());
        System.out.println("Tipo de armazenamento :" + getTipoDeArmazenamento());
        System.out.println("Data de arquivamento :" + getDataArquivamento());
        System.out.println("Descrição :" + getDescriçãoDocumento());
        System.out.println("Local de armazenamento :" + getLocalCompletoDeArmazenamento());

    }
}