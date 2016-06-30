package com.uniritter.monitor.domain.metricas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicaoService {

	@Autowired
	MedicaoRepository medicaoRepository;
	
	public List<Medicao> getMedicoes(){
		return this.medicaoRepository.getMedicoes();
	}
	
	public List<Medicao> getMedicoesPorMetrica(Long id){
		return this.medicaoRepository.getMedicoesPorMetrica(id);
	}
		
	public Medicao createMedicao(Medicao med,Long metrica_id){
		return medicaoRepository.createMedicao(med, metrica_id);	
		 
	}
	
	
}
