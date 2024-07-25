package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrame frame = new AdminMainFrame();
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
	public AdminMainFrame() {
		setBackground(new Color(240, 240, 240));
		setTitle("员工信息管理系统V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 709);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("部门管理");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("部门添加");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentAddInterFrame departmentAddInterFrame=new DepartmentAddInterFrame();
				departmentAddInterFrame.setVisible(true);
//				table.add(departmentAddInterFrame);
			}
		});
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("部门维护");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentManagerInterFrame departmentManagerInterFrame=new DepartmentManagerInterFrame();
				departmentManagerInterFrame.setVisible(true);
				//table.add(departmentManagerInterFrame);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("岗位添加");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostAddInterFrame postAddInterFrame=new PostAddInterFrame();
				postAddInterFrame.setVisible(true);
				//table.add(departmentManagerInterFrame);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("岗位维护");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostManagerInterFrame postManagerInterFrame=new PostManagerInterFrame();
				postManagerInterFrame.setVisible(true);
				//table.add(departmentManagerInterFrame);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("员工信息管理");
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("基本信息录入");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffAddInterFrame staffAddInterFrame=new StaffAddInterFrame();
				staffAddInterFrame.setVisible(true);
				//table.add(departmentManagerInterFrame);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("基本信息维护");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffManagerInterFrame staffManagerInterFrame=new StaffManagerInterFrame();
				staffManagerInterFrame.setVisible(true);
				//table.add(departmentManagerInterFrame);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("用户管理");
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("用户添加");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAddInterFrame userAddInterFrame=new UserAddInterFrame();
				userAddInterFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("用户维护");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagerInterFrame userManagerInterFrame=new UserManagerInterFrame();
				userManagerInterFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_3 = new JMenu("设置");
		mnNewMenu_3.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("退出系统");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame loginFrame=new LoginFrame();
				loginFrame.setVisible(true);
			}
		});
		mntmNewMenuItem_11.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mnNewMenu_3.add(mntmNewMenuItem_11);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		final JLabel background = new JLabel();
		background.setFont(new Font("SimSun", Font.PLAIN, 12));
		background.setBackground(new Color(240, 240, 240));
		URL resource = this.getClass().getResource("/image/back.jpg");
		final ImageIcon icon=new ImageIcon(resource); 
		
		icon.setImage(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		background.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/image/back.jpg")));
		background.setBounds(-345, -12, this.getWidth(), this.getHeight());
		table.add(background, new Integer(Integer.MIN_VALUE));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/image/注册账号.jpg")));
		contentPane.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
	}
}