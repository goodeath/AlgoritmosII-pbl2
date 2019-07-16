package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.utils.PriorityQueue;

/**
* a informação de cada nó desta linked list é considerada como a prioridade no problema
*/

public class QueueTeste {

	private PriorityQueue <Agendamento> queue;	


@Before
public void setUp(){
	queue = new MyPriorityQueue<Agendamento>();
	
	Lote l1 = new Lote(50,"hemograma");
	Paciente p1 = new Paciente("marcio","M","Rua alvorada","7699990000","01/10/1990");
	Agendamento a1 = new Agendamento(Lote l1,Paciente p1);
	
	Lote l2 = new Lote(50,"consulta geral");
	Paciente p2 = new Paciente("jose","M","Rua alvorada","7699990001","01/10/1910");
	Agendamento a2 = new Agendamento(Lote l2,Paciente p2);
	
	Lote l3 = new Lote(50,"raiox");
	Paciente p3 = new Paciente("josefa","F","Avenida alvorada","7699990002","01/10/1993");
	Agendamento a3 = new Agendamento(Lote l3,Paciente p3);
}

/**
* Testa se o elemento de maior prioridade está sendo retornado
*/
@Test
public void testMax(){
	queue.enqueue(a1);
	queue.enqueue(a2);
	assertEquals(a2,queue.max());
	queue.enqueue(a3);
	assertEquals(a3,queue.max());
}

/**
*  Teste que verifica se os pacientes de prioridade 5 estão sendo inseridos no começo
*/
@Test
public void insertP5(){
	queue.enqueue(a1);
	queue.enqueue(a2);
	queue.enqueue(a2);
	queue.enqueue(a3);
	assertEquals(a3,queue.max());
	queue.enqueue_p5();
	assertEquals(,queue.max());
	assertEquals(5,queue.first());
	queue.enqueue(3);
	queue.enqueue_p5(5);
	assertEquals(5,queue.first());
	queue.dequeue();
	assertEquals(5,queue.first());
}
	
	
/**
* Teste unitário que verifica inserção dos elementos na fila
*/
@Test
public void testEnqueue(){
	queue.enqueue(1);
	assertEquals(1, queue.peek());
	assertEquals(1, queue.max());    //max retorna elemento de maior prioridade
	queue.enqueue(9);
	assertEquals(9, queue.max());
	queue.enqueue(2);
	assertEquals(9, queue.max());
}

@Test
public void testisEmpty(){
	assertTrue(queue.isEmpty());
	queue.enqueue(20);
	assertFalse(queue.isEmpty());
	queue.dequeue();
	assertTrue(queue.isEmpty());
	queue.enqueue(20);
	queue.enqueue(30);
	queue.enqueue(10);
	assertFalse(queue.isEmpty());
	queue.dequeue();
	assertFalse(queue.isEmpty());
	queue.dequeue();
	assertFalse(queue.isEmpty());
	queue.dequeu();
	assertTrue(queue.isEmpty());
}

/**
/* Teste unitário que verifica a remoção dos elementos da fila
*/

@Test
public void testRemove(){
	queue.enqueue(5);
	queue.enqueue(90);
	queue.enqueue(39);
	
	assertEquals(3,queue.size())
	assertEquals(5,queue.first());
	queue.dequeue();
	
	assertEquals(2,queue.size());
	assertEquals(90,queue.first());
	queue.dequeue();
	
	assertEquals(39,queue.first());
	assertEquals(1,queue.first());
	queue.dequeue();
	assertEquals(0,queue.size());
	assertNull(queue.dequeue());
}

}
