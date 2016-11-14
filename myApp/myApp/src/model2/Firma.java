package model2;

import java.util.ArrayList;
import java.util.List;
//http://merlin.phys.uni.lodz.pl/kft-old/people/KPodlaski/zaj/Aplikacje_Bazodanowe_JEE_zaliczenie_zadania.pdf
public class Firma {
	private String nazwa;
	private List<Jednostka> jednostki = new ArrayList<>();
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
	 * @return the jednostki
	 */
	public List<Jednostka> getJednostki() {
		return jednostki;
	}
	/**
	 * @param jednostki the jednostki to set
	 */
	public void setJednostki(List<Jednostka> jednostki) {
		this.jednostki = jednostki;
	}
	
	public Firma(){
		nazwa ="XXYZ";
		createFirme();
	}
	private void createFirme() {
		Stanowisko kierownik = new Stanowisko("Kierownik");
		Stanowisko ciec = new Stanowisko("Cieæ");
		Stanowisko pracBiurowy = new Stanowisko("Pracownik Biuriowy");
		
		Jednostka j = new Jednostka("Biuro g³wne");
		j.getPracownicy().add(new Osoba("Anna","Dyrektor","fotki/1.jpg", kierownik ));
		j.getPracownicy().add(new Osoba("Jan","Pasek","fotki/2.jpg", pracBiurowy ));
		j.getPracownicy().add(new Osoba("Ewelina","Pokrzywka","fotki/3.png", pracBiurowy ));
		jednostki.add(j);
		j = new Jednostka("Obs³uga");
		j.getPracownicy().add(new Osoba("Tomasz","Tomaszewski","fotki/4.png", kierownik ));
		j.getPracownicy().add(new Osoba("Adam","Adamski","fotki/5.jpg", ciec ));
		jednostki.add(j);
		
	}
	
	//Metoda fabryczna
	private static Firma createNowaFirme() {
		Firma f =  new Firma();
		Stanowisko kierownik = new Stanowisko("Kierownik");
		Stanowisko ciec = new Stanowisko("Cieæ");
		Stanowisko pracBiurowy = new Stanowisko("Pracownik Biuriowy");
		
		Jednostka j = new Jednostka("Biuro g³wne");
		j.getPracownicy().add(new Osoba("Anna","Dyrektor","/fotki/1.jpg", kierownik ));
		j.getPracownicy().add(new Osoba("Jan","Pasek","/fotki/2.jpg", pracBiurowy ));
		j.getPracownicy().add(new Osoba("Ewelina","Pokrzywka","/fotki/3.jpg", pracBiurowy ));
		f.jednostki.add(j);
		j = new Jednostka("Obs³uga");
		j.getPracownicy().add(new Osoba("Tomasz","Tomaszewski","/fotki/4.jpg", kierownik ));
		j.getPracownicy().add(new Osoba("Adam","Adamski","/fotki/5.jpg", ciec ));
		f.jednostki.add(j);
		return f;
	}
	
	// Firma firma = Firma.createNowaFirme()
}
