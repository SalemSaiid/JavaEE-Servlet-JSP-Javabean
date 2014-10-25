package Controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CommandeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		String id = req.getParameter("id");
		
		if(action.equals("deliver")){
			   
			   System.out.println(action);
			   
			   try {
				   Class.forName("com.mysql.jdbc.Driver");
				   Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
	               String sql = "DELETE FROM commande WHERE id=?";
	               PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(sql);
	               ps.setString(1, id);
	               ps.executeUpdate();

	             } catch (Exception e) {
	                     e.printStackTrace();
	                   }
			   req.getRequestDispatcher("listeCommandes.jsp").forward(req, resp);
		   }
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
