package spotify.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public abstract class Artista {
	@Id	
	private Integer Id_artista;

	@Column(name = "Nom_Artista", length = 64, nullable  = false)
	public String Nom_Artista;

	@ManyToMany
	@JoinTable(name="Artista_ArtistaPersona",
	joinColumns=@JoinColumn(name="id_artista"),
	inverseJoinColumns=@JoinColumn(name="id_artistaPersona"))
	private Set<ArtistaPersona> artistasPersona = new HashSet<ArtistaPersona>();
	
	@ManyToMany(mappedBy="artistas")
	private Set<Cancion> canciones = new HashSet<Cancion>();
	
	@ManyToMany(mappedBy="artistas")
	private Set<Album> albumes = new HashSet<Album>();
	
	
	

	public Set<ArtistaPersona> getArtistasPersona() {
		return artistasPersona;
	}

	public void setArtistasPersona(Set<ArtistaPersona> artistasPersona) {
		this.artistasPersona = artistasPersona;
	}

	public Set<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(Set<Cancion> canciones) {
		this.canciones = canciones;
	}

	public Set<Album> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(Set<Album> albumes) {
		this.albumes = albumes;
	}

	public Integer getId_artista() {
		return Id_artista;
	}

	public void setId_artista(Integer id_artista) {
		Id_artista = id_artista;
	}

	public String getNom_Artista() {
		return Nom_Artista;
	}

	public void setNom_Artista(String nom_Artista) {
		Nom_Artista = nom_Artista;
	}
}


