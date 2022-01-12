<c:import url="nav/header.jsp"></c:import>

<div class="container">
	<c:out value="${erreur }"/>
	<form action="<%= request.getContextPath() %>/login" method="post">
	  <div class="mb-3">
	    <label for="emailLog" class="form-label"><c:out value="Saisir votre E-mail" /></label>
	    <input type="email" class="form-control" name="emailLog" id="emailLog">
	  </div>
	  <div class="mb-3">
	    <label for="pwdLog" class="form-label"><c:out value="Saisir votre mot de passe" /></label>
	    <input type="password" class="form-control" name="pwdLog" id="pwdLog">
	  </div>
	  <button type="submit" class="btn btn-primary" id="btnConnect"><c:out value="Se connecter" /></button>
	</form>
</div>

<c:import url="nav/footer.jsp"></c:import>