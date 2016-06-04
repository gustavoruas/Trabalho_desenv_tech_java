package com.uniritter.monitor.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLDataException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.uniritter.monitor.domain.metricas.Medicao;
import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.metricas.MetricaService;
import com.uniritter.monitor.domain.tipo.TipoTempo;
import com.uniritter.monitor.rest.events.EventMetrica;

@Component
@Path("metricas")
@Produces("application/json")
@Consumes("application/json")
public class MetricaController {

    
	@Autowired  //Nao se deve instanciar com NEW quando autowired.
	MetricaService metService;
	
	@GET
	public Response getMetricas() {
        		
		return Response.ok().build();
	}

	@POST
	public Response createMetrica(EventMetrica emetrica) {

		Metrica nova = metService.createMetrica(emetrica.getPeriodicidade(), emetrica.getEnumTipo());

		//return Response.ok().build();
		return Response.accepted(nova).build();
	}

}
