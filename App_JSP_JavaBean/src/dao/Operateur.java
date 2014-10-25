package dao;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.Utilisateur;

public class Operateur {
	
	private PreparedStatement pr = null;
    
	
	
	public ArrayList<Produit> getAllProduit(){
		
	   ArrayList<Produit> listproduit = new ArrayList<Produit>();
		
	   try{
			
		     Class.forName("com.mysql.jdbc.Driver");
		     Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
			  pr =  (PreparedStatement) cnx.prepareStatement("select * from produit");
			  ResultSet rs = pr.executeQuery();
			  
			    while(rs.next()){
				      Produit produit =  new Produit();
				      produit.setId(rs.getInt("id"));
				      produit.setNom(rs.getString("nom"));
				      produit.setDescription(rs.getString("description"));
				      produit.setPrix(rs.getFloat("prix"));
				      produit.setImage(rs.getString("image"));
				      
				     
				     
				      listproduit.add(produit);
				  
			      }
			    
			}catch(Exception e){}
	   
		return listproduit;
	}
	
	
	
	public ArrayList<Commande> getAllCommandes(){
		
		   ArrayList<Commande> listcommandes = new ArrayList<Commande>();
			
		   try{
				
			     Class.forName("com.mysql.jdbc.Driver");
			     Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
				  pr =  (PreparedStatement) cnx.prepareStatement("select * from commande");
				  ResultSet rs = pr.executeQuery();
				  
				    while(rs.next()){
				    	  Commande commande =  new Commande();
				    	  commande.setId(rs.getInt("id"));
				    	  commande.setIdUser(rs.getInt("idUser"));
				    	  commande.setCommande(rs.getString("commande"));
				    	  commande.setTotale(rs.getFloat("totale"));
					    
					      
					     
					     
					      listcommandes.add(commande);
					  
				      }
				    
				}catch(Exception e){}
		   
			return listcommandes;
		}
	
	
	
	public ArrayList<Utilisateur> getAllUser(){
		
		
		
		ArrayList<Utilisateur> listutilisateur = new ArrayList<Utilisateur>();
		try{
		
	     Class.forName("com.mysql.jdbc.Driver");
	     Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
		  pr =  (PreparedStatement) cnx.prepareStatement("select * from utilisateur");
		  ResultSet rs = pr.executeQuery();
		  
		    while(rs.next()){
			      Utilisateur utilisateur =  new Utilisateur();
			      utilisateur.setId(rs.getLong("id"));
			      utilisateur.setUsername(rs.getString("username"));
			      utilisateur.setFirst_name(rs.getString("first_name"));
			      utilisateur.setLast_name(rs.getString("last_name"));
			      utilisateur.setPassword(rs.getString("password"));
			      utilisateur.setEmail(rs.getString("email"));
			      utilisateur.setRole(rs.getString("role"));
			      utilisateur.setPhoto(rs.getString("photo"));
			      
			     
			     
			      listutilisateur.add(utilisateur);
			  
		      }
		    
		}catch(Exception e){}
	
		return listutilisateur;
		
	}
	
	public Utilisateur ShowUser(String id) {
		
		Utilisateur user = new Utilisateur();
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
	     Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
		Statement stmt = (Statement) cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateur WHERE id = "+id);
		
		while (rs.next()) {
			  user.setId(rs.getLong(1));
			  user.setUsername(rs.getString("username"));
			  user.setFirst_name(rs.getString("first_name"));
			  user.setLast_name(rs.getString("Last_name"));
			  user.setPassword(rs.getString("password"));
			  user.setEmail(rs.getString("email"));
			  user.setRole(rs.getString("role"));
			}
		
	}catch(Exception e){}
		
		return user;
	}
	
	public void addUtilisateur (Utilisateur utilisateur ){
		
		
		
		/*try{
		 Class.forName("com.mysql.jdbc.Driver");
         Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
         Statement  St = (Statement) cnx.createStatement();
         System.out.println(utilisateur.getUsername()+" est bien dddajoute");
         St.executeUpdate("Insert into utilisateur values(default,'" + utilisateur.getUsername() +"','" + utilisateur.getFirst_name() +"','" + utilisateur.getLast_name() +"','" + utilisateur.getPassword() +"','" + utilisateur.getEmail() +"','" + utilisateur.getRole() +"')");
         
         System.out.println(utilisateur.getUsername()+" est bien dddajoute");
          
		}catch(Exception e){}*/
		
		
		
		   
		try {
		   
			Class.forName("com.mysql.jdbc.Driver");
			Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
			pr =  (PreparedStatement) cnx.prepareStatement(
					"insert into utilisateur (id,username,first_name,last_name,password,email,role) values (default,?,?,?,?,?,?)"
					);
			
			   pr.setString(1, utilisateur.getUsername());
			   pr.setString(2, utilisateur.getFirst_name());
			   pr.setString(3, utilisateur.getLast_name());
			   pr.setString(4, utilisateur.getPassword());
			   pr.setString(5, utilisateur.getEmail());
			   pr.setString(6, utilisateur.getRole());
			   
			   pr.executeUpdate();
			   pr.close();
				   
				   
			   
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
