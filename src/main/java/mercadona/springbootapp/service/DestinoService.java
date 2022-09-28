package mercadona.springbootapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mercadona.springbootapp.dto.DestinoDTO;
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
	public DestinoDTO getDestinoByCod(Integer cod) throws IOException, RestException {
		
		log.info("Access to getDestinoByCod Service");
		DestinoDTO res = null;
		
		List<Destino> list = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		
		try {
			list = destinoRepo.findByCod(cod);
			res = new DestinoDTO();
			
			if ( list.isEmpty() || list.get(0) ==  null) {
				return null;
			}else {
				res = Converters.destinoEntityToDestinoDTO(list.get(0));
			}
			
		} catch (Exception e) {
			log.info("No se ha podido obtener correctamente datos de BBDD");
			throw new RestException("No se ha podido encontrar Destino en BBDD para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public DestinoDTO createDestino(DestinoDTO destino) throws RestException {
		
		log.info("Access to createDestino Service");
		DestinoDTO res = null;
		
		try {
			log.info("Convierte objeto destino dto a entity");
			Destino destinoEntity = Converters.destinoDTOToDestinoEntity(destino);
			
			log.info("Llamada al repository para crear objeto en Base de Datos");
			Destino entity = destinoRepo.save(destinoEntity);
			
			if ( entity ==  null) {
				return null;
			}else {
				res = Converters.destinoEntityToDestinoDTO(entity);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido crear correctamente datos en BBDD");
			throw new RestException("No se ha podido crear Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	@Override
	public DestinoDTO updateDestino(DestinoDTO destino) throws RestException {
		
		log.info("Access to updateDestino Service");
		DestinoDTO res = null;
		
		try {
			log.info("Convierte objeto destino dto a entity");
			Destino destinoEntity = Converters.destinoDTOToDestinoEntity(destino);
			
			log.info("Llamada al repository buscar objeto a actualizar");
			List<Destino> listaDest = new ArrayList<>();
			
			listaDest = destinoRepo.findByCod(destino.getCod());
			
			Destino destinoEnt = null;
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + destino.getCod() + "para actualizar");
				throw new RestException("No existen registro con el codigo indicado para actualizar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
				log.info("Se obtiene el id del registro a actualizar");
				destinoEntity.setId(listaDest.get(0).getId());
				
				log.info("Se actualiza el registro encontrado");
				destinoEnt = destinoRepo.save(destinoEntity);
			}
			
			if ( destinoEnt ==  null) {
				return null;
			}else {
				res = Converters.destinoEntityToDestinoDTO(destinoEnt);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido actualizar correctamente datos en BBDD");
			throw new RestException("No se ha podido actualizar Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public DestinoDTO deleteDestino(DestinoDTO destino) throws RestException {
		log.info("Access to deleteDestino Service");
		DestinoDTO res = null;
		
		try {
			log.info("Convierte objeto destino dto a entity");
			Destino destinoEntity = Converters.destinoDTOToDestinoEntity(destino);
			
			log.info("Llamada al repository buscar objeto a borrar");
			List<Destino> listaDest = new ArrayList<>();
			
			listaDest = destinoRepo.findByCod(destino.getCod());
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + destino.getCod() + "para borrar");
				throw new RestException("No existen registro con el codigo indicado para borrar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				log.info("Se obtiene el id del registro a borrar");
				destinoEntity.setId(listaDest.get(0).getId());
				
				log.info("Se borra el registro encontrado");
				destinoRepo.delete(destinoEntity);
			}
			
			res = destino;
			
		} catch (Exception e) {
			log.info("No se ha podido borrar correctamente datos en BBDD");
			throw new RestException("No se ha podido borrar Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	
}
