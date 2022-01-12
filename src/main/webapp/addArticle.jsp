<c:import url="nav/header.jsp"/>

<div class="container">
<c:if test="${empty user }">
	<b><c:out value="Vous devez vous 'connecter' ou vous 'inscrire' pour creer un post"></c:out></b>
</c:if>
<c:if test="${!empty user }">
	<b><c:out value="${erreurSais }"></c:out></b>
	<form action="<%= request.getContextPath() %>/creation-article" method="post">
	<div class="mb-3">
		  <label for="titreSaisi" class="form-label"><c:out value="Titre* :"/></label>
		  <input type="text" class="form-control" id="titreSaisi" name="titreSaisi" required>
	</div>
	<div class="mb-3">
		  <label for="contenuSaisi" class="form-label"><c:out value="Saisir le contenu* :"/></label>
		  <textarea class="form-control" id="contenuSaisi" name="contenuSaisi" rows="3" required></textarea>
	</div>
	<div class="mb-3">
		  <label for="resumeSaisi" class="form-label"><c:out value="Saisir le resume :"/></label>
		  <textarea class="form-control" id="resumeSaisi" name="resumeSaisi" rows="3" placeholder="Facultatif"></textarea>
	</div>
	<div class="mb-3">
		  <label for="lienImage" class="form-label"><c:out value="inserer URL d'une image :"/></label>
		  <input type="text" class="form-control" id="lienImage" name="lienImage" placeholder="Facultatif : insert url ici">
	</div>
	<button type="submit"><c:out value="Creez votre post"/></button>
	</form>
</c:if>
</div>

<c:import url="nav/footer.jsp"/>