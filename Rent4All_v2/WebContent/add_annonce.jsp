<%@ page import="ca.qc.cgodin.model.Annonce" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter une annonce</title>
</head>
<body>
<%
    //on recupere les deux parametres envoyes par le lien hypertexte
	String UserID = request.getParameter("UserID");
%>

<form method="POST" action="AddAnnonceServlet" >
 Titre:<br>
  <input type="text" name="titre">
  <br>
   <input type="text" name="category">
   <input type="text" name="description">
   <input type="number" name="amount">
   <input type="hidden" name="userID" value="<%=UserID%>">
   <input type="hidden" name="statut" value="actif">
   <br/><br/>  
  <input type="submit" value="Submit">
</form>

</body>
</html>