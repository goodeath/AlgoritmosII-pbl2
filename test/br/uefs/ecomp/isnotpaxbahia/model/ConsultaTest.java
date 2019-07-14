package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class ConsultaTeste {
	
	private Consulta consulta1;
	
	/**
     * Este mÃ©todo Ã© executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que sÃ£o utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {

    	this.proc1 = new Procedimento("hemograma","S10","Dr. Ricardo","Gertrudes");
        this.consulta1 = new Consulta(proc1, 50,"Pediatra");
    }

	@Test
	public void testInitialization() {
		assertEquals(50,this.lote1.getQuantidade());
		assertEquals("Pediatra",this.getEspecialidade());
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
