package VincenzoMelillo.S5L5.services;


import VincenzoMelillo.S5L5.entities.Edificio;
import VincenzoMelillo.S5L5.repositories.EdificioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EdificioService {

	@Autowired
	EdificioDAO repo;
	
	public void saveEdificio(Edificio e) {
		repo.save(e);
	}
	
	public Edificio getEdificioByID(Long id) {	
		return repo.findById(id).get();
	}
	
	public void updateEdificio(Edificio e) {
		repo.save(e);
	}
	
	public void removeEdificio(Edificio e) {
		repo.delete(e);
	}
	
	public List<Edificio> getAllEdificio() {
		return (List<Edificio>) repo.findAll();
	}
	
	public List<Edificio> getEdificioByCitta(String citta){
		return repo.findEdificioByCitta(citta);
	}
	
	public void printInfo(Long id) {
		Edificio ed = repo.findById(id).get();
		System.out.println("INFO EDIFICIO(" + ed.getId_edificio() + "):\n" + ed + "\n" + "POSTAZIONI (" + ed.getPostazioni().size() + "):\n" + ed.getPostazioni());
	}
	
}
	


