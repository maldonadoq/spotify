package spotify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public abstract class Usuario{
	
	@Column(length = 64, nullable = false)
	protected String Nombre;
	
	@Column(name = "Ap_pat", length = 64, nullable = false)
	protected String ApellidoPaterno;
	
	@Column(name = "Ap_mat", length = 64)
	protected String ApellidoMaterno;
	
	@Column(length = 64, nullable = false)
	protected String Correo;

	
//----------------------GETTER AND SETTER--------------------------

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
