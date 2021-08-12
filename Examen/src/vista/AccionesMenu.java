package vista;

import java.util.List;

import modelo.Cliente;

public interface AccionesMenu {
	
	void listarClientes();

	void agregarCliente();

	void editarCliente();

	void importarDatos(String ruta,List<Cliente> listaCliente);

	void exportarDatosCsv();
	void exportarDatosTxt();

	void terminarPrograma();

}
