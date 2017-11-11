package spotify.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import spotify.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
  List<Usuario> findAll();
}
