package fr.gestionformation.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.gestionformation.entitie.Session;

@Service
public interface SessionService {
	
	public Page<Session> getAllSessions(Pageable page);

}
