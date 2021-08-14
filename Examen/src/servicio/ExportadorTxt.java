package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorTxt extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaCliente) {
		// Variables para trabajar la ruta del archivo
		String ruta = "";
		int largoStr;

		// Obtiene ruta proveniente del parametro fileName
		String[] datosImport = fileName.split("Clientes");
		ruta = datosImport[0];
		largoStr = ruta.length();
		ruta = ruta.substring(0, largoStr - 1);

		// Crea excepcion para la creacion del directorio y archivo
		try {
			File carpeta = new File(ruta);
			File archivo = new File(fileName);
			// Valida si existe la ruta
			if (carpeta.exists() == false) {
				// Si la ruta no existe entonces
				// Crea el directorio
				carpeta.mkdir();
				// Crea el archivo
				archivo.createNewFile();
				// Invoca metodo auxiliar para guardar datos en el archivo
				llenarArchivo(ruta, fileName, listaCliente);
			} else {
				// Si la ruta existe entonces
				// Valida si existe el archivo
				if (archivo.exists() == false) {
					// Si el archivo no existe entonces
					// Crea el archivo
					archivo.createNewFile();
					// Invoca metodo auxiliar para guardar datos en el archivo
					llenarArchivo(ruta, fileName, listaCliente);
				} else {
					// Si el archivo existe entonces
					// Elimina el archivo
					archivo.delete();
					// Crea el archivo
					archivo.createNewFile();
					// Invoca metodo auxiliar para guardar datos en el archivo
					llenarArchivo(ruta, fileName, listaCliente);
				}
			}
		} catch (IOException e) {
			System.out.println("\nNo se pudo crear directorio.");
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Datos de clientes exportados correctamente en formato txt.");

	}

	// Metodo auxiliar que permite guardar datos en el archivo
	public void llenarArchivo(String carpeta, String fileName, List<Cliente> listaCliente) {
		// Crea excepcion para lectura de la lista de productos
		try {
			// Obtiene datos de ubicacion y nombre del archivo
			File documento = new File(fileName);
			// Inicializa escritura del archivo
			FileWriter fw = new FileWriter(documento);
			BufferedWriter bw = new BufferedWriter(fw);
			// Por cada cliente que contenga la lista, inserta una linea en el archivo
			listaCliente.stream().forEach(
				(cliente) -> {
					try {
						bw.write("-------------Datos del Cliente-------------");
						bw.newLine();
						bw.write("RUN del Cliente: " + cliente.getRunCliente());
						bw.newLine();
						bw.write("Nombre del Cliente: " + cliente.getNombreCliente());
						bw.newLine();
						bw.write("Apellido del Cliente: " + cliente.getApellidoCliente());
						bw.newLine();
						bw.write("A�os como Cliente: " + cliente.getAniosCliente());
						bw.newLine();
						String estado = "";
						if (cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
							estado = "Activo";
						} else {
							estado = "Inactivo";
						}
						bw.write("Categor�a del Cliente: " + estado);
						bw.newLine();
						bw.write("-------------------------------------------");
						bw.newLine();
						bw.newLine();
					} catch (IOException e) {
						System.out.println("\nEl archivo no existe.");
						System.out.println(e.getMessage());
					} catch (RuntimeException e) {
						System.out.println("\nLista fuera de rango.");
						System.out.println(e.getMessage());
					}
				}
				);
			// guarda datos en el archivo al cerrarlo
			bw.close();
		} catch (IOException e) {
			System.out.println("\nEl archivo no existe.");
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("\nLista fuera de rango.");
			System.out.println(e.getMessage());
		}
	}
}
