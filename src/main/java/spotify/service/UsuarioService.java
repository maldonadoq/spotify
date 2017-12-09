package spotify.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.model.UsuarioNormal;
import spotify.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository repository;

  public boolean existeUsuario(String correo) {
	  List<UsuarioNormal> usuarios = repository.findByCorreo(correo);
	  if (usuarios.size() >= 1)
		  return true;
	  else
		  return false;
  }
  
  public boolean usuarioCorrecto(String correo, String password) {
	  List<UsuarioNormal> usuarios = repository.findByCorreo(correo);
	  if (usuarios.size() == 1 && usuarios.get(0).getPassword() == password)
		  return true;
	  else
		  return false;
  }
  
  public int numUsuariosNormales() {
	  return repository.numeroDeUsuariosNormales();
  }
  
  public List<UsuarioNormal> getAll() {
    return repository.findAll();
  }

  public UsuarioNormal getById_usuario(Integer Id_usuario) {
    return repository.findOne(Id_usuario);
  }

  public UsuarioNormal save(UsuarioNormal usuarioChanged) {
    System.out.println("Modificando: " + usuarioChanged.getIdUsuarioNormal());
    UsuarioNormal usuario = repository.findOne(usuarioChanged.getIdUsuarioNormal());
    if (usuario != null) {
      usuario.setApellidoPaterno(usuarioChanged.getApellidoPaterno());
      usuario.setApellidoMaterno(usuarioChanged.getApellidoMaterno());
      usuario.setNombre(usuarioChanged.getNombre());
    } else {
      usuario = usuarioChanged;
    }

    return repository.save(usuario);
  }
    
}
