package spotify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spotify.model.Album;
import spotify.model.Cancion;
import spotify.repository.AlbumRepository;
import spotify.repository.CancionRepository;

@Service
public class CancionService{
	@Autowired
	CancionRepository repository;
	@Autowired
	AlbumRepository arepository;

	  public List<Cancion> getAll() {	
		  return repository.findAll();
	  }
	  
	  public List<Cancion> getMatchName(String name) {
		  return repository.findMatchName(name);
	  }
	  
	  public List<Cancion> getAlbumName(String name){
		  Album tmp = arepository.findAlbumName(name);	
		  return repository.findByAlbum(tmp);
	  }
	  
	  public List<Cancion> get100SongsPuntuation(String num){	
		  //return repository.findBestPunt(Integer.parseInt(num));
		  return repository.findAll();
	  }
}
