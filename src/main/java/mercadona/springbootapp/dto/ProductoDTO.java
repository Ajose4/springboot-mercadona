package mercadona.springbootapp.dto;

public class ProductoDTO {

	/** cod */
	private Integer cod;
	
	/** name */
	private String name;
	
	public ProductoDTO() {
		super();
	}
	
	public Integer getCod() {
		return cod;
	}
	public String getName() {
		return name;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
