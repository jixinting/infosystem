package view;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import dao.DepartmentDao;
import dao.PostDao;
import dao.staffDao;
import model.Department;
import model.Post;
import model.Staff;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class StaffManagerInterFrame extends JFrame {
	private JTable stafftable;
	
	private DbUtil dbUtil=new DbUtil();
	private DepartmentDao departmentDao=new DepartmentDao();
	private PostDao postDao = new PostDao();
	private staffDao staffDao=new staffDao();
	private JTextField s_staff_nameTxt;
	private JTextField s_staff_idTxt;
	private JComboBox<Department> s_departjcb;
	private JComboBox<Post> s_postjcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffManagerInterFrame frame = new StaffManagerInterFrame();
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
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
	public StaffManagerInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
		setTitle("基本信息维护");
		setBounds(100, 100, 850, 553);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(276, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		s_staff_nameTxt = new JTextField();
		s_staff_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("工号");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		s_staff_idTxt = new JTextField();
		s_staff_idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("部门");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		s_departjcb = new JComboBox();
		s_departjcb.setFont(new Font("宋体", Font.PLAIN, 20));
		s_departjcb.setToolTipText("");
		
		JLabel lblNewLabel_3 = new JLabel("岗位");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		s_postjcb = new JComboBox();
		s_postjcb.setToolTipText("");
		s_postjcb.setFont(new Font("宋体", Font.PLAIN, 20));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_staff_nameTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_staff_idTxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_departjcb, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_postjcb, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_staff_nameTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_staff_idTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_departjcb, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(s_postjcb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(23))
		);
		panel.setLayout(gl_panel);
		
		stafftable = new JTable();
		stafftable.setFont(new Font("宋体", Font.PLAIN, 18));
		stafftable.setFillsViewportHeight(true);
		stafftable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u5DE5\u53F7", "\u6027\u522B", "\u6C11\u65CF", "\u7C4D\u8D2F", "\u653F\u6CBB\u9762\u8C8C", "\u8EAB\u4EFD\u8BC1\u53F7", "\u90E8\u95E8", "\u7535\u8BDD", "\u5C97\u4F4D", "\u5730\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(stafftable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Staff());
		this.filljcb("search");
		this.setLocationRelativeTo(null);
	}
	/*
	 * 查询事件处理
	 */
	private void staffSearchActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String staff_name=this.s_staff_nameTxt.getText();
		String staff_id=this.s_staff_idTxt.getText();
		Post post=(Post) this.s_postjcb.getSelectedItem();
		Department department=(Department) this.s_departjcb.getSelectedItem();
		
		int departid=department.getId();
		int postid=post.getId();
		
		System.out.println(department.getDepart_name());
		System.out.println(department.getId());
		System.out.println(department.getDepart_desc());
		System.out.println(post.getPost_name());
		System.out.println(post.getId());
		System.out.println(post.getPost_desc());
		
		Staff staff=new Staff(staff_name,staff_id, departid, postid);
//		this.filljcb("search");
		this.fillTable(staff);
	}

	/*
	 * 初始化下拉框
	 */
	private void filljcb(String type) {
		Connection con=null;
		Department department=null;
		Post post= null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=departmentDao.list(con, new Department());
			ResultSet rs1=postDao.list(con, new Post());
			if("search".equals(type)) {
				department=new Department();
				post = new Post();
				department.setDepart_name("请选择...");
				post.setPost_name("请选择...");
				department.setId(-1);
				post.setId(-1);
				this.s_departjcb.addItem(department);
				this.s_postjcb.addItem(post);
			}
			while(rs.next()) {
				department = new Department();
				department.setDepart_name(rs.getString("depart_name"));
				department.setId(rs.getInt("id"));
				
				if("search".equals(type)) {
					this.s_departjcb.addItem(department);
				}else if("modify".equals(type)) {
					
				}
			}while(rs1.next()) {
				post = new Post();
				post.setPost_name(rs1.getString("post_name"));
				post.setId(rs1.getInt("id"));
				
				if("search".equals(type)) {
					this.s_postjcb.addItem(post);
				}else if("modify".equals(type)) {
					
				}
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}	
		}
	}
	
	/*
	 * 
	 * 初始化表格
	 */
	@SuppressWarnings("unchecked")
	private void fillTable(Staff staff) {
		DefaultTableModel dtm=(DefaultTableModel)stafftable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=staffDao.list(con, staff);
			while(rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("staff_name"));
				v.add(rs.getString("staff_id"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("nation"));
				v.add(rs.getString("native_place"));
				v.add(rs.getString("politics_status"));
				v.add(rs.getString("idNum"));
				v.add(rs.getString("depart_name"));
				v.add(rs.getString("phoneNum"));
				v.add(rs.getString("post_name"));
				v.add(rs.getString("address"));
				
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
}
