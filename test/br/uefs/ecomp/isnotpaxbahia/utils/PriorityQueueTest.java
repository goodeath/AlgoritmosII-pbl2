package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.utils.PriorityQueue;

/**
* a informação de cada nó desta linked list é considerada como a prioridade no problema
*/

public class QueueTeste {

	private PriorityQueue<int> queue;


@Before
public void setUp(){
	queue = new MyPriorityQueue();
}

/**
* Testa se o elemento de maior prioridade está sendo retornado
*/
@Test
public void testMax(){
	queue.enqueue(10);
	queue.enqueue(20);
	assertEquals(20,queue.max());
	queue.enqueue(30);
	assertEquals(30,queue.max());
}

/**
* Teste unitário que verifica inserção dos elementos na fila
*/
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
