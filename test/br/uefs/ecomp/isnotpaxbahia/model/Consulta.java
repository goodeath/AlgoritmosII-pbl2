package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class ConsultaTeste {
	
	private Consulta consulta1;
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
//    	this.proc1 = new Procedimento("Endoscopia", "S1", "Dr. Ricardo", "Gertrudes");
//        this.consulta1 = new Consulta(proc1, 50);
    }

	@Test
	public void testInitialization() {
		assertEquals(50,this.lote1.getQuantidade());
		assertTrue(this.proc1.equals(this.lote1.getProcedimento()));
	}
	
	@test
	public void testSetQuantity() {
		assertEquals(50,this.lote1.getQuantidade());
		this.lote1.setQuantity(10);
		assertEquals(10,this.lote1.getQuantidade());
	}
	
	@Test
	public void testDecreaseQuantity() {
		assertEquals(50,this.lote1.getQuantidade());
		this.lote1.decrease();
		assertEquals(49,this.lote1.getQuantidade());
		this.lote1.decrease();
		assertEquals(48,this.lote1.getQuantidade());
		this.lote1.setQuantity(1);
		this.lote1.decrease();
		assertEquals(0,this.lote1.getQuantidade());
		this.lote1.decrease();
		assertEquals(0,this.lote1.getQuantidade());
	}

}
