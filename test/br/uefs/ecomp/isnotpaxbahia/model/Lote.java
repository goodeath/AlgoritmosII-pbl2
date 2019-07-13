package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.model.Exame;
import br.uefs.ecomp.isnotpaxbahia.model.Consulta;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;

class LoteTeste {
	
	private Lote lote1;
	private Procedimento proc1;
	private Procedimento proc2;
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
    	this.proc1 = new Exame("Endoscopia", "S1", "Dr. Ricardo", "Gertrudes");
    	this.proc2 = new Consulta("Clinico Geral")
        this.lote1 = new Lote(proc1, 50);
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
