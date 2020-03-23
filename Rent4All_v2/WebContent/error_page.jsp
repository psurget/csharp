<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur</title>
</head>
<body>
	<h1>Une erreur est survenue</h1>
	<p><%=exception.getClass().getName()%></p>
	<p><%=exception.getMessage()%></p>
	<p>Cliquez sur le bouton "Continuer" pour revenir à la page
		d'origine.</p>
	<button
		onclick="javascript:self.location='<%=request.getContextPath()%>/ouverture.jsp'"></button>
</body>
</html>