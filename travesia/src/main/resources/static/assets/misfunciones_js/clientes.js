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
   
  MostrarUsuarios();
//  Buscar_Usuarios();

});




// window.onload = function () {
    
    
  
         
// } 

// funcion javascript para hacer una peticion al servidor
// dada una peticion dada.Cuando se hace una peticion al servidor 
// con javascript se utiliza la funcion fetch

async function MostrarUsuarios (){
const request = await fetch('usuarios',{

 method: 'GET',
 headers: {
   'Accept': 'application/json',
   'Content-Type': 'application/json'

 }

});
const usuarios = await request.json(); // el resultado que viene de la funcion se convierte en json
//console.log(usuarios);

let listadousuarioHTML = '';


for(let user of usuarios){   // se recorre el json y se ponen los valores en la tabla
  //var nombre = user.nombre;
  let botoneliminar = ' <a  class="badge badge-pill badge-danger eliminar" href="#" onclick ="EliminarUsuarios('+ user.id+')"> <span > Eliminar</span> </a>';
  let botoneditar = '   <a class="badge badge-pill badge-info editar" href="#"  data-whatever='+ user.id +' onclick ="EditarUsuarios( '+ user.id +')" ><span >Editar</span> </a>';

  let usuarioHTML ='<tr id='+user.id +'><th>'+ user.nombre +'</th><td>' + user.apellidos +'</td><td> '+ user.movil +'</td><td> '+ user.travesias.nombre +'</td><td><div> '+ botoneliminar +' '+ botoneditar +'  </div></td> </tr> '  ; 
 
  listadousuarioHTML += usuarioHTML; 

}
 // aqui modificamos el body de la tabla

document.querySelector('#tabla-cl tbody').outerHTML= listadousuarioHTML;     


}

// ================ FUNCION PARA BORRAR =========================
async function EliminarUsuarios(id){
 //alert(id);

 const request = await fetch('eliminar_clientes/'+ id,{

  method: 'DELETE',
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
 
  }
 
 });
 //window.location = "/travesia/listado";
 var id = await request.json(); // se comenta porque la funcion no devuleve nada
 var fila = '#' + id // se concatena la fila con id 
 $(fila).remove();

 
}

 var save_tr = null;
 var save_tr2 = null;
 var xhr;

 function EditarUsuarios(id) {
    //  Event.preventDefault();
    //  Event.stopPropagation();
      var data = {
         id_fila_cliente: id,
          };

  //  alert (data.id_fila_cliente);
    var table = $('#tabla-cl');
      save_tr = table.find('#' + data.id_fila_cliente).html(); // se guarda el contenido o el cuerpo de la tabla
    //  console.log(save_tr);

      //  if (xhr && xhr.readyState != 4) {
    //      table.find('.fa-spinner').removeClass('fa-spin fa-spinner').addClass('fa-edit').parent().removeAttr('disabled');
    //      xhr.abort();
    //  }
    //  button.html("<i class='fa fa-spinner fa-spin'></i>").attr('disabled', 'disabled');
      xhr = $.ajax({
          url: "/travesia/crear_cliente_edit/" + data.id_fila_cliente,
          type: "POST",
          data: data,
          success: function (response) {

          //  console.log(response);
              table.find('#' + data.id_fila_cliente).html(response);
            //  table.find('#amd_piperbundle_lineavoucher_plancuenta').selectpicker('refresh');// poner estilo de un select al select de cuenta y refrescarlo
           // $('#form-check').attr("action", "/travesia/editar_clientes/" + id ).attr('method', 'post')
           
          },
          error: function (request, msg, error) {
              console.log(request);
          }
      })
 }


 $('#boton_buscar').click(function() {
 
   var data = {
      patron : $('#input_buscar').val()

   };
   if (data.patron) {
    
           ///-----
      $.ajax({
        url: href = "/travesia/buscar_clientes/" + data.patron,  // indicando la ruta de Symfony a pedir
        type: 'POST',                                             // indicando que la peticion será por POST
        data: data,       // datos del formulario serializados
        success: function (clientes) {                                  // funcion encargada de gestionar el resultado devuelto
        // console.log(clientes);

         let listadousuarioHTML = '';


         for(let user of clientes){   // se recorre el json y se ponen los valores en la tabla
           //var nombre = user.nombre;
           let botoneliminar = ' <a  class="badge badge-pill badge-danger eliminar" href="#" onclick ="EliminarUsuarios('+ user.id+')"> <span > Eliminar</span> </a>';
           let botoneditar = '   <a class="badge badge-pill badge-info editar" href="#"  data-whatever='+ user.id +' onclick ="EditarUsuarios( '+ user.id +')" ><span >Editar</span> </a>';
         
           let usuarioHTML ='<tr id='+user.id +'><th>'+ user.nombre +'</th><td>' + user.apellidos +'</td><td> '+ user.movil +'</td><td><div> '+ botoneliminar +' '+ botoneditar +'  </div></td> </tr> '  ; 
          
           listadousuarioHTML += usuarioHTML; 
         
         }
          // aqui modificamos el body de la tabla
         
         document.querySelector('#tabla-cl tbody').outerHTML= listadousuarioHTML;   

           
        },
        error: function (error) {                     // funcion encargada de procesar el error del servidor
            alert("Ha ocurrido un error: [" + error + "]");

        },

    });

   }
  
   
  
 });



function prueba(){

 //document.getElementById('tabla-cl').innerHTML = "DJDJDDKDKDKDKDKDKD";
 $('#tabla-cl').html("njdcjdjcjdcjed");

}

