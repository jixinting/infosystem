package dao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Util.StringUtil;
import model.Staff;

public class staffDao {
	
	/*
	 * 基本信息录入
	 */
	public int add(Connection con, Staff staff)throws Exception{
		String sql="insert into staff_information values(null,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, staff.getStaff_name());
		pstmt.setString(2, staff.getStaff_id());
		pstmt.setString(3, staff.getSex());
		pstmt.setString(4, staff.getNation());
		pstmt.setString(5, staff.getNative_place());
		pstmt.setString(6, staff.getPolitics_status());
		pstmt.setString(7, staff.getIdNum());
		pstmt.setString(8, staff.getAddress());
		pstmt.setInt(9, staff.getDepartid());
		pstmt.setInt(10, staff.getPostid());
		pstmt.setString(11, staff.getPhoneNum());
		return pstmt.executeUpdate();
	}
	/*
	 * 员工基本信息查询
	 */
	
	public ResultSet list(Connection con, Staff staff)throws Exception{
		StringBuffer strb=new StringBuffer("select *from staff_information si, department d, post p where si.departid=d.id AND si.postid=p.id");
		if(StringUtil.isNotEmpty(staff.getStaff_name())) {
			strb.append(" and si.staff_name like '%"+staff.getStaff_name()+"%'");
		}if(StringUtil.isNotEmpty(staff.getStaff_id())) {
			strb.append(" and si.staff_id like '%"+staff.getStaff_id()+"%'");
		}if(staff.getDepartid()!=0 && staff.getDepartid()!=-1) {
			strb.append(" and si.departid="+staff.getDepartid());
		}if(staff.getPostid()!=0 && staff.getPostid()!=-1) {
			strb.append(" and si.postid="+staff.getPostid());
		}
		
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(strb.toString());
		return pstmt.executeQuery();
	}
	
	
	public Staff query(Connection con, String staff_id)throws Exception {
		Staff resultStaff=null;
		String sql="select*from staff_information where staff_id=?";

		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, staff_id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			resultStaff = new Staff();
			resultStaff.setId(rs.getInt("id"));
			resultStaff.setStaff_name(rs.getString("staff_name"));
			resultStaff.setStaff_id(rs.getString("staff_id"));
			resultStaff.setSex(rs.getString("sex"));
			resultStaff.setNation(rs.getString("nation"));
			resultStaff.setNative_place(rs.getString("native_place"));
			resultStaff.setPolitics_status(rs.getString("politics_status"));
			resultStaff.setIdNum(rs.getString("idNum"));
			resultStaff.setAddress(rs.getString("address"));
			resultStaff.setDepartid(rs.getInt("departid"));
			resultStaff.setPostid(rs.getInt("postid"));
			resultStaff.setPhoneNum(rs.getString("phoneNum"));
		}
		
		return resultStaff;
	}
	public int change(Connection con,Staff staff)throws Exception {
		String sql="update staff_information set staff_name=?,sex=?,nation=?,native_place=?,politics_status=?,idNum=?,address=?,phoneNum=? where staff_id=?";
		
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, staff.getStaff_name());
		pstmt.setString(2, staff.getSex());
		pstmt.setString(3, staff.getNation());
		pstmt.setString(4, staff.getNative_place());
		pstmt.setString(5, staff.getPolitics_status());
		pstmt.setString(6, staff.getIdNum());
		pstmt.setString(7, staff.getAddress());
		pstmt.setString(8, staff.getPhoneNum());
		pstmt.setString(9, staff.getStaff_id());
		
		return pstmt.executeUpdate();
	}
}
