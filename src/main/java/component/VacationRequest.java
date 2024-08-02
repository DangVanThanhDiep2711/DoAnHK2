package component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.LeaveRequestDao;
import dao.LeaveTypeDao;
import entity.Employees;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VacationRequest extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel buttonPane;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable table;
	private Employees user;
	/**
	 * Create the panel.
	 */
	public VacationRequest(Employees emp) {
		user = emp;
		setLayout(new BorderLayout(0, 0));
		
		buttonPane = new JPanel();
		add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		addButton = new JButton("add Request");
		addButton.setMnemonic('A');
		buttonPane.add(addButton);
		
		editButton = new JButton("edit Request");
		editButton.setMnemonic('e');
		buttonPane.add(editButton);
		
		deleteButton = new JButton("delete Request");
		deleteButton.setMnemonic('d');
		buttonPane.add(deleteButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPane.add(textField);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		showleaveRequest();
	}
	
	public void showleaveRequest() {
		var model = new DefaultTableModel();
		var daoLR = new LeaveRequestDao();
		var daoLT = new LeaveTypeDao();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		
//		tạo cột
		model.addColumn("FullName");
		model.addColumn("LeaveType");
		model.addColumn("StartDate");
		model.addColumn("EndDate");
		model.addColumn("Reason");
		model.addColumn("ApprovalStatus");
		model.addColumn("SubmissionDate");
		
//		add hang vao	
	
		daoLR.getLeaveRequests(user.getEmployeeID())
		.stream()
		.forEach(
			lr -> {
				model.addRow(new Object[] {
					user.getEmployeeName(),
					daoLT.selectLeaveType(lr.getLeaveRequestId()).getLeaveTypeName(),
					lr.getStartDate(),lr.getEndDate(),
					lr.getReason(),lr.getStatusLR()
					,lr.getSubmissionDate()
					});
					});
//		});
		table.setModel(model);
	}

}
