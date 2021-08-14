package vista;



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
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportadorTxt = new ExportadorTxt();
	private final String archivo = "Clientes";
	String rutaArchivo;
	Cliente cliente;
	Utilidad uti = new Utilidad();

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
				
				//uti.limpiandoPantalla();
				
				if (!clienteS.getListaClientes().isEmpty()) {
					
					System.out.println("Ya existen clientes en la lista.");
					System.out.println("Los clientes seran agregados a continuacion de los clientes");
					System.out.println("ingresados por el usuario.");
					System.out.println("Ingrese 1 para confirmar:");
					opcion = Integer.parseInt(leer.nextLine().trim());
					if (opcion==1) {
						
						importarDatos();
					}else {
						System.out.println();
						System.out.println("Proceso cargar datos cancelado.");
					}
				}else {
					
					importarDatos();
				}
				System.out.println("Presione Enter para volver al menu principal.");
				leer.nextLine();
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
		//Cliente cliente = new Cliente();

		System.out.println("------Crear Cliente------");

		System.out.println("Ingresa RUN del Cliente: ");
		String rut=leer.nextLine();
		//cliente.setRunCliente(leer.nextLine());
		System.out.println("Ingresa Nombre del Cliente: ");
		String nombre=leer.nextLine();
		//cliente.setNombreCliente(leer.nextLine());
		System.out.println("Ingresa Apellido del Cliente: ");
		String apellido=leer.nextLine();
		//cliente.setApellidoCliente(leer.nextLine());
		System.out.println("Ingresa años como Cliente: ");
		String anios=leer.nextLine();
		//cliente.setAniosCliente(leer.nextLine());
		System.out.println("-------------------------");
		clienteS.agregarCliente(rut,nombre,apellido,anios);

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
	
	
	
	

	

	public void importarDatos() {
		String rutaArchivo = "";
		System.out.println("---------Cargar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo Clientes.csv:");
		rutaArchivo = leer.nextLine().trim();
			
		archivoServicio.setClienteServicio(clienteS);
		
		archivoServicio.cargarDatos(rutaArchivo,clienteS.getListaClientes(),opcion);
	}

	public void exportarDatos() {
		String rutaArchivo = "", opConfirmar = "";
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println();
		System.out.println("Ingrese una opcion para exportar:");
		opConfirmar = leer.nextLine().trim();
		System.out.println("----------------------------------");
		System.out.println();
		
		if (opConfirmar.equals("1")) {
			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			rutaArchivo = leer.nextLine().trim();
			
			rutaArchivo = rutaArchivo + "\\" + archivo + ".csv";
		
			exportadorCsv.exportar(rutaArchivo, clienteS.getListaClientes());
		}else if (opConfirmar.equals("2")) {
			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo Clientes.txt:");
			rutaArchivo = leer.nextLine().trim();
			
			rutaArchivo = rutaArchivo + "\\" + archivo + ".txt";
		
			exportadorTxt.exportar(rutaArchivo, clienteS.getListaClientes());
		}else {
			System.out.println();
			System.out.println("La opcion ingresada no es valida.");
		}
	}
	

	//public void importarDatos(String ruta, List<Cliente> listaCliente) {
		//archivoServicio.cargarDatos(ruta, listaCliente);
	//}

	public void exportarDatosCsv() {
		
		
			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo Clientes.csv:");
			 rutaArchivo = leer.nextLine().trim();	
			rutaArchivo = rutaArchivo + "\\" + archivo + ".csv";
			exportadorCsv.exportar(rutaArchivo, clienteS.getListaClientes());
		
			
	
	}

	public void exportarDatosTxt() {
		
		System.out.println("---------Exportar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
		rutaArchivo = leer.nextLine().trim();
		rutaArchivo = rutaArchivo + "\\" + archivo + ".txt";
		exportadorTxt.exportar(rutaArchivo, clienteS.getListaClientes());
	}

	public void terminarPrograma() {
		
		uti.limpiandoPantalla();
	}

	

}
