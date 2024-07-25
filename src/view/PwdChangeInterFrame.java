package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import dao.PostDao;
import dao.UserDao;
import dao.staffDao;
import model.Department;
import model.Post;
import model.Staff;
import model.User;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class PwdChangeInterFrame extends JFrame {
	private JTextField user_nameTxt;
	private JTextField pwd_idTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private DbUtil dbUtil=new DbUtil();
	private DepartmentDao departmentDao=new DepartmentDao();
	private PostDao postDao = new PostDao();
	private staffDao staffDao=new staffDao();
	private UserDao userDao=new UserDao();

	private String user_name;
	private String password;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_2;
	private JTextField newpwdTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PwdChangeInterFrame frame = new PwdChangeInterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PwdChangeInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
		setTitle("修改密码");
		setBounds(100, 100, 479, 355);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		user_nameTxt = new JTextField();
		user_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		user_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("原密码");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		pwd_idTxt = new JTextField();
		pwd_idTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		pwd_idTxt.setColumns(10);
		
		btnNewButton_3 = new JButton("修改密码");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepwdActionPerformed(e);
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		lblNewLabel_2 = new JLabel("新密码");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		newpwdTxt = new JTextField();
		newpwdTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		newpwdTxt.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(96)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(user_nameTxt, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(newpwdTxt)
								.addComponent(pwd_idTxt))))
					.addGap(93))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(user_nameTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(pwd_idTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(newpwdTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		getContentPane().setLayout(groupLayout);

		this.setLocationRelativeTo(null);
	}
	

	protected void changepwdActionPerformed(ActionEvent e) {
		String n_pwd=newpwdTxt.getText();
		if(n_pwd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "新密码不得为空！");
		}else {
			if(password.equals(pwd_idTxt.getText())) {
				SetInfo();
			}
		}
	}

	void init(String username)
	{
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.query(con, username);
			if(currentUser!=null) {
				this.user_name=currentUser.getUserName();
				this.password=currentUser.getPassword();
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	void SetInfo() {
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			User currentUser=new User();
			currentUser.setUserName(user_nameTxt.getText());
			currentUser.setPassword(newpwdTxt.getText());
			
			int flag = userDao.Change(con, currentUser);
			if(flag==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
			}
			else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	void Data() {
		user_nameTxt.setText(this.user_name);
	}
	
	void SetUnEdit() {
		user_nameTxt.setEditable(false);
	}
}
