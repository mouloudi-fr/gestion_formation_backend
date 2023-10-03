package fr.gestionformation.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.gestionformation.entitie.Session;
import fr.gestionformation.service.SessionService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;



@ExtendWith(SpringExtension.class)
@WebMvcTest(SessionRestController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Slf4j
class SessionRestControllerTest {

	
	
	@MockBean
	private SessionService sessionService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	Session session1 = Session.builder()
			.name("Développeur web")
			.track("Java")
			.dateSession(LocalDateTime.of(2023, 10, 20, 11,30))
			.duration(50)
			.isCompleted(false)
			.participants(4)
			.address("22 rue jean 59000, Lille")
			.build();
	
	Session session2 = Session.builder()
			.name("Développeur mobile")
			.track("Flutter")
			.dateSession(LocalDateTime.of(2024, 01, 20, 14,30))
			.duration(60)
			.isCompleted(false)
			.participants(9)
			.address("2 rue de luis 59100 Roubaix")
			.build();
	
	List<Session> sessions=new ArrayList<>();
	

	
	@BeforeEach
	void setUp() throws Exception {
		
		log.trace("START TEST setUp ...");
		
		sessions.add(session1);
		sessions.add(session2);

	}

	@Test
	void testInjectComponentAreNotNull() {
		assertNotNull(this.mockMvc);
		assertNotNull(this.objectMapper);
		assertNotNull(this.sessionService);
	}

	@Test
	void shouldReturnListOfSessions() throws Exception {
		
		// Given
		
		when(this.sessionService.getAllSessions(PageRequest.of(0, 10)))
		.thenReturn(new PageImpl<>(sessions));
		
		// When
		
		RequestBuilder request =get("/v1/sessions").contentType("application/json");
		MvcResult mvcResult =mockMvc.perform(request)
				.andDo(print())
				.andExpect(status().is(200))
				.andReturn();
		
		// Then
		
		String sessionAsString = mvcResult.getResponse().getContentAsString();
		
		PageImplDeserializer<Session> sessionPage =objectMapper.readValue(sessionAsString, new TypeReference<PageImplDeserializer<Session>>() {});
		assertEquals(sessionPage.getNumberOfElements(), 2);
		log.info("---------------------->>>>>>>"+sessionPage.numberOfElements);
		
	}
	
	@Data
	public static class PageImplDeserializer<T> {
	    
		private List<T> content;
	    private int number;
	    private int size;
	    private Long totalElements;
	    private JsonNode pageable;
	    private boolean last;
	    private int totalPages;
	    private JsonNode sort;
	    private boolean first;
	    private int numberOfElements;

	}
}
