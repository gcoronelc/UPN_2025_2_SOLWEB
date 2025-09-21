package pe.edu.upn.educaweb.prueba;

import pe.edu.upn.educaweb.dto.EmpleadoDto;
import pe.edu.upn.educaweb.service.LogonService;

public class Prueba03ValidaUsuario02 {
	
	public static void main(String[] args) {
		// Datos
		String usuario = "kdelgado";
		String clave = "siimporta";
		
		// Proceso
		LogonService logonService = new LogonService();
		EmpleadoDto dto = logonService.validarUsuario(usuario, clave);
		
		// Reporte
		if(dto == null){
			System.out.println("Datos incorrectos.");
		} else {
			System.out.println("Datos correctos, hola " + dto.getNombre() + ".");
		}
	}
}
