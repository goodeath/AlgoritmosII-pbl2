package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ExameTeste {

	private Exame exame1;

	@Before
	public void setUp throws Exception {
		this.proc1 = new Procedimento("hemograma","S10","Dr. Ricardo","Gertrudes");
		this.exame1 = new Exame(proc1,50,"nao respirar","esteja hidratado","hemograma");
	}

	@Test
	public void testInitialization(){
		assertEquals(50,this.lote1.getQuantidade());
		assertEquals("hemograma",this.getTipo());
		assertEquals("nao respirar",this.getRecomendacao());
		assertFalse("nao comer",this.getRecomendacao());
		assertEquals("esteja hidratado",this.getRestricao());
	}

	@Test
	public void testSetQuantity() {
		assertEquals(50,this.lote1.getQuantidade());
		this.lote1.setQuantity(10);
		assertEquals(10,this.lote1.getQuantidade());
	}

	@Test
	public void testDecreaseQuantity() {
		assertEquals(50,this.lote1.getQuantidade());
		this.lote1.decrease();
		assertFalse(48,this.lote1.getQuantidade());
		assertEquals(49,this.lote1.getQuantidade());
		this.lote1.decrease();
		assertEquals(48,this.lote1.getQuantidade());
		assertEquals(0,this.lote1.getQuantidade());
		assertNull(this.lote1.decrease());
	}
}
