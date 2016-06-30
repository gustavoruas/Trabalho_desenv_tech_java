package com.uniritter.monitor.domain.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.uniritter.monitor.domain.regras.Regra;

public class RegraRowMapper implements RowMapper<Regra> {

	@Override
	public Regra mapRow(ResultSet rs, int rowNum) throws SQLException{
				
		//ID  	NOME_FUNCAO  	VALOR  	METRICA_ID  
		
		return new Regra(
				rs.getInt("id"),
				rs.getString("NOME_FUNCAO"),
				rs.getDouble("VALOR"),
				rs.getInt("METRICA_ID")				
				);			
	}

}
