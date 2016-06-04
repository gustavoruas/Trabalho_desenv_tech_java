package com.uniritter.monitor.domain.host;

public enum Cidades {
	sao_paulo ("sao paulo-SP"),
	porto_alegre ("porto alegre-rs");
	
	private String nome;
	
	private Cidades(String cidade){
		this.nome = cidade;
	}
	
	
	public String toString(){
		return this.nome;
	}
}
