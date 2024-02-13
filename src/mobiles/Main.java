package mobiles;
import java.util.Scanner;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		DbConnection con = new DbConnection();
		System.out.println("---------	Mobile Shop Management System	---------");
		con.getMSMDbconnection();
		Login.getLogging(sc, con);
	}
}
