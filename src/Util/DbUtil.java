package Util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/*
 * 
 * 连接数据库
 */

public class DbUtil {
	
	private String dbUrl= "jdbc:mysql://localhost:3306/info_system";		//数据库地址
	private String dbUserName = "root";		//用户名
	private String dbPassword="123456";		//密码
	private String jdbcName="com.mysql.jdbc.Driver";	//驱动器名称
	
	/**
	 * 
	 * 获取数据库连接
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=(Connection) DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * 
	 * 关闭数据库
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if(con !=null) {
			con.close();
		}	
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}	
	}
}

