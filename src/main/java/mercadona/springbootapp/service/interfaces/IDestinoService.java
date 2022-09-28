package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import mercadona.springbootapp.dto.AllDestinoResponse;
import mercadona.springbootapp.dto.DestinoDTO;
import mercadona.springbootapp.exception.RestException;

public interface IDestinoService {
	
	public DestinoDTO getDestinoByCod (Integer cod) throws RestException, IOException;
	
	public DestinoDTO createDestino (DestinoDTO destino) throws RestException;
	
	public DestinoDTO updateDestino (DestinoDTO destino) throws RestException;
	
	public DestinoDTO deleteDestino (DestinoDTO destino) throws RestException;
	
	public AllDestinoResponse getAllDestino () throws RestException, IOException;
	
}
