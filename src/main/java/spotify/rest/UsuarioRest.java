package spotify.rest;

import spotify.model.UsuarioNormal;
import spotify.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/listar.json")
    @ResponseBody
    public List<UsuarioNormal> listarUsuarios() {
        List<UsuarioNormal> usuarios = usuarioService.getAll();
        return usuarios;
    }

    @RequestMapping("/{idUsuarioNormal}.json")
    @ResponseBody
    public UsuarioNormal usuarioNormal(@PathVariable("idUsuarioNormal") String Id_usuario) {
        UsuarioNormal usuarioNormal = usuarioService.getById_usuario(Id_usuario);
        return usuarioNormal;
    }
}