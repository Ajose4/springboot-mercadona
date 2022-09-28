package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IProductoController;
import mercadona.springbootapp.dto.AllProductoResponse;
import mercadona.springbootapp.dto.ProductoDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController implements IProductoController{

private static Log log = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	IProductoService productoService;
    
	/**
	 * Método para obtener All Productos
	 * 
	 * @return code ResponseEntity<AllProductoResponse>
	 * @throws RestException 
	 */
    public ResponseEntity<AllProductoResponse> getAllProducto(String token) throws RestException {
    	
    	log.info("Access to AllProducto controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<AllProductoResponse> response = null;
		
		try {
			
			final AllProductoResponse res = productoService.getAllProducto();
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST AllProducto");
				throw new RestException("No se ha podido encontrar Productos", "500", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST AllProducto");
			throw new RestException("No se ha podido encontrar Productos", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to AllProducto() took "
				+ duration + " ms.");
		return response;
		
  }
    
	/**
	 * Método para obtener ProductoDTO by codigo
	 * 
	 * @param cod the cod
	 * @return code ResponseEntity<ProductoDTO>
	 * @throws RestException 
	 */
    public ResponseEntity<ProductoDTO> getProductoByCod(String token, Integer cod) throws RestException {
    	
    	log.info("Access to getProductoByCod controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProductoDTO> response = null;
		
		try {
			
			final ProductoDTO res = productoService.getProductoByCod(cod);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST getProductoByCod");
				throw new RestException("No se ha podido encontrar Producto para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST getProductoByCod");
			throw new RestException("No se ha podido encontrar Producto para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getProductoByCod(" + cod + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
	 * Método para crear entidad Producto
	 * 
	 * @param ProductoDTO the Producto to create
	 * @return code ResponseEntity<ProductoDTO>
	 * @throws RestException 
	 */
    @Override
    public ResponseEntity<ProductoDTO> createProducto(String token, ProductoDTO request) throws RestException {
    	
    	log.info("Access to createProducto controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProductoDTO> response = null;
		
		try {
			
			final ProductoDTO res = productoService.createProducto(request);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido crear correctamente los datos del servicio REST createProducto");
				throw new RestException("No se ha podido crear Producto para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido crear correctamente los datos del servicio REST createProducto");
			throw new RestException("No se ha podido crear Producto para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to createProducto(" + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
   	 * Método para actualizar una entidad Producto
   	 * 
   	 * @param ProductoDTO the Producto to create
   	 * @return code ResponseEntity<ProductoDTO>
   	 * @throws RestException 
   	 */
       @Override
       public ResponseEntity<ProductoDTO> updateProducto(String token, ProductoDTO request) throws RestException {
       	
       	log.info("Access to updateProducto controller");
         
       	long startTime = System.nanoTime();
         
   		ResponseEntity<ProductoDTO> response = null;
   		
   		try {
   			
   			final ProductoDTO res = productoService.updateProducto(request);
   			
   			if (res != null) {
   				response = ResponseEntity.ok(res);
   				
   			} else {
   				log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProducto");
   				throw new RestException("No se ha podido actualizar Producto para el valor indicado", "404", HttpStatus.NOT_FOUND);
   			}
   			
   		} catch (Exception e) {
   			
   			log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProducto");
   			throw new RestException("No se ha podido encontrar Producto para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
   		}
   		
   		long endTime = System.nanoTime();
   		long duration = (endTime - startTime) / 1000000L;
   		
   		log.info("The request to updateProducto(" + ") took "
   				+ duration + " ms.");
   		return response;
   		
     }
       
       /**
      	 * Método para borrar una entidad Producto
      	 * 
      	 * @param ProductoDTO the Producto to create
      	 * @return code ResponseEntity<ProductoDTO>
      	 * @throws RestException 
      	 */
          @Override
          public ResponseEntity<ProductoDTO> deleteProducto(String token, ProductoDTO request) throws RestException {
          	
          	log.info("Access to deleteProducto controller");
            
          	long startTime = System.nanoTime();
            
      		ResponseEntity<ProductoDTO> response = null;
      		
      		try {
      			
      			final ProductoDTO res = productoService.deleteProducto(request);
      			
      			if (res != null) {
      				response = ResponseEntity.ok(res);
      				
      			} else {
      				log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProducto");
      				throw new RestException("No se ha podido borrar Producto para el valor indicado", "404", HttpStatus.NOT_FOUND);
      			}
      			
      		} catch (Exception e) {
      			
      			log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProducto");
      			throw new RestException("No se ha podido borrar Producto para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
      		}
      		
      		long endTime = System.nanoTime();
      		long duration = (endTime - startTime) / 1000000L;
      		
      		log.info("The request to deleteProducto(" + ") took "
      				+ duration + " ms.");
      		return response;
      		
        }

}
