package travesia.com.travesia.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="travesias")
@ToString // anotacion de lombok para generar el ToString() de la clase 
public class Travesias {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    @Getter @Setter 
    private int id;

    @Column(name="recorrido")
    @Getter @Setter 
    private String recorrido;

    @Column(name="nombre")
    @Getter @Setter 
    private String nombre;


    @Column(name="precio")
    @Getter @Setter 
    private int precio;

    
   
}
