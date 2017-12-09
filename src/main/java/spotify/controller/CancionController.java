package spotify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spotify.model.Cancion;
import spotify.model.Post;
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
	

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	  public String matchCanciones(@ModelAttribute Post postChanged, ModelMap model){
		List<Cancion> canciones = cancionService.getMatchName(postChanged.getVar1());
	    model.addAttribute("canciones", canciones);
	    return "cancion/list";
	  }
	
	@RequestMapping(value = "/playlist")
	  public String matchCanciones(ModelMap model){
		List<Cancion> canciones = cancionService.getAll();
	    model.addAttribute("canciones", canciones);
	    return "cancion/playlist";
	  }
	
	@RequestMapping(value = "/puntuacion")
	  public String SongPuntuation(@ModelAttribute Post postChanged, ModelMap model){
		List<Cancion> canciones = cancionService.get100SongsPuntuation(postChanged.getVar1());
	    model.addAttribute("canciones", canciones);
	    return "cancion/list";
	  }

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	  public String albumCanciones(@ModelAttribute Post postChanged, ModelMap model) {
		List<Cancion> canciones = cancionService.getAlbumName(postChanged.getVar1());
	    model.addAttribute("canciones", canciones);
	    return "cancion/list";
	  }
}
