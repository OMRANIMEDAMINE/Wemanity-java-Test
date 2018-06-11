/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Candidat;
import technique.Crude;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OMRANI
 */
public class CandidatControler implements IDAO<Candidat>{
 private Crude crude = new Crude();
    @Override
    public boolean insert(Candidat a) {
        String sql =
                "INSERT INTO candidat( nom,  prenom, datenaissance ,  pays,  ville,  activite,  etat,  tel,  mail) "
                + "VALUES ('"+ a.getNom() + "','" + a.getPrenom() + "','" + a.getDatenaissance() + "','" + a.getPays() + "','" + a.getVille()+ "','" + a.getActivite()+ "',"
                + "'" + a.getEtat()+ "','" + a.getTel()+ "','" + a.getMail()+ "')";
        //System.out.println(sql);
        return crude.exeCreate(sql);
    }

    @Override
    public boolean update(Candidat a, int id ) {
        String sql =
           "UPDATE candidat SET nom='" + a.getNom() + "',prenom='" + a.getPrenom() + "',"
           + "datenaissance='" + a.getDatenaissance() + "',pays='" + a.getPays() + "',  ville='" + a.getVille() + "',"
           + "activite='" + a.getActivite() + "',etat='" + a.getEtat()+ "', tel='"
           + a.getTel()+ "', mail = '" + a.getMail()+ "' WHERE id="+ id ;
        //System.out.println(sql);
        return crude.exeUpdate(sql);
    }
    
 
    
    
    @Override
    public boolean delete(Candidat a) {
        String sql = "DELETE FROM candidat WHERE id=" + a.getId();
        //System.out.println(sql);
        return crude.exeDelete(sql);
    }
   
    


    @Override
    public List<Candidat> getAll() {
        try {
            String sql = "SELECT * FROM candidat ORDER BY nom";
            ResultSet rs = crude.exeRead(sql);
            List<Candidat> liste = new ArrayList<Candidat>();
            while (rs.next()) {
                Candidat v = new Candidat();
                    v.setId(rs.getInt(1));
                    v.setNom(rs.getString(2));
                    v.setPrenom(rs.getString(3));
                    v.setDatenaissance(rs.getString(4));
                    v.setPays(rs.getString(5));
                    v.setVille(rs.getString(6));
                    v.setActivite(rs.getString(7));
                    v.setEtat(rs.getString(8));
                    v.setTel(rs.getString(9));
                    v.setMail(rs.getString(10));
                liste.add(v);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(CandidatControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

      


    @Override
    public List<Candidat> findByString(String string) {
 try {
            String sql = "SELECT * FROM candidat WHERE nom Like '%"+string+"%' or prenom Like '%"+string+"%' ORDER BY nom desc";
            ResultSet rs = crude.exeRead(sql);
            List<Candidat> liste = new ArrayList<Candidat>();
            while (rs.next()) {
                Candidat v = new Candidat();
                    v.setId(rs.getInt(1));
                    v.setNom(rs.getString(2));
                    v.setPrenom(rs.getString(3));
                    v.setDatenaissance(rs.getString(4));
                    v.setPays(rs.getString(5));
                    v.setVille(rs.getString(6));
                    v.setActivite(rs.getString(7));
                    v.setEtat(rs.getString(8));
                    v.setTel(rs.getString(9));
                    v.setMail(rs.getString(10));
                liste.add(v);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(CandidatControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }

    @Override
    public Candidat findByINT(int var) {
        Candidat v = new Candidat();
        try {
            String sql = "SELECT * FROM candidat WHERE id="+var;
            ResultSet rs = crude.exeRead(sql);
                while (rs.next()) {                                    
                    v.setId(rs.getInt(1));
                    v.setNom(rs.getString(2));
                    v.setPrenom(rs.getString(3));
                    v.setDatenaissance(rs.getDate(4).toString());
                    v.setPays(rs.getString(5));
                    v.setVille(rs.getString(6));
                    v.setActivite(rs.getString(7));
                    v.setEtat(rs.getString(8));
                    v.setTel(rs.getString(9));
                    v.setMail(rs.getString(10));
                   
                }
           
        } catch (SQLException ex) {
            Logger.getLogger(AdminControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return v;
    }

     

    


    
}
