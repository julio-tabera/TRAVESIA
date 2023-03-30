package travesia.com.travesia.Interfaces;
import travesia.com.travesia.Entidades.Travesias;
import java.util.List;

// INTERFACE QUE DEFINE LOS METODOS QUE NECESITAMOS
public interface ITravesiasService {
    
    public List<Travesias> ListarTravesias();

    public void Insertar(Travesias travesia);

    public void EliminarxID(int id);

    public void Editar(Travesias travesia, int id );

    public Travesias BuscarxID(int id);


	
	
    


}
