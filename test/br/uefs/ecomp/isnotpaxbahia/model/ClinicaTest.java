package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;
import br.uefs.ecomp.isnotpaxbahia.model.Exame;
import br.uefs.ecomp.isnotpaxbahia.model.Consulta;
import br.uefs.ecomp.isnotpaxbahia.util.LinkedList;
import br.uefs.ecomp.isnotpaxbahia.util.PriorityQueue;
import br.uefs.ecomp.isnotpaxbahia.utils.IPrioridade;

import java.util.Calendar;
import java.util.Date;

import javax.swing.text.html.HTMLDocument.Iterator; 



public class ClinicaTest{

	private Paciente p1, p2, p3;
	private Agendamento a1, a2, a3;
	private Lote lote1, lote2, lote3;
	private Consulta c1, c2, c3;
	private Exame e1, e2, e3;
	
	@Before
	public void setUp() throws Exception {
		clinica = new Clinica();
		
		p1 = new Paciente("Ronaldinho", "M", "Rua Barcelona", "8390102002", "01/02/1987");
		p2 = new Paciente("Tod Guten", "M","Rua do Hittler","1194663520","12/06/1949");
		p3 = new Paciente("Karla Perez" , "F", "Avenida do Alfabeto","7191234567", "03/03/1917");
		
		c1 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes");
        c2 = new Consulta("Dentista", "S1", "Dr. Maria", "Gertrudes");
        c3 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes");

		e1 = new Exame("Glicorraquia", "T3", "Dra. Maria", "Gertrudes");
		e2 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes");
		e3 = new Exame("Retossigmoidoscopia","T4", "Dra. Maria", "Gertrudes", "Uma boa noite de sono", "Jejum por 12 horas");
		
		lote1 = new Lote(c1,30);
		lote2 = new Lote(e1,30);
		lote3 = new Lote(c2,30);
		
		a1 = new Agendamento(lote1,p1);		
		a2 = new Agendamento(lote2,p2);
		a3 = new Agendamento(lote3,p3);
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
        
        assertTrue(p1.equals(cli.getPacientes().get(0)));
        assertTrue(p2.equals(cli.getPacientes().get(1)));
        assertTrue(p3.equals(cli.getPacientes().get(2)));

    }
    
    // User stories 2
    public void testSearchPaciente() {
    	clinica.getPacientes().add(p1);
    	clinica.getPacientes().add(p2);
        clinica.getPacientes().add(p3);
    	Iterator it = clinica.searchPacientByNome("Tod Guten");
    	assertTrue(it.hasNext());
    	assertTrue(p1.equals(it.next()));
    	
    	Iterator it = clinica.searchPacientByEndereco("Rua do Hittler");
    	assertTrue(it.hasNext());
    	assertTrue(p2.equals(it.next()));
    	
    	Iterator it = clinica.searchPacientByNome("Karla");
    	assertFalse(it.hasNext());
    	assertNull(it.next());
    }
    
    // User Stories 3
    
    public void testLancamentoLotes() {
    	
    }

    /**
     * Teste de unidade que verifica verifica se é possível buscar pacientes na lista de cadastro
     */
    @Test
    public void testSearchPacientes(){
        cli.getPacientes().add(p1);	
        cli.getPacientes().add(p2);	
        cli.getPacientes().add(p3);	

	Paciente p_nome = cli.getPacientes().searchPacientebyName("Tod");        
	assertEquals(p_nome,cli.getPacientes().get(1);
	
	Paciente p_sexo = cli.getPacientes().searchPacientesbySex("M");
	assertEquals(p_sexo,cli.getPacientes.get(0));
	assertEquals(p_sexo,cli.getPacientes.get(1));
	
	Paciente p_endereco = cli.getPacientes().searchPacientesbyAddress("Rua");
	assertEquals(p_endereco,cli.getPacientes.get(0));
	assertEquals(p_endereco,cli.getPacientes.get(1));

	Paciente p_telefone = cli.getPacientes().searchPacientesbyPhone("71");
	assertEquals(p_telefone,cli.getPacientes.get(2));	

	Paciente p_idade = cli.getPacientes().searchPacientesbyIdade("29");
	assertEquals(p_telefone,cli.getPacientes.get(2));

    }
    
    /**
    * Teste que verifica se o método que busca pelo elemento de maior prioridade está funcionando corretamente    
    */
    @Test
    public void testSearchPriority(){
	cli.getPacientes().add(p1);
	cli.getPacientes().add(p2);
	assertEquals(p2,cli.getPacientes().getMaxPriority());
	cli.getPacientes().add(p3);
	assertEquals(p3,cli.getPacientes().getMaxPriority());
   }

    /**
    * Verifica se os pacientes estao sendo inseridos na ordem correta na fila de presenca
    */
    @Test
    public void testEnqueuePresenca{
        
	cli.getPacientes().add(p1);
	cli.getPacientes().add(p2);
	cli.getPacientes().add(p3);

// Considerando que todos agendaram para mesmo dia, a ordem de insercao na fila de presenca eh: p3 - p2 - p1
	
	Paciente px = cli.getPacientes().getMaxPriority();
	cli.getPresenca().enqueue(cli.getPacientes.getMaxPriority());
	px = cli.getPacientes().getMaxPriority();
	cli.getPresenca().enqueue(px);
	px = cli.getPacientes().getMaxPriority();
	assertEquals(p3,cli.getPresenca().first());
	cli.getPresenca().dequeue();
	assertEquals(p2,cli.getPresenca().first());
	cli.getPresenca().dequeue();
	assertEquals(p1,cli.getPresenca().first());
    }
    
    /**
    * Teste unitário que verifica quais pacientes não se declararam presentes, ou seja ainda estão em lista de agendamento
    * getAgendamento retorna uma lista de pacientes que ja agendaram seu procedimento
    */
    
    @Test
    public void testFinishShift{
     
	cli.getAgendamento().add(p1);
	cli.getAgendamento().add(p2);
    	cli.getAgendamento().add(p3);
	    
    }
		     
		      /**
     * Teste de unidade que verifica o iterador de pacientes.
     */
    @Test
    public void testIterator() {
        sys.getClientes().add(p1);
        sys.getClientes().add(p2);
        sys.getClientes().add(p3);
        
        Iterator it = sys.getPacientes().iterator();
        
        assertTrue(it.hasNext());
        assertEquals(p1, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(p2, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(p3, it.next());
        
        assertFalse(it.hasNext());        
    }   
}
