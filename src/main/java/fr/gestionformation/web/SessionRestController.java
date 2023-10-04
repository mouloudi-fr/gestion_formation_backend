package fr.gestionformation.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.gestionformation.entitie.Session;
import fr.gestionformation.service.SessionService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/sessions")
@Slf4j
public class SessionRestController {

	
	
	@Autowired
	private SessionService sessionService;
	
	
	
	  @GetMapping()
	  @ResponseBody
	  public ResponseEntity<Page<Session>> allSessions(@RequestParam(required = false) Integer
	  page, @RequestParam(required = false) Integer size){
	  
	  
	  return page !=null && size!=null ?
	  ResponseEntity.ok(sessionService.getAllSessions(PageRequest.of(page, size)))
	  : ResponseEntity.ok(sessionService.getAllSessions(PageRequest.of(0, 10)));
	  
	  }
	 

}
