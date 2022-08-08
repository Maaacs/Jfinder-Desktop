package com.example.jfinder;
//import java.sql.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BancodeDados {
    String user;

    public BancodeDados(String novoUser){
        this.setUser(novoUser);
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String novoUser) {
        this.user = novoUser;
        //this.user = "Max";
    }

   /* private String getPass() {
        return pass;
    }

    private void setPass(String pass) {
        this.pass = "123";
    }*/

    /*public boolean conecta(){
        if (this.getUser() == "Max"){
            return true;
        }
        else{
            return false;
        }
    }*/

}
