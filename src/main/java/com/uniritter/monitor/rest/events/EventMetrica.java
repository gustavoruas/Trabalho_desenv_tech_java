package com.uniritter.monitor.rest.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uniritter.monitor.domain.tipo.TipoTempo;

public class EventMetrica {
   
	private int periodicidade;
	private String tipo;
	
	
	@JsonCreator
	public EventMetrica(@JsonProperty("periodicidade")int periodicidade, @JsonProperty("tipo")String tipo){
		this.periodicidade = periodicidade;
		this.tipo = tipo;
	}
	
	public TipoTempo getEnumTipo(){
		
		String a = getTipo();
		
		if(a.equals("umidade")){
			return TipoTempo.umidade;
		}else{
			return TipoTempo.temperatura;
		}
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(int periodicidade) {
		this.periodicidade = periodicidade;
	}
	
}
