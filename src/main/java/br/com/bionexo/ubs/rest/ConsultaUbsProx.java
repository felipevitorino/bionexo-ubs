package br.com.bionexo.ubs.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.bionexo.ubs.controller.CalculaUbsProx;
import br.com.bionexo.ubs.modelo.Ubs;

/**
 * @author fvitorino
 * Classe responsavel em processar a requisição Rest e retornar o json com a lista de postos
 */
@Path("/ubsprox")
public class ConsultaUbsProx {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String consultar(@QueryParam("lat") String lat, @QueryParam("lng") String lng) {
		CalculaUbsProx c = new CalculaUbsProx();
		List<Ubs> lista = c.calcula(lat, lng);
 
		return new Gson().toJson(lista);
	}
}
