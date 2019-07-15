package br.uefs.ecomp.isnotpaxbahia.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.uefs.ecomp.isnotpaxbahia.model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;
import br.uefs.ecomp.isnotpaxbahia.model.Exame;
import br.uefs.ecomp.isnotpaxbahia.model.Consulta;
import br.uefs.ecomp.isnotpaxbahia.util.LinkedList;
import br.uefs.ecomp.isnotpaxbahia.util.PriorityQueue;

import java.util.Calendar;
import java.util.Date; 



public class TestClinica{

	
	@Before
	public void setUp() throws Exception {
	cli = new Clinica();
	
	p1 = new Paciente("Ronaldinho", "M", "Rua Barcelona", "8390102002", "01/02/1987");
	p2 = new Paciente("Tod Guten", "M","Rua do Hittler","1194663520","12/06/1990");
	p3 = new Paciente("Karla Perez" , "F", "Avenida do Alfabeto","7191234567", "03/03/1977");

	c1 = new Consulta();
	}

    
    /**
     * Teste de unidade que verifica a inserção de pacientes no cadastro da clínica.
     */
    @Test
    public void testAddCliente() {
        cli.getPacientes().add(p1);
        cli.getPacientes().add(p2);
        cli.getPacientes().add(p3);
        assertEquals(sys.getPacientes().size(),3);
        
        assertEquals(p1, sys.getPacientes().get(0));
        assertEquals(p2, sys.getPacientes().get(1));
        assertEquals(p3, sys.getPacientes().get(2));

    }

    /**
     * Teste de unidade que verifica verifica se é possível buscar pacientes
     */
    @Test
    public void testSearchClientes(){
        sys.getPacientes().add(c1);	//c1=ronaldinho = new Paciente("Ronaldinho", "M", "Rua Barcelona", "8390102002", "01/02/1987");
        sys.getPacientes().add(c2);	//c2=tod guten = new Paciente("Tod Guten", "M","Rua do Hittler","1194663520","12/06/1990");
        sys.getPacientes().add(c3);	//c3=Karla perez = new Paciente("Karla Perez" , "F", "Avenida do Alfabeto","7191234567", "03/03/1977");

	Paciente p_nome = cli.getPacientes().searchPacientebyName("Tod");        
	//assertTrue(cli.getPacientes().get(0),false);
	assertEquals(p_nome,cli.getPacientes().get(1);
	//assertTrue(cli.getPacientes(2),false);

	Paciente p_sexo = cli.getPacientes().searchPacientesbySex("M");
	assertEquals(p_sexo,cli.getPacientes.get(0));
	assertEquals(p_sexo,cli.getPacientes.get(1));
	//assertEquals(cli.getPacientes.get(2),false);	
	
	Paciente p_endereco = cli.getPacientes().searchPacientesbyAddress("Rua");
	assertEquals(p_endereco,cli.getPacientes.get(0));
	assertEquals(p_endereco,cli.getPacientes.get(1));

	Paciente p_telefone = cli.getPacientes().searchPacientesbyPhone("71");
	assertEquals(p_telefone,cli.getPacientes.get(2));	

	Iterator it = sys.getPacientes().searchPacientebyName("Fulano");
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());
        assertFalse(it.hasNext());

        it = sys.getPacientes().searchPacientebyPhone("000-9090-0000");
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());
        assertFalse(it.hasNext());

        it = sys.getPacientes().searchPacientebyName("l");
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());

        assertTrue(it.hasNext());
        assertEquals(c2, it.next());

        assertFalse(it.hasNext());
        assertNull(it.next());

        it = sys.getPacientes().searchPacientebyPhone("000-9080-0000");
        assertTrue(it.hasNext());
        assertEquals(c2, it.next());
        assertTrue(it.hasNext());
        assertEquals(c3, it.next());

        assertFalse(it.hasNext());
        assertNull(it.next());

    }
}