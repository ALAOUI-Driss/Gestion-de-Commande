<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Commande" %>
<!DOCTYPE html>
<html>
<head>
	<link
		rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous"
	>
	<meta charset="ISO-8859-1">
	<title>Gestion de Commandes</title>
</head>
<body class="container m-auto">
<%List<Commande> cmds = (List<Commande>) request.getAttribute("cmds");%>
<br/>
<h1 class="d-flex justify-content-center">
	<b>Bienvenue au service de gestion des commandes</b>
</h1>
<hr/>
<div class="d-flex justify-content-between">
	<a class="btn btn-primary" href="ajouter"> Ajouter </a>  
	<div class="d-flex justify-content-around">    
		<a class="btn btn-primary" href="imprimerPDF"> Telecharger PDF </a>
		<a class="btn btn-primary" href="imprimerWord.docx"> Telecharger Word </a>
	</div>  
</div>
<br/><br/>
<table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Article</th>
                <th>qte</th>
                <th>Prix_unit</th>
                <th>Prix_total</th>
                <th>Client</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
            	for (Commande o : cmds){
            %>
                <tr>
                    <th> <%=o.get_id()%> </th>
                    <th> <%=o.getArticle()%> </th>
                    <th> <%=o.getQte()%> </th>
                    <th> <%=o.getPrix_unit()%> </th>
                    <th> <%=o.getPrix_total()%> </th>
                    <th> <%=o.getClient()%> </th>
                    <th>
                        <a
                        	href="modifier?id=<%=o.get_id()%>" 
                        	class="btn btn-primary"
                        >
                        Modifier
                        </a>
                        <a
                        href="supprimer?id=<%=o.get_id()%>"
                        class="btn btn-danger"
                        >
                        Supprimer
                        </a>
                    </th>
                </tr>
            <% } %>
            </tbody>
        </table>
</body>
</html>