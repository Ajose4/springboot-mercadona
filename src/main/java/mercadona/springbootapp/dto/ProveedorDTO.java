package mercadona.springbootapp.dto;

public class ProveedorDTO {

	/** cod */
	private Integer cod;
	
	/** name */
	private String name;
	
	public ProveedorDTO() {
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
