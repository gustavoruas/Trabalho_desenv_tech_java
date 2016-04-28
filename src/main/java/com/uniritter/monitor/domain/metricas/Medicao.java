package com.uniritter.monitor.domain.metricas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.uniritter.monitor.domain.tipo.TipoTempo;

public class Medicao {

    private double valor;
    private Date data;
    private String data_formatada;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss DD/MM/YYYY");
    Date hora_atual = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
    String dataFormatada = sdf.format(hora_atual);
    
    TipoTempo medicao_tipo;


	public Medicao(double valor, TipoTempo unidade) {
        this.valor = valor;
        this.data = hora_atual;
        this.data_formatada = dataFormatada;
        this.medicao_tipo = unidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public TipoTempo getMedicao_tipo() {
		return medicao_tipo;
	}

	public void setMedicao_tipo(TipoTempo medicao_tipo) {
		this.medicao_tipo = medicao_tipo;
	}
}
