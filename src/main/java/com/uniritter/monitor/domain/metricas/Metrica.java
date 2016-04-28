package com.uniritter.monitor.domain.metricas;

import com.uniritter.monitor.domain.host.Host;
import java.util.ArrayList;
import com.uniritter.monitor.domain.tipo.Tipo;

public class Metrica {
    
	
	//Devese iniciar uma Array list para usar seus metodos
    private ArrayList<Medicao> medicoes = new ArrayList<Medicao>();
    private Tipo tipo;
    private Host host;
    private String periodicidade;
    
       
    public Metrica(Tipo tipo, Host host) {
        this.tipo = tipo;
        this.host = host;
    }
    
    public Metrica(Medicao met){
    	this.medicoes.add(met);    	
    }

    public ArrayList<Medicao> getMedicoes() {
        return medicoes;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
    
    public void insereNovaMedicao(Medicao medicao) {
        medicoes.add(medicao);
    }
    
    public Medicao getUnicaMedicao(int index){
    	return medicoes.get(index);
    }
    
   
    
}
