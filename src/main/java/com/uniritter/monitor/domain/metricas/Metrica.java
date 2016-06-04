package com.uniritter.monitor.domain.metricas;

import com.uniritter.monitor.domain.host.Host;
import java.util.ArrayList;
import com.uniritter.monitor.domain.tipo.Tipo;
import com.uniritter.monitor.domain.tipo.TipoTempo;

public class Metrica {
    
	
	//Devese iniciar uma Array list para usar seus metodos
    private ArrayList<Medicao> medicoes = new ArrayList<Medicao>();
    
	private Host host;
    private int periodicidade;
    private Long id;
	private TipoTempo tipo;
    
	
	/*
    public Metrica(Long id, Host host, int period ) {
        this.id = id;    	
        this.host = host;
        this.periodicidade = period;
    }
    
    public Metrica(Medicao met){
    	this.medicoes.add(met);  
    }
    
    public Metrica() {
	}
    */
    
    public Metrica(int period, TipoTempo tip){    	
    	this.periodicidade = period;
    	this.tipo = tip;
    	
    }
    
	public int getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(int periodicidade) {
		this.periodicidade = periodicidade;
	}
       
    public TipoTempo getTipo() {
		return tipo;
	}

	public void setTipo(TipoTempo tipo) {
		this.tipo = tipo;
	}

    public ArrayList<Medicao> getMedicoes() {
        return medicoes;
    }    
    
    public void insereNovaMedicao(Medicao medicao) {
        medicoes.add(medicao);
    }
    
    public Medicao getUnicaMedicao(int index){
    	return medicoes.get(index);
    }   
    
    
}
