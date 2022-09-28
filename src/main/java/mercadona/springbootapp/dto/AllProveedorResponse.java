package mercadona.springbootapp.dto;

import java.util.List;

public class AllProveedorResponse {
	
	/** proveedores */
	private List<ProveedorDTO> proveedores;
	
	/** numProveedores */
	private Integer numProveedores;

	public AllProveedorResponse() {
		super();
	}

	public List<ProveedorDTO> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<ProveedorDTO> proveedores) {
		this.proveedores = proveedores;
	}

	public Integer getNumProveedores() {
		return numProveedores;
	}

	public void setNumProveedores(Integer numProveedores) {
		this.numProveedores = numProveedores;
	}

}
