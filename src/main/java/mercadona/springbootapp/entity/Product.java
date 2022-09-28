package mercadona.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "cod", nullable = false)
    private Integer cod;
	
	@Column(name = "name", nullable = false)
    private String name;

    public Product() {
    	super();
	}
	 
    public Product(long id, Integer cod, String name) {
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public long getId() {
        return id;
    }

    public Integer getCod() {
		return cod;
	}

	public String getName() {
        return name;
    }

	public void setId(long id) {
		this.id = id;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
