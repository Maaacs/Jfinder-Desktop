/*package com.example.jfinder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class UsuarioDao {
    public List<Usuario> getList() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            Connection con = null;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { //enquanto tiver uma posicao na array preenchida
                Usuario usr = new Usuario();
                usr.setPrimeiroNome(rs.getString("nome"));//string nome da coluna do banco
                usr.setUltimoNome(rs.getString("sobrenome"));//string nome da coluna do banco
                usr.setCPF(rs.getString("cpf"));//string nome da coluna do banco
                usr.setCargo(rs.getString("cargo"));//string nome da coluna do banco

                usuarios.add(usr);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Lista não retornada");
            return null;
        }
        return usuarios;
    }
}*/

