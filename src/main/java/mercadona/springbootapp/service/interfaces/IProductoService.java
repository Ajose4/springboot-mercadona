package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import mercadona.springbootapp.dto.AllProductoResponse;
import mercadona.springbootapp.dto.ProductoDTO;
import mercadona.springbootapp.exception.RestException;

public interface IProductoService {
	
	public ProductoDTO getProductoByCod (Integer cod) throws RestException, IOException;
	
	public ProductoDTO createProducto (ProductoDTO destino) throws RestException;
	
	public ProductoDTO updateProducto (ProductoDTO destino) throws RestException;
	
	public ProductoDTO deleteProducto (ProductoDTO destino) throws RestException;
	
	public AllProductoResponse getAllProducto () throws RestException, IOException;
}
