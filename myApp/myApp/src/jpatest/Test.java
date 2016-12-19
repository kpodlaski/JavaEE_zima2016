package jpatest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.jpa.Jednostka;
import model.jpa.Osoba;
import model.jpa.Stanowisko;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("myAppJPA");
		EntityManager em = emf.createEntityManager();
		Stanowisko s = em.find(Stanowisko.class, 2L); //Obiekt Stanowisko o id = 2;
		System.out.println(s.getId()+ " "+ s.getNazwa());
		List<Stanowisko> wynik = em.createNamedQuery("Stanowisko.findAll").getResultList();
		for (Stanowisko st : wynik){
			System.out.println(st.getId()+ " "+ st.getNazwa());
		}
		System.out.println("=======================");
		//Query nQ =  em.createNamedQuery("Stanowisko.findByNazwa");
		//nQ.setParameter("nazwa", "Asystent");
		wynik =em.createNamedQuery("Stanowisko.findByNazwa")
				 .setParameter("nazwa", "Asystent").getResultList();
		for (Stanowisko st : wynik){
			System.out.println(st.getId()+ " "+ st.getNazwa());
		}
		//Stanowisko.findByNazwa
		//Osoba.findByNazwisko
		//Osoba.findByImie
		//Jednostka.findByNazwa
		Jednostka j = new Jednostka();
		j.setNazwa("Ochrona");
		Osoba o = new Osoba();
		o.setImie("Olaf");o.setNazwisko("Kowalski");
		o.setStanowisko(wynik.get(0));
		j.getPracownicy().add(o);
		//em.getTransaction().begin();
		//em.persist(o);
		//em.persist(j);
		//em.getTransaction().commit();
		List<Jednostka> jwynik =em.createNamedQuery("Jednostka.findAll")
				 .getResultList();
		for (Jednostka je : jwynik){
			System.out.println(je.getId()+ " "+ je.getNazwa());
		}
		List<Osoba> osList = jwynik.get(0).getPracownicy();
		for(Osoba os : osList ){
			System.out.println(os.getId()+ " "+ os.getNazwisko());
		}
		
	}

}
