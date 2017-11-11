package spotify.rest;

import spotify.model.Usuario;
import spotify.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioRest {

    @Autowired
    UsuarioService UsuarioService;

    @RequestMapping("/listar.json")
    @ResponseBody
    public List<Usuario> listarUsuarios() {
        List<Usuario> Usuarios = UsuarioService.getAll();
        return Usuarios;
    }

    @RequestMapping("/{Id_usuario}.json")
    @ResponseBody
    public Usuario Usuario(@PathVariable("Id_usuario") String Id_usuario) {
        Usuario Usuario = UsuarioService.getById_usuario(Id_usuario);
        return Usuario;
    }
}