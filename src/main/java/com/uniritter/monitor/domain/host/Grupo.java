package com.uniritter.monitor.domain.host;

public class Grupo {
    
	
	//Servidor JSON encontrado
	//http://developers.agenciaideias.com.br/tempo
	//http://developers.agenciaideias.com.br/tempo/json/porto%20alegre-rs	
	//http://www.mkyong.com/java/jackson-streaming-api-to-read-and-write-json/
	//http://developers.agenciaideias.com.br/tempo/json/porto%20alegre-rs
	
	//Working
	//http://hgbrasil.com/status/weather/
	//http://api.hgbrasil.com/weather/?format=json&cid=
	
    private String tipo;
    private String nome_grupo;
    private Host servidores;

    public Grupo(String tipo, String nome, Host serv) {
        this.servidores = serv;
        this.nome_grupo = nome;
        this.tipo = tipo;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_grupo() {
		return nome_grupo;
	}

	public void setNome_grupo(String nome_grupo) {
		this.nome_grupo = nome_grupo;
	}

	public Host getServidores() {
		return servidores;
	}

	public void setServidores(Host servidores) {
		this.servidores = servidores;
	}

}
