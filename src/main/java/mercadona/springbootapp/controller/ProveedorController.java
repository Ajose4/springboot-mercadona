package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IProveedorController;
import mercadona.springbootapp.dto.AllProveedorResponse;
import mercadona.springbootapp.dto.ProveedorDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController implements IProveedorController {

private static Log log = LogFactory.getLog(ProveedorController.class);
	
	@Autowired
	IProveedorService proveedorService;
    
	/**
	 * Método para obtener All Proveedores
	 * 
	 * @return code ResponseEntity<AllProveedorResponse>
	 * @throws RestException 
	 */
    public ResponseEntity<AllProveedorResponse> getAllProveedor(String token) throws RestException {
    	
    	log.info("Access to AllProveedor controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<AllProveedorResponse> response = null;
		
		try {
			
			final AllProveedorResponse res = proveedorService.getAllProveedor();
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST AllProveedor");
				throw new RestException("No se ha podido encontrar Proveedores", "500", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST AllProveedor");
			throw new RestException("No se ha podido encontrar Proveedores", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to AllProveedor() took "
				+ duration + " ms.");
		return response;
		
  }
    
	/**
	 * Método para obtener ProveedorDTO  by codigo
	 * 
	 * @param cod the cod
	 * @return code ResponseEntity<ProveedorDTO>
	 * @throws RestException 
	 */
    public ResponseEntity<ProveedorDTO> getProveedorByCod(String token, Integer cod) throws RestException {
    	
    	log.info("Access to getProveedorByCod controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProveedorDTO> response = null;
		
		try {
			
			final ProveedorDTO res = proveedorService.getProveedorByCod(cod);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST getProveedorByCod");
				throw new RestException("No se ha podido encontrar Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST getProveedorByCod");
			throw new RestException("No se ha podido encontrar Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getProveedorByCod(" + cod + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
	 * Método para crear entidad Proveedor
	 * 
	 * @param ProveedorDTO the proveedor to create
	 * @return code ResponseEntity<ProveedorDTO>
	 * @throws RestException 
	 */
    @Override
    public ResponseEntity<ProveedorDTO> createProveedor(String token, ProveedorDTO request) throws RestException {
    	
    	log.info("Access to createProveedor controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProveedorDTO> response = null;
		
		try {
			
			final ProveedorDTO res = proveedorService.createProveedor(request);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido crear correctamente los datos del servicio REST createProveedor");
				throw new RestException("No se ha podido crear Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido crear correctamente los datos del servicio REST createProveedor");
			throw new RestException("No se ha podido crear Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to createProveedor(" + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
   	 * Método para actualizar una entidad Proveedor
   	 * 
   	 * @param ProveedorDTO the proveedor to create
   	 * @return code ResponseEntity<ProveedorDTO>
   	 * @throws RestException 
   	 */
       @Override
       public ResponseEntity<ProveedorDTO> updateProveedor(String token, ProveedorDTO request) throws RestException {
       	
       	log.info("Access to updateProveedor controller");
         
       	long startTime = System.nanoTime();
         
   		ResponseEntity<ProveedorDTO> response = null;
   		
   		try {
   			
   			final ProveedorDTO res = proveedorService.updateProveedor(request);
   			
   			if (res != null) {
   				response = ResponseEntity.ok(res);
   				
   			} else {
   				log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProveedor");
   				throw new RestException("No se ha podido actualizar Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
   			}
   			
   		} catch (Exception e) {
   			
   			log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProveedor");
   			throw new RestException("No se ha podido encontrar Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
   		}
   		
   		long endTime = System.nanoTime();
   		long duration = (endTime - startTime) / 1000000L;
   		
   		log.info("The request to updateProveedor(" + ") took "
   				+ duration + " ms.");
   		return response;
   		
     }
       
       /**
      	 * Método para borrar una entidad Proveedor
      	 * 
      	 * @param ProveedorDTO the proveedor to create
      	 * @return code ResponseEntity<ProveedorDTO>
      	 * @throws RestException 
      	 */
          @Override
          public ResponseEntity<ProveedorDTO> deleteProveedor(String token, ProveedorDTO request) throws RestException {
          	
          	log.info("Access to deleteProveedor controller");
            
          	long startTime = System.nanoTime();
            
      		ResponseEntity<ProveedorDTO> response = null;
      		
      		try {
      			
      			final ProveedorDTO res = proveedorService.deleteProveedor(request);
      			
      			if (res != null) {
      				response = ResponseEntity.ok(res);
      				
      			} else {
      				log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProveedor");
      				throw new RestException("No se ha podido borrar Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
      			}
      			
      		} catch (Exception e) {
      			
      			log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProveedor");
      			throw new RestException("No se ha podido borrar Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
      		}
      		
      		long endTime = System.nanoTime();
      		long duration = (endTime - startTime) / 1000000L;
      		
      		log.info("The request to deleteProveedor(" + ") took "
      				+ duration + " ms.");
      		return response;
      		
        }

}
