package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import dao.UserDao;
import dao.staffDao;
import model.User;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserAddInterFrame extends JFrame {
	private JTextField user_nameTxt;
	private JTextField user_pwdTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private DbUtil dbUtil=new DbUtil();
	private DepartmentDao departmentDao=new DepartmentDao();
	private UserDao userDao = new UserDao();
	private staffDao staffDao=new staffDao();
	private JTextField quanTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInterFrame frame = new UserAddInterFrame();
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
	public UserAddInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
		setTitle("基本信息录入");
		setBounds(100, 100, 673, 309);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		user_nameTxt = new JTextField();
		user_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		user_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		user_pwdTxt = new JTextField();
		user_pwdTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		user_pwdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAddActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValues();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("权限");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		quanTxt = new JTextField();
		quanTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		quanTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(38)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(quanTxt, 0, 0, Short.MAX_VALUE)
								.addComponent(user_nameTxt, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
							.addGap(51)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(user_pwdTxt, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(user_nameTxt, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(user_pwdTxt, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(quanTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocationRelativeTo(null);
		
	}
	
	private void userAddActionPerformed(ActionEvent e) {
		String user_name=this.user_nameTxt.getText();
		String user_pwd=this.user_pwdTxt.getText();
		String quan=this.quanTxt.getText();
		
		if(StringUtil.isEmpty(user_name)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(user_pwd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(quan)) {
			JOptionPane.showMessageDialog(null, "权限不能为空！");
			return;
		}
		
		
		User user=new User(user_name, user_pwd, quan);
		
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			int addnum=userDao.addUser(con, user);
			if(addnum==1) {
				JOptionPane.showMessageDialog(null, "用户添加成功！");
				resetValues();
			}else {
				JOptionPane.showMessageDialog(null, "用户添加失败！");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
	}

	/*
	 * 重置表单
	 */
	private void resetValues() {
		this.user_nameTxt.setText("");
		this.user_pwdTxt.setText("");
		this.quanTxt.setText("");
	}
}
