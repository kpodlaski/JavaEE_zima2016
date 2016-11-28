package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model2.Jednostka;
import model2.Osoba;

public class ConnectOracle {

	public static void main(String[] args) throws SQLException {
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
		//Wysy³amy zapytanie
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
		//obs³uga jak z PreparedStatement
		
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
		//TEST  DBConnector;
	}

}
