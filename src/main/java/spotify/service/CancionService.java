package spotify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spotify.model.Cancion;
import spotify.repository.CancionRepository;

@Service
public class CancionService {
	@Autowired
	  CancionRepository repository;

	  public List<Cancion> getAll() {
		  return repository.findAll();
	  }
	  
	  
	  public List<Cancion> getMatchName(String name) {
		  return repository.findMatchName(name);
	  }

}
