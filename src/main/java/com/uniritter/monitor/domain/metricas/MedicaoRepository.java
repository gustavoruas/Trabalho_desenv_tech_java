package com.uniritter.monitor.domain.metricas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.persistance.MedicaoDao;

@Component
public class MedicaoRepository {

	@Autowired
	MedicaoDao medicaoDAO;
	
	public List<Medicao> getMedicoes(){
		return this.medicaoDAO.getMedicoes();
	}
	
	public List<Medicao> getMedicoesPorMetrica(Long id){
		return this.medicaoDAO.getMedicaoporMetricaID(id);
	}
	
	public Medicao createMedicao(Medicao med, Long metrica_id){
		
		medicaoDAO.createMedicao(med, metrica_id);
		
		return med;
		
	}

	public List<Medicao> getMedicaoMaisAtualMetrica(Long id) {		
		return this.medicaoDAO.getMedicaoMaisAtualMetrica(id);
	}
	
}
