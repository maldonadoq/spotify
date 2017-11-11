package spotify.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spotify.model.Usuario;
import spotify.service.UsuarioService;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

  @Autowired
  UsuarioService UsuarioService;

  @RequestMapping
  public String listarUsuarios(ModelMap model,
      @RequestParam(value = "message", required = false) String message) {
    List<Usuario> Usuarios = UsuarioService.getAll();
    model.addAttribute("Usuarios", Usuarios);
    model.addAttribute("message", message);
    return "Usuario/list";
  }

  @RequestMapping("/{codigo}")
  public String editarUsuario(ModelMap model, @PathVariable("codigo") String codigo) {
    Usuario Usuario = UsuarioService.getByCodigo(codigo);
    model.addAttribute("Usuario", Usuario);
    model.addAttribute("fullName", String.format("%s/%s, %s", Usuario.getApellidoPaterno(),
        Usuario.getApellidoMaterno(), Usuario.getNombres()));
    return "Usuario/editar";
  }

  @RequestMapping("/new")
  public String nuevoUsuario(ModelMap model) {
    Usuario Usuario = new Usuario();
    model.addAttribute("Usuario", Usuario);
    model.addAttribute("title", "Nuevo Usuario");
    return "Usuario/editar";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveUsuario(@ModelAttribute Usuario UsuarioChanged, ModelMap model) {
    UsuarioService.save(UsuarioChanged);
    return "redirect:/Usuario?message=El Usuario se actualizo correctamente";
    // return listarUsuarios(model);
  }

}