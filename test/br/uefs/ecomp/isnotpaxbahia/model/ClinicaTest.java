package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.isnotpaxbahia.model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;
import br.uefs.ecomp.isnotpaxbahia.model.Exame;
import br.uefs.ecomp.isnotpaxbahia.model.Consulta;
import br.uefs.ecomp.isnotpaxbahia.utils.LinkedList;
import br.uefs.ecomp.isnotpaxbahia.utils.PriorityQueue;
import br.uefs.ecomp.isnotpaxbahia.utils.IPrioridade;

import java.util.Calendar;
import java.util.Date;

import java.util.Iterator; 



public class ClinicaTest{

	private Paciente p1, p2, p3;
	private Agendamento a1, a2, a3;
	private Lote l1, l2, l3, l4;
	private Consulta c1, c2, c3;
	private Exame e1, e2, e3;
	private Clinica clinica;
	
	@Before
	public void setUp() {
		clinica = new Clinica();
		
		p1 = new Paciente("Ronaldinho", 'M', "Rua Barcelona", "8390102002", "01/02/1987", "75670034570");
		p2 = new Paciente("Tod Guten", 'M',"Rua do Hittler","1194663520","12/06/1949", "41023802562");
		p3 = new Paciente("Karla Perez" , 'F', "Avenida do Alfabeto","7191234567", "03/03/1917", "41277228515");
		
		c1 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes", "684512");
        c2 = new Consulta("Dentista", "S1", "Dr. Maria", "Gertrudes", "597842");
        c3 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes", "684512");
		
		e1 = new Exame("Glicorraquia", "T3", "Dra. Maria", "Gertrudes", "456123");
		e2 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes", "159951");
		e3 = new Exame("Retossigmoidoscopia","T4", "Dra. Maria", "Gertrudes","478235", "Uma boa noite de sono", "Jejum por 12 horas");
		
		l1= new Lote(c1,31);
		l2= new Lote(e1,31);
		l3= new Lote(c2,31);
		l4= new Lote(c3,1);
		
		a1 = new Agendamento(l1,p1);		
		a2 = new Agendamento(l2,p2);
		a3 = new Agendamento(l3,p3);
	}

    
    /**
     * Teste de unidade que verifica a inserção de pacientes no cadastro da clínica.
     * User Stories 1 . Cadastrar paciente
     */
    @Test
    public void testAddPaciente() {
    	clinica.getPacientes().add(p1);
    	clinica.getPacientes().add(p2);
        clinica.getPacientes().add(p3);
        assertEquals(clinica.getPacientes().size(),3);
        
        assertTrue(p1.equals(clinica.getPacientes().get(0)));
        assertTrue(p2.equals(clinica.getPacientes().get(1)));
        assertTrue(p3.equals(clinica.getPacientes().get(2)));

    }
    
    // User stories 2
    @Test
    public void testSearchPaciente() {
    	clinica.getPacientes().add(p1);
    	clinica.getPacientes().add(p2);
        clinica.getPacientes().add(p3);
    	Iterator<Paciente> it = clinica.searchPacientByNome("Tod Guten");
    	assertTrue(it.hasNext());
    	assertTrue(p2.equals(it.next()));
    	assertFalse(it.hasNext());
    	
    	it = clinica.searchPacientByEndereco("Rua do Hittler");
    	assertTrue(it.hasNext());
    	assertTrue(p2.equals(it.next()));
    	assertFalse(it.hasNext());
    	
    	it = clinica.searchPacientByNome("Karla");
    	assertTrue(it.hasNext());
    	assertTrue(p3.equals(it.next()));
    }
    
    // User Stories 3 / 8
    @Test
    public void testLancamentoLotes() {
    	assertEquals("Exame/Consulta não disponível esta semana",clinica.agendar(p1,l1));
    	clinica.getLotes().add(l1);
    	clinica.getLotes().add(l2);
    	clinica.getLotes().add(l3);
    	clinica.getLotes().add(l4);
    	assertEquals("",clinica.agendar(p1,l1));
    	
    	assertEquals(29,clinica.getLotes().get(0).getQuantidade());
    	
    	assertEquals("",clinica.agendar(p2,l4));
    	assertEquals("Exame/Consulta esgotado para esta semana",clinica.agendar(p3,l4));
    }
    
    // User Stories 4
    @Test
    public void testConfirmarAgendamento() {
    	clinica.getPacientes().add(p1);
    	clinica.getPacientes().add(p2);
        clinica.getPacientes().add(p3);
        
        clinica.getLotes().add(l1);
        clinica.getLotes().add(l2);
        
        
        clinica.agendar(p1,l1);
        clinica.agendar(p2,l1);
        clinica.agendar(p3,l2);
        
        assertEquals(3,clinica.getAgendados().size());
        
        clinica.confirmarAgendamento(p1);
        assertEquals(2,clinica.getAgendados().size());
        assertEquals(1,clinica.getConfirmados().size());
        assertEquals(1,clinica.getConfirmados().get(0).getPrioridade());
        Agendamento a1 = (Agendamento) clinica.getConfirmados().get(0);
        assertTrue(p1.equals(a1.getPaciente()));
        
        clinica.confirmarAgendamento(p3,Agendamento.PRIORIDADE_DEFICIENTE);
        assertEquals(1,clinica.getAgendados().size());
        assertEquals(2,clinica.getConfirmados().size());
        assertEquals(4,clinica.getConfirmados().get(0).getPrioridade());
        Agendamento a3 = (Agendamento) clinica.getConfirmados().get(0);
        assertTrue(p3.equals(a3.getPaciente()));
        
        clinica.confirmarAgendamento(p2,Agendamento.PRIORIDADE_GRAVIDA);
        assertEquals(0,clinica.getAgendados().size());
        assertEquals(3,clinica.getConfirmados().size());
        Agendamento a2 = (Agendamento) clinica.getConfirmados().get(1);
        assertEquals(2,a2.getPrioridade());
        assertTrue(p2.equals(a2.getPaciente()));
    }
    
    //Stories 4
    
    @Test
    public void testPacientesAusentes() {
    	clinica.getPacientes().add(p1);
    	clinica.getPacientes().add(p2);
        clinica.getPacientes().add(p3);
        clinica.getLotes().add(l1);
    	clinica.getLotes().add(l2);
        clinica.agendar(p1,l1);
        clinica.agendar(p2,l1);
        clinica.agendar(p3,l2);
                
        clinica.confirmarAgendamento(p2,Agendamento.PRIORIDADE_DEFICIENTE);
        assertEquals(2,clinica.getAgendados().size());
        assertEquals(1,clinica.getConfirmados().size());
        
        Iterator<Agendamento> it = clinica.encerrarSemana();
        assertTrue(it.hasNext());
        assertTrue(p1.equals(it.next().getPaciente()));
        assertTrue(it.hasNext());
        assertTrue(p3.equals(it.next().getPaciente()));
        assertFalse(it.hasNext());

    }
    
    // Stories 6
    
    @Test
    public void testHistoricoDeProcedimento() {
    	clinica.getPacientes().add(p1);
    	clinica.getPacientes().add(p2);
        clinica.getPacientes().add(p3);
        clinica.getLotes().add(l1);
    	clinica.getLotes().add(l2);
        clinica.agendar(p1,l1);
        clinica.agendar(p2,l1);
        clinica.agendar(p3,l2);
        clinica.confirmarAgendamento(p2,Agendamento.PRIORIDADE_IDOSO);
        clinica.confirmarAgendamento(p1,Agendamento.PRIORIDADE_DEFICIENTE);        
        clinica.confirmarAgendamento(p3,Agendamento.PRIORIDADE_MUITO_IDOSO);
        
        clinica.chamarPaciente(l1);
        assertEquals(2,clinica.getConfirmados().size());
        assertEquals(1,clinica.getAtendidos().size());
        
        clinica.chamarPaciente(l1);
        assertEquals(1,clinica.getConfirmados().size());
        assertEquals(2,clinica.getAtendidos().size());
        
        clinica.chamarPaciente(l2);
        assertEquals(0,clinica.getConfirmados().size());
        assertEquals(3,clinica.getAtendidos().size());
        
        Iterator<Agendamento> it = clinica.getHistorico();
        assertTrue(it.hasNext());
        
        Agendamento a1 = it.next();
        assertTrue(p1.equals(a1.getPaciente()));
        assertTrue(l1.equals(a1.getLote()));
        assertTrue(it.hasNext());
        
        Agendamento a2 = it.next();
        assertTrue(p2.equals(a2.getPaciente()));
        assertTrue(l1.equals(a2.getLote()));
        assertTrue(it.hasNext());
        
        Agendamento a3 = it.next();
        assertTrue(p3.equals(a3.getPaciente()));
        assertTrue(l2.equals(a3.getLote()));
    }
    
    // Stories 7
    @Test
    public void testPesquisarHistorico() {
    	clinica.getPacientes().add(p1);
    	clinica.getPacientes().add(p2);
        clinica.getPacientes().add(p3);
        clinica.getLotes().add(l1);
    	clinica.getLotes().add(l2);
        clinica.agendar(p1,l1);
        clinica.agendar(p2,l1);
        clinica.agendar(p3,l2);
        clinica.confirmarAgendamento(p2,Agendamento.PRIORIDADE_IDOSO);
        clinica.confirmarAgendamento(p1,Agendamento.PRIORIDADE_DEFICIENTE);        
        clinica.confirmarAgendamento(p3,Agendamento.PRIORIDADE_MUITO_IDOSO);
        clinica.chamarPaciente(l1);
        clinica.chamarPaciente(l1);
        clinica.chamarPaciente(l2);
        
        Iterator<Agendamento> it = clinica.getHistoricoByLote(l1);
        assertTrue(it.hasNext());
        
        Agendamento a1 = it.next();
        assertTrue(l1.equals(a1.getLote()));
        assertTrue(p1.equals(a1.getPaciente()));
        assertTrue(it.hasNext());
        
        Agendamento a2 = it.next();
        assertTrue(p2.equals(a2.getPaciente()));
        assertTrue(l1.equals(a2.getLote()));
        assertFalse(it.hasNext());
        
        
        it = clinica.getHistoricoByMedico("Dra. Maria");
        assertTrue(it.hasNext());
        Agendamento a3 = it.next();
        assertTrue(p3.equals(a3.getPaciente()));
        assertTrue(l2.equals(a3.getLote()));
        
        assertFalse(it.hasNext());
    }
 
    
  
    
}
