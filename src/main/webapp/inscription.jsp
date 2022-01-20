<c:import url="nav/header.jsp"></c:import>

<div class="container">
	<form action="<%= request.getContextPath() %>/inscription" method="post">
		<c:out value="${erreurMail }"></c:out>
	  <div class="mb-3" >
	    <label for="prenomSaisie" class="form-label"><c:out value="Prenom" /></label>
	    <input type="text" class="form-control" name="prenomSaisie" >
	  </div>
	  <div class="mb-3">
	    <label for="nomSaisie" class="form-label"><c:out value="Nom" /></label>
	    <input type="text" class="form-control" name="nomSaisie">
	  </div>
	  <div class="mb-3">
	    <label for="ageSaisie" class="form-label"><c:out value="Age" /></label>
	    <input type="text" class="form-control" name="ageSaisie">
	  </div>
	  <div class="mb-3">
	    <label for="civSaisie" class="form-label"><c:out value="Civilite" /></label>
	    <input type="text" class="form-control" name="civSaisie">
	  </div>
	  <div class="mb-3">
	    <label for="nomSaisie" class="form-label"><c:out value="Email" /></label>
	    <input type="email" class="form-control" name="emailSaisie">
	  </div>
	  <div class="mb-3">
	    <label for="nomSaisie" class="form-label"><c:out value="Password" /></label>
	    <input type="password" class="form-control" name="pwdSaisie">
	  </div>
	  <button type="submit" class="btn btn-primary"><c:out value="Ajouter utilisateur" /></button>
	</form>
</div>

<c:import url="nav/footer.jsp"></c:import>