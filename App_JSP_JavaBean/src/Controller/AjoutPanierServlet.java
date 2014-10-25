package Controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.Panier;
import dao.Produit;

public class AjoutPanierServlet extends HttpServlet {
	
	 public	 String nom,description,image,idProduit,idUser,qte;
	 float prix;
	 private PreparedStatement pr = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		idProduit = req.getParameter("id");
		idUser = req.getParameter("idUser");
		qte = req.getParameter("qte");
		System.out.println(idProduit);
		System.out.println(qte);
	   
		
		
		try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
			Statement stmt = (Statement) cnx.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM produit WHERE id = "+idProduit);
			Produit produit = new Produit();
		    
			
			while (rs.next()) {
				
				produit.setId(rs.getInt(1));
				produit.setNom(rs.getString("nom"));
				produit.setDescription(rs.getString("description"));
				produit.setPrix(rs.getFloat("prix"));
				produit.setImage(rs.getString("image"));
				
				
			    nom = produit.getNom();
				description = produit.getDescription();
				prix = produit.getPrix();
			    image = produit.getImage();
				
				}
			System.out.println(idProduit);
			System.out.println(idUser);
			System.out.println(qte);
			System.out.println(nom);
			System.out.println(description);
			System.out.println(prix);
			System.out.println(image);
			
			pr =  (PreparedStatement) cnx.prepareStatement(
					"insert into panier (id,idProduit,idUser,qte,nom,description,prix,image) values (default,?,?,?,?,?,?,?)"
					);
			
			   pr.setString(1,idProduit );
			   pr.setString(2,idUser );
			   pr.setString(3, qte);
			   pr.setString(4, nom);
			   pr.setString(5,description);
			   pr.setFloat(6, prix);
			   pr.setString(7, image);
			   
			   pr.executeUpdate();
			   pr.close();
				   
			
			
		     }catch(Exception e){}
		
		
		resp.sendRedirect("panier.jsp");
		
	}

}
