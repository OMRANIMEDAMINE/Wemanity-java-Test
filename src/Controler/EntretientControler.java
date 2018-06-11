/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import Model.Candidat;
import Model.Entretient;
import technique.Crude;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author OMRANI
 */
public class EntretientControler implements IDAO<Entretient>{
    
    private Crude crude = new Crude();
    
    @Override
    public boolean insert(Entretient a) {
        String sql =
        "INSERT INTO  entretient(candidat,  date,  heure,  description, qualite,  defaut,  decision,  note) "
        + "VALUES ("+ a.getCandidat()+ ",'" + a.getDate()+"','"+a.getHeure()+"'," + a.getDescription()+","
                + "'" + a.getQualite()+ "', '" + a.getDefaut()+ "','" + a.getDecision()+ "'," + a.getNote()+ ")";
        //System.out.println(sql);
        return crude.exeCreate(sql);
    }

      
    
    @Override
    public List<Entretient> findByString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Entretient findByINT(int var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
            
    public List<Entretient> findByCandidat(int c){
        
            try {
                Date date = new Date();
            String format = "yyyy-MM-dd" ;  //H:mm:ss";
             Locale locale = Locale.getDefault();
            SimpleDateFormat formater = new SimpleDateFormat( format, locale );  
            String sToday = formater.format( date );      
            String sql = "SELECT * FROM entretient WHERE candidat   = "+c;
            ResultSet rs = crude.exeRead(sql);
            List<Entretient> liste = new ArrayList<Entretient>();
            CandidatControler CDAO= new CandidatControler();
            while (rs.next()) {
                Entretient v = new Entretient();
                  v.setId(rs.getInt(1)); 
                int idCandidat=(rs.getInt(2));
                v.setCandidat(CDAO.findByINT(idCandidat)  );                
                v.setDate(rs.getString(3));
                v.setHeure(rs.getString(4));             
                v.setDescription(rs.getString(5));
                v.setQualite(rs.getString(6));
                v.setDefaut(rs.getString(7));    
                v.setDecision(rs.getString(8));    
                v.setNote(rs.getInt(9));  ;                     
                liste.add(v);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(EntretientControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
    }

    @Override
    public boolean update(Entretient a, int id) {
        String sql =       
           "UPDATE entretient SET candidat=" + a.getCandidat() + ", date='" + a.getDate()+ "',"
           + "heure='" + a.getHeure()+ "',   description='" + a.getDescription()+ "',"
           + "qualite='" + a.getQualite()+ "',defaut='" + a.getDefaut()+ "', decision='"
           + a.getDecision()+ "', note = " + a.getNote()+ " WHERE id="+ id ;
        //System.out.println(sql);
        return crude.exeUpdate(sql);    }

    @Override
    public boolean delete(Entretient a) {
        String sql = "DELETE FROM entretient WHERE id=" + a.getId();
        //System.out.println(sql);
        return crude.exeDelete(sql);    }

    @Override
    public List<Entretient> getAll() {
  try {
                 
            String sql = "SELECT * FROM entretient order by date ";
            ResultSet rs = crude.exeRead(sql);
            List<Entretient> liste = new ArrayList<Entretient>();
            CandidatControler CDAO= new CandidatControler();
            while (rs.next()) {
                Entretient v = new Entretient();   
                    v.setId(rs.getInt(1)); 
                int idCandidat=(rs.getInt(2));
                v.setCandidat(CDAO.findByINT(idCandidat)  );                
                v.setDate(rs.getString(3));
                v.setHeure(rs.getString(4));             
                v.setDescription(rs.getString(5));
                v.setQualite(rs.getString(6));
                v.setDefaut(rs.getString(7));    
                v.setDecision(rs.getString(8));    
                v.setNote(rs.getInt(9));  ;        
                liste.add(v);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(EntretientControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
    }
    public List<Entretient> findToday(){

            try {
            Date date = new Date();
            String format = "yyyy-MM-dd" ;  //H:mm:ss";
             Locale locale = Locale.getDefault();
            SimpleDateFormat formater = new SimpleDateFormat( format, locale );  
            String sToday = formater.format( date );  
            
            String sql = "SELECT * FROM entretient WHERE date   = '"+sToday+"'" ;
            //System.out.print(sql);
            ResultSet rs = crude.exeRead(sql);
            List<Entretient> liste = new ArrayList<Entretient>();
            CandidatControler CDAO= new CandidatControler();
            while (rs.next()) {
                Entretient v = new Entretient();
                v.setId(rs.getInt(1)); 
                int idCandidat=(rs.getInt(2));
                v.setCandidat(CDAO.findByINT(idCandidat)  );                
                v.setDate(rs.getString(3));
                v.setHeure(rs.getString(4));             
                v.setDescription(rs.getString(5));
                v.setQualite(rs.getString(6));
                v.setDefaut(rs.getString(7));    
                v.setDecision(rs.getString(8));    
                v.setNote(rs.getInt(9));                   
                liste.add(v);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(EntretientControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
    }
    
    
    public List<Entretient> findEntretientBydate(String de, String a){
        
            try {
               
            String sql = "SELECT * FROM entretient WHERE date   >= '"+de+"' and  date   <= '"+a+"' " ;
            ResultSet rs = crude.exeRead(sql);
            List<Entretient> liste = new ArrayList<Entretient>();
            CandidatControler CDAO= new CandidatControler();
            while (rs.next()) {
                Entretient v = new Entretient();
                v.setId(rs.getInt(1)); 
                int idCandidat=(rs.getInt(2));
                v.setCandidat(CDAO.findByINT(idCandidat)  );                
                v.setDate(rs.getString(3));
                v.setHeure(rs.getString(4));             
                v.setDescription(rs.getString(5));
                v.setQualite(rs.getString(6));
                v.setDefaut(rs.getString(7));    
                v.setDecision(rs.getString(8));    
                v.setNote(rs.getInt(9));                   
                liste.add(v);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(EntretientControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
    }
    
}
