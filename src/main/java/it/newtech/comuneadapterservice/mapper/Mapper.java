package it.newtech.comuneadapterservice.mapper;

import org.springframework.stereotype.Component;

import it.newtech.comuneadapterservice.domain.model.Comune;
import it.newtech.comuneadapterservice.domain.model.ComuneDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class Mapper {
	
	
	public ComuneDto toComuneDto(Comune comune) {
		ComuneDto dto = new ComuneDto();
		dto.setNome(comune.getDenominazioneIta());
		dto.setProvincia(comune.getDenominazioneProvincia());
		dto.setSigla(comune.getSiglaProvincia());
		dto.setCap(comune.getCap());
		dto.setIstat(comune.getCodiceIstat());
		return dto;
	}

}