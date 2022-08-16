package com.example.jfinder;

import java.util.List;

public class Teste {


    public static void main (String[] args){
        BancodeDados bd = new BancodeDados("max","10121114");
        bd.conecta();

        Usuario p = new Usuario();

        //p.setCPF("9");
        p.setPrimeiroNome("joao");
        p.setUltimoNome("Barroso");
        p.setCargo("Professor");


        if (bd.alterarUsuario(p)){
            System.out.println("alterado");
        }
        else{
            System.out.println("nao alterado");
        }
    }

}
