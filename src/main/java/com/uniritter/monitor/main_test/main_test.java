package com.uniritter.monitor.main_test;


import java.io.IOException;

import java.util.Properties;

import org.apache.log4j.Level;

import com.fasterxml.jackson.core.JsonParseException;
import com.uniritter.monitor.domain.alertas.Notificacao;
import com.uniritter.monitor.domain.host.Cidades;
import com.uniritter.monitor.domain.host.Host;
import com.uniritter.monitor.domain.metricas.Medicao;
import com.uniritter.monitor.rest.ServiceJsonMedicao;


public class main_test {
    	
	public static Properties props = System.getProperties();
	
	//PropertyConfigurator.configure("log4j.properties");
	/*
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Current working directory is " + props.getProperty("user.dir"));
		
		
		
		Notificacao.log(main_test.class).fatal("Teste te LOG 4j");
		
		Notificacao.log(main_test.class).debug("Teste te LOG 4j");
						
		//System.out.println(host.getUrl());
						
		try{		
			Host host = new Host("http://api.hgbrasil.com/weather/?format=json&cid=", Cidades.porto_alegre.toString());	
			
			System.out.println(host.getUrl());
			
			Medicao med = ServiceJsonMedicao.getJsonMedicao(host);
									
			System.out.println("teste");
			
			
			System.out.println(med.getData_formatada() + " " +
			        med.getValor_temp() + " " +
					med.getValor_umid() + " " 				
					);							
			
		}catch(JsonParseException je){
			System.out.println(je.getMessage());
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		

	}
	*/

}
