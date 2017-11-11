spackage spotify.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.model.Usuario;
import spotify.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository repository;

  public List<Usuario> getAll() {
    return repository.findAll();
  }

  public Usuario getById_usuario(String Id_usuario) {
    return repository.findOne(Id_usuario);
  }

  public Usuario save(Usuario UsuarioChanged) {
    System.out.println("Modificando: " + UsuarioChanged.getId_usuario());
    Usuario Usuario = repository.findOne(UsuarioChanged.getId_usuario());
    if (Usuario != null) {
      Usuario.setApellidoPaterno(UsuarioChanged.getApellidoPaterno());
      Usuario.setApellidoMaterno(UsuarioChanged.getApellidoMaterno());
      Usuario.setNombres(UsuarioChanged.getNombres());
    } else {
      Usuario = UsuarioChanged;
    }

    return repository.save(Usuario);
  }
}
