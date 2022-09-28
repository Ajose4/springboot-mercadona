package mercadona.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mercadona.springbootapp.entity.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Long>{
	
	List<Destino> findByCod (Integer cod);

}
