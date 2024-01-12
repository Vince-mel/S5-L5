package VincenzoMelillo.S5L5;


import VincenzoMelillo.S5L5.entities.Edificio;
import VincenzoMelillo.S5L5.services.EdificioService;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {

        creaEdificio();
    }


    public void creaEdificio() {
        Edificio e = new Edificio();
        e.setNome_edificio("Palazzo Vattelapesca");
        e.setCitta("Palermo");
        e.setIndirizzo("Via Dei Merluzzi");

        System.out.println(e);
        edificioSrv.saveEdificio(e);
        log.info("Edificio creato in DB");
    }



}
