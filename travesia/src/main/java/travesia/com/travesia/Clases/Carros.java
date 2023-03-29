package travesia.com.travesia.Clases;

import lombok.*;

@ToString
public class Carros {
    
    @Getter @Setter
    private String marca;
    @Getter @Setter
    private  String color;
    @Getter @Setter
    private int precio;
    
    public Carros(String marca, String color, int precio ) {
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        
    }

    public Carros() {
        
    }




  



        
    }

  


