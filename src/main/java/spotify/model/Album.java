package spotify.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Album {
	@Id
	@Column(length = 16)
	public String idAlbum;
	
	@Column(length = 64, nullable = false)
	public String nombreAlbum;
	
	public Date fechaAlbum;
	
	@ManyToMany
	@JoinTable(name="album_artista",
	joinColumns=@JoinColumn(name="id_album"),
	inverseJoinColumns=@JoinColumn(name="id_artista"))
   	private Set<Artista> artistas = new HashSet<Artista>();
	
	@OneToMany(mappedBy="album")
	private List<Cancion> canciones = new ArrayList<Cancion>();
	
	
	
	public Set<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public String getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(String idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getNombreAlbum() {
		return nombreAlbum;
	}

	public void setNombreAlbum(String nombreAlbum) {
		this.nombreAlbum = nombreAlbum;
	}

	public Date getFechaAlbum() {
		return fechaAlbum;
	}

	public void setFechaAlbum(Date fechaAlbum) {
		this.fechaAlbum = fechaAlbum;
	}
	
	
}
