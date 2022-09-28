package mercadona.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESTINO")
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "cod", nullable = false)
    private String cod;
	 
    public Destino() {
    	super();
	}

	public Destino(long id, String cod, String destiny) {
        this.id = id;
        this.name = destiny;
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

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
    
}