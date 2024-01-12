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
public class Edificio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_edificio;
	private String nome_edificio;
	private String indirizzo;
	private String citta;
	@OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) 
	private Set<Postazione> postazioni;
	
	@Override
	public String toString() {
		return "[ID= " + id_edificio + ", NOME= " + nome_edificio + ", INDIRIZZO= " + indirizzo
				+ ", CITTA= " + citta + "]";
	}
	
	
}
