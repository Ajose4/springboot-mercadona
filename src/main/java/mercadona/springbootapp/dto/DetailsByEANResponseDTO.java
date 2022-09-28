package mercadona.springbootapp.dto;

public class DetailsByEANResponseDTO {

	/** EAN */
	private String EAN;
	
	/** destino */
	private DestinyDTO destino;
	
	/** producto */
	private ProductDTO producto;
	
	/** proveedor */
	private ProviderDTO proveedor;

	public DetailsByEANResponseDTO() {
		super();
	}

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public DestinyDTO getDestino() {
		return destino;
	}

	public void setDestino(DestinyDTO destino) {
		this.destino = destino;
	}

	public ProductDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductDTO producto) {
		this.producto = producto;
	}

	public ProviderDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProviderDTO proveedor) {
		this.proveedor = proveedor;
	}

}
