package VincenzoMelillo.S5L5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prenotazione;
	private LocalDate dataPrenotazione;
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;
	@ManyToOne
	@JoinColumn(name = "codice_univoco")
	private Postazione postazione;
	
}
