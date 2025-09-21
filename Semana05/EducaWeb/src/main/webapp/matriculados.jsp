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

			<h1>CONSULTAR MATRICULADOS</h1>

			<div class="card">
				<div class="card-header">
					Datos
				</div>
				<div class="card-body">
					<form method="post" action="curso_matriculados">
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
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="col"><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">#</font></font></th>
								<th scope="col"><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">IdCurso</font></font></th>
								<th scope="col"><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">IdAlumno</font></font></th>
								<th scope="col"><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">Precio</font></font></th>
								<th scope="col"><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">Cuotas</font></font></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.lista}" var="r">
							<tr>
								<th scope="row"><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">1</font></font></th>
								<td><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">${r.CUR_ID}</font></font></td>
								<td><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">${r.ALU_ID}</font></font></td>
								<td><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">${r.MAT_PRECIO}</font></font></td>
								<td><font dir="auto" style="vertical-align: inherit;"><font dir="auto" style="vertical-align: inherit;">${r.MAT_CUOTAS}</font></font></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>


		</div>




		<!-- Option 2: Separate Popper and Bootstrap JS -->
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    </body>
</html>
