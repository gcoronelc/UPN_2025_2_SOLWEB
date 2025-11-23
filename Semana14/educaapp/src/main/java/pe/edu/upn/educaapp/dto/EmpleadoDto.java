package pe.edu.upn.educaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {

	private int id;
	private String apellido;
	private String nombre;
	private String direccion;
	private String email;
	private String usuario;
	private String clave;

}
