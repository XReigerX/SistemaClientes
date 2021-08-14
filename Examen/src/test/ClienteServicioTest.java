package test;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {

	@Test
	public void agregarClienteTest() {
		System.out.println("Test agregarClienteTest():");
		Cliente clientePrueba = new Cliente("18.248.335-3", "Arturo", "Vidal", "1",CategoriaEnum.ACTIVO);
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		listaCliente.add(clientePrueba);
		ClienteServicio clienteServicio = new ClienteServicio(listaCliente);
		clienteServicio.agregarCliente("18.248.335-3", "Arturo", "Vidal", "1");
		Assert.assertEquals(listaCliente, clienteServicio.getListaClientes());
		System.out.println();
	}
	
	@Test
	public void agrearClienteNullTest() {
		System.out.println("Test agrearClienteNullTest():");
		Cliente clientePrueba = new Cliente(null, null, null, null,null);
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		listaCliente.add(clientePrueba);
		ClienteServicio clienteServicio = new ClienteServicio(listaCliente);
		assertNull(clientePrueba.getRunCliente());
		assertNull(clientePrueba.getNombreCliente());
		assertNull(clientePrueba.getApellidoCliente());
		assertNull(clientePrueba.getAniosCliente());
		clienteServicio.agregarCliente(null, null, null, null);
		Assert.assertEquals(listaCliente, clienteServicio.getListaClientes());
		System.out.println();
	}
	
	@Test
	public void test() {
	
	}
}
