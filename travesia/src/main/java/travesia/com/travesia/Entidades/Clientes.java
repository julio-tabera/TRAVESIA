package travesia.com.travesia.Entidades;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="clientes")
@ToString // anotacion de lombok para generar el ToString() de la clase  
@EqualsAndHashCode
public class Clientes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    @Getter @Setter // estos son los getters y setters con antaciones de Lombok
    private int id;

    @Column(name="nombre")
    @Getter @Setter 
    private String nombre;

    @Column(name="apellidos")
    @Getter @Setter 
    private String apellidos;

    @Column(name="movil")
    @Getter @Setter 
    private int movil;

   

    public Clientes(){}

    
    @ManyToOne()
    @JoinColumn(name="travesia_id")
    @Getter @Setter 
    private Travesias travesias; 
     


}
