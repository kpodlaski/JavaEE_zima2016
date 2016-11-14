package model2;

import java.util.ArrayList;
import java.util.List;

public class Jednostka {
	private int id;
	private String nazwa;
	private List<Osoba> pracownicy = new ArrayList<Osoba>();
	
	/**
	 * @return the nazwa
	 */
	public String getNazwa() {
		return nazwa;
	}
	/**
	 * @param nazwa the nazwa to set
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * @return the pracownicy
	 */
	public List<Osoba> getPracownicy() {
		return pracownicy;
	}
	/**
	 * @param pracownicy the pracownicy to set
	 */
	public void setPracownicy(List<Osoba> pracownicy) {
		this.pracownicy = pracownicy;
	}
	public Jednostka(String nazwa) {
		super();
		this.nazwa = nazwa;
	}
	
	public Jednostka(){
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
