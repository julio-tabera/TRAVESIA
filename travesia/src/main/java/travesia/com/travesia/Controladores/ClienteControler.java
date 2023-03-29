package travesia.com.travesia.Controladores;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import travesia.com.travesia.Clases.Carros;
import travesia.com.travesia.Entidades.Clientes;
import travesia.com.travesia.Entidades.Travesias;
import travesia.com.travesia.Interfaces.IClienteService;
import travesia.com.travesia.Interfaces.ITravesiasService;

@Controller
@RequestMapping("/travesia")
public class ClienteControler {

  @Autowired
  private IClienteService clienteservice;
  @Autowired
  private ITravesiasService travesiaservice;

  @RequestMapping("/portada")

  public String portada() {

    return "plantillas/portada";

  }

  // listado de clientes
  @RequestMapping("/listado")

  public String listado() {
    return "clientes/listado_clientes";
  }

  @RequestMapping("/listado-travesia")

  public String listadotravesia() {
    return "clientes/listado_travesias";
  }

  @RequestMapping("/crear_cliente")

  // le mandamos el objeto cliente al formulario de clientes para que lo llene
  public String Crear_Clientes(Model model) {

    Clientes nuevocliente = new Clientes();

    // mandamos una lista de todas las travisias para mostrarlas en el select de
    // travesias
    List<Travesias> travesias = travesiaservice.ListarTravesias();

    model.addAttribute("nuevocliente", nuevocliente);
    model.addAttribute("listravesias", travesias);

    return "clientes/form_clientes";

  }

  @RequestMapping("/crear_cliente_edit/{id}")
  // @ResponseBody
  public String Crear_Clientes_Editar(@PathVariable int id, Model model) throws SQLException {

    Clientes editarcliente = clienteservice.BuscarxID(id);
    model.addAttribute("editarcliente", editarcliente);
    return "clientes/form_clientes_edit";

  }

  // la anotacion @ModelAttribute() obtiene el objeto que se guarda en el modelo
  // que enviamos a la vista

  // la anotacion @PostMapping() se usa cuando vamos arecibir datos de la vista
  @PostMapping("/insertar_clientes")
  public String Insertar_Clientes(@ModelAttribute Clientes nuevocliente) {

    clienteservice.Insertar(nuevocliente);
    return "clientes/listado_clientes";
  }

  // =================================== TREVASIAS ==============================

  @RequestMapping("/crear_travesia")
  public String Crear_Travesias(Model modelo) {

    Travesias nuevatravesia = new Travesias();
    modelo.addAttribute("nuevatravesia", nuevatravesia);

    return "clientes/form_travesias";
  }

  @PostMapping("/insertar_travesias")
  public String Insertar_Travesias(@ModelAttribute Travesias nuevatravesia) {

    travesiaservice.Insertar(nuevatravesia);
    return "clientes/listado_travesias";
  }



  //==================================== EJERCICOS ========================================

  @RequestMapping("/miscarros")
  
  public String VerCarros(Model modelo) {

    List<Carros> miscarros = new ArrayList<>();
    miscarros.add(new Carros("LADA", "ROJO", 67));
    miscarros.add(new Carros("FERRARI", "BLANCO",3));
    miscarros.add(new Carros("CHEVROLET", "AZUL", 567));


    comparar(miscarros);
    Carros carro_menor_precio =  Menor_carro(miscarros);

    modelo.addAttribute("miscarros", miscarros);
    modelo.addAttribute("menorcarroprecio", carro_menor_precio);
    return "clientes/vista-pruebas";
     

    
  }

  
  public void comparar(List<Carros> miscarros) {

    Collections.sort(miscarros, new Comparator<Carros>() {

      @Override
      public int compare(Carros o1, Carros o2) {

        return o1.getColor().compareTo(o2.getColor());

      }

    });

  }


  public Carros Menor_carro(List<Carros> miscarros) {


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

   // ================= ESTA PARTE ES LA MISMA FUNCION PERO SIN LA INTERFACE ITERACION

    //  var menor = array[0].getPrecio();
    //  Carros carro_menor = array[0];
     
    // for (int i = 1; i < array.length; i++) {
      
    //   if (menor > array[i].getPrecio()) {
    //     menor =  array[i].getPrecio() ;
    //     carro_menor = array[i];
    //   }

    // }
    //================================================================================
    return carro_menor;
  }
  
}