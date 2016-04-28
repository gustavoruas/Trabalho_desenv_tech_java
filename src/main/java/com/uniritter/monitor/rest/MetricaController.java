package com.uniritter.monitor.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.metricas.Medicao;
import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.tipo.TipoTempo;

@Component
@Path("metricas")
@Produces("application/json")
@Consumes("application/json")
public class MetricaController {
	
	
	
	
	@GET
	public Response getMetricas(){
				
		Metrica met = new Metrica(new Medicao(20, TipoTempo.temperatura));
	    
		String exemplo ="{\"metrica\": " + "\"" +met.getUnicaMedicao(1).getMedicao_tipo().toString() +"\"" + ":"
				+ "\"" + met.getUnicaMedicao(1).getValor()+ "\"" + "}";
		
		return Response.ok(exemplo).build();
	}
	
	@POST
	public Response createMetrica(Metrica metrica){
		
		
		//service.
		
		return Response.ok().build();
	}

	
	
}
