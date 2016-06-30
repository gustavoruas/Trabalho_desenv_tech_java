package com.uniritter.monitor.domain.host;

import java.net.MalformedURLException;
import java.net.URL;

public class Host {
    private int IP;
    private String nome;    
    private URL url;    
    
                       
    public Host(String url_base, String cidade){
    	try{
    		
    		this.url = new URL(url_base + cidade);
    		
    	}catch(MalformedURLException eml){
    		
    	}finally {
			this.url = url;
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
    	this.url = urlp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
