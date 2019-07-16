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
	Paciente p3 = new Paciente("josefa","F","Avenida alvorada","7699990002","01/10/1987");
	Agendamento a3 = new Agendamento(Lote l3,Paciente p3);
	
	Lote l4 = new Lote(50,"ressonancia magnetica");
	Paciente p4 = new Paciente("josefa","F","Avenida afonso pena","7699990003","04/04/1977");
	Agendamento a4 = new Agendamento(Lote l4,Paciente p4);
	
	Lote l5 = new Lote(50,"ultrassom");
	Paciente p5 = new Paciente("josefa","F","Avenida papagaio","7699990004","04/04/1987");
	Agendamento a5= new Agendamento(Lote l5,Paciente p5);
	
	
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
	queue.enqueue(a1);
	assertEquals(a1, queue.peek());
	assertEquals(a1, queue.max());    //max retorna elemento de maior prioridade
	queue.enqueue(a2);
	assertEquals(a2, queue.max());
	queue.enqueue(a3);
	assertEquals(a2, queue.max());
}
	
/**
*Testa insercao de dois elementos, sendo o segundo de maior prioridade, portanto o primeiro a ser removido
*/
@Test
public void testinsert2_removemaiorprioridade(){
	queue.enqueue(a1);
	queue.enqueue(a2);
	assertEquals(a2,queue.first());
	assertEquals(a2,queue.dequeue());
}
	
@Test
public void testinsert3_RemoveMaiorPrioridade(){
	queue.enqueue(a1);
	queue.enqueue(a3);
	queue.enqueue(a2);
	
}

@Test
public void testisEmpty(){
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

/**
/* Teste unitário que verifica a remoção dos elementos da fila
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

}
