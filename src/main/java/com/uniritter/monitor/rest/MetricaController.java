  package com.uniritter.monitor.rest;



import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.uniritter.monitor.domain.alertas.AlertaService;
import com.uniritter.monitor.domain.alertas.Notificacao;
import com.uniritter.monitor.domain.host.Cidades;
import com.uniritter.monitor.domain.host.Host;
import com.uniritter.monitor.domain.metricas.MedicaoService;
import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.metricas.MetricaRepository;
import com.uniritter.monitor.domain.metricas.MetricaService;
import com.uniritter.monitor.rest.events.EventMetrica;


@Path("/metricas")
@Produces("application/json")
@Consumes("application/json")
@Component
public class MetricaController {
    
	//JErsey Rest Library DOC
	//https://jsr311.java.net/nonav/releases/1.1/index.html
	//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    
	@Autowired  //Nao se deve instanciar com NEW quando autowired. NEsted Exception
	MetricaService metService;
	
	@Autowired
	MedicaoService medicaoService;
	
	@Autowired
	AlertaService alertaServ;
				
	@Path("get/{id}") @GET	
	public Response getMetrica(@PathParam("id") int id) throws Exception{
		
        Metrica met = metService.getMetrica(id).get(0);//Busca uma Métrica para aquisição do ID
		
		Notificacao.log(MetricaRepository.class).info("***** Metrica selecionada, ID a ser inserida na medicao: " + met.getId());
		
		ServiceJsonMedicao jmed = new ServiceJsonMedicao();//creates a Medicao by fetching data from Webservice
						
		Host host = new Host("http://api.hgbrasil.com/weather/?format=json&cid=", Cidades.porto_alegre.toString());	
		
		Notificacao.log(RegraController.class).info("Adquirindo medição de WebService - " + host.getUrl().toString());
		
		try {
			met.insereNovaMedicao(medicaoService.createMedicao(jmed.getJsonMedicao(host), met.getId()));
		} catch (IOException e) {			
			e.printStackTrace();			
		}
		
		//Verifica se nova medicao fere alguma regra
		Notificacao.log(RegraController.class).info("Medição adquirida. Verificando regras para metrica selecionada:" + met.getId());
		alertaServ.disparaAlertaUnicoMetrica(met);
		
				
		return Response.ok(met).build();
						
	}
	
	
	@GET	
	public Response getMetricas() throws Exception{
        
		List<Metrica> lMetrica = metService.getMetricas();
						
		return Response.ok(lMetrica).build();
	}

	@POST	
	public Response createMetrica(EventMetrica emetrica) throws Exception{

		Metrica nova = metService.createMetrica(emetrica.getPeriodicidade(), emetrica.getEnumTipo());
        
		Notificacao.log(MetricaController.class).info("Metrica com ID:"+nova.getId()+" criada");
		
		//return Response.ok().build();
		return Response.accepted(nova).build();
	}
	
	@Path("del/{id}") @GET
	public Response deleteMetrica(@PathParam("id") long id){
		
		if(metService.deleteMetrica(id) > 0 ){
			Notificacao.log(MetricaController.class).info("Metrica com ID: "+id+"deletada");
			return Response.accepted("Metrica com ID " +id+ " deletada").build();
		}else{
			Notificacao.log(MetricaController.class).info("Nenhuma metrica encontrada com ID: "+id);
			return Response.accepted("Metrica nao encontrada para deletar").build();
		}
		
	}
	
	@Path("alerta/{id}") @GET
	public Response disparaAlerta(@PathParam("id") int id){
					
		Metrica met = metService.getMetrica(id).get(0);
		
		alertaServ.disparaAlertaMetrica(met);
		
		return Response.ok("Alerta Disparado").build();
		
		
	}
	
}
