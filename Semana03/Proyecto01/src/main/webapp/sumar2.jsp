<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // Variables
    int num1 = 0, num2 = 0, suma = 0;

    // Datos
    if (request.getAttribute("suma") != null) {
	num1 = Integer.parseInt(request.getAttribute("num1").toString());
	num2 = Integer.parseInt(request.getAttribute("num2").toString());
	suma = Integer.parseInt(request.getAttribute("suma").toString());
    }

%>
<html>
    <head>
        <!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

	<title>Hello, world!</title>
    </head>
    <body>

	<div class="container">
	    <h1>SUMAR</h1>

	    <% if(request.getAttribute("suma") == null){ %>
	    
	    <!-- FORMULARIO DE ENTRADA DE DATOS -->
	    <div class="card">
		<div class="card-header">
		    Datos
		</div>
		<div class="card-body">
		    <form id="sumaForm" method="post" action="SumarService">
			<!-- Primer número -->
			<div class="row mb-3">
			    <label for="numero1" class="col-sm-4 col-form-label">Primer número:</label>
			    <div class="col-sm-8">
				<input type="number" class="form-control" id="numero1" name="numero1" placeholder="Ingrese el primer número" required>
			    </div>
			</div>

			<!-- Segundo número -->
			<div class="row mb-3">
			    <label for="numero2" class="col-sm-4 col-form-label">Segundo número:</label>
			    <div class="col-sm-8">
				<input type="number" class="form-control" id="numero2" name="numero2" placeholder="Ingrese el segundo número" required>
			    </div>
			</div>

			<!-- Botón de calcular -->
			<div class="row mb-3">
			    <div class="col-sm-8 offset-sm-4">
				<input type="submit" class="btn btn-success w-100" value="Calcular Suma">
			    </div>
			</div>

		    </form>

		</div>
	    </div>

	    <% } %>
	    
	    <% if(request.getAttribute("suma") != null){ %>
	    
	    <!-- SECCION DE REPORTE -->
	    <div class="card">
		<div class="card-header">
		    Resultado
		</div>
		<div class="card-body">
		    <!-- Primer número -->
		    <div class="row mb-3">
			<label for="numero1" class="col-sm-4 col-form-label">Primer número:</label>
			<div class="col-sm-8">
			    <input type="text" class="form-control bg-light" id="numero1" readonly splaceholder="Primer número" value="<%=num1%>">
			</div>
		    </div>

		    <!-- Segundo número -->
		    <div class="row mb-3">
			<label for="numero2" class="col-sm-4 col-form-label">Segundo número:</label>
			<div class="col-sm-8">
			    <input type="text" class="form-control bg-light" id="numero2" readonly placeholder="Segundo número" value="<%=num2%>">
			</div>
		    </div>

		    <!-- Resultado -->
		    <div class="row">
			<label class="col-sm-4 col-form-label">Resultado:</label>
			<div class="col-sm-8">
			    <input type="text" class="form-control bg-light" id="resultado" readonly placeholder="El resultado aparecerá aquí" value="<%=suma%>">
			</div>
		    </div>
		
		    <!-- Nuevo calculo -->
		    <div class="row">
			<a href="sumar2.jsp" class="btn btn-success" role="button">Nuevo calculo</a>
		    </div>
		</div>
	    </div>

	    <% } %>
			
	</div>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

    </body>
</html>
