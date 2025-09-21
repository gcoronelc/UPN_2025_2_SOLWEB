<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

		<title>Hello, world!</title>
	</head>
    <body>

		<jsp:include page="menu.jsp"/>

		<div class="container">

			<h1>CONSULTAR PRECIO</h1>

			<div class="card">
				<div class="card-header">
					Datos
				</div>
				<div class="card-body">
					<form method="post" action="curso_precio">
						<div class="mb-3">
							<label for="idCurso" class="form-label">Id Curso</label>
							<input type="number" class="form-control" id="idCurso" name="idCurso" aria-describedby="emailHelp">
						</div>
						<button type="submit" class="btn btn-primary">Consultar</button>
					</form>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					Resultado
				</div>
				<div class="card-body">
					<c:if test="${not empty requestScope.precio}">
					<div class="mb-3">
						<label class="form-label">Id Curso: </label>
						<label class="form-label">${requestScope.idCurso}</label>
					</div>
					<div class="mb-3">
						<label class="form-label">Precio: </label>
						<label class="form-label">${requestScope.precio}</label>
					</div>
					</c:if>
					<c:if test="${not empty requestScope.error}">
					<div class="alert alert-danger " id="errorAlert" role="alert">
						<i class="bi bi-exclamation-triangle"></i>
						<span id="errorMessage">IdCurso no existe</span>
					</div>
					</c:if>
				</div>
			</div>


		</div>




		<!-- Option 2: Separate Popper and Bootstrap JS -->
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    </body>
</html>
