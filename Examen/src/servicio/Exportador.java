package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Exportador {
	public abstract void exportar(String nombreArchivo,List<Cliente> listaClientes);

}
