package spotify.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public abstract class ArtistaPersona {
	//Cada artista unitario posee un ID
	@Id
	private Integer Id_artista_persona;
	
	@Column(name ="Nombre", length = 64, nullable = false)
	private String Nombre;
	
	@Column(name = "Ap_pat" ,length = 64, nullable = false)
	private String ApellidoPaterno;
	
	
	@Column(name = "Ap_mat" ,length = 64, nullable = false)
	private String ApellidoMaterno;

	//Un cantante forma parte de una banda.
	@ManyToOne
	private Artista artista;
	
	@ManyToMany(mappedBy="artistasPersona")
	private Set<Artista> artistas = new HashSet<Artista>();
	
	
	
	

	public Integer getId_artista_persona() {
		return Id_artista_persona;
	}

	public void setId_artista_persona(Integer id_artista_persona) {
		Id_artista_persona = id_artista_persona;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Set<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
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
