package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ExameTest {

	private Exame exame1, exame2, exame3, exame4;

	@Before
	public void setUp throws Exception {		
		exame1 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes");
		exame2 = new Exame("Glicorraquia", "T3", "Dra. Maria", "Gertrudes");
		exame3 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes");
		exame4 = new Exame("Retossigmoidoscopia","T4", "Dra. Maria", "Gertrudes", "Uma boa noite de sono", "Jejum por 12 horas");
	}

	@Test
	public void testInitialization(){
		assertEquals("Jejum por 12 horas",exame4.getRestricao());
		assertEquals("Uma boa noite de sono",exame4.getRecomendacao());
		assertEquals("Retossigmoidoscopia",exame4.getNome());
		assertTrue("T4",exame4.getSala());
		assertTrue("Dra. Maria", exame4.getMedico());
		assertTrue("Gertrudes", exame4.getAtendente());
		
		assertEquals("Biópsia",exame3.getNome());
		assertTrue("S1",exame3.getSala());		
		assertTrue("Dr. Ricardo", exame3.getMedico());
		assertTrue("Gertrudes", exame3.getAtendente());
		
		
	}


	@Test
	public void testEquality(){
		assertFalse(exame1.equals(exame2));
		assertTrue(exame1.equals(exame3));
	}
}
