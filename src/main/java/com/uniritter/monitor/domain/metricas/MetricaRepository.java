package com.uniritter.monitor.domain.metricas;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.host.Host;
import com.uniritter.monitor.domain.persistance.MetricaDao;
import com.uniritter.monitor.domain.tipo.Tipo;
import com.uniritter.monitor.domain.tipo.TipoTempo;
public class MetricaRepository {

	@Autowired
	MetricaDao metricaDao;
	
	public List<Metrica> getMetricas() {
		return this.metricaDao.getMetricas();
	}

	public Metrica createMetrica(int periodicidade,TipoTempo tipoMetrica) {
		
		//Metrica nova = new Metrica(
		//		null,
		//		nomeMetrica, new Date());
		//metricaDao.createMetrica(nova);
		//return nova;
		
		//Adiciona Host JSON a ser cadastrado
				
		Metrica nova = new Metrica(periodicidade, tipoMetrica);
		
		metricaDao.createMetrica(nova);
		
		return nova;
	}
}
