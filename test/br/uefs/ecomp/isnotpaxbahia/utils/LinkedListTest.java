package br.uefs.ecomp.isnotpaxbahia.utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import br.uefs.ecomp.isnotpaxbahia.utils.LinkedList;

public class LinkedListTest {
	
	private LinkedList<Integer> list;
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() {
    	this.list = new LinkedList<Integer>();
    }

	@Test
	public void testAdd() {
		this.list.add(1);
		this.list.add(2);
		this.list.add(3);
		assertEquals(1,list.get(0).intValue());
		assertEquals(2,list.get(1).intValue());
		assertEquals(3,list.get(2).intValue());
	}
	
	
	@Test
    public void testRemove(){
        assertNull(this.list.remove(0));
        assertNull(this.list.remove(1));
        this.list.add(10);
        this.list.add(20);
        this.list.add(30);
        assertEquals(20, this.list.remove(1).intValue());
        assertEquals(30, list.remove(1).intValue());
        assertNull(list.remove(1));
        assertEquals(10, list.remove(0).intValue());
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
        Iterator<Integer> it = list.iterator();
        assertFalse(it.hasNext());
        list.add(10);
        list.add(20);
        list.add(30);
        it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(10, it.next().intValue());
        assertTrue(it.hasNext());
        assertEquals(20, it.next().intValue());
        assertTrue(it.hasNext());
        assertEquals(30, it.next().intValue());
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

}
