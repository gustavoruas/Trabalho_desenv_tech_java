package com.uniritter.monitor.domain.alertas;

import java.util.List;

import com.uniritter.monitor.domain.metricas.Medicao;
import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.regras.Regra;

public class Alerta {

	private Metrica metrica;	
	private List<Regra> regras;	
	private List<Medicao> medicoes;
	
	public Metrica getMetrica() {
		return metrica;
	}
	public void setMetrica(Metrica met) {
		this.metrica = met;
	}
	public List<Regra> getRegras() {
		return regras;
	}
	public void setRegras(List<Regra> regras) {
		this.regras = regras;
	}
	public List<Medicao> getMedicoes() {
		return medicoes;
	}
	public void setMedicoes(List<Medicao> medicoes) {
		this.medicoes = medicoes;
	}
	
	public void addMedicoes(Medicao med){
		this.medicoes.add(med);
	}
	
	
}
