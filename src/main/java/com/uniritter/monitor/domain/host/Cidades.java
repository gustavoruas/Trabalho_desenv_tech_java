package com.uniritter.monitor.domain.host;

public enum Cidades {
	sao_paulo ("BRXX0232"),
	porto_alegre ("BRXX0186"),
	florianopolis("BRXX0091"),
	curitiba("BRXX0079");
	
	private String nome;
	
	private Cidades(String cidade){
		this.nome = cidade;
	}
	
	
	public String toString(){
		return this.nome;
	}
}
