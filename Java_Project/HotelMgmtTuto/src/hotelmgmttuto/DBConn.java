package hotelmgmttuto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
                        System.out.println("DB suck");
		} catch(Exception e) {
			System.out.println("DBERROR1"+e.getMessage());
		}
	}
	String sql = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String dbURL="jdbc:mysql://localhost:3306/HotelDb";
        String dbID="root";
        String dbPW="eksldpf1!";
			
	public DBConn() {}
	public void getConn() {
		try {
			conn = DriverManager.getConnection(dbURL,dbID,dbPW);
		}catch(Exception e) {
			System.out.println("DB연결 ERROR"+e.getMessage());
		}
	}
	public void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			System.out.println("DB종료가 실패하였습니다."+e.getMessage());
		}
	}
}