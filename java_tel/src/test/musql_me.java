package test;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class musql_me {
	
static String url ="jdbc:mysql://127.0.0.1:3306/test";
static String name ="root";
static String passwrod = "root";


public static void main(String args[]) throws ClassNotFoundException, SQLException
{

	mysqlQ();

}




public static void insertmysql(String row1,String row2) throws Exception
{

	Class.forName("com.mysql.jdbc.Driver");
	String sql = " insert into username(pname,pass) value('"+row1+"','"+row2+"');";
	Connection conn = (Connection) DriverManager.getConnection(url,name,passwrod);
	Statement stmt = conn.createStatement();
	int rows = stmt.executeUpdate(sql);
	if (rows > 0) {
		System.out.println("您增加了" + rows + "行数据");
	}
}

public static void mysqlQ() throws ClassNotFoundException, SQLException
{
	String name = "sdf";
	Class.forName("com.mysql.jdbc.Driver");
	String sql = " select pass from username where pname='"+name+"';";
	System.out.println("");
	Connection conn = (Connection) DriverManager.getConnection(url,name,passwrod);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		String qid = rs.getString("pass");
		System.out.println(qid + "\t");
	}
	rs.close();
	stmt.close();
	conn.close();
}
	
	
	
	
}
