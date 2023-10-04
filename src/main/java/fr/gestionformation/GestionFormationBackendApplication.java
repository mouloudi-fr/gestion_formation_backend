package fr.gestionformation;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.gestionformation.entitie.Session;
import fr.gestionformation.repository.SessionRepository;

@SpringBootApplication
public class GestionFormationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionFormationBackendApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner commandLineRunner (SessionRepository sessionRepository) {
		return arg->{
			
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
			sessionRepository.save(session1);
			sessionRepository.save(session2);
		};
	}
	*/

}
