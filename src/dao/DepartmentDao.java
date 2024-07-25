package dao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Util.StringUtil;
import model.Department;

public class DepartmentDao {
	
	/*
	 * 部门类别添加
	 */
	public int add(Connection con, Department department)throws Exception{
		String sql="insert into department values(null, ?, ?)";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, department.getDepart_name());
		pstmt.setString(2, department.getDepart_desc());
		return pstmt.executeUpdate();
	}
	
	/*
	 * 
	 * 查询部门
	 */
	public ResultSet list(Connection con, Department department)throws Exception{
		StringBuffer strb=new StringBuffer("select * from department");
		
		if(StringUtil.isNotEmpty(department.getDepart_name())) {
			strb.append(" and depart_name like '%"+department.getDepart_name()+"%'");
		}
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(strb.toString().replace("and", "where"));
		return pstmt.executeQuery();
	}
	/*
	 * 
	 * 删除部门
	 */
	public int delete(Connection con, String id) throws Exception{
		String sql="delete from department where id=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/*
	 * 修改部门
	 */
	public int update(Connection con, Department department)throws Exception{
		String sql="update department set depart_name=? ,depart_desc=? where id=?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, department.getDepart_name());
		pstmt.setString(2, department.getDepart_desc());
		pstmt.setInt(3, department.getId());
		return pstmt.executeUpdate();
	}
}
