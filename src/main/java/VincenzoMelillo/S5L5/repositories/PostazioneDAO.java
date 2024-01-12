package VincenzoMelillo.S5L5.repositories;


import VincenzoMelillo.S5L5.entities.Postazione;
import VincenzoMelillo.S5L5.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {

     @Query("SELECT p FROM Postazione p WHERE p.tipo = ?1")
	 public List<Postazione> findPostazioneByTipo(Tipo tipo);
}
