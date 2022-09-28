package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import mercadona.springbootapp.dto.AllProveedorResponse;
import mercadona.springbootapp.dto.ProveedorDTO;
import mercadona.springbootapp.exception.RestException;

public interface IProveedorService {

	public ProveedorDTO getProveedorByCod (Integer cod) throws RestException, IOException;
	
	public ProveedorDTO createProveedor (ProveedorDTO destino) throws RestException;
	
	public ProveedorDTO updateProveedor (ProveedorDTO destino) throws RestException;
	
	public ProveedorDTO deleteProveedor (ProveedorDTO destino) throws RestException;
	
	public AllProveedorResponse getAllProveedor () throws RestException, IOException;
}
