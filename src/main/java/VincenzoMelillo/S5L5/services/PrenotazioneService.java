package VincenzoMelillo.S5L5.services;

import VincenzoMelillo.S5L5.entities.Prenotazione;
import VincenzoMelillo.S5L5.repositories.PrenotazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneDAO repo;
	
	public void savePrenotazione(Prenotazione p) {
		repo.save(p);
	}
	
	public Prenotazione getPrenotazioneByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updatePrenotazione(Prenotazione p) {
		repo.save(p);
	}
	
	public void removePrenotazione(Prenotazione p) {
		repo.delete(p);
	}
	
	public List<Prenotazione> getAllPrenotazione() {
		return (List<Prenotazione>) repo.findAll();
	}
	
	public void printInfo(Long id) {
		Prenotazione p = repo.findById(id).get();
		System.out.println("INFO PRENOTAZIONE: \n" + "ID: "+ p.getId_prenotazione() 
		+ "\n" + "PER " + p.getUtente().getNome_completo() + "\n" + "POSTAZIONE PRENOTATA" + p.getPostazione()
		+ "\n" + "DATA PRENOTAZIONE" + p.getDataPrenotazione()
		);
	}
}
