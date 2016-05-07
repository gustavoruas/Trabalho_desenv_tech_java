package com.uniritter.monitor.domain.persistance;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.metricas.Metrica;

@Component
public class MetricaDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MetricaDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Metrica getMetriva(Long id){
		return  this.jdbcTemplate.queryForObject("select * from metrica where id = ?", Metrica.class, id);
	}
	
	public List<Metrica> getMetricas(){
		return this.jdbcTemplate.query("select * from metrica order by id", new MetricaRowMapper());
	}
	
	
}
