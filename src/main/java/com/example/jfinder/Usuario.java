package com.example.jfinder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static com.example.jfinder.BancodeDados.conexao;

public class Usuario {

    //atributos
    private String primeiroNome;
    private String ultimoNome;
    private int  CPF;
    private String cargo;

    //construtores
    public Usuario (){

    }
    public Usuario(String NovoPrimeiroNome, String NovoUltimoNome, int novoCPF, String NovoCargo){
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

    public int getCPF() {
        return this.CPF;
    }
    public void setCPF(int CPF) {

        this.CPF = CPF;
    }

    public String getCargo() {

        return this.cargo;
    }

    public void setCargo(String cargo) {

        this.cargo = cargo;
    }


    public Usuario buscarCPF(int cpf){// Seleciona a lista de usuarios do DB
        Usuario usuarios = new Usuario();

        // verificar se a entrada nao esta vazia
        try{
            Statement st = conexao.createStatement();
            System.out.println("Tentando recuperar informações...");
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE " + "cpf='" + cpf + "'");
            System.out.println("Aguarde um pouco...");

            if(rs.next()){ //enquanto tiver uma posicao na array preenchida

                return new Usuario(rs.getString("nome"), rs.getString("sobrenome"), rs.getInt("cpf"), rs.getString("cargo"));

            }else{
                System.out.println("infelizmente nao o encontrei");
                return null;
            }

        }catch (SQLException ex){
            System.out.println("Lista não retornada");
            return null;
        }
    }

    public List<Usuario> buscarPorNome(String nome){// Seleciona a lista de usuarios do DB
        List<Usuario> usr = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE " + "nome='" + nome + "'");
            System.out.println("Buscando...");

            while(rs.next()){ //enquanto tiver uma posicao na array preenchida

                Usuario usuario = new Usuario();
                usuario.setPrimeiroNome(rs.getString("nome"));//string nome da coluna do banco
                usuario.setUltimoNome(rs.getString("sobrenome"));//string nome da coluna do banco
                usuario.setCPF(rs.getInt("cpf"));//string nome da coluna do banco
                usuario.setCargo(rs.getString("cargo"));

                usr.add(usuario);
            }
            rs.close();

        }catch (SQLException ex){
            System.out.println("Infelizmente nao encontrei o usuario com esse nome");
            return null;
        }
        return usr;
    }

    public List<Usuario> buscarPorSobrenome(String sobrenome){// Seleciona a lista de usuarios do DB
        List<Usuario> usr = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE " + "sobrenome='" + sobrenome + "'");
            System.out.println("Buscando...");

            while(rs.next()){ //enquanto tiver uma posicao na array preenchida

                Usuario usuario = new Usuario();
                usuario.setPrimeiroNome(rs.getString("nome"));//string nome da coluna do banco
                usuario.setUltimoNome(rs.getString("sobrenome"));//string nome da coluna do banco
                usuario.setCPF(rs.getInt("cpf"));//string nome da coluna do banco
                usuario.setCargo(rs.getString("cargo"));

                usr.add(usuario);
            }
            rs.close();

        }catch (SQLException ex){
            System.out.println("Infelizmente nao encontrei o usuario com esse sobrenome");
            return null;
        }
        return usr;
    }

    public List<Usuario> buscaPorCargo(String cargo){// Seleciona a lista de usuarios do DB
        List<Usuario> usr = new ArrayList<>();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE " + "cargo='" + cargo + "'");
            System.out.println("Buscando...");

            while(rs.next()){ //enquanto tiver uma posicao na array preenchida

                Usuario usuario = new Usuario();
                usuario.setPrimeiroNome(rs.getString("nome"));//string nome da coluna do banco
                usuario.setUltimoNome(rs.getString("sobrenome"));//string nome da coluna do banco
                usuario.setCPF(rs.getInt("cpf"));//string nome da coluna do banco
                usuario.setCargo(rs.getString("cargo"));

                usr.add(usuario);
            }
            rs.close();

        }catch (SQLException ex){
            System.out.println("Infelizmente nao encontrei o usuario com esse sobrenome");
            return null;
        }
        return usr;
    }


    public void mostraUsuario(){// apenas para terminal
        System.out.println("Nome :" + getPrimeiroNome());
        System.out.println("Sobrenome :" + getUltimoNome());
        System.out.println("CPF :" + getCPF());
        System.out.println("Cargo :" + getCargo());
    }
}