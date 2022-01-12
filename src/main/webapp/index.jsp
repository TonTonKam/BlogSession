<c:import url="nav/header.jsp"/>

<c:url value="/creation-article" var="creerArt"/>
<div class="container">
	<p><c:out value="Bonjour ${user.nom }, bienvenu sur la page index"/><p>
	<c:if test="${empty listArt }">
		<c:out value="Nous ne possedons pour le moment, aucun article. Souhaitez-vous ajouter un article?"/>
		<a href="${creerArt }">Creer article</a>
	</c:if>
	<c:if test="${!empty listArt }">
	<div class="contenaire-objet">
		<c:forEach items="${listArt }" var="article">
			<div class="objet-article">
				<a href="<%= request.getContextPath() %>/article?idArticle=${article.idArticle }">
					<div class="objet-contenu">
						<c:if test="${!empty article.image }">
							<div class="objet-image">
								<img alt="img" src="<c:out value="${article.image }"/>"/>
							</div>
						</c:if>
						<p><c:out value="Titre : ${article.titre }"/></p>
						<p><c:out value="Auteur : ${article.auteur }"/></p>
						<p><c:out value="Date de parution : ${article.date }"/></p>
						<c:if test="${!empty article.resume }">
							<p><c:out value="Resume : ${article.resume }"/></p>
						</c:if>
						<c:if test="${empty article.resume }">
							<c:forTokens items="${article.contenu }" delims=".?" var="point">
					       		<p><c:out value="${point}"/></p>
						    </c:forTokens>
						</c:if>
					</div>
				</a>
			</div>
		</c:forEach>
	</div>
	<c:out value="Si vous souhaitez ajouter des sujets : "/><a href="${creerArt }">Creer article.</a>
	<p><c:out value="En vous remerciant pour votre participation."/></p>
	</c:if>
</div>

<c:import url="nav/footer.jsp"/>