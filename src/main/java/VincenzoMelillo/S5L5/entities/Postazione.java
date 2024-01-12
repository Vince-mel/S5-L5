package VincenzoMelillo.S5L5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Postazione implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codice_univoco;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private Integer numero_max_occupanti;
	@ManyToOne
	@JoinColumn(name = "id_edificio")
	private Edificio edificio;
	private boolean isLibera = true;
	@OneToMany(mappedBy = "postazione", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Prenotazione> prenotazioni;
	
	@Override
	public String toString() {
		return "ID=" + codice_univoco + "\n" + "descrizione=" + descrizione + "\n" + "tipo=" + tipo
				+ "\n" + "numero_max_occupanti=" + numero_max_occupanti + "\n" + "edificio=" + edificio + "\n" + "isLibera=" + isLibera ;
	}

 
}
