package servicio;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio {
	private ClienteServicio clienteServicio = new ClienteServicio();

	public ArchivoServicio() {
		super();
	}

	public ArchivoServicio(ClienteServicio clienteServicio) {
		super();
		this.clienteServicio = clienteServicio;
	}

	public ClienteServicio getClienteServicio() {
		return clienteServicio;
	}

	public void setClienteServicio(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArchivoServicio [clienteServicio=");
		builder.append(clienteServicio);
		builder.append("]");
		return builder.toString();
	}

	void exportar(String archivo, List<Cliente> listaCliente) {
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println();
		System.out.println("Ingrese una opcion para exportar:");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("---------Exportar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Datos de clientes exportados correctamente en formato txt.");
	}

	public void cargarDatos(String ruta,ArrayList<Cliente>listaClientes,int opcion) {

		String archivoC="/Clientes";
		File archivo=null;
		
		File directorio = new File("src/"+ruta);
		archivo = new File("src/"+ruta+archivoC+".csv");
		//if (opcion==1) {
		//	 archivo = new File("src/"+ruta+archivoC+".csv");
		//}
		//if (opcion==2) {
		//	 archivo = new File("src/"+ruta+archivoC+".txt");
		//}
		
		if(directorio.exists()) {
			try(BufferedReader br= new BufferedReader(new FileReader(archivo)))
			{
				String contenido="";
				
				while ((contenido=br.readLine())!=null) {
					String [] arrayClientes=contenido.split(",");
					String run=arrayClientes[0];
					String nombre=arrayClientes[1];
					String apellido=arrayClientes[2];
					String anios=arrayClientes[3];
					String categoria=arrayClientes[4];
					if(categoria.equalsIgnoreCase("ACTIVO")) {
					Cliente	cliente= new Cliente(run,nombre,apellido,anios,CategoriaEnum.ACTIVO);
					listaClientes.add(cliente);
					}
					else {
						Cliente	cliente= new Cliente(run,nombre,apellido,anios,CategoriaEnum.INACTIVO);
						listaClientes.add(cliente);
					}
					
					
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
}
}
