package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import dao.staffDao;
import model.Staff;

public class UserMainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;
	private DbUtil dbUtil = new DbUtil();
	private staffDao staffDao = new staffDao();
	
	private String staff_name;
	private String staff_id;
	private String sex;
	private String nation;
	private String native_place;
	private String politics_status;
	private String idNum;
	private String address;
	private String phoneNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainFrame frame = new UserMainFrame();
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
	public UserMainFrame() {
		setBackground(new Color(240, 240, 240));
		setTitle("员工信息管理系统V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 709);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("设置");
		mnNewMenu_3.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("修改密码");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PwdChangeInterFrame pwdChangeInterFrame = new PwdChangeInterFrame();
				pwdChangeInterFrame.init(staff_id);
				pwdChangeInterFrame.Data();
				pwdChangeInterFrame.SetUnEdit();
				pwdChangeInterFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_10.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("退出系统");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_11.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu = new JMenu("个人信息管理");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("个人信息维护");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfoInterFrame myInfoInterFrame=new MyInfoInterFrame();
				myInfoInterFrame.init(staff_id);
				myInfoInterFrame.Data();
				myInfoInterFrame.SetUnEdit();
				myInfoInterFrame.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel((String) null);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblNewLabel.setIcon(new ImageIcon(UserMainFrame.class.getResource("/image/注册账号.jpg")));
		contentPane.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
	}
	void init(String staffid)
	{
		Connection con=null;
		try {
			con=dbUtil.getCon();
			Staff currentStaff=staffDao.query(con, staffid);
			if(currentStaff!=null) {
				this.staff_id=staffid;

			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}