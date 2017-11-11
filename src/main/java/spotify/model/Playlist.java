package spotify.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

public class Playlist {
	@Id 
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int idPlaylist;

	@Column(length = 32, nullable = false)
	private String nombrePlaylist;
	
	@ManyToOne
	private UsuarioNormal usuarioNormal;
	
	@ManyToMany(targetEntity=Cancion.class)
	private Set cancionSet;
	
	
	
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
