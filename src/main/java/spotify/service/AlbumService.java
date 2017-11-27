package spotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spotify.repository.AlbumRepository;

@Service
public class AlbumService {
	@Autowired
	  AlbumRepository repository;
	
}
