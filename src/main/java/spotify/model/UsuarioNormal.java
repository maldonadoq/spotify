package spotify.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class UsuarioNormal extends Usuario{
	@Id
	@Column(length = 64, nullable = false)
	private String idUsuarioNormal;
	
	//@Column(nullable = false)
	private Boolean Estado;
	
	@OneToMany(mappedBy="usuarioNormal")
	List<Historial> historiales = new ArrayList<Historial>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Seguidor",
		joinColumns = @JoinColumn(name = "Usuario_id", referencedColumnName = "idUsuarioNormal"),
		inverseJoinColumns = @JoinColumn(name = "Sigue_id", referencedColumnName = "idUsuarioNormal")
	)
	private List<UsuarioNormal> Sigue;

	@OneToMany(mappedBy="usuarioNormal")
	List<Playlist> playlists = new ArrayList<Playlist>();
	
	
	
	public List<Historial> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public String getIdUsuarioNormal() {
		return idUsuarioNormal;
	}

	public void setIdUsuarioNormal(String idUsuarioNormal) {
		this.idUsuarioNormal = idUsuarioNormal;
	}

	public List<UsuarioNormal> getSigue() {
		return Sigue;
	}

	public void setSigue(List<UsuarioNormal> sigue) {
		Sigue = sigue;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}
}
