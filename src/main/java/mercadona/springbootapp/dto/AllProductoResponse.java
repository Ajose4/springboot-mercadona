package mercadona.springbootapp.dto;

import java.util.List;

public class AllProductoResponse {

	/** productos */
	private List<ProductoDTO> productos;
	
	/** numProductos */
	private Integer numProductos;

	public AllProductoResponse() {
		super();
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}

	public Integer getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(Integer numProductos) {
		this.numProductos = numProductos;
	}

}
