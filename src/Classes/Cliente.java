/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matheus
 */
public class Cliente {
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs = null;
    
    public String cadastrarCliente(String nome, String cpf, String idade, String end, String tel) {
        String sql = "insert into cliente(nome, cpf, idade, endereco, tel)"
                + "values(?, ?, ?, ?, ?)";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, idade);
            pst.setString(4, end);
            pst.setString(5, tel);

            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                return "Cliente cadastro com sucesso!";
            else
                return "Não foi possível cadastrar o cliente!";

        } catch(SQLException ex) {
            return null;
        } finally {
            Conector.desconectar(conexao);
        }
    }
    
    public boolean checaId(String id){
        String sql = "select * from cliente where id = ?";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, id);
            
            rs = pst.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            Conector.desconectar(conexao);
            return false;
        } finally {
            Conector.desconectar(conexao);
        }
    }
    
    public ResultSet litar() {
        String sql = "select * from cliente";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            rs = pst.executeQuery();
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            return rs;
        }
    }
    
    public ResultSet litar(String id) {
        String sql = "select * from cliente where id = ?";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, id);
            
            rs = pst.executeQuery();
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            return rs;
        }
    }
    
    public String delete(String id) {
        String sql = "delete from cliente where id = ?";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, id);
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                return "Cliente apagado com sucesso!";
            else
                return "Id inexistente!";
            
        } catch(SQLException ex) {
            return null;
        } finally {
            Conector.desconectar(conexao);
        }
    }
    
    public String atualizar(String nome, String cpf, String idade, String end, 
            String tel, String id) {
        String sql = "update cliente set nome =?, cpf = ?, idade = ?, endereco = ?, "
                + "tel = ? where id = ?";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, idade);
            pst.setString(4, end);
            pst.setString(5, tel);
            pst.setString(6, id);
            
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                return "Cliente atualizado com sucesso!";
            else
                return "Não foi possível atualizar este cliente!";
        } catch(SQLException ex) {
            System.out.println(ex);
            return null;
        } finally {
            Conector.desconectar(conexao);
        }
    }
}
