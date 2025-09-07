package pe.edu.upn.demo01.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Mate", urlPatterns = {"/Mate"})
public class Mate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		int num1;
		int num2;
		int suma;
		String rpta;
		// Proceso		
		try {
			// Obtener datos
			num1 = Integer.parseInt(request.getParameter("num1"));
			num2 = Integer.parseInt(request.getParameter("num2"));
			// Operaciones
			suma = num1 + num2;
			rpta = num1 + " + " + num2 + " = " + suma;
		} catch (Exception e) {
			rpta = "Ingresa datos correctos.";
		}
		// Generando la salida
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(rpta);
		out.flush();
	}

	

	

}
