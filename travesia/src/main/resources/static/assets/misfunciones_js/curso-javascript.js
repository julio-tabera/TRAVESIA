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

/* 
$(document).ready(function() { // cuando cargue la apagna se ejcutan las funciones
   // alert("hola mundo");
   // Escribe_en_el_HTML();
  // var a = 56, b = 44, c= "66";
 
  

   Aparecer_suave();
   document.write("<p>"); // para hacer un salto de linea 
  // Suma();
 //  document.write("</p>"); // se cierra el salto de linea
//   document.write("<p>"); 
//   Descrementar();
   document.write("</p>");
   document.write("<p>");
 //  Comprar_articulos();
   document.write("</p>");
   document.write("<p>");
 //  Trabajar_conObjetos();
}) ; */

// ======================= FUNCIONES PARA EL CURSO =====================

// con esto escribimos el texto que ponemos en el html
function Escribe_en_el_HTML() {
  document.write("con esto escribimos el texto que ponemos");
}

// efecto de la bibioteca de jquery para aparecer en 5s lo qu esta el body de la pagina
function Aparecer_suave() {
  $("body").hide().fadeIn(5000);
}

function Suma() {
  // funcion prompt para la entrada de datos por el usuario
  // funcion parseInt para convertir valor de strig a int
  var a = parseInt(prompt("entre valor 1"));
  var b = parseInt(prompt("entre valor 2"));
  var c = parseInt(prompt("entre valor 3"));

  if (isNaN(a) || isNaN(b)) {
    // funcion isNAN pregunta si no es un numero

    alert("tienen que ser numeros");
  } else {
    document.write("suma de los valores");
    document.write(a + b + Number(c)); // funcion Number para convertir en numero siempre que se pueda
  }
}

function Descrementar() {
  var edad = parseInt(prompt(" diga su edad"));
  var restar_edad = parseInt(prompt("cantidad de años que quieres quitarte"));
  edad -= restar_edad;
  document.write("se le quito" + " " + restar_edad + " " + "años" + " ");
  document.writeln("tiene ahora" + " " + edad);
}

function Comprar_articulos() {
  var articulos = new Array(3);
  // var articulos = [] para declarar un array vacio;

  for (let index = 0; index < articulos.length; index++) {
    var articulo = prompt("introduzca el articulo a comprar");
    articulos[index] = articulo;
  }

  document.writeln("Usted a comprado estos articulos" + "<br>");
  articulos.push("leche"); // la funcion push agrega elemtos al final del array

  articulos.unshift("papas"); // la funcion unshist agrega elemtos al principio del array

  articulos.pop(); // la funcion pop elimina elemtos al final del array

  articulos.shift(); // la funcion shift elimina elemtos al principio del array

  for (let index = 0; index < articulos.length; index++) {
    document.writeln(articulos[index] + "<br>");
  }
}

$("#miboton").click(function () {
  var valor = $("#objeto_input").val();
  var nombre, apell, edad, tr1, tr2, tr3;
  nombre = prompt("escriba el nombre");
  apell = prompt("escriba el apellido");
  edad = prompt("escriba el edad");

  // tr1= ' <tr><td><div class="form-group"> <input type="text" class="form-contro form-control-sm" id="tr_obj1" placeholder="Apellidos"></div></td></tr>'

  // tr2= ' <tr><td><div class="form-group"> <input type="text" class="form-contro form-control-sm" id="tr_obj2" placeholder="Apellidos"></div></td></tr>'

  // tr3= ' <tr><td><div class="form-group"> <input type="text" class="form-contro form-control-sm" id="tr_obj3" placeholder="Apellidos"></div></td></tr>'

  tr1 = $("#tr1").html(); // aqui se obtiene el objeto input completo
  tr2 = $("#tr2").html();
  tr3 = $("#tr3").html();

  console.log(tr1);

  $("#objeto_input2").val(valor * valor);
  //  $('#objeto_input2').focus(); // la funcion focus selecciona el objeto

  $("#nombre").val(nombre);
  $("#apellidos").val(apell);
  $("#edad").val(Number(edad));

  var data = [nombre, apell, edad];

  for (let i = 0; i < data.length; i++) {
    if (i == 1) {
      data[i] = "TABERA";
      $("#nombre").val(data[i]);
    }
  }

  var data2 = new Array(tr1, tr2, tr3); // se almacenan en un array los input obtenidos

  // se crea un nuevo input
  var tr4 =
    ' <tr><td><div class="form-group"> <input type="text" class="form-contro form-control-sm" id="tr_obj4" placeholder="INPUT AGREGADO"></div></td></tr>';

  data2.push(tr4); // se inserta al final del array el nuevo input

  // se sustitute el cuerpo de la tabla por los elementos del array
  $(".mitable tbody").html(data2);

  // funcion css() es para cambiar los estilos de los objetos
  $("#edad").css("background-color", "red");
  // for (let index = 0; index < data2.length; index++) {
  //    document.write(data2[index]);

  // }
});

$("#miboton_fondo").click(function () {
  var body = $("#cuerpo");

  // la funcion find busca un objeto
  $(".mitable").find($("#edad").val(2345));
  //console.log(body);
  var color_fondo = prompt(
    "Elige color de fondo de la pagina:" + " " + "AZUL/ROJO/AMARILLO"
  );

  if (color_fondo.toUpperCase() == "AZUL") {
    body.css("background", "blue"); // se cambia el color de fondo
  } else if (color_fondo.toUpperCase() == "ROJO") {
    body.css("background", "red");
  } else if (color_fondo.toUpperCase() == "AMARILLO") {
    body.css("background", "yellow");
  } else {
    alert("este color no existe");
  }
});

$("#miboton_comprar").click(function () {
  var array = [];
  var cont = 0;
  var menor;

  while (cont < 5) {
    array[cont] = parseInt(prompt("entre las edades"));
    cont++;
  }
  menor = array[0];
  for (let i = 0; i < array.length; i++) {
    // document.write(array[i] + "<br>");
    if (menor > array[i]) {
      menor = array[i];
    }
  }

  for (let i = 0; i < array.length; i++) {
    for (let j = i + 1; j < array.length; j++) {
      if (array[i] > array[j]) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
  }
  $("#objeto_input2").val(
    "Array ordenado" +
      " " +
      array[0] +
      ", " +
      array[1] +
      "," +
      array[2] +
      ", " +
      array[3] +
      ", " +
      array[4]
  );
  $("#edad").val(menor);
});

$("#miboton_juego").click(function () {
  var intentos = 0;
  var aleatorio = Math.round(Math.random() * 100);
  // alert(aleatorio);
  var num = prompt("entre el numero");

  while (aleatorio != num) {
    if (aleatorio > num) {
      alert("Es mas alto el numero aleatorio");
    } else if (aleatorio < num) {
      alert("Es mas bajo el numero aleatorio");
    }

    intentos++;
    num = prompt("entre el numero");
  }

  alert("BINGO ACERTASTE con" + " " + intentos);
});

$(document).ready(function () {
  localStorage.clear();
  $('#panel').val(0);
});

var array_numero1 = [];
var array_numero_panel = [];
var parte1 = "";
var parte2 = "";

// AQUI se obtienen los valores tanto de los numeros como de las operaciones
// y se guardan en el localstorage en un arreglo global llamado array_numero1
// para trabajar con el seria de esta forma el arreglo: array_numero1 [7, 8, SUMA ,9,7,7]
// antes de la operacion concatenamos los valores y formamos un numero y despues de la operacion
// hacemos lo mismo

function Almacenar(botton, result_guardado) {
  var valor = botton.attr("name");
  array_numero1.push(valor);

  if (valor == "SUMA") {
    valor = "" + " + ";
  } else if (valor == "RESTA") {
    valor = "" + " - ";
  } else if (valor == "MULTIPLICAR") {
    valor = "" + " * ";
  } else if (valor == "DIVISION") {
    valor = "" + " / ";
  }
  array_numero_panel.push(valor);

  Panel(array_numero_panel);
  localStorage.setItem("arreglo", JSON.stringify(array_numero1));
  localStorage.setItem("arreglo_panel", JSON.stringify(array_numero_panel));
  // console.log(array_numero1);
}

function Panel(array) {
  var join = "";
  for (let i = 0; i < array.length; i++) {
    join += array[i];
  }
  $("#panel").val(join);
}

// AQUI se borra el ultimo elemento del arreglo
// y se limpia el localstorage y se vuevle a guardar el arreglo
// para que este actualizado en l localstorage

function BorrarUltimo(array) {
  if (array.length != 0) {
    array.pop();
    ActualizarArryLocalStorage(array);
  }
}

// AQUI borra el localstorage y actualiza el arreglo con los valore que tiene actuales
function ActualizarArryLocalStorage(array) {
  localStorage.clear();
  localStorage.setItem("arreglo", JSON.stringify(array));
}

//AQUI se recorre el arreglo hasta la posicion donde esta almacenada el nombre de la operacion (SUMA, RESTA, etc)
// y luego se concatenan los valores de las posiciones anteriores y se guarda en una variable

function Parte1(pos, union) {
  for (let index = 0; index < pos; index++) {
    union = union + array_numero1[index];
  }

  return union;
}


function Parte1_para_el_Porciento(union_porciento) {
    for (let index = 0; index < array_numero_panel.length; index++) {
        union_porciento = union_porciento + array_numero_panel[index];
    }
  
    return union_porciento;
  }


//AQUI se recorre el arreglo desde la posicion posterior donde esta almacenada el nombre de la operacion (SUMA, RESTA, etc)
// y luego se concatenan los valores de las posiciones posteriores y se guarda en una variable

function Parte2(pos, union) {
  for (let index = pos + 1; index < array_numero1.length; index++) {
    union = union + array_numero1[index];
  }

  return union;
}

// AQUI se borran los elementos del arreglos eso nos sirve
// para comenzar nuevas operaciones
function Borrar_Array(array) {
  for (let index = 0; index < array.length; index++) {
    array.splice(index);
  }
}

// ================================= CLICK EN LOS BOTONES ======================================
// AQUI se recoge el valor del calculo guardado en el localstorage
// si existe ese valor, entonces indica que realizo una operacion antes
// y se guarda en la parte1 de arreglo

function Click_boton_Suma() {
  var result_calculo_guardado = localStorage.getItem("calculo");
  // console.log(typeof(result_calculo_guardado));
  localStorage.clear();
  Almacenar($("#suma"), result_calculo_guardado);
  if (result_calculo_guardado) {
    parte1 = result_calculo_guardado;
  }

  return parte1;
}

function Click_boton_Resta() {
  var result_calculo_guardado = localStorage.getItem("calculo");
  // console.log(typeof(result_calculo_guardado));
  localStorage.clear();
  Almacenar($("#resta"), result_calculo_guardado);
  if (result_calculo_guardado) {
    parte1 = result_calculo_guardado;
  }

  return parte1;
}

function Click_boton_Multiplicar() {
  var result_calculo_guardado = localStorage.getItem("calculo");
  // console.log(typeof(result_calculo_guardado));
  localStorage.clear();
  Almacenar($("#multiplicar"), result_calculo_guardado);
  if (result_calculo_guardado) {
    parte1 = result_calculo_guardado;
  }

  return parte1;
}

function Click_boton_Division() {
  var result_calculo_guardado = localStorage.getItem("calculo");
  // console.log(typeof(result_calculo_guardado));
  localStorage.clear();
  Almacenar($("#division"), result_calculo_guardado);
  if (result_calculo_guardado) {
    parte1 = result_calculo_guardado;
  }

  return parte1;
}

function Click_boton_Porciento() {
    var result_calculo_guardado = localStorage.getItem("calculo");
    var union_porciento="";
    // console.log(typeof(result_calculo_guardado));
    localStorage.clear();
   // Almacenar($("#porciento"));
    if (result_calculo_guardado) {
      parte1 = result_calculo_guardado;

     }else{

        parte1 = parseInt(Parte1_para_el_Porciento(union_porciento));
     }
      var result_calculo = parseFloat(parte1/100); // operacion para hhlar el % de un numero
      $("#panel").val(result_calculo );
      Borrar_Array(array_numero1); // borramos en arreglo de los calculos
      Borrar_Array(array_numero_panel); // borramos el arreglo del panel
      localStorage.clear();
      localStorage.setItem("calculo", parseInt(result_calculo));
      
    return parte1;
  }

// AQUI es la funcion central que gestiona las operaciones a realizar

function Calcular(array_numero1, parte1, parte2) {
  var pos = 0;
  var union_parte1 = "";
  var union_parte2 = "";

  if (array_numero1.length != 0) {
    for (let i = 0; i < array_numero1.length; i++) {
      // ======================================================== SUMA ==========================
      if (array_numero1[i] == "SUMA") {
        pos = i;

        if (parte1 == "") {
          parte1 = parseInt(Parte1(pos, union_parte1));
        } else {
          parte1 = parseInt(parte1);
        }

        parte2 = parseInt(Parte2(pos, union_parte2));

        console.log(parte1);
        console.log(parte2);

        return Suma(parte1, parte2);

        // ======================================================== RESTA ============================
      } else if (array_numero1[i] == "RESTA") {
        pos = i;

        if (parte1 == "") {
          parte1 = parseInt(Parte1(pos, union_parte1));
        } else {
          parte1 = parseInt(parte1);
        }

        var parte2 = parseInt(Parte2(pos, union_parte2));

        console.log(parte1);
        console.log(parte2);

        return Resta(parte1, parte2);
      }

      // ======================================================== MULTIPLICAR ============================
      else if (array_numero1[i] == "MULTIPLICAR") {
        pos = i;

        if (parte1 == "") {
          parte1 = parseInt(Parte1(pos, union_parte1));
        } else {
          parte1 = parseInt(parte1);
        }

        var parte2 = parseInt(Parte2(pos, union_parte2));

        console.log(parte1);
        console.log(parte2);

        return Multiplicar(parte1, parte2);
      }

      // ======================================================== DIVISION ============================
      else if (array_numero1[i] == "DIVISION") {
        pos = i;

        if (parte1 == "") {
          parte1 = parseInt(Parte1(pos, union_parte1));
        } else {
          parte1 = parseInt(parte1);
        }

        var parte2 = parseInt(Parte2(pos, union_parte2));

        console.log(parte1);
        console.log(parte2);

        return Division(parte1, parte2);
      }
    }
  }
}

$("#resultado").click(function () {
  if (array_numero1 != 0) {
    var result_calculo = Calcular(array_numero1, parte1, parte2);

    if (!isNaN(result_calculo)) {

      $("#panel").val(result_calculo);
      Borrar_Array(array_numero1); // borramos en arreglo de los calculos
      Borrar_Array(array_numero_panel); // borramos el arreglo del panel
      localStorage.clear();
      localStorage.setItem("calculo", parseInt(result_calculo));

    }
  }
});

$("#flecha").click(function () {
  window.location = "/curso/calculadora";
  Borrar_Array(array_numero1);
  Borrar_Array(array_numero_panel);
  // document.write(array_numero1);
  $("#panel").val(""); // se limpia el panel de calculo
});

$("#borra_ultimo").click(function () {
  BorrarUltimo(array_numero1);
  BorrarUltimo(array_numero_panel);
  Panel(array_numero_panel);
});

// $("#prueba").click(function () {

//   });

////============================= FUNCIONES ARITMETICAS ======================

function Suma(valor1, valor2) {
  return valor1 + valor2;
}

function Resta(valor1, valor2) {
  return valor1 - valor2;
}

function Multiplicar(valor1, valor2) {
  return valor1 * valor2;
}

function Division(valor1, valor2) {
  return valor1 / valor2;
}

function Porciento(valor1) {
   return valor1/100;

  }
