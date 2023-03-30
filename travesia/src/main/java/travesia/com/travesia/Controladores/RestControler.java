package travesia.com.travesia.Controladores;


import java.util.List;
import org.springframework.web.bind.annotation.RestController;

//import travesia.com.travesia.Clases.Carros;
import travesia.com.travesia.Entidades.Clientes;
import travesia.com.travesia.Entidades.Travesias;
import travesia.com.travesia.Interfaces.IClienteService;
import travesia.com.travesia.Interfaces.ITravesiasService;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@RestController
@RequestMapping(value = "travesia")
public class RestControler {

  
   @Autowired
    private IClienteService clienteservice;

    @Autowired
    private ITravesiasService traveciaservice;


  
    @RequestMapping(value = "usuarios")

    public List<Clientes> listado() {
        List<Clientes> misclientes = clienteservice.ListarTodos();
        return misclientes;
    }

    @RequestMapping(value = "buscar_usuarios")

    public List<Clientes> listado_obtener() {
        List<Clientes> misclientes = clienteservice.ListarTodos();
        return misclientes;
    }

    @RequestMapping(value = "eliminar_clientes/{id}", method = RequestMethod.DELETE)
    public int Eliminar_Clientes(@PathVariable int id) {

     clienteservice.EliminarxID(id);
      return id;
    }

    @PostMapping("/editar_clientes/{id}")
    public void Editar_Clientes(@ModelAttribute Clientes editarcliente, @PathVariable int id  ) {
    clienteservice.Editar(editarcliente, id);
  
  }

   @RequestMapping (value="buscar_clientes/{patron}")
   public List<Clientes>Buscar_all_Clientes(@PathVariable String patron) {
    
    List<Clientes> misclientes_buscados = clienteservice.Buscar_Clientes(patron);
       
    return misclientes_buscados;
   }


    //======================================== TRABAJO CON LAS TRAVESIAS =======================

    @RequestMapping(value = "travesias")

    public List<Travesias> listado_travesias() {

        List<Travesias> mistravesias = traveciaservice.ListarTravesias();

        return mistravesias;

    }

    @RequestMapping(value = "eliminar_travesia/{id}", method = RequestMethod.DELETE)
    public int Eliminar_Travesias(@PathVariable int id){
   
        traveciaservice.EliminarxID(id);
        return id;
    }

    @PostMapping (value = "editar_travesia/{id}")
    public void Editar_Travesia(@ModelAttribute Travesias editartravesia, @PathVariable int id  ) {

        traveciaservice.Editar(editartravesia, id);
        
    }

   
    // @RequestMapping(value = "carros")
    // public List<Carros> ListaCarros(){

    // Carros micarro1 = new Carros("NISAN", "NEGRO" );
    // Carros micarro2 = new Carros("TOYOTA", "ROJO" );
    // Carros micarro3 = new Carros("AUDI", "ROSA" );

    // miscarros.add(micarro1);
    // miscarros.add(micarro2);
    // miscarros.add(micarro3);

    // return miscarros;
    // }
}
