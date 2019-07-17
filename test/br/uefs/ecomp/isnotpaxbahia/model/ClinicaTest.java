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

import java.util.Calendar;
import java.util.Date; 



public class ClinicaTest{

	
	@Before
	public void setUp() throws Exception {
	cli = new Clinica();
	
	p1 = new Paciente("Ronaldinho", "M", "Rua Barcelona", "8390102002", "01/02/1987");
	p2 = new Paciente("Tod Guten", "M","Rua do Hittler","1194663520","12/06/1949");
	p3 = new Paciente("Karla Perez" , "F", "Avenida do Alfabeto","7191234567", "03/03/1917");
	
	a1 = new Agendamento();		
	a2 = new Agendamento();
	a3 = new Agendamento();
	
	lote1 = new Lote(proc1,30);
	lote2 = new Lote(proc2,30);
	lote3 = new Lote(proc3,30);

	c1 = new Consulta(proc1,30,"Pediatra");
        c2 = new Consulta(proc1,29,"Pediatra");
	c3 = new Consulta(proc3,30,"Gastroenterologista");
	e1 = new Exame(proc1,28,"estar em jejum","se hidratar","hemograma");
	e2 = new Exame(proc1,27,"estar em jejum","se hidratar","hemograma");
	e3 = new Exame(proc2,30,"estar em jejum de 12h","se hidratar","ressonancia magnetica");

	
	}

    
    /**
     * Teste de unidade que verifica a inserção de pacientes no cadastro da clínica.
     */
    @Test
    public void testAddCliente() {
        cli.getPacientes().add(p1);
        cli.getPacientes().add(p2);
        cli.getPacientes().add(p3);
        assertEquals(sys.getPacientes().size(),3);
        
        assertEquals(p1, cli.getPacientes().get(0));
        assertEquals(p2, cli.getPacientes().get(1));
        assertEquals(p3, cli.getPacientes().get(2));

    }

    /**
     * Teste de unidade que verifica verifica se é possível buscar pacientes
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

}
