package spotify.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class Playlist {
	@Id 
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int idPlaylist;

	@Column(length = 32, nullable = false)
	private String nombrePlaylist;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_normal")
	private UsuarioNormal usuarioNormal;
	
	@ManyToMany(mappedBy="playlists")
	private Set<Cancion> canciones = new HashSet<Cancion>();
	
	
	
	
	public Set<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(Set<Cancion> canciones) {
		this.canciones = canciones;
	}

	public UsuarioNormal getUsuarioNormal() {
		return usuarioNormal;
	}

	public void setUsuarioNormal(UsuarioNormal usuarioNormal) {
		this.usuarioNormal = usuarioNormal;
	}

	public int getIdPlaylist() {
		return idPlaylist;
	}

	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	public String getNombrePlaylist() {
		return nombrePlaylist;
	}

	public void setNombrePlaylist(String nombrePlaylist) {
		this.nombrePlaylist = nombrePlaylist;
	}
}
