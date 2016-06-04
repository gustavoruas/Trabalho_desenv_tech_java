package com.uniritter.monitor.domain.tipo;

public enum TipoTempo {
    temperatura ("temperatura"),
    umidade ("umidade");
	
	private String tipo_nome;
	
	private TipoTempo(String s){
		this.tipo_nome = s;
	}
	
	public String toString(){
		return tipo_nome;
	}
	
}
