package br.com.bionexo.ubs.controller;

import org.junit.Test;

import junit.framework.Assert;

public class TestaConsultaCalculo {

	@Test
	public void deveExecutarCalculoDeProx() {
		CalculaUbsProx c = new CalculaUbsProx();
		Assert.assertNotNull("Retorno do calculo nulo", c.calcula("-23.39","-46.43"));
	}
}
