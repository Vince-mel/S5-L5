package VincenzoMelillo.S5L5;


import VincenzoMelillo.S5L5.entities.Edificio;
import VincenzoMelillo.S5L5.entities.Postazione;
import VincenzoMelillo.S5L5.entities.Tipo;
import VincenzoMelillo.S5L5.entities.Utente;
import VincenzoMelillo.S5L5.services.EdificioService;
import VincenzoMelillo.S5L5.services.PostazioneService;
import VincenzoMelillo.S5L5.services.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GestionePrenotazioniRunner implements ApplicationRunner {


    static Logger log = LoggerFactory.getLogger(GestionePrenotazioniRunner.class);

    @Autowired
    EdificioService edificioSrv;
    @Autowired
    PostazioneService postazioneSrv;
    @Autowired
    UtenteService utenteSrv;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        creaEdificio();
        creaPostazione();
        creaUtente();
    }


    public void creaEdificio() {
        Edificio e = new Edificio();
        e.setNome_edificio("Palazzo Vattelapesca");
        e.setCitta("Palermo");
        e.setIndirizzo("Via Dei Merluzzi");

        System.out.println(e);
        edificioSrv.saveEdificio(e);
        log.info("Edificio salvato nel DB");
    }


    public void creaPostazione() {
        Postazione p = new Postazione();
        p.setTipo(Tipo.SALA_RIUNIONI);
        p.setDescrizione("Aula Magna");
        p.setNumero_max_occupanti(30);

        System.out.println(p);
        postazioneSrv.savePostazione(p);
        log.info("Postazione salvata nel DB");
    }

    public void creaUtente() {
        Utente u = new Utente();
        u.setNome_completo("Guido LaVespa");
        u.setUsername("guido88");
        u.setEmail("guido88@gmail.com");

        System.out.println(u);
        utenteSrv.saveUtente(u);
        log.info("Utente salvato nel DB");
    }



}
