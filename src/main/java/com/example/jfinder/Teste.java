package com.example.jfinder;

import java.util.List;

public class Teste {


    public static void main (String[] args){
        BancodeDados bd = new BancodeDados("max","10121114");
        bd.conecta();
        //Usuario usr = new Usuario();
        List<Usuario> usuarios = new BancodeDados().getListUsuarios();

        if (usuarios != null){
            for (int i = 0; i < usuarios.size(); i++){
                usuarios.get(i).mostraUsuario();

                System.out.println("------------");
            }
        }else{
            System.out.println("Teste: Lista nula");

        }
    }

}
