package com.uniritter.monitor.domain.metricas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.uniritter.monitor.domain.tipo.TipoTempo;

public class Medicao {

	private Long id;
    private double valor_temp;
    private double valor_umid;
    private Date data;
    private String data_formatada;
    private Long metricaID;
    
	private SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/yyyy");
    private Date hora_atual = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
    private String dataFormatada = sdf.format(hora_atual);
        
	TipoTempo medicao_tipo;

	public Medicao(Long id, double temp, double umid) {
        this.id = id;
		this.valor_temp = temp;
        this.valor_umid = umid;
        this.data = hora_atual;
        this.data_formatada = dataFormatada;       
    }
	
	public Medicao(Long id, double temp, double umid, String data) {
        this.id = id;
		this.valor_temp = temp;
        this.valor_umid = umid;
        this.data = hora_atual;
        this.data_formatada = data;       
    }

	
	public Medicao(){
        
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getData_formatada() {
		return data_formatada;
	}

	public void setData_formatada(String data_formatada) {
		this.data_formatada = data_formatada;
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
	
	public Long getMetricaID() {
		return metricaID;
	}

	public void setMetricaID(Long metricaID) {
		this.metricaID = metricaID;
	}
	
	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}
    

}
