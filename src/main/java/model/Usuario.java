package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public abstract class Usuario {
	@Id 
	private Integer Id_usuario;
	
	@Column(length = 64, nullable = false)
	private String Nombre;
	
	@Column(name = "Ap_pat", length = 64, nullable = false)
	private String ApellidoPaterno;
	
	@Column(name = "Ap_mat", length = 64)
	private String ApellidoMaterno;
	
	@Column(length = 64, nullable = false)
	private String Correo;
}
