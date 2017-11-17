package spotify.model;

import java.util.Set;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class Cancion {
	@Id
	private Integer Id_cancion;
		
	@Column(length = 32, nullable = false)
	private String Nombre;
	
	private Date Fecha;
	
	@Column(columnDefinition = "Text")
	private String Letra;
	
	private Integer Puntuacion;
		
	@ManyToMany
	@JoinTable(name="cancion_playlist",
	joinColumns=@JoinColumn(name="id_cancion"),
	inverseJoinColumns=@JoinColumn(name="id_playlist"))
	private Set<Playlist> playlists = new HashSet<Playlist>();
	
	@ManyToMany
	@JoinTable(name="ancion_artista",
	joinColumns=@JoinColumn(name="id_cancion"),
	inverseJoinColumns=@JoinColumn(name="id_artista"))
	private Set<Artista> artistas = new HashSet<Artista>();
	
	@ManyToOne
	@JoinColumn(name="fk_album")
	private Album album;
	
	
	
	

	public Set<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<Playlist> playlists) {
		this.playlists = playlists;
	}

	public Set<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Integer getId_cancion() {
		return Id_cancion;
	}

	public void setId_cancion(Integer id_cancion) {
		Id_cancion = id_cancion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getLetra() {
		return Letra;
	}

	public void setLetra(String letra) {
		Letra = letra;
	}

	public Integer getPuntuacion() {
		return Puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		Puntuacion = puntuacion;
	}
}
