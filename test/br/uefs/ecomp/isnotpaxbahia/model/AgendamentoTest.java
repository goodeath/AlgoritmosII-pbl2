package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.model.Exame;
import br.uefs.ecomp.isnotpaxbahia.model.Consulta;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;


class AgendamentoTest {
	
	private Paciente paciente1;
	private Exame proc1;
	private Consulta proc2;
	private Lote lote1;
	private Lote lote2;
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
    	this.paciente1 = new Paciente("Tod Guten", "M", "Rua Alciano", "7599534432", "12/06/1989");
    	this.proc1 = new Exame("Endoscopia", "S1", "Dr. Ricardo", "Gertrudes");
    	this.proc2 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes");
        this.lote1 = new Lote(proc1, 50);
    	this.lote2 = new Lote(proc2, 50);
    }

	@Test
	public void testInitialization() {
		Agendamento agendamento = new Agendamento(this.lote1,this.paciente1);
		assertEquals(this.lote1.getQuantity(),49);
		assertEquals(this.lote2.getQuantity(),50);
		assertTrue(agendamento.getPaciente().equals(this.paciente1));
		assertTrue(agendamento.getProcedimento().equals(proc1));
		Agendamento agendamento2 = new Agendamento(this.lote2,this.paciente1);
		assertEquals(this.lote2.getQuantity(),49);
		Agendamento agendamento3 = new Agendamento(this.lote2,this.paciente1);
		assertEquals(this.lote2.getQuantity(),48);
	}
	
	@Test
	public void testEquality() {
		Agendamento agendamento = new Agendamento(this.lote1,this.paciente1);
		Agendamento agendamento2 = new Agendamento(this.lote1,this.paciente1);
		assertTrue(agendamento.equals(agendamento2));
		Agendamento agendamento3 = new Agendamento(this.lote2,this.paciente1);
		assertFalse(agendamento.equals(agendamento3));
	}
	
	
	@Test
	public void testSetPriority() {
		Agendamento agendamento1 = new Agendamento(this.lote1,this.paciente1);
		assertEquals(agendamento1.getPrioridade(),0);
	}

}
