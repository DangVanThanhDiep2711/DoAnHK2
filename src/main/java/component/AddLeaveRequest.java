package component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import dao.DepartmentDao;
import entity.Employees;


public class AddLeaveRequest extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelForm;
	private JTextField txtEmployeeMail;
	private JPanel panel;
	private JLabel lblFullName;
	private JTextField txtfullName;
	private JLabel lblDepartment;
	private JComboBox cmbDepartment;
	private JTextField textField_1;
	private JComboBox cmbLeaveType;
	private JTextArea txtReason;
	private JDateChooser dateChooser;
	private JDateChooser startDateChooser;
	private JDateChooser endDateChooser;
	private JDateChooser startDateChooser_1;
	private JButton btnSave;
	private JButton btnCancel;
	private Component btnSubmit;
	private JPanel panelbutton;
	private JComboBox cmbApprover;
	private JButton btnChooseFile;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public AddLeaveRequest(Employees emp) {
		var dao = new DepartmentDao();
		setBounds(100, 100, 900, 500);
		setLayout(null);
		
		panelForm = new JPanel();
		panelForm.setBorder(BorderFactory.createTitledBorder("Đơn xin nghỉ phép"));
		panelForm.setBounds(0, 0, 900, 70);
		add(panelForm);
		
		lblNewLabel = new JLabel("creat leave");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelForm.add(lblNewLabel);
        
        panel = new JPanel();
        panel.setBounds(0, 71, 900, 380);
        add(panel);
        panel.setLayout(null);
        
        lblFullName = new JLabel("FullName :");
        lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblFullName.setBounds(60, 37, 107, 14);
        panel.add(lblFullName);
        
        txtfullName = new JTextField(emp.getEmployeeName());
        txtfullName.setBounds(60, 62, 200, 34);
        txtfullName.setColumns(10);
        panel.add(txtfullName);
        
        lblDepartment = new JLabel("Department :");
        lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDepartment.setBounds(60, 123, 107, 20);
        panel.add(lblDepartment);
        
        cmbDepartment = new JComboBox<>();
        var d = dao.selectDepartment(emp.getEmployeeID());
        cmbDepartment.addItem(d.getDepartmentName());
        cmbDepartment.setBounds(60, 154, 200, 34);
        panel.add(cmbDepartment);
        
        JLabel lblEmployeeId = new JLabel("Mã nhân viên:");
        lblEmployeeId.setBounds(60, 199, 120, 25);
        lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
        panel.add(lblEmployeeId);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(60, 234, 200, 34);
        panel.add(textField_1);
        
        JLabel lblApprover = new JLabel("Recipient of the application :");
        lblApprover.setBounds(60, 277, 174, 25);
        panel.add(lblApprover);

        cmbApprover = new JComboBox<>(new String[] {"HR", "PM"});
        cmbApprover.setBounds(60, 308, 200, 34);
        panel.add(cmbApprover);
        
        JLabel lblLeaveType = new JLabel("Types of Leave :");
        lblLeaveType.setBounds(387, 37, 120, 25);
        panel.add(lblLeaveType);
        
        cmbLeaveType = new JComboBox<>(new String[] {"Nghỉ phép cá nhân", "Nghỉ ốm", "Nghỉ lễ"});
        cmbLeaveType.setBounds(387, 62, 438, 34);
        panel.add(cmbLeaveType);

        JLabel lblReason = new JLabel("Lý do nghỉ:");
        lblReason.setBounds(387, 122, 120, 25);
        panel.add(lblReason);

        txtReason = new JTextArea();
        txtReason.setBounds(387, 154, 438, 95);
        txtReason.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(txtReason);
        
//        JLabel lblFile = new JLabel("File xin nghỉ phép:");
//        lblFile.setBounds(400, 70, 120, 25);
//        panelForm.add(lblFile);
//
//        txtFilePath = new JTextField();
//        txtFilePath.setBounds(530, 70, 200, 25);
//        panelForm.add(txtFilePath);
//        txtFilePath.setColumns(10);

        btnChooseFile = new JButton("");
        btnChooseFile.setBounds(725, 258, 100, 25);
        btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
        panel.add(btnChooseFile);

        JLabel lblStartDate = new JLabel("Ngày bắt đầu:");
        lblStartDate.setBounds(388, 277, 120, 25);
        panel.add(lblStartDate);

        startDateChooser = new JDateChooser();
        startDateChooser.setDate(new java.util.Date());
        startDateChooser.setDateFormatString("dd/MM/yyyy");
        startDateChooser.setBounds(388, 307, 198, 35);
        panel.add(startDateChooser);

        JLabel lblEndDate = new JLabel("Ngày kết thúc:");
        lblEndDate.setBounds(627, 277, 120, 25);
        panel.add(lblEndDate);
        
        endDateChooser = new JDateChooser();
        endDateChooser.setDate(new java.util.Date());
        endDateChooser.setDateFormatString("dd/MM/yyyy");
        endDateChooser.setBounds(627, 308, 198, 35);
        panel.add(endDateChooser);
        
      
        
        panelbutton = new JPanel();
        panelbutton.setBounds(0, 447, 900, 53);
        add(panelbutton);
        panelbutton.setLayout(null);
        btnSave = new JButton("Lưu hồ sơ");
        btnSave.setBounds(59, 5, 223, 37);
        panelbutton.add(btnSave);

        btnCancel = new JButton("Hủy hồ sơ");
        btnCancel.setBounds(316, 5, 223, 37);
        panelbutton.add(btnCancel);

        btnSubmit = new JButton("Chuyển phê duyệt");
        btnSubmit.setBounds(572, 5, 250, 37);
        panelbutton.add(btnSubmit);
        
       
        
        
	}
	
	
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new 	JFileChooser("");
		int result = fileChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION) {
	
					txtReason.setText(fileChooser.getSelectedFile().getAbsolutePath());
					;
		}
		
	}
}
