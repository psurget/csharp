<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./error_page.jsp" %>
    
<%@ page import="ca.qc.cgodin.model.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de profil</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>

<body>

<div id="container">
	<div class="nav">
		<a class="btn" href="AnnonceList_srvlt.jsp">Retour Accueil</a>
		<a class="btn" href="closeSession.jsp">Fermer session</a>
	</div>
	
<h3>Vos annonces</h3>

<% 	
	List<Annonce> annList = new ArrayList<Annonce>();
	AnnManager annDB = new AnnManager();
	annDB.getAnnoncesByUser_list();
%>
<button id="addAnn" onclick="/NewAnnonce_srvlt">Ajouter une annonce</button>
<br/>
	<table border="1">
  <%
 	for(Annonce a : annList){
  %>
		<tr>
			<td>
				<img width="50px" src="#"/>
			</td>
			<td>
				<h4>
					<%=a.getTitre() %>
				</h4>
				<p>
					<%=a.getDescription() %>
				</p>
			</td>
			<td>
				<% double amnt= a.getAmount();
					String.format("%,2f$", amnt);
				%>
			</td>
		</tr>
  <%
 	}
  %>
	</table>
</div>
</body>
</html>