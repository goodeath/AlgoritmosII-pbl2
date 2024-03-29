package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ExameTest {

	private Exame exame1, exame2, exame3, exame4;

	@Before
	public void setUp() {		
		exame1 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes", "126842");
		exame2 = new Exame("Glicorraquia", "T3", "Dra. Maria", "Gertrudes", "789364");
		exame3 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes", "126842");
		exame4 = new Exame("Retossigmoidoscopia","T4", "Dra. Maria", "Gertrudes", "627512", "Uma boa noite de sono", "Jejum por 12 horas");
	}

	@Test
	public void testInitialization(){
		assertEquals("Jejum por 12 horas",exame4.getRestricao());
		assertEquals("Uma boa noite de sono",exame4.getRecomendacao());
		assertEquals("Retossigmoidoscopia",exame4.getTipo());
		assertEquals("T4",exame4.getSala());
		assertEquals("Dra. Maria", exame4.getMedico());
		assertEquals("Gertrudes", exame4.getAtendente());
		assertEquals("627512", exame4.getId());
		
		assertEquals("Biópsia",exame3.getTipo());
		assertEquals("S1",exame3.getSala());		
		assertEquals("Dr. Ricardo", exame3.getMedico());
		assertEquals("Gertrudes", exame3.getAtendente());
		assertEquals("126842", exame3.getId());
		
		
	}


	@Test
	public void testEquality(){
		assertFalse(exame1.getId().equals(exame2.getId()));
		assertTrue(exame1.getId().equals(exame3.getId()));
	}
}
