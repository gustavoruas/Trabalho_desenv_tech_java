package com.uniritter.monitor.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.uniritter.monitor.domain.host.Host;
import com.uniritter.monitor.domain.metricas.Medicao;

public class JsonMetrica {
	
	public static Medicao getJsonMedicao(Host host) throws IOException {
		
		Medicao med = new Medicao();
		
		InputStream is = host.getUrl().openStream();
		
		JsonFactory fac = new JsonFactory();
		JsonParser  jpar = fac.createParser(is);
		
		try{			
								
		    jpar.nextToken();
		    while(jpar.nextToken() != JsonToken.END_OBJECT){
		    	String node_field = jpar.getCurrentName();		    	
		    	
		    	if("agora".equals(node_field)){
		    		
		    		jpar.nextToken();  // Required for opening each node { object
		    		int i = 0;
		    		while(jpar.nextToken() != JsonToken.END_OBJECT){
		    			
		    			node_field = jpar.getCurrentName();
		    					    				    		
		    			
		    			//&& (!jpar.getText().equals(node_field)) inserido para remover replicação do Token Name no valor
		    			if("temperatura".equals(node_field) && (!jpar.getText().equals(node_field))){		    				
		    				med.setValor_temp(Double.parseDouble(jpar.getText()));
		    			}
		    			
		    			if("umidade".equals(node_field) && (!jpar.getText().equals(node_field))){
		    				med.setValor_umid(Double.parseDouble(jpar.getText()));
		    			}
		    			
		    			if("data_hora".equals(node_field) && (!jpar.getText().equals(node_field))){
		    				med.setData_formatada(jpar.getText());
		    			}		    			
		    			
		    		}		
		    		
		    	}
		    	
		    }
		    
		    is.close();
			jpar.close();
		    return med;
			
		}catch(JsonParseException je){
			//
		}catch(Exception e){
			
		}finally{			
			is.close();
			jpar.close();			
			return med;
					
		}	
		
	}

}
