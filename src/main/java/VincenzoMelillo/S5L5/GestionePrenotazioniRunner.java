package VincenzoMelillo.S5L5;


import VincenzoMelillo.S5L5.entities.*;
import VincenzoMelillo.S5L5.services.EdificioService;
import VincenzoMelillo.S5L5.services.PostazioneService;
import VincenzoMelillo.S5L5.services.PrenotazioneService;
import VincenzoMelillo.S5L5.services.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class GestionePrenotazioniRunner implements ApplicationRunner {


    static Logger log = LoggerFactory.getLogger(GestionePrenotazioniRunner.class);

    @Autowired
    EdificioService edificioSrv;
    @Autowired
    PostazioneService postazioneSrv;
    @Autowired
    UtenteService utenteSrv;

    @Autowired
    PrenotazioneService prenotazioneSrv;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        creaEdificio();
//        creaPostazione();




//        EdificioPostazioni(1L);

        getInfoEdificio(1l);


        //        creaUtente();

               //id_utente //id_postazione //datadaprenotare

//        Prenota(1l,1l,"2024-02-20");



        getInfoPrenotazione(1l);









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



    public void EdificioPostazioni(Long id) {
        Edificio ed = edificioSrv.getEdificioByID(id);
        Postazione p1 = postazioneSrv.getPostazioneByID(1l);
        p1.setEdificio(ed);
        postazioneSrv.updatePostazione(p1);
        edificioSrv.updateEdificio(ed);
        log.info("Edificio assegnato alla postazione");

    }

    public void getInfoEdificio(Long id) {
        edificioSrv.printInfo(id);
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

    public void Prenota(Long id_u, Long id_p, String data) {
        Prenotazione prenota = new Prenotazione();
        Utente u = utenteSrv.getUtenteByID(id_u);
        Postazione p = postazioneSrv.getPostazioneByID(id_p);

        if(p.isLibera() || p.checkDataIfLibera(data)==false && u.checkDateUtente(data)==false) {
            prenota.setUtente(u);
            prenota.setPostazione(p);
            prenota.setDataPrenotazione(LocalDate.parse(data));

            p.setLibera(false);

            System.out.println(prenota);

            prenotazioneSrv.savePrenotazione(prenota);
            postazioneSrv.updatePostazione(p);
            log.info("Prenotazione effettuata con successo");

        }else if(u.checkDateUtente(data)) {
            log.info("ERROE: hai già prenotato una postazione per quella data");
        }else if(p.checkDataIfLibera(data)) {
            log.info("ERROE: la postazione è già prenotata per quella data");
        }
    }


    public void getInfoPrenotazione(Long id) {
        prenotazioneSrv.printInfo(id);
    }



}
