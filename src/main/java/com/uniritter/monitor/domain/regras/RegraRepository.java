package com.uniritter.monitor.domain.regras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.persistance.RegraDao;

@Component
public class RegraRepository {

	@Autowired
	RegraDao regraDao;
	
	public List<Regra> getRegras(){
		return this.regraDao.getRegras();
	}
	
	public List<Regra> getRegra(int id){
		return this.regraDao.getRegra(id);
	}
	
	public List<Regra> getRegraPorMEtricaID(Long id){
		return this.regraDao.getRegraPorMEtricaID(id);
	}
	
	public Regra createRegra(Regra regra){
		
		Regra reg = new Regra(regra.getNome(),				
				regra.getValor(),
				regra.getMetrica_id());
		
		this.regraDao.createRegra(regra);
		
		return reg;
	}
	
	public int deleteRegra(int id){
		return this.regraDao.deleteRegra(id);
	}
		
}
