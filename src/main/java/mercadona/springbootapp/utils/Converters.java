package mercadona.springbootapp.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import mercadona.springbootapp.dto.DestinoDTO;
import mercadona.springbootapp.entity.Destino;

public class Converters {

	private static Log log = LogFactory.getLog(Converters.class);
	
	public static ModelMapper modelMapper = new ModelMapper();
	
	public static List<DestinoDTO> listDestinoEntityToListDestinoDTO(List<Destino> listEnt) {
		
		log.info("Convertir lista de objeto entidad Destino a lista de Destino dto");
		
		List<DestinoDTO> res = new ArrayList<DestinoDTO>();
		
		res = modelMapper.map(listEnt,new TypeToken<List<DestinoDTO>>(){}.getType());
		
		return res;
	}
	
	public static DestinoDTO destinoEntityToDestinoDTO(Destino dest) {
		
		log.info("Convertir objeto entidad Destino a dto Destino");
		
		DestinoDTO res = modelMapper.map(dest, DestinoDTO.class);
		
		return res;
	}
	
	public static Destino destinoDTOToDestinoEntity(DestinoDTO dest) {
		
		log.info("Convertir objeto dto Destino a entidad Destino");
		
		Destino res = modelMapper.map(dest, Destino.class);
		
		return res;
	}
}
