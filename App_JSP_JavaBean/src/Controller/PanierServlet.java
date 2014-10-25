package Controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PanierServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String id = req.getParameter("id");
        String action = req.getParameter("action");
        
      
        
		if(action.equals("delete")){
			
        
        try {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
			   
            String sql = "DELETE FROM panier WHERE id=?";
            PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

          } catch (Exception e) {
                  e.printStackTrace();
                }
		   req.getRequestDispatcher("panier.jsp").forward(req, resp);
	   
		}
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

        String id = req.getParameter("id");
        String qte = req.getParameter("qte");
        System.out.println(qte);
		
   
        	try {
    			
 		       Class.forName("com.mysql.jdbc.Driver");
 			   Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
         String sql = "UPDATE panier SET qte =? where id = ?";
         
         PreparedStatement ps = (PreparedStatement) cnx .prepareStatement(sql);
         ps.setString(1, qte );
         ps.setString(2, id );
        
         ps.executeUpdate();            

              } catch (Exception e) {
                  e.printStackTrace();
              }
        
        	resp.sendRedirect("panier.jsp");
		
	}
	
	
}
