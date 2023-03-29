package travesia.com.travesia.Clases;

import java.util.ArrayList;
import java.util.List;



//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import travesia.com.travesia.Entidades.Clientes;
import travesia.com.travesia.Interfaces.IClienteService;
import travesia.com.travesia.Repositorios.ClientesRepository;

@Service
public class IClienteImplement_IService implements IClienteService {

    @Autowired
    private ClientesRepository clientesrepository;

     /**
      Metodo finAll() [Con Paginacion y Ordenado] - PagingAndSortingRepository
      (te brinda el ordenamiento y la paginacion) 
       por defecto viene ordenado de forma ASC si querems ordenarlo de manera DESC
       tenemos que poner 
       Sort.by("nombre").descending()
      */  

      @Override
      public List<Clientes> ListarTodos() {
          Page<Clientes> pagina = clientesrepository.findAll(PageRequest.of(0, 10, Sort.by("nombre") ));
         
          return (List<Clientes>) pagina.getContent();
      
        }
  

    @Override
    public void Insertar(Clientes cliente) {
       
        clientesrepository.save(cliente);
        
    }

    @Override
    public Clientes BuscarxID(int id) {
    return clientesrepository.findById(id).orElse(null);
    }

    @Override
    public void EliminarxID(int id) {
    clientesrepository.deleteById(id);
    }


    @Override
    public void Editar(Clientes cliente, int id) {
        Clientes editarcliente = clientesrepository.findById(id).orElse(null);

        editarcliente.setNombre(cliente.getNombre());
        editarcliente.setApellidos(cliente.getApellidos());
        editarcliente.setMovil(cliente.getMovil());
        clientesrepository.save(editarcliente);
    }


    @Override
    public List<Clientes> Buscar_Clientes(String patron) {
        List <Clientes> clientesbuscados = new ArrayList<>();

           // EXPRESION LAMBDA PARA SABER SI UNA CADENA ES UN NUMERO
         if(!patron.chars().allMatch(Character::isDigit)){

             clientesbuscados = clientesrepository.BuscarClientesXNombre(patron);
             
         }else{

            var patronconv = Integer.parseInt(patron);

            clientesbuscados = clientesrepository.BuscarClientesXMovil(patronconv);

         }
        
        return clientesbuscados;
       
    }


    // ================================OPERACIONES CRUD CON SQL===========================================================

    // @Override
    // public Clientes BuscarxID(int id) throws SQLException {

    //     Clientes cliente = new Clientes();
    //     Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
    //             "");

    //     try (Statement mistatement = miconexion.createStatement()) {
    //         String consulta = "SELECT * FROM clientes WHERE clientes.id = " + id;
    //         ResultSet result = mistatement.executeQuery(consulta);

    //         if (result.next()) {

    //             cliente = new Clientes(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
    //             return cliente;
    //             // System.out.println(cliente);

    //         }

    //     } catch (Exception e) {

    //         System.out.println("Error de conexion ");
    //         return cliente;

    //     }

    //     return cliente;

    // }

    // @Override
    // public void EliminarxID(int id) throws SQLException {

    //     Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
    //             "");

    //     try (Statement mistatement = miconexion.createStatement()) {
    //         String consulta = "DELETE FROM clientes WHERE clientes.id = " + id;
    //         mistatement.executeUpdate(consulta);
    //         System.out.println("Se elimino el cliente");
    //     } catch (Exception e) {

    //         System.out.println("Error de conexion ");

    //     }

    // }

    // @Override
    // public void Insertar(Clientes cliente) throws ClassNotFoundException {

    //     try {

    //         Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias",
    //                 "root", "");
    //         Statement mistatement = miconexion.createStatement();

    //         cliente.setId(UltimoId() + 1);

    //         String consulta = "INSERT INTO clientes (id, nombre, apellidos, movil) VALUES (' " + cliente.getId()
    //                 + " ', ' " + cliente.getNombre() + "', '" + cliente.getApellidos() + " ', '" + cliente.getMovil()
    //                 + " ')";
    //         mistatement.executeUpdate(consulta);

    //         System.out.println("Los datos se insertaron");

    //     } catch (Exception e) {

    //         System.out.println("Error de conexion");
    //     }

    // }

   

//    @Override
//     public void Editar(Clientes cliente, int id) throws SQLException {

//         Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
//                 "");

//         try (Statement mistatement = miconexion.createStatement()) {
//             String consulta = "UPDATE clientes SET clientes.nombre =  ' " +  cliente.getNombre() + "', clientes.apellidos = ' " + cliente.getApellidos()
//                     + "' , clientes.movil = '" + cliente.getMovil() + "'  WHERE clientes.id = ' " + id + " '  ";
//             mistatement.executeUpdate(consulta);
//             System.out.println("Se edito el cliente");
//         } catch (Exception e) {

//             System.out.println("Error de conexion ");

//         }

//     }

  
//    // ======== INCREMENTAR ID CON SQL ==========================
//     public static int UltimoId() throws SQLException {
//         int id = 2;
//         Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
//                 "");

//         try (Statement mistatement = miconexion.createStatement()) {
//             String consulta = "SELECT MAX(id) AS id FROM clientes ";
//             ResultSet result = mistatement.executeQuery(consulta);

//             while (result.next()) {

//                 id = result.getInt(1);
//                 return id;
//             }

//         } catch (Exception e) {

//             System.out.println("Error de conexion");
//             return id;
//         }
//         return id;

//     }

   // ========================================= FIN ===========================================================

    

}
