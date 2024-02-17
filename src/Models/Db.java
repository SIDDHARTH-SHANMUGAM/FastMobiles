package Models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	
	static Connection con;
	static{
		String url="jdbc:mysql://localhost:3306/MSM";
		String userName="root";
		String password="";
		try {
			 con = DriverManager.getConnection(url, userName, password);

		} catch (SQLException e) {
			System.out.println("DB CONNECTION ERROR\n"+e);
		}
	}
	
	public static PreparedStatement getPs(String query)
	{
		try {
			PreparedStatement ps = con.prepareStatement(query);
			return ps;
		} catch (Exception e) {
			System.out.println("Db--getPs(1)");
		}
		return null;
	}
	public static PreparedStatement getPs(String query, boolean b)
	{
		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			return ps;
		} catch (Exception e) {
			System.out.println("Db--getPs(2)");
		}
		return null;
	}

}