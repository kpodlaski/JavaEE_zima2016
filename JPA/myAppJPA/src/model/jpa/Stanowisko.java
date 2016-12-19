package model.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STANOWISKA database table.
 * 
 */
@Entity
@Table(name="STANOWISKA")
@NamedQueries (value={
@NamedQuery(name="Stanowisko.findAll", query="SELECT s FROM Stanowisko s"),
@NamedQuery(name="Stanowisko.findByNazwa", 
			query="SELECT s FROM Stanowisko s WHERE s.nazwa=:nazwa")
})

public class Stanowisko implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STANOWISKA_ID_GENERATOR", sequenceName="STANOWISKA_ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STANOWISKA_ID_GENERATOR")
	private long id;

	@Column(name="nazwa")
	private String nazwa;

	public Stanowisko() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}