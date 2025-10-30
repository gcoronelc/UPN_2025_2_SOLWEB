package pe.edu.upn.educaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDto {
	
	private int idCurso; // Codigo del curso.
	private int idAlumno; // Codigo del estudiante.
	private String tipo; // Tipo de matricula, puede ser: REGULAR, MEDIABECA o BECA.
	private int cuotas; // La cantidad de cuotas en que se paga el precio, puede ser 1, 2 o 3.
	private int idEmpleado; // El codigo del eempleado que registra la matricula.
	private double precio; // El precio del curso.
	private String estado; // El estado del proceso.
	
}
