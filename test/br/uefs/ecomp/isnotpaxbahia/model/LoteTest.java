package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.isnotpaxbahia.model.Exame;
import br.uefs.ecomp.isnotpaxbahia.model.Consulta;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;

public class LoteTest {
	
	private Lote lote1;
	private Lote lote2;
	private Lote lote3;
	private Procedimento proc1;
	private Procedimento proc2;
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() {
    	proc1 = new Exame("Retossigmoidoscopia","T4", "Dra. Maria", "Gertrudes", "126842", "Uma boa noite de sono", "Jejum por 12 horas");
    	proc2 = new Consulta("Clinico Geral", "S1", "684512", "Dr. Ricardo", "Gertrudes", "Pediatria");
        lote1 = new Lote(proc1, 50);
        lote2 = new Lote(proc2, 50);
        lote3 = new Lote(proc1, 30);
    }

	@Test
	public void testInitialization() {
		assertEquals(50,lote1.getQuantidade());
		assertTrue(proc1.equals(lote1.getProcedimento()));
		assertEquals(50,lote2.getQuantidade());
		assertTrue(proc2.equals(lote2.getProcedimento()));
	}
	
	@Test
	public void testSetQuantity() {
		assertEquals(50,lote1.getQuantidade());
		lote1.setQuantidade(10);
		assertEquals(10,lote1.getQuantidade());
	}
	
	@Test
	public void testDecreaseQuantity() {
		assertEquals(50,lote1.getQuantidade());
		lote1.diminuir();
		assertEquals(49,lote1.getQuantidade());
		lote1.diminuir();
		assertEquals(48,lote1.getQuantidade());
		lote1.setQuantidade(1);
		lote1.diminuir();
		assertEquals(0,lote1.getQuantidade());
		lote1.diminuir();
		assertEquals(0,lote1.getQuantidade());
	}
	
	@Test
	public void testEquals(){
		assertFalse(lote1.equals(lote2));
		assertFalse(lote1.equals(lote3));
		assertTrue(lote1.equals(lote1));
	}
	
	@Test
	public void testEquality(){
		assertFalse(lote1.getProcedimento().equals(lote2.getProcedimento()));
		assertTrue(lote1.getProcedimento().equals(lote3.getProcedimento()));
	}

}
