package component;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.EmployeeDao;
import dao.LeaveHRDao;
import dao.LeaveTypeDao;
import entity.Employees;

public class Processed extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panelSearch;
	private JPanel panelButton;
	private JTextField textField;
	private JComboBox comboBox;
	private Employees employee = null;
	private Employees user = null;
	 private Integer pageNumber = 1; //Trang thu may
		private Integer rowOfPage = 10; // So dong mac dinh trong trang
		private Integer totalRow = 0; // so dong trong database
		private Double totalPage = 1.0; // Tong so trang
		private Pagination pagination;

	/**
	 * Create the panel.
	 */
	public Processed(Employees emp) {
		user = emp;
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panelSearch = new JPanel();
		add(panelSearch, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Approved", "Rejeck"}));
		GroupLayout gl_panelSearch = new GroupLayout(panelSearch);
		gl_panelSearch.setHorizontalGroup(
			gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSearch.createSequentialGroup()
					.addContainerGap(538, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelSearch.setVerticalGroup(
			gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSearch.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelSearch.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelSearch.setLayout(gl_panelSearch);
		
		panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		
		pagination = new Pagination();
		GroupLayout gl_panelButton = new GroupLayout(panelButton);
		gl_panelButton.setHorizontalGroup(
			gl_panelButton.createParallelGroup(Alignment.LEADING)
				.addComponent(pagination, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
		);
		gl_panelButton.setVerticalGroup(
			gl_panelButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(pagination, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		pagination.addFirstButtonListener(new ActionListener() {
            @Override
	        public void actionPerformed(ActionEvent e) {
	                // Xử lý sự kiện cho nút "First"
	                var num = pagination.setPagination(e,pageNumber, totalPage);
	           	 	loadData(num);
	           	 pageNumber = num;	
	            }
	        });
	
	    pagination.addPreviousButtonListener(new ActionListener() {
            @Override
	        public void actionPerformed(ActionEvent e) {
	                // Xử lý sự kiện cho nút "Previous"
	            	var num = pagination.setPagination(e,pageNumber, totalPage);
	            	loadData(num);
	            	pageNumber = num;
	            }
	        });
	
	    pagination.addNextButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện cho nút "Next"
            	var num = pagination.setPagination(e,pageNumber ,totalPage);
	           	loadData(num);
	           	pageNumber = num;
              
	            }
	        });
	        
	    pagination.addLastButtonListener(new ActionListener() {
	        	// Xử lý sự kiện cho nút "Last"
				@Override
				public void actionPerformed(ActionEvent e) {
					var num = pagination.setPagination(e,pageNumber ,totalPage);
		           	loadData(num);
		           	pageNumber = num;	
				}
		});
	    
	    pagination.addSearchListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				String str = pagination.getStrSearch();
				searchTable(pagination.getStrSearch());
			}
		});
		
		
		panelButton.setLayout(gl_panelButton);
		
		
		
		
		 showHistoryRequest();
	}
	
	
	public void showHistoryRequest() {
        var model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };

        model.addColumn("LeaveRequestID");
        model.addColumn("EmployeeName");
        model.addColumn("LeaveType");
        model.addColumn("StartDate");
        model.addColumn("EndDate");
        model.addColumn("Reason");
        model.addColumn("SubmissionDate");
        model.addColumn("ApproverDate");
        model.addColumn("Status");
        
        var daoLH = new LeaveHRDao();
        var daoEmp = new EmployeeDao();
        var daoLT = new LeaveTypeDao();
        
        totalRow = daoLH.countLHForLeader(user.getEmployeeID()); // lay tong so dong
        totalPage = Math.ceil(totalRow.doubleValue() / rowOfPage.doubleValue()); // tinh so trang
		daoLH.selLHistoryForLeader(1,rowOfPage, user.getEmployeeID()).stream().forEach(lr -> {
			employee = daoEmp.getEmp(lr.getEmployeeId());
            model.addRow(new Object[]{
                    lr.getLeaveRequestId(), employee.getEmployeeName(),
                    daoLT.selectLeaveType(lr.getLeaveRequestId()).getLeaveTypeName(),
                    lr.getStartDate(),
                    lr.getEndDate(), lr.getReason(),
                    lr.getSubmissionDate(),lr.getApprovalDate(),lr.getStatusLR()
            });
        });
		table.setRowSorter( new TableRowSorter<>(model));

        table.setModel(model);
        table.getColumn("LeaveRequestID").setMinWidth(0);
		table.getColumn("LeaveRequestID").setMaxWidth(0);
		table.getColumn("LeaveRequestID").setWidth(0);
    }
	
    public void loadData(Integer pageNumber) {
    	JOptionPane.showMessageDialog(null, pageNumber);
		// TODO Auto-generated method stub
		var model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // xoa het du lieu con ben trong
		
		var daoLT = new LeaveTypeDao();
		var dao = new LeaveHRDao();
		totalRow = dao.countLHForLeader(user.getEmployeeID()); // lay tong so dong
		totalPage = Math.ceil(totalRow.doubleValue() / rowOfPage.doubleValue()); // tinh so trang
		

		String lblStaPage = " page " + pageNumber + " of " + totalPage.intValue();
		var daoEmp = new EmployeeDao();
		dao.selLHistoryForLeader(pageNumber,rowOfPage, user.getEmployeeID()).stream().forEach(lr -> {
			employee = daoEmp.getEmp(lr.getEmployeeId());

            model.addRow(new Object[]{
            		lr.getLeaveRequestId(), employee.getEmployeeName(),
            		daoLT.selectLeaveType(lr.getLeaveRequestId()).getLeaveTypeName(), lr.getStartDate(),
                    lr.getEndDate(), lr.getReason(),
                    lr.getSubmissionDate(),lr.getApprovalDate(),lr.getStatusLR()
            });
        });
		
		table.setModel(model);
		table.getColumn("LeaveRequestID").setMinWidth(0);
		table.getColumn("LeaveRequestID").setMaxWidth(0);
		table.getColumn("LeaveRequestID").setWidth(0);
	}
    
    public void searchTable(String str) {
		var sorter = (DefaultRowSorter<?,?>)table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(str));
		sorter.setSortKeys(null);
	}
}
