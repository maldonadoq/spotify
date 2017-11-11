package spotify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
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

	public Integer getId_usuario() {
		return Id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		Id_usuario = id_usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}
}
