package it.newtech.comuneadapterservice.domain.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComuneDto {
	
	
	private String nome;
	private String sigla;
	private String provincia;
	private List<String> cap;
	private List<String> istat;
	@Override
	public String toString() {
		return "Nome=" + nome + ", Sigla=" + sigla + ", Provincia=" + provincia + ", CAP=" + cap + ", Codice Istat="
				+ istat + " ";
	}

}
