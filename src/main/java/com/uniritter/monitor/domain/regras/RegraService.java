package com.uniritter.monitor.domain.regras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegraService {
	
	@Autowired
	RegraRepository regraRep;
	
	public List<Regra> getRegras(){
		return this.regraRep.getRegras();
	}
	
	public List<Regra> getRegra(int id){
		return this.regraRep.getRegra(id);
	}
	
	public List<Regra> getRegraPorMEtricaID(Long id){
		return this.regraRep.getRegraPorMEtricaID(id);
	}
	
	public Regra createRegra(Regra regra){
		return this.regraRep.createRegra(regra);
	}
	
	public int deleteRegra(int id){
		return this.regraRep.deleteRegra(id);
	}
		

}
