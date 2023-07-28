import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleCon
{
	public static void main(String[] a)
	{
	try
	    {	
		Class.forName("jdbc.jmysql://localhost:3306/jdbc");//dynamicly load this driver by using class name.
		Connection con=DrivereManager.getConnection ("jdbc:mysql://localhost:3306/jdbc");//("jdbc:orcle:thin:@localhost:1521:xe","system","oracle");//thin(tyoe 4 driver)//XE express edition
		Statemet stmt=con.createStatement();       //("jdbc:mysql://localhost:3306/jdbc")//statment shows where actuall query runs
		ResultSet rs=stmt.executeQuery("select*from emp");
		
		while(rs.next())

		System.out.println(rs.getInt(1)+" "+rs.getString(2)+"rs.getString(3)");
		con.close();
	    }catch(Exception e){System.out.println(e);}
	}
}