package com.uniritter.monitor.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.alertas.Notificacao;
import com.uniritter.monitor.domain.regras.Regra;
import com.uniritter.monitor.domain.regras.RegraService;
import com.uniritter.monitor.rest.events.EventRegra;

@Path("/regras")
@Produces("application/json")
@Consumes("application/json")
@Component
public class RegraController {
	
	@Autowired
	RegraService regraServ;
	
	@Path("get/{id}") @GET
	public Response getRegra(@PathParam("id") int id) throws Exception{
		
		Regra reg = regraServ.getRegra(id).get(0);
		
		return Response.ok(reg).build();	
		
	}
	
	@GET
	public Response getRegras(){
		return Response.ok(regraServ.getRegras()).build();
	}
	
	@POST
	public Response createRegra(EventRegra regra) throws Exception{
		
		Regra reg = regraServ.createRegra(regra);
		
		return Response.accepted(reg).build();
		
	}
	
	@Path("del/{id}") @GET
	public Response deleteRegra(@PathParam("id") int id){
		
		if(regraServ.deleteRegra(id) > 0){
			Notificacao.log(RegraController.class).info("Regra deletada, ID: " + id);
			return Response.ok("Regra deletada ID: " +id).build();
		}else{
			Notificacao.log(RegraController.class).info("Regra nao existe");
			return Response.ok("Regra nao existe").build();
		}
		
		
	}

}
