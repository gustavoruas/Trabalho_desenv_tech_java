package com.uniritter.monitor.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.metricas.Metrica;

@Component
@Path("metricas")
@Produces("application/json")
@Consumes("application/json")
public class MetricaController {
	
	
	
	@GET
	public Response getMetricas(){
		
		String metrica = "{\"metrica\":\"Espaco em disco\"}";
		
		return Response.ok(metrica).build();
	}
	
	@POST
	public Response createMetrica(Metrica metrica){
		
		
		service.
		
		return Response.ok().build();
	}

	
	
}
