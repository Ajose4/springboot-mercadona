package mercadona.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mercadona.springbootapp.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

		List<Proveedor> findByCod (Integer cod);

}
