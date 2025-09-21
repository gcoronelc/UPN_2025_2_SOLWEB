package pe.edu.upn.educaweb.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import pe.edu.upn.educaweb.service.EducaService;

@WebServlet(name = "EducaController",
		urlPatterns = {"/curso_precio", "/curso_matricular", "/curso_matriculados"})
public class EducaController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
			case "/curso_precio":
				cursoPrecio(request, response);
				break;
			case "/curso_matriculados":
				cursoMatriculados(request, response);
				break;
			case "/curso_matricular":
				cursoMatricular(request, response);
				break;
		}
	}

	private void cursoPrecio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Datos
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		// Proceso
		EducaService educaService = new EducaService();
		double precio = educaService.consultarPrecio(idCurso);
		// El Forward
		request.setAttribute("idCurso", idCurso);
		if (precio > 0) {
			request.setAttribute("precio", precio);
		} else {
			request.setAttribute("error", "Hay error");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("precio.jsp");
		dispatcher.forward(request, response);
	}

	private void cursoMatricular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void cursoMatriculados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		// Proceso
		EducaService educaService = new EducaService();
		List<Map<String, ?>> lista = educaService.consultarMatriculados(idCurso);
		// El Forward
		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("matriculados.jsp");
		dispatcher.forward(request, response);
	}

}
