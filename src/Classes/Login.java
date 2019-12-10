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

/**
 *
 * @author matheus
 */
public class Login {
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs = null;
    
    public boolean checkLogin(String login, String senha) {
        String sql = "select * from loginbd";
        
        conexao = Conector.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            while(rs.next()) {
                String lg = rs.getString("login");
                String psw = rs.getString("senha");
                
                if (lg.equals(login) && psw.equals(senha)) {
                    return true;
                }
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    
}
