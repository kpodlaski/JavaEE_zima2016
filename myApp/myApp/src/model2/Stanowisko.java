package model2;

public class Stanowisko {

	private String nazwa;

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

	public Stanowisko(String nazwa) {
		super();
		this.nazwa = nazwa;
	}
	
	public Stanowisko(){
		
	}
}
