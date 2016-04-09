package metricas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Medicao {

    private double valor;
    private Date data;
    private String data_formatada;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss DD/MM/YYYY");
    Date hora_atual = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
    String dataFormatada = sdf.format(hora_atual);
    

    public Medicao(double valor) {
        this.valor = valor;
        this.data = hora_atual;
        this.data_formatada = dataFormatada;
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

}
