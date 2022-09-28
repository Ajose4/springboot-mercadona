package mercadona.springbootapp.dto;

public class ProductDTO {

	/** cod */
	private Integer cod;
	
	/** name */
	private String name;
	
	public ProductDTO() {
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
