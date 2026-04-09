package it.newtech.comuneadapterservice.domain.service;



import java.util.List;

import org.springframework.stereotype.Service;

import it.newtech.comuneadapterservice.domain.model.ComuneDto;
import it.newtech.comuneadapterservice.domain.ports.ComuneRepository;
import it.newtech.comuneadapterservice.domain.ports.ComuneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ComuneServiceImpl implements ComuneService {

	private final ComuneRepository comuneRepository;

	@Override
	public List<ComuneDto> getComuneAll() {

		var comuni = comuneRepository.getAllComune();
		if (comuni.isEmpty()) {
			throw new ResourceNotFound("Nessun comune trovato");
		}
		return comuni;
	}

	@Override
	public List<String> getRegioni() {
		var regioni = comuneRepository.getRegioni();
		if (regioni.isEmpty()) {
			throw new ResourceNotFound("Nessuna Regione trovata");
		}
		return regioni;
	}

	@Override
	public List<String> getProvince(String regione) {
		var provincie = comuneRepository.getProvince(regione);
		if (provincie.isEmpty()) {
			throw new ResourceNotFound("Nessuna Provincia trovata per la Regione " + regione);
		}
		return provincie;
	}

	@Override
	public List<String> getComuni(String provincia) {
		var comuni = comuneRepository.getComuni(provincia);
		if (comuni.isEmpty()) {
			throw new ResourceNotFound("Nessun Comune trovato per la Provincia " + provincia);
		}
		return comuni;
	}

	@Override
	public List<String> getCapByComune(String comune) {
		var cap = comuneRepository.getCapByComune(comune);
		if(cap.isEmpty()) {
			throw new ResourceNotFound("Comune "+ comune + " non trovato");
		}return cap;
	}

	@Override
	public List<String> getSiglaByComune(String comune) {
		var sigla = comuneRepository.getSiglaByComune(comune);
		if(sigla.isEmpty()) {
			throw new ResourceNotFound("Comune "+ comune + " non trovato");
		}return sigla;
	}

	@Override
	public List<String> getAllProvince() {
		var province = comuneRepository.getAllProvince();
		if(province.isEmpty()) {
			throw new ResourceNotFound("Province non trovate");
		}return province;
	}

	@Override
	public List<ComuneDto> searchByComune(String q) {
		var comuni = comuneRepository.searchByComune(q);
		if(comuni.isEmpty())
			throw new ResourceNotFound("Comune non trovato");
		return comuni;
	}
	
}