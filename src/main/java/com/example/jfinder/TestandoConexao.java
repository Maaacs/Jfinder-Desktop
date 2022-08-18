package com.example.jfinder;

public class TestandoConexao {

    String user = "usuario_criado";
    String pass = "senha_criada";

    TestandoConexao(){

    }

    public boolean verificarConexao() {
        BancodeDados bd = new BancodeDados(this.user, this.pass);
        if(bd.conecta()) {
            System.out.println("Conectei :)");
            return true;
        }else {
            System.out.println("Não conectei :(");
            return false;
        }
    }

    public static void main(String[] args) {
        TestandoConexao banco = new TestandoConexao();
        banco.verificarConexao();
        System.out.println(BancodeDados.getConexao());
    }
}


