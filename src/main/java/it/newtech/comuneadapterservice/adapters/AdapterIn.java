package it.newtech.comuneadapterservice.adapters;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.newtech.comuneadapterservice.domain.ports.ComuneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/comuni")
@AllArgsConstructor
@Slf4j
public class AdapterIn {

	private final ComuneService comuneService;

	@GetMapping("all")
	public ResponseEntity<?> getAll() {
		log.debug("Carico citta");
		var all = comuneService.getComuneAll();
		return (!all.isEmpty()) ? ResponseEntity.ok(all) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("regioni")
	public ResponseEntity<?> getRegioni() {
		log.debug("Carico Regioni");
		var regioni = comuneService.getRegioni();
		return (!regioni.isEmpty()) ? ResponseEntity.ok(regioni) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("province")
	public ResponseEntity<?> getProvince(@RequestParam String regione) {
		log.debug("Parametro inserito : {}", regione);
		var province = comuneService.getProvince(regione);
		return (!province.isEmpty()) ? ResponseEntity.ok(province) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("comuni")
	public ResponseEntity<?> getComuni(@RequestParam String provincia) {
		log.debug("Parametro inserito : {}", provincia);
		var comune = comuneService.getComuni(provincia);
		return (!comune.isEmpty()) ? ResponseEntity.ok(comune) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("cap")
	public ResponseEntity<?> getCapByComune(@RequestParam String comune){
		log.debug("Comune inserito : {}",comune);
		var cap = comuneService.getCapByComune(comune);
		return (!cap.isEmpty()) ? ResponseEntity.ok(cap) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("sigla")
	public ResponseEntity<?> getSiglaByComune(@RequestParam String comune){
		log.debug("Comune inserito : {}",comune);
		var sigla = comuneService.getSiglaByComune(comune);
		return (!sigla.isEmpty()) ? ResponseEntity.ok(sigla) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("province/all")
	public ResponseEntity<?> getAllProvince(){
		var province = comuneService.getAllProvince();
		return (!province.isEmpty()) ? ResponseEntity.ok(province) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Province non trovate");
	}
	
	@GetMapping("comune")
	public ResponseEntity<?> searchByComune(@RequestParam String q){
		var comuni = comuneService.searchByComune(q);
		return (!comuni.isEmpty()) ? ResponseEntity.ok(comuni) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comune non trovato");
	}
	

}
