package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import dao.PostDao;
import dao.staffDao;
import model.Department;
import model.Post;
import model.Staff;
import model.User;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class MyInfoInterFrame extends JFrame {
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
	
	private JRadioButton manjrb;
	private JRadioButton femalejrb;
	private JTextArea addressTxt;
	private JButton btnNewButton_1;

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
					MyInfoInterFrame frame = new MyInfoInterFrame();
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
	public MyInfoInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
		setBackground(new Color(227, 244, 255));
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
		manjrb.setBackground(new Color(227, 244, 255));
		manjrb.setSelected(true);
		buttonGroup.add(manjrb);
		manjrb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		femalejrb = new JRadioButton("女");
		femalejrb.setBackground(new Color(227, 244, 255));
		buttonGroup.add(femalejrb);
		femalejrb.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
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
		
		JButton btnNewButton = new JButton("编辑资料");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetEdit();
			
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		btnNewButton_1 = new JButton("保存");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetUnEdit();
				SetInfo();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(staff_idTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(nationTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addGap(18)
									.addComponent(nativeTxt))))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 242, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton)
								.addGap(18)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
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
									.addComponent(idNumTxt, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))))
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
							.addComponent(staff_idTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(nativeTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(29)
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
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1))
					.addGap(117))
		);
		getContentPane().setLayout(groupLayout);

		this.setLocationRelativeTo(null);
	}
	

	void init(String staff_id)
	{
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			Staff currentStaff=staffDao.query(con, staff_id);
			if(currentStaff!=null) {
				this.staff_name=currentStaff.getStaff_name();
				this.staff_id=currentStaff.getStaff_id();
				this.sex=currentStaff.getSex();
				this.nation=currentStaff.getNation();
				this.native_place=currentStaff.getPolitics_status();
				this.politics_status=currentStaff.getPolitics_status();
				this.idNum=currentStaff.getIdNum();
				this.address=currentStaff.getAddress();
				this.phoneNum=currentStaff.getPhoneNum();
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	void SetInfo() {
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			Staff currentStaff=new Staff();
			currentStaff.setStaff_name(staff_nameTxt.getText());
			currentStaff.setStaff_id(staff_idTxt.getText());
			currentStaff.setNation(nationTxt.getText());
			currentStaff.setPolitics_status(politicsTxt.getText());
			currentStaff.setNative_place(nativeTxt.getText());
			currentStaff.setIdNum(idNumTxt.getText());
			currentStaff.setPhoneNum(phoneNumTxt.getText());
			currentStaff.setAddress(addressTxt.getText());
			
			int flag = staffDao.change(con, currentStaff);
			if(flag==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
			}
			else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	void Data() {
		staff_nameTxt.setText(this.staff_name);
		staff_idTxt.setText(this.staff_id);
		nationTxt.setText(this.nation);
		politicsTxt.setText(this.politics_status);
		nativeTxt.setText(this.native_place);
		idNumTxt.setText(this.idNum);
		phoneNumTxt.setText(this.phoneNum);
		addressTxt.setText(this.address);
	}
	
	void SetEdit() {
		staff_nameTxt.setEditable(true);
//		staff_idTxt.setEditable(true);
		nationTxt.setEditable(true);
		politicsTxt.setEditable(true);
		nativeTxt.setEditable(true);
		idNumTxt.setEditable(true);
		phoneNumTxt.setEditable(true);
		addressTxt.setEditable(true);
	}
	
	
	void SetUnEdit() {
		staff_nameTxt.setEditable(false);
		staff_idTxt.setEditable(false);
		nationTxt.setEditable(false);
		politicsTxt.setEditable(false);
		nativeTxt.setEditable(false);
		idNumTxt.setEditable(false);
		phoneNumTxt.setEditable(false);
		addressTxt.setEditable(false);
	}
}
