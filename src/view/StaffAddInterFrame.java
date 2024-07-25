package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import dao.PostDao;
import dao.staffDao;
import model.Department;
import model.Post;
import model.Staff;
import java.awt.Color;

public class StaffAddInterFrame extends JFrame {
	private JTextField staff_nameTxt;
	private JTextField staff_idTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nationTxt;
	private JTextField politicsTxt;
	private JTextField nativeTxt;
	private JTextField idNumTxt;
	private JTextField phoneNumTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private DepartmentDao departmentDao=new DepartmentDao();
	private PostDao postDao = new PostDao();
	private staffDao staffDao=new staffDao();
	private JComboBox departJCB; 
	private JComboBox postJCB;
	
	private JRadioButton manjrb;
	private JRadioButton femalejrb;
	private JTextArea addressTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffAddInterFrame frame = new StaffAddInterFrame();
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
	public StaffAddInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
		setTitle("基本信息录入");
		setBounds(100, 100, 626, 710);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		staff_nameTxt = new JTextField();
		staff_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		staff_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("工号");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		staff_idTxt = new JTextField();
		staff_idTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		staff_idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("性别");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		manjrb = new JRadioButton("男");
		manjrb.setSelected(true);
		buttonGroup.add(manjrb);
		manjrb.setFont(new Font("宋体", Font.PLAIN, 20));
		
		femalejrb = new JRadioButton("女");
		buttonGroup.add(femalejrb);
		femalejrb.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("民族");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		nationTxt = new JTextField();
		nationTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		nationTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("政治面貌");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		politicsTxt = new JTextField();
		politicsTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		politicsTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("籍贯");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		nativeTxt = new JTextField();
		nativeTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		nativeTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("部门");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		departJCB = new JComboBox();
		departJCB.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		JLabel lblNewLabel_7 = new JLabel("岗位");
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		postJCB = new JComboBox();
		postJCB.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		JLabel lblNewLabel_8 = new JLabel("身份证号");
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		idNumTxt = new JTextField();
		idNumTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idNumTxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("电话号码");
		lblNewLabel_9.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		phoneNumTxt = new JTextField();
		phoneNumTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		phoneNumTxt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("地址");
		lblNewLabel_10.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		addressTxt = new JTextArea();
		addressTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffAddActionPerformed(e);
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_10)
									.addGap(18)
									.addComponent(addressTxt, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_9)
									.addGap(18)
									.addComponent(phoneNumTxt, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addGap(18)
									.addComponent(idNumTxt, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_6)
											.addGap(41)
											.addComponent(departJCB, 0, 122, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_4)
											.addGap(18)
											.addComponent(politicsTxt, 105, 105, 105))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addGap(18)
											.addComponent(staff_nameTxt, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addGap(18)
											.addComponent(manjrb)
											.addGap(18)
											.addComponent(femalejrb)))
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addGap(18)
											.addComponent(staff_idTxt))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addGap(18)
											.addComponent(nationTxt))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_7)
												.addComponent(lblNewLabel_5))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(nativeTxt)
												.addComponent(postJCB, 0, 182, Short.MAX_VALUE))))))))
					.addGap(107))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(staff_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)
							.addComponent(staff_idTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(manjrb)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(femalejrb)
							.addComponent(lblNewLabel_3)
							.addComponent(nationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(politicsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5)
							.addComponent(nativeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(departJCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7)
						.addComponent(postJCB, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_8)
						.addComponent(idNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(phoneNumTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel_10))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		this.fillJCB();
		this.setLocationRelativeTo(null);
	}
	
	private void staffAddActionPerformed(ActionEvent e) {
		String staff_name=this.staff_nameTxt.getText();
		String staff_id=this.staff_idTxt.getText();
		String nation=this.nationTxt.getText();
		String native_place=this.politicsTxt.getText();
		String politics_status=this.nativeTxt.getText();
		String idNum=this.idNumTxt.getText();
		String address=this.addressTxt.getText();
		String phoneNum=this.phoneNumTxt.getText();
		
		if(StringUtil.isEmpty(staff_name)) {
			JOptionPane.showMessageDialog(null, "员工姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(staff_id)) {
			JOptionPane.showMessageDialog(null, "员工工号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(nation)) {
			JOptionPane.showMessageDialog(null, "民族不能为空！");
			return;
		}
		if(StringUtil.isEmpty(native_place)) {
			JOptionPane.showMessageDialog(null, "籍贯不能为空！");
			return;
		}
		if(StringUtil.isEmpty(politics_status)) {
			JOptionPane.showMessageDialog(null, "政治面貌不能为空！");
			return;
		}
		if(StringUtil.isEmpty(idNum)) {
			JOptionPane.showMessageDialog(null, "身份证号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(address)) {
			JOptionPane.showMessageDialog(null, "地址不能为空！");
			return;
		}
		if(StringUtil.isEmpty(phoneNum)) {
			JOptionPane.showMessageDialog(null, "电话号码不能为空！");
			return;
		}
		
		String sex="";
		if(this.manjrb.isSelected()) {
			sex="男";
		}else if(this.femalejrb.isSelected()) {
			sex="女";
		}
		
		Department department = (Department) this.departJCB.getSelectedItem();
		int departid = department.getId();
		
		Post post=(Post) this.postJCB.getSelectedItem();
		int postid=post.getId();
		
		Staff staff=new Staff(staff_name, staff_id, sex, nation, native_place,
				politics_status, idNum, address, departid, postid, phoneNum);
		
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			int addnum=staffDao.add(con, staff);
			if(addnum==1) {
				JOptionPane.showMessageDialog(null, "员工基本信息添加成功！");
				resetValues();
			}else {
				JOptionPane.showMessageDialog(null, "员工基本信息添加失败！");
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
		this.staff_nameTxt.setText("");
		this.staff_idTxt.setText("");
		this.manjrb.setSelected(true);
		this.nationTxt.setText("");
		this.politicsTxt.setText("");
		this.nativeTxt.setText("");
		this.idNumTxt.setText("");
		this.addressTxt.setText("");
		this.phoneNumTxt.setText("");
		if(this.departJCB.getItemCount()>0) {
			this.departJCB.setSelectedIndex(0);
		}if(this.postJCB.getItemCount()>0) {
			this.postJCB.setSelectedIndex(0);
		}
	}

	/*
	 * 初始化下拉框
	 */
	@SuppressWarnings("unchecked")
	private void fillJCB() {
		Connection con=null;
		Department department=null;
		Post post=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=departmentDao.list(con, new Department());
			ResultSet rs1=postDao.list(con, new Post());
			
			while(rs.next()) {
				department=new Department();
				department.setId(rs.getInt("id"));
				department.setDepart_name(rs.getString("depart_name"));
				this.departJCB.addItem(department);
			}
			while(rs1.next()) {
				post=new Post();
				post.setId(rs1.getInt("id"));
				post.setPost_name(rs1.getString("post_name"));
				this.postJCB.addItem(post);
 			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
