package hotelmgmttuto;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBConn{

	public UserDAO() {}
	// 회원가입 db insert
	public int SignUpInsert(UserVO vo) {
		int result = 0;
		try{
			getConn();
			sql = "insert into user(userMail, userPW, userName, userPhone)values(?,?,?,?)";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserMail());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserPhone());
			System.out.println("dbAll.UserDAO.SignUpInsert()");
			
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			dbClose();
		}
		return result;
	}
	// 회원 아이디 비밀번호 검색, 회원 유무 확인
	public List<UserVO> getidCheck(String userMail){
		List<UserVO> lst = new ArrayList<UserVO>();		
		try {
			getConn();
			sql = "select userMail from user where userMail = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userMail);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO("","","","");
				vo.setUserMail(rs.getString(1));
				
				lst.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return lst;
	}
            
        
            public List<UserVO> getUserByEmailAndPassword(String userMail, String userPW) {
        List<UserVO> userList = new ArrayList<>();
        try {
            getConn();
            sql = "select * from user where userMail = ? and userPW = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userMail);
            pstmt.setString(2, userPW);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserVO vo = new UserVO("","","","");
                vo.setUserMail(rs.getString("userMail"));
                vo.setUserPW(rs.getString("userPW"));
                vo.setUserName(rs.getString("userName"));
                vo.setUserPhone(rs.getString("userPhone"));

                userList.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }

        return userList;
    }
}