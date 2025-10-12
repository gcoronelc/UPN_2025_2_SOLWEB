package pe.edu.upn.demo01.service;

import org.springframework.stereotype.Service;

import pe.edu.upn.demo01.dto.OperaDto;

@Service
public class AlfaService {

	
	public OperaDto procesar(int n1, int n2) {
		// Proceso
		int suma = n1 + n2;
		int producto = n1 * n2;
		// Reporte
		OperaDto bean = new OperaDto(n1, n2, suma, producto);
		return bean;
	}
	
}
