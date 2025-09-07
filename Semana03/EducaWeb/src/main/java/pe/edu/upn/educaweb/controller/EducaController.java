package pe.edu.upn.educaweb.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.upn.educaweb.service.EducaService;


@WebServlet(name = "EducaController", 
		urlPatterns = {"/curso_precio","/curso_matricular"})
public class EducaController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
			case "/curso_precio":
				cursoPrecio(request,response);
				break;
			case "/curso_matricular":
				cursoMatricular(request,response);
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
		request.setAttribute("precio", precio);
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultarPrecio.jsp");
		dispatcher.forward(request, response);
	}

	private void cursoMatricular(HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	
	
	
	
}
