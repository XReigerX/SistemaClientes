package servicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio {
	ClienteServicio clienteServicio = new ClienteServicio();

	String [] arrDatos;


	public void cargarDatos(String ruta,List <Cliente> listaCliente) {

		try {

			File fichero = new File(ruta);
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			String dato;
			linea=br.readLine();
			while(linea!=null){
				Cliente cliente = new Cliente();
				arrDatos=linea.split(",");
				for(int i=0; i<arrDatos.length; i++) {
					dato=arrDatos[i];
					switch(i) {
					case 0:
						cliente.setRunCliente(dato);
						break;
					case 1:
						cliente.setNombreCliente(dato);
						break;
					case 2:
						cliente.setApellidoCliente(dato);
						break;
					case 3:
						cliente.setAniosCliente(dato);
						break;
					case 4:
						if(dato.equalsIgnoreCase("Activo")) {
							cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
						}else
						{
							cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
						}
						

					}
				}

				listaCliente.add(cliente);
				linea=br.readLine();
			}
			
			System.out.println("Archivo cargado con exito");
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

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
