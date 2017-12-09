package spotify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spotify.model.UsuarioNormal;

public interface UsuarioRepository extends CrudRepository<UsuarioNormal, Integer>{
	public List<UsuarioNormal> findAll();
	
	@Query("select u from UsuarioNormal u where u.Correo like %?1%")
	List<UsuarioNormal> findByCorreo(String correo);
	
	@Query("select count(*) from UsuarioNormal")
	public int numeroDeUsuariosNormales();
}
