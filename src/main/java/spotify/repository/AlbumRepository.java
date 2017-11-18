package spotify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import spotify.model.Album;


public interface AlbumRepository extends CrudRepository<Album, String>{
	List<Album> findAll();
	
	@Query("select a from Album a where a.nombreAlbum = ?1")
    Album findAlbumName(String name);
}