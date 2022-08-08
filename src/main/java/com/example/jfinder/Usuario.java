package com.example.jfinder;

public class Usuario {

    //atributos
    private String primeiroNome;
    private String ultimoNome;
    private String CPF;
    private String cargo;

    //construtores
    Usuario(String NovoPrimeiroNome, String NovoUltimoNome, String novoCPF, String NovoCargo){
        this.setPrimeiroNome(NovoPrimeiroNome);
        this.setUltimoNome(NovoUltimoNome);
        this.setCPF(novoCPF);
        this.setCargo(NovoCargo);
    }

    //Get Set dos atributos
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}