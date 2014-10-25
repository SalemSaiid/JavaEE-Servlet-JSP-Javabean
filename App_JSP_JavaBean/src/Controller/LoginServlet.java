package Controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.Utilisateur;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/jeegeti", "root", "");
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from utilisateur where username='"
					+ username + "'");
			if (rs.next()) {
				if (rs.getString(5).equals(password)) {
					
					String role=rs.getString("role");
					Long id = rs.getLong("id");
					String photo = rs.getString("photo");
					
					req.getSession().setAttribute("user", new Utilisateur(id,username,password,role,photo));
					
					String sql = "DELETE FROM panier WHERE idUser=?";
		            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		            ps.setLong(1, id);
		            ps.executeUpdate();
					
					resp.sendRedirect("Home");

				} else  {
					
					System.out.println( "Invalid password try again");
					resp.sendRedirect("login.jsp");
				}
			}else{
			
			System.out.println( "Invalid password try again");
			resp.sendRedirect("login.jsp");}
			
	  }catch(Exception e){ System.out.println( "Erreur !!"); }
	       
	}

	

	}

