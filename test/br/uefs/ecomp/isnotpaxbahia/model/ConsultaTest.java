package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ConsultaTest {
	
	private Consulta consulta1;
	private Consulta consulta2;
	private Consulta consulta3;	
	/**
     * Este mÃ©todo Ã© executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que sÃ£o utilizados nos testes.
     */
    @Before
    public void setUp() {
        consulta1 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes", "684512", "Pediatria");
        consulta2 = new Consulta("Dentista", "S1", "Dr. Maria", "Gertrudes", "597842". "Neurologia");
        consulta3 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes", "987562", "Urologia");
    }

	@Test
	public void testInitialization() {
		assertEquals(this.consulta1.getNome(),"Clinico Geral");
		assertEquals(this.consulta1.getMedico(),"Dr. Ricardo");
		assertEquals(this.consulta1.getAtendente(),"Gertrudes");
		assertEquals(this.consulta1.getSala(),"S1");
		assertEquals(this.consulta1.getId(),"684512");
		assertEquals(this.consulta1.getEspecialidade(),"Pediatria");
	}

	@Test
	public void testEquality() {
		assertFalse(consulta1.equals(consulta2));
		assertFalse(consulta1.equals(consulta3));
		assertTrue(consulta.equals(consulta1));
	}

}
