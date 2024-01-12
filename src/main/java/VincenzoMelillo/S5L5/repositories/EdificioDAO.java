package VincenzoMelillo.S5L5.repositories;


import VincenzoMelillo.S5L5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, Long> {


    @Query("SELECT e FROM Edificio e WHERE e.citta = ?1")
    public List<Edificio> findEdificioByCitta(String citta);


}
