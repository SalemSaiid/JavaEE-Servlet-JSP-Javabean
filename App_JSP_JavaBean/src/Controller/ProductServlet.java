package Controller;

import dao.Operateur;
import dao.Produit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.Utilisateur;


public class ProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   String nom = req.getParameter("nom");
		   String description = req.getParameter("description");
		   String prix = req.getParameter("prix");
		   String image = req.getParameter("image");
		   
		   System.out.println(nom);
		   System.out.println(description);
		   System.out.println(prix);
		   System.out.println(image);
		   
				try {
				   
					Class.forName("com.mysql.jdbc.Driver");
					Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
				    PreparedStatement pr =  (PreparedStatement) cnx.prepareStatement(
							"insert into produit (id,nom,description,prix,image) values (default,?,?,?,?)"
							);
					
					   pr.setString(1,nom);
					   pr.setString(2,description );
					   pr.setString(3, prix);
					   pr.setString(4,image );
					  
					   
					   pr.executeUpdate();
					   pr.close();
						   
						   
					   
					   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
      

		String id = req.getParameter("id");
		String action =  req.getParameter("action");
		
	if(action.equals(null)){
		
		   
		
	}	
		
	if(action.equals("show")){
		System.out.println(action);
		Produit produit = new Produit();
		try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
			Statement stmt = (Statement) cnx.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM produit WHERE id = "+id);
			
			while (rs.next()) {
				produit.setId(rs.getInt("id"));
				produit.setNom(rs.getString("nom"));
				produit.setDescription(rs.getString("description"));
				produit.setPrix(rs.getFloat("prix"));
				produit.setImage(rs.getString("image"));
				  
				  req.setAttribute("produit", produit);
				  
				}
		
		     }catch(Exception e){}
		
		     req.getRequestDispatcher("ShowProduct.jsp").forward(req, resp);
		  }
	
	   else if(action.equals("edit")){
		   
		   System.out.println(action);
		   
		   Produit produit = new Produit();
			try{
				 
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
				Statement stmt = (Statement) cnx.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM produit WHERE id = "+id);
				
				while (rs.next()) {
					produit.setId(rs.getInt(1));
					produit.setNom(rs.getString("nom"));
					produit.setDescription(rs.getString("description"));
					produit.setPrix(rs.getFloat("prix"));
					produit.setImage(rs.getString("image"));
					  
					  req.setAttribute("produit", produit);
					  
					}
			
			     }catch(Exception e){}
		   
		   req.getRequestDispatcher("EditProduit.jsp").forward(req, resp);
		
		   
	     }
	
       else if(action.equals("delete")){
		   
		   System.out.println(action);
		   
		   try {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
               String sql = "DELETE FROM produit WHERE id=?";
               PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(sql);
               ps.setString(1, id);
               ps.executeUpdate();

             } catch (Exception e) {
                     e.printStackTrace();
                   }
		   req.getRequestDispatcher("listProduit.jsp").forward(req, resp);
	   }
	
		
		
		
		
	}

}
