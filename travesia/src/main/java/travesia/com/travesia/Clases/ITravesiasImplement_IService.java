package travesia.com.travesia.Clases;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import travesia.com.travesia.Entidades.Travesias;
import travesia.com.travesia.Interfaces.ITravesiasService;
import travesia.com.travesia.Repositorios.TravesiasRepository;

@Service
public class ITravesiasImplement_IService implements ITravesiasService {

     @Autowired
     private TravesiasRepository travesiarepository;


     @Override
     public List<Travesias> ListarTravesias() {

        Page<Travesias> page = travesiarepository.findAll(PageRequest.of(0, 10, Sort.by("nombre")));
       
         return (List<Travesias>) page.getContent() ;
     }

   
    @Override
    public void Insertar(Travesias travesia) {
       travesiarepository.save(travesia);
        
    }


    @Override
    public void EliminarxID(int id) {

        travesiarepository.deleteById(id);
       
    }


    @Override
    public void Editar(Travesias travesia, int id) {
        Travesias editartravesia = travesiarepository.findById(id).orElse(null);

        editartravesia.setNombre(travesia.getNombre());
        editartravesia.setRecorrido(travesia.getRecorrido());
        // editarcliente.setMovil(cliente.getMovil());
        // clientesrepository.save(editarcliente);
    }

   
    
}
