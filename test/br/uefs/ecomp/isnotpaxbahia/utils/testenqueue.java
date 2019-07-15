package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.utils.PriorityQueue;

/**
/* a Data de cada nó desta linked list é considerada como a prioridade no problema
*/

public class QueueTeste {

	private PriorityQueue<int> queue;


@Before
public void setUp(){
	queue = new MyQueue();
}

/**
/* Testa se o elemento de maior prioridade está sendo retornado
*/
@Test
public void testMax(){
	queue.enqueue(10);
	queue.enqueue(20);
	assertEquals(20,queue.max());
	queue.enqueue(30);
	assertEquals(30,queue.max());
}

@Test
public void testEnqueue(){
	queue.enqueue(10);
	assertEquals(10, queue.peek());
	assertEquals(10, queue.max());    //max retorna elemento de maior prioridade
	queue.enqueue(99);
	assertEquals(99, queue.max());
	queue.enqueue(23);
	assertEquals(99, queue.max());
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
/* Este teste verifica se a fila está obedecendo a ordem de prioridades na hora de remoção
*/

@Test
public void testRemove(){
	queue.enqueue(5);
	queue.enqueue(90);
	queue.enqueue(39);
	assertEquals(90,queue.remove());
	assertEquals(39,queue.remove());
	assertEquals(5,queue.remove());
}


}
