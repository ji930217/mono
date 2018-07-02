package ein.mono.profil.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ein.mono.common.JDBCTemplate;
import ein.mono.profil.model.vo.ProfilVo;

public class ProfilDao {

	public ArrayList<ProfilVo> selectProfilList(Connection con, int currentPage,int limit) {
		
		ArrayList<ProfilVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "쿼리작성";
			
			pstmt = con.prepareStatement(query);
			
			int stratRow = (currentPage-1)*limit+1;  
			int endRow = stratRow+limit-1;
			
			pstmt.setInt(1, stratRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<ProfilVo>();
			
			ProfilVo temp = null;
			
			while(rs.next()) {
				temp = new ProfilVo();
				//저장한값 담기
				
				list.add(temp);
			}
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//5. 자원반납
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	}
		
		return list;
	}

	public int updateProfil(Connection con, ProfilVo profil) {
		int result = 0;
		return result;
	}

	public int selectprofilTotalCount(Connection con) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "+
			"FROM PROFIL "+
			"WHERE PTN_APP !='N'";
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				result = rs.getInt("listcount");
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

}
