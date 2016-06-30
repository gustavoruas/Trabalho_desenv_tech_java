package com.uniritter.monitor.domain.persistance;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.alertas.Notificacao;
import com.uniritter.monitor.domain.metricas.Metrica;

@Component
public class MetricaDao {
  
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MetricaDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Metrica> getMetrica(int id){
						
		Notificacao.log(MetricaDao.class).info("Valor do ID passado por URL REST" + id);
		
		return this.jdbcTemplate.query("select * from metrica where id = ? ", new MetricaRowMapper(), id);
	}
	
	public List<Metrica> getMetricas(){
				
		Notificacao.log(MetricaDao.class).info("Chamada da Classe DAO de todas as metricas");
		
		return this.jdbcTemplate.query("select * from metrica order by id", new MetricaRowMapper());
	}
	
	public int createMetrica(Metrica metrica) {
		return jdbcTemplate.update(
			"insert into metrica (nome,periodicidade) values (?,?)", 
			metrica.getTipo().toString(),
			metrica.getPeriodicidade()			
			);
	}
	
	public int deleteMetrica(Long id){
		return jdbcTemplate.update("delete from metrica where id = ?",
				id
				);
	}
	
}
