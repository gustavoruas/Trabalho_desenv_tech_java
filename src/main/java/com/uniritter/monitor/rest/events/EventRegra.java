package com.uniritter.monitor.rest.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uniritter.monitor.domain.regras.Regra;

public class EventRegra extends Regra {

	
	//NAME  	VALOR  	METRICA_ID 
	
	@JsonCreator
	public EventRegra(@JsonProperty("nome") String nome, 
			@JsonProperty("valor") double valor, 
			@JsonProperty("metrica_id") int metrica_id){
		super(nome, valor, metrica_id);
		
	}
	
	
}
