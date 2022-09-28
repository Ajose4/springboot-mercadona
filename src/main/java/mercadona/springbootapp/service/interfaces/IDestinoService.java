package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import mercadona.springbootapp.dto.DestinoResponseDTO;
import mercadona.springbootapp.exception.RestException;

public interface IDestinoService {
	
	public DestinoResponseDTO getDestinoByCod (String cod) throws RestException, IOException;
	

}
