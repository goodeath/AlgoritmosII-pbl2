package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.isnotpaxbahia.utils.PriorityQueue;
import br.uefs.ecomp.isnotpaxbahia.model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.model.Consulta;
import br.uefs.ecomp.isnotpaxbahia.model.Exame;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;
import br.uefs.ecomp.isnotpaxbahia.utils.IPrioridade;

/**
* a informação de cada nó desta linked list é considerada como a prioridade no problema
*/

public class PriorityQueueTest {

	private PriorityQueue queue;	
	private Lote l1, l2, l3, l4, l5;
	private Agendamento a1, a2, a3, a4, a5;
	private Paciente p1, p2, p3, p4, p5;
	private Exame e1, e2, e3;
	private Consulta c1, c2;

	@Before
	public void setUp(){
		queue = new PriorityQueue();
		
		e1 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes", "126842");	
		l1 = new Lote(e1,10);
		p1 = new Paciente("marcio",'M',"Rua alvorada","7699990000","01/10/1990", "54597533508");
		a1 = new Agendamento(l1, p1);
		
		e2 = new Exame("Glicorraquia", "T3", "Dra. Maria", "Gertrudes", "789364");
		l2 = new Lote(e2,20);
		p2 = new Paciente("jose",'M',"Rua nova alvorada","7699990001","01/10/1910", "85803939579");
		a2 = new Agendamento(l2, p2);
		
		e3 = new Exame("Biópsia", "S1", "Dr. Ricardo", "Gertrudes", "126842");
		l3 = new Lote(e3, 30);
		p3 = new Paciente("florentina",'F',"Avenida alvorada","7699990002","01/10/1987", "66629301560");
		a3 = new Agendamento(l3, p3);
		
		c1 = new Consulta("Clinico Geral", "S1", "Dr. Ricardo", "Gertrudes", "684512");
		l4 = new Lote(c1,40);
		p4 = new Paciente("josefina",'F',"Avenida afonso pena","7699990003","04/04/1977", "62577395515");
		a4 = new Agendamento(l4, p4);
		
		c2 = new Consulta("Dentista", "S1", "Dr. Maria", "Gertrudes", "597842");
		l5 = new Lote(c2, 50);
		p5 = new Paciente("josefa",'F',"Favela do alemao","7699990004","04/04/1958", "71702517527");
		a5= new Agendamento(l5, p5);
		
		
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
		
		queue = new PriorityQueue();
		
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
