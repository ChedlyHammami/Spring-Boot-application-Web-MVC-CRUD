<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Employes</title>
</head>
<body>
<div class="container mt-5">
<div class="card">
 <div class="card-header">
 Liste des Employe
 </div>
 <div class="card-body">

 <table class="table table-striped">
 <tr>
<th>ID</th><th>Nom Employe</th><th>Prenom Employe</th><th>Date
Naissance</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${employes}" var="p">
 <tr>
 <td>${p.idEmploye }</td>
 <td>${p.nomEmploye }</td>
 <td>${p.prenomEmploye}</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${p.dateNaissance}" /></td>
 <td><a onclick="return confirm('Etes-vous sûr ?')"
href="supprimerEmploye?id=${p.idEmploye }">Supprimer</a></td>
 <td><a href="modifierEmploye?id=${p.idEmploye }">Edit</a></td>
 </tr>
 </c:forEach>
 </table>
 </div>
</div>
</div>
</body>
</html>