package spotify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Artista")
public abstract class ArtistaPersona {
	//Cada artista unitario posee un ID
	@Id
	private Integer Id_artista;
	
	@Column(name ="Nombre", length = 64, nullable = false)
	private String Nombre;
	
	@Column(name = "Ap_pat" ,length = 64, nullable = false)
	private String ApellidoPaterno;
	
	
	@Column(name = "Ap_mat" ,length = 64, nullable = false)
	private String ApellidoMaterno;

	//Un cantante forma parte de una banda.
	@ManyToOne
	private Artista artista;
	
	public Integer getId_artista() {
		return Id_artista;
	}


	public void setId_artista(Integer id_artista) {
		Id_artista = id_artista;
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
	
	
}
