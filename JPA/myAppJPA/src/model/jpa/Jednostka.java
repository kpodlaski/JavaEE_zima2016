package model.jpa;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the JEDNOSTKA database table.
 * 
 */
@Entity
@NamedQuery(name="Jednostka.findAll", query="SELECT j FROM Jednostka j")
public class Jednostka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JEDNOSTKA_ID_GENERATOR", sequenceName="JEDNOSTKA_ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JEDNOSTKA_ID_GENERATOR")
	private long id;

	private String nazwa;

	//uni-directional many-to-many association to Osoba
	@ManyToMany
	@JoinTable(
		name="OS_JEDN_LNK"
		, joinColumns={
			@JoinColumn(name="ID_JEDN")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_OSOBA")
			}
		)
	private List<Osoba> pracownicy = new ArrayList<Osoba>();

	public Jednostka() {
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

	public List<Osoba> getPracownicy() {
		return this.pracownicy;
	}

	public void setPracownicy(List<Osoba> pracownicy) {
		this.pracownicy = pracownicy;
	}

}