package travesia.com.travesia.Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import travesia.com.travesia.Entidades.Clientes;

public class PREBAS {

    
  

    public static void Insertar(Clientes cliente) throws ClassNotFoundException {

        try {

            Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias",
                    "root", "");
            Statement mistatement = miconexion.createStatement();

            cliente.setId(cliente.getId() + 1);

            String consulta = "INSERT INTO clientes (id, nombre, apellidos, movil) VALUES (' " + cliente.getId()
                    + " ', ' " + cliente.getNombre() + "', '" + cliente.getApellidos() + " ', '" + cliente.getMovil()
                    + " ')";
            mistatement.executeUpdate(consulta);

            System.out.println("Los datos se insertaron");

        } catch (Exception e) {

            System.out.println("Error de conexion");
        }

    }

    public static int UltimoId() throws SQLException {
        int id = 2;
        Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
                "");

        try (Statement mistatement = miconexion.createStatement()) {
            String consulta = "SELECT MAX(id) AS id FROM clientes ";
            ResultSet result = mistatement.executeQuery(consulta);

            while (result.next()) {

                id = result.getInt(1);
                // System.out.println(result.getInt(1));
                // System.out.println(id);
                return id;
            }

            // return 1;

        }

        catch (Exception e) {

            System.out.println("Error de conexion");
            return id;
        }
        return id;

    }

    public static Clientes BuscarxID() throws SQLException {

        Clientes cliente = new Clientes();
        Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
                "");

        try (Statement mistatement = miconexion.createStatement()) {
            String consulta = "SELECT * FROM clientes WHERE clientes.id = " + 6;
            ResultSet result = mistatement.executeQuery(consulta);

            if (result.next()) {

                cliente = new Clientes(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
                return cliente;
                // System.out.println(cliente);

            }

        } catch (Exception e) {

            System.out.println("Error de conexion ");
            return cliente;

        }

        return cliente;

    }

    public static void EliminarxID() throws SQLException {
       
        Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
                "");

        try (Statement mistatement = miconexion.createStatement()) {
            String consulta = "DELETE FROM clientes WHERE clientes.id = " + 7;
            mistatement.executeUpdate(consulta);
            System.out.println("Se elimino el cliente");
        } catch (Exception e) {

            System.out.println("Error de conexion ");
          

        }

             
    }

    public static void Editar() throws SQLException {
       
        String nomb ="PEDRO"; 
        String apll ="FERNANDEZ";
        int movil = 56565656;

        Connection miconexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/travesias", "root",
                "");

        try (Statement mistatement = miconexion.createStatement()) {
            String consulta = "UPDATE clientes SET clientes.nombre =  ' "+ nomb + "', clientes.apellidos = ' " + apll + "' , clientes.movil = '" + movil +  "'  WHERE clientes.id = ' " + 6 +" '  ";
            mistatement.executeUpdate(consulta);
            System.out.println("Se edito el cliente");
        } catch (Exception e) {

            System.out.println("Error de conexion ");

          
          

        }
             
    }

     public static void Menor_carro() {


        List<Carros> miscarros = new ArrayList<>();
        miscarros.add(new Carros("LADA", "ROJO", 67));
        miscarros.add(new Carros("FERRARI", "BLANCO",3));
        miscarros.add(new Carros("CHEVROLET", "AZUL", 567));
        // Carros array [] = new Carros [miscarros.size()];
         
        // miscarros.toArray(array);
    
         var menor = miscarros.get(0).getPrecio();
         Carros carro_menor = miscarros.get(0);
       
       
         Iterator <Carros> miterador = miscarros.iterator();
    
         while (miterador.hasNext()) {
           var proximo =  miterador.next();
          if (menor > proximo.getPrecio() ) {
                menor = proximo.getPrecio();
                carro_menor = proximo;  
          }


        
         
        }
         System.out.println(menor + "<br>" + carro_menor);
     //   System.out.println(carro_menor);
      }

     
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
 
 
       
    List<Carros> miscarros = new ArrayList<>();
    miscarros.add(new Carros("LADA", "ROJO", 345));
    miscarros.add(new Carros("FERRARI", "BLANCO", 800));
    miscarros.add(new Carros("CHEVROLET", "AZUL", 567));

        Clientes clientes = new Clientes(UltimoId(), "NUEVO", "NUEVO", 5555555);

        Insertar(clientes);
       BuscarxID();
       EliminarxID();
         UltimoId();
          Editar();
        Menor_carro();

        

       



    }

}
