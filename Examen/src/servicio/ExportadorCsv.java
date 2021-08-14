package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaCliente) {
		
		String ruta = "";
		int largoStr;

		
		String[] datosImport = fileName.split("Clientes");
		ruta = datosImport[0];
		largoStr = ruta.length();
		ruta = ruta.substring(0, largoStr - 1);

		
		try {
			File carpeta = new File(ruta);
			File archivo = new File(fileName);
			
			if (carpeta.exists() == false) {
				
				carpeta.mkdir();
				
				archivo.createNewFile();
				
				llenarArchivo( fileName, listaCliente);
			} else {
				
				if (archivo.exists() == false) {
					
					archivo.createNewFile();
					
					llenarArchivo( fileName, listaCliente);
				} else {
				
					archivo.delete();
					
					archivo.createNewFile();
					
					llenarArchivo( fileName, listaCliente);
				}
			}
		} catch (IOException e) {
			System.out.println("\nNo se pudo crear directorio.");
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Datos de clientes exportados correctamente en formato csv.");

	}

	
	public void llenarArchivo( String fileName, List<Cliente> listaCliente) {
		String estado = "";
		
		try {
			
			File documento = new File(fileName);
			
			FileWriter fw = new FileWriter(documento);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (Cliente cli : listaCliente) {
				
				cli.getRunCliente();
				cli.getNombreCliente();
				cli.getApellidoCliente();
				cli.getAniosCliente();
				cli.getNombreCategoria();
			
				if (String.valueOf(cli.getNombreCategoria()).equalsIgnoreCase("activo")) {
					estado = "Activo";
				} else {
					estado = "Inactivo";
				}
				
				bw.write(cli.getRunCliente() + "," + cli.getNombreCliente() + "," + cli.getApellidoCliente() + ","
						+ cli.getAniosCliente() + "," + estado);
				bw.newLine();
			}
		
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

