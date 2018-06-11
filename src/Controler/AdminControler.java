/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Admin;
import technique.Crude;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author OMRANI
 */
public class AdminControler implements IDAO<Admin>{
    
    private Crude crude = new Crude();

    @Override
    public boolean insert(Admin a) {
         String sql =
                "INSERT INTO  admin( nom, prenom, username, password,email,tel) "
                + "VALUES ('"+ a.getNom()+ "','" + a.getPrenom()+ "','" + a.getLogin()+ "','" + a.getPassword()+"','" + a.getEmail()+"',"+a.getTel()+")";
        //System.out.println(sql);
        return crude.exeCreate(sql); 
    }

    @Override
    public boolean update(Admin a, int id) {
        String sql =
            "UPDATE admin SET nom='" + a.getNom() + "',prenom='" + a.getPrenom()+ "',username='" + a.getLogin()+ "',password='" + a.getPassword()+"',email='" + a.getEmail()+"',tel="+a.getTel()+" WHERE id="+id;
            //System.out.println(sql);
            return crude.exeUpdate(sql);
    }

    @Override
    public boolean delete(Admin e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Admin> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin findByINT(int id) {
        Admin user = null;
        try {
            String sql = "SELECT * FROM admin WHERE id="+id;
            ResultSet rs = crude.exeRead(sql);
                while (rs.next()) {
                    user = new Admin();
                    user.setIdU(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setLogin(rs.getString(4));
                    user.setPassword(rs.getString(5));
                    user.setEmail(rs.getString(6));
                    user.setTel(rs.getInt(7));
                   
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;    }

    @Override
    public List<Admin> findByString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Admin findUtilisateurByLoginMdp(String login, String mdp){
        Admin user = null;
        try {
            String sql = "SELECT * FROM admin WHERE username = '"+login+"' AND password = '"+mdp+"'";
            ResultSet rs = crude.exeRead(sql);
                while (rs.next()) {
                    user = new Admin();
                    user.setIdU(rs.getInt(1));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setLogin(rs.getString(4));
                    user.setPassword(rs.getString(5));
                    user.setEmail(rs.getString(6));
                    user.setTel(rs.getInt(7));
                   
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;
    }

}
