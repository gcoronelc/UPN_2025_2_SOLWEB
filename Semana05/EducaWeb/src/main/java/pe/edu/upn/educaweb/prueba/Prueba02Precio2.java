package pe.edu.upn.educaweb.prueba;

import pe.edu.upn.educaweb.service.EducaService;

public class Prueba02Precio2 {

	public static void main(String[] args) {
		// Datos
		int idCurso = 0;
		// Proceso
		EducaService educaService = new EducaService();
		double precio = educaService.consultarPrecio(idCurso);
		// Reporte
		System.out.println("IdCurso: " + idCurso);
		System.out.println("Precio: " + precio);
	}

	
}
