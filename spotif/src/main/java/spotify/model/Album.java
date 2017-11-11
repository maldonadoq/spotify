package spotify.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Entity
public class Album {
	@Id 
	@Column(length = 16)
	public String idAlbum;
	
	@Column(length = 64, nullable = false)
	public String nombreAlbum;
	
	public Date fechaAlbum;
	
	@ManyToMany(targetEntity=Artista.class)
   	private Set artistaSet;
}
