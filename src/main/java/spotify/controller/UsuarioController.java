package spotify.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import spotify.model.Post;
import spotify.model.UsuarioNormal;
import spotify.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
  @Autowired
  UsuarioService usuarioService;

  @RequestMapping
  public String listarUsuarios(ModelMap model,
      @RequestParam(value = "message", required = false) String message) {
    List<UsuarioNormal> usuarios = usuarioService.getAll();
    model.addAttribute("usuarios", usuarios);
    model.addAttribute("message", message);
    return "usuario/list";
  }
  
  @RequestMapping("/{idUsuarioNormal}")
  public String editarUsuario(ModelMap model, @PathVariable("idUsuarioNormal") Integer codigo) {
    UsuarioNormal usuario = usuarioService.getById_usuario(codigo);
    model.addAttribute("usuario", usuario);
    model.addAttribute("fullName", String.format("%s/%s, %s", usuario.getApellidoPaterno(),
        usuario.getApellidoMaterno(), usuario.getNombre()));
    return "usuario/editar";
  }

  @RequestMapping("/new")
  public String nuevoUsuario(ModelMap model) {
    UsuarioNormal usuario = new UsuarioNormal();
    model.addAttribute("usuario", usuario);
    model.addAttribute("title", "Nuevo Usuario");	
    return "usuario/editar";
  }
  
  @RequestMapping(value="/perfil", method = RequestMethod.POST)
  public String perfilUsuario(@ModelAttribute UsuarioNormal usuarioChanged, ModelMap model){
	usuarioChanged.setIdUsuarioNormal(new Integer(0));
	String correo = usuarioChanged.getCorreo();
	String password = usuarioChanged.getPassword();
	boolean usuarioCorrecto = usuarioService.usuarioCorrecto(correo, password);
	
	if (usuarioCorrecto == true)
	{
		model.addAttribute("usuario", usuarioChanged);
		return "usuario/perfil";
	}
	else
		return "menu/menu";
  }
  
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveUsuario(@ModelAttribute UsuarioNormal usuarioChanged, ModelMap model) {
	String correo = usuarioChanged.getCorreo();
	boolean existeUsuario = usuarioService.existeUsuario(correo);
	
	if (existeUsuario == true)
	{
		return "menu/menu";
	}
	else
	{
		usuarioChanged.setEstado(true);
		usuarioChanged.setIdUsuarioNormal(new Integer(usuarioService.numUsuariosNormales() + 1));
		usuarioService.save(usuarioChanged);
	    return "usuario/perfil";
	}
  }

  @RequestMapping("/searchCode")
  public String paginaBuscarCodigo(ModelMap model) {
    return "usuario/searchUserCode";
  }
  
  @RequestMapping(value="/search", method = RequestMethod.POST)
  public String buscarCodigo(@ModelAttribute Post postChanged, ModelMap model) {
	UsuarioNormal usuario = usuarioService.getById_usuario(Integer.parseInt(postChanged.getVar1()));
	List<UsuarioNormal> usuarios = usuarioService.getAll();
	if (!usuarios.contains(usuario)) {
		return "redirect:/usuario?message=No se encuentra el Usuario.";
	}
	model.addAttribute("usuario", usuario);
    return "usuario/editar";
  }
  
  @RequestMapping("/register")
  public String Register(ModelMap model) {
	  return "usuario/register";
  }
}