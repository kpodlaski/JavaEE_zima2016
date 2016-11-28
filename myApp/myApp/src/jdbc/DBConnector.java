package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	
	public List<Jednostka> getAllJednostki() {
		List<Jednostka> result = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryAllJednostki);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result.add(createJednostkaFromResultSet(rs));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Jednostka getJednostkaById(int id) {
		Jednostka j = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryJednostkaById + id);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				j = createJednostkaFromResultSet(rs);
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
	}

	public List<Jednostka> getJednostkiByNazwa(String nazwa) {
		List<Jednostka> result = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryJednostkaByNazwa + nazwa);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result.add(createJednostkaFromResultSet(rs));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Osoba> getAllOsoby() {
		List<Osoba> result = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryAllOsobyAndStanowisko);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result.add(createOsobaFromResultSet(rs));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Osoba getOsobaById(int id) {
		Osoba result = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryOsobaAndStanowiskoByOsobaId + id);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result = createOsobaFromResultSet(rs);
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Osoba> getOsobyByNazwisko(String nazwisko) {
		List<Osoba> result = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryOsobaAndStanowiskoByNazwisko + nazwisko);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result.add(createOsobaFromResultSet(rs));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Osoba> getOsobaByImie(String imie) {
		List<Osoba> result = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryOsobaAndStanowiskoByImie);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result.add(createOsobaFromResultSet(rs));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Osoba> getOsobyOlderThan(Date date) {
		List<Osoba> result = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			System.out.println(SQLqueryOsobyAndStanowiskoOlderThan+to_date(date));
			st.execute(SQLqueryOsobyAndStanowiskoOlderThan+to_date(date));
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result.add(createOsobaFromResultSet(rs));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static String dateFormat = "yyyy-MM-dd";
	private static SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
	private String to_date(Date date) {
		StringBuilder sb = new StringBuilder("to_date('");
		sb.append(formatter.format(date));
		sb.append("','");
		sb.append(dateFormat);
		sb.append("')");
		return sb.toString();
	}

	public Stanowisko getStanowiskoById(int id) {
		Stanowisko result = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryStanowiskoById + id);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result = createStanowiskoFromResultSet(rs);
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Stanowisko> getAllStanowiska() {
		List<Stanowisko> result = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryAllStanowiska);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result.add(createStanowiskoFromResultSet(rs));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Stanowisko getStanowiskoByNazwa(String nazwa) {
		Stanowisko result = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", "sys as SYSDBA",
					"oracle");
			Statement st = con.createStatement();
			st.execute(SQLqueryStanowiskoByNazwa + nazwa);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				result = createStanowiskoFromResultSet(rs);
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//using querys:	SQLqueryALLJednostki
	//				SQLqueryJednostkaById
	//				SQLqueryJednostkaByNazwa
	private Jednostka createJednostkaFromResultSet(ResultSet rs) throws SQLException{
		int id = rs.getInt(1);
		String name = rs.getString("nazwa");
		Jednostka j = new Jednostka(name);
		j.setId(id);
		Statement st2 = rs.getStatement().getConnection().createStatement();
		st2.execute(SQLqueryOsobyAndStanowiskoByJednostkaId+id);
		ResultSet rs2 = st2.getResultSet();
		while(rs2.next()){
			j.getPracownicy().add(createOsobaFromResultSet(rs2));
    	}
		rs2.close();
		return j;
	}
	
	//using querys: SQLqueryAllOsobyAndStanowisko
	//				SQLqueryOsobyAndStanowiskoByJednostkaId
	//				SQLqueryOsobaAndStanowiskoByOsobaId
	//				SQLqueryOsobaAndStanowiskoByNazwisko
	//				SQLqueryOsobaAndStanowiskoByImie

	private Osoba createOsobaFromResultSet(ResultSet rs) throws SQLException{
		Osoba o = new Osoba();
		Stanowisko s =createStanowiskoFromResultSet(rs);
		s.setId(rs.getInt("sid"));
		o = new Osoba(rs.getString("imie"),
				rs.getString("nazwisko"),
				rs.getString("fotka"),s);
		o.setWiek(rs.getString("wiek"));
		o.setId(rs.getInt("oid"));
		return o;
	}
	
	//using querys: SQLqueryAllStanowiska
	//				SQLqueryStanowiskoById
	//				SQLqueryStanowiskaByNazwa
	//				SQLqueryAllOsobyAndStanowisko
	//				SQLqueryOsobyAndStanowiskoByJednostkaId
	//				SQLqueryOsobaAndStanowiskoByOsobaId
	//				SQLqueryOsobaAndStanowiskoByNazwisko
	//				SQLqueryOsobaAndStanowiskoByImie
	private Stanowisko createStanowiskoFromResultSet(ResultSet rs) throws SQLException{
		Stanowisko s = new Stanowisko(rs.getString("nazwa"));
		s.setId(rs.getInt("sid"));
		return s;
	}
	
	private static String SQLqueryAllJednostki = "Select * From Jednostka";
	private static String SQLqueryJednostkaById = "Select * From Jednostka WHERE id=";
	private static String SQLqueryJednostkaByNazwa = "Select * From Jednostka WHERE nazwa=";
	private static String SQLqueryAllOsobyAndStanowisko =
			"Select imie, nazwisko, stanowisko, fotka, wiek, nazwa, "+
			" osoba.id as oid, stanowiska.id as sid"+
			" From Osoba,Stanowiska "+
			" WHERE osoba.stanowisko = stanowiska.id ";
	private static String SQLqueryOsobyAndStanowiskoByJednostkaId =
			"Select imie, nazwisko, stanowisko, fotka, wiek, nazwa, "+
			" osoba.id as oid, stanowiska.id as sid"+
			" From Osoba,Stanowiska,os_jedn_lnk "+
			" WHERE osoba.id=id_osoba AND osoba.stanowisko = stanowiska.id AND id_jedn=";
	private static String SQLqueryOsobyAndStanowiskoOlderThan =
			"Select imie, nazwisko, stanowisko, fotka, wiek, nazwa, "+
			" osoba.id as oid, stanowiska.id as sid"+
			" From Osoba,Stanowiska "+
			" WHERE osoba.stanowisko = stanowiska.id AND wiek<";
	private static String SQLqueryOsobaAndStanowiskoByOsobaId =
			"Select imie, nazwisko, stanowisko, fotka, wiek, nazwa, "+
			" osoba.id as oid, stanowiska.id as sid"+
		    " From Osoba,Stanowiska "+
			" WHERE osoba.stanowisko = stanowiska.id AND osoba.id=";
	private static String SQLqueryOsobaAndStanowiskoByNazwisko =
			"Select imie, nazwisko, stanowisko, fotka, wiek, nazwa, "+
			" osoba.id as oid, stanowiska.id as sid"+
		    " From Osoba,Stanowiska "+
			" WHERE osoba.stanowisko = stanowiska.id AND nazwisko=";
	private static String SQLqueryOsobaAndStanowiskoByImie =
			"Select imie, nazwisko, stanowisko, fotka, wiek, nazwa, "+
			" osoba.id as oid, stanowiska.id as sid"+
		    " From Osoba,Stanowiska "+
			" WHERE osoba.stanowisko = stanowiska.id AND imie=";
	private static String SQLqueryAllStanowiska =
			"Select id as sid, nazwa"+
			" From Stanowiska ";
	private static String SQLqueryStanowiskoById =
			"Select id as sid, nazwa"+
			" From Stanowiska "+
			" WHERE stanowiska.id=";
	private static String SQLqueryStanowiskoByNazwa =
			"Select id as sid, nazwa"+
			" From Stanowiska "+
			" WHERE stanowiska.nazwa=";
	//+insert + update
}
