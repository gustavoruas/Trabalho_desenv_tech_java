package com.uniritter.monitor.domain.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uniritter.monitor.domain.metricas.Medicao;

public class MedicaoRowMapper implements RowMapper<Medicao> {

	@Override
	public Medicao mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//ID  	TEMPERATURA  	UMIDADE  	DATA_REGISTRADA     METRICA_ID
		
		Medicao med = new Medicao(
				rs.getLong("ID"),
				rs.getDouble("TEMPERATURA"),
				rs.getDouble("UMIDADE"),
				rs.getString("DATA_REGISTRADA")
				);
		med.setMetricaID(rs.getLong("METRICA_ID"));
		
		return med;
	}

	
	
	
}
