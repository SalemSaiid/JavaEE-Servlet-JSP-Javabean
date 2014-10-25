<%@page import="dao.Utilisateur"%>
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
       Utilisateur u = (Utilisateur)request.getAttribute("utilisateur");
    %>
      
       
       <table>
            
            <tr>
                 <td>ID: </td>
                 <td><%= u.getId()%></td>
            </tr>
            
            <tr>
                 <td>Username: </td>
                 <td><%= u.getUsername()%></td>
            </tr>
            
            <tr>
                 <td>First Name: </td>
                 <td><%= u.getFirst_name()%></td>
            </tr>
            
            <tr>
                 <td>Last Name: </td>
                 <td><%= u.getLast_name()%></td>
            </tr>
            
            <tr>
                 <td>Password: </td>
                 <td><%= u.getPassword()%></td>
            </tr>
            
            <tr>
                 <td>Email: </td>
                 <td><%= u.getEmail()%></td>
            </tr>
            
            <tr>
                 <td>Role: </td>
                 <td><%= u.getRole()%></td>
            </tr>
            
           
       
       </table>
</body>
</html>