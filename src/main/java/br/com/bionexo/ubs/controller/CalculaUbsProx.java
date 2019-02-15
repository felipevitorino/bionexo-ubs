package br.com.bionexo.ubs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bionexo.ubs.modelo.Ubs;
import br.com.bionexo.ubs.util.JPAUtil;

/**
 * Essa classe tem como objetivo calcular o ponto mais proximo dado uma referencia lat lng<br>
 * A consulta utiliza a fórmula de Haversine em quilometros 
 * @author fvitorino
 *
 */
public class CalculaUbsProx {

	public List<Ubs> calcula(String lat, String lng) {
		EntityManager em = new JPAUtil().getEntityManager();

		String jpql = "select u, (6371 * acos(\n" + 
				"		 cos( radians(" + lat + ") )\n" + 
				"		 * cos( radians( u.lat ) )\n" + 
				"		 * cos( radians( u.lng ) - radians(" + lng + ") )\n" + 
				"		 + sin( radians(" + lat + ") )\n" + 
				"		 * sin( radians( u.lat ) ) \n" + 
				"		 )\n" + 
				"		) AS distancia from Ubs u ORDER BY distancia ASC";

		Query query = em.createQuery(jpql);

		List<Ubs> listUbs= new ArrayList<>();
		List<Object[]> resultados = query.setMaxResults(13).getResultList();
		for (Object[] obj : resultados) {
			listUbs.add((Ubs) obj[0]);
		} 
		em.close();

		return listUbs;
	}
}
