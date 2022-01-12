<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="CSS/style.css" rel="stylesheet" type="text/css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="JS/jquery-3.6.0.slim.min.js"></script>
<script src="JS/script.js"></script>

<title>Accueil</title>
</head>
<body>

<c:url value="/index" var="index"/>

<div class="menuGeneral">
	<div class="sectionAccueil">
		<div class="section">
			<a href="${index }"><c:out value="Accueil "/></a>
		</div>
		<div class="section">
			<c:if test="${!empty user}">
				<c:out value="Bonjour ${user.nom } comment ca va?"></c:out>
			</c:if>
		</div>
	</div>
	<div class="connexion">
		<c:if test="${empty user}">
			<a href="login">
				<button type="button" id="connected"><c:out value="Se connecter"/></button>
			</a>
			<a href="inscription">
				<button type="button" id="inscrire"><c:out value="S'incrire"/></button>
			</a>
		</c:if>
		<c:if test="${!empty user}">
			<a data-bs-toggle="modal" data-bs-target="#disconnected">
				<button type="button" ><c:out value="Se deconnecter"/></button>
			</a>
		</c:if>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="disconnected" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	Voulez-vous vraiment vous deconnecter?
	        <b><c:out value="${user.prenom } ${user.nom }" /></b> ?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Non</button>
	       
	        <a href="delete">
	        	<button type="button" class="btn btn-success">Oui, je confirme</button>
	        </a>
	      </div>
	    </div>
	  </div>
	</div>
	
</div>