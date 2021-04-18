<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><jsp:include page="/WEB-INF/villes.css"/></style>
<title>Liste des villes</title>
</head>
<body>
	<div class = "centrer">
		<h1>Liste des villes : page <c:out value="${ page }"/></h1>
	</div>
	<table>
		<thead>
			<tr>
				<th>code INSEE</th>
				<th>nom commune</th>
				<th>code postal</th>
				<th>libelle acheminement</th>
				<th>ligne 5</th>
				<th>lattitude</th>
				<th>longitude</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ villes }" begin="${ begin }" end="${ end }" var="ville">
				<tr>
					<td>${ ville.getCodeINSEE() }</td>
					<td>${ ville.getNomCommune() }</td>
					<td>${ ville.getCP() }</td>
					<td>${ ville.getLibelleAcheminement() }</td>
					<td>${ ville.getLigne_5() }</td>
					<td>${ ville.getLattitude() }</td>
					<td>${ ville.getLongitude() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class = centrer>
		<c:if test="${ page == 1 }">
			<form action="" method="get" class="form">
				<button class="bouton" name="page" type="submit" value="${ page -1 }"  disabled = "disabled">Page precedente</button>
			</form>
		</c:if>
		
		<c:if test="${ page > 1 }">
			<form action="" method="get" class="form">
				<button class="bouton" name="page" type="submit" value="${ page -1 }">page precedente</button>
			</form>
		</c:if>
		
		<c:if test="${ page > villes.size()/50 }">
			<form action="" method="get" class="form">
				<button class="bouton" name="page" type="submit" value="${ page +1 }" disabled = "disabled">Page suivante</button>
			</form>
		</c:if>
		<c:if test="${ page <= villes.size()/50 }">
			<form action="" method="get" class="form">
				<button class="bouton" name="page" type="submit" value="${ page +1 }">page suivante</button>
			</form>
		</c:if>
	</div>
	<div class = centrer>
		<button class="boutonDistance" onclick="window.location='/Client_TWIC/index';">Calculer la distance entre deux villes</button>
	</div>
</body>
</html>