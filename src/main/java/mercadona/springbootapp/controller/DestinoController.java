package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IDestinoController;
import mercadona.springbootapp.dto.AllDestinoResponse;
import mercadona.springbootapp.dto.DestinoDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IDestinoService;

//@OpenAPIDefinition(servers = { @Server(url = "http://localhost:7001") }, info = @Info(title = "Sample Spring Boot API", version = "v1", description = "A demo project using Spring Boot with Swagger-UI enabled", license = @License(name = "MIT License", url = "https://github.com/bchen04/springboot-swagger-rest-api/blob/master/LICENSE"), contact = @Contact(url = "https://www.linkedin.com/in/bchen04/", name = "Ben Chen")))
@RestController
@RequestMapping("/destino")
public class DestinoController implements IDestinoController {
	
	private static Log log = LogFactory.getLog(DestinoController.class);
	
	@Autowired
	IDestinoService destinoService;
    
	/**
	 * Método para obtener All Destinos
	 * 
	 * @return code ResponseEntity<AllDestinoResponse>
	 * @throws RestException 
	 */
    public ResponseEntity<AllDestinoResponse> getAllDestino(String token) throws RestException {
    	
    	log.info("Access to AllDestino controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<AllDestinoResponse> response = null;
		
		try {
			
			final AllDestinoResponse res = destinoService.getAllDestino();
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST AllDestino");
				throw new RestException("No se ha podido encontrar Destinos", "500", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST AllDestino");
			throw new RestException("No se ha podido encontrar Destinos", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to AllDestinoResponse() took "
				+ duration + " ms.");
		return response;
		
  }
    
	/**
	 * Método para obtener DestinoDTO  by codigo
	 * 
	 * @param cod the cod
	 * @return code ResponseEntity<DestinoDTO>
	 * @throws RestException 
	 */
    public ResponseEntity<DestinoDTO> getDestinoByCod(String token, Integer cod) throws RestException {
    	
    	log.info("Access to getDestinoByCod controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<DestinoDTO> response = null;
		
		try {
			
			final DestinoDTO res = destinoService.getDestinoByCod(cod);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST getDestinoByCod");
				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST getDestinoByCod");
			throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to destinoByCod(" + cod + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
	 * Método para crear entidad Destino
	 * 
	 * @param DestinoDTO the destino to create
	 * @return code ResponseEntity<DestinoDTO>
	 * @throws RestException 
	 */
    @Override
    public ResponseEntity<DestinoDTO> createDestino(String token, DestinoDTO request) throws RestException {
    	
    	log.info("Access to createDestino controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<DestinoDTO> response = null;
		
		try {
			
			final DestinoDTO res = destinoService.createDestino(request);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST createDestino");
				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST createDestino");
			throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to createDestino(" + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
   	 * Método para actualizar una entidad Destino
   	 * 
   	 * @param DestinoDTO the destino to create
   	 * @return code ResponseEntity<DestinoDTO>
   	 * @throws RestException 
   	 */
       @Override
       public ResponseEntity<DestinoDTO> updateDestino(String token, DestinoDTO request) throws RestException {
       	
       	log.info("Access to updateDestino controller");
         
       	long startTime = System.nanoTime();
         
   		ResponseEntity<DestinoDTO> response = null;
   		
   		try {
   			
   			final DestinoDTO res = destinoService.updateDestino(request);
   			
   			if (res != null) {
   				response = ResponseEntity.ok(res);
   				
   			} else {
   				log.error("No se ha podido obtener correctamente los datos del servicio REST updateDestino");
   				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
   			}
   			
   		} catch (Exception e) {
   			
   			log.error("No se ha podido actualizar correctamente los datos del servicio REST updateDestino");
   			throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
   		}
   		
   		long endTime = System.nanoTime();
   		long duration = (endTime - startTime) / 1000000L;
   		
   		log.info("The request to updateDestino(" + ") took "
   				+ duration + " ms.");
   		return response;
   		
     }
       
       /**
      	 * Método para borrar una entidad Destino
      	 * 
      	 * @param DestinoDTO the destino to create
      	 * @return code ResponseEntity<DestinoDTO>
      	 * @throws RestException 
      	 */
          @Override
          public ResponseEntity<DestinoDTO> deleteDestino(String token, DestinoDTO request) throws RestException {
          	
          	log.info("Access to deleteDestino controller");
            
          	long startTime = System.nanoTime();
            
      		ResponseEntity<DestinoDTO> response = null;
      		
      		try {
      			
      			final DestinoDTO res = destinoService.deleteDestino(request);
      			
      			if (res != null) {
      				response = ResponseEntity.ok(res);
      				
      			} else {
      				log.error("No se ha podido borrar correctamente los datos del servicio REST deleteDestino");
      				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
      			}
      			
      		} catch (Exception e) {
      			
      			log.error("No se ha podido borrar correctamente los datos del servicio REST deleteDestino");
      			throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
      		}
      		
      		long endTime = System.nanoTime();
      		long duration = (endTime - startTime) / 1000000L;
      		
      		log.info("The request to deleteDestino(" + ") took "
      				+ duration + " ms.");
      		return response;
      		
        }


}
