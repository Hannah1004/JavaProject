package mvc.model.Util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB������ ����  �ε�, ����, �ݱ� ��� Ŭ����
 * */

public class DBUtill {
	private static Properties proFile = new Properties();
	
	/**
	 * �ε�
	 * */
	static {
			try {
				/*cmdâ���� �����Ҷ�*/
				//�� ���� properties���� �ε��ϱ�
				proFile.load(new FileInputStream("mvc/model/Util/dbInfo.properties"));
				proFile.load(new FileInputStream("mvc/model/Util/movie.properties"));
				
				/*�ܼ�â���� �����Ҷ�*/
//				proFile.load(new FileInputStream("src/mvc/model/Util/dbInfo.properties"));
//				proFile.load(new FileInputStream("src/mvc/model/Util/movie.properties"));
				
				Class.forName(proFile.getProperty("driverName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	/**
	 * ����
	 * @throws SQLException 
	 * */
	public static Connection getConnection () throws SQLException{
		return DriverManager.getConnection(proFile.getProperty("url"),proFile.getProperty("userName"),proFile.getProperty("userPass"));
	}
	
	/**
	 * �ݱ�(update, insert, delete�� ���)
	 * */
	public static void dbClose(Statement st, Connection con) {
		try {
			if(st!=null) st.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ݱ�(select�� ���)
	 * */
	public static void dbClose(ResultSet rs, Statement st, Connection con ) {
		try {
			if(rs!=null) rs.close();
			dbClose(st, con);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	}
}
