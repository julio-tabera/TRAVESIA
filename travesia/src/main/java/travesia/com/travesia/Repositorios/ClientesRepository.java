package travesia.com.travesia.Repositorios;
import travesia.com.travesia.Entidades.Clientes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




//public interface ClientesRepository extends CrudRepository<Clientes, Integer>  {

               // CrudRepository: 
    /*Interfaz que extiende de la interfaz Repository y proporciona los metodos
    para las opraciones CRUD */

           // PagingAndSortingRepository
      /*Interfaz que extiende de la interfaz CrudRepository y agrega metodos
    adicionales para las Paginacion y Ordenmiento */

      // JpaRepository
      /*Interfaz que extiende de la interfaz PagingAndSortingRepository y agrega 
    funcionalidades especficas para la tecnologia Jpa */

    // Entoces nuestros Repositorios extendern directamente de JpaRepository

public interface ClientesRepository extends JpaRepository<Clientes, Integer>  {
    
  // ====== PARA DEFINIR UNA CONSULTA ESPECIFICA EN JPA, SE LLAMA JPQL
  @Query(value="SELECT * FROM Clientes c WHERE c.nombre LIKE %:nombre% or c.apellidos LIKE %:nombre%",
   nativeQuery=true)
   List<Clientes> BuscarClientesXNombre(String nombre);

   @Query(value="SELECT * FROM Clientes c WHERE c.movil LIKE %:movil%"  , nativeQuery=true)
   List<Clientes> BuscarClientesXMovil(int movil);;
           
}
