<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./error_page.jsp" %>
	<%@ page import="ca.qc.cgodin.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Rent4All - Bienvenue </title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
<div id="container">
<div class="nav">
	<a class="btn" href="login.jsp"> Se connecter </a>
</div>
<h3> Toutes les dernières annonces </h3>

	<table border="1">
  <%
  	AnnManager annMan = new AnnManager();
	List<Annonce> annlist = new ArrayList<Annonce>();
	annlist = annMan.getAllAnnonces_list();
 	for(Annonce a:annlist){
 %>
		<tr>
			<td><img width='100px' height='50px' src=''/></td>
			<td><%=a.getTitre() %></td>
			<td><%=a.getDescription() %></td>
			<td><%= a.getAmount()+"$" %></td>
		</tr>
<%
 	}
%>
	</table>
</div>
</body>
</html>