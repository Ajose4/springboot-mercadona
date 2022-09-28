package mercadona.springbootapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mercadona.springbootapp.dto.DestinoResponseDTO;
import mercadona.springbootapp.entity.Destino;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.repository.DestinoRepository;
import mercadona.springbootapp.service.interfaces.IDestinoService;
import mercadona.springbootapp.utils.Converters;

@Service
public class DestinoService implements IDestinoService{

	/** The log */
	private static Log log = LogFactory.getLog(DestinoService.class);
	
	@Autowired
	private DestinoRepository destinoRepo;
	
	@Override
	public DestinoResponseDTO getDestinoByCod(String cod) throws IOException, RestException {
		
		log.info("Access to getDestinoByCod Service");
		DestinoResponseDTO res = null;
		
		List<Destino> list = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		list = destinoRepo.findByCod(cod);
		
		res = new DestinoResponseDTO();
		
		res = Converters.destinoToDestinoResponseDTO(list.get(0));
		
		return res;
	}
	
	
}
