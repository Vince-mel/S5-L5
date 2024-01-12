package VincenzoMelillo.S5L5.repositories;


import VincenzoMelillo.S5L5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, Long> {


}
