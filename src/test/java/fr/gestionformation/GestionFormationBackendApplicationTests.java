package fr.gestionformation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes=GestionFormationBackendApplicationTests.class)
@ActiveProfiles("test")
@ContextConfiguration
class GestionFormationBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
