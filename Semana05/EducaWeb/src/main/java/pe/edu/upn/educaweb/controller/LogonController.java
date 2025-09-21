package pe.edu.upn.educaweb.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.edu.upn.educaweb.dto.EmpleadoDto;
import pe.edu.upn.educaweb.service.LogonService;

@WebServlet(name = "LogonController", urlPatterns = {"/Login","/Salir"})
public class LogonController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String path = request.getServletPath();
		switch(path){
			case "/Login":
				login(request,response);
				break;
			case "/Salir":
				salir(request,response);
				break;
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// Datos
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		// Proceso
		LogonService logonService = new LogonService();
		EmpleadoDto dto = logonService.validarUsuario(usuario, clave);
		// Reporte
		String destino;
		if(dto == null){
			destino = "index.jsp";
			request.setAttribute("mensaje", "Datos incorrectos");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", dto);
			destino = "main.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	
	
}
