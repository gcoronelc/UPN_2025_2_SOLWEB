package pe.edu.upn.demo01.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upn.demo01.dto.OperaDto;
import pe.edu.upn.demo01.service.AlfaService;

@RestController
public class Alfa {
	
	@Autowired
	private AlfaService alfaService;
	
	@GetMapping("/saludo")
	public String saludo() {
		return "Hola, estas en el camino correcto para ser millonario!!!";
	}
	
	@GetMapping("/sumar")
	public String sumar(int n1, int n2) {
		int suma = n1 + n2;
		String repo = "Suma de " + n1 + " + " + n2 + " es igual a " + suma + ".";
		return repo;
	}
	
	@PostMapping("/opera")
	public OperaDto opera(int n1, int n2) {
		return alfaService.procesar(n1, n2);
	}
	
	@PostMapping("/opera2")
	public OperaDto opera(@RequestBody OperaDto bean) {
		return alfaService.procesar(bean.getN1(), bean.getN2());
	}

}
