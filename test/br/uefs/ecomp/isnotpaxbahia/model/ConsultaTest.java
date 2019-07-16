package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class ConsultaTeste {
	
	private Consulta consulta1;
	private Consulta consulta2;
	private Consulta consulta3;	
	/**
     * Este mÃ©todo Ã© executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que sÃ£o utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        consulta1 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes");
        consulta2 = new Consulta("Dentista", "S1", "Dr. Maria", "Gertrudes");
        consulta3 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes");
    }

	@Test
	public void testInitialization() {
		assertEquals(this.consulta1.getNome(),"Clinico Geral");
		assertEquals(this.consulta1.getMedico(),"Dr. Ricardo");
		assertEquals(this.consulta1.getAtendente(),"Gertrudes");
		assertEquals(this.consulta1.getSala(),"S1");
	}

	@Test
	public void testEquality() {
		assertFalse(consulta1.equals(consulta2));
		assertTrue(consulta1.equals(consulta3));
	}

}
