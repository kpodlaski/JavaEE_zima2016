package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import model2.Jednostka;
import model2.Osoba;

public class ConnectOracle {

	private static String dateFormat = "yyyy-MM-dd";
	private static SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
	
	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			 //Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@10.16.80.11:1521:orcl", 
													 //jdbc:mysql://IP/dbname
				"sys as SYSDBA", "oracle");
		//Prosty Statement
		Statement st = con.createStatement();
		int minId =1;
		st.execute("SELECT * FROM Jednostka Where id>"+minId);
		ResultSet rs = st.getResultSet();
		while (rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString("nazwa");
			System.out.println(id + " : " + name );
		}
		rs.close();
		st.close();
		System.out.println("===============================");
		//Prepared Statement
		PreparedStatement pst = con.prepareStatement("SELECT * FROM Jednostka Where id>?");
		//Wysy�amy zapytanie
		pst.setInt(1, minId);
		pst.execute();
		rs = pst.getResultSet();
		while (rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString("nazwa");
			System.out.println(id + " : " + name );
		}
		rs.close();
		pst.close();
		//Callable statement
		//CallableStatement cst =  con.prepareCall(" ");
		//obs�uga jak z PreparedStatement
		
		con.close();
		
		DBConnector db = new DBConnector();
		List<Jednostka> jednostki = db.getAllJednostki();
		for(Jednostka j : jednostki){
			System.out.println(j.getId() + " " +j.getNazwa());
			System.out.println("Pracownicy");
			for (Osoba o : j.getPracownicy()){
				System.out.println("\t"+o);
			}
			
		}
		Date date = formatter.parse("1988-01-31");
		List<Osoba> osoby = db.getOsobyOlderThan(date);
		for(Osoba o : osoby){
			System.out.println(o.getId() +" " +o.getImie()+ " " +o.getNazwisko());
			}
			
		//TEST  DBConnector;
	}

}
