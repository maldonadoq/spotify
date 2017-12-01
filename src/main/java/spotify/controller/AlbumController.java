package spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spotify.service.AlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController {
	@Autowired
	  AlbumService albumService;
}
