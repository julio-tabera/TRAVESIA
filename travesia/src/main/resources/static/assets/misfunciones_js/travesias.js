/*!
=========================================================
* FoodHut Landing page
=========================================================

* Copyright: 2019 DevCRUD (https://devcrud.com)
* Licensed: (https://devcrud.com/licenses)
* Coded by www.devcrud.com

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
*/

// smooth scroll
$(document).ready(function(){
   
  MostrarTravesias ();
  
});



//==========================================================================
 // funcion javascript para hacer una peticion al servidor
     // dada una peticion dada.Cuando se hace una peticion al servidor 
     // con javascript se utiliza la funcion fetch
    
     async function MostrarTravesias (){
        const request = await fetch('travesias',{
        
         method: 'GET',
         headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
        
         }
        
        });
        const travesias = await request.json(); // el resultado se convierte en json
      
      
        let listadotravesiasHTML = '';
      
        for(let trav of travesias){   // se recorre el json y se ponen los valores en la tabla
          
          let botoneliminar = ' <a  class="badge badge-pill badge-danger eliminar" href="#"  onclick ="EliminarTravesia('+trav.id +')"> <span > Eliminar</span> </a>';
          let botoneditar  =  '<a class="badge badge-pill badge-info editar" href="#" onclick = "EditarTravesia('+trav.id +')"><span>Editar</span></a>';

          let travesiasHTML ='<tr id ='+ trav.id + '><th>'+ trav.nombre +'</th><td>' + trav.precio +'</td><td> '+ trav.recorrido +'</td><td><div> ' + botoneliminar +' '+botoneditar +'  </div></td> </tr> '  ; 
         
          listadotravesiasHTML += travesiasHTML; 
        
        }
         // aqui modificamos el body de la tabla
        
        document.querySelector('#tabla-trav tbody').outerHTML= listadotravesiasHTML;     
        
      
      }


     function EliminarTravesia(id) {

      var url = "eliminar_travesia/" + id
       $.ajax({
        type: 'DELETE',
        url: url,
        data: null,
        success: function (data) {
            if (data) {
                var id = '#' + data;// se concatena la fila con id del producto
                $(id).remove();// para eliminar  la fila
               }
        },

        error: function (request, msg, error) {                     // funcion encargada de procesar el error del servidor
            alert("Ha ocurrido un error: [" + error + "]");
        },
    });
    
    }

    var savetr = null; 

    function EditarTravesia(id) {
      
     savetr = $('#tabla-trav').find('#' + id).html(); // se salva la fila 

     // alert(savetr);
      var url = "crear_travesia_edit/" + id
       $.ajax({
        type: 'POST',
        url: url,
        data: null,
        success: function (data) {
           console.log(data);
           var fila = '#' + id; // se busca la fila para ponerle los input
           $(fila).html(data);

        },

        error: function (request, msg, error) {                     // funcion encargada de procesar el error del servidor
            alert("Ha ocurrido un error: [" + error + "]");
        },
    });
    
    }