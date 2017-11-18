package spotify.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import spotify.model.UsuarioNormal;

public interface UsuarioRepository extends CrudRepository<UsuarioNormal, String>{
	List<UsuarioNormal> findAll();
}
