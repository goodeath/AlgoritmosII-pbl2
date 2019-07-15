package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.utils.LinkedList;

class LinkedListTeste {
	
	private LinkedList<int> list;
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
    	this.list = new MyLinkedList<int>();
    }

	@Test
	public void testAdd() {
		assertEquals(0,list.size());
		this.list.add(1);
		assertEquals(1,list.size());
		this.list.add(2);
		assertEquals(2,list.size());
		this.list.add(3);
		assertEquals(3,list.size());
	}
	
	@Test
	public void testGet() {
		this.list.add(1);
		this.list.add(2);
		this.list.add(3);
		assertEquals(1,list.get(0));
		assertEquals(2,list.get(1));
		assertEquals(3,list.get(2));
	}
	
	@Test
    public void testRemove(){
        assertNull(this.list.remove(0));
        assertNull(this.list.remove(1));
        
        this.list.add(10);
        this.list.add(20);
        this.list.add(30);
        
        assertEquals(20, this.list.remove(1));
        assertEquals(2, this.list.size());

        assertEquals(30, list.remove(1));
        assertEquals(1, list.size());

        assertNull(list.remove(1));

        assertEquals(10, list.remove(0));
        assertEquals(0, list.size());
        
    }
	
	 /**
     * Teste de unidade que verifica se os métodos de inserção e remoção de objetos 
     * na lista estão funcionando corretamente.
     */
    @Test
    public void testInsertDelete() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertFalse(list.isEmpty());

        assertEquals(30, list.remove(2));
        assertFalse(list.isEmpty());

        assertEquals(20, list.remove(1));
        assertFalse(list.isEmpty());

        assertEquals(10, list.remove(0));
        assertTrue(list.isEmpty());
    }
	
	 /**
     * Teste de unidade que verifica o tamanho da lista antes e após inserções 
     * e remoções.
     */
    @Test
    public void testSize() {
        assertEquals(0, list.size());

        list.add(10);
        assertEquals(1, list.size());
        list.add(20);
	assertEquals(2, list.size());
        list.add(30);
        assertEquals(3, list.size());

        list.remove(0);
        assertEquals(2, list.size());

        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
    }
	
	  /**
     * Teste de unidade que verifica se o método iterator está listando os
     * objetos corretamente.
     */
    @Test
    public void testIterator() {
        Iterator it = list.iterator();
        assertFalse(it.hasNext());

        list.add(10);
        list.add(20);
        list.add(30);
        it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(data1, it.next());
        assertTrue(it.hasNext());
        assertEquals(data2, it.next());
        assertTrue(it.hasNext());
        assertEquals(data3, it.next());
        assertFalse(it.hasNext());
    }
	
	@Test
	public void testEmpty() {
		assertTrue(list.isEmpty());
		this.list.add(10);
		assertFalse(list.isEmpty());
		this.list.remove(0);
		assertTrue(list.isEmpty());
	}
	/**
	* Teste de unidade que verifica se a lista está ordenada, conforme as prioridades de modo decrescente
	*/
	public void testOrder(){
		list.add(1);
		list.add(2);
		assertEquals(2,list.get(0));
		assertEquals(2,list.size());
		list.add(5);
		assertEquals(3,list.size());
		assertEquals(5,list.get(0));
		assertEquals(4,list.size());
		list.add(5);
		list.add(3);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		assertEquals(9,list.size());
		assertEquals(5,list.get(0));
		assertEquals(5,list.get(1));
		assertEquals(4,list.get(2));
		assertEquals(3,list.get(3));
		assertEquals(3,list.get(4));
		assertEquals(2,list.get(5));
		assertEquals(2,list.get(6));
		assertEquals(1,list.get(7));
		assertEquals(1,list.get(8));
	}
}
