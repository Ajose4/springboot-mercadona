package mercadona.springbootapp.dto;

public class DetallesByEANResponseDTO {

	/** EAN */
	private String EAN;
	
	/** destino */
	private DestinoDTO destino;
	
	/** producto */
	private ProductoDTO producto;
	
	/** proveedor */
	private ProveedorDTO proveedor;

	public DetallesByEANResponseDTO() {
		super();
	}

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public DestinoDTO getDestino() {
		return destino;
	}

	public void setDestino(DestinoDTO destino) {
		this.destino = destino;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

}
