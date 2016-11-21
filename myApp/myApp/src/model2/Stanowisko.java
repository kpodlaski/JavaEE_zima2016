package model2;

public class Stanowisko {
	private int id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s", nazwa);
	}
}
