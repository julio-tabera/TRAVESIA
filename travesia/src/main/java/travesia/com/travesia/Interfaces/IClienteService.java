package travesia.com.travesia.Interfaces;
import travesia.com.travesia.Entidades.Clientes;

import java.util.List;



// INTERFACE QUE DEFINE LOS METODOS QUE NECESITAMOS
public interface IClienteService {
    
    public List<Clientes> ListarTodos();

    public void Insertar(Clientes cliente);
	
	public Clientes BuscarxID(int id);
	
    public void EliminarxID(int id);

    public void Editar(Clientes cliente, int id );

    public List<Clientes> Buscar_Clientes(String nombre);



    


}
