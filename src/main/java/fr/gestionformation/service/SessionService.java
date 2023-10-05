package fr.gestionformation.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.gestionformation.entitie.Session;

@Service
public interface SessionService {
	
	public Page<Session> getAllSessions(Pageable page);
	public Optional<Session> getOneSession(Long id);

}
