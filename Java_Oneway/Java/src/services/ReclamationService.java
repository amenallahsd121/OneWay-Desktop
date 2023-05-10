 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services; 
import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author hp
 */
public class ReclamationService   {
Connection cnx;

    public ReclamationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    
    
    
    public void ajouter(Reclamation t) throws SQLException {
        

        String req = "INSERT INTO reclamation (id_user,text_rec,sujet) VALUES("
                + "'" + t.getId_user()+ "','" + t.getText_rec() + "','" + t.getSujet() + "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
  
    }
    
    

    public boolean modifier(Reclamation t) throws SQLException {
          boolean ok = false;
          try
          {
             
        String req = " UPDATE reclamation SET id_user = ? , text_rec = ? , sujet= ?  where id_reclamation = ? ";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setInt(1, t.getId_user());
        vs.setString(2, t.getText_rec());
        vs.setString(3, t.getSujet());
        vs.setInt(4, t.getId_rec());
        vs.executeUpdate();
         ok = true;
        } catch (SQLException ex) {
             System.out.println("error in update" + ex);
        }
        return ok;  
        
    }
    
    
    

  
    public boolean supprimer(Reclamation t) {
        boolean ok = false;
        try {
         String req = " DELETE FROM reclamation where id_reclamation = ?   ";
         
            PreparedStatement vs = cnx.prepareStatement(req);
             vs.setInt(1, t.getId_rec());
            vs.executeUpdate();
            ok= true;
           
        }
        catch ( SQLException ex){
            System.out.println("error in delete"+ex);
        
           
        }
      
        return ok;
    }
    
    
    

    
    public List<Reclamation> recuperer() throws SQLException {
          List<Reclamation> Reclamation = new ArrayList<>();
        String s = "select * from reclamation ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reclamation R = new Reclamation();
            
            R.setId_rec(rs.getInt("id_reclamation"));
            R.setId_user(rs.getInt("id_user"));
            R.setSujet(rs.getString("sujet"));
            R.setText_rec(rs.getString("text_rec"));
            
            
            
            Reclamation.add(R);
            
        }
        return Reclamation;
    }
    
    
    
    
    
    
    
     public Reclamation recherche(int id) {
        Reclamation R = null;
        String Req = "select * from reclamation where id_reclamation= " + id + "";
                  
   
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {

               R = new Reclamation(res.getInt(1),res.getInt(2), res.getString(3), res.getString(4));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return R;
    }
    
    
    
    
     public ObservableList<Integer> getidclient() {
       
        String Req = "select id from utilisateur ";
                  
      ObservableList<Integer> l = FXCollections.observableArrayList();
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {
                l.add(res.getInt(1));
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }
     
     /////////////////////////////////////////////////////////////////////////////////////////////
     
     
     public String getClientNameById (int id) {
        String R = null;
        String Req = "select name from utilisateur where id = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

               R =(res.getString("name")); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return R;
    }
     
     
     
            public ObservableList<Integer> GetALLReclamationID() {
       
        String Req = "select id_reclamation from reclamation ";
                  
      ObservableList<Integer> l = FXCollections.observableArrayList();
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {
                l.add(res.getInt(1));
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }
     
     
     
     
      public List<Reclamation> AllReclamationNonTraiteColis(List <Integer> L) throws SQLException {
      
         List<Reclamation> Recla = new ArrayList<>();
         
         
         
         for(int i=0;i<L.size();i++)
         {
             
             
        String s = "select * from reclamation where id_reclamation = " + L.get(i) + "";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reclamation R = new Reclamation();
            R.setId_rec(rs.getInt("id_reclamation"));
            R.setId_user(rs.getInt("id_user"));
            R.setSujet(rs.getString("sujet"));
            R.setText_rec(rs.getString("text_rec"));      
            Recla.add(R);
            
         }    
        }
         
        return Recla;
    } 
      
      
      
      public Reclamation GetRec (int id)  {
       Reclamation Recla = null;
        String s = "select * from reclamation where id_reclamation = " + id + "";
       try {
       
        Statement st = cnx.createStatement();
        ResultSet res =  st.executeQuery(s);
        while(res.next()){
           
           Recla = new Reclamation (res.getInt(1),res.getInt(2),res.getString(4), res.getString(3) );
   
         }  
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         
        return Recla;
    } 
      
      
      
      
      
      
       public Reclamation Verifrec (List <String> S) throws SQLException {
      
           Reclamation R = null;
      
       for(int i=0; i<S.size();i++)
       {
        String s = "  select * from reclamation where text_rec like '%"+ S.get(i) +"%'    " ;
           Statement st = cnx.createStatement();
        ResultSet res =  st.executeQuery(s);
  
        while(res.next()){
    
            R = new Reclamation (res.getInt(1),res.getInt(2),res.getString(4), res.getString(3) );
         }    
         }
        return R;
    } 
      
       
      
      
       
       
       
       
       
       
       
        public int Stats(String par,String field) {
     String s  = "select count(*) from reclamation where "+field+""+ "=" +"'"+par+"'";
   
  
      try {

        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);

            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
                return num;
 
            }
        } catch (SQLException ex) {
            
        }
        return 0 ;
    }
        
        
        
       public List<Reclamation> recuperer(int sizee,String word)  throws SQLException{
         List<Reclamation> users = new ArrayList<>();
        String s = "select * from reclamation";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
           Boolean find = true;
            Reclamation t = new Reclamation();
            t.setId_rec(rs.getInt("id_reclamation"));
            t.setId_user(rs.getInt("id_user"));
            t.setText_rec(rs.getString("text_rec"));
            t.setSujet(rs.getString("sujet"));

            //System.out.println(word );
            System.out.println(sizee );

            String name = getClientNameById(t.getId_user());
            //String ww = word + "hhh";
            //System.out.println(ww.charAt(2) + " chhh");
            //if(sizee == 1)
            {
             for(int i=0; i<sizee && find == true ; i++)
             {
                System.out.println(word.charAt(i));
                System.out.println(word);
                 if(name.charAt(i) == word.charAt(i))
                 {
                     System.out.println("in");
                     find = true;
                 }
                 else
                 {
                     System.out.println("out");
                    find =false;
                 }

             }
                System.out.println(find);
             if(find == true)
             {
                 users.add(t);
             }

            }

        }
        return users;
    }
       
            
       public List<Reclamation> triUp()  throws SQLException{
         List<Reclamation> rect = new ArrayList<>();
        String s = "select * from reclamation ORDER BY text_rec ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reclamation t = new Reclamation();
            t.setId_user(rs.getInt("id_user"));
            t.setText_rec(rs.getString("text_rec"));
            t.setSujet(rs.getString("sujet"));
        rect.add(t);
            
        }
        return rect;
    }

     public List<Reclamation> triDown()  throws SQLException{
          List<Reclamation> rect = new ArrayList<>();
        String s = "select * from reclamation ORDER BY text_rec DESC";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reclamation t = new Reclamation();
            t.setId_user(rs.getInt("id_user"));
            t.setText_rec(rs.getString("text_rec"));
            t.setSujet(rs.getString("sujet"));
        rect.add(t);
            
        }
        return rect;
    }

     
        
    }
    

