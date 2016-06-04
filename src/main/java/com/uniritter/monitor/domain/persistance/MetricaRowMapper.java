package com.uniritter.monitor.domain.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.tipo.TipoTempo;

public class MetricaRowMapper implements RowMapper<Metrica> {
    
	@Override
	public Metrica mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		TipoTempo tipo;
		
		if(TipoTempo.umidade.toString().equals(rs.getString("nome"))){
			tipo = TipoTempo.umidade ;
		}else{
			tipo = TipoTempo.temperatura ;
		}
		
		
		return new Metrica(	
				rs.getInt("periodicidade"),
				tipo				   		   
				);
	}
}
