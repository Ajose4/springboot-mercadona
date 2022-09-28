package mercadona.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mercadona.springbootapp.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	List<Producto> findByCod (Integer cod);

}
