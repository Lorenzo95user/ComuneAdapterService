package it.newtech.comuneadapterservice.domain.ports;


import java.util.List;

import it.newtech.comuneadapterservice.domain.model.ComuneDto;




public interface PortIn {
	
	public List<ComuneDto> getComuneAll();
	
	public List<String> getRegioni();
	
	public List<String> getProvince(String regione);
	
	public List<String> getComuni(String provincia);
	
	public List<String> getCapByComune(String comune);
	
	public List<String> getSiglaByComune ( String comune);
	
	public List<String> getAllProvince();

}