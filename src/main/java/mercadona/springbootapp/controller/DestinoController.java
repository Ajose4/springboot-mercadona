package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IDestinoController;
import mercadona.springbootapp.dto.DestinoResponseDTO;
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
	 * Método para obtener entidad Destino by codigo
	 * 
	 * @param cod the cod
	 * @return code ResponseEntity<DestinoResponseDTO>
	 * @throws RestException 
	 */
    public ResponseEntity<DestinoResponseDTO> getDestinoByCod(String token, String cod) throws RestException {
    	
    	log.info("Access to getDestinoByCod controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<DestinoResponseDTO> response = null;
		
		try {
			
			Integer.valueOf("cod");
			
			final DestinoResponseDTO res = destinoService.getDestinoByCod(cod);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST getDestinoByCod");
				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
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
    
    
}
