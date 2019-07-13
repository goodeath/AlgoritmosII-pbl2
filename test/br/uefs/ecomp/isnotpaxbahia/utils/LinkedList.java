package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.delivery.util.IList;
import br.uefs.ecomp.delivery.util.MyLinkedList;
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
	
	@Test
	public void testEmpty() {
		assertTrue(list.isEmpty());
		this.list.add(10);
		assertFalse(list.isEmpty());
		this.list.remove(0);
		assertTrue(list.isEmpty());
	}
}
