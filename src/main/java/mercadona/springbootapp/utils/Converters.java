package mercadona.springbootapp.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;

import mercadona.springbootapp.dto.DestinoResponseDTO;
import mercadona.springbootapp.entity.Destino;

public class Converters {

	private static Log log = LogFactory.getLog(Converters.class);
	
	public static DestinoResponseDTO destinoToDestinoResponseDTO(Destino dest) {
		
		log.info("Convertir objeto entidad Destino a dto Destino");
		
		ModelMapper modelMapper = new ModelMapper();
		DestinoResponseDTO res = modelMapper.map(dest, DestinoResponseDTO.class);
		
		return res;
	}
}
