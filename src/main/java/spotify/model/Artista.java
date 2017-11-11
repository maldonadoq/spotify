package spotify.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public abstract class Artista {
	@Id	
	private Integer Id_artista;

	@Column(name = "Nom_Artista", length = 64, nullable  = false)
	public String Nom_Artista;

	@ManyToMany(targetEntity = Artista.Persona.class)
	private Set artistasSet;

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

	public Set getArtistasSet() {
		return artistasSet;
	}

	public void setArtistasSet(Set artistasSet) {
		this.artistasSet = artistasSet;
	}
}


