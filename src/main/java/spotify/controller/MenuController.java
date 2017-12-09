package spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import spotify.service.MenuService;

@Controller
@RequestMapping("/spotify")
public class MenuController {
	@Autowired
	  MenuService menuService;
	
	  @RequestMapping
	  public String mostrarMenuPrincipal(ModelMap model,
	      @RequestParam(value = "message", required = false) String message) {
	    model.addAttribute("message", message);
	    return "menu/menu";
	  }
	  
	  @RequestMapping("/about")
	  public String mostrarInformacion() {	
	    return "menu/about";
	  }
	  
	  @RequestMapping("/registro")
	  public String registrarUsuarioNormal() {	
	    return "menu/registro";
	  }
	  
	  @RequestMapping("/login")
	  public String iniciarSesion() {	
	    return "menu/login";
	  }
}