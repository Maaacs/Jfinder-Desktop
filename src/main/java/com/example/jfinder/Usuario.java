package com.example.jfinder;

public class Usuario {

    //atributos
    private String primeiroNome;
    private String ultimoNome;
    private String CPF;
    private String cargo;

    //construtores
    public Usuario (){

    }
    public Usuario(String NovoPrimeiroNome, String NovoUltimoNome, String novoCPF, String NovoCargo){
        this.setPrimeiroNome(NovoPrimeiroNome);
        this.setUltimoNome(NovoUltimoNome);
        this.setCPF(novoCPF);
        this.setCargo(NovoCargo);
    }

    //Get Set dos atributos
    public String getPrimeiroNome() {

        return this.primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {

        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {

        return this.ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {

        this.ultimoNome = ultimoNome;
    }

    public String getCPF() {
        return this.CPF;
    }
    public void setCPF(String CPF) {

        this.CPF = CPF;
    }

    public String getCargo() {

        return this.cargo;
    }

    public void setCargo(String cargo) {

        this.cargo = cargo;
    }

    public void mostraUsuario(){
        System.out.println("Nome :" + getPrimeiroNome());
        System.out.println("Sobrenome :" + getUltimoNome());
        System.out.println("CPF :" + getCPF());
        System.out.println("Cargo :" + getCargo());
    }
}