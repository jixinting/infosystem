package model;

public class User {
	
	private int id;
	private String usrName;
	private String password;
	private String power;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return usrName;
	}
	public void setUserName(String usrName) {
		this.usrName = usrName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public User(String usrName, String password, String power) {
		super();
		this.usrName = usrName;
		this.password = password;
		this.power = power;
	}
	public User(String usrName, String password) {
		super();
		this.usrName = usrName;
		this.password = password;
	}
	public User(int id, String usrName, String password, String power) {
		super();
		this.id = id;
		this.usrName = usrName;
		this.password = password;
		this.power = power;
	}
	
	
}
