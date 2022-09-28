package mercadona.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
	
	@Column(name = "cod", nullable = false)
    private final String cod;
	
	@Column(name = "name", nullable = false)
    private final String name;

    public Producto(long id, String cod, String name) {
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public long getId() {
        return id;
    }

    public String getCod() {
		return cod;
	}

	public String getName() {
        return name;
    }
	
}
