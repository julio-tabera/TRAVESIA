package travesia.com.travesia.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import travesia.com.travesia.Entidades.Travesias;

public interface TravesiasRepository extends JpaRepository<Travesias, Integer> {
    
}
