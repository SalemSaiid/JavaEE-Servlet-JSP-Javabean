<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    
    <%
       Produit pro = (Produit) request.getAttribute("produit");
    %>
      
       
       <table>
            
            <tr>
                 <td>ID: </td>
                 <td><%= pro.getId()%></td>
            </tr>
            
            <tr>
                 <td>Nom: </td>
                 <td><%= pro.getNom()%></td>
            </tr>
            
            <tr>
                 <td>Description: </td>
                 <td><%= pro.getDescription()%></td>
            </tr>
            
            <tr>
                 <td>Prix: </td>
                 <td><%= pro.getPrix()%></td>
            </tr>
            
            <tr>
                 <td>Image: </td>
                 <td><IMG SRC="<%= pro.getImage()%>"  WIDTH="50" HEIGHT="50" /></td>
            </tr>
            
          
           
       
       </table>
</body>
</html>