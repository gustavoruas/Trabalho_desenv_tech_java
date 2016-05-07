package com.uniritter.monitor.main_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;


public class main_test {
    
	
	public static void lerJsondeURL(String url) throws IOException {
		InputStream is = new URL(url).openStream();
		
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
		    				System.out.println("temperatura: " + jpar.getText());
		    			}
		    			
		    			if("umidade".equals(node_field) && (!jpar.getText().equals(node_field))){
		    				System.out.println("Umidade: "+ jpar.getText());
		    			}
		    			
		    			if("data_hora".equals(node_field) && (!jpar.getText().equals(node_field))){
		    				System.out.println("Hora data: "+ jpar.getText());
		    			}
		    			
		    			
		    		}		
		    		
		    	}
		    	
		    }
			
		}catch(JsonParseException je){
			System.out.println(je.getMessage());
		}finally{
			is.close();
			jpar.close();
		}	
		
	}
	
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			main_test.lerJsondeURL("http://developers.agenciaideias.com.br/tempo/json/porto%20alegre-rs");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}

	}
	*/

}
