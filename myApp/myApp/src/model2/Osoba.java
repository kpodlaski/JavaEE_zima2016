package model2;

public class Osoba {
	private int id;
	private String imie;
	private String nazwisko;
	private String wiek;
	private String foto;
	private Stanowisko stanowisko;
	/**
	 * @return the imie
	 */
	public String getImie() {
		return imie;
	}
	/**
	 * @param imie the imie to set
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}
	/**
	 * @return the nazwisko
	 */
	public String getNazwisko() {
		return nazwisko;
	}
	/**
	 * @param nazwisko the nazwisko to set
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	/**
	 * @return the stanowisko
	 */
	public Stanowisko getStanowisko() {
		return stanowisko;
	}
	/**
	 * @param stanowisko the stanowisko to set
	 */
	public void setStanowisko(Stanowisko stanowisko) {
		this.stanowisko = stanowisko;
	}
	public Osoba(String imie, String nazwisko, String foto, Stanowisko stanowisko) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.foto = foto;
		this.stanowisko = stanowisko;
	}
	
	public Osoba(){
		
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
	/**
	 * @return the wiek
	 */
	public String getWiek() {
		return wiek;
	}
	/**
	 * @param wiek the wiek to set
	 */
	public void setWiek(String wiek) {
		this.wiek = wiek;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s, %s %s : %s (%s, %s)", id, imie, nazwisko, stanowisko,
				wiek, foto);
	}
	
	
}
