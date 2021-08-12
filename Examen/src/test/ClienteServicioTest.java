package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {

	@Test
	public void agregarClienteTest() {
		
		
		ClienteServicio clienteServicio = new ClienteServicio();
		Cliente agregarClienteRes = clienteServicio.agregarCliente(Cliente cliente);
		assertEquals("Cliente agregado correctamente", agregarClienteRes);
	}
	
	@Test
	public void agregarClienteNullTest() {
		
		ClienteServicio clienteServicio = new ClienteServicio();
		Cliente agregarClienteRes = clienteServicio.agregarCliente(Cliente null);
		assertEquals("Cliente agregado correctamente", agregarClienteRes);
	}
	
	@Test
	public void test() {
	
	}
}
