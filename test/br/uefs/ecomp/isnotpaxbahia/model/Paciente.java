package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.model.Paciente;

import java.util.Calendar;
import java.util.Date;

class PacienteTeste {
	
	private Paciente paciente1;
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        this.paciente1 = new Paciente("Tod Guten", "7599534432","Rua do Hittler","12/06/1990");
    }

	@Test
	public void testInitialization() {
		assertEquals("Tod Guten",this.paciente1.getNome());
		assertEquals("7599534432",this.paciente1.getTelefone());
		assertEquals("Rua do Hittler, 666",this.paciente1.getEndereco);
		assertEquals(Calendar.YEAR-1990, this.paciente1.getIdade());
	}
	
	@Test
	public void testEquals() {
		Paciente paciente2 = new Paciente("Irish Abah", "7599534432","Rua do Hittler","12/06/1990");
		assertFalse(this.paciente1.equals(paciente2));
		Paciente paciente3 = new Paciente("Tod Guten","1194663520","Rua do Hittler","12/06/1990");
		assertFalse(this.paciente1.equals(paciente3));
		Paciente paciente4 = new Paciente("Tod Guten","7599534432","Rua do Hittler","12/06/1990");
		assertTrue(this.paciente1.equals(paciente4));
	}

}