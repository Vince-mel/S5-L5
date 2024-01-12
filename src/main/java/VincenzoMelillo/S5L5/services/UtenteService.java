package VincenzoMelillo.S5L5.services;


import VincenzoMelillo.S5L5.entities.Utente;
import VincenzoMelillo.S5L5.repositories.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

	@Autowired
	UtenteDAO repo;
	
	public void saveUtente(Utente u) {
		repo.save(u);
	}
	
	public Utente getUtenteByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updateUtente(Utente u) {
		repo.save(u);
	}
	
	public void removeUtente(Utente u) {
		repo.delete(u);
	}
	
	public List<Utente> getAllUtente() {
		return (List<Utente>) repo.findAll();
	}
	

}
