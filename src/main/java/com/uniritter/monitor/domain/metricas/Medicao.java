package com.uniritter.monitor.domain.metricas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.uniritter.monitor.domain.tipo.TipoTempo;

public class Medicao {

    private double valor_temp;
    private double valor_umid;
    private Date data;
    private String data_formatada;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss DD/MM/YYYY");
    Date hora_atual = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
    String dataFormatada = sdf.format(hora_atual);
    
    TipoTempo medicao_tipo;


	public Medicao(double temp, double umid, String hora) {
        this.valor_temp = temp;
        this.valor_umid = umid;
        this.data = hora_atual;
        this.data_formatada = dataFormatada;       
    }
	
	public Medicao(){
        
	}
	
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

	public double getValor_temp() {
		return valor_temp;
	}

	public void setValor_temp(double valor_temp) {
		this.valor_temp = valor_temp;
	}

	public double getValor_umid() {
		return valor_umid;
	}

	public void setValor_umid(double valor_umid) {
		this.valor_umid = valor_umid;
	}    
    
    

    
}
