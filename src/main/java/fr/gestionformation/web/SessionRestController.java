package fr.gestionformation.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.gestionformation.entitie.Session;
import fr.gestionformation.exceptions.ResourceNotFoundException;
import fr.gestionformation.service.SessionService;
import jakarta.validation.Valid;
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
	  
	  @GetMapping("/{id}")
	  @ResponseBody
	  public ResponseEntity<Session> getOneSession(@PathVariable String id){
		  
		  Long sessionId=Long.parseLong(id);
		  Session session = sessionService.getOneSession(sessionId)
				  .orElseThrow(() -> (new ResourceNotFoundException("Session", "id", sessionId)));
		  
		  
		  log.info("-------------->"+session.toString());
		  return new ResponseEntity<Session>(session,HttpStatus.OK);
	  }
	 

	   @PostMapping("/addSession")
	   public ResponseEntity<Session> addSession(@RequestBody @Valid Session session){
		   
		   try {
			   Session sessionAdd = sessionService.saveSession(session);
			   
			   return new ResponseEntity<Session>(sessionAdd,HttpStatus.CREATED);
		   }
		   catch (Exception e) {
			// TODO: handle exception
			   log.error(e.getMessage());
		}
		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
		   
		   
	   }
	   
	   @DeleteMapping("/deleteSession/{id}")
	    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String id) {
		   Long sessionId=Long.parseLong(id);
	        sessionService.deleteSession(sessionId);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	    }
}
