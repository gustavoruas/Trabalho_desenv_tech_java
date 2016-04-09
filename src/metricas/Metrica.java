package metricas;

import host.Host;
import java.util.ArrayList;
import tipo.Tipo;

public class Metrica {
    
    private ArrayList<Medicao>medicoes;
    private Tipo tipo;
    private Host host;
    private String periodicidade;
    
    public Metrica(Tipo tipo, Host host) {
        this.tipo = tipo;
        this.host = host;
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
    
   
    
}
