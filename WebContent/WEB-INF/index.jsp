<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><jsp:include page="/WEB-INF/index.css"/></style>
<title>Calcul de distance</title>
</head>
<body>
	<div class="container">
		<form action="" method="post" class="form">
			<h1>Calculer la distance entre deux villes</h1>
			<div class="villes">
				<label class="label">Ville 1 : </label>
				<select class="listeVilles" name="ville1">
					<c:forEach items="${ villes }" var="ville">
						<option value="${ ville.getLattitude() },${ ville.getLongitude() }"><c:out value="${ ville.getCP() } ${ ville.getNomCommune() }" /></option>
					</c:forEach>
				</select>
			</div>
			
			<div class="villes">
				<label class="label">Ville 2 : </label>
				<select class="listeVilles" name="ville2">
					<c:forEach items="${ villes }" var="ville">
						<option value="${ ville.getLattitude() },${ ville.getLongitude() }"><c:out value="${ ville.getCP() } ${ ville.getNomCommune() }" /></option>
					</c:forEach>
				</select>
			</div>
			
			<input type="submit" value="Calculer la distance" class="bouton">
			
			<c:if test="${ distance != null }">
				<h3><c:out value="La distance est de ${ distance } km"></c:out></h3>
			</c:if>
		</form>
		<button class="boutonVilles" onclick="window.location='/Client_TWIC/villes';">Afficher toutes les villes</button>
	</div>
</body>
</html>