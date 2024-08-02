package component;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import java.awt.Font;
import java.awt.Image;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class ProfileEmployee extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panelImage;
	private JPanel panel_3;
	private JLabel lblImage;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private JPanel panelGender;
	private JRadioButton rbFemale;
	private JRadioButton rbMale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_7;
	private JPanel panelDepartment;
	private JComboBox cbDepartment;

	/**
	 * Create the panel.
	 */
	public ProfileEmployee() {
		setSize(900, 500);
		setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("thoat");
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panelImage = new JPanel();
		panel_1.add(panelImage, BorderLayout.WEST);
		
		 lblImage = new JLabel();
		 lblImage.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        lblImage.setHorizontalAlignment(JLabel.CENTER);
	        lblImage.setIcon(
	        		new ImageIcon("C:\\Users\\ngthi\\eclipse-workspace\\projectLeaveManagement\\image\\login1.png"));
	        lblImage.setPreferredSize(new Dimension(250, 200));
	        lblImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        btnNewButton_1 = new JButton("chọn ảnh");
	        
	        lblNewLabel_1 = new JLabel("Nguyễn Thị Linh Linh");
	        GroupLayout gl_panelImage = new GroupLayout(panelImage);
	        gl_panelImage.setHorizontalGroup(
	        	gl_panelImage.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelImage.createSequentialGroup()
	        			.addGroup(gl_panelImage.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_panelImage.createSequentialGroup()
	        					.addGap(24)
	        					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        				.addGroup(gl_panelImage.createSequentialGroup()
	        					.addGap(111)
	        					.addComponent(lblNewLabel_1))
	        				.addGroup(gl_panelImage.createSequentialGroup()
	        					.addGap(105)
	        					.addComponent(btnNewButton_1)))
	        			.addContainerGap(38, Short.MAX_VALUE))
	        );
	        gl_panelImage.setVerticalGroup(
	        	gl_panelImage.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelImage.createSequentialGroup()
	        			.addGap(49)
	        			.addComponent(lblNewLabel_1)
	        			.addGap(18)
	        			.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
	        			.addGap(18)
	        			.addComponent(btnNewButton_1)
	        			.addContainerGap(41, Short.MAX_VALUE))
	        );
	        panelImage.setLayout(gl_panelImage);
	        
	       
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(7, 2, 5, 5));
		
		lblNewLabel_2 = new JLabel("Mã Nhân VIên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Tên Nhân Viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		
		lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_3.add(textField_2);
		
		lblNewLabel_5 = new JLabel("Ngày Sinh");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_3.add(textField_3);
		
		lblNewLabel_6 = new JLabel("Giới Tính");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_6);
		
		panelGender = new JPanel();
		panel_3.add(panelGender);
		
		rbMale = new JRadioButton("NAM");
		buttonGroup.add(rbMale);
		panelGender.add(rbMale);
		
		rbFemale = new JRadioButton("NU");
		buttonGroup.add(rbFemale);
		rbFemale.setSelected(true);
		panelGender.add(rbFemale);
		
		lblNewLabel_7 = new JLabel("Phòng Ban");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblNewLabel_7);
		
		panelDepartment = new JPanel();
		panel_3.add(panelDepartment);
		
		cbDepartment = new JComboBox<>(new String[]{"GIAM DOC", "NHAN VIEN", "KE TOAN"});
        panelDepartment.add(cbDepartment);

	}
}
