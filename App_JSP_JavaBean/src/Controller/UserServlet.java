package Controller;

import dao.Operateur;

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

@MultipartConfig(maxFileSize = 16177215) 
public class UserServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   String username = req.getParameter("username");
		   String first_name = req.getParameter("first_name");
		   String last_name = req.getParameter("last_name");
		   String password = req.getParameter("password");
		   String email = req.getParameter("email");
		   String role = req.getParameter("role");
		   String photo = req.getParameter("photo");
		   
		  
		
		   
				try {
				   
					Class.forName("com.mysql.jdbc.Driver");
					Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
				    PreparedStatement pr =  (PreparedStatement) cnx.prepareStatement(
							"insert into utilisateur (id,username,first_name,last_name,password,email,role,photo) values (default,?,?,?,?,?,?,?)"
							);
					
					   pr.setString(1,username);
					   pr.setString(2,first_name );
					   pr.setString(3, last_name);
					   pr.setString(4,password );
					   pr.setString(5,email );
					   pr.setString(6,role );
					   pr.setString(7,photo );
					   
					   pr.executeUpdate();
					   pr.close();
						   
					   resp.sendRedirect("listUtilisateur.jsp");   
					   
					   
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
				  
				  req.setAttribute("utilisateur", user);
				  
				}
		
		     }catch(Exception e){}
		
		     req.getRequestDispatcher("ShowUser.jsp").forward(req, resp);
		  }
	
	   else if(action.equals("edit")){
		   
		   System.out.println(action);
		   
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
					  user.setPhoto(rs.getString("photo"));
					  
					  req.setAttribute("utilisateur", user);
					  
					}
			
			     }catch(Exception e){}
		   
		   req.getRequestDispatcher("EditUser.jsp").forward(req, resp);
		
		   
	     }
	
       else if(action.equals("delete")){
		   
		   System.out.println(action);
		   
		   try {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
               String sql = "DELETE FROM utilisateur WHERE id=?";
               PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(sql);
               ps.setString(1, id);
               ps.executeUpdate();

             } catch (Exception e) {
                     e.printStackTrace();
                   }
		   req.getRequestDispatcher("listUtilisateur.jsp").forward(req, resp);
	   }
	
      
	}

}
