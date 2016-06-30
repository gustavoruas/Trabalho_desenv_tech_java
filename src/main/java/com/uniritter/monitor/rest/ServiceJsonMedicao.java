package com.uniritter.monitor.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.uniritter.monitor.domain.host.Host;
import com.uniritter.monitor.domain.metricas.Medicao;

public class ServiceJsonMedicao {

	public static Medicao getJsonMedicao(Host host) throws IOException, JsonParseException, ConnectException {

		Medicao med = new Medicao();
        
		
		
		URLConnection connectionURL = host.getUrl().openConnection();
		connectionURL.setRequestProperty("User-Agent", "Mozilla/45.0");
		connectionURL.connect();
		
		InputStream is = connectionURL.getInputStream();
		JsonFactory fac = new JsonFactory();
		JsonParser jpar = fac.createParser(is);
        
		
		
		jpar.nextToken();
		while (jpar.nextToken() != JsonToken.END_OBJECT) {
			String node_field = jpar.getCurrentName();

			if ("results".equals(node_field)) {

				jpar.nextToken(); // Required for opening each node { object
				int i = 0;
				while (jpar.nextToken() != JsonToken.END_OBJECT) {

					node_field = jpar.getCurrentName();

					// && (!jpar.getText().equals(node_field)) inserido para
					// remover replicação do Token Name no valor
					if ("temp".equals(node_field) && (!jpar.getText().equals(node_field))) {
						med.setValor_temp(Double.parseDouble(jpar.getText()));
					}

					if ("humidity".equals(node_field) && (!jpar.getText().equals(node_field))) {
						med.setValor_umid(Double.parseDouble(jpar.getText()));
					}

					if ("date".equals(node_field) && (!jpar.getText().equals(node_field))) {
						med.setData_formatada(jpar.getText());
					}

				}

			}

		}
		
		jpar.close();
		is.close();		
		return med;

	}

}
