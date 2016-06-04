package com.uniritter.monitor.domain.host;

import java.net.MalformedURLException;
import java.net.URL;

public class Host {
    private int IP;
    private String nome;    
    private URL url;    
    
    public Host(int IP, String nome, Grupo grupo) {
        this.IP = IP;
        this.nome = nome;        
    }
    
    public Host(URL urli, String nome){
    	this.url = urli;
    	this.nome = nome;
    }
    
        
    public Host(String url_base, String cidade){
    	try{
    		
    		this.url = new URL(url_base + cidade);
    		
    	}catch(MalformedURLException eml){
    		this.url = null;
    	}finally {
			this.url = null;
		}    	    	
    	
    }
    
    public int getIP() {
        return IP;
    }

    public void setIP(int IP) {
        this.IP = IP;
    }

    public String getNome() {
        return nome;
    }
    
    public URL getUrl(){
    	return this.url;
    }
    
    public void setURL (URL urlp){
    	this.url = url;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
