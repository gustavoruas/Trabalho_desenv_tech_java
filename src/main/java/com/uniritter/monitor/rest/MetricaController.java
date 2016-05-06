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

<<<<<<< HEAD
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
=======
>>>>>>> origin/master
import com.uniritter.monitor.domain.metricas.Medicao;
import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.tipo.TipoTempo;

@Component
@Path("metricas")
@Produces("application/json")
@Consumes("application/json")
public class MetricaController {
<<<<<<< HEAD

		
=======
	
	
	
	
	@GET
	public Response getMetricas(){
				
		Metrica met = new Metrica(new Medicao(20, TipoTempo.temperatura));
	    
		String exemplo ="{\"metrica\": " + "\"" +met.getUnicaMedicao(1).getMedicao_tipo().toString() +"\"" + ":"
				+ "\"" + met.getUnicaMedicao(1).getValor()+ "\"" + "}";
		
		return Response.ok(exemplo).build();
	}
>>>>>>> origin/master
	
	public void popMedicaoJson(String url) throws IOException {
		
		InputStream is = new URL(url).openStream();
				
		
<<<<<<< HEAD
=======
		//service.
>>>>>>> origin/master
		
		JsonFactory fac = new JsonFactory();
		JsonParser jpar = fac.createParser(is);

		try {
			
			Medicao med;
			
			jpar.nextToken();
			while (jpar.nextToken() != JsonToken.END_OBJECT) {
				String node_field = jpar.getCurrentName();

				if ("agora".equals(node_field)) {

					jpar.nextToken(); // Required for opening each node { object
					while (jpar.nextToken() != JsonToken.END_OBJECT) {

						node_field = jpar.getCurrentName();

						if ("temperatura".equals(node_field)) {
							//med.setMedicao_tipo(TipoTempo.temperatura);
							
							System.out.println("temperatura: " + jpar.getText());
						}

						if ("umidade".equals(node_field)) {
							System.out.println("Umidade: " + jpar.getText());
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

	@GET
	public Response getMetricas() {

		return Response.ok().build();
	}

	@POST
	public Response createMetrica(Metrica metrica) {

		// service.

		return Response.ok().build();
	}

}
