package spotify.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Historial {
	@Id
	private Integer Id_historial;

	@ManyToOne
	private Usuario User;
	
	private Date Fecha;
	
	@Column(length = 64, nullable = false)
	private String Busqueda;
  

	public Usuario getUser() {
		return User;
	}

	public void setUser(Usuario user) {
		User = user;
	}
}
