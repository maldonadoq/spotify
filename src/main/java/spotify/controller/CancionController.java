package spotify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spotify.model.Cancion;
import spotify.service.CancionService;

@Controller
@RequestMapping("/cancion")
public class CancionController {
	@Autowired
	  CancionService cancionService;
	
	@RequestMapping
	  public String listarCanciones(ModelMap model,
	      @RequestParam(value = "message", required = false) String message) {
	    List<Cancion> canciones = cancionService.getAll();
	    model.addAttribute("canciones", canciones);
	    model.addAttribute("message", message);
	    return "cancion/list";
	  }
	
	//@RequestMapping(value = "/{Nombre}", method = RequestMethod.GET)
	@RequestMapping("/{Nombre}")
	  public String mathCanciones(ModelMap model, @PathVariable("Nombre") String name) {
		List<Cancion> canciones = cancionService.getMatchName(name);
	    model.addAttribute("canciones", canciones);
	    return "cancion/list";
	  }
}
