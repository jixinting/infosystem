package dao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Util.StringUtil;
import model.Post;

public class PostDao {
	/*
	 * 
	 * 岗位添加
	 */
	public int add(Connection con, Post post)throws Exception{
		String sql="Insert into post values(null, ?, ?)";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, post.getPost_name());
		pstmt.setString(2, post.getPost_desc());
		return pstmt.executeUpdate();
	}
	/*
	 * 查询岗位
	 */
	public ResultSet list(Connection con, Post post)throws Exception{
		StringBuffer stub=new StringBuffer("select * from post");
		if(StringUtil.isNotEmpty(post.getPost_name())) {
			stub.append(" and post_name like '%"+post.getPost_name()+"%'");
		}
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(stub.toString().replace("and", "where"));
		return pstmt.executeQuery();
	}
	/*
	 * 删除岗位
	 */
	public int delete(Connection con, String id) throws Exception{
		String sql = "delete from post where id=?";
		PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/*
	 * 修改岗位
	 */
	public int update(Connection con, Post post)throws Exception{
		String sql = "update post set post_name=? ,post_desc=? where id=?";
		PreparedStatement pstmt =(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, post.getPost_name());
		pstmt.setString(2, post.getPost_desc());
		pstmt.setInt(3, post.getId());
		return pstmt.executeUpdate();
	}
}
