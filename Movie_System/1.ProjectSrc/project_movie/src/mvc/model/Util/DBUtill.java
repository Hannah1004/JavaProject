package mvc.model.Util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB연동을 위한  로드, 연결, 닫기 기능 클래스
 * */

public class DBUtill {
	private static Properties proFile = new Properties();
	
	/**
	 * 로드
	 * */
	static {
			try {
				/*cmd창에서 실행할때*/
				//두 개의 properties파일 로딩하기
				proFile.load(new FileInputStream("mvc/model/Util/dbInfo.properties"));
				proFile.load(new FileInputStream("mvc/model/Util/movie.properties"));
				
				/*콘솔창에서 실행할때*/
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
	 * 연결
	 * @throws SQLException 
	 * */
	public static Connection getConnection () throws SQLException{
		return DriverManager.getConnection(proFile.getProperty("url"),proFile.getProperty("userName"),proFile.getProperty("userPass"));
	}
	
	/**
	 * 닫기(update, insert, delete인 경우)
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
	 * 닫기(select인 경우)
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
