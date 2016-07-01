package com.uniritter.monitor.domain.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.metricas.Medicao;

@Component
public class MedicaoDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MedicaoDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Medicao> getMedicaoporMetricaID(Long id){
		return this.jdbcTemplate.query("select * from medicao where metrica_id = ?", new MedicaoRowMapper(),id);
	}
	
	public List<Medicao> getMedicoes(){
		return this.jdbcTemplate.query("select * from medicao", new MedicaoRowMapper());
	}
	
	public Medicao getMedicao(Long id){
		
		return this.jdbcTemplate.queryForObject("select * from medicao where id = ?", Medicao.class, id);
	}
	
	//tabela Medicao
	//ID  	TEMPERATURA  	UMIDADE  	DATA_REGISTRADA     METRICA_ID
	public int createMedicao(Medicao med, Long metrica_id){
		
		return this.jdbcTemplate.update(
				"insert into medicao (TEMPERATURA,UMIDADE,DATA_REGISTRADA, METRICA_ID) values (?,?,?,?)",				
				med.getValor_temp(),
				med.getValor_umid(),
				med.getData_formatada(),//Metodo retorna SYSDATE formatado em string	
				metrica_id
				);			
				
	}

	public List<Medicao> getMedicaoMaisAtualMetrica(Long id) {

		
		return this.jdbcTemplate.query("select * from medicao where metrica_id = ? and id = (select max(id) from medicao)", new MedicaoRowMapper(),id);
		
		/*
		return this.jdbcTemplate.queryForObject(
				  "select * from medicao"
				+ " where metrica_id = ?" 
				+ " and id = ("
				+ "  select max(id) from medicao" + 
				  "  where metrica_id = ?)",
				Medicao.class, id, id);
				*/
	}
	
}
