package com.uniritter.monitor.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.uniritter.monitor.domain.metricas.Medicao;
import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.tipo.TipoTempo;

@Component
@Path("metricas")
@Produces("application/json")
@Consumes("application/json")
public class MetricaController {

	/*
	public Medicao popMedicaoJson(String url) throws IOException {

		InputStream is = new URL(url).openStream();

		JsonFactory fac = new JsonFactory();
		JsonParser jpar = fac.createParser(is);

		try {

			Medicao med = new Medicao();

			jpar.nextToken();
			while (jpar.nextToken() != JsonToken.END_OBJECT) {
				String node_field = jpar.getCurrentName();

				if ("agora".equals(node_field)) {

					jpar.nextToken(); // Required for opening each node { object
					while (jpar.nextToken() != JsonToken.END_OBJECT) {

						node_field = jpar.getCurrentName();

						// && (!jpar.getText().equals(node_field)) inserido para
						// remover replicação do Token Name no valor
						if ("temperatura".equals(node_field)
								&& (!jpar.getText().equals(node_field))) {
							
							med.setValor_temp(jpar.getDoubleValue());

						}

						if ("umidade".equals(node_field)
								&& (!jpar.getText().equals(node_field))) {
							med.setValor_umid(jpar.getDoubleValue());

						}

						if ("data_hora".equals(node_field)
								&& (!jpar.getText().equals(node_field))) {

						}

					}

				}
			}

		} catch (JsonParseException je) {
			System.out.println(je.getMessage());
		} finally {
			is.close();
			jpar.close();
		}

	}

*/
	@GET
	public Response getMetricas() {
        
		String teste = "teste";
		
		return Response.ok(teste).build();
	}

	@POST
	public Response createMetrica(Metrica metrica) {

		// service.

		return Response.ok().build();
	}

}
