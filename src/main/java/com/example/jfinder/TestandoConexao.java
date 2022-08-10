package com.example.jfinder;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class TestandoConexao {

    String user = "max";
    String pass = "10121114";

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
        System.out.println(BancodeDados.getConexao()+"oi");
    }
}


