package com.uniritter.monitor.domain.host;

public class Host {
    private int IP;
    private String nome;
    private Grupo grupo;
    
    public Host(int IP, String nome, Grupo grupo) {
        this.IP = IP;
        this.nome = nome;
        this.grupo = grupo;
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
