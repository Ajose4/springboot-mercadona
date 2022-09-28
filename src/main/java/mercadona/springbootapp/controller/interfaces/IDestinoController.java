package mercadona.springbootapp.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import mercadona.springbootapp.common.StandarizedApiExceptionResponse;
import mercadona.springbootapp.dto.DestinoDTO;
import mercadona.springbootapp.exception.RestException;

public interface IDestinoController {
	
	@Operation(summary = "getDestino", description = "Get a destino by cod", tags={ "Destino" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinoDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/getDestinoByCod" }, method = { RequestMethod.GET })
	ResponseEntity<DestinoDTO> getDestinoByCod(@RequestHeader("access-token") String token, 
			@RequestParam(name = "cod", required = true) Integer cod) throws RestException;
	
	@Operation(summary = "createDestino", description = "Create a destino entity", tags={ "Destino" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinoDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/createDestino" }, method = { RequestMethod.POST })
	ResponseEntity<DestinoDTO> createDestino(@RequestHeader("access-token") String token, 
			@RequestBody DestinoDTO request) throws RestException;
	
	@Operation(summary = "updateDestino", description = "update destino entity", tags={ "Destino" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinoDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/updateDestino" }, method = { RequestMethod.PUT })
	ResponseEntity<DestinoDTO> updateDestino(@RequestHeader("access-token") String token, 
			@RequestBody DestinoDTO request) throws RestException;
	
	@Operation(summary = "deleteDestino", description = "Delete destino entity", tags={ "Destino" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinoDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/deleteDestino" }, method = { RequestMethod.DELETE })
	ResponseEntity<DestinoDTO> deleteDestino(@RequestHeader("access-token") String token, 
			@RequestBody DestinoDTO request) throws RestException;
	

}
