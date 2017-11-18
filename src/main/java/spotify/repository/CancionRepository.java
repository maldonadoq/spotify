package spotify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import spotify.model.Cancion;

public interface CancionRepository extends CrudRepository<Cancion, String>{
	List<Cancion> findAll();
	
	@Query("select c from Cancion c where c.Nombre like %?1%")
    List<Cancion> findMatchName(String name);
	
	//fk_album
	@Query("select a from Cancion a where a.Nombre = ?1")
    List<Cancion> findAlbumCodigo(String name);
}
