package fr.gestionformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gestionformation.entitie.Session;


@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

}
