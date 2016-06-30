package com.uniritter.monitor.domain.metricas;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.alertas.Notificacao;
import com.uniritter.monitor.domain.host.Cidades;
import com.uniritter.monitor.domain.host.Host;
import com.uniritter.monitor.domain.persistance.MetricaDao;
import com.uniritter.monitor.domain.tipo.Tipo;
import com.uniritter.monitor.domain.tipo.TipoTempo;
import com.uniritter.monitor.rest.ServiceJsonMedicao;

@Component
public class MetricaRepository {

	@Autowired
	MetricaDao metricaDao;
	
	@Autowired
	MedicaoService medicaoService;
	
	public List<Metrica> getMetricas() {
		return this.metricaDao.getMetricas();
	}
	
	public int deleteMetrica(Long id){
		return this.metricaDao.deleteMetrica(id);
	}

	public Metrica createMetrica(int periodicidade,TipoTempo tipoMetrica) {
								
		Metrica nova = new Metrica(periodicidade, tipoMetrica);
		
		this.metricaDao.createMetrica(nova);
		
		return nova;
	}

	public List<Metrica> getMetrica(int id) {
			    	
		return 	this.metricaDao.getMetrica(id);
		
	}
}
