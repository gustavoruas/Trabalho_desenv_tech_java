package com.uniritter.monitor.domain.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.regras.Regra;

@Component
public class RegraDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public RegraDao(JdbcTemplate jdbc){
		this.jdbcTemplate = jdbc;		
	}
	
	public List<Regra> getRegra(int id){
		
		return this.jdbcTemplate.query("select * from regra where id = ?", new RegraRowMapper(), id);
	}
	
	public List<Regra> getRegras(){
		return this.jdbcTemplate.query("select * from regra", new RegraRowMapper());
	}
	
	public List<Regra> getRegraPorMEtricaID(Long id){
		return this.jdbcTemplate.query("select * from regra where metrica_id = ?", new RegraRowMapper(), id);
	}
	
	public int createRegra(Regra regra){
		//ID  	NOME_FUNCAO  	VALOR  	METRICA_ID  
		
		return jdbcTemplate.update(
				"insert into regra (NOME_FUNCAO, VALOR, METRICA_ID) "
			  + "values (?,?,?) ",
			  regra.getNome(),
			  regra.getValor(),
			  regra.getMetrica_id()				
				);
				
	}
	
	public int deleteRegra(int id){
		return jdbcTemplate.update("delete from regra where id = ?", id);
	}
	
	
	
}
