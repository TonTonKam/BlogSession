<c:import url="nav/header.jsp"/>

<div class="container">
	<form action="<%= request.getContextPath() %>/article" method="post">
	<p>
	<c:out value="Je suis l'article : ${idArt.titre }"/>
	<c:if test="${!empty compare }">
		<c:out value="Vous pouvez modifier le titre ici :"/>
		<input type="text" class="form-control" name="titreEdit" value="${idArt.titre }">
	</c:if>
	<p>
	<p>
	<c:out value="Mon contenu est : ${idArt.contenu }"/>
	<c:if test="${!empty compare }">
		<c:out value="Vous pouvez modifier le contenu ici :"/>
		<textarea class="form-control" name="contenuEdit" rows="3" value="">
		</textarea>
	</c:if>
	</p>	
	<p>
	<c:out value="Mon resume est : ${idArt.resume }"/>
	<c:if test="${!empty compare }">
		<c:out value="Vous pouvez modifier le resume ici :"/>
		<textarea class="form-control" name="resumeEdit" rows="3" >
		</textarea>
	</c:if>
	</p>
	<p>
	<c:out value="Mon image est : "/><img alt="img" src="<c:out value="${idArt.image }"/>"/></p>
	<c:if test="${!empty compare }">
		<p><c:out value="Vous pouvez modifier l'image ici :"/>
		<input type="text" class="form-control" name="imageEdit" value="${idArt.image }"></p>
	</c:if>
	
	<c:if test="${!empty compare }">
	<div class="format">
		<p><button type="submit"><c:out value="Valider l'edition"/></button></p>
		<a data-bs-toggle="modal" data-bs-target="#suppr">
			<button type="button" ><c:out value="SUPPRIMER"/></button>
		</a>
		<!-- Modal -->
		<div class="modal fade" id="suppr" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">SUPPRIMER</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      	Voulez-vous vraiment vous Supprimer le contenu?
		        <b><c:out value="${user.prenom }  sujet : ${idArt.titre }" /></b> ?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Non</button>
		       
		        <a href="supprimer?idArticle=${idArt.idArticle}">
		        	<button type="button" class="btn btn-success">Oui, je confirme</button>
		        </a>
		      </div>
		    </div>
		  </div>
		</div>
	</c:if>
	</div>
	</form>
</div>

<c:import url="nav/footer.jsp"/>