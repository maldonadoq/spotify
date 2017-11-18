package spotify.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Historial {
	@Id
	private Integer Id_historial;

	@ManyToOne
	@JoinColumn(name="id_usuarioNormal")
	private UsuarioNormal usuarioNormal;
	
	private Date Fecha;
	
	@Column(length = 64, nullable = false)
	private String Busqueda;

	public Integer getId_historial() {
		return Id_historial;
	}

	public void setId_historial(Integer id_historial) {
		Id_historial = id_historial;
	}

	public UsuarioNormal getUsuarioNormal() {
		return usuarioNormal;
	}

	public void setUsuarioNormal(UsuarioNormal usuarioNormal) {
		this.usuarioNormal = usuarioNormal;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getBusqueda() {
		return Busqueda;
	}

	public void setBusqueda(String busqueda) {
		Busqueda = busqueda;
	}
	
	
}
