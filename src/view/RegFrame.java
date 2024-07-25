package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.UserDao;
import model.User;

public class RegFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao = new UserDao();
	private JPasswordField re_passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFrame frame = new RegFrame();
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
	public RegFrame() {
		setResizable(false);
		setTitle("员工信息管理系统V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("账      号");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(269, 166, 136, 52);
		contentPane.add(lblNewLabel_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		userNameTxt.setBounds(426, 166, 432, 52);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("密      码");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(269, 258, 136, 52);
		contentPane.add(lblNewLabel_1_1);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		passwordTxt.setBounds(426, 258, 432, 52);
		contentPane.add(passwordTxt);
		
		JButton btnNewButton_1 = new JButton("立即注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		btnNewButton_1.setBounds(269, 442, 589, 52);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("确认密码");
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(269, 348, 136, 51);
		contentPane.add(lblNewLabel_1_1_1);
		
		re_passwordTxt = new JPasswordField();
		re_passwordTxt.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		re_passwordTxt.setBounds(426, 347, 432, 52);
		contentPane.add(re_passwordTxt);
		
		
		JLabel lblNewLabel_2 = new JLabel("欢迎注册员工管理系统！");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		lblNewLabel_2.setBounds(269, 67, 457, 89);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegFrame.class.getResource("/image/注册账号.jpg")));
		lblNewLabel.setBounds(10, 10, 1110, 709);
		contentPane.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
	}
	
	/*
	 * 
	 * 注册事件处理
	 */
	private void regActionPerformed(ActionEvent e) {
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		String re_password=new String(this.re_passwordTxt.getPassword());
		
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "账号不能为空！");
			return;
		}if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}if(StringUtil.isEmpty(re_password)) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空！");
			return;
		}if(password.equals(re_password)) {
			Connection con=null;
			User user=new User(userName, password);
			
			try {
				con=dbUtil.getCon();
				int addnum=userDao.addUser(con, user);
				if(addnum==1) {
					JOptionPane.showMessageDialog(null, "注册成功！");
				}else {
					JOptionPane.showMessageDialog(null, "注册失败！");
				}
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "两次密码不一致！");
			return;
		}
	}
}
