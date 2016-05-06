package com.uniritter.monitor.domain.host;

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
    
    public int getIP() {
        return IP;
    }

    public void setIP(int IP) {
        this.IP = IP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
