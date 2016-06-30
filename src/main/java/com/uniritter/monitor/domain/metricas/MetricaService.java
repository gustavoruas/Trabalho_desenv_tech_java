package com.uniritter.monitor.domain.metricas;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.host.Host;
import com.uniritter.monitor.domain.tipo.TipoTempo;

@Component
public class MetricaService {
	@Autowired
	MetricaRepository repository;
			
	public List<Metrica> getMetricas() {
		return repository.getMetricas();
	}
	
	public List<Metrica> getMetrica(int id){
		return repository.getMetrica(id);
	}
	
	public Metrica createMetrica(int periodicidade, TipoTempo tipoMetrica) {
		return repository.createMetrica(periodicidade, tipoMetrica);
	}
	
	public int deleteMetrica(Long id){
		return this.repository.deleteMetrica(id);
	}
}
