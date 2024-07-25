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
import dao.staffDao;
import model.User;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private JComboBox powerJCB;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);
		setTitle("员工信息管理系统V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, -35, 686, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(80, 161, 72, 30);
		contentPane.add(lblNewLabel_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		userNameTxt.setBackground(new Color(255, 255, 255));
		userNameTxt.setBounds(173, 153, 432, 52);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("密码");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(80, 256, 72, 30);
		contentPane.add(lblNewLabel_1_1);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		passwordTxt.setBounds(173, 245, 432, 52);
		contentPane.add(passwordTxt);
		
		JLabel lblNewLabel_1_2 = new JLabel("权限");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(80, 346, 72, 30);
		contentPane.add(lblNewLabel_1_2);
		
		powerJCB = new JComboBox();
		powerJCB.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		powerJCB.setModel(new DefaultComboBoxModel(new String[] {"员工", "管理员"}));
		powerJCB.setBounds(173, 335, 200, 52);
		contentPane.add(powerJCB);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}

		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		btnNewButton.setBounds(80, 417, 525, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("立即注册");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_1.setBounds(485, 498, 120, 30);
		contentPane.add(btnNewButton_1);
	
		
		JLabel lblNewLabel_2 = new JLabel("登陆界面");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("优设标题黑", Font.PLAIN, 40));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(279, 57, 169, 61);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/OR68V80.jpg")));
		lblNewLabel.setBounds(10, 10, 1366, 768);
		contentPane.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
		
	}
	
	private void loginActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		String power=null;
		String juris=(String) this.powerJCB.getSelectedItem();
		User user=new User(userName, password, power);
		Connection con=null;
		if(juris.equals("管理员")) {
			user.setPower("管理员");
			try {
				con=dbUtil.getCon();
				User currentUser=userDao.login(con, user);
				if(currentUser!=null) {
					dispose();
					new AdminMainFrame().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
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
		}else if(juris.equals("员工")) {
			user.setPower("员工");
			try {
				con=dbUtil.getCon();
				User currentUser=userDao.login(con, user);
				if(currentUser!=null) {
					dispose();
					UserMainFrame userMainFrame=new UserMainFrame();
					userMainFrame.setVisible(true);
					String idString=currentUser.getUserName();
					userMainFrame.init(idString);
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
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
		}
	}
}
