<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CONSULTAR PRECIO</h1>
		<form method="post" action="curso_precio">
			<div>
				<label>Ingrese el id del curso: </label>
				<input type="type" name="idCurso">
			</div>
			<div>
				<input type="submit" value="Procesar">
			</div>
		</form>
		<%if(request.getAttribute("precio") != null){%>
		<div>
			<h1>RESULTADO</h1>
			<div>
				IdCurso:<%=request.getAttribute("idCurso").toString()%>
			</div>
			<div>
				Precio:<%=request.getAttribute("precio").toString()%>
			</div>
		</div>
		<%}%>
    </body>
</html>
