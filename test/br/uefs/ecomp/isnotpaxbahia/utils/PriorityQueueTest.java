package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.utils.PriorityQueue;
import br.uefs.ecomp.isnotpaxbahia.Model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.Model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.Model.Lote;
import br.uefs.ecomp.isnotpaxbahia.utils.IPrioridade;

/**
* a informação de cada nó desta linked list é considerada como a prioridade no problema
*/

public class QueueTeste {

	private PriorityQueue <IPrioridade> queue;	
	private Lote l1, l2, l3, l4, l5;
	private Agendamento a1, a2, a3, a4, a5;
	private Paciente p1, p2, p3, p4, p5;

@Before
public void setUp(){
	queue = new MyPriorityQueue<IPrioridade>();
	
	Lote l1 = new Lote(50,"hemograma");
	Paciente p1 = new Paciente("marcio","M","Rua alvorada","7699990000","01/10/1990");
	Agendamento a1 = new Agendamento(Lote l1,Paciente p1);
	
	Lote l2 = new Lote(50,"consulta geral");
	Paciente p2 = new Paciente("jose","M","Rua nova alvorada","7699990001","01/10/1910");
	Agendamento a2 = new Agendamento(Lote l2,Paciente p2);
	
	Lote l3 = new Lote(50,"raiox");
	Paciente p3 = new Paciente("florentina","F","Avenida alvorada","7699990002","01/10/1987");
	Agendamento a3 = new Agendamento(Lote l3,Paciente p3);
	
	Lote l4 = new Lote(50,"ressonancia magnetica");
	Paciente p4 = new Paciente("josefina","F","Avenida afonso pena","7699990003","04/04/1977");
	Agendamento a4 = new Agendamento(Lote l4,Paciente p4);
	
	Lote l5 = new Lote(50,"ultrassom");
	Paciente p5 = new Paciente("josefa","F","Favela do alemao","7699990004","04/04/1958");
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
	
	queue = new MyPriorityQueue<IPrioridade>();
	
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

 
/**
* Teste unitário que verifica inserção dos elementos na fila
*/
@Test
public void testRemove(){
	queue.enqueue(a1);
	queue.enqueue(a2);
	queue.enqueue(a3);
	
	assertEquals(3,queue.size())
	assertEquals(a2,queue.first());
	queue.dequeue();
	
	assertEquals(2,queue.size());
	assertEquals(a3,queue.first());
	queue.dequeue();			//remove o a2, apesar de nao ser o primeiro
	
	assertEquals(1,queue.size());
	assertEquals(a1,queue.first());
	queue.dequeue();
	assertEquals(0,queue.size());
	assertNull(queue.dequeue());
}
	

@Test
public void testIsEmpty(){
	assertTrue(queue.isEmpty());
	queue.enqueue(a1);
	assertFalse(queue.isEmpty());
	queue.dequeue();
	assertTrue(queue.isEmpty());
	queue.enqueue(a2);
	queue.enqueue(a3);
	assertFalse(queue.isEmpty());
	queue.dequeue();
	assertFalse(queue.isEmpty());
	queue.dequeue();
	assertFalse(queue.isEmpty());
	queue.dequeue();
	assertTrue(queue.isEmpty());
}
 

}
