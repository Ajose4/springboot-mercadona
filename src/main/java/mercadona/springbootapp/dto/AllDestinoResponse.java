package mercadona.springbootapp.dto;

import java.util.List;

public class AllDestinoResponse {

	/** destinos */
	private List<DestinoDTO> destinos;
	
	/** numDestinos */
	private Integer numDestinos;

	public AllDestinoResponse() {
		super();
	}

	public List<DestinoDTO> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<DestinoDTO> destinos) {
		this.destinos = destinos;
	}

	public Integer getNumDestinos() {
		return numDestinos;
	}

	public void setNumDestinos(Integer numDestinos) {
		this.numDestinos = numDestinos;
	}
	
	
}
