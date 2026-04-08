package it.newtech.comuneadapterservice.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comune {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cap")
    private String cap;
	
	@Column(name = "codice_istat")
    private String codiceIstat;

	private String denominazioneItaAltra;

	private String denominazioneIta;

	private String siglaProvincia;

	private String denominazioneProvincia;

	private String tipologiaProvincia;

	private String codiceRegione;

	private String denominazioneRegione;

	private String tipologiaRegione;

	private String ripartizioneGeografica;

	private String flagCapoluogo;

	private String codiceBelfiore;

	private BigDecimal lat;

	private BigDecimal lon;

	private BigDecimal superficieKmq;

}