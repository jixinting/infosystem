package view;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;


public class DepartmentManagerInterFrame extends JFrame {
	private JTable depart_table;
	private DbUtil dbUtil = new DbUtil();
	private DepartmentDao departmentDao = new DepartmentDao();
	private JTextField s_depart_nameTxt;
	private JTextField idTxt;
	private JTextField depart_nameTxt;
	private JTextArea depart_descTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagerInterFrame frame = new DepartmentManagerInterFrame();
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
	public DepartmentManagerInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
//		setIconifiable(true);
//		setClosable(true);
		setTitle("部门维护");
		setBounds(100, 100, 712, 957);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(244, 247, 252));
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
		
		JLabel lblNewLabel_1 = new JLabel("编号");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("部门名称");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		depart_nameTxt = new JTextField();
		depart_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		depart_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("部门描述");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		depart_descTxt = new JTextArea();
		depart_descTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentDeleteActionperformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(246)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(depart_descTxt)))))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(depart_descTxt, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("部门名称");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		s_depart_nameTxt = new JTextField();
		s_depart_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		s_depart_nameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentSearchActionPerformed(e);
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
					.addComponent(s_depart_nameTxt, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(s_depart_nameTxt)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		depart_table = new JTable();
		depart_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		depart_table.setFillsViewportHeight(true);
		depart_table.setToolTipText("");
		depart_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				departTableMousePressed(e);
			}
		});
		depart_table.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		depart_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u90E8\u95E8\u540D\u79F0", "\u90E8\u95E8\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(depart_table);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Department());
		
		this.setLocationRelativeTo(null);

	}
	private void departmentDeleteActionperformed(ActionEvent e) {
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
				int num=departmentDao.delete(con, id);
				if(num==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetNull();
					this.fillTable(new Department());
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
	private void departmentUpdateActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String id = this.idTxt.getText();
		String depart_name=this.depart_nameTxt.getText();
		String depart_desc=this.depart_descTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(depart_name)) {
			JOptionPane.showMessageDialog(null, "部门名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(depart_desc)) {
			JOptionPane.showMessageDialog(null, "部门描述不能为空！");
			return;
		}
		
		Department department = new Department(Integer.parseInt(id), depart_name, depart_desc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int num =departmentDao.update(con, department);
			if(num==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetNull();
				this.fillTable(new Department());
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
	private void departTableMousePressed(MouseEvent e) {
		int row = this.depart_table.getSelectedRow();
		this.idTxt.setText((String)this.depart_table.getValueAt(row, 0));
		this.depart_nameTxt.setText((String) this.depart_table.getValueAt(row, 1));
		this.depart_descTxt.setText((String) this.depart_table.getValueAt(row, 2));
	}

	/*
	 * 
	 * 查询事件处理
	 */
	private void departmentSearchActionPerformed(ActionEvent e) {
		String s_depart_name=this.s_depart_nameTxt.getText();
		Department department = new Department();
		department.setDepart_name(s_depart_name);
		this.fillTable(department);
	}
	
	/*
	 * 初始化表格
	 */
	private void fillTable(Department department) {
		DefaultTableModel dtm = (DefaultTableModel) this.depart_table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=departmentDao.list(con, department);
			while(rs.next()) {
				Vector v=new Vector<>();
				v.add(rs.getString("id"));
				v.add(rs.getString("depart_name"));
				v.add(rs.getString("depart_desc"));
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
		this.depart_nameTxt.setText("");
		this.depart_descTxt.setText("");
	}
}
