package pe.edu.upn.proyecto01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Saludo3", urlPatterns = {"/Saludo3"})
public class Saludo3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String idioma = request.getParameter("idioma").toUpperCase();
	switch (idioma) {
	    case "SP":
		saludoSP(request, response);
		break;
	    case "EN":
		saludoEN(request, response);
		break;
	    case "FR":
		saludoFR(request, response);
		break;
	    default:
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:blue;'>Que paso!!</h1>");
	}
    }


    protected void saludoSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<h1 style='color:blue;'>Hola mundo fantastico desde doPost!!</h1>");
    }
    
    protected void saludoEN(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<h1 style='color:blue;'>Hello fantastic world from doPost!!</h1>");
    }
    
    protected void saludoFR(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<h1 style='color:blue;'>Bonjour le monde fantastique de doPost!!</h1>");
    }
    
}
