package vista;

import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu implements AccionesMenu {

	Scanner leer = new Scanner(System.in);
	private int opcion, opcionE;
	private ClienteServicio clienteS = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportarCsv = new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	private final String archivo = "Clientes";
	Cliente cliente;

	public Menu() {
		while (opcion != 6) {
			System.out.println("1.- Listar Clientes");
			System.out.println("2.- Agregar Cliente");
			System.out.println("3.- Editar Cliente");
			System.out.println("4.- Cargar Datos");
			System.out.println("5.- Exportar Datos");
			System.out.println("6.- Salir");
			System.out.println("Ingrese una opcion: ");
			opcion = Integer.parseInt(leer.nextLine().trim());
			switch (opcion) {
			case 1:
				listarClientes();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente();
				break;
			case 4:
				String ruta;
				System.out.println("Importacion de datos");
				System.out.println("Ingrese la ruta");
				ruta=leer.nextLine();
				importarDatos(ruta,clienteS.getListaClientes());
				break;
			case 5:
				System.out.println("Exportacion de datos");
				System.out.println("Elija el formato a exportar");
				System.out.println("1.-Formato csv\n"
							  	 + "2.-Formato txt");
				opcion= Integer.parseInt(leer.nextLine());
				
				switch(opcion) {
					case 1:
						exportarDatosCsv();
						break;
					case 2:
						exportarDatosTxt();
						break;
					default:
						System.out.println("La opcion ingresada no es valida");
				}

				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("La opcion ingresada no es valida");
			}
		}

	}

	@Override
	public void listarClientes() {
		clienteS.retornoListarClientes();

	}

	@Override
	public void agregarCliente() {
		Cliente cliente = new Cliente();

		System.out.println("------Crear Cliente------");

		System.out.println("Ingresa RUN del Cliente: ");
		cliente.setRunCliente(leer.nextLine());
		System.out.println("Ingresa Nombre del Cliente: ");
		cliente.setNombreCliente(leer.nextLine());
		System.out.println("Ingresa Apellido del Cliente: ");
		cliente.setApellidoCliente(leer.nextLine());
		System.out.println("Ingresa años como Cliente: ");
		cliente.setAniosCliente(leer.nextLine());
		System.out.println("-------------------------");
		clienteS.agregarCliente(cliente);

	}

	@Override
	public void editarCliente() {
		System.out.println("------Editar Cliente------");
		System.out.println("Seleccione que desae hacer:");
		System.out.println("1.- Cambiar el estado del Cliente");
		System.out.println("2.- Editar los datos ingresados del Cliente");
		System.out.println("Ingrese Opcion:");
		opcion = Integer.parseInt(leer.nextLine().trim());
		switch (opcion) {

		case 1:

			System.out.println("Ingrese RUN del Cliente a editar:");
			cliente = clienteS.editarCliente(leer.nextLine(), 0, null);

			System.out.println("----Actualizando el estado del Cliente----");
			System.out.println("El estado actual del Cliente es: " + cliente.getNombreCategoria().toString());
			System.out.println("1.-Si desea cambiar el estado del Cliente Inactivo");
			System.out.println("2.-Si desea mantener el estado del Cliente Activo");
			System.out.println("Ingrese opcion: ");
			opcionE = Integer.parseInt(leer.nextLine().trim());
			clienteS.editarCliente(cliente.getRunCliente(), opcionE, null);
			break;

		case 2:
			System.out.println("Ingrese RUN del Cliente a editar:");
			cliente = clienteS.editarCliente(leer.nextLine(), 0, null);

			System.out.println("----Actualizando estado del Cliente----");
			System.out.println("1.-El Run del Cliente es: " + cliente.getRunCliente());
			System.out.println("2.-El Nombre del Cliente es: " + cliente.getNombreCliente());
			System.out.println("3.-El Apellido del Cliente es: " + cliente.getApellidoCliente());
			System.out.println("4.-Los años como Cliente son: " + cliente.getAniosCliente());
			System.out.println("\nIngrese opcion a editar de los datos del Cliente: ");
			System.out.println("----------------------------------------------------");
			opcionE = Integer.parseInt(leer.nextLine().trim());
			if (opcionE == 1) {
				opcionE = 3;
				System.out.println("Ingrese el nuevo RUN del Cliente: ");
				String edicion = leer.nextLine();
				clienteS.editarCliente(cliente.getRunCliente(), opcionE, edicion);
				System.out.println("----------------------------------");
				System.out.println("Datos cambiados con exito");
				break;
			}
			if (opcionE == 2) {
				opcionE = 4;
				System.out.println("Ingrese el nuevo nombre del Cliente: ");
				String edicion = leer.nextLine();
				clienteS.editarCliente(cliente.getRunCliente(), opcionE, edicion);
				System.out.println("----------------------------------");
				System.out.println("Datos cambiados con exito");
				opcionE = 0;
			}
			if (opcionE == 3) {
				opcionE = 5;
				System.out.println("Ingrese el nuevo Apellido del Cliente: ");
				String edicion = leer.nextLine();
				clienteS.editarCliente(cliente.getRunCliente(), opcionE, edicion);
				System.out.println("----------------------------------");
				System.out.println("Datos cambiados con exito");
			}
			if (opcionE == 4) {
				opcionE = 6;
				System.out.println("Ingrese el nuevo años como Cliente: ");
				String edicion = leer.nextLine();
				clienteS.editarCliente(cliente.getRunCliente(), opcionE, edicion);
				System.out.println("----------------------------------");
				System.out.println("Datos cambiados con exito");
			}

		}

	}

	public void importarDatos(String ruta, List<Cliente> listaCliente) {
		archivoServicio.cargarDatos(ruta, listaCliente);
	}

	public void exportarDatosCsv() {
		exportarCsv.exportar(archivo, clienteS.getListaClientes());
	}

	public void exportarDatosTxt() {
		exportarTxt.exportar(archivo, clienteS.getListaClientes());
	}

	public void terminarPrograma() {
		Utilidad uti = new Utilidad();
		uti.limpiandoPantalla();
	}

}
