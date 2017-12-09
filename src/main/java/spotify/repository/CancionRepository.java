package spotify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import spotify.model.Album;
import spotify.model.Cancion;

public interface CancionRepository extends CrudRepository<Cancion, String>{
	List<Cancion> findAll();
	
	@Query("select c from Cancion c where c.Nombre like %?1%")
    List<Cancion> findMatchName(String name);
	
	//fk_album
	List<Cancion> findByAlbum(Album album);
}
