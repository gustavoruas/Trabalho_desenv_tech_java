package com.uniritter.monitor.domain.metricas;

import com.uniritter.monitor.domain.host.Host;
import java.util.ArrayList;
import com.uniritter.monitor.domain.tipo.Tipo;

public class Metrica {
    
	
	//Devese iniciar uma Array list para usar seus metodos
    private ArrayList<Medicao> medicoes = new ArrayList<Medicao>();
    private String tipo;
	private String host;
    private String periodicidade;
	private Long id;
    
       
    public Metrica(Long id, String tipo, String host) {
        this.id = id;
    	this.tipo = tipo;
        this.host = host;
    }
    
    public Metrica(Medicao met){
    	this.medicoes.add(met);    	
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
    
    public String getTipo() {
		return tipo;
	}
    
    public String getHost() {
		return host;
	}
    
}
