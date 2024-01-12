package VincenzoMelillo.S5L5.services;


import VincenzoMelillo.S5L5.entities.Postazione;
import VincenzoMelillo.S5L5.entities.Tipo;
import VincenzoMelillo.S5L5.repositories.PostazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

	@Autowired
	PostazioneDAO repo;
	
	public void savePostazione(Postazione p) {
		repo.save(p);
	}
	
	public Postazione getPostazioneByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updatePostazione(Postazione p) {
		repo.save(p);
	}
	
	public void removePostazione(Postazione p) {
		repo.delete(p);
	}
	
	public List<Postazione> getAllPostazione() {
		return (List<Postazione>) repo.findAll();
	}
	public List<Postazione> getPostazioneByTipo(Tipo tipo){
		return repo.findPostazioneByTipo(tipo);
	}
}
