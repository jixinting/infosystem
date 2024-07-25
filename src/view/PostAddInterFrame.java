package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;

import Util.DbUtil;
import Util.StringUtil;
import dao.PostDao;
import model.Department;
import model.Post;
import java.awt.Color;

public class PostAddInterFrame extends JFrame {
	private JTextField post_nameTxt;
	private JTextArea post_descTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private PostDao postDao=new PostDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostAddInterFrame frame = new PostAddInterFrame();
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
	public PostAddInterFrame() {
		getContentPane().setBackground(new Color(227, 244, 255));
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setTitle("岗位添加");
		setBounds(100, 100, 698, 434);
		
		JLabel lblNewLabel = new JLabel("岗位名称");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		post_nameTxt = new JTextField();
		post_nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		post_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("岗位描述");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		post_descTxt = new JTextArea();
		post_descTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postAddActionPerformed(e);
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
							.addComponent(post_nameTxt, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1))
								.addComponent(post_descTxt))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(post_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(post_descTxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocationRelativeTo(null);
	}
	
	/*
	 * 岗位添加
	 */
	private void postAddActionPerformed(ActionEvent e) {
		String post_name=this.post_nameTxt.getText();
		String post_desc=this.post_descTxt.getText();
		
		if(StringUtil.isEmpty(post_name)) {
			JOptionPane.showMessageDialog(null, "岗位名称不能为空！");
			return;
		}if(StringUtil.isEmpty(post_desc)) {
			JOptionPane.showMessageDialog(null, "岗位描述不能为空！");
			return;
		}
		
		Post post=new Post(post_name, post_desc);
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addnum=postDao.add(con, post);
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
		this.post_nameTxt.setText("");
		this.post_descTxt.setText("");
	}
}
