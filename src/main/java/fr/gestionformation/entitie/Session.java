package fr.gestionformation.entitie;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Le champs ne doit pas être vide")
	private String name;
	private String track;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dateSession;
	private int duration;
	private String address;
	private int participants;
	private boolean isCompleted;
	
}
