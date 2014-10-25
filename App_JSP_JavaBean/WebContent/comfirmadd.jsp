<%@page import="dao.Operateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation d'ajout</title>
</head>
<body>
   <jsp:useBean id="utilisateur" class="dao.Utilisateur" scope="request">
     <jsp:setProperty name="utilisateur" property="username" param="username" />
      <jsp:setProperty name="utilisateur" property="first_name" param="first_name" />
       <jsp:setProperty name="utilisateur" property="last_name" param="last_name" />
        <jsp:setProperty name="utilisateur" property="password" param="password" />
         <jsp:setProperty name="utilisateur" property="email" param="email" />
          <jsp:setProperty name="utilisateur" property="role" param="role" />
          
          <%
               Operateur op =  new Operateur();
               op.addUtilisateur(utilisateur);
          
          %>
          
          
          
          <h2>Utilisateur est bien ajouté !!</h2>
   
   </jsp:useBean>
</body>
</html>