package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import model.Department;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DepartmentAddInterFrame extends JFrame {
	private JTextField depart_nameTxt;
	private JTextArea depart_descTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private DepartmentDao departmentDao=new DepartmentDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentAddInterFrame frame = new DepartmentAddInterFrame();
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
	public DepartmentAddInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
		setFont(new Font("微软雅黑", Font.PLAIN, 20));
		setTitle("部门添加");
		setBounds(100, 100, 628, 435);
		
		JLabel lblNewLabel = new JLabel("部门名称");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		depart_nameTxt = new JTextField();
		depart_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		depart_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("部门描述");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		depart_descTxt = new JTextArea();
		depart_descTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(DepartmentAddInterFrame.class.getResource("/image/注册账号.jpg")));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane()); 
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(lblNewLabel_2)
					.addContainerGap(654, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(338, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(212))
		);
		getContentPane().setLayout(groupLayout);
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(154)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1))
								.addComponent(depart_descTxt))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(depart_descTxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		this.setLocationRelativeTo(null);

	}
	
	private void departmentAddActionPerformed(ActionEvent e) {
		String depart_name=this.depart_nameTxt.getText();
		String depart_desc=this.depart_descTxt.getText();
		
		if(StringUtil.isEmpty(depart_name)) {
			JOptionPane.showMessageDialog(null, "部门名称不能为空！");
			return;
		}if(StringUtil.isEmpty(depart_desc)) {
			JOptionPane.showMessageDialog(null, "部门描述不能为空！");
			return;
		}
		
		Department department=new Department(depart_name, depart_desc);
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addnum=departmentDao.add(con, department);
			if(addnum==1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败！");
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
	 * 重置事件处理
	 */
	private void resetActionPerformed(ActionEvent e) {
		resetNull();
		// TODO 自动生成的方法存根
		
	}
	public void resetNull() {
		this.depart_nameTxt.setText("");
		this.depart_descTxt.setText("");
	}
}
