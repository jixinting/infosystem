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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.PostDao;
import model.Department;
import model.Post;
import java.awt.Color;
import java.awt.SystemColor;


public class PostManagerInterFrame extends JFrame {
	private JTable post_table;
	private DbUtil dbUtil = new DbUtil();
	private PostDao postDao = new PostDao();
	private JTextField s_post_nameTxt;
	private JTextField idTxt;
	private JTextField post_nameTxt;
	private JTextArea post_descTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostManagerInterFrame frame = new PostManagerInterFrame();
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
	public PostManagerInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
//		setIconifiable(true);
//		setClosable(true);
		setTitle("岗位维护");
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
		
		JLabel lblNewLabel_1 = new JLabel("编号");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("岗位名称");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		post_nameTxt = new JTextField();
		post_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		post_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("岗位描述");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		post_descTxt = new JTextArea();
		post_descTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postDeleteActionperformed(e);
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
									.addComponent(post_nameTxt, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(post_descTxt)))))
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
						.addComponent(post_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(post_descTxt, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("岗位名称");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		s_post_nameTxt = new JTextField();
		s_post_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		s_post_nameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postSearchActionPerformed(e);
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
					.addComponent(s_post_nameTxt, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(s_post_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		post_table = new JTable();
		post_table.setFillsViewportHeight(true);
		post_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				postTableMousePressed(e);
			}
		});
		post_table.setFont(new Font("宋体", Font.PLAIN, 20));
		post_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5C97\u4F4D\u540D\u79F0", "\u5C97\u4F4D\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(post_table);
		getContentPane().setLayout(groupLayout);
		this.setLocationRelativeTo(null);
		this.fillTable(new Post());

	}
	private void postDeleteActionperformed(ActionEvent e) {
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
				int num=postDao.delete(con, id);
				if(num==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetNull();
					this.fillTable(new Post());
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
	private void postUpdateActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String id = this.idTxt.getText();
		String post_name=this.post_nameTxt.getText();
		String post_desc=this.post_descTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(post_name)) {
			JOptionPane.showMessageDialog(null, "部门名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(post_desc)) {
			JOptionPane.showMessageDialog(null, "部门描述不能为空！");
			return;
		}
		
		Post post = new Post(Integer.parseInt(id), post_name, post_desc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int num =postDao.update(con, post);
			if(num==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetNull();
				this.fillTable(new Post());
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
	private void postTableMousePressed(MouseEvent e) {
		int row = this.post_table.getSelectedRow();
		this.idTxt.setText((String)this.post_table.getValueAt(row, 0));
		this.post_nameTxt.setText((String) this.post_table.getValueAt(row, 1));
		this.post_descTxt.setText((String) this.post_table.getValueAt(row, 2));
	}

	/*
	 * 
	 * 查询事件处理
	 */
	private void postSearchActionPerformed(ActionEvent e) {
		String s_post_name=this.s_post_nameTxt.getText();
		Post post = new Post();
		post.setPost_name(s_post_name);
		this.fillTable(post);
	}
	
	/*
	 * 初始化表格
	 */
	private void fillTable(Post post) {
		DefaultTableModel dtm = (DefaultTableModel) this.post_table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=postDao.list(con, post);
			while(rs.next()) {
				Vector v=new Vector<>();
				v.add(rs.getString("id"));
				v.add(rs.getString("post_name"));
				v.add(rs.getString("post_desc"));
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
		this.post_nameTxt.setText("");
		this.post_descTxt.setText("");
	}
}
