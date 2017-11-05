package spotify.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Playlist {
	@Id 
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int idPlaylist;

	@Column(length = 32, nullable = false)
	private String nombrePlaylist;
}
