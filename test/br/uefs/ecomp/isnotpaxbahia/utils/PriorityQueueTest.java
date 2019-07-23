package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.isnotpaxbahia.utils.PriorityQueue;
import br.uefs.ecomp.isnotpaxbahia.model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;
import br.uefs.ecomp.isnotpaxbahia.utils.IPrioridade;

/**
* a informação de cada nó desta linked list é considerada como a prioridade no problema
*/

public class QueueTest {

	private PriorityQueue <IPrioridade> queue;	
	private Lote l1, l2, l3, l4, l5;
	private Agendamento a1, a2, a3, a4, a5;
	private Paciente p1, p2, p3, p4, p5;

	@Before
	public void setUp(){
		queue = new PriorityQueue<IPrioridade>();
		
		Lote l1 = new Lote(50,"hemograma");
		Paciente p1 = new Paciente("marcio","M","Rua alvorada","7699990000","01/10/1990", "54597533508");
		Agendamento a1 = new Agendamento(Lote l1,Paciente p1);
		
		Lote l2 = new Lote(50,"consulta geral");
		Paciente p2 = new Paciente("jose","M","Rua nova alvorada","7699990001","01/10/1910", "85803939579");
		Agendamento a2 = new Agendamento(Lote l2,Paciente p2);
		
		Lote l3 = new Lote(50,"raiox");
		Paciente p3 = new Paciente("florentina","F","Avenida alvorada","7699990002","01/10/1987", "66629301560");
		Agendamento a3 = new Agendamento(Lote l3,Paciente p3);
		
		Lote l4 = new Lote(50,"ressonancia magnetica");
		Paciente p4 = new Paciente("josefina","F","Avenida afonso pena","7699990003","04/04/1977", "62577395515");
		Agendamento a4 = new Agendamento(Lote l4,Paciente p4);
		
		Lote l5 = new Lote(50,"ultrassom");
		Paciente p5 = new Paciente("josefa","F","Favela do alemao","7699990004","04/04/1958", "71702517527");
		Agendamento a5= new Agendamento(Lote l5,Paciente p5);
		
		
	}

	/**
	* Testa se o elemento de maior prioridade está sendo retornado
	*/
	@Test
	public void testAdd(){
		queue.enqueue(a1);
		assertTrue(queue.get(0).equals(a1));
		assertEquals(queue.get(0).getPrioridade(),1);
		assertEquals(queue.size(),1);
		
		queue.enqueue(a2,Agendamento.PRIORIDADE_GRAVIDA);
		assertTrue(queue.get(0).equals(a2));
		assertEquals(queue.get(0).getPrioridade(),2);
		assertEquals(queue.size(),2);
		
		queue.enqueue(a3,Agendamento.PRIORIDADE_IDOSO);
		assertTrue(queue.get(0).equals(a3));
		assertEquals(queue.get(0).getPrioridade(),3);
		assertEquals(queue.size(),3);
		
		queue.enqueue(a4,Agendamento.PRIORIDADE_DEFICIENTE);
		assertTrue(queue.get(0).equals(a4));
		assertEquals(queue.get(0).getPrioridade(),4);
		assertEquals(queue.size(),4);
		
		queue.enqueue(a5,Agendamento.PRIORIDADE_MUITO_IDOSO);
		assertTrue(queue.get(0).equals(a5));
		assertEquals(queue.get(0).getPrioridade(),5);
		assertEquals(queue.size(),5);
		
		queue = new PriorityQueue<IPrioridade>();
		
		queue.enqueue(a5,Agendamento.PRIORIDADE_MUITO_IDOSO);
		queue.enqueue(a4,Agendamento.PRIORIDADE_MUITO_IDOSO);
		assertTrue(queue.get(0).equals(a5));
		assertTrue(queue.get(1).equals(a4));
		queue.enqueue(a3,Agendamento.PRIORIDADE_IDOSO);
		assertTrue(queue.get(2).equals(a3));
		queue.enqueue(a2,Agendamento.PRIORIDADE_IDOSO);
		assertTrue(queue.get(2).equals(a3));
		assertTrue(queue.get(3).equals(a2));
	}
	

}
