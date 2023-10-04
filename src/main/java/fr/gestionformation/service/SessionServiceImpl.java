package fr.gestionformation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.gestionformation.entitie.Session;
import fr.gestionformation.repository.SessionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

	
	@Autowired
	private SessionRepository sessionRepository;
	

	@Override
	public Page<Session> getAllSessions(Pageable page) {
		// TODO Auto-generated method stub
		return sessionRepository.findAll(page);
	}

}
