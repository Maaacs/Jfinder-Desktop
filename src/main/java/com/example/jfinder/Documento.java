package com.example.jfinder;

import java.util.Date;

public class Documento {


    //atributos
    private String numeroUnicoReferencia;
    private String tipoDeDocumento;
    private String interessado;
    private String tipoDeArmazenamento;
    private String dataArquivamento;
    private String descriçãoDocumento;
    private String localCompletoDeArmazenamento;

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
}