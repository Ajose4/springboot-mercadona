package mercadona.springbootapp.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;

import mercadona.springbootapp.dto.DestinoDTO;
import mercadona.springbootapp.entity.Destino;

public class Converters {

	private static Log log = LogFactory.getLog(Converters.class);
	
	public static DestinoDTO destinoEntityToDestinoDTO(Destino dest) {
		
		log.info("Convertir objeto entidad Destino a dto Destino");
		
		ModelMapper modelMapper = new ModelMapper();
		DestinoDTO res = modelMapper.map(dest, DestinoDTO.class);
		
		return res;
	}
	
	public static Destino destinoDTOToDestinoEntity(DestinoDTO dest) {
		
		log.info("Convertir objeto dto Destino a entidad Destino");
		
		ModelMapper modelMapper = new ModelMapper();
		Destino res = modelMapper.map(dest, Destino.class);
		
		return res;
	}
}
