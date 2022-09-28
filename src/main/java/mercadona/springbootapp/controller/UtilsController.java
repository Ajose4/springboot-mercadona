package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IUtilsController;
import mercadona.springbootapp.dto.AllProveedorResponse;
import mercadona.springbootapp.dto.DestinoDTO;
import mercadona.springbootapp.dto.DetallesByEANResponseDTO;
import mercadona.springbootapp.dto.ProductoDTO;
import mercadona.springbootapp.dto.ProveedorDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IDestinoService;
import mercadona.springbootapp.service.interfaces.IProductoService;
import mercadona.springbootapp.service.interfaces.IProveedorService;
import mercadona.springbootapp.utils.Utilidades;

@RestController
@RequestMapping("/utils")
public class UtilsController implements IUtilsController {

private static Log log = LogFactory.getLog(UtilsController.class);

	@Autowired
	IProveedorService proveedorService;
	
	@Autowired
	IProductoService productoService;
	
	@Autowired
	IDestinoService destinoService;
	
	/**
	 * Método para obtener detalles by ean
	 * 
	 * @return code ResponseEntity<AllProveedorResponse>
	 * @throws RestException 
	 */
	@Override
	public ResponseEntity<DetallesByEANResponseDTO> getDetallesByEAN(String token, String ean) throws RestException {
		
		log.info("Access to getDetallesByEAN controller");
	  
		long startTime = System.nanoTime();
	  
		ResponseEntity<DetallesByEANResponseDTO> response = null;
		
		try {
			
			Boolean esNumeric = Utilidades.isNumeric(ean);
			
			if ( !esNumeric ) {
				log.error("El String dado no es válido, existen letras.");
				throw new RestException("El EAN dado no es válido, contiene letras.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			Integer numCaracteres = ean.length();
			
			if (numCaracteres!=13) {
				log.error("El String dado no es válido, debe tener una longitud exacta de 13 caracteres.");
				throw new RestException("El String dado no es válido, debe tener una longitud exacta de 13 caracteres.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
			
			final DetallesByEANResponseDTO res = new DetallesByEANResponseDTO();

			
			String destino = ean.substring(12);
			String proveedor = ean.substring(0, 7);
			String producto = ean.substring(7,12);
			
			ProductoDTO productoDto = productoService.getProductoByCod(Integer.valueOf(producto));
			
			if( productoDto==null ) {
				log.error("No existe producto con codigo: " + producto + " por favor, compruebe el número EAN introducido.");
				throw new RestException("No existe producto con codigo: " + producto + " por favor, compruebe el número EAN introducido.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			} else {
				res.setProducto(productoDto);
			}
			
			ProveedorDTO proveedorDto = proveedorService.getProveedorByCod(Integer.valueOf(proveedor));
			
			if( proveedorDto==null ) {
				log.error("No existe producto con codigo: " + proveedor + " por favor, compruebe el número EAN introducido.");
				throw new RestException("No existe producto con codigo: " + proveedor + " por favor, compruebe el número EAN introducido.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			} else {
				res.setProveedor(proveedorDto);
			}
			
			DestinoDTO destinoDto = destinoService.getDestinoByCod(Integer.valueOf(destino));
			
			if( destinoDto==null ) {
				log.error("No existe producto con codigo: " + destino + " por favor, compruebe el número EAN introducido.");
				throw new RestException("No existe producto con codigo: " + destino + " por favor, compruebe el número EAN introducido.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			} else {
				res.setDestino(destinoDto);
			}
			
			
			response = ResponseEntity.ok(res);
			
		} catch (Exception e) {
			
			log.error(e.getMessage());
			throw new RestException(e.getMessage(), "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getDetallesByEAN("+ean+") took "
				+ duration + " ms.");
		return response;
		
	}


}
