package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model2.Jednostka;
import model2.Osoba;
import model2.Stanowisko;

public class DBConnector {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			 //Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static List<Jednostka>getAllJednostki(){
		List<Jednostka> result = new ArrayList<>();
		try {
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA", "oracle");
			Statement st = con.createStatement();
			st.execute("Select * From Jednostka");
			ResultSet rs = st.getResultSet();
			while (rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString("nazwa");
				Jednostka j = new Jednostka(name);
				j.setId(id);
				Statement st2 = con.createStatement();
				st2.execute("Select imie, nazwisko, stanowisko, fotka, wiek, nazwa, "+
							" osoba.id as oid, stanowisko.id as sid"+
						    " From Osoba,Stanowiska,os_jedn_lnk "+
							"WHERE osoba.id=id_osoba AND osoba.stanowisko = stanowiska.id AND id_jedn="+id);
				ResultSet rs2 = st2.getResultSet();
				while(rs2.next()){
					Stanowisko s = new Stanowisko(rs2.getString("nazwa"));
					s.setId(rs2.getInt("sid"));
					Osoba o = new Osoba(rs2.getString("imie"),
							rs2.getString("nazwisko"),
							rs2.getString("fotka"),s);
					o.setWiek(rs2.getString("wiek"));
					o.setId(rs2.getInt("oid"));
		    	}
			
			}
			//close()+
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static Jednostka getJednostkaById(int id){
		return null;
	}
	
	public static List<Jednostka> getJednostkiByNazwa(String nazwa){
		return null;
	}
}
