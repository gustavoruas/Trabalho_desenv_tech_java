package com.uniritter.monitor.domain.regras;

public class Regra {

	private int id;
	private String nome;
	private double valor;
	private int metrica_id;
	
	public Regra(String nome, double valor, int metrica_id){
		this.nome =nome;
		this.valor = valor;	
		this.metrica_id = metrica_id;
	}	
	
	public Regra(int id, String nome, double valor, int metrica_id){
		this.id = id;
		this.nome =nome;
		this.valor = valor;	
		this.metrica_id = metrica_id;
	}	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getMetrica_id() {
		return metrica_id;
	}
	public void setMetrica_id(int metrica_id) {
		this.metrica_id = metrica_id;
	}
	
	
	
}
