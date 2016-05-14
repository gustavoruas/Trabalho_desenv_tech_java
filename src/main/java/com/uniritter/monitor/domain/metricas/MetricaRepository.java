package com.uniritter.monitor.domain.metricas;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uniritter.monitor.domain.persistance.MetricaDao;
public class MetricaRepository {

	@Autowired
	MetricaDao metricaDao;
	
	public List<Metrica> getMetricas() {
		return this.metricaDao.getMetricas();
	}

	public Metrica createMetrica(String tipoMetrica, String host) {
		
		//Metrica nova = new Metrica(
		//		null,
		//		nomeMetrica, new Date());
		//metricaDao.createMetrica(nova);
		//return nova;
		
		Metrica nova = new Metrica(null, tipoMetrica, host);
		
		metricaDao.createMetrica(nova);
		
		return nova;
	}
}
