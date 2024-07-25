package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.UserDao;
import model.Department;
import model.User;
import java.awt.Color;
import java.awt.SystemColor;


public class UserManagerInterFrame extends JFrame {
	private JTable user_table;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	private JTextField s_powerTxt;
	private JTextField idTxt;
	private JTextField user_nameTxt;
	private JTextField pwdTxt;
	private JTextField powerTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagerInterFrame frame = new UserManagerInterFrame();
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
	public UserManagerInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
//		setIconifiable(true);
//		setClosable(true);
		setTitle("用户信息维护");
		setBounds(100, 100, 709, 954);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("编   号");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("用户名");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		user_nameTxt = new JTextField();
		user_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		user_nameTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDeleteActionperformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("密   码");
		lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		pwdTxt = new JTextField();
		pwdTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		pwdTxt.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("权   限");
		lblNewLabel_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		powerTxt = new JTextField();
		powerTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		powerTxt.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(152)
						.addComponent(btnNewButton_1)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_2))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(48)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(powerTxt, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(idTxt))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(user_nameTxt, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(user_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(powerTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(85))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("权限");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		s_powerTxt = new JTextField();
		s_powerTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		s_powerTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(27)
					.addComponent(s_powerTxt, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(s_powerTxt)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		user_table = new JTable();
		user_table.setFillsViewportHeight(true);
		user_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				userTableMousePressed(e);
			}
		});
		user_table.setFont(new Font("宋体", Font.PLAIN, 20));
		user_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6743\u9650"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(user_table);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new User());
		this.setLocationRelativeTo(null);

	}
	private void userDeleteActionperformed(ActionEvent e) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int num=userDao.delete(con, id);
				if(num==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetNull();
					this.fillTable(new User());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败！");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		}
		
	}

	/*
	 * 修改事件处理
	 */
	private void userUpdateActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String id = this.idTxt.getText();
		String username=this.user_nameTxt.getText();
		String password=this.pwdTxt.getText();
		String power=this.powerTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(power)) {
			JOptionPane.showMessageDialog(null, "权限不能为空！");
			return;
		}
		
		User user = new User(Integer.parseInt(id), username, password, power);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int num =userDao.update(con, user);
			if(num==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetNull();
				this.fillTable(new User());
			}else {
				JOptionPane.showMessageDialog(null, "修改失败！");
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

	/*
	 * 
	 * 表格点击事件
	 */
	private void userTableMousePressed(MouseEvent e) {
		int row = this.user_table.getSelectedRow();
		this.idTxt.setText((String)this.user_table.getValueAt(row, 0));
		this.user_nameTxt.setText((String) this.user_table.getValueAt(row, 1));
		this.pwdTxt.setText((String) this.user_table.getValueAt(row, 2));
		this.powerTxt.setText((String) this.user_table.getValueAt(row, 3));
	}

	/*
	 * 
	 * 查询事件处理
	 */
	private void userSearchActionPerformed(ActionEvent e) {
		String s_power=this.s_powerTxt.getText();
		User user = new User();
		user.setPower(s_power);
		this.fillTable(user);
	}
	
	/*
	 * 初始化表格
	 */
	private void fillTable(User user) {
		DefaultTableModel dtm = (DefaultTableModel) this.user_table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=userDao.list(con, user);
			while(rs.next()) {
				Vector v=new Vector<>();
				v.add(rs.getString("id"));
				v.add(rs.getString("userName"));
				v.add(rs.getString("password"));
				v.add(rs.getString("power"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}	
		}
	}
	
	/*
	 * 置空表单
	 */
	private void resetNull() {
		this.idTxt.setText("");
		this.user_nameTxt.setText("");
		this.pwdTxt.setText("");
		this.powerTxt.setText("");
	}
}
