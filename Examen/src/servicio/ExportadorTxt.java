package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador{
	
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		try {
			File carpeta = new File("src/CarpetaExportador");
			File archivo = new File("src/CarpetaExportador/"+fileName+".txt");
			
			
			if(carpeta.exists()==false) {
				carpeta.mkdir();
				System.out.println("La carpeta se creo existosamente");
			}else {
				System.out.println("La carpeta ya existe");
			}
			archivo.createNewFile();	
			
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Cliente cliente: listaClientes) {
				String categoria;
				bw.write(cliente.getRunCliente()+" ");
				bw.write(cliente.getNombreCliente()+" ");
				bw.write(cliente.getApellidoCliente()+" ");
				bw.write(cliente.getAniosCliente()+" ");
				categoria=String.valueOf(cliente.getNombreCategoria());
				if(categoria.equalsIgnoreCase("Activo")) {
					bw.write("Activo\n");
				}else {
					bw.write("Inactivo\n");
				}
			}
			System.out.println("Datos exportados correctamente en archivo .txt");
			bw.close();
			
		}catch(IOException e){
			System.out.println("No fue posible realizar la accion");
		}
		
	}
}
