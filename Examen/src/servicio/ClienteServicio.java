package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {
	
	List<Cliente> listaClientes;
	Cliente cliente;
	

	public ClienteServicio() {
		super();
		listaClientes= new ArrayList<Cliente>();
	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	public ArrayList<Cliente> getListaClientes() {
		return (ArrayList<Cliente>) listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void agregarCliente(String rut,String nombre,String apellido,String anios) {
		Cliente cliente= new Cliente(rut,nombre,apellido,anios,CategoriaEnum.ACTIVO);
		listaClientes.add(cliente);
	}
	
	public void retornoListarClientes() {
		for (Cliente cliente : listaClientes) {
			System.out.println("------Datos del Cliente------");
			System.out.println("R.U.T:\t\t\t"+cliente.getRunCliente());
			System.out.println("Nombre:\t\t\t"+cliente.getNombreCliente());
			System.out.println("Apellido:\t\t"+cliente.getApellidoCliente());
			System.out.println("Años como Cliente:\t"+cliente.getAniosCliente());
			System.out.println("Categoria del Cliente:\t"+cliente.getNombreCategoria());
			System.out.println("----------------------------");
		}
	}
	
	public Cliente editarCliente(String busquedaRut, int opcionE,String edicion) {
		Cliente cliente=null;
		for (int i = 0; i < listaClientes.size(); i++) {
			if (busquedaRut.equals(listaClientes.get(i).getRunCliente())) {
				
				
				cliente= new Cliente(listaClientes.get(i).getRunCliente(),listaClientes.get(i).getNombreCliente(),
						listaClientes.get(i).getApellidoCliente(),listaClientes.get(i).getAniosCliente(),listaClientes.get(i).getNombreCategoria());
				if(opcionE==1) {
					listaClientes.get(i).setNombreCategoria(CategoriaEnum.INACTIVO);
				
				}
				if(opcionE==2) {
					listaClientes.get(i).setNombreCategoria(CategoriaEnum.ACTIVO);
				
				}
				if(opcionE==3) {
					listaClientes.get(i).setRunCliente(edicion);
					System.out.println("Cambio de rut");
				
				}
				if(opcionE==4) {
					listaClientes.get(i).setNombreCliente(edicion);
				
				}
				if(opcionE==5) {
					listaClientes.get(i).setApellidoCliente(edicion);
				
				}
				if(opcionE==6) {
					listaClientes.get(i).setAniosCliente(edicion);
				
				}
				
				return cliente;
				
				
				
		
			}
		}
	
		return cliente;
	}

}
