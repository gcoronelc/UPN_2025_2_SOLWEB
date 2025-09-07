package pe.edu.upn.proyecto01.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SumarService", urlPatterns = {"/SumarService"})
public class SumarService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Datos
	int num1 = Integer.parseInt( request.getParameter("numero1") );
	int num2 = Integer.parseInt( request.getParameter("numero2") );
	
	// Proceso
	int suma = num1 + num2;
	
	// Reporte
	request.setAttribute("num1", num1);
	request.setAttribute("num2", num2);
	request.setAttribute("suma", suma);
	RequestDispatcher rd = request.getRequestDispatcher("sumar2.jsp");
	rd.forward(request, response);
	
    }

    
    
    
    
}
