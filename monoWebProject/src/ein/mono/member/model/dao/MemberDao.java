package ein.mono.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ein.mono.common.JDBCTemplate;
import ein.mono.member.model.vo.MemberVo;

public class MemberDao {

	public int joinMember(Connection con, MemberVo member, String mRank) {
		//회원가입
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		
		switch(mRank) {
		
		case "1":
			query = "INSERT INTO MEMBER "+
							"VALUES('B'||SEQ_MCODE.NEXTVAL, DEFAULT, ?,?,?,?,?,?,?,DEFAULT,DEFAULT)";
			break;
			
		case "2":
			query = "INSERT INTO MEMBER "+
					"VALUES('C'||SEQ_MCODE.NEXTVAL, DEFAULT, ?,?,?,?,?,?,?,DEFAULT,DEFAULT)";
	break;
		}
		
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberEmail());
			pstmt.setString(5, member.getMemberAddress());
			pstmt.setString(6, member.getMemberTel());
			pstmt.setString(7, member.getMemberNname());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MemberVo loginMember(Connection con, String id) {

		/*MemberVo result = null;//로그인
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		
		query = "SELECT *\r\n" + 
				"FROM MEMBER\r\n" + 
				"WHERE MEMBER_ID = '?'";
		System.out.println(id);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery(query);
			
			if(rs.next()) {
				
				result = new MemberVo();
				
				result.setMemberCode(rs.getString("memberCode"));
				result.setMemberType(rs.getString("memberType"));
				result.setMemberRank(rs.getString("memberRank"));
				result.setMemberId(id);
				result.setMemberPwd(rs.getString("memberPwd"));
				result.setMemberName(rs.getString("memberName"));
				result.setMemberEmail(rs.getString("memberEmail"));
				result.setMemberAddress(rs.getString("memberAddress"));
				result.setMemberTel(rs.getString("memberTel"));
				result.setMemberNickname(rs.getString("memberNickname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;*/
		
		MemberVo result = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			
			String query = "SELECT *\r\n" + 
					"FROM MEMBER\r\n" + 
					"WHERE MEMBER_ID = '"+id+"'";
			
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				
				
				result = new MemberVo();
				result.setMemberCode(rs.getString("MEMBER_CODE"));
				result.setMemberRank(rs.getString("MEMBER_RANK"));
				result.setMemberId(id);
				result.setMemberPwd(rs.getString("MEMBER_PWD"));
				result.setMemberName(rs.getString("MEMBER_NAME"));
				result.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				result.setMemberAddress(rs.getString("MEMBER_ADDRESS"));
				result.setMemberTel(rs.getString("MEMBER_TEL"));
				result.setMemberNname(rs.getString("MEMBER_NNAME"));
				result.setMemberJdate(rs.getDate("MEMBER_JDATE"));
				result.setDelflag(rs.getString("DELFLAG"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);					
		}
		
		return result;
	}
	

	public int updateMember(Connection con, MemberVo member) {
		
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		
		query = "UPDATE MEMBER SET "+
		"MEMBER_PWD = ? WHERE MEMBER_ID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberId());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;//회원정보수정
	}

	public int deleteMember(Connection con, MemberVo member) {
		
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		
		query = "UPDATE MEMBER SET DELFLAG = 'Y' WHERE MEMBER_ID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;//회원삭제
		
		/*MemberVo result = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			
			String query = "UPDATE MEMBER SET DELFLAG = 'Y' WHERE MEMBER_ID = '"+id+"'";
			
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				result = new MemberVo();
				result.setMemberCode(rs.getString("MEMBER_CODE"));
				result.setMemberType(rs.getString("MEMBER_TYPE"));
				result.setMemberRank(rs.getString("MEMBER_RANK"));
				result.setMemberId(id);
				result.setMemberPwd(rs.getString("PASSWORD"));
				result.setMemberName(rs.getString("NAME"));
				result.setMemberEmail(rs.getString("EMAIL"));
				result.setMemberAddress(rs.getString("ADDRESS"));
				result.setMemberTel(rs.getString("TEL"));
				result.setMemberNickname(rs.getString("NICKNAME"));
				result.setMemberJoinDate(rs.getDate("JOIN_DATE"));
				result.setDelflag(rs.getString("DELFLAG"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);	
		}
		
		return result;*/
		
	}

}
