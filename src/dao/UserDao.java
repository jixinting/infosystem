package dao;

import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Util.StringUtil;
import model.Department;
import model.Post;
import model.Staff;
import model.User;

public class UserDao {

	public User login(Connection con, User user) throws Exception{
		User resultUser=null;
		String sql="select * from user where userName=? and password=? and power=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getPower());
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setPower(rs.getString("power"));
		 }
		return resultUser;
	}
	
	public int addUser(Connection con, User user)throws Exception{
		String sql="insert into user values(null, ?, ?, ?)";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, "员工");
		
		return pstmt.executeUpdate();
	}
	/*
	 * 查询岗位
	 */
	public ResultSet list(Connection con, User user)throws Exception{
		StringBuffer stub=new StringBuffer("select * from user");
		if(StringUtil.isNotEmpty(user.getUserName())) {
			stub.append(" and userName like '%"+user.getUserName()+"%'");
		}
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(stub.toString().replace("and", "where"));
		return pstmt.executeQuery();
	}
	/*
	 * 
	 * 删除部门
	 */
	public int delete(Connection con, String id) throws Exception{
		String sql="delete from user where id=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/*
	 * 修改部门
	 */
	public int update(Connection con, User user)throws Exception{
		String sql="update user set userName=? ,password=? , power=? where id=?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getPower());
		pstmt.setInt(4, user.getId());
		return pstmt.executeUpdate();
	}
	
	public int change(Connection con,User user)throws Exception {
		String sql="update user set userName=? ,password=?  where id=?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setInt(3, user.getId());
		return pstmt.executeUpdate();
	}
	
	public int Change(Connection con,User user)throws Exception {
		String sql="update user set password=?  where userName=?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getUserName());
		return pstmt.executeUpdate();
	}
	
	public User query(Connection con, String username)throws Exception {
		User resultUser=null;
		String sql="select*from user where userName=?";

		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			resultUser = new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}
}
