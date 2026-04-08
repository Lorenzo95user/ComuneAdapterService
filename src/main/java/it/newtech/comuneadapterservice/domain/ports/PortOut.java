package it.newtech.comuneadapterservice.domain.ports;


import java.util.List;

import it.newtech.comuneadapterservice.domain.model.ComuneDto;




public interface PortOut {

	public List<ComuneDto> getAllComune();

	public List<String> getRegioni();

	public List<String> getProvince(String Regione);

	public List<String> getComuni(String Provincia);

	public List<String> getCapByComune(String comune);
	
	public List<String> getSiglaByComune ( String comune);
	
	public List<String> getAllProvince();
}